package com.msa.user.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.msa.user.model.Department;
import com.msa.user.model.User;
import com.msa.user.model.UserDTO;

@Service
public class UserService{

    @Autowired
    private RestTemplate restTemplate;

    private static List<User> users = new ArrayList<>();

    public User create(User user){
        user.setId(1);
        if(!users.isEmpty()){
            user.setId(users.size() + 1);
        }

        users.add(user);
        return user;

    }

    public List<User> get(){
        return users;
    }

    public UserDTO getById(int id){
        User user = users.stream()
                .filter(department -> department.getId() == id)
                .findFirst()
                .orElseThrow(()->new IllegalStateException("User not found"));

        //Department department = restTemplate.getForObject("http://localhost:9001/departments/"+user.getDepartmentId(), Department.class);

        /*
        Because we have multiple instances running on server with different ports. So we don't know which one we should communicate
        then we should use the NAME OF SERVICE instead of calling direct to domain name
        => we need a load balancer here.
         */
        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/"+user.getDepartmentId(), Department.class);

        return new UserDTO(user, department);
    }
}
