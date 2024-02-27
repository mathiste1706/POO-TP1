package batailles;

import personnages.Personnage;

public interface IBataille {
	
	String decrireContexte();
	String choisirCombattants(final Personnage[] listePersonnages1, final Personnage[] listePersonnages2);
	String preparerCombat(Personnage[] listePersonnages1, Personnage[] listePersonnages2);
	String decrireCombat(Personnage[] listePersonnages1, Personnage[] listePersonnages2);
	String donnerResultat(Personnage[] listePersonnages1, Personnage[] listePersonnages2);
	
	
	
}
