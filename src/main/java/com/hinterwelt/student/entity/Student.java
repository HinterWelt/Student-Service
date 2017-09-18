/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hinterwelt.student.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author bilbo
 */
@XmlRootElement
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
public class Student {
    private int id;
    private String firstname;
    private String lastname;
    private String fullname;
    private String email;
    private String department;
    private String firstaccess;
    private String lastaccess;
    private String description;
    private int descriptionformat;
    private String city;
    private String country;
    private String profileimageurlsmall;
    private String profileimageurl;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getFirstaccess() {
        return firstaccess;
    }

    public void setFirstaccess(String firstaccess) {
        this.firstaccess = firstaccess;
    }

    public String getLastaccess() {
        return lastaccess;
    }

    public void setLastaccess(String lastaccess) {
        this.lastaccess = lastaccess;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDescriptionformat() {
        return descriptionformat;
    }

    public void setDescriptionformat(int descriptionformat) {
        this.descriptionformat = descriptionformat;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProfileimageurlsmall() {
        return profileimageurlsmall;
    }

    public void setProfileimageurlsmall(String profileimageurlsmall) {
        this.profileimageurlsmall = profileimageurlsmall;
    }

    public String getProfileimageurl() {
        return profileimageurl;
    }

    public void setProfileimageurl(String profileimageurl) {
        this.profileimageurl = profileimageurl;
    }
    
}
