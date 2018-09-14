package com.sit.common;


import com.sit.entity.Employee_base;
import com.sit.entity.Patient_base;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class CommonService {
    public static String Id;
    public static Patient_base patient_base = new Patient_base();
    public static Employee_base employee_base = new Employee_base();
//    public static final String imgAddress = "C:\\doctorPic\\";
    public static final String userImgAddress = "C:\\userPic\\";
    public static final String hospitalCn = "15101000001";//医院账户
    public static final String havePaid = "已支付";//支付成功状态
    public static final String haveRecharged = "已充值";//充值账户成功状态

    public static HttpSession getSession() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getSession();

    }
}
