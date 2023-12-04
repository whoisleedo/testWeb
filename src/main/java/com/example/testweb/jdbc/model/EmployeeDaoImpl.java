package com.example.testweb.jdbc.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public Employee findById(int id) {
        final String sql = "SELECT * FROM EMP2 WHERE EMPNO = ?";

        return jdbcTemplate.query(sql, new EmployeeRowMapper(), id)
                .stream().findFirst().orElse(null);
    }

    @Override
    public List<Employee> findAll() {
        final String sql = "SELECT * FROM EMP2 ";

        return jdbcTemplate.query(sql, new EmployeeRowMapper());
    }
    //使用匿名類別的row mapper
    @Override
    public Employee getById(int id) {
        final String sql = "SELECT * FROM EMP2 WHERE EMPNO = ?";

        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Employee employee = new Employee();
            employee.setEmpNo(rs.getInt("EMPNO"));
            employee.setEname(rs.getString("ENAME"));
            employee.setJob(rs.getString("JOB"));
            employee.setHireDate(parseLocalDate(rs.getString("HIREDATE")));
            employee.setSal(parseBigDecimal(rs.getString("SAL")));
            employee.setComm(parseBigDecimal(rs.getString("COMM")));
            employee.setDeptNo(rs.getInt("DEPTNO"));
            return employee;
        }, id).stream().findFirst().orElse(null);
    }
    // 使用方法引用row mapper
    @Override
    public Employee getById2(int id) {
        final String sql = "SELECT * FROM EMP2 WHERE EMPNO = ?";

        return jdbcTemplate.query(sql,this::row2Employee , id)
                           .stream().findFirst().orElse(null);
    }

    protected Employee row2Employee(ResultSet rs, int rowNo) throws SQLException {
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

    private BigDecimal parseBigDecimal(String numberString){
        if(numberString == null){
            return null;
        }

        return new BigDecimal(numberString);
    }

    private LocalDate parseLocalDate(String date){
        if(date == null) return null;

        return LocalDate.parse(date);
    }

    @Override
    public Employee save(Employee employee) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        final String insertSql = "INSERT INTO EMP2 (ENAME, JOB, HIREDATE, SAL, COMM, DEPTNO) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement pst = con.prepareStatement(insertSql, new String[]{"EMPNO"});
                pst.setString(1, employee.getEname());
                pst.setString(2, employee.getJob());
                pst.setObject(3, employee.getHireDate());
                pst.setDouble(4, employee.getSal() != null ? employee.getSal().doubleValue() : 0);
                pst.setObject(5, employee.getComm() != null ? employee.getComm().doubleValue() : 0);
                pst.setInt(6, employee.getDeptNo());
                return pst;
            }
        },keyHolder);
        Number key = keyHolder.getKey();
        if (key != null) {
            employee.setEmpNo(key.intValue());
        }
        return employee;
    }

    @Override
    public int update(Employee employee) {
        final String updateSql = "UPDATE EMP2 SET ENAME=?, JOB=?, HIREDATE=?, SAL=?, COMM=?, DEPTNO=? WHERE EMPNO=?";
        return jdbcTemplate.update(updateSql, employee.getEname(), employee.getJob(),
                employee.getHireDate(), employee.getSal(), employee.getComm(), employee.getDeptNo(), employee.getEmpNo());
    }
}
