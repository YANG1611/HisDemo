package com.sit.controller;

import com.sit.common.CommonService;
import com.sit.entity.*;
import com.sit.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.*;

@Controller
public class DoctorController {
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
    @Autowired
    DoctorShowService doctorShowService;

    @RequestMapping("/DotorCheckAppointment")
    public String findOrderDetail(Model model, OrderDetail orderDetail) {
        System.out.println("查询所有预约信息：");
        model.addAttribute("data", orderDetailService.findOrder());
        System.out.println("OrderDetail.Id:" + orderDetail.getPatientId());
        return "DotorCheckAppointment";
    }

    @RequestMapping("/saveDiagnosticInfo")
    public String saveDiagnosticInfo(Model model, Diagnostic diagnostic) {
        diagnostic.setDoctorId(((Employee_base) CommonService.getSession().getAttribute("employee_base")).getEmployeeId());
        diagnosticMakeService.saveDiagnosticMake(diagnostic);
//        System.out.println("diagnosticPatient" + diagnostic.getMedTime());
        return "DoctorMain";
    }

    @RequestMapping("/DiagnosticMake")
    public String DiagnosticMake(Model model, Diagnostic diagnostic) {
        return "DiagnosticMake";
    }

    @RequestMapping("/DiagnosticInpsect")
    public String DiagnosticInpsect(Model model, Diagnostic diagnostic) {
        model.addAttribute("dataList", diagnosticInspectService.finaDiagnostic());
        return "DiagnosticInspect";
    }

    @RequestMapping("/applyForDimission")
    public String applyForDimission(Model model, Empl_dimission empl_dimission) {
        model.addAttribute("empl_dimission", empl_dimission);
        return "applyForDimission";
    }

    @RequestMapping("/EmplApplyForDimission")
    public String EmplApplyForDimission(Model model, Empl_dimission empl_dimission) {
        empl_dimission.setEmployeeId(((Employee_base) CommonService.getSession().getAttribute("employee_base")).getEmployeeId());
        Boolean addFlag = empl_dimissionService.verifyaddEmpl_dimission(empl_dimission.getEmployeeId());
        if (addFlag) {
            empl_dimissionService.addEmpl_dimission(empl_dimission);
            return "DoctorMain";
        } else {
            return "redirect:/applyForDimission";
        }
    }

    @RequestMapping("/DoctorPersonalInfo")
    public String DoctorPersonalInfo(Model model, Employee_base employee_base) {
        String EmployeeId = ((Employee_base) CommonService.getSession().getAttribute("employee_base")).getEmployeeId();
        employee_base = employee_baseService.findEmployee_base(EmployeeId);
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
        employee_base.setImgAddress(employee_base.getImgAddress().substring(employee_base.getImgAddress().lastIndexOf("\\")+1));
        doctorHelper.setImgAddress(employee_base.getImgAddress());
        model.addAttribute("dataList", doctorHelper);
        return "DoctorPersonalInfo";

    }

    @RequestMapping("/updateEmployee_baseInfo")
    public String updateEmployee_baseInfo(Model model, Employee_base employee_base) {
        return "updateEmployee_baseInfo";
    }

    @RequestMapping(value = "/saveEmployee_baseInfo")
    public String saveEmployee_baseInfo(Model model, Employee_base employee_base, @RequestParam(value = "employeeAge") String employeeAge, @RequestParam(value = "imgFile") MultipartFile imgFile, HttpSession httpSession) {
//        System.out.println("age:"+employeeAge.equals(""));
        employee_base.setEmployeeId(((Employee_base) CommonService.getSession().getAttribute("employee_base")).getEmployeeId());
//        System.out.println("-------CommonService.employee_base.getEmployeeName():" + CommonService.employee_base.getEmployeeName());
        if (employee_base.getEmployeeName().isEmpty()) {
            employee_base.setEmployeeName(((Employee_base) CommonService.getSession().getAttribute("employee_base")).getEmployeeName());
        }
        if (employee_base.getEmployeeSex().isEmpty()) {
            employee_base.setEmployeeSex(((Employee_base) CommonService.getSession().getAttribute("employee_base")).getEmployeeSex());
        }
        if (employeeAge.equals("")) {
        employee_base.setEmployeeAge(employee_baseService.findEmployee_base(((Employee_base) CommonService.getSession().getAttribute("employee_base")).getEmployeeId()).getEmployeeAge());
        }
        if (employee_base.getId().isEmpty()) {
            employee_base.setId(((Employee_base) CommonService.getSession().getAttribute("employee_base")).getId());
        }
        if (employee_base.getEmployeeBirthplace().isEmpty()) {
            employee_base.setEmployeeBirthplace(((Employee_base) CommonService.getSession().getAttribute("employee_base")).getEmployeeBirthplace());
        }
        if (employee_base.getEmployeeLiveAddress().isEmpty()) {
            employee_base.setEmployeeLiveAddress(((Employee_base) CommonService.getSession().getAttribute("employee_base")).getEmployeeLiveAddress());
        }
        if (employee_base.getEmployeeNation().isEmpty()) {
            employee_base.setEmployeeNation(((Employee_base) CommonService.getSession().getAttribute("employee_base")).getEmployeeNation());
        }
        if (employee_base.getPhoneNum().isEmpty()) {
            employee_base.setPhoneNum(((Employee_base) CommonService.getSession().getAttribute("employee_base")).getPhoneNum());
        }
        employee_base.setEmployeeType(((Employee_base) CommonService.getSession().getAttribute("employee_base")).getEmployeeType());
        employee_base.setPwd(((Employee_base) CommonService.getSession().getAttribute("employee_base")).getPwd());

        //--------------------------------------------------------------------
        try {
            if (!imgFile.isEmpty()) {
//                String filename = CommonService.imgAddress + ((Employee_base) CommonService.getSession().getAttribute("employee_base")).getEmployeeId() + ".jpg";
                String filename = CommonService.userImgAddress + ((Employee_base) CommonService.getSession().getAttribute("employee_base")).getEmployeeId()+"-"+ (int)(Math.random()*10)+".jpg";
                File file = new File(filename);
                if (!file.exists()) {
                    file.getParentFile().mkdirs();
                }

//                System.out.println(">>>>>>>>>>>>>>>>>>>" + filename);
                BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(new File(filename)));//保存图片到目录下
                out.write(imgFile.getBytes());
                out.flush();
                out.close();
                employee_base.setImgAddress(filename);

            } else {
                employee_base.setImgAddress(((Employee_base) CommonService.getSession().getAttribute("employee_base")).getImgAddress());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        employee_baseService.addEmployee_baseInfo(employee_base);
        Boolean DoctorShowExist=doctorShowService.verifyDoctorShowExist(((Employee_base) CommonService.getSession().getAttribute("employee_base")).getEmployeeId());
//        System.out.println("DoctorShowExist:"+DoctorShowExist);
        if (DoctorShowExist&&!employee_base.getEmployeeName().isEmpty()) {
            DoctorShow doctorShow = new DoctorShow();
            doctorShow = doctorShowService.getDoctorShowByEmployeeId(((Employee_base) CommonService.getSession().getAttribute("employee_base")).getEmployeeId());
            doctorShow.setEmployeeName(employee_base.getEmployeeName());
            doctorShowService.addDoctorShow(doctorShow);
        }
        httpSession.setAttribute("employee_baseUpdate", employee_base);
        return "DoctorMain";
    }


}
