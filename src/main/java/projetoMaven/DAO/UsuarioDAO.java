package projetoMaven.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import projetoMaven.Mensagem.Mensagem;
import projetoMaven.entity.Usuario;

public class UsuarioDAO {

	public static void salvarUsuario(Usuario usuario) {

		EntityManagerFactory entityManagerFactory = null;
		EntityManager entityManager = null;

		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("projetoP2JPA");
			entityManager = entityManagerFactory.createEntityManager();

			entityManager.getTransaction().begin();
			entityManager.persist(usuario);
			entityManager.getTransaction().commit();
			Mensagem.usuarioSalvo();

		} catch (PersistenceException e) {
			Mensagem.bancoErro(e);
		} finally {
			entityManager.close();
			entityManagerFactory.close();
		}
	}

	public static void excluirUsuario(long id) {

		EntityManagerFactory entityManagerFactory = null;
		EntityManager entityManager = null;
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("projetoP2JPA");
			entityManager = entityManagerFactory.createEntityManager();

			Usuario usuario = entityManager.find(Usuario.class, id);
			System.out.println(usuario);

			entityManager.getTransaction().begin();
			entityManager.remove(usuario);
			entityManager.getTransaction().commit();
			Mensagem.usuarioExcluir();

		} catch (PersistenceException e) {
			Mensagem.bancoErro();
		} finally {
			entityManager.close();
			entityManagerFactory.close();
		}
	}

	public static Usuario existeUsuario(long id) {
		Usuario usuario = null;
		EntityManager entityManager = null;
		EntityManagerFactory entityManagerFactory = null;

		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("projetoP2JPA");
			entityManager = entityManagerFactory.createEntityManager();
			
			entityManager.getTransaction().begin();
			usuario = entityManager.find(Usuario.class, id);
			entityManager.getTransaction().commit();
			

		} catch (PersistenceException e) {
			Mensagem.bancoErro(e);
		}catch(IllegalArgumentException e) {
			Mensagem.bancoErro(e);
		} finally {
			entityManagerFactory.close();
			entityManager.close();
		}
		return usuario;
	}
}
