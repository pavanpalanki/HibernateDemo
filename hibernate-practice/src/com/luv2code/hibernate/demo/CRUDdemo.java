package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Employee;

public class CRUDdemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();
		
		try {			

			Employee tmpEmployee1 = new Employee("pawan", "palanki", "TechM");
			Employee tmpEmployee2 = new Employee("saranya", "nakka", "Global Payments");
			Employee tmpEmployee3 = new Employee("gautham", "pisini", "Creatorz");
			Employee tmpEmployee4 = new Employee("anirban", "pal", "Accenture");
			
			session.beginTransaction();
			session.save(tmpEmployee1);
			session.save(tmpEmployee2);
			session.save(tmpEmployee3);
			session.save(tmpEmployee4);
			
			session.getTransaction().commit();
			
			System.out.println("Employees genetared..\n");
			System.out.println(tmpEmployee1+" \n"+tmpEmployee2+" \n"+tmpEmployee3+" \n"+tmpEmployee4+" \n\n");
			
			session=factory.getCurrentSession();
			session.beginTransaction();
			
			List<Employee> employees=session.createQuery("from Employee e where e.firstName='saranya'").getResultList();
			System.out.println("Employee with firstName as 'saranya'\n");
			displayEmployees(employees);
						
			
			Employee tmpEmployee5=session.get(Employee.class, tmpEmployee1.getId());
			System.out.println("Employee with id=1\n");
			System.out.println(tmpEmployee5);
			
			tmpEmployee5.setFirstName("dharma");			
			session.getTransaction().commit();
			System.out.println("Updating Employee with id=1\n");
			System.out.println(tmpEmployee5);
			
			session=factory.getCurrentSession();
			session.beginTransaction();
			
			session.delete(tmpEmployee4);
			List<Employee> employeesRemaining=session.createQuery("from Employee").getResultList();			
			session.getTransaction().commit();
			System.out.println("After deleting employee 'anirban'\n");
			displayEmployees(employeesRemaining);
			
			
		} finally {
			factory.close();
		}

	}

	private static void displayEmployees(List<Employee> employees) {
		for(Employee emp: employees){
			System.out.println(emp);
		}
	}

}
