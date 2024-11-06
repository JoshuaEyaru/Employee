package com.resultset;

public class Employee {
    private int empId;
    private String empName;
    private String empTitle;

    public Employee (int empId, String empName, String empTitle){
        this.empId = empId;
        this.empName= empName;
        this.empTitle = empTitle;
    }
    // setter methods to set values of varriables
    public void setEmpId(int id){
        this.empId = id;
    }
    public void setEmpName(String name){
        this.empName = name;
    }

    public void setEmpTitle(String title){
        this.empTitle = title;
    }

    // getter methods
    public int getEmpId(){
        return  empId;
    }
    public String getEmpName(){
        return empName;
    }
    public String getEmpTitle(){
        return empTitle;
    }
}
