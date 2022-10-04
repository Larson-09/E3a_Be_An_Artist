package fr.eseo.cpoo.projet.artiste.modele;

public enum Remplissage {
	
	AUCUNE("aucune"),
	UNIFORME("uniforme");
	
	private String mode;
	private Remplissage(String mode) {
		this.mode = mode;
	}
	
	public String getMode() {
		return this.mode;
	}
		
}
