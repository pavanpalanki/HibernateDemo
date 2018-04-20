package com.luv2code.mappings.one_to_many;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToManyDemo_Create {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory factory=new Configuration()
				.configure("com/luv2code/mappings/one_to_many/hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		
		Instructor tempInstructor=new Instructor("pavan","palanki","pavan@gamail.com");
		Instructor tempInstructor1=new Instructor("akshay","palanki","akshay@gamail.com");
		
		InstructorDetail tempInstructorDetail=new InstructorDetail("pavan@youtube.com","Love to code");
		InstructorDetail tempInstructorDetail1=new InstructorDetail("akshay@youtube.com","Actor");
		
		tempInstructor.setInstructorDetail(tempInstructorDetail);
		tempInstructor1.setInstructorDetail(tempInstructorDetail1);
		
		Course course1=new Course("Mechanics");
		Course course2=new Course("Thermodynamics");
		Course course3=new Course("Industrial");
		
		Course course4=new Course("Java");
		Course course5=new Course("MySql");
		
		tempInstructor.addCourse(course1);
		tempInstructor.addCourse(course2);
		tempInstructor.addCourse(course3);
		
		tempInstructor1.addCourse(course4);
		tempInstructor1.addCourse(course5);
		
		
		session.beginTransaction();
		
		System.out.println("Instructor: " + tempInstructor);
		System.out.println("Courses: "+tempInstructor.getCourses());
		
		System.out.println("\nInstructor: " + tempInstructor1);
		System.out.println("Courses: "+tempInstructor1.getCourses());
		session.save(tempInstructor);
		session.save(tempInstructor1);
		session.save(tempInstructorDetail);
		session.save(tempInstructorDetail1);
		session.save(course1);
		session.save(course2);
		session.save(course3);	
		session.save(course4);
		session.save(course5);	
		
		session.getTransaction().commit();
		
		System.out.println("Done!!");
		
		factory.close();
	}

}
