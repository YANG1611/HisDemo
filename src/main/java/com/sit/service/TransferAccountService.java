package com.sit.service;

import com.sit.dao.TransferAccountRepository;
import com.sit.entity.HospitalAccount;
import com.sit.entity.PatientAccount;
import com.sit.entity.TransferAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;

@Service
public class TransferAccountService {
    @Autowired
    private TransferAccountRepository transferAccountRepository;
    @Autowired
    private PatientAccountService patientAccountService;
    @Autowired
    private HospitalAccountService hospitalAccountService;

    @Transactional
    public void transferAccount(String fromUserId, String toUserId, Double amount) {

        PatientAccount patientAccount = new PatientAccount();
        patientAccount = patientAccountService.findPatientAccountById(fromUserId);
        patientAccount.setBalance(patientAccount.getBalance() - amount);//fromUser 扣钱
        patientAccountService.savePatientAccount(patientAccount);
        HospitalAccount hospitalAccount = new HospitalAccount();
        hospitalAccount = hospitalAccountService.findHospitalAccountById(toUserId);
        hospitalAccount.setBalance(hospitalAccount.getBalance() + amount);//toUser 加钱
        hospitalAccountService.saveHospitalAccount(hospitalAccount);

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(df.format(System.currentTimeMillis()));
        TransferAccount transferAccount = new TransferAccount();
        transferAccount.setFromUserId(fromUserId);
        transferAccount.setToUserId(toUserId);
        transferAccount.setAmount(amount);
        transferAccount.setOperateTime(df.format(System.currentTimeMillis()));
        transferAccountRepository.save(transferAccount);//添加转账记录
    }
}
