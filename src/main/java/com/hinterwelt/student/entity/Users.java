/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hinterwelt.student.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 *
 * @author bilbo
 */
public class Users {
    @JsonProperty("users")
    private List<Student> users;

    public List<Student> getStudents() {
        return users;
    }

    public void setStudents(List<Student> students) {
        this.users = users;
    }
    
}
