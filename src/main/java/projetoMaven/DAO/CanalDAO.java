package projetoMaven.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import projetoMaven.Mensagem.Mensagem;
import projetoMaven.entity.Canal;

public class CanalDAO {

	public static void saveUpDateCanal(Canal canal) {

		EntityManagerFactory entityManagerFactory = null;
		EntityManager entityManager = null;

		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("projetoP2JPA");
			entityManager = entityManagerFactory.createEntityManager();

			entityManager.getTransaction().begin();
			entityManager.persist(canal);
			entityManager.getTransaction().commit();
			Mensagem.usuarioSalvo();

		} catch (PersistenceException e) {
			Mensagem.bancoErro(e);
		} finally {
			entityManager.close();
			entityManagerFactory.close();
		}
	}
}
