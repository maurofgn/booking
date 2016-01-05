package org.mf.modelView;

public enum PrenoState {
	
	Libero, Occupato, MiaPreno, Indisponibile;
	private static PrenoState[] allValues = values();
	public static PrenoState fromOrdinal(int n) {return allValues[n];}
	
	public Color getColor() {
		Color retValue = Color.WHITE;
		switch (this) {
		case Libero:
			retValue = Color.GREEN;	
			break;
		case Occupato:
			retValue = Color.RED;	
			break;
		case MiaPreno:
			retValue = Color.LIGHTBLUE;	
			break;
		case Indisponibile:
			retValue = Color.GREY;	
			break;
		}
		
		return retValue;
		
	}
}
