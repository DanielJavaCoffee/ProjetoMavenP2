package projetoMaven.DAO;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import projetoMaven.Mensagem.Mensagem;
import projetoMaven.entity.Usuario;

public class UsuarioDAO {

	public static void saveUpDate(Usuario usuario) {

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

	public static void excluirUsuario(Long id) {

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
		} catch (NumberFormatException e) {
			Mensagem.bancoBuscarPorLetra(e);
		}
	}

	public static Usuario existeUsuario(Long id) {
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
		} catch (IllegalArgumentException e) {
			Mensagem.bancoErro(e);
		} catch (Exception e) {
			Mensagem.exception(e);
		} finally {
			entityManagerFactory.close();
			entityManager.close();
		}
		return usuario;
	}

	public static boolean login(String email, String senha) {

		boolean autenticado = false;
		Usuario usuario = null;
		EntityManager entityManager = null;
		EntityManagerFactory entityManagerFactory = null;

		try {

			entityManagerFactory = Persistence.createEntityManagerFactory("projetoP2JPA");
			entityManager = entityManagerFactory.createEntityManager();

			entityManager.getTransaction().begin();
			
			String sql = "select id from usuario where email = ? and senha = ?";
			Query query = entityManager.createNativeQuery(sql);
			query.setParameter(1, email);
			query.setParameter(2, senha);
			BigInteger id = (BigInteger) query.getSingleResult();
			if(id != null) {	
				autenticado = true;
			} 

			entityManager.getTransaction().commit();

		} catch (PersistenceException e) {
			Mensagem.bancoErro(e);
		} catch (IllegalArgumentException e) {
			Mensagem.bancoErro(e);
		} finally {
			entityManagerFactory.close();
			entityManager.close();
		}
		
		return autenticado;
	}
	

	@SuppressWarnings("unchecked")
	public static List<Usuario> findAll() {
		EntityManager entityManager = null;
		EntityManagerFactory entityManagerFactory = null;
		List<Usuario> usuarios = null;
		try {
			
			entityManagerFactory = Persistence.createEntityManagerFactory("projetoP2JPA");
			entityManager = entityManagerFactory.createEntityManager();
			entityManager.getTransaction().begin();
			usuarios = entityManager.createQuery("from Usuario").getResultList();
			entityManager.getTransaction().commit();

		} catch (Exception e) {
			Mensagem.exception(e);
		} finally {
			entityManagerFactory.close();
			entityManager.close();
		}
		return usuarios;
	}
}
