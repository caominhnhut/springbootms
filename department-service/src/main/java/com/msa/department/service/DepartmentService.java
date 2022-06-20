package com.msa.department.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.msa.department.model.Department;

@Service
public class DepartmentService{

    @Autowired
    private RestTemplate restTemplate;

    private static List<Department> departments = new ArrayList<>();

    public Department create(Department department){
        department.setId(1);
        if(!departments.isEmpty()){
            department.setId(departments.size()+1);
        }

        departments.add(department);

        String message = restTemplate.getForObject("http://NOTIFICATION-SERVICE/notification/"+department.getId()+"/?target-type=department", String.class);

        System.out.println(message);

        return department;

    }

    public List<Department> get(){
        return departments;
    }

    public Department getById(int id){
        Department result = departments.stream()
                .filter(department -> department.getId() == id)
                .findFirst()
                .orElseThrow(()->new IllegalStateException("Department not found"));

        String message = restTemplate.getForObject("http://NOTIFICATION-SERVICE/notification/"+id+"/?target-type=department", String.class);

        System.out.println(message);

        return  result;
    }
}