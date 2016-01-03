package org.mf.model;

public class Campo {

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
	
	@Override
	public String toString() {
		return "Campo [nome=" + nome + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((societa_Id == null) ? 0 : societa_Id.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
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
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (societa_Id == null) {
			if (other.societa_Id != null)
				return false;
		} else if (!societa_Id.equals(other.societa_Id))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		return true;
	}
	
	

}
