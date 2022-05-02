package projetoMaven.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Programa implements Comparable<Programa> {

	@Column
	private String nomeDoPrograma;
	@Column
	private Canal canal;
	@Column
	private Date dataDoPrograma;
	@Column
	private String horario;
	@Id
	private Long id;
	
	public Programa() {
		
	}
	
	public Programa(String nomeDoPrograma, Canal canal, Date dateDeNascimento, String horario ) {
		this.nomeDoPrograma = nomeDoPrograma;
		this.canal = canal;
		this.dataDoPrograma = dateDeNascimento;
		this.horario = horario;
	}
	
	public String toString() { 
		return "Nome Do Canal: " + this.nomeDoPrograma + " Canal: " + this.canal + " Data De exebição: " + this.dataDoPrograma +
				" Horario: " + this.horario;			
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

	public int compareTo(Programa o) {
	
		return 0;
	}
}
