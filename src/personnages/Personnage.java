package personnages;

public abstract class Personnage {

private String nom;
private int force;

public String getNom() {
	return nom;
}

public Personnage(String nom, int force){
	this.nom=nom;
	this.force=force;
}

protected abstract String donnerAuteur();

public void parler(String texte) {
	String auteur=donnerAuteur();
	System.out.println(auteur+" "+nom+": "+"\""+texte+"\".");
}

public int frapper(Personnage personnage) {
	System.out.println("Le "+nom+" envoie un grand coup dans la machoire du "+personnage.donnerAuteur()+" "+personnage.getNom());
	return (force/3);
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
}