package personnages;

public class Romain extends Personnage {

public Romain(String nom, int force){
	super(nom, force);
}

protected String donnerAuteur() {
	return "romain";
}
}
