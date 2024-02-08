package personnages;

public enum Equipement {
	BOUCLIER("bouclier", 3), CASQUE("casque", 2), PLASTRON("plastron",3);
	
	private String nom;
	private int defense;
	private Equipement(String nom, int defense) {
	this.nom = nom;
	this.defense=defense;
	}
	
	public String getNom() {
	return nom;
	}
	
	public int getDefense() {
		return defense;
	}

}
