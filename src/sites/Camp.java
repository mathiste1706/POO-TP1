package sites;
import personnages.Grade;
import personnages.Soldat;

public class Camp{

private Soldat centurion;
private Soldat[] listeSoldats=new Soldat[20];

public Camp(Soldat centurion) {
	this.centurion=centurion;
	listeSoldats[0]=centurion;
	
	centurion.parler("Je suis en charge de creer un nouveau camp romain");
}

public Soldat getCenturion(){
	return centurion;
}

public Soldat[] getListeSoldats() {
	return listeSoldats;
}

public void ajouterSoldat(Soldat soldat) {
	boolean estInsere=false;
	for (int i=1;i<listeSoldats.length && !estInsere; i++) { 
		if (listeSoldats[i]==null) {
			listeSoldats[i]=soldat;
			estInsere=true;
		}
	}
		
		if (estInsere) {
			soldat.parler(" Je mets mon epee au service de Rome dans le camp dirige par " +centurion.getNom());
		}
		else {
			centurion.parler(" Desole " + soldat.getNom()+" notre camp est complet !");
		
		}

}

public void afficherCamp() {
	String camp="Le camp dirige par "+centurion.getNom()+ " contient les soldats :\n";
	for (int i=1;i<listeSoldats.length; i++) { 
		if (listeSoldats[i]!=null) {
			camp+="- "+listeSoldats[i].getNom()+"\n";;
		}
	}
	
		
	System.out.println(camp);
}

public Soldat changerCommandant(Soldat nvCenturion) {
	Soldat oldCenturion=null;
	if (nvCenturion.getGrade()==Grade.CENTURION) {
		nvCenturion.parler("Moi "+nvCenturion.getNom()+" je prend la direction du camp.");
		oldCenturion=centurion;
		centurion=nvCenturion;
		listeSoldats[0]=centurion;
	}
	else {
		nvCenturion.parler(" Je ne suis pas suffisamment grade pour prendre la direction du camp romain.");
	}
	return oldCenturion;
	}

}