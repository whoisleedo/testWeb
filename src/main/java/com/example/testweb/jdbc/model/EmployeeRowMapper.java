package com.example.testweb.jdbc.model;

import org.springframework.jdbc.core.RowMapper;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;


public class EmployeeRowMapper implements RowMapper<Employee> {
    @Override
    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
        Employee employee = new Employee();
        employee.setEmpNo(rs.getInt("EMPNO"));
        employee.setEname(rs.getString("ENAME"));
        employee.setJob(rs.getString("JOB"));
        employee.setHireDate(parseLocalDate(rs.getString("HIREDATE")));
        employee.setSal(parseBigDecimal(rs.getString("SAL")));
        employee.setComm(parseBigDecimal(rs.getString("COMM")));
        employee.setDeptNo(rs.getInt("DEPTNO"));

        return employee;
    }

    private LocalDate parseLocalDate(String date){
        if(date == null) return null;

        return LocalDate.parse(date);
    }

    private BigDecimal parseBigDecimal(String numberString){
        if(numberString == null){
            return null;
        }

        return new BigDecimal(numberString);
    }
}
