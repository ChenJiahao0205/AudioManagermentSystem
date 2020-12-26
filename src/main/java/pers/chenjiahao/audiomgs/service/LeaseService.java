package pers.chenjiahao.audiomgs.service;

import pers.chenjiahao.audiomgs.entity.Lease;

import java.util.List;

public interface LeaseService {
    int addLeaseInfo(Lease lease);

    String updateLeaseInfo(Lease lease);

    List<Lease> selectAll();

    List<Lease> selectByUsername(String username);

    Lease selectById(Long id);
}
