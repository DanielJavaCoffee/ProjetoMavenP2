package projetoMaven.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Canal implements Serializable{

	private static final long serialVersionUID = 4016689312543956378L;
	@Id
	private long id;
	private String nomeDoCanal;
	private String forma;
	
	public Canal() {
		this.id = System.currentTimeMillis();
	}
	
	public Canal(String nome) {
		this.nomeDoCanal = nome;
		this.id = System.currentTimeMillis();
	}
	
	public Canal(String nome, String forma) {
		this.nomeDoCanal = nome;
		this.forma = forma;
		this.id = System.currentTimeMillis();
	}

	public String getNomeDoCanal() {
		return nomeDoCanal;
	}

	public void setNomeDoCanal(String nomeDoCanal) {
		this.nomeDoCanal = nomeDoCanal;
	}

	public String getForma() {
		return forma;
	}

	public void setForma(String forma) {
		this.forma = forma;
	}

	public long getId() {
		return id;
	}
}
