package pers.chenjiahao.audiomgs.service;

import pers.chenjiahao.audiomgs.entity.Audio;

import java.util.List;

public interface AudioService {

    int updateAudioInfo(Audio audio);

    Audio selectById(Long audioId);

    String insert(Audio audio);

    String delete(Long id);

    List<Audio> selectAll();

    String changeAudioInfo(Audio audio);

    Audio selectByAudioName(String audioName);
}
