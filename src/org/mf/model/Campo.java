package org.mf.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;

import org.mf.dao.PrenoDao;
import org.mf.modelView.Fondo;

public class Campo implements Comparable<Campo> {

	private int id;
	private String nome;
	private Fondo tipo = Fondo.Sintetico;
	private String descrizione;
	private Integer aperturaOra = 8;
	private Integer aperturaMin = 0;
	private Integer chiusuraOra = 23;
	private Integer intervalloOra = 0;
	private Integer intervalloOre = 0;
	private Integer sequenza = 0;
	private Integer societa_Id;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Fondo getTipo() {
		return tipo;
	}
	public void setTipo(Fondo tipo) {
		this.tipo = tipo;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public Integer getAperturaOra() {
		return aperturaOra;
	}
	public void setAperturaOra(Integer aperturaOra) {
		this.aperturaOra = aperturaOra;
	}
	public Integer getAperturaMin() {
		return aperturaMin;
	}
	public void setAperturaMin(Integer aperturaMin) {
		this.aperturaMin = aperturaMin;
	}
	public Integer getChiusuraOra() {
		return chiusuraOra;
	}
	public void setChiusuraOra(Integer chiusuraOra) {
		this.chiusuraOra = chiusuraOra;
	}
	public Integer getIntervalloOra() {
		return intervalloOra;
	}
	public void setIntervalloOra(Integer intervalloOra) {
		this.intervalloOra = intervalloOra;
	}
	public Integer getIntervalloOre() {
		return intervalloOre;
	}
	public void setIntervalloOre(Integer intervalloOre) {
		this.intervalloOre = intervalloOre;
	}
	public Integer getSequenza() {
		return sequenza;
	}
	public void setSequenza(Integer sequenza) {
		this.sequenza = sequenza;
	}
	public Integer getSocieta_Id() {
		return societa_Id;
	}
	public void setSocieta_Id(Integer societa_Id) {
		this.societa_Id = societa_Id;
	}

	/**
	 * 
	 * @param ora
	 * @return prossima ora a partire da ora e per nrOre. Tiene conto dell'intervallo e ritorna -1 se l'ora va oltre o uguale alla chiusura
	 */
	public int getNextHour(int ora) {
		if (ora < 0)
			return ora;
		
		int next = ora + 1;
		if (next >= intervalloOra && next <= intervalloOra+intervalloOre)
			next = intervalloOra+intervalloOre;
		
		return next >= chiusuraOra ? -1 : next;
	}
	
	/**
	 * 
	 * @return lista di prenotazioni ordinate x ora, per ogni singola data, relative al campo di istanza 
	 */
	public Hashtable<Date, List<Preno>> getPreno() {
		PrenoDao prenoDao = new PrenoDao();
		
		List<Preno> prenos = prenoDao.getAll(getId());
		Hashtable<Date, List<Preno>> retValue = new  Hashtable<Date, List<Preno>>();
		
		for (Preno preno : prenos) {
			List<Preno> oneDayPreno = retValue.get(preno.getData());
			if (oneDayPreno == null) {
				oneDayPreno = new ArrayList<Preno>();
				retValue.put(preno.getData(), oneDayPreno);
			}
			oneDayPreno.add(preno);
		}
		return retValue;
	}

	
	@Override
	public String toString() {
		return "Campo [nome=" + nome + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Campo other = (Campo) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	@Override
	public int compareTo(Campo o) {
		if (getSequenza() > o.getSequenza())
			return 1;
		else if (getSequenza() < o.getSequenza())
			return -1;
		
		if (getId() > o.getId())
			return 1;
		else if (getId() < o.getId())
			return -1;
		
		return 0;
	}
	
	

}
