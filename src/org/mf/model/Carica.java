package org.mf.model;

import org.mf.modelView.Cariche;

public class Carica {

	private int id;
	private Cariche tipo;
	private Societa societa;
	private Persona persona;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Cariche getTipo() {
		return tipo;
	}
	public void setTipo(Cariche tipo) {
		this.tipo = tipo;
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
		result = prime * result + ((persona == null) ? 0 : persona.hashCode());
		result = prime * result + ((societa == null) ? 0 : societa.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
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
		Carica other = (Carica) obj;
		if (persona == null) {
			if (other.persona != null)
				return false;
		} else if (!persona.equals(other.persona))
			return false;
		if (societa == null) {
			if (other.societa != null)
				return false;
		} else if (!societa.equals(other.societa))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Carica [tipo=" + tipo + ", persona=" + persona + "]";
	}	
	
	
}
