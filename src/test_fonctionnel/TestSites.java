package test_fonctionnel;
import personnages.Gaulois;
import personnages.Grade;
import personnages.Soldat;
import sites.*;

public class TestSites {
		public static void main(String[] args) {
		Gaulois vercingetorix=new Gaulois ("Vercingetorix", 5);
		Soldat minus=new Soldat("Minus", 2, Grade.SOLDAT);  
		
		Village village=new Village(vercingetorix);
		
		 village.ajouterGaulois(new Gaulois("Agecanonix", 1));
		 village.ajouterGaulois(new Gaulois ("Assurancetourix", 2));
		 village.ajouterGaulois(new Gaulois("Asterix", 5));
		 village.ajouterGaulois(new Gaulois("Obelix", 15));
		 village.ajouterGaulois(new Gaulois("Prolix",2));
		
		 
		 Camp camp=new Camp(minus);
		 camp.ajouterSoldat(new Soldat("Brutus", 5, Grade.CENTURION));
		 camp.ajouterSoldat(new Soldat("Milexcus", 2, Grade.SOLDAT));
		 camp.ajouterSoldat(new Soldat("Tullius Octopus", 2, Grade.TESSERARIUS));
		 camp.ajouterSoldat(new Soldat("Ballondebaudrus", 3, Grade.OPTIO));
		 
		 village.afficherVillage();
		 camp.afficherCamp();
		 
		 village.changerChef(new Gaulois("Abraracourcix", 5));
		 camp.changerCommandant(new Soldat("Briseradius", 4, Grade.SOLDAT));
		 camp.changerCommandant(new Soldat("Chorus", 4, Grade.CENTURION));
		 
		 System.out.println("chef: "+village.getChef().getNom());
		 System.out.println("commandant: "+camp.getCenturion().getNom());
	}

}
