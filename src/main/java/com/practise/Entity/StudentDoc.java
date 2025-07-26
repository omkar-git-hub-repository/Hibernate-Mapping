package com.practise.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class StudentDoc {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String PanNumber;
    private String AadharNumber;

    
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
