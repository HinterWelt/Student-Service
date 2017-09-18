/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hinterwelt.student.service;

import com.hinterwelt.student.dao.StudentDao;
import com.hinterwelt.student.entity.ErrorMessage;
import com.hinterwelt.student.entity.Student;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

/**
 *
 * @author Bill Corrie
 * @version 1.0
 */
@Service
public class StudentService {
    @Autowired
    @Qualifier("moodle")
    private StudentDao studentDao;
    
    public List<Student> getAllStudents(){
        return this.studentDao.getAllStudents();
    }
    
    public Student getStudentById(int id){
        Student student = this.studentDao.getStudentById(id);
        //student.setCity("Downers Grove");
        return student;
    }
    
    public ErrorMessage removeStudent(int id){
        return this.studentDao.removeStudentById(id);
        
    }
    
    public void updateStudent(Student student){
        this.studentDao.updateStudentById(student);
    }
    
    public void insertStudent(Student student){
        this.studentDao.createStudent(student);
    }
}
