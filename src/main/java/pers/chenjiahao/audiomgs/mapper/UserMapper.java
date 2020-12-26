package pers.chenjiahao.audiomgs.mapper;

import pers.chenjiahao.audiomgs.entity.User;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User selectByUsername(String username);

    int updateByUsername(String username, String newPassword);

    List<User> selectAllUser();
}