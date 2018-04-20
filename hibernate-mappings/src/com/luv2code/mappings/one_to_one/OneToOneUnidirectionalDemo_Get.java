package com.luv2code.mappings.one_to_one;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToOneUnidirectionalDemo_Get {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory factory=new Configuration()
				.configure("com/luv2code/mappings/one_to_one/hibernate.cfg.xml")				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		
		int theId=3;
		
		session.beginTransaction();
		
		//Getting Instructor details from Instructor
		System.out.println("Getting Instructor details from Instructor");
		Instructor tempInstructor=session.get(Instructor.class, theId);
		
		System.out.println("\nInstructor: " + tempInstructor);
		
		System.out.println("\nInstructorDetails: " + tempInstructor.getInstructorDetail());
		
		//Getting Instructor from Instructor details
		System.out.println("Getting Instructor from Instructor details");
		InstructorDetail tempInstructorDetails=session.get(InstructorDetail.class, theId);
				
		System.out.println("\nInstructorDetails: " + tempInstructorDetails);
				
		System.out.println("\nInstructor: " + tempInstructorDetails.getInstructor());		
		
		session.getTransaction().commit();
		
		System.out.println("Done!!");
		
		factory.close();
	}

}
