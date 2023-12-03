package com.example.testweb.jdbc.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Employee {
    private int empNo;
    private String ename;
    private String job;
    private LocalDate hireDate;
    private BigDecimal sal;
    private BigDecimal comm;
    private int deptNo;

    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public BigDecimal getSal() {
        return sal;
    }

    public void setSal(BigDecimal sal) {
        this.sal = sal;
    }

    public BigDecimal getComm() {
        return comm;
    }

    public void setComm(BigDecimal comm) {
        this.comm = comm;
    }

    public int getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(int deptNo) {
        this.deptNo = deptNo;
    }

    public Employee() {}

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer(super.toString());
        sb.append("{empNo:").append(empNo);
        sb.append(", ename:'").append(ename).append('\'');
        sb.append(", job:'").append(job).append('\'');
        sb.append(", hireDate:").append(hireDate);
        sb.append(", sal:").append(sal);
        sb.append(", comm:").append(comm);
        sb.append(", deptNo:").append(deptNo);
        sb.append('}');
        return sb.toString();
    }
}
