package com.msa.department.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.msa.department.model.Department;
import com.msa.department.service.DepartmentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/departments")
public class DepartmentController{

    @Autowired
    private DepartmentService departmentService;

    @PostMapping
    @HystrixCommand
    public Department create(@RequestBody Department department){
        return departmentService.create(department);
    }

    @GetMapping
    @HystrixCommand
    public List<Department> get(){
        return departmentService.get();
    }

    @GetMapping("/{department-id}")
    @HystrixCommand
    public Department getById(@PathVariable("department-id") int departmentId){
        return departmentService.getById(departmentId);
    }

}
