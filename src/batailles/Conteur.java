package batailles;

import personnages.Personnage;


public class Conteur {
	private String nom;

	public Conteur(String nom) {
		this.nom=nom;
	}
	
	public void raconterHistoire(IBataille bataille, Personnage[] listePersonnage1, Personnage[] listePersonnage2) {

		TupleChoixCombattants<Personnage, String> tupleChoixCombattants;
		
		
		String texte="Je suis "+nom+". "
				+ "Je vais vous conter une histoire qui se deroule en 50 avant Jesus-Christ, "
				+ "du temps ou la Gaule est occupee par les Romains.\n\n";
		
		texte+=bataille.decrireContexte(); 
		tupleChoixCombattants=bataille.choisirCombattants(listePersonnage1, listePersonnage2);
		texte+=tupleChoixCombattants.getTexte();
		texte+=bataille.preparerCombat(tupleChoixCombattants.getListePersonage1(), tupleChoixCombattants.getListePersonage2());
		texte+=bataille.decrireCombat(tupleChoixCombattants.getListePersonage1(), tupleChoixCombattants.getListePersonage2());
		texte+=bataille.donnerResultat(tupleChoixCombattants.getListePersonage1(), tupleChoixCombattants.getListePersonage2());
		System.out.println(texte);
	}

}