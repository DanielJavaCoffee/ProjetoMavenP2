package projetoMaven.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Programa implements Comparable<Programa> {

	@Column
	private String nomeDoPrograma;
	private Canal canal;
	@Column
	private Date dataDoPrograma;
	@Column
	private String horario;
	@Column
	private String nomeDoCanal;
	@Id
	private Long id;
	
	public Programa() {
		this.id = System.currentTimeMillis();
	}
	
	public Programa(String nomeDoPrograma, Canal canal, Date dataDoPrograma, String horario) {
		this.nomeDoPrograma = nomeDoPrograma;
		this.canal = canal;
		this.dataDoPrograma = dataDoPrograma;
		this.horario = horario;
		this.id = System.currentTimeMillis();
	}
	
	public Programa(String nomeDoPrograma, String nomeDoCanal, Date dataDoPrograma, String horario) {
		this.nomeDoPrograma = nomeDoPrograma;
		this.nomeDoCanal = nomeDoCanal; 
		this.dataDoPrograma = dataDoPrograma;
		this.horario = horario;
		this.id = System.currentTimeMillis();
	}
	
	public String toString() { 
		return "Nome Do Canal: " + this.nomeDoPrograma + " Nome Do Canal Canal: " + this.canal.getNomeDoCanal() + " Data De exebição: " + this.dataDoPrograma + " Horario: " + this.horario;			
	}
	
	public String getNomeDoPrograma() {
		return nomeDoPrograma;
	}

	public void setNomeDoPrograma(String nomeDoPrograma) {
		this.nomeDoPrograma = nomeDoPrograma;
	}

	public Canal getCanal() {
		return canal;
	}

	public void setCanal(Canal canal) {
		this.canal = canal;
	}

	public Date getDataDoPrograma() {
		return dataDoPrograma;
	}

	public void setDataDoPrograma(Date dataDoPrograma) {
		this.dataDoPrograma = dataDoPrograma;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public Long getId() {
		return id;
	}

	public String getNomeDoCanal() {
		return nomeDoCanal;
	}

	public void setNomeDoCanal(String nomeDoCanal) {
		this.nomeDoCanal = nomeDoCanal;
	}

	public int compareTo(Programa o) {
		return 0;
	}
}
