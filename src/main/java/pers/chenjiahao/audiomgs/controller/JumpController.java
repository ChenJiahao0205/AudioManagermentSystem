package pers.chenjiahao.audiomgs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pers.chenjiahao.audiomgs.entity.Audio;
import pers.chenjiahao.audiomgs.entity.Lease;
import pers.chenjiahao.audiomgs.entity.User;
import pers.chenjiahao.audiomgs.service.AudioService;
import pers.chenjiahao.audiomgs.service.LeaseService;
import pers.chenjiahao.audiomgs.service.UserService;
import pers.chenjiahao.audiomgs.utils.GetSessionUtil;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class JumpController {
    @Resource
    private AudioService audioService;

    @Resource
    private LeaseService leaseService;

    @Resource
    private UserService userService;

    @RequestMapping("/jump/toRecharge")
    public String toRecharge(){
        return "recharge";
    }

    @RequestMapping("/jump/toUpdatePwd")
    public String toUpdatePwd(){
        return "updatePwd";
    }

    @RequestMapping("/jump/toAddAudio")
    public String toAddAudio(){
        return "addAudio";
    }

    @RequestMapping("/jump/toManagerAudio")
    public String toManagerAudio(Model model){
        List<Audio> audios = audioService.selectAll();
        model.addAttribute("audios",audios);
        return "managerAudio";
    }

    @RequestMapping("/jump/toUpdateAudio")
    public String toUpdateAudio(Audio audio,Model model){
        model.addAttribute("audio",audio);
        return "updateAudio";
    }


    @RequestMapping("/jump/toManagerLease")
    public String toManagerLease(Model model){
        List<Lease> leases = leaseService.selectAll();
        model.addAttribute("leases",leases);
        return "managerLease";
    }

    @RequestMapping("/jump/toManagerUser")
    public String toManagerUser(Model model){
        List<User> users = userService.selectAllUser();
        model.addAttribute("users",users);
        return "managerUser";
    }

    @RequestMapping("/jump/toUpdateUserInfo")
    public String toUpdateUserInfo(Model model){
        User user1 = (User) GetSessionUtil.getSession().getAttribute("user");
        User user = userService.selectUserById(user1.getId());
        model.addAttribute("user",user);
        return "updateUserInfo";
    }

    @RequestMapping("/jump/toUserSelectLease")
    public String toUserSelectLease(Model model){
        User user = (User) GetSessionUtil.getSession().getAttribute("user");
        List<Lease> leases = leaseService.selectByUsername(user.getUsername());
        model.addAttribute("leases",leases);
        return "userSelectLease";
    }

}
