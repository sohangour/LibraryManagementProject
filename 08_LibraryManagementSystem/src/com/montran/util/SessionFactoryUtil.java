package com.montran.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SessionFactoryUtil {
	private static SessionFactory factory;
	static {
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		System.out.println("Session Created");
	}

	public static SessionFactory getSessionFactory() {
		return factory;
	}
}
