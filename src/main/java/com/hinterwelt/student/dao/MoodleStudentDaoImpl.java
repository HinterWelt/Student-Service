package com.hinterwelt.student.dao;

import com.hinterwelt.student.entity.ErrorMessage;
import com.hinterwelt.student.entity.Student;
import com.hinterwelt.student.entity.Users;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author bilbo
 */
@Repository("moodle")
@ConfigurationProperties
@PropertySource("classpath:secure.properties")
public class MoodleStudentDaoImpl implements StudentDao {
    @Value("${restMoodleURI}")
    private String restMoodleURI;
    @Value("${vletoken}")
    private String vletoken;
    @Value("${requestFormat}")
    private String requestFormat;

    @Override
    public List<Student> getAllStudents() {
        String moodleFunction = "&wsfunction=core_user_get_users&criteria[0][key]=role&criteria[0][value]=student";
        String reqURL = restMoodleURI + vletoken + moodleFunction + requestFormat;
        RestTemplate restTemplate = new RestTemplate();
 
        List<Student> students = restTemplate.getForObject(reqURL,Users.class).getStudents();

        return students;

    }

    @Override
    public Student getStudentById(int id) {
        RestTemplate restTemplate = new RestTemplate();
        String moodleFunction = "&wsfunction=core_user_get_users_by_field&field=id&values[0]=" + id;
        String reqURL = restMoodleURI + vletoken + moodleFunction + requestFormat;

        ResponseEntity<List<Student>> studentResponse
                = restTemplate.exchange(reqURL,
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<Student>>() {
                });
        List<Student> students = studentResponse.getBody();

        return students.get(0);
    }

    @Override
    public ErrorMessage removeStudentById(int id) {
        String moodleFunction = "&wsfunction=core_user_delete_users&criteria[0][key]=id&criteria[0][value]="+id;
        String reqURL = restMoodleURI + vletoken + moodleFunction + requestFormat;
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
        String moodleFunction = "&wsfunction=core_user_delete_users&criteria[0][key]=id&criteria[0][value]=";
        String reqURL = restMoodleURI + vletoken + moodleFunction + requestFormat;
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void createStudent(Student student) {
        String moodleFunction = "&wsfunction=core_user_delete_users&criteria[0][key]=id&criteria[0][value]=";
        String reqURL = restMoodleURI + vletoken + moodleFunction + requestFormat;
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
