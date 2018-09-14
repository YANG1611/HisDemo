package com.sit.service;

import com.sit.dao.DoctorShowRepository;
import com.sit.entity.DoctorShow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorShowService {
    @Autowired
    private DoctorShowRepository doctorShowRepository;

    public void addDoctorShow(DoctorShow doctorShow) {
        doctorShowRepository.save(doctorShow);
    }
    public List<DoctorShow> getDoctorShow()
    {
      return   doctorShowRepository.findAll();
    }
    public Boolean verifyDoctorShowExist(String employeeId)
    {
       if( !doctorShowRepository.findByEmployeeId(employeeId).equals(null))
       {
           return true;
       }else
           return false;
    }
    public DoctorShow getDoctorShowByEmployeeId(String id)
    {
       return doctorShowRepository.findByEmployeeId(id);
    }
}
