package com.hibernate.vehicle;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainClassUser {
	public static void main(String[] args) {
		System.out.println("Started the Program");
		SessionFactory factory = new Configuration().configure().buildSessionFactory();

		Vehicle vehicle = new Vehicle();
		vehicle.setVehicle_name("Honda");

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(vehicle);
		tx.commit();
		session.close();
	}
}
