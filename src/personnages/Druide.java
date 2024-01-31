package personnages;

import java.util.Random;

public class Druide extends Gaulois {
	int quantite;
	int forcePotion;

	public Druide(String nom, int force) {
		
		super(nom, force);
		quantite=0;
		forcePotion=0;

		
	}
	public void concoterPotion(int quantite) {
		Random random=new Random();
		forcePotion=random.nextInt((6-2)+1)+2;
		parler("J'ai concocté "+quantite+ " doses de potion magique. Elle a une force de "+forcePotion);
	}
	
	public void donnerPotion(Gaulois gaulois) {
		String paroles;
		quantite--;
		if (gaulois.getNom().equals("Obelix")){
			paroles="Non, Obélix Non !... Et tu le sais très bien !";
		}
		else {
			paroles="Tiens "+gaulois.getNom() +" un peu de potion magique.";
		}
		parler(paroles);
	}

}
