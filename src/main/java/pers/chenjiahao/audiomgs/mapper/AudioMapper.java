package pers.chenjiahao.audiomgs.mapper;

import pers.chenjiahao.audiomgs.entity.Audio;

import java.util.List;

public interface AudioMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Audio record);

    int insertSelective(Audio record);

    Audio selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Audio record);

    int updateByPrimaryKey(Audio record);

    List<Audio> selectAll();

    Audio selectByAudioName(String audioName);
}