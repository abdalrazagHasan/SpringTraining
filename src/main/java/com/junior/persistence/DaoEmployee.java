package com.junior.persistence;

import com.junior.entity.Employee;
import com.junior.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;


@Repository
public class DaoEmployee implements EmployeeRepository {

    private final JdbcTemplate template;

    @Autowired
    public DaoEmployee(JdbcTemplate template){
        this.template = template;
    }

    @Override
    public Iterable<Employee> getAllEmployees() {
        return template.query("SELECT * FROM users",this::mapRowToIngredient);
    }

    @Override
    public Employee getEmployee(long id) {
        return template.queryForObject("SELECT * FROM users WHERE id=?",
                this::mapRowToIngredient,id);
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        template.update(
                "INSERT INTO users(id, fullname, username, password)VALUES(?,?,?,?)",
                employee.getId(),employee.getFullName(),employee.getUsername(),employee.getPassword());
        return employee;
    }

    private Employee mapRowToIngredient(ResultSet rs, int rowNum)
            throws SQLException {

        Employee employee = new Employee();
        employee.setId(rs.getLong("id"));
        employee.setFullName(rs.getString("fullname"));
        employee.setUsername(rs.getString("username"));
        employee.setPassword(rs.getString("password"));

        return employee;
    }

}
