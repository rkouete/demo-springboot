package com.soft.demo;

public class Student {
    private String firstname;
    private String lastname;
    private String matricule;


    public Student() {
    }

    public Student(String firstname, String lastname, String matricule) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.matricule = matricule;
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

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getMatricule() {
        return matricule;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
