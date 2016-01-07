package org.mf.modelView;

public class PrenoHourJson {

	private int campo;
	private int ora;
	private PrenoState stato;
	private boolean checked;
	
	public int getCampo() {
		return campo;
	}
	public void setCampo(int campo) {
		this.campo = campo;
	}
	public int getOra() {
		return ora;
	}
	public void setOra(int ora) {
		this.ora = ora;
	}
	public PrenoState getStato() {
		return stato;
	}
	public void setStato(PrenoState stato) {
		this.stato = stato;
	}
	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	
	@Override
	public String toString() {
		return "PrenoHourJson [campo=" + campo + ", ora=" + ora + ", stato="
				+ stato + ", checked=" + checked + "]";
	}
	
	

}
