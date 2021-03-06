package org.mf.modelView;


import java.util.Arrays;
import java.util.Date;

import org.mf.model.Campo;


public class PrenoRow implements Comparable<PrenoRow> {

	private int personaId;
	private Campo campo;
	private Date data;
	private int primaOra;
	private int ultimaOra;
	private PrenoHour[] preno;
	private int oraMin;
	
	public PrenoRow(int personaId, Campo campo, Date data, int primaOra, int ultimaOra, int oraMin) {
		super();
		this.personaId = personaId;
		this.campo = campo;
		this.data = data;
		this.primaOra = primaOra;
		this.ultimaOra = ultimaOra;
		this.oraMin = oraMin;
		preno = new PrenoHour[ultimaOra >= primaOra ? ultimaOra-primaOra : 0];
		
		for (int i = 0; i < preno.length; i++) {
			preno[i] = new PrenoHour(campo.getStato(i + primaOra), i + primaOra, i + primaOra <= oraMin);
		}
	}
	
	
	public int getPersonaId() {
		return personaId;
	}

	public Date getData() {
		return data;
	}
	
	public int length() {
		return preno.length;
	}
	
	/**
	 * 
	 * @param hh ora assoluta
	 * @param personaId
	 */
	public void reserveOneHour(int hh, int personaId, String utente) {
		if (hh >= primaOra) {
			preno[hh-primaOra].setPersonaId(personaId);
			preno[hh-primaOra].setStato(this.personaId == personaId ? PrenoState.MiaPreno : PrenoState.Occupato);
			preno[hh-primaOra].setUtente(utente);
			preno[hh-primaOra].setPast(hh<=oraMin);	//ora inferiore all'ora minima utilizzabile (nel passato)
		}
	}

	public Campo getCampo() {
		return campo;
	}

	public int getOraMin() {
		return oraMin;
	}
	
	public int getPrimaOra() {
		return primaOra;
	}

	public int getUltimaOra() {
		return ultimaOra;
	}

	public PrenoHour[] getPreno() {
		return preno;
	}
	
	public int[] getPrenoHead() {
		int[] head = new int[preno.length];
		for (int i = 0; i < head.length; i++) {
			head[i] = i + primaOra;
		}
		return head;
	}
	
//	public PrenoState[] getPrenoColored() {
//		PrenoState[] c = new PrenoState[preno.length];
//		for (int i = 0; i < preno.length; i++) {
//			if (preno[i] < 0)
//				c[i] = PrenoState.Indisponibile;
//			else if (preno[i] == 0)
//				c[i] = PrenoState.Libero;
//			else if (preno[i] == personaId)
//				c[i] = PrenoState.MiaPreno;
//			else
//				c[i] = PrenoState.Occupato;
//		}
//		return c;
//	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((campo == null) ? 0 : campo.hashCode());
		result = prime * result + ((data == null) ? 0 : data.hashCode());
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
		PrenoRow other = (PrenoRow) obj;
		if (campo == null) {
			if (other.campo != null)
				return false;
		} else if (!campo.equals(other.campo))
			return false;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PrenoRow [campo=" + campo + ", data=" + data + ", preno="
				+ Arrays.toString(preno) + "]";
	}

	@Override
	public int compareTo(PrenoRow o) {
		return getCampo().compareTo(o.getCampo());
	}
	

}
