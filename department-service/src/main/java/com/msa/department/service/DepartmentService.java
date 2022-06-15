package com.msa.department.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.msa.department.model.Department;

@Service
public class DepartmentService{

    private static List<Department> departments = new ArrayList<>();

    public Department create(Department department){
        department.setId(1);
        if(!departments.isEmpty()){
            department.setId(departments.size()+1);
        }

        departments.add(department);
        return department;

    }

    public List<Department> get(){
        return departments;
    }

    public Department getById(int id){
        return departments.stream()
                .filter(department -> department.getId() == id)
                .findFirst()
                .orElseThrow(()->new IllegalStateException("Department not found"));
    }
}