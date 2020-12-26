package pers.chenjiahao.audiomgs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pers.chenjiahao.audiomgs.entity.Audio;
import pers.chenjiahao.audiomgs.service.AudioService;
import pers.chenjiahao.audiomgs.utils.HtmlPageUtil;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class AudioController {
    String retValue;

    @Resource
    private AudioService audioService;

    /**
     * 添加音响
     * @return
     */
    @RequestMapping("/audio/add")
    public String add(Audio audio){
        Audio audio1 = audioService.selectByAudioName(audio.getAudioName());
        if (audio1 != null){
            retValue = "添加失败，音响已存在";
            HtmlPageUtil.alert(retValue);
        }else {
            audioService.insert(audio);
        }
        return "redirect:/jump/toAddAudio";
    }

    /**
     * 删除音响
     * @return
     */
    @RequestMapping("/audio/delete")
    public String delete(Long id){
        retValue = audioService.delete(id);
        if ("删除失败".equals(retValue)){
            HtmlPageUtil.alert(retValue);
        }
        return "redirect:/jump/toManagerAudio";
    }

    /**
     * 查询音响信息
     * @return
     */
    @RequestMapping("/audio/select")
    public String select(Model model){
        List<Audio> audios = audioService.selectAll();
        model.addAttribute("audios",audios);
        return "index";
    }

    /**
     * 更新音响信息
     * @return
     */
    @RequestMapping("/audio/update")
    public String update(Audio audio){
        retValue = audioService.changeAudioInfo(audio);
        if ("修改失败".equals(retValue)){
            HtmlPageUtil.alert(retValue);
        }
        return "redirect:/jump/toManagerAudio";
    }
}
