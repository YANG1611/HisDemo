package com.sit.service;

import com.sit.dao.PatientAccountRepository;
import com.sit.entity.PatientAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PatientAccountService {
    @Autowired
    private PatientAccountRepository patientAccountRepository;

    public void savePatientAccount(PatientAccount patientAccount) {
        patientAccountRepository.save(patientAccount);
    }

    public PatientAccount findPatientAccountById(String id) {
        return patientAccountRepository.findById(id).get();
    }
    public Boolean verifyAccountBalanceEnough(String id,Double amount)//验证账户余额
    {
      if( ( patientAccountRepository.findById(id).get().getBalance()-amount)<0)
          return false;
      else
          return true;
    }
}
