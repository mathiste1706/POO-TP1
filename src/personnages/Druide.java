package personnages;

import java.util.Random;

public class Druide extends Gaulois {
	int quantite;

	public Druide(String nom, int force) {
		
		super(nom, force);
		quantite=0;
	}
	
	private void setQuantite(int quantite) {
		this.quantite=quantite;
	}
	
	public String concoterPotion(int quantite) {
		String texte="";
		Random random=new Random();
		setForcePotion(random.nextInt((6-2)+1)+2);
		texte=parler("J'ai concocte "+quantite+ " doses de potion magique. Elle a une force de "+getForcePotion());
		setQuantite(3);
		return texte;
	}
	
	public String donnerPotion(Gaulois gaulois) {
		String paroles;
		if (gaulois.getNom().equals("Obelix")){
			paroles="Non, Obelix Non !... Et tu le sais tres bien !";
			setForcePotion(1);
		}
		else if (quantite>0) {
			paroles="Tiens "+gaulois.getNom() +" un peu de potion magique.";
			gaulois.recevoirPotion(getForcePotion());
			quantite--;
		}
		else {
			paroles="Desole "+ gaulois.getNom()+ " il n'y a plus une seule goutte de potion";
		}
		return parler(paroles);
	}

}
