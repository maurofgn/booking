package org.mf.modelView;

public class PrenoHour {
	
	private PrenoState stato;
	private int personaId;
	private int hour;	//ora assoluta (0-23)
	
	
	public PrenoHour(PrenoState stato, int hour) {
		super();
		this.stato = stato;
		this.hour = hour;
	}

	public PrenoState getStato() {
		return stato;
	}

	public void setStato(PrenoState stato) {
		this.stato = stato;
	}

	public int getPersonaId() {
		return personaId;
	}

	public void setPersonaId(int personaId) {
		this.personaId = personaId;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getHour() {
		return hour;
	}

	@Override
	public String toString() {
		return "PrenoHour [stato=" + stato + ", personaId=" + personaId
				+ ", hour=" + hour + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + hour;
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
		PrenoHour other = (PrenoHour) obj;
		if (hour != other.hour)
			return false;
		return true;
	}
	
	
	
	
}
