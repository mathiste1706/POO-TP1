package test_fonctionnel;

import personnages.Gaulois;
import personnages.Romain;

public class TestGaulois {

	public static void main(String[] args) {
		int forceCoup;
		Gaulois asterix = new Gaulois("Asterix", 8);
		Romain minus=new Romain("Minus", 6);
		
		System.out.println(asterix.getNom());
		asterix.parler("Bonjour à tous");
		minus.parler("UN GAU... UN GAUGAU...");
		/*for (int i=0; i<2;i++) {
			minus.recevoirCoup(3);
		}*/
		for (int i=0; i<3;i++) {
		forceCoup=asterix.frapper(minus);
		minus.recevoirCoup(forceCoup);
	}
		

	}
}
