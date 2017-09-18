/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hinterwelt.student.dao;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hinterwelt.student.entity.ErrorMessage;
import com.hinterwelt.student.entity.Student;
import com.hinterwelt.student.entity.Users;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author bilbo
 */
@Repository("moodle")
public class MoodleStudentDaoImpl implements StudentDao {

    @Override
    public List<Student> getAllStudents() {
        String reqURL = "http://moodle.hinterwelt.org/webservice/rest/server.php?wstoken=4143ab05998b499b05d06fb46e674915&wsfunction=core_user_get_users&moodlewsrestformat=json&criteria[0][key]=role&criteria[0][value]=student";
        RestTemplate restTemplate = new RestTemplate();
 
        List<Student> students = restTemplate.getForObject(reqURL,Users.class).getStudents();

        return students;

    }

    @Override
    public Student getStudentById(int id) {
        RestTemplate restTemplate = new RestTemplate();
        String reqURL = "http://moodle.hinterwelt.org/webservice/rest/server.php?wstoken=4143ab05998b499b05d06fb46e674915&wsfunction=core_user_get_users_by_field&field=id&values[0]=" + id + "&moodlewsrestformat=json";

        ResponseEntity<List<Student>> studentResponse
                = restTemplate.exchange(reqURL,
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<Student>>() {
                });
        List<Student> students = studentResponse.getBody();

        return students.get(0);
    }

    @Override
    public ErrorMessage removeStudentById(int id) {
        String reqURL = "http://moodle.hinterwelt.org/webservice/rest/server.php?wstoken=4143ab05998b499b05d06fb46e674915&wsfunction=core_user_delete_users&moodlewsrestformat=json&criteria[0][key]=id&criteria[0][value]="+id;
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(reqURL);

        ResponseEntity<ErrorMessage> deleteResponse
                = restTemplate.exchange(reqURL,
                        HttpMethod.GET, null, new ParameterizedTypeReference<ErrorMessage>() {
                });
ErrorMessage eResponse = deleteResponse.getBody();
return eResponse;

    }

    @Override
    public void updateStudentById(Student student) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void createStudent(Student student) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
