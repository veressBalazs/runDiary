package hu.unideb.inf.pk.RunDiary.database;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 *RunDAOFactory osztály
 *
 */
public class RunDAOFactory implements AutoCloseable {
	
	
	private static Logger	
	logger = LoggerFactory.getLogger(RunDAOFactory.class);

	
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
	/**
	 *RunDAOFactory egy példányát adja vissza
	 *@return RunDAOFactory
	 */
	public static RunDAOFactory getInstance(){
		
		return instance;
		
	}
	
	/**
	 * Egy RunDAO objektumot példányosít.
	 * @return RunDAOImpl
	 */
	public RunDAO createRunDAO(){
		logger.info("creating runDAO");
		return new RunDAOImpl(em);
		
	}
	
	
	
	public void close() throws Exception {
		em.close();
        f.close();
		
	}


	
	
	

}
