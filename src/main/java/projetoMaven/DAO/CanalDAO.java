package projetoMaven.DAO;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import projetoMaven.Mensagem.Mensagem;
import projetoMaven.entity.Canal;
import projetoMaven.entity.Usuario;

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

		} catch (PersistenceException e) {
			Mensagem.bancoErro(e);
		} finally {
			entityManager.close();
			entityManagerFactory.close();
		}
	}

	public static boolean excluirCanal(Long id) {

		EntityManager entityManager = null;
		EntityManagerFactory entityManagerFactory = null;

		try {

			entityManagerFactory = Persistence.createEntityManagerFactory("projetoP2JPA");
			entityManager = entityManagerFactory.createEntityManager();
			entityManager.getTransaction().begin();
			Canal canal = entityManager.find(Canal.class, id);
			entityManager.remove(canal);
			entityManager.getTransaction().commit();
			return true;

		} catch (Exception e) {

		}
		return false;
	}

	@SuppressWarnings("unchecked")
	public static ArrayList<Canal> findAll() throws IllegalArgumentException {
		EntityManager entityManager = null;
		EntityManagerFactory entityManagerFactory = null;
		ArrayList<Canal> canal = null;
		try {

			entityManagerFactory = Persistence.createEntityManagerFactory("projetoP2JPA");
			entityManager = entityManagerFactory.createEntityManager();
			entityManager.getTransaction().begin();
			canal = (ArrayList<Canal>) entityManager.createQuery("from Canal").getResultList();
			entityManager.getTransaction().commit();

		} catch (Exception e) {
			Mensagem.exception(e);
		} finally {
			entityManager.close();
			entityManagerFactory.close();
		}
		return canal;
	}

	public static Canal existeCanal(Long id) {

		Canal canal = null;
		EntityManager entityManager = null;
		EntityManagerFactory entityManagerFactory = null;

		try {

			entityManagerFactory = Persistence.createEntityManagerFactory("projetoP2JPA");
			entityManager = entityManagerFactory.createEntityManager();
			
			entityManager.getTransaction().begin();
			canal = entityManager.find(Canal.class, id);
			entityManager.getTransaction().commit();

		} catch (PersistenceException e) {
			Mensagem.bancoErro(e);
		} catch (IllegalArgumentException e) {
			Mensagem.bancoErro(e);
		} catch (Exception e) {
			Mensagem.exception(e);
		} finally {
			entityManager.close();
			entityManagerFactory.close();
		}
		return canal;
	}
}
