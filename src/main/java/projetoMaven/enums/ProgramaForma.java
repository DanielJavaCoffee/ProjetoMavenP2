package projetoMaven.enums;

public enum ProgramaForma {

	SERIES_REGULARES("s�ries regulares"),
	REALITY_SHOWS("reality shows"),
	PROGRAMA_CONTINUOS("programas cont�nuos");
	
	private String label;
	
	private ProgramaForma(String label) {
		this.label = label;
	}
	
	public String getLabel() {
		return label;
	}
}
