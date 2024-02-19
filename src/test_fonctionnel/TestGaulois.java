package test_fonctionnel;

import personnages.Gaulois;
import personnages.Grade;
import personnages.Soldat;
import personnages.Druide;
import personnages.Equipement;

public class TestGaulois {

	public static void main(String[] args) {
		String texte="";
		
		Gaulois asterix = new Gaulois("Asterix", 5);
		Gaulois obelix=new Gaulois("Obelix", 15);
		Gaulois assurancetourix =new Gaulois ("Assurancetourix", 2);
		Gaulois abraracourcix =new Gaulois("Abraracourcix", 5);
		Gaulois agecanonix =new Gaulois("Agecanonix", 1);
		Soldat minus=new Soldat("Minus", 6, Grade.SOLDAT);
		
		minus.equiper(Equipement.BOUCLIER);
		minus.equiper(Equipement.CASQUE);
		minus.equiper(Equipement.PLASTRON);
		
		Druide panoramix=new Druide("Panoramix", 2);
		texte+=panoramix.concoterPotion(3);
		texte+=panoramix.donnerPotion(asterix);
		texte+=panoramix.donnerPotion(obelix);
		texte+=panoramix.donnerPotion(assurancetourix);
		texte+=panoramix.donnerPotion(abraracourcix);
		texte+=panoramix.donnerPotion(agecanonix);

		System.out.println(asterix.getNom());
		texte+=asterix.parler("Bonjour a tous");
		texte+=minus.parler("UN GAU... UN GAUGAU...");
		/*for (int i=0; i<2;i++) {
			minus.recevoirCoup(3);
		}*/
		
		boolean boolEstATerre=minus.estATerre();
		for (int i=0; i<3 && !boolEstATerre;i++) {
			texte+=asterix.frapper(minus);
			boolEstATerre=minus.estATerre();
			
		}
		
		System.out.println(texte);
	}
}
