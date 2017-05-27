package hu.unideb.inf.pk.RunDiary.database;

import java.util.List;

import javax.persistence.EntityManager;

public class RunDAOImpl implements RunDAO {

	private EntityManager em;

	public RunDAOImpl(EntityManager em) {
		this.em = em;
	}

	public RunEntity createEntry(RunEntity re) {
		em.getTransaction().begin();
		em.persist(re);
		em.getTransaction().commit();
		return re;
	}

	public List<RunEntity> readAllEntry() {
		em.getTransaction().begin();
		List<RunEntity> l = em.createQuery("Select a FROM RunEntity a", RunEntity.class).getResultList();
		em.getTransaction().commit();
		return l;
	}

	public RunEntity ReadEntry(int id) {

		return em.find(RunEntity.class, id);
	}

	public RunEntity removeEntry(RunEntity re) {
		em.getTransaction().begin();
		em.remove(re);
		em.getTransaction().commit();
		return re;
	}

}
