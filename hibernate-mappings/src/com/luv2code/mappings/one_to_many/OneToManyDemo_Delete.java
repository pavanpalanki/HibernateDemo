package com.luv2code.mappings.one_to_many;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToManyDemo_Delete {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory factory=new Configuration()
				.configure("com/luv2code/mappings/one_to_many/hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		
		session.beginTransaction();	
		
		//Deleting Instructor 1 and retaining Course
		//This will delete the associated Instructor details
		Instructor tempInstructor=session.get(Instructor.class, 1);		
		
		for(Course course: tempInstructor.getCourses()){
			course.setInstructor(null);
		}
				
		session.delete(tempInstructor);

		session.getTransaction().commit();
		
		System.out.println("Done!!");
		
		factory.close();
	}

}
