
package models;

public enum KindInstitution {
    SELECCIONE("MANAGER"),
    NINGUNA("PROFESOR "),
	PUBLICA("PUBLICA"),
	UNIVERSIDAD("PROFESIONAL"),
	COLEGIO("PROFESIONAL"),
	PRIVADA("PRIVADA"),
        OFICIAL("OFICIAL");


	private final String name;
	
	private KindInstitution(String name) {
		this.name = name;
	}

	public String toSpanish() {
		return name;
	}
	
	@Override
	public String toString() {
		return toSpanish();
	}
}
