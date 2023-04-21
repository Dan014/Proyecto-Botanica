
package models;

public enum SuitableCyty {
    
    SELECCIONE(" "),
    COLOMBIA("SI "),
	PERU("NO");

	private final String name;
	
	private SuitableCyty(String name) {
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
