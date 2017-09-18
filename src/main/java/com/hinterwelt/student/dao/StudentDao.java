/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hinterwelt.student.dao;

import com.hinterwelt.student.entity.ErrorMessage;
import com.hinterwelt.student.entity.Student;
import com.hinterwelt.student.entity.Users;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author bilbo
 */
public interface StudentDao {

    List<Student> getAllStudents();

    Student getStudentById(int id);

    ErrorMessage removeStudentById(int id);

    void updateStudentById(Student student);

    void createStudent(Student student);
    

}
