package com.luv2code.mappings.one_to_one;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToOneUnidirectionalDemo_DeleteAll {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory factory=new Configuration()
				.configure("com/luv2code/mappings/one_to_one/hibernate.cfg.xml")				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		
		session.beginTransaction();
		
		List<Instructor> tempInstructor=session.createQuery("from Instructor").getResultList();
		
		for(Instructor instructor: tempInstructor)
			session.delete(instructor);
		
		session.getTransaction().commit();
		
		System.out.println("Done!!");
		
		factory.close();
	}

}
