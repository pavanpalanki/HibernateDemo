package com.luv2code.hibernate.demo;

import java.text.ParseException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) throws ParseException {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			// create 3 student objects
			System.out.println("Creating 3 student objects...");
			Student tempStudent1 = new Student("John", "Doe", "john@luv2code.com",DateUtils.parseDate("31/12/1999"));
			Student tempStudent2 = new Student("Mary", "Public", "mary@luv2code.com",DateUtils.parseDate("31/11/1998"));
			Student tempStudent3 = new Student("Bonita", "Applebum", "bonita@luv2code.com",DateUtils.parseDate("30/12/1998"));
			
			// start a transaction
			session.beginTransaction();
			
			// save the student object
			System.out.println("Saving the students...");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
		
		
	}

}
