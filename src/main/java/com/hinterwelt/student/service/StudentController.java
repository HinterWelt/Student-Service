/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hinterwelt.student.service;
import com.hinterwelt.student.entity.ErrorMessage;
import com.hinterwelt.student.entity.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 *
 * @author bilbo
 */
@RestController
@Configuration
@EnableAutoConfiguration
@EnableDiscoveryClient
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;
    
    @RequestMapping(method = RequestMethod.GET)
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }
    
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Student getStudentById(@PathVariable("id") int id){
        return studentService.getStudentById(id);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public ErrorMessage deleteStudentById(@PathVariable("id") int id){
        return studentService.removeStudent(id);
    }

    @RequestMapping(method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateStudent(@RequestBody Student student){
        studentService.updateStudent(student);
    }

    @RequestMapping(method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertStudent(@RequestBody Student student){
        studentService.insertStudent(student);
    }
}
