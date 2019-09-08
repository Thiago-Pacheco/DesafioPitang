package br.aluno.thiago.desafio.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	
	private static SessionFactory sessionFactory = fabricaSessoes(); 
	
	public static SessionFactory getSessionFactory() {
		
		return sessionFactory;
	}
	
	private static SessionFactory fabricaSessoes() {
		
		try {
			
			Configuration configuration = new Configuration().configure();
			
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
			
			SessionFactory factory = configuration.buildSessionFactory(serviceRegistry);
			
			return factory;
		
		} catch (Throwable t) {
			
			System.err.println("Sessão não criada");
			
			throw new ExceptionInInitializerError(t);
			
		}
		
	}

}
