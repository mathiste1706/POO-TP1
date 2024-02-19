package batailles;

import personnages.Personnage;

public interface IBataille {
	
	String decrireContexte();
	TupleChoixCombattants<Personnage, String> choisirCombattants(Personnage[] listePersonnage1, Personnage[] listePersonnage2);
	String preparerCombat(Personnage[] listePersonnage1, Personnage[] listePersonnage2);
	String decrireCombat(Personnage[] listePersonnage1, Personnage[] listePersonnage2);
	String donnerResultat(Personnage[] listePersonnage1, Personnage[] listePersonnage2);
	
}
