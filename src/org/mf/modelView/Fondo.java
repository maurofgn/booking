package org.mf.modelView;

public enum Fondo {
	Sintetico, TerraRossa, Erba;
	private static Fondo[] allValues = values();
	public static Fondo fromOrdinal(int n) {return allValues[n];}
}
