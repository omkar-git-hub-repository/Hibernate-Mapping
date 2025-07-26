package com.practise.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class StudentDoc {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String PanNumber;
    private String AadharNumber;

    @OneToMany(mappedBy = "studentDoc")
    private Student student;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getPanNumber() {
        return PanNumber;
    }
    public void setPanNumber(String panNumber) {
        PanNumber = panNumber;
    }
    public String getAadharNumber() {
        return AadharNumber;
    }
    public void setAadharNumber(String aadharNumber) {
        AadharNumber = aadharNumber;
    }


    @Override
    public String toString() {
        return "StudentDoc [id=" + id + ", PanNumber=" + PanNumber + ", AadharNumber=" + AadharNumber + "]";
    }

}
