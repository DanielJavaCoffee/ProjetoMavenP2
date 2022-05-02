package projetoMaven.enums;

public enum ProgramaForma {

	SERIES_REGULARES("séries regulares"),
	REALITY_SHOWS("reality shows"),
	PROGRAMA_CONTINUOS("programas contínuos");
	
	private String label;
	
	private ProgramaForma(String label) {
		this.label = label;
	}
	
	public String getLabel() {
		return label;
	}
}
