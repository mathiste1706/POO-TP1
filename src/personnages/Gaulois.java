package personnages;

public class Gaulois extends Personnage {


public Gaulois(String nom, int force){
	super(nom, force);
}

protected String donnerAuteur() {
	return "gaulois";
}

public void recevoirPotion(int forcePotion) {
	force*=forcePotion;
	//?
	forcePotion-=0.5;
	
	
}

public int frapper(Personnage personnage) {
	System.out.println("Le "+donnerAuteur()+" "+personnage.getNom()+" envoie un grand coup dans la machoire du "+personnage.donnerAuteur()+" "+personnage.getNom());
	return (force/3);
}
}

