package batailles;

import personnages.Personnage;

public interface IBataille {
	
	String decrireContexte();
	TupleChoixCombattants<Personnage, String> choisirCombattants(Personnage[] listePersonnages1, Personnage[] listePersonnages2);
	String preparerCombat(Personnage[] listePersonnages1, Personnage[] listePersonnages2);
	String decrireCombat(Personnage[] listePersonnages1, Personnage[] listePersonnages2);
	String donnerResultat(Personnage[] listePersonnages1, Personnage[] listePersonnages2);
	
}
