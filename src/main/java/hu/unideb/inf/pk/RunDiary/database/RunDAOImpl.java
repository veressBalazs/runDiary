package hu.unideb.inf.pk.RunDiary.database;

import java.util.List;

import javax.persistence.EntityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * 
 * Iplementálja  RunDAO Interfészt.	
 */
public class RunDAOImpl implements RunDAO {

	private EntityManager em;
	private static Logger	
	logger = LoggerFactory.getLogger(RunDAOImpl.class);

	
	/**
	 *
	 *Konstruktor.
	 *@param em amit használni fog a RunDAOImpl a hozzáféréshez
	 */
	public RunDAOImpl(EntityManager em) {
		this.em = em;
	}
	/**
	 * Új elem létrehozása az adatbázisba.
	 * 
	 * @param re amit elfog menteni
	 * @return RunEntity amelyet elmentett
	 */
	public RunEntity createEntry(RunEntity re) {
		em.getTransaction().begin();
		logger.info("begining trasaction");
		em.persist(re);
		logger.info("persisting " + re.toString() + "entity");
		em.getTransaction().commit();
		logger.info("commited");
		return re;
	}
	/**
	 * AZ összes elem lekérdezése az adatbázisból.
	 * 
	 * @return RunEntity lista amelyet kiolvasott
	 */
	public List<RunEntity> readAllEntry() {
		em.getTransaction().begin();
		logger.info("begening trasaction");
		List<RunEntity> l = em.createQuery("Select a FROM RunEntity a", RunEntity.class).getResultList();
		logger.info("reading all database");
		em.getTransaction().commit();
		logger.info("commited");
		return l;
	}
	/**
	 * Egy elem kiolvasása az adatbázisból.
	 * @param id elemet olvas ki az adatbázisból id alapján
	 * @return RunEntity amelyet kiolvasott 
	 */
	public RunEntity ReadEntry(int id) {
		logger.info("finding entry with id: " +id);
		return em.find(RunEntity.class, id);
	}
	/**
	 * Elem törlése az adatbázisból.
	 * @param re lefog törölni
	 * @return RunEntity amelyet eltávolított
	 */
	public RunEntity removeEntry(RunEntity re) {
		em.getTransaction().begin();
		logger.info("begining trasaction");
		em.remove(re);
		logger.info("removing entry: "+ re);
		em.getTransaction().commit();
		logger.info("commiting changes");
		return re;
	}

}
