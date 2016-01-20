package org.mf.model;

import java.util.Date;

import org.mf.modelView.PrenoHourJson;

public class Preno {
	

	private Integer id;
	private Date data;
	private Integer ora;
	private Integer campoId;
	private Integer socioId;
	private Date created;

	
	public Preno() {
	}

	public Preno(PrenoHourJson prenoHourJson, Integer socioId, Date data) {
		campoId = prenoHourJson.getCampo();
		ora = prenoHourJson.getOra();
		this.socioId = socioId;
		this.data = data;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
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

	public Integer getCampoId() {
		return campoId;
	}
	public void setCampoId(Integer campoId) {
		this.campoId = campoId;
	}
	public Integer getSocioId() {
		return socioId;
	}
	public void setSocioId(Integer socioId) {
		this.socioId = socioId;
	}
	
	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((campoId == null) ? 0 : campoId.hashCode());
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((ora == null) ? 0 : ora.hashCode());
		result = prime * result + ((socioId == null) ? 0 : socioId.hashCode());
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
		if (socioId == null) {
			if (other.socioId != null)
				return false;
		} else if (!socioId.equals(other.socioId))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Preno [id=" + id + ", data=" + data + ", ora=" + ora
				+ ", campoId=" + campoId + ", socioId="
				+ socioId + "]";
	}
	
}
