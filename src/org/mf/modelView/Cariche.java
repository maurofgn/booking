package org.mf.modelView;

public enum Cariche {
	Presidente, Vicepresidente, Segretario, Probiviro, Consigliere;
	
	private static Cariche[] allValues = values();
	public static Cariche fromOrdinal(int n) {return allValues[n];}
}
