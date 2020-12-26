package pers.chenjiahao.audiomgs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pers.chenjiahao.audiomgs.algorithm.CalculateLeaseRent;
import pers.chenjiahao.audiomgs.algorithm.CalculateLeaseTime;
import pers.chenjiahao.audiomgs.entity.Audio;
import pers.chenjiahao.audiomgs.entity.Lease;
import pers.chenjiahao.audiomgs.entity.User;
import pers.chenjiahao.audiomgs.service.AudioService;
import pers.chenjiahao.audiomgs.service.LeaseService;
import pers.chenjiahao.audiomgs.service.UserService;
import pers.chenjiahao.audiomgs.utils.GetSessionUtil;
import pers.chenjiahao.audiomgs.utils.HtmlPageUtil;
import pers.chenjiahao.audiomgs.utils.TwoDecimalPlacesUtil;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Controller
public class UserController {

    @Resource
    private UserService userService;

    @Resource
    private AudioService audioService;

    @Resource
    private LeaseService leaseService;

    String retValue;

    /**
     * 用户注册
     * @param user 从前端接收的用户注册信息
     * @return
     */
    @RequestMapping("/user/registry")
    public String registry(User user,Model model){
        // 初始化余额
        user.setBalance(0.00);
        // 默认身份为0 0可以表示普通用户
        user.setIdentity("0");
        String message = userService.userRegistry(user);
        model.addAttribute("registryMessage",message);
        // HtmlAlertUtil.alert(message);
        return "login";
    }

    /**
     * 用户登录
     * @param username 前端传来的用户名
     * @param password 前端传来的密码
     * @return
     */
    @RequestMapping("/user/login")
    public String login(Model model,String username, String password){
        String retValue = userService.userLogin(username,password);
        model.addAttribute("loginMessage",retValue);
        if ("用户名或密码错误".equals(retValue)){
            model.addAttribute("registryMessage",retValue);
            return "login";
        }
        List<Audio> audios = audioService.selectAll();
        model.addAttribute("audios",audios);
        return "index";
    }

    /**
     * 用户退出登录
     * @return
     */
    @RequestMapping("/user/logout")
    public String logout(){
        // 移除session
        GetSessionUtil.getSession().removeAttribute("user");
        // 返回到登录页
        return "login";
    }


    /**
     * 用户修改密码
     * @param newPassword 新密码
     * @return
     */
    @RequestMapping("/user/updatePassword")
    public String updatePassword(String newPassword){
        User user = (User) GetSessionUtil.getSession().getAttribute("user");
        User user1 = new User();
        user1.setId(user.getId());
        user1.setPassword(newPassword);
        retValue = userService.updatePassword(user1);
        if ("修改失败".equals(retValue)){
            HtmlPageUtil.alert(retValue);
        }
        return "redirect:/jump/toUpdatePwd";
    }

    /**
     * 查询用户信息（店主）
     * 弃用
     *      * @return
     */
    @RequestMapping("/user/select")
    public String select(Model model){
        List<User> users = userService.selectAllUser();
        model.addAttribute("users",users);
        return "allUserInfo";
    }

    /**
     * 用户修改个人信息
     * @return
     */
    @RequestMapping("/user/updateInfo")
    public String updateInfo(User user){
        retValue = userService.updateInfo(user);
        if ("修改失败".equals(retValue)){
            HtmlPageUtil.alert(retValue);
        }
        return "redirect:/jump/toUpdateUserInfo";
    }

    /**
     * 用户租借 需要加事务
     * @return
     */
    @Transactional
    @RequestMapping("/user/lease")
    public String lease(Audio audio,Model model){
        // 从session中拿到当前用户
        User user1 = (User) GetSessionUtil.getSession().getAttribute("user");
        // 去数据库中查询最新的用户信息
        User user = userService.selectUserById(user1.getId());
        double deposit = audio.getDeposit();
        // 校验余额是否足够
        if (user.getBalance() - deposit < 0){
            HtmlPageUtil.alert("余额不足，租借失败");
        }else if(audio.getInventory() <= 0){
            HtmlPageUtil.alert("库存不足，租借失败");
        }else {
            // 修改用户余额
            user.setBalance(user.getBalance() - deposit);
            userService.updateInfo(user);
            // 添加租借信息
            Lease lease = new Lease(user.getUsername(),user.getRealName(),audio.getId(),audio.getAudioName(),audio.getDeposit(),new Date(),"租借中");
            int retValue = leaseService.addLeaseInfo(lease);
            // 减少库存
            audio.setInventory(audio.getInventory() - 1);
            int retValue2 = audioService.updateAudioInfo(audio);
            /*HtmlPageUtil.alert("租借成功");*/
        }
        return "redirect:/audio/select";
    }

    /**
     * 用户租还 需要加事务
     * @return
     */
    @Transactional
    @RequestMapping("/user/returnAudio")
    public String returnAudio(Long id){
        Lease lease = leaseService.selectById(id);
        // 从session中拿到当前用户
        User user1 = (User) GetSessionUtil.getSession().getAttribute("user");
        // 拿到最新的用户信息
        User user = userService.selectUserById(user1.getId());
        // 当前日期(也就是退还日期)
        Date endRentDate = new Date();
        // 总租借天数(小时/24得)
        double totalLeaseTime = CalculateLeaseTime.calculateTime(lease.getStartRentDate(),endRentDate);
        // 租金
        double rent = CalculateLeaseRent.calculateRent(lease.getDeposit(),totalLeaseTime);
        // 需要退回的押金
        double returnRent = TwoDecimalPlacesUtil.twoDecimalPlace(lease.getDeposit() - rent);
        // 更新订单中的信息
        lease.setRent(rent);
        lease.setReturnRent(returnRent);
        lease.setEndRentDate(endRentDate);
        lease.setLeaseStatus("已归还");
        // 更新租借表
        String leaseRetValue = leaseService.updateLeaseInfo(lease);
        // 退还用户剩余押金
        user.setBalance(user.getBalance() + returnRent);
        // 更新用户余额
        String retValue = userService.updateReturnDeposit(user);
        // 查询该id的音响
        Audio audio = audioService.selectById(lease.getAudioId());
        // 库存+1
        audio.setInventory(audio.getInventory() + 1);
        if (audioService.updateAudioInfo(audio) <= 0){
            HtmlPageUtil.alert("租还失败");
        }
        return "redirect:/jump/toUserSelectLease";
    }

    /**
     * 用户充值
     * @return
     */
    @Transactional
    @RequestMapping("/user/recharge")
    public String recharge(String recharge){
        User user = (User) GetSessionUtil.getSession().getAttribute("user");
        Long id = user.getId();
        // 重新查询余额
        User user1 = userService.selectUserById(id);
        double balance = user1.getBalance();
        Double updateBalance = Double.parseDouble(recharge) + balance;
        retValue = userService.userRecharge(id,updateBalance);
        if ("充值失败".equals(retValue)){
            HtmlPageUtil.alert(retValue);
        }
        return "redirect:/jump/toRecharge";
    }

    /**
     * 跳转到登录界面
     * @return
     */
    @RequestMapping("/user/toLogin")
    public String toLogin(){
        return "login";
    }
}
