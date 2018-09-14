package com.sit.controller;

import com.sit.common.CommonService;
import com.sit.entity.*;
import com.sit.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AdminController {
    @Autowired
    private Employee_baseService employee_baseService;
    @Autowired
    private FeedbackService feedbackService;
    @Autowired
    private Empl_dimissionService empl_dimissionService;
    @Autowired
    private Empl_salaryService empl_salaryService;
    @Autowired
    private Empl_titleService empl_titleService;
    @Autowired
    private DoctorShowService doctorShowService;
    @Autowired
    private TitleService titleService;
    @Autowired
    private Empl_depaService empl_depaService;
    @Autowired
    private HospitalAccountService hospitalAccountService;

    @RequestMapping("/addEmployee_baseInfo")
    public String addEmployee_baseInfo(Model model, Employee_base employee_base) {
        model.addAttribute("employee_base", employee_base);
        return "addEmployee_baseInfo";
    }

    @RequestMapping("/adminAddEmployee_baseInfo")
    public String adminAddEmployee_baseInfo(Model model, Employee_base employee_base) {
        System.out.println("--employee_base.getEmployeeId()" + employee_base.getEmployeeId());
        Boolean addFlag = employee_baseService.verifyAddEmployee_baseInfo(employee_base.getEmployeeId());
        System.out.println("--addFlag" + addFlag);
        if (addFlag == true) {
            employee_baseService.addEmployee_baseInfo(employee_base);
            return "AdminMain";
        } else {
            return "redirect:/addEmployee_baseInfo";
        }

    }

    @RequestMapping("/findFeedbackAllInfo")
    public String findFeedbackAllInfo(Model model) {
        model.addAttribute("dataList", feedbackService.findAllFeedback());
        return "findFeedbackAllInfo";
    }

    @RequestMapping("/findEmpl_dimissionAllInfo")
    public String findEmpl_dimissionAllInfo(Model model) {
        model.addAttribute("dataList", empl_dimissionService.findEmpl_dimissionInfoAll());
        return "findEmpl_dimissionAllInfo";
    }

    @RequestMapping("/addEmpl_salary")
    public String addEmpl_salary(Model model, Empl_salary empl_salary) {
        model.addAttribute("empl_salary", empl_salary);
        return "addEmpl_salary";
    }

    @RequestMapping("/adminAddEmpl_salaryInfo")
    public String adminAddEmpl_salaryInfo(Model model, Empl_salary empl_salary) {
        empl_salaryService.addEmpl_salary(empl_salary);
        return "AdminMain";

    }

    @RequestMapping("/addEmpl_title")
    public String addEmpl_title(Model model, Empl_title empl_title) {
        model.addAttribute("empl_title", empl_title);
        return "addEmpl_title";
    }

    @RequestMapping("/adminAddEmpl_titleInfo")
    public String adminAddEmpl_titleInfo(Model model, Empl_title empl_title) {
        empl_titleService.addEmpl_title(empl_title);
        return "AdminMain";

    }

    @RequestMapping("/addDoctorShow")
    public String addDoctorShow(Model model, DoctorShow doctorShow) {
        model.addAttribute("doctorShow", doctorShow);
        return "addDoctorShow";
    }

    @RequestMapping("/adminAddDoctorShow")
    public String adminAddDoctorShow(Model model, DoctorShow doctorShow) {
        String EmployeeId = doctorShow.getEmployeeId();
        doctorShow.setEmployeeName(employee_baseService.findEmployee_base(EmployeeId).getEmployeeName());
        Integer TitleID = empl_titleService.findEmpl_title(EmployeeId).getTitleID();
        String TitleName = titleService.findTitle(TitleID).getTitleName();
        doctorShow.setTitleName(TitleName);
        doctorShowService.addDoctorShow(doctorShow);
        return "AdminMain";

    }

    @RequestMapping("/addEmpl_depa")
    public String addEmpl_depa(Model model, Empl_depa empl_depa) {
        model.addAttribute("empl_depa", empl_depa);
        return "addEmpl_depa";
    }

    @RequestMapping("/adminAddEmpl_depa")
    public String adminAddEmpl_depa(Model model, Empl_depa empl_depa) {
        empl_depaService.addEmpl_depa(empl_depa);
        return "AdminMain";

    }

    @RequestMapping("/findHospitalAccount")
    public String adminFindHospitalAccount(Model model, HospitalAccount hospitalAccount) {
        hospitalAccount = hospitalAccountService.findHospitalAccountById(CommonService.hospitalCn);
        model.addAttribute("hospitalAccount", hospitalAccount);
        return "findHospitalAccount";
    }
}
