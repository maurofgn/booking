package org.mf.model;

import org.mf.modelView.Cariche;

public class Carica {

	private int id;
	private Cariche tipo;
	private Integer societaId;
	private Integer personaId;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Cariche getTipo() {
		return tipo;
	}
	public void setTipo(Cariche tipo) {
		this.tipo = tipo;
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result
				+ ((personaId == null) ? 0 : personaId.hashCode());
		result = prime * result
				+ ((societaId == null) ? 0 : societaId.hashCode());
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
		if (id != other.id)
			return false;
		if (personaId == null) {
			if (other.personaId != null)
				return false;
		} else if (!personaId.equals(other.personaId))
			return false;
		if (societaId == null) {
			if (other.societaId != null)
				return false;
		} else if (!societaId.equals(other.societaId))
			return false;
		if (tipo != other.tipo)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Carica [tipo=" + tipo + ", societaId=" + societaId
				+ ", personaId=" + personaId + "]";
	}
	

}
