package com.sit.service;

import com.sit.common.CommonService;
import com.sit.dao.RechargeRepository;
import com.sit.entity.PatientAccount;
import com.sit.entity.Recharge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class RechargeService {
    @Autowired
    private RechargeRepository rechargeRepository;
    @Autowired
    private PatientAccountService patientAccountService;

    @Transactional
    public void rechargeAccount(String cardId, String phoneNum, Double amount) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Recharge recharge = new Recharge();
        recharge.setCardId(cardId);
        recharge.setPhoneNum(phoneNum);
        recharge.setAmount(amount);
        recharge.setOperateTime(df.format(System.currentTimeMillis()));
        recharge.setOperateStatus(CommonService.haveRecharged);
        saveRecharge(recharge);//添加充值记录
        PatientAccount patientAccount = new PatientAccount();
        patientAccount = patientAccountService.findPatientAccountById(phoneNum);
        patientAccount.setBalance(patientAccount.getBalance() + amount);
        patientAccountService.savePatientAccount(patientAccount);//充值账户

    }

    @Transactional
    public void saveRecharge(Recharge recharge) {
        rechargeRepository.save(recharge);
    }
    public List<Recharge> findRechargeRecordByPhoneNum(String phoneNum)
    {
        return rechargeRepository.findByPhoneNum(phoneNum);
    }
}
