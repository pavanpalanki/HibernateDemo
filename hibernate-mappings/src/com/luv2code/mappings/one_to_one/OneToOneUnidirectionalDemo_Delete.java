package com.luv2code.mappings.one_to_one;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToOneUnidirectionalDemo_Delete {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory factory=new Configuration()
				.configure("com/luv2code/mappings/one_to_one/hibernate.cfg.xml")				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		
		int theId=2;
		
		session.beginTransaction();
		
		Instructor tempInstructor=session.get(Instructor.class, theId);
		
		System.out.println("\nDeleting Instructor: " + tempInstructor);
		
		System.out.println("\nDeleting InstructorDetails: " + tempInstructor.getInstructorDetail());
		
		session.delete(tempInstructor);
		
		session.getTransaction().commit();
		
		System.out.println("Done!!");
		
		factory.close();
	}

}
