package test_fonctionnel;

import batailles.Conteur;
import batailles.Embuscade;
import personnages.Gaulois;
import personnages.Grade;
import personnages.Soldat;
import sites.*;

public class TestBataille {

	public static void main(String[] args) {
		Gaulois abraracourcix = new Gaulois("Abraracourcix", 5);
		Village village = new Village(abraracourcix);
		
		Gaulois agecanonix = new Gaulois("Agecanonix", 1);
		Gaulois assurancetourix = new Gaulois("Assurancetourix", 2);
		Gaulois asterix = new Gaulois("Astérix", 5);
		Gaulois obelix = new Gaulois("Obelix", 15);
		Gaulois cetautomatix = new Gaulois("Cétautomatix", 8);
		Gaulois ordralfabetix = new Gaulois("Ordralfabétix", 8);
		
		//village.ajouterGaulois(agecanonix);
		//village.ajouterGaulois(assurancetourix);
		village.ajouterGaulois(asterix);
		village.ajouterGaulois(obelix);
		//village.ajouterGaulois(cetautomatix);
		village.ajouterGaulois(ordralfabetix);
		
		Soldat chorus = new Soldat("Chorus", 4, Grade.CENTURION);
		Camp camp = new Camp(chorus);
		
		Soldat minus = new Soldat("Minus", 2, Grade.SOLDAT);
		Soldat brutus = new Soldat("Brutus", 5, Grade.CENTURION);
		Soldat milexcus = new Soldat("Milexcus", 2, Grade.SOLDAT);
		Soldat tullius = new Soldat("Tullius Octopus", 2, Grade.TESSERARIUS);
		Soldat ballondebaudrus = new Soldat("Ballondebaudrus", 3, Grade.OPTIO);
		Soldat quintilius = new Soldat("Quintilius", 2, Grade.SOLDAT);
		
		camp.ajouterSoldat(brutus);
		camp.ajouterSoldat(milexcus);
		camp.ajouterSoldat(tullius);
		camp.ajouterSoldat(ballondebaudrus);
		camp.ajouterSoldat(minus);
		camp.ajouterSoldat(quintilius);
		
		Conteur goscinny=new Conteur("Goscinny");
		goscinny.raconterHistoire(new Embuscade(), village.getListeGaulois(), camp.getListeSoldats());

	}

}
