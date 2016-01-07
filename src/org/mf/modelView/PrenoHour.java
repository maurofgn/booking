package org.mf.modelView;

public class PrenoHour {
	
	private PrenoState stato;
	private int personaId;
	private int hour;
	
	public PrenoHour() {
		this(PrenoState.Indisponibile);
	}
	
	public PrenoHour(PrenoState stato) {
		super();
		this.stato = stato;
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
	
}
