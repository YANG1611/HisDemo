package com.sit.controller;

import com.sit.common.CommonService;
import com.sit.entity.DoctorShow;
import com.sit.entity.Feedback;
import com.sit.entity.Patient_pwd;
import com.sit.service.DoctorShowService;
import com.sit.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.List;

//@RestController
@Controller
//@EnableAutoConfiguration
@RequestMapping("/")
public class FeedbackController {
    @Autowired
    private FeedbackService feedbackService;
    @Autowired
    private DoctorShowService doctorShowService;

    @RequestMapping("/")
    public String addFeedback(Model model) {
        model.addAttribute("feedback", new Feedback());
        File doctorPicDir = new File(CommonService.userImgAddress);
        if(!doctorPicDir.exists()){
            doctorPicDir.mkdirs();
        }
        return "index";
    }

    @RequestMapping("/index")
    public String addFeedback1(Model model) {
        model.addAttribute("feedback", new Feedback());
        File doctorPicDir = new File(CommonService.userImgAddress);
        if(!doctorPicDir.exists()){
            doctorPicDir.mkdirs();
        }
        return "index";
    }

    @RequestMapping("/visitor_addFeedback")
    @ResponseBody
    public String visitor_addFeedback(Feedback feedback, Model model) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        feedback.setMsgTime(df.format(System.currentTimeMillis()));
        feedbackService.addFeedback(feedback);
        return "留言成功！";
    }

    @RequestMapping("/login")
    public String login(Model model) {
        model.addAttribute("patient_pwd", new Patient_pwd());
        return "login";
    }

    @RequestMapping("/getDoctorShowJson")
    @ResponseBody
    public List<DoctorShow> getDoctorShowJson() {
        return doctorShowService.getDoctorShow();
    }

}
