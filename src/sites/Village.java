package sites;

import personnages.Gaulois;

public class Village {

private Gaulois chef;
private Gaulois[] listeGaulois=new Gaulois[5];

public Village(Gaulois chef) {
	this.chef=chef;
	listeGaulois[0]=chef;
	
	System.out.println("Le gaulois "+chef.getNom()+" : \"Je suis un grand guerrier et je vais créer mon village\".");
}

public Gaulois getChef(){
	return chef;
}

public void ajouterGaulois(Gaulois gaulois) {
	boolean estInsere=false;
	for (int i=1;i<5 && estInsere==false; i++) { 
		if (listeGaulois[i]==null) {
			listeGaulois[i]=gaulois;
			estInsere=true;
		}
	}
	

	if (estInsere) {
		System.out.println("Le gaulois " + chef.getNom() + " : \" Bienvenue  " +gaulois.getNom()+"! \". " );
	}
	else {
		System.out.println("Le gaulois " + chef.getNom() + " : \" Désolé " + gaulois.getNom()+"  mon village est déjà bien rempli. \"." );
	}

}
}
