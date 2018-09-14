package com.sit.controller;

import com.sit.common.CommonService;
import com.sit.entity.Admin_pwd;
import com.sit.entity.Employee_base;
import com.sit.entity.Patient_base;
import com.sit.entity.Patient_pwd;
import com.sit.service.Admin_pwdService;
import com.sit.service.Employee_baseService;
import com.sit.service.Patient_baseService;
import com.sit.service.Patient_pwdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class LoginController {
    @Autowired
    private Patient_pwdService patient_pwdService;
    @Autowired
    private Admin_pwdService admin_pwdService;
@Autowired
private Employee_baseService employee_baseService;
@Autowired
private Patient_baseService patient_baseService;

    @RequestMapping("/loginEmpl")
    public String loginEmpl(Model model) {
        model.addAttribute("employee_base", new Employee_base());
        return "loginEmpl";
    }

    @RequestMapping("/EmplLogin")
    public String loginEmplPwd(Model model,Employee_base employee_base,HttpSession httpSession) {
        model.addAttribute("employee_base", new Employee_base());
        String emplType=employee_baseService.findEmployee_baseInfo(employee_base.getEmployeeId()).get(0).getEmployeeType();
        Boolean loginFlag = employee_baseService.verifyEmployee_base(employee_base);
        System.out.println("loginflag:"+loginFlag+"\n"+"empltype:"+emplType);
        if (loginFlag) {
            if(emplType.equals("doctor")) {
//                CommonService.Id=employee_base.getEmployeeId();
//                CommonService.employee_base=employee_baseService.findEmployee_base(CommonService.Id);
                employee_base=employee_baseService.findEmployee_base(employee_base.getEmployeeId());
                httpSession.setAttribute("employee_base",employee_base);

                return "DoctorMain";//跳转doctor登陆成功后主页面
            }
            if(emplType.equals("nurse"))
            {
//                CommonService.Id=employee_base.getEmployeeId();
                employee_base=employee_baseService.findEmployee_base(employee_base.getEmployeeId());
                httpSession.setAttribute("employee_base",employee_base);
                return "NurseMain";//跳转nurse登陆成功后主页面
            }
            if(emplType.equals("supporter"))
            {
//                CommonService.Id=employee_base.getEmployeeId();
                employee_base=employee_baseService.findEmployee_base(employee_base.getEmployeeId());
                httpSession.setAttribute("employee_base",employee_base);
                return "SupporterMain";//跳转supporter登陆成功后主页面
            }

            if(emplType.equals("receptionist")) {
//                CommonService.Id=employee_base.getEmployeeId();
//                System.out.println("CommonService.Id:"+CommonService.Id);
                employee_base=employee_baseService.findEmployee_base(employee_base.getEmployeeId());
                httpSession.setAttribute("employee_base",employee_base);
                return "receptionistMain";//跳转receptionist登陆成功后主页面
            }

        }
        return "loginEmpl";//返回员工登录界面

    }

    @RequestMapping("/loginAdmin")
    public String loginAdmin(Model model) {
        model.addAttribute("admin_pwd", new Admin_pwd());
        return "loginAdmin";
    }

    @RequestMapping("/loginAdminPwd")
    public String loginAdminPwd(Model model,Admin_pwd admin_pwd,HttpSession httpSession) {
        model.addAttribute("admin_pwd", new Admin_pwd());
        Boolean loginFlag = admin_pwdService.verifyAdmin_pwd(admin_pwd);
        if (loginFlag) {
//            CommonService.Id=admin_pwd.getAdminiId();
            httpSession.setAttribute("admin_pwd",admin_pwd);
            return "AdminMain";//跳转管理员登陆成功后主页面
        }
        return "loginAdmin";//返回管理员登录界面

    }

    @RequestMapping("/patientLogin")
    public String patientLogin(Model model, Patient_pwd patient_pwd, HttpSession httpSession) {

        model.addAttribute("patient_pwd", new Patient_pwd());
        Boolean loginFlag = patient_pwdService.verifyPatient_pwd(patient_pwd);
            if (loginFlag) {
                httpSession.setAttribute("patient_pwd", patient_pwd);
//                httpSession.setAttribute("patient_base", patient_baseService.findPatient_baseById(patient_pwd.getPhoneNum()));
                Patient_pwd patpwd = new Patient_pwd();
                patpwd = (Patient_pwd) httpSession.getAttribute("patient_pwd");
//                Patient_base p = new Patient_base();
//                p = (Patient_base) httpSession.getAttribute("patient_base");
//                System.out.println("session-patient_pwd:" + patpwd.getPwd());
//                System.out.println("session-patient_base:" + p.getPatientName());
                return "patientMain";//跳转病人登陆成功后主页面
            }


        return "login";//返回病人登录界面
    }
    }
