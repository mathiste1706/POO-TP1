package personnages;

public abstract class Personnage {

private String nom;
private int force;

public String getNom() {
	return nom;
}

public int getForce() {
	return force;
}

public void setForce(int force) {
	this.force=force;
}

public Personnage(String nom, int force){
	this.nom=nom;
	this.force=force;
}

protected abstract String donnerAuteur();

public void parler(String texte) {
	String auteur=donnerAuteur();
	System.out.println("Le "+auteur+" "+nom+": "+"\""+texte+"\".");
}

public int frapper(Personnage personnage) {
	System.out.println("Le "+donnerAuteur()+" "+nom+" envoie un grand coup de force "+force+ " dans la machoire du "+personnage.donnerAuteur()+" "+personnage.getNom());
	return (force);
}

public void recevoirCoup(int forceCoup) {
	force-=forceCoup;
	if (force<0) {
		force=0;
	}
	if (force>0) {
		parler("Aie!");
	}
	else {
		parler("J'abandonne...");
	}
}
public boolean estATerre() {
	if (force>0) {
		return false;
	}
	else {
		return true;
	}
	
}
}