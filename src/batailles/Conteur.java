package batailles;

import personnages.Personnage;


public class Conteur {
	private String nom;

	public Conteur(String nom) {
		this.nom=nom;
	}
	
	public void raconterHistoire(IBataille bataille, Personnage[] listePersonnages1, Personnage[] listePersonnages2) {

		
		StringBuilder texte = new StringBuilder("Je suis "+nom+". "
				+ "Je vais vous conter une histoire qui se deroule en 50 avant Jesus-Christ, "
				+ "du temps ou la Gaule est occupee par les Romains.\n\n");
		
		texte.append(bataille.decrireContexte()); 
		texte.append(bataille.choisirCombattants());
		texte.append(bataille.preparerCombat());
		texte.append(bataille.decrireCombat());
		texte.append(bataille.donnerResultat());
		System.out.println(texte);
	}

}