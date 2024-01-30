package sites;

import personnages.Gaulois;

public class Village {

private Gaulois chef;
private Gaulois[] listeGaulois=new Gaulois[5];

public Village(Gaulois chef) {
	this.chef=chef;
	listeGaulois[0]=chef;
	
	System.out.println("Le gaulois "+chef.getNom()+" : \"Je suis un grand guerrier et je vais creer mon village\".");
}

public Gaulois getChef(){
	return chef;
}

public void ajouterGaulois(Gaulois gaulois) {
	boolean estInsere=false;
	for (int i=1;i<listeGaulois.length && !estInsere; i++) { 
		if (listeGaulois[i]==null) {
			listeGaulois[i]=gaulois;
			estInsere=true;
		}
	}
	

	if (estInsere) {
		System.out.println("Le gaulois " + chef.getNom() + " : \" Bienvenue  " +gaulois.getNom()+"! \". " );
	}
	else {
		System.out.println("Le gaulois " + chef.getNom() + " : \" Desole " + gaulois.getNom()+"  mon village est deja bien rempli. \"." );
	}

}

public void afficherVillage() {
	String village="Le village de "+chef.getNom()+ "est habite par : \n";
	for (int i=1;i<listeGaulois.length; i++) { 
		if (listeGaulois[i]!=null) {
			village+="- "+listeGaulois[i].getNom()+"\n";
		}
	}
	
		
	System.out.println(village);
}
public Gaulois changerChef(Gaulois nvChef) {
	System.out.println("Le gaulois "+chef.getNom()+ ": \" Je laisse mon grand bouclier au grand "+nvChef.getNom()+"\".\n");
	System.out.println("Le gaulois "+nvChef.getNom()+ ": \" Merci!\".\n");
	Gaulois oldChef=chef;
	chef=nvChef;
	listeGaulois[0]=chef;
	return oldChef;
	}
}
