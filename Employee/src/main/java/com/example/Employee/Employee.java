package com.example.Employee;

import java.sql.Date;

public class Employee {
    private int id;
    private String first_name;
    private String last_name;
    private int salary;
    private Date dateOfBirth;
    private Date joinningDate;
    public Employee(){

    }


    public Employee(int id, String first_name, String last_name, int salary, Date dateOfBirth, Date joinninDate) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.salary = salary;
        this.dateOfBirth = dateOfBirth;
        this.joinningDate = joinninDate;
    }

    public int getId() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Date getJoinningDate() {
        return joinningDate;
    }

    public void setJoinningDate(Date joinninDate) {
        this.joinningDate = joinninDate;
    }
}
