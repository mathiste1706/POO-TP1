package sites;
import personnages.Gaulois;
import personnages.Soldat;

public class Camp{

private Soldat centurion;
private Soldat[] listeSoldats=new Soldat[5];

public Camp(Soldat centurion) {
	this.centurion=centurion;
	listeSoldats[0]=centurion;
	
	System.out.println("Le romain "+centurion.getNom()+" : \"Je suis en charge de créer un nouveau camp romain\".");
}

public Soldat getCenturion(){
	return centurion;
}

public void ajouterSoldat(Soldat soldat) {
	boolean estInsere=false;
	for (int i=1;i<5 && estInsere==false; i++) { 
		if (listeSoldats[i]==null) {
			listeSoldats[i]=soldat;
			estInsere=true;
		}
	}
		
		if (estInsere) {
			System.out.println("Le romain " + soldat.getNom() + " : \" Je mets mon epee au service de Rome dans le camp dirige par " 
		+centurion.getNom()+". \". " );
		}
		else {
			System.out.println("Le romain " + centurion.getNom() + " : \" Désolé " + soldat.getNom()+" notre camp est complet ! \"." );
		}

}

}