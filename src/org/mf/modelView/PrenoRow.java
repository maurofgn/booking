package org.mf.modelView;


import java.util.Arrays;
import java.util.Date;

import org.mf.model.Campo;


public class PrenoRow implements Comparable<PrenoRow> {

	private int socioId;
	private Campo campo;
	private Date data;
	private int primaOra;
	private int ultimaOra;
	private int[] preno;
	
	public PrenoRow(int socioId, Campo campo, Date data, int primaOra, int ultimaOra) {
		super();
		this.socioId = socioId;
		this.campo = campo;
		this.data = data;
		this.primaOra = primaOra;
		this.ultimaOra = ultimaOra;
		preno = new int[ultimaOra >= primaOra ? ultimaOra-primaOra : 0];
		
		for (int i = 0; i < preno.length; i++) {
			if (i + primaOra < campo.getAperturaOra())
				preno[i] = -1;
			else if (i + primaOra >=campo.getIntervalloOra() && i + primaOra < campo.getIntervalloOra() + campo.getIntervalloOre())
				preno[i] = -1;
			else if (i + primaOra >=campo.getChiusuraOra())
				preno[i] = -1;
			else
				preno[i] = 0;
		}
	}
	
	
	public int getSocioId() {
		return socioId;
	}

	public Date getData() {
		return data;
	}
	
	public int length() {
		return preno.length;
	}
	
	public void addOneHour(int hh, int personaId) {
		if (hh>=primaOra)
			preno[hh-primaOra] = personaId;
	}

	public Campo getCampo() {
		return campo;
	}

	public int getPrimaOra() {
		return primaOra;
	}

	public int getUltimaOra() {
		return ultimaOra;
	}

	public int[] getPreno() {
		return preno;
	}
	
	public int[] getPrenoHead() {
		int[] head = new int[preno.length];
		for (int i = 0; i < head.length; i++) {
			head[i] = i + primaOra;
		}
		return head;
	}
	
	public PrenoState[] getPrenoColored() {
		PrenoState[] c = new PrenoState[preno.length];
		for (int i = 0; i < preno.length; i++) {
			if (preno[i] < 0)
				c[i] = PrenoState.Indisponibile;
			else if (preno[i] == 0)
				c[i] = PrenoState.Libero;
			else if (preno[i] == socioId)
				c[i] = PrenoState.MiaPreno;
			else
				c[i] = PrenoState.Occupato;
		}
		return c;
	}



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
