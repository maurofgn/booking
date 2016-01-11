package org.mf.modelView;

import java.util.Date;

public class PrenoList {

	private Date data; 
	private Integer societaId;
	private String societa; 
	private Integer campoId;
	private String campo;
	private Fondo fondo; 
	private Integer ora; 
	private Integer personaId;
	private String nome; 
	private String cognome; 
	private Date nascita; 
	private Integer etaDay; 
	private Integer etaYear; 
	private Integer socioId;
	private Integer tessera; 
	private Integer ggDue; 
	private Date scadenza; 
	private Integer annoInizio;
	
	
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Integer getSocietaId() {
		return societaId;
	}
	public void setSocietaId(Integer societaId) {
		this.societaId = societaId;
	}
	public String getSocieta() {
		return societa;
	}
	public void setSocieta(String societa) {
		this.societa = societa;
	}
	public Integer getCampoId() {
		return campoId;
	}
	public void setCampoId(Integer campoId) {
		this.campoId = campoId;
	}
	public String getCampo() {
		return campo;
	}
	public void setCampo(String campo) {
		this.campo = campo;
	}
	public Fondo getFondo() {
		return fondo;
	}
	public void setFondo(Fondo fondo) {
		this.fondo = fondo;
	}
	public Integer getOra() {
		return ora;
	}
	public void setOra(Integer ora) {
		this.ora = ora;
	}
	public Integer getPersonaId() {
		return personaId;
	}
	public void setPersonaId(Integer personaId) {
		this.personaId = personaId;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public Date getNascita() {
		return nascita;
	}
	public void setNascita(Date nascita) {
		this.nascita = nascita;
	}
	public Integer getEtaDay() {
		return etaDay;
	}
	public void setEtaDay(Integer etaDay) {
		this.etaDay = etaDay;
	}
	public Integer getEtaYear() {
		return etaYear;
	}
	public void setEtaYear(Integer etaYear) {
		this.etaYear = etaYear;
	}
	public Integer getSocioId() {
		return socioId;
	}
	public void setSocioId(Integer socioId) {
		this.socioId = socioId;
	}
	public Integer getTessera() {
		return tessera;
	}
	public void setTessera(Integer tessera) {
		this.tessera = tessera;
	}
	
	public boolean tesseraScaduta() {
		return ggDue > 0;
	}
	
	public Integer getGgDue() {
		return ggDue;
	}
	public void setGgDue(Integer ggDue) {
		this.ggDue = ggDue;
	}
	public Date getScadenza() {
		return scadenza;
	}
	public void setScadenza(Date scadenza) {
		this.scadenza = scadenza;
	}
	public Integer getAnnoInizio() {
		return annoInizio;
	}
	public void setAnnoInizio(Integer annoInizio) {
		this.annoInizio = annoInizio;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((campoId == null) ? 0 : campoId.hashCode());
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((ora == null) ? 0 : ora.hashCode());
		result = prime * result
				+ ((societaId == null) ? 0 : societaId.hashCode());
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
		PrenoList other = (PrenoList) obj;
		if (campoId == null) {
			if (other.campoId != null)
				return false;
		} else if (!campoId.equals(other.campoId))
			return false;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (ora == null) {
			if (other.ora != null)
				return false;
		} else if (!ora.equals(other.ora))
			return false;
		if (societaId == null) {
			if (other.societaId != null)
				return false;
		} else if (!societaId.equals(other.societaId))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "PrenoList [data=" + data + ", campo=" + campo + ", fondo="
				+ fondo + ", ora=" + ora + ", nome=" + nome + ", cognome="
				+ cognome + "]";
	} 
	

}
