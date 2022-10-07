package com.hibernate;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.student.Address;
import com.hibernate.student.Certificate;
import com.hibernate.student.Student;

public class HibernateApplication {

	public static void main(String[] args) throws IOException {
		System.out.println("hello world");
		System.out.println("Project Started");
		// SessionFactory factory = new
		// Configuration().configure().buildSessionFactory();

		// System.out.println(factory.isClosed());
		// we can use factory to fetch data and to save data and more

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		System.out.println(":factory:==>" + factory);
		// Creating Student class
		Student st = new Student();

		Certificate cf = new Certificate();
		cf.setCourse("Java");
		cf.setDuration("1 hour 30 Minutes");
		// the problem in this project is that it is not auto incrementing we have to
		// manually provide the numbers for the studentId here --------------------
		st.setFirstName("keshav");
		st.setLastName("koli");
		st.setClassName("Computer-Science");
		st.setRollNo("A12C");
		st.setAge(23);
		st.setCerti(cf);
		System.out.println(st);
		
		

		// Creating object of Address class
		Address ad = new Address();
		ad.setStreet("Mumbai-Pune Road");
		ad.setCity("Pune");
		ad.setOpen(true);
		ad.setAddedDate(new Date());
		ad.setX(12);
		System.out.println(":ad==>:" + ad);

		try {
			// reading image
			FileInputStream fis = new FileInputStream("C:\\Users\\91774\\Desktop\\jai.jpg");
			byte[] date = new byte[fis.available()];
			fis.read(date);
			ad.setImage(date);
			System.out.println(":fis:==>" + fis);
			System.out.println(":date:==>" + date);
		} catch (FileNotFoundException fne) {
			System.out.println(fne);
			fne.printStackTrace();
		}

		// Get the session object.
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(st);
		session.save(ad);
		tx.commit();
		session.close();
		System.out.println("Done..........");

	}

}
