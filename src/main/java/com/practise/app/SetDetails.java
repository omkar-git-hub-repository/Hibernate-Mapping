package com.practise.app;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.practise.Entity.StudVehicles;
import com.practise.Entity.Student;
import com.practise.Entity.StudentDoc;
import com.practise.Utility.HibernateUtility;

public class SetDetails {
    
    public void setDetails(){

        // This method can be used to set details for the application
        SessionFactory sessionFactory = HibernateUtility.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        
        System.out.println("Setting up application details...");
        Student s = new Student();
        s.setName("kia sain");
        s.setEmail("Kia@gmail.com");

        
        
        StudentDoc sd = new StudentDoc();
        sd.setPanNumber("RWQIJ-1234-5678");
        sd.setAadharNumber("1234-5678-9101");

        StudVehicles sv = new StudVehicles();
        sv.setVehicleName("Activa ");
        sv.setVehicleType("Two Wheeler");
       
        sv.setStudent(s);

      
        // Establishing the relationship
        sd.setStudent(s);
        s.setStudentDoc(sd);

        // Persisting the entities of StudentDoc due to mappedBy relationship it will automatically persist the Student entity
        
        session.persist(s);

        transaction.commit();
        session.close();
        System.out.println("Details set successfully: " + s);
        
    }
}
