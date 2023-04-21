package models;

public enum KindDocument {
	
	CEDULA(1, "Cedula de ciudadania"),
	TI(2, "Tarjeta de Identidad"),
	PASAPORTE(3, "Pasaporte de extranjero"),
	NIT(4, "NIT");
	
	private int id;
	private String nombre;
	
	private KindDocument (int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}
	
}
