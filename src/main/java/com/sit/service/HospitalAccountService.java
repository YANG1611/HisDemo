package com.sit.service;

import com.sit.dao.HospitalAccountRepository;
import com.sit.entity.HospitalAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HospitalAccountService {
    @Autowired
    private HospitalAccountRepository hospitalAccountRepository;

    public void saveHospitalAccount(HospitalAccount hospitalAccount) {
        hospitalAccountRepository.save(hospitalAccount);
    }

    public HospitalAccount findHospitalAccountById(String id) {
        return hospitalAccountRepository.findById(id).get();
    }
}
