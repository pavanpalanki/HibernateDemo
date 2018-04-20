package com.luv2code.mappings.one_to_one;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToOneUnidirectionalDemo_Create {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory factory=new Configuration()
				.configure("com/luv2code/mappings/one_to_one/hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		
		Instructor tempInstructor=new Instructor("saranya","palanki","bsnakka@gamail.com");
		
		InstructorDetail tempInstructorDetail=new InstructorDetail("saranyapalanki@youtube.com","watching movies");
		
		tempInstructor.setInstructorDetail(tempInstructorDetail);
		
		session.beginTransaction();
		
		System.out.println("Saving instructor: " + tempInstructor);
		session.save(tempInstructor);
		
		session.getTransaction().commit();
		
		System.out.println("Done!!");
		
		factory.close();
	}

}
