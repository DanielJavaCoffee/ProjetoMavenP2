package projetoMaven.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Canal implements Serializable{

	private static final long serialVersionUID = 4016689312543956378L;
	@Id
	private long id;
	@Column
	private String nomeDoCanal;
	@Column
	private String numeroDoCanal;
	@Column
	private String forma;
	@Column
	private String linkDocanal;
	
	public Canal() {
		this.id = System.currentTimeMillis();
	}
	
	public Canal(String nome, String forma, String numeroDoCanal, String linkDoCanal) {
		this.nomeDoCanal = nome;
		this.forma = forma;
		this.numeroDoCanal = numeroDoCanal;
		this.linkDocanal = linkDoCanal;
		this.id = System.currentTimeMillis();
	}

	public String getNomeDoCanal() {
		return nomeDoCanal;
	}

	public void setNomeDoCanal(String nomeDoCanal) {
		this.nomeDoCanal = nomeDoCanal;
	}

	public String getNumeroDoCanal() {
		return numeroDoCanal;
	}

	public void setNumeroDoCanal(String numeroDoCanal) {
		this.numeroDoCanal = numeroDoCanal;
	}

	public String getForma() {
		return forma;
	}

	public void setForma(String forma) {
		this.forma = forma;
	}
	
	public String getLinkDocanal() {
		return linkDocanal;
	}

	public void setLinkDocanal(String linkDocanal) {
		this.linkDocanal = linkDocanal;
	}

	public long getId() {
		return id;
	}
}
