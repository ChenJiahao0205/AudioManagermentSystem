package pers.chenjiahao.audiomgs.mapper;

import pers.chenjiahao.audiomgs.entity.Lease;

import java.util.List;

public interface LeaseMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Lease record);

    int insertSelective(Lease record);

    Lease selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Lease record);

    int updateByPrimaryKey(Lease record);

    List<Lease> selectAll();

    List<Lease> selectByUsername(String username);
}