package com.practise.Entity;


import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_doc_id")
    private StudentDoc studentDoc;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
    private List<StudVehicles> studVehicles;

    public List<StudVehicles> getStudVehicles() {
        return studVehicles;
    }

    public void setStudVehicles(List<StudVehicles> studVehicles) {
        this.studVehicles = studVehicles;
    }

    public StudentDoc getStudentDoc() {
        return studentDoc;
    }
    public void setStudentDoc(StudentDoc studentDoc) {
        this.studentDoc = studentDoc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name='" + name + '\'' + ", email='" + email + '\'' + '}';
    }
}
