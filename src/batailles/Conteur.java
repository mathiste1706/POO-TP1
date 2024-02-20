package batailles;

import personnages.Personnage;


public class Conteur {
	private String nom;

	public Conteur(String nom) {
		this.nom=nom;
	}
	
	public void raconterHistoire(IBataille bataille, Personnage[] listePersonnages1, Personnage[] listePersonnages2) {

		TupleChoixCombattants<Personnage, String> tupleChoixCombattants;
		
		StringBuilder texte = new StringBuilder("Je suis "+nom+". "
				+ "Je vais vous conter une histoire qui se deroule en 50 avant Jesus-Christ, "
				+ "du temps ou la Gaule est occupee par les Romains.\n\n");
		
		texte.append(bataille.decrireContexte()); 
		tupleChoixCombattants=bataille.choisirCombattants(listePersonnages1, listePersonnages2);
		texte.append(tupleChoixCombattants.getTexte());
		texte.append(bataille.preparerCombat(tupleChoixCombattants.getListePersonnages1(), tupleChoixCombattants.getListePersonnages2()));
		texte.append(bataille.decrireCombat(tupleChoixCombattants.getListePersonnages1(), tupleChoixCombattants.getListePersonnages2()));
		texte.append(bataille.donnerResultat(tupleChoixCombattants.getListePersonnages1(), tupleChoixCombattants.getListePersonnages2()));
		System.out.println(texte);
	}

}