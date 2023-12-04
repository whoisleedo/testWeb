package com.example.testweb.jdbc.controller;

import com.example.testweb.jdbc.model.Employee;
import com.example.testweb.jdbc.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class EmpController {

    private final static Logger log = LoggerFactory.getLogger(EmpController.class);
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("employees")
    public List<Employee> getEmployees(){
        return employeeService.listAllEmployee();
    }
    @GetMapping("employee/{id}")
    public Employee findById(@PathVariable int id){
        return employeeService.getEmployee(id);
    }
    @PostMapping("employee")
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeService.addEmployee(employee);
    }
    @PutMapping("employee/{id}")
    public int updateEmployee(@RequestBody Employee employee, @PathVariable int id){
        return employeeService.updateEmployee(employee , id);
    }
    @PutMapping("error")
    public int testError(@RequestBody Employee employee){
        try {
           return employeeService.testTransactional(employee,true);
        }catch (Exception e){
            log.warn("something wrong ", e);
        }
         return -1;
    }

    // 以下為其他寫法的測試用
    @GetMapping("test1/employee/{id}")
    public Employee getEmployeeUseAnonymousClass(@PathVariable int id){
        return employeeService.getEmployeeByAnonymousClass(id);
    }
    @GetMapping("test2/employee/{id}")
    public Employee getEmployeeUseMethodReferences(@PathVariable int id){
        return employeeService.getEmployeeByMethodReferences(id);
    }
}
