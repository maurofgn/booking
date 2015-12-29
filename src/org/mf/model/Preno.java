package org.mf.model;

import java.util.Date;

public class Preno {

	private Date data;
	private Integer ora;
	private Integer nrOre;
	private Campo campo;
	private Socio socio;
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Integer getOra() {
		return ora;
	}
	public void setOra(Integer ora) {
		this.ora = ora;
	}
	public Integer getNrOre() {
		return nrOre;
	}
	public void setNrOre(Integer nrOre) {
		this.nrOre = nrOre;
	}
	public Campo getCampo() {
		return campo;
	}
	public void setCampo(Campo campo) {
		this.campo = campo;
	}
	public Socio getSocio() {
		return socio;
	}
	public void setSocio(Socio socio) {
		this.socio = socio;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((campo == null) ? 0 : campo.hashCode());
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((nrOre == null) ? 0 : nrOre.hashCode());
		result = prime * result + ((ora == null) ? 0 : ora.hashCode());
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
		Preno other = (Preno) obj;
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
		if (nrOre == null) {
			if (other.nrOre != null)
				return false;
		} else if (!nrOre.equals(other.nrOre))
			return false;
		if (ora == null) {
			if (other.ora != null)
				return false;
		} else if (!ora.equals(other.ora))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Preno [data=" + data + ", ora=" + ora + ", nrOre=" + nrOre
				+ ", campo=" + campo + ", socio=" + socio + "]";
	}
	
	

}
