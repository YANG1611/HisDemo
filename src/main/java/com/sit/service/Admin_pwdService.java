package com.sit.service;

import com.sit.dao.Admin_pwdRepository;
import com.sit.entity.Admin_pwd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Admin_pwdService {
    @Autowired
    private Admin_pwdRepository admin_pwdRepository;

    public boolean verifyAdmin_pwd(Admin_pwd admin_pwd) {//验证管理员登录条件

        if (admin_pwdRepository.findByAdminiIdAndPwd(admin_pwd.getAdminiId(), admin_pwd.getPwd()).isEmpty()) {
            return false;
        } else {
            return true;
        }

    }

}
