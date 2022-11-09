package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.pojo.Employee;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Configuration config = new Configuration().addAnnotatedClass(Employee.class);
        SessionFactory sf = config.configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = sf.openSession();
        
       
        Employee emp  = new Employee();
        emp.setEname("Tom32");
        emp.setEaddress("US32");
        
       // session.save(emp);
        //session.persist(emp);
        Transaction tx =  session.beginTransaction();
        //session.persist(emp);  //persist method is used within the transaction boundaries.
        session.save(emp); 
        //emp.setEname("Tom22");  //we can use save method with or without transaction boundaries.
        tx.commit();
        
        
        System.out.println("Record inserted successfully..");
        session.close();
        sf.close();
    }
}
