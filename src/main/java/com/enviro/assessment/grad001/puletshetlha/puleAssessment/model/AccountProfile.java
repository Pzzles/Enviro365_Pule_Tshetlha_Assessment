package com.enviro.assessment.grad001.puletshetlha.puleAssessment.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class AccountProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // or GenerationType.AUTO, GenerationType.SEQUENCE, etc.
    @Column(name = "id")
    private Integer id;

    private String name;
    private String surname;
    private String httpImageLink;

    public AccountProfile(){
    }

    public AccountProfile(Integer id, String name, String surname, String httpImageLink) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.httpImageLink = httpImageLink;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setHttpImageLink(String httpImageLink) {
        this.httpImageLink = httpImageLink;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getHttpImageLink() {
        return httpImageLink;
    }

}
