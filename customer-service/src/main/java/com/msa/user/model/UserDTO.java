package com.msa.user.model;

public class UserDTO{

    private User user;

    private Department department;

    public UserDTO(User user, Department department){
        this.user = user;
        this.department = department;
    }

    public User getUser(){
        return user;
    }

    public void setUser(User user){
        this.user = user;
    }

    public Department getDepartment(){
        return department;
    }

    public void setDepartment(Department department){
        this.department = department;
    }
}
