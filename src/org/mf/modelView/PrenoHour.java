package org.mf.modelView;

public class PrenoHour {
	
	PrenoState stato;
	int personaId;
	
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
	
	

}
