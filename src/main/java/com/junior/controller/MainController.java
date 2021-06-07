package com.junior.controller;

import com.junior.entity.Employee;
import com.junior.persistence.DaoEmployee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("dashboard")
public class MainController {

    private List<Employee> employees;
    private DaoEmployee daoEmployee;
    public MainController(List<Employee> employees, DaoEmployee daoEmployee){
        this.employees = new ArrayList<>();
        this.daoEmployee = daoEmployee;
    }

    @GetMapping
    public String index(Model model){

        daoEmployee.getAllEmployees().forEach(i -> employees.add(i));
        model.addAttribute("employees",employees);
        return "dashboard";
    }

}
