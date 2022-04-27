package projetoMaven.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Usuario implements Serializable {
	

	private static final long serialVersionUID = 4016689312543956378L;
	private String nome;
	private String email;
	private String senha;
	@Id	
	private long id;
	public Usuario() {
		
	}

	public Usuario(String nome, String email, String senha) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.id = System.currentTimeMillis();
	}

	public String toString() {
		return "Nome: " + this.nome + " Emael: " + this.email + "Senha:" + this.senha + "ID: " + this.id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public long getId() {
		return id;
	}
}
