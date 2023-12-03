package com.example.testweb.jdbc.model;

import java.util.List;

public interface EmployeeDao {
    Employee findById(int id);
    List<Employee> findAll();
    Employee save(Employee employee);

    int update(Employee employee);


}
