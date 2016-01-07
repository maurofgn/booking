package org.mf.modelView;

import java.util.Date;

public class PrenoHoursJson {
	
	private Date data;
	private PrenoHourJson[] hours;

	public PrenoHourJson[] getHours() {
		return hours;
	}

	public void setHours(PrenoHourJson[] hours) {
		this.hours = hours;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	

}
