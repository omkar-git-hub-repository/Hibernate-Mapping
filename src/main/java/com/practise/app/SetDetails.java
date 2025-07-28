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
        s.setName("Sam Smith");
        s.setEmail("Sam@gmail.com");

        
        
        StudentDoc sd = new StudentDoc();
        sd.setPanNumber("ABCDE1234F");
        sd.setAadharNumber("1234-5678-9012");

        StudVehicles sv = new StudVehicles();
        sv.setVehicleName("Gt 650");
        sv.setVehicleType("Bike");
       
        sv.setStudent(s);
        StudVehicles sv1 = new StudVehicles();
        sv1.setVehicleName("Honda Shine");
        sv1.setVehicleType("Bike");
        sv1.setStudent(s);

        // Setting the student for the second vehicle
        // This is necessary to maintain the bidirectional relationship
        // between StudVehicles and Student
        
        StudVehicles sv2 = new StudVehicles();
        sv2.setVehicleName("Honda Amaze");
        sv2.setVehicleType("Car");
        sv2.setStudent(s);

        List<StudVehicles> vehicles = Arrays.asList(sv, sv1, sv2);
        s.setStudVehicles(vehicles);


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
