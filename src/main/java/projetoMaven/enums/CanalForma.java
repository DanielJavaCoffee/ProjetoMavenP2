package projetoMaven.enums;

public enum CanalForma {

	CANAL_ABERTO("Canal Aberto"), 
	BROADCASTING("Broadcasting"), 
    PACOTE_DE_ASSINATURA("Pacote De Assinatura"),
    ASSINATURA_INDIVIDUAL_DE_TELEVISAO("Assinatura Individual De televisão"), 
	ASSINATURA_INDIVIDUAL_DE_BROADCASTING("Assinatura Individual De Broadcasting");
	
	private String label;
		
	private CanalForma(String label) {
		this.label = label;
	}
	
	public String getLabel() {
		return label;
	}
}
