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
        s.setName("John Doe");
        s.setEmail("john.doe@example.com");

        
        
        StudentDoc sd = new StudentDoc();
        sd.setPanNumber("ABCDE1234F");
        sd.setAadharNumber("1234-5678-9012");
        
        s.setStudentDoc(sd);

        session.persist(s);
        transaction.commit();
        session.close();
    }

}
