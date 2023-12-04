package com.example.testweb.jdbc.service;

import com.example.testweb.jdbc.model.Employee;
import com.example.testweb.jdbc.model.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;

    public Employee getEmployee(int id){
        return employeeDao.findById(id);
    }

    public Employee getEmployeeByAnonymousClass(int id){
        return employeeDao.getById(id);
    }

    public Employee getEmployeeByMethodReferences(int id){
        return employeeDao.getById2(id);
    }

    public List<Employee> listAllEmployee(){
        return employeeDao.findAll();
    }

    public Employee addEmployee(Employee employee){
        return employeeDao.save(employee);
    }

    public int updateEmployee(Employee employee , int id){
        employee.setEmpNo(id);
        return employeeDao.update(employee);
    }

    @Transactional
    public int testTransactional(Employee employee , boolean isTest){
        employeeDao.update(employee);
        employeeDao.update(employee);

        if(isTest){
            throw new RuntimeException("測試交易錯誤");
        }

        return 1;
    }
}
