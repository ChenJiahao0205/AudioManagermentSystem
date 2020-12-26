package pers.chenjiahao.audiomgs.service.impl;

import org.springframework.stereotype.Service;
import pers.chenjiahao.audiomgs.entity.User;
import pers.chenjiahao.audiomgs.mapper.UserMapper;
import pers.chenjiahao.audiomgs.service.UserService;
import pers.chenjiahao.audiomgs.utils.GetSessionUtil;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public String userRegistry(User user) {
        return userMapper.insert(user) > 0 ? "注册成功" : "注册失败";
    }

    @Override
    public String userLogin(String username, String password) {
        User user = userMapper.selectByUsername(username);
        if (user != null && user.getPassword().equals(password)){
            GetSessionUtil.getSession().setAttribute("user",user);
            return "登录成功";
        }
        return "用户名或密码错误";
    }


    @Override
    public String updatePassword(User user) {
        return userMapper.updateByPrimaryKeySelective(user) > 0 ? "修改成功" : "修改失败";
    }
    @Override
    public List<User> selectAllUser() {
        return userMapper.selectAllUser();
    }

    @Override
    public String updateInfo(User user) {
        String retValue = userMapper.updateByPrimaryKeySelective(user) > 0 ? "修改成功" : "修改失败";
        // 更新session
        GetSessionUtil.getSession().setAttribute("user",userMapper.selectByPrimaryKey(user.getId()));
        return retValue;
    }

    @Override
    public String userRecharge(Long id, Double updateBalance) {
        User user = new User();
        user.setId(id);
        user.setBalance(updateBalance);
        return userMapper.updateByPrimaryKeySelective(user) > 0 ? "充值成功" : "充值失败";
    }

    @Override
    public String updateReturnDeposit(User user) {
        return userMapper.updateByPrimaryKey(user) > 0 ? "退还成功" : "退还失败";
    }

    @Override
    public User selectUserById(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
