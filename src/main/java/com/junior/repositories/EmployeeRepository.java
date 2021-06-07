package com.junior.repositories;

import com.junior.entity.Employee;

import java.util.Iterator;

public interface EmployeeRepository {

    Iterable<Employee> getAllEmployees();

    Employee getEmployee(long id);

    Employee saveEmployee(Employee employee);

}
