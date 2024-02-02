package test_fonctionnel;

import personnages.Gaulois;
import personnages.Grade;
import personnages.Plastron;
import personnages.Soldat;
import personnages.Bouclier;
import personnages.Casque;
import personnages.Druide;

public class TestGaulois {

	public static void main(String[] args) {
		int forceCoup;
		Gaulois asterix = new Gaulois("Asterix", 5);
		Gaulois obelix=new Gaulois("Obelix", 15);
		Gaulois assurancetourix =new Gaulois ("Assurancetourix", 2);
		Gaulois abraracourcix =new Gaulois("Abraracourcix", 5);
		Gaulois agecanonix =new Gaulois("Agecanonix", 1);
		Soldat minus=new Soldat("Minus", 6, Grade.SOLDAT);
		
		minus.equiper(new Bouclier());
		minus.equiper(new Casque());
		minus.equiper(new Plastron());
		
		Druide panoramix=new Druide("Panoramix", 2);
		panoramix.concoterPotion(3);
		panoramix.donnerPotion(asterix);
		panoramix.donnerPotion(obelix);
		panoramix.donnerPotion(assurancetourix);
		panoramix.donnerPotion(abraracourcix);
		panoramix.donnerPotion(agecanonix);
		
		System.out.println(asterix.getNom());
		asterix.parler("Bonjour a tous");
		minus.parler("UN GAU... UN GAUGAU...");
		/*for (int i=0; i<2;i++) {
			minus.recevoirCoup(3);
		}*/
		
		boolean boolEstATerre=minus.estATerre();
		for (int i=0; i<3 && !boolEstATerre;i++) {
			forceCoup=asterix.frapper(minus);
			minus.recevoirCoup(forceCoup);
			boolEstATerre=minus.estATerre();
			
		}
		

	}
}
