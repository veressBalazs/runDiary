package hu.unideb.inf.pk.RunDiary.database;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



public class RunDAOFactory implements AutoCloseable {
	
	
	
	
	private final static String PERSISTENCE_UNIT_NAME = "run";
	private static RunDAOFactory instance;
	private static EntityManager em;
	private static EntityManagerFactory f;
	
	static{
		instance = new RunDAOFactory();
		f=Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		em = f.createEntityManager();
		
	}
	
	private  RunDAOFactory() {
		
	}
	
	public static RunDAOFactory getInstance(){
		
		return instance;
		
	}
	
	
	public RunDAO createRunDAO(){
		return new RunDAOImpl(em);
		
	}
	
	
	
	public void close() throws Exception {
		em.close();
        f.close();
		
	}


	
	
	

}
