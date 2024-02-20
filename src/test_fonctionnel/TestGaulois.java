package test_fonctionnel;

import personnages.Gaulois;
import personnages.Grade;
import personnages.Soldat;
import personnages.Druide;
import personnages.Equipement;

public class TestGaulois {

	public static void main(String[] args) {
		StringBuilder texte=new StringBuilder();
		
		Gaulois asterix = new Gaulois("Asterix", 5);
		Gaulois obelix=new Gaulois("Obelix", 15);
		Gaulois assurancetourix =new Gaulois ("Assurancetourix", 2);
		Gaulois abraracourcix =new Gaulois("Abraracourcix", 5);
		Gaulois agecanonix =new Gaulois("Agecanonix", 1);
		Soldat minus=new Soldat("Minus", 6, Grade.SOLDAT);
		
		texte.append(minus.equiper(Equipement.BOUCLIER));
		texte.append(minus.equiper(Equipement.CASQUE));
		texte.append(minus.equiper(Equipement.PLASTRON));
		texte.append(minus.equiper(Equipement.PLASTRON));
		
		Druide panoramix=new Druide("Panoramix", 2);
		texte.append(panoramix.concoterPotion(3));
		texte.append(panoramix.donnerPotion(asterix));
		texte.append(panoramix.donnerPotion(obelix));
		texte.append(panoramix.donnerPotion(assurancetourix));
		texte.append(panoramix.donnerPotion(abraracourcix));
		texte.append(panoramix.donnerPotion(agecanonix));

		System.out.println(asterix.getNom());
		texte.append(asterix.parler("Bonjour a tous"));
		texte.append(minus.parler("UN GAU... UN GAUGAU..."));
		
		
		boolean boolEstATerre=minus.estATerre();
		for (int i=0; i<3 && !boolEstATerre;i++) {
			texte.append(asterix.frapper(minus));
			boolEstATerre=minus.estATerre();
			
		}
		System.out.println(texte);	
	}
}
