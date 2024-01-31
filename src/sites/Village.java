package sites;

import personnages.Gaulois;

public class Village {

private Gaulois chef;
private Gaulois[] listeGaulois=new Gaulois[5];

public Village(Gaulois chef) {
	this.chef=chef;
	listeGaulois[0]=chef;
	
	chef.parler("Je suis un grand guerrier et je vais creer mon village");
}

public Gaulois getChef(){
	return chef;
}

public void ajouterGaulois(Gaulois gaulois) {
	boolean estInsere=false;
	String paroles="";
	for (int i=1;i<listeGaulois.length && !estInsere; i++) { 
		if (listeGaulois[i]==null) {
			listeGaulois[i]=gaulois;
			estInsere=true;
		}
	}
	

	if (estInsere) {
		paroles="Bienvenue " +gaulois.getNom()+"!";
	}
	else {
		paroles= "Desole " + gaulois.getNom()+"  mon village est deja bien rempli. \"." ;
	}
	
	chef.parler(paroles);

}

public void afficherVillage() {
	String village="Le village de "+chef.getNom()+ " est habite par : \n";
	for (int i=1;i<listeGaulois.length; i++) { 
		if (listeGaulois[i]!=null) {
			village+="- "+listeGaulois[i].getNom()+"\n";
		}
	}
	
		
	System.out.println(village);
}
public Gaulois changerChef(Gaulois nvChef) {
	chef.parler(" Je laisse mon grand bouclier au grand "+nvChef.getNom());
	nvChef.parler("Merci !");
	Gaulois oldChef=chef;
	chef=nvChef;
	listeGaulois[0]=chef;
	return oldChef;
	}
}
