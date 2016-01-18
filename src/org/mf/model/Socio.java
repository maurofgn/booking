package org.mf.model;

import java.util.Date;

public class Socio {

	private int id;
	private Integer tessera;
	private Integer annoInizio;
	private Date scadenza;
	private Integer societaId;
	private Integer personaId;
	private Persona persona;
	private Societa societa;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public Integer getSocietaId() {
		return societaId;
	}
	public void setSocietaId(Integer societaId) {
		this.societaId = societaId;
	}
	public Integer getPersonaId() {
		return personaId;
	}
	public void setPersonaId(Integer personaId) {
		this.personaId = personaId;
	}
	
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	public Persona getPersona() {
		return persona;
	}
	
	public void setSocieta(Societa societa) {
		this.societa = societa;
	}
	public Societa getSocieta() {
		return societa;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((annoInizio == null) ? 0 : annoInizio.hashCode());
		result = prime * result + id;
		result = prime * result
				+ ((personaId == null) ? 0 : personaId.hashCode());
		result = prime * result
				+ ((scadenza == null) ? 0 : scadenza.hashCode());
		result = prime * result
				+ ((societaId == null) ? 0 : societaId.hashCode());
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
		if (annoInizio == null) {
			if (other.annoInizio != null)
				return false;
		} else if (!annoInizio.equals(other.annoInizio))
			return false;
		if (id != other.id)
			return false;
		if (personaId == null) {
			if (other.personaId != null)
				return false;
		} else if (!personaId.equals(other.personaId))
			return false;
		if (scadenza == null) {
			if (other.scadenza != null)
				return false;
		} else if (!scadenza.equals(other.scadenza))
			return false;
		if (societaId == null) {
			if (other.societaId != null)
				return false;
		} else if (!societaId.equals(other.societaId))
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
		return "Socio [id=" + id + ", tessera=" + tessera + ", annoInizio="
				+ annoInizio + ", scadenza=" + scadenza + ", societaId="
				+ societaId + ", personaId=" + personaId + "]";
	}
	
}
