package projetoMaven.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import projetoMaven.enums.CanalForma;

@Entity
public class Canal implements Serializable{

	private static final long serialVersionUID = 4016689312543956378L;
	@Id
	private long id;
	private String nomeDoCanal;
	private CanalForma formaDeAssitir;
	private String numeroDoCanalOuLink;
	
	public Canal() {
		this.id = System.currentTimeMillis();
	}
	
	public Canal(String nome, CanalForma forma, String numeroDoCanal) {
		this.nomeDoCanal = nome;
		this.formaDeAssitir = forma;
		this.numeroDoCanalOuLink = numeroDoCanal;
		this.id = System.currentTimeMillis();
	}

	public String getNomeDoCanal() {
		return nomeDoCanal;
	}

	public void setNomeDoCanal(String nomeDoCanal) {
		this.nomeDoCanal = nomeDoCanal;
	}

	public CanalForma getCanalForma() {
		return formaDeAssitir;
	}

	public void setCanalForma(CanalForma forma) {
		this.formaDeAssitir = forma;
	}

	public String getNumeroDoCanal() {
		return numeroDoCanalOuLink;
	}

	public void setNumeroDoCanal(String numeroDoCanal) {
		this.numeroDoCanalOuLink = numeroDoCanal;
	}

	public long getId() {
		return id;
	}
}
