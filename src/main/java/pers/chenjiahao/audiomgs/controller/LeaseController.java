package pers.chenjiahao.audiomgs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pers.chenjiahao.audiomgs.entity.Lease;
import pers.chenjiahao.audiomgs.service.LeaseService;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class LeaseController {

    @Resource
    private LeaseService leaseService;

    /**
     * 用户查询个人租借记录
     * @param username
     * @return
     */
    @RequestMapping("/lease/selectPersonUser")
    public void selectPersonUser(String username,Model model){
        List<Lease> userLeases = leaseService.selectByUsername(username);
        model.addAttribute("userLeases",userLeases);
    }

    /**
     * 店主查询所有租借记录
     * @return
     */
    @RequestMapping("/lease/select")
    public void select(Model model){
        List<Lease> leases = leaseService.selectAll();
        model.addAttribute("leases",leases);
    }
}
