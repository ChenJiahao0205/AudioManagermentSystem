package pers.chenjiahao.audiomgs.service;

import pers.chenjiahao.audiomgs.entity.User;

import java.util.List;

public interface UserService {
    /**
     * 用户注册
     * @param user 用户的注册信息
     * @return
     */
    String userRegistry(User user);

    /**
     * 用户登录
     * @param username 前端传来的用户名
     * @param password 前端传来的密码
     * @return
     */
    String userLogin(String username, String password);

    /**
     * 用户修改密码
     */
    String updatePassword(User user);

    /**
     * 查询所有用户信息（店主）
     * @return
     */
    List<User> selectAllUser();

    String updateInfo(User user);

    String userRecharge(Long id, Double updateBalance);

    String updateReturnDeposit(User user);

    User selectUserById(Long id);
}
