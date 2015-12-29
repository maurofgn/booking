package org.mf.model;

import java.util.Date;

public class Persona {

	private Integer id;
	private String nome;
	private String cognome;
	private String citta;
	private String prov;
	private String indirizzo;
	private String telefono;
	private String mail;
	private String codFisc;
	private String psw;
	private String utente;
	private String ruolo;
	private Date nascita;
	private String sesso;
	
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
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
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
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getCodFisc() {
		return codFisc;
	}
	public void setCodFisc(String codFisc) {
		this.codFisc = codFisc;
	}
	public String getPsw() {
		return psw;
	}
	public void setPsw(String psw) {
		this.psw = psw;
	}
	public String getUtente() {
		return utente;
	}
	public void setUtente(String utente) {
		this.utente = utente;
	}
	public String getRuolo() {
		return ruolo;
	}
	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}
	public Date getNascita() {
		return nascita;
	}
	public void setNascita(Date nascita) {
		this.nascita = nascita;
	}
	public String getSesso() {
		return sesso;
	}
	public void setSesso(String sesso) {
		this.sesso = sesso;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((citta == null) ? 0 : citta.hashCode());
		result = prime * result + ((codFisc == null) ? 0 : codFisc.hashCode());
		result = prime * result + ((cognome == null) ? 0 : cognome.hashCode());
		result = prime * result + ((indirizzo == null) ? 0 : indirizzo.hashCode());
		result = prime * result + ((nascita == null) ? 0 : nascita.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((prov == null) ? 0 : prov.hashCode());
		result = prime * result + ((sesso == null) ? 0 : sesso.hashCode());
		result = prime * result + ((utente == null) ? 0 : utente.hashCode());
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
		Persona other = (Persona) obj;
		if (citta == null) {
			if (other.citta != null)
				return false;
		} else if (!citta.equals(other.citta))
			return false;
		if (codFisc == null) {
			if (other.codFisc != null)
				return false;
		} else if (!codFisc.equals(other.codFisc))
			return false;
		if (cognome == null) {
			if (other.cognome != null)
				return false;
		} else if (!cognome.equals(other.cognome))
			return false;
		if (indirizzo == null) {
			if (other.indirizzo != null)
				return false;
		} else if (!indirizzo.equals(other.indirizzo))
			return false;
		if (nascita == null) {
			if (other.nascita != null)
				return false;
		} else if (!nascita.equals(other.nascita))
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
		if (sesso == null) {
			if (other.sesso != null)
				return false;
		} else if (!sesso.equals(other.sesso))
			return false;
		if (utente == null) {
			if (other.utente != null)
				return false;
		} else if (!utente.equals(other.utente))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Persona [nome=" + nome + ", cognome=" + cognome + ", citta="
				+ citta + ", prov=" + prov + ", indirizzo=" + indirizzo
				+ ", telefono=" + telefono + ", codFisc=" + codFisc
				+ ", nascita=" + nascita + "]";
	}
	
	

}
