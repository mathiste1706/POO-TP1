package personnages;

public class Gaulois extends Personnage {


public Gaulois(String nom, int force){
	super(nom, force);
}

protected String donnerAuteur() {
	return "gaulois";
}
}

