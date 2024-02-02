package personnages;



public class Gaulois extends Personnage {
private double forcePotion;

public Gaulois(String nom, int force){
	super(nom, force);
	forcePotion=1;
}

protected void setForcePotion(double forcePotion) {
	this.forcePotion=forcePotion;
}

protected double getForcePotion() {
	return forcePotion;
}

protected String donnerAuteur() {
	return "gaulois";
}

public void recevoirPotion(double forcePotion) {
	setForcePotion(forcePotion);
	
	
}
@Override
public int frapper(Personnage personnage) {
	
	int forceCoup=(int)(getForce()*forcePotion);
	if (forcePotion>1) {
		forcePotion-=0.5;
		setForcePotion(forcePotion);
	}
	System.out.println("Le "+donnerAuteur()+" "+getNom()+" envoie un grand coup de force "+forceCoup+ 
			" dans la machoire du "+personnage.donnerAuteur()+" "+personnage.getNom());
	return (forceCoup);
}
}

