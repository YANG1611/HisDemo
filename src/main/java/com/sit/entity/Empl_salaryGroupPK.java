package com.sit.entity;




import java.io.Serializable;


public class Empl_salaryGroupPK implements Serializable {
   private Integer title_id;
   private String employee_id;

   public Empl_salaryGroupPK() {
   }

   public Integer getTitle_id() {
      return title_id;
   }

   public void setTitle_id(Integer title_id) {
      this.title_id = title_id;
   }

   public String getEmployee_id() {
      return employee_id;
   }

   public void setEmployee_id(String employee_id) {
      this.employee_id = employee_id;
   }
}
