package com.sit.controller;

import com.sit.common.CommonService;
import com.sit.entity.*;
import com.sit.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PatientController {
    @Autowired
    private Patient_pwdService patient_pwdService;
    @Autowired
    private Patient_baseService patient_baseService;
    @Autowired
    private OrderDetailService orderDetailService;
    @Autowired
    private PatientAccountService patientAccountService;
    @Autowired
    private TransferAccountService transferAccountService;
    @Autowired
    private RechargeService rechargeService;
    @Autowired
    private DepartmentService departmentService;

    @RequestMapping("/registerPatient")
    public String registerPatient(Model model, Patient_pwd patient_pwd, HttpSession httpSession) {
//        httpSession.setAttribute("patient_pwd",patient_pwd);
//        = patient_pwd.getPhoneNum();
//        System.out.println("----------- CommonService.Id" + CommonService.Id);
        Patient_base patient_base = new Patient_base();
        patient_base.setPhoneNum(patient_pwd.getPhoneNum());
//        patient_base.setPhoneNum(CommonService.Id);
        System.out.println("?exist:" + patient_pwdService.getPatient_pwd(patient_pwd).isEmpty());
        if (patient_pwdService.getPatient_pwd(patient_pwd).isEmpty() == true) {
            patient_baseService.addPatient_base(patient_base);
            patient_pwdService.addPatient_pwd(patient_pwd);
            PatientAccount patientAccount = new PatientAccount();
            patientAccount.setPhoneNum(patient_pwd.getPhoneNum());
            patientAccount.setBalance(0.00);
            patientAccountService.savePatientAccount(patientAccount);//初始化账户余额

            return "redirect:/login";
        } else {
            return "addPatientError";
        }
    }

    @RequestMapping("/PatientIndex")
    public String PatientMain(Model model, Patient_base patient_base) {
        HttpSession httpSession = CommonService.getSession();
        System.out.println("///////:" + httpSession.getServletContext().getAttribute("patient_base"));
        Patient_pwd patientPwd = new Patient_pwd();
        patientPwd = (Patient_pwd) httpSession.getAttribute("patient_pwd");
        patient_base= patient_baseService.findPatient_baseById(patientPwd.getPhoneNum());
        System.out.println("img:"+patient_base.getImgAddress().substring(patient_base.getImgAddress().lastIndexOf("\\")+1));
        patient_base.setImgAddress(patient_base.getImgAddress().substring(patient_base.getImgAddress().lastIndexOf("\\")+1));
        model.addAttribute("patientBase",patient_base);
//        model.addAttribute("patient_base", patient_base);
//        CommonService.patient_base = patient_base;
        System.out.println("session.Id:" + httpSession.getId());
//        System.out.println("CommonService.patient_base.getPhoneNum():" + CommonService.patient_base.getPhoneNum());
        return "PatientIndex";
    }

    @RequestMapping("/applyForHospital")
    public String applyForHospital(Model model, OrderDetail orderDetail) {
        model.addAttribute("orderDetail", orderDetail);
//        System.out.println("CommonService.patient_base.getPhoneNum():"+ CommonService.patient_base.getPhoneNum());
//        Calendar now = Calendar.getInstance();
////        orderDetail.setOrderHandleTime(now.getTime());
//
//        System.out.println("year:" +  now.getTime().getYear()+"-"+now.getTime().getMonth()+"-"+now.getTime().getDay()+"**"+now.getTime().getDate());
//        System.out.println("-now.getTime():" + now.getTime());
        return "applyForHospital";
    }

    @RequestMapping("/addOrderDetail")
    @ResponseBody
    public String addOrderDetail(Model model, OrderDetail orderDetail) {
        try {
            String phoneNum = patient_baseService.findPatient_baseByIDNo(orderDetail.getPatientId()).getPhoneNum();
            if (patientAccountService.verifyAccountBalanceEnough(phoneNum, orderDetail.getOrderCost())) {
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                System.out.println(df.format(System.currentTimeMillis()));
                orderDetail.setOrderHandleTime(df.format(System.currentTimeMillis()));
                orderDetail.setOrderStatus(CommonService.havePaid);

                transferAccountService.transferAccount(phoneNum, CommonService.hospitalCn, orderDetail.getOrderCost());//执行转账业务
                orderDetailService.addOrderDetail(orderDetail);//添加订单
                return "已成功预约！";
            } else {
                return "账户余额不足，请先充值！";
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "服务器正忙，请稍后再试！";

//        return "patientMain";
    }

    @RequestMapping("/updatePatient_baseInfo")
    public String updatePatient_baseInfo(Model model, Patient_base patient_base) {
        model.addAttribute("patient_base", patient_base);
        System.out.println("表单中Id:" + patient_base.getIdNo());
        return "updatePatient_baseInfo";
    }

    @RequestMapping(value = "/savePatient_baseInfo")
    public String savePatient_baseInfo(Model model, Patient_base patient_base, @RequestParam(value = "imgFile") MultipartFile imgFile, HttpSession httpSession) {
        Patient_base patient_base0 = new Patient_base();
        patient_base0 = patient_baseService.findPatient_baseById(((Patient_pwd) CommonService.getSession().getAttribute("patient_pwd")).getPhoneNum());
        patient_base.setPhoneNum(patient_base0.getPhoneNum());
        System.out.println("查询病人基本信息：" + patient_base0.getPhoneNum());
        if (patient_base.getPatientName().isEmpty()) {
            patient_base.setPatientName(patient_base0.getPatientName());
        }
        if (patient_base.getPatientSex().isEmpty()) {
            patient_base.setPatientSex(patient_base0.getPatientSex());
        }
        if (patient_base.getPatientAge() == 0) {
            patient_base.setPatientAge(patient_base0.getPatientAge());
        }
        if (patient_base.getIdNo().isEmpty()) {
            patient_base.setIdNo(patient_base0.getIdNo());
        }
        if (patient_base.getPatientPmdlh().isEmpty()) {
            patient_base.setPatientPmdlh(patient_base0.getPatientPmdlh());
        }
        try {
            if (!imgFile.isEmpty()) {
                String phoneNum = "";
                phoneNum = ((Patient_pwd) CommonService.getSession().getAttribute("patient_pwd")).getPhoneNum();
                String filename = CommonService.userImgAddress + phoneNum +"-"+ (int)(Math.random()*10)+".jpg";
                File file = new File(filename);
                if (!file.exists()) {
                    file.getParentFile().mkdirs();
                }
                BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(new File(filename)));//保存图片到目录下
                out.write(imgFile.getBytes());
                out.flush();
                out.close();
                patient_base.setImgAddress(filename);

            } else {
                patient_base.setImgAddress(patient_base0.getImgAddress());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("查询病人基本信息" + patient_base.getPatientName() + "-" + patient_base.getPatientAge() + "-" + patient_base.getPatientSex() + "-" + patient_base.getPatientPmdlh());
        httpSession.setAttribute("patient_base", patient_base);
        patient_baseService.addPatient_base(patient_base);

        return "patientMain";
    }

    @RequestMapping("rechargeAccount")
    public String rechargeAccount(Model model, Recharge recharge) {
        return "rechargeAccount";
    }

    @RequestMapping("patientRechargeAccount")
    @ResponseBody
    public String patientRechargeAccount(Model model, Recharge recharge) {
        try {
            rechargeService.rechargeAccount(recharge.getCardId(), recharge.getPhoneNum(), recharge.getAmount());
            return "充值成功！";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "服务器正忙，请稍后再试！";
    }

    @RequestMapping("findAccount")
    public void patientFindAccount(Model model, PatientAccount patientAccount) {
        String phoneNum = ((Patient_pwd) CommonService.getSession().getAttribute("patient_pwd")).getPhoneNum();
        PatientAccount pa = new PatientAccount();
        pa = patientAccountService.findPatientAccountById(phoneNum);
        if (!pa.getPhoneNum().isEmpty()) {
            model.addAttribute("patientAccount", pa);
        }
    }

    @RequestMapping("findRechargeRecord")
    public void findAccount(Model model) {
        String phoneNum = ((Patient_pwd) CommonService.getSession().getAttribute("patient_pwd")).getPhoneNum();
        List<Recharge> dataList = new ArrayList<>();
        dataList = rechargeService.findRechargeRecordByPhoneNum(phoneNum);
        if (!dataList.isEmpty()) {
            model.addAttribute("dataList", dataList);
        }
    }

    @RequestMapping("findOrderRecord")
    public void findOrderRecord(Model model) throws Exception {
        String phoneNum = ((Patient_pwd) CommonService.getSession().getAttribute("patient_pwd")).getPhoneNum();
        String idNo = patient_baseService.findPatient_baseById(phoneNum).getIdNo();
        List<OrderDetail> dataList = new ArrayList<>();
        dataList = orderDetailService.findOrderByIdNo(idNo);
        List<OrderRecord> recordList = new ArrayList<>();
//        OrderRecord orderRecord = new OrderRecord();
//        OrderRecord []or=new OrderRecord[dataList.size()];
//          dataList.toArray(or);
        String name = "";
        String sex = "";
        String departmentName = "";
        String id = "";
        for (int i = 0; i < dataList.size(); i++) {
            id = dataList.get(i).getPatientId();
            OrderRecord orderRecord = new OrderRecord();
//            name=patient_baseService.findPatient_baseByIDNo(id).getPatientName();
            orderRecord.setPatientName(patient_baseService.findPatient_baseByIDNo(id).getPatientName());

//            sex=patient_baseService.findPatient_baseByIDNo(id).getPatientSex();
            orderRecord.setPatientSex(patient_baseService.findPatient_baseByIDNo(id).getPatientSex());

            orderRecord.setIdNo(dataList.get(i).getPatientId());

            departmentName = departmentService.findDepartment(dataList.get(i).getDepartmentId()).getDepartmentName();
            orderRecord.setDepartmentName(departmentName);

            orderRecord.setOrderTime(dataList.get(i).getOrderTime());
            orderRecord.setOrderCost(dataList.get(i).getOrderCost());
            orderRecord.setOrderStatus(dataList.get(i).getOrderStatus());
            orderRecord.setOrderHandleTime(dataList.get(i).getOrderHandleTime());
//            recordList.set(i,orderRecord);
//            or[i]=orderRecord;
            System.out.println("i值:" + i);
            System.out.println("id值:" + dataList.get(i).getPatientId());

            recordList.add(orderRecord);
            System.out.println("departmentName值:" + recordList.get(i).getDepartmentName());
            System.out.println("OrderTime值:" + recordList.get(i).getOrderTime());
            System.out.println("OrderHandleTime值:" + recordList.get(i).getOrderHandleTime());
            orderRecord = null;

        }
//        for (int i=0;i<or.length;i++)
//        {
//            recordList.add(or[i]);
//        }
//        System.out.println("---departmentName值:"+recordList.get(0).getDepartmentName());
//        System.out.println("---departmentName值:"+recordList.get(1).getDepartmentName());
//        System.out.println("---departmentName值:"+recordList.get(2).getDepartmentName());
//        System.out.println("---departmentName值:"+recordList.get(3).getDepartmentName());
        if (!recordList.isEmpty()) {
            for (int j = 0; j < recordList.size(); j++) {
                System.out.println("departmentName值:" + recordList.get(j).getDepartmentName());
                System.out.println("OrderTime值:" + recordList.get(j).getOrderTime());
                System.out.println("OrderHandleTime值:" + recordList.get(j).getOrderHandleTime());
            }
            model.addAttribute("dataList", recordList);
//            return "";
        } else {
            OrderRecord orderRecord = new OrderRecord();
            orderRecord.setOrderTime("");
            orderRecord.setOrderHandleTime("");
            orderRecord.setOrderStatus("");
            orderRecord.setOrderCost(null);
            orderRecord.setDepartmentName("");
            orderRecord.setIdNo("");
            orderRecord.setPatientSex("");
            recordList.add(orderRecord);
            model.addAttribute("dataList", recordList);
//            return "<center>对不起，您还没有预约记录哦！<center>";
        }

    }


}
