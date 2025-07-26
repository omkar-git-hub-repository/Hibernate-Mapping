package com.practise.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

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
        s.setName("Alice Doe");
        s.setEmail("alice.doe@example.com");

        
        
        StudentDoc sd = new StudentDoc();
        sd.setPanNumber("ASKO-1234k");
        sd.setAadharNumber("5421-7849-6523");
      
        // Establishing the relationship
        sd.setStudent(s);
        s.setStudentDoc(sd);

        
        session.persist(sd);

        transaction.commit();
        session.close();
        System.out.println("Details set successfully: " + s);
    }
}
