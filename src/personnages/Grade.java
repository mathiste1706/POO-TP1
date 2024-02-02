package personnages;

public enum Grade { 
	SOLDAT("soldat"), TESSERARIUS("tesserarius"), OPTIO("optio"), CENTURION("centurion");
	
	private String chaine;
	private Grade(String chaine) {
	this.chaine = chaine;
	}
	@Override
	public String toString() {
	return chaine;
	}
}
