package pers.chenjiahao.audiomgs.service.impl;

import org.springframework.stereotype.Service;
import pers.chenjiahao.audiomgs.entity.Lease;
import pers.chenjiahao.audiomgs.mapper.LeaseMapper;
import pers.chenjiahao.audiomgs.service.LeaseService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LeaseServiceImpl implements LeaseService {
    @Resource
    private LeaseMapper leaseMapper;

    @Override
    public int addLeaseInfo(Lease lease) {
        return leaseMapper.insert(lease);
    }

    @Override
    public String updateLeaseInfo(Lease lease) {
        return leaseMapper.updateByPrimaryKey(lease) > 0 ? "更新成功" : "更新失败";
    }

    @Override
    public List<Lease> selectAll() {
        return leaseMapper.selectAll();
    }

    @Override
    public List<Lease> selectByUsername(String username) {
        return leaseMapper.selectByUsername(username);
    }

    @Override
    public Lease selectById(Long id) {
        return leaseMapper.selectByPrimaryKey(id);
    }
}
