package org.mf.model;

public class Societa {

	private int id;
	private String nome;
	private String citta;
	private String prov;
	private String indirizzo;
	private String codiceFederale;
	private Integer giorniRitardoAmmesso;
	private String site;
	private String mail;
	private Persona persona;
	
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
	public String getCitta() {
		return citta;
	}
	public void setCitta(String citta) {
		this.citta = citta;
	}
	public String getProv() {
		return prov;
	}
	public void setProv(String prov) {
		this.prov = prov;
	}
	public String getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	public String getCodiceFederale() {
		return codiceFederale;
	}
	public void setCodiceFederale(String codiceFederale) {
		this.codiceFederale = codiceFederale;
	}
	public Integer getGiorniRitardoAmmesso() {
		return giorniRitardoAmmesso;
	}
	public void setGiorniRitardoAmmesso(Integer giorniRitardoAmmesso) {
		this.giorniRitardoAmmesso = giorniRitardoAmmesso;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
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
		result = prime * result + ((citta == null) ? 0 : citta.hashCode());
		result = prime * result
				+ ((codiceFederale == null) ? 0 : codiceFederale.hashCode());
		result = prime * result
				+ ((indirizzo == null) ? 0 : indirizzo.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((prov == null) ? 0 : prov.hashCode());
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
		Societa other = (Societa) obj;
		if (citta == null) {
			if (other.citta != null)
				return false;
		} else if (!citta.equals(other.citta))
			return false;
		if (codiceFederale == null) {
			if (other.codiceFederale != null)
				return false;
		} else if (!codiceFederale.equals(other.codiceFederale))
			return false;
		if (indirizzo == null) {
			if (other.indirizzo != null)
				return false;
		} else if (!indirizzo.equals(other.indirizzo))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (prov == null) {
			if (other.prov != null)
				return false;
		} else if (!prov.equals(other.prov))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Societa [nome=" + nome + ", citta=" + citta
				+ ", codiceFederale=" + codiceFederale + "]";
	}

}
