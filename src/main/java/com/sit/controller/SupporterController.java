package com.sit.controller;

import com.sit.common.CommonService;
import com.sit.entity.DoctorHelper;
import com.sit.entity.Employee_base;
import com.sit.entity.Medicine;
import com.sit.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class SupporterController {
    @Autowired
    OrderDetailService orderDetailService;
    @Autowired
    DiagnosticMakeService diagnosticMakeService;
    @Autowired
    DiagnosticInspectService diagnosticInspectService;
    @Autowired
    Empl_dimissionService empl_dimissionService;
    @Autowired
    Empl_depaService empl_depaService;
    @Autowired
    DepartmentService departmentService;
    @Autowired
    Empl_titleService empl_titleService;
    @Autowired
    TitleService titleService;
    @Autowired
    Empl_salaryService empl_salaryService;
    @Autowired
    SalaryService salaryService;
    @Autowired
    Employee_baseService employee_baseService;

    @RequestMapping("/SupporterPersonalInfo")
    public String NursePersonalInfo(Model model, Employee_base employee_base) {
        String EmployeeId = CommonService.Id;
        System.out.println("职工ID：" + EmployeeId);
        employee_base = employee_baseService.findEmployee_base(EmployeeId);
        if (employee_base == null)
            employee_base = employee_baseService.findEmployee_base("1");
        DoctorHelper doctorHelper = new DoctorHelper();
        doctorHelper.setEmployeeID(EmployeeId);
        doctorHelper.setName(employee_base.getEmployeeName());
        doctorHelper.setSex(employee_base.getEmployeeSex());
        doctorHelper.setAge(employee_base.getEmployeeAge().toString());
        doctorHelper.setID(employee_base.getId());
        doctorHelper.setPhoneNumber(employee_base.getPhoneNum());
        doctorHelper.setLiveAddress(employee_base.getEmployeeLiveAddress());
        doctorHelper.setBirthplace(employee_base.getEmployeeBirthplace());
        doctorHelper.setNation(employee_base.getEmployeeNation());
        doctorHelper.setDepartmentName(departmentService.findDepartment(empl_depaService.findEmpl_depa(EmployeeId).getDepartmentID()).getDepartmentName());
        doctorHelper.setTitleName(titleService.findTitle(empl_titleService.findEmpl_title(EmployeeId).getTitleID()).getTitleName());
        doctorHelper.setSalary(salaryService.findSalary(empl_salaryService.findEmpl_salary(EmployeeId).getTitleID()).getMoney_month().toString());
        model.addAttribute("dataList", doctorHelper);
        return "SupporterPersonalInfo";
    }

    @RequestMapping(value = "/findMedicineAll")
    public String findMedicineAll() {
        return "findMedicineAll";
    }

    @RequestMapping("/addMedicine")
    public String addMedicine() {
        return "/addMedicine";
    }

    @RequestMapping("/SupporterMain")
    public String SupporterMain() {
        return "/SupporterMain";
    }

    @RequestMapping("/GetMedicineByObject")
    @ResponseBody
    public String login() {
        String url = "http://localhost:8080/GetMedicineByObject";
        HttpMethod httpMethod = HttpMethod.POST;
        RestTemplate restTemplate = new RestTemplate();
        MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<>();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class, multiValueMap);
        return responseEntity.getBody();
    }

}
