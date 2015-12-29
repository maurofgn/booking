package org.mf.model;

import java.util.Date;

public class Socio {

	private int id;
	private Integer tessera;
	private Integer annoInizio;
	private Date scadenza;
	private Societa societa;
	private Persona persona;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getTessera() {
		return tessera;
	}
	public void setTessera(Integer tessera) {
		this.tessera = tessera;
	}
	public Integer getAnnoInizio() {
		return annoInizio;
	}
	public void setAnnoInizio(Integer annoInizio) {
		this.annoInizio = annoInizio;
	}
	public Date getScadenza() {
		return scadenza;
	}
	public void setScadenza(Date scadenza) {
		this.scadenza = scadenza;
	}
	public Societa getSocieta() {
		return societa;
	}
	public void setSocieta(Societa societa) {
		this.societa = societa;
	}
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((societa == null) ? 0 : societa.hashCode());
		result = prime * result + ((tessera == null) ? 0 : tessera.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Socio other = (Socio) obj;
		if (societa == null) {
			if (other.societa != null)
				return false;
		} else if (!societa.equals(other.societa))
			return false;
		if (tessera == null) {
			if (other.tessera != null)
				return false;
		} else if (!tessera.equals(other.tessera))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Socio [tessera=" + tessera + ", annoInizio=" + annoInizio
				+ ", scadenza=" + scadenza + ", societa=" + societa
				+ ", persona=" + persona + "]";
	}
	
	

}
