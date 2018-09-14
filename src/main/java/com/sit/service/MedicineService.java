package com.sit.service;

import com.sit.dao.MedicineRepository;
import com.sit.entity.Medicine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicineService {
    @Autowired
    private MedicineRepository medicineRepository;
    public List<Medicine> findMedicineAll()
    {
        return medicineRepository.findAll();
    }
    public void addMedicine(Medicine medicine)
    {
        medicineRepository.save(medicine);
    }
}
