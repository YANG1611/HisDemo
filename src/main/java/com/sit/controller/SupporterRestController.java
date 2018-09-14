package com.sit.controller;

import com.sit.common.CommonService;
import com.sit.entity.Employee_base;
import com.sit.entity.Medicine;
import com.sit.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageNotReadableException;
//import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class SupporterRestController {
    @Autowired
    private MedicineService medicineService;

    @RequestMapping(value = "/findMedicineAllInfo")
    public List<Medicine> findMedicineAll() {
        return medicineService.findMedicineAll();

    }

    @RequestMapping(value = "/saveMedicine", method = RequestMethod.POST, consumes = "application/json")
    public Map<String, String> getMedicine(@RequestBody Medicine medicine) throws HttpMediaTypeNotSupportedException {
        Map<String, String> result = new HashMap<String, String>();
        if (medicine != null) {
            System.out.println("springboot接受到浏览器以JSON格式    提交的数据：" + medicine.getMedId());
            medicine.setEmplId(((Employee_base) CommonService.getSession().getAttribute("employee_base")).getEmployeeId());
            medicineService.addMedicine(medicine);
            Format format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            result.put("code", "添加成功！");


        } else {
            result.put("error", "网络错误，请重新尝试！");
        }
        return result;
    }

}
