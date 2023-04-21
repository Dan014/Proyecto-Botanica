
package models;

public enum KindBotanic {
    
    SELECCIONE(" "),
    PROFESOR("PROFESOR "),
	ESTUDIANTE("ESTUDIANTE"),
	PROFESIONAL("PROFESIONAL");

	private final String name;
	
	private KindBotanic(String name) {
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
