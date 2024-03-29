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

protected Personnage(String nom, int force){
	this.nom=nom;
	this.force=force;
}

protected abstract String donnerAuteur();

public String parler(String texte) {
	String auteur=donnerAuteur();
	return "Le "+auteur+" "+nom+": "+"\""+texte+"\".\n";
}

public String frapper(Personnage personnage) {
	String recevoirCoupTexte=personnage.recevoirCoup(force);
	return "Le "+donnerAuteur()+" "+nom+" envoie un grand coup de force "+force+ " dans la machoire du "+personnage.donnerAuteur()+" "
			+personnage.getNom()+"\n"+ recevoirCoupTexte;
}

public String recevoirCoup(int forceCoup) {
	force-=forceCoup;
	String texte="";
	if (force<0) {
		force=0;
	}
	if (force>0) {
		texte=parler("Aie!");
	}
	else {
		texte=parler("J'abandonne...");
	}
	return texte;
}

public boolean estATerre() {
	boolean estATerre;
	if (force>0) {
		estATerre= false;
	}
	else {
		estATerre= true;
	}
	return estATerre;
	
}
}