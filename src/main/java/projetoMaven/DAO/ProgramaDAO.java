package projetoMaven.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import projetoMaven.Mensagem.Mensagem;
import projetoMaven.entity.Programa;

public class ProgramaDAO {
	
	public static void saveUpDate(Programa programa) {

		EntityManagerFactory entityManagerFactory = null;
		EntityManager entityManager = null;

		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("projetoP2JPA");
			entityManager = entityManagerFactory.createEntityManager();

			entityManager.getTransaction().begin();
			entityManager.persist(programa);
			entityManager.getTransaction().commit();

		} catch (PersistenceException e) {
			Mensagem.bancoErro(e);
		} finally {
			entityManager.close();
			entityManagerFactory.close();
		}
	}

}
