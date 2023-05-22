package utils;

import javax.persistence.*;

public class JpaUtil {

	private static final EntityManagerFactory entityManagerFactory;

	static {
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("buildWeekBack_1");
		} catch (Throwable ex) {
			System.err.println("Initial EntityManagerFactory creation failed."	+ ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}

}
