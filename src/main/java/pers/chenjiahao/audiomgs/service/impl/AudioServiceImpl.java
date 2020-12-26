package pers.chenjiahao.audiomgs.service.impl;

import org.springframework.stereotype.Service;
import pers.chenjiahao.audiomgs.entity.Audio;
import pers.chenjiahao.audiomgs.mapper.AudioMapper;
import pers.chenjiahao.audiomgs.service.AudioService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AudioServiceImpl implements AudioService {
    @Resource
    private AudioMapper audioMapper;

    @Override
    public int updateAudioInfo(Audio audio) {
        return audioMapper.updateByPrimaryKey(audio);
    }

    @Override
    public Audio selectById(Long audioId) {
        return audioMapper.selectByPrimaryKey(audioId);
    }

    @Override
    public String insert(Audio audio) {
        return audioMapper.insert(audio) > 0 ? "添加成功" : "添加失败";
    }

    @Override
    public String delete(Long id) {
        return audioMapper.deleteByPrimaryKey(id) > 0 ? "删除成功" : "删除失败";
    }

    @Override
    public List<Audio> selectAll() {
        return audioMapper.selectAll();
    }

    @Override
    public String changeAudioInfo(Audio audio) {
        return audioMapper.updateByPrimaryKey(audio) > 0 ? "修改成功" : "修改失败";
    }

    @Override
    public Audio selectByAudioName(String audioName) {
        return audioMapper.selectByAudioName(audioName);
    }
}
