package batailles;

import personnages.Personnage;

public class TupleChoixCombattants {
	private final Personnage[] LISTE_PERSONNAGES1;
	private final Personnage[] LISTE_PERSONNAGES2;
	private final String TEXTE;

	public TupleChoixCombattants(final Personnage[] LISTE_PERSONNAGES1, final Personnage[] LISTE_PERSONNAGES2, final String texte) {
		this.LISTE_PERSONNAGES1 = LISTE_PERSONNAGES1;
		this.LISTE_PERSONNAGES2 = LISTE_PERSONNAGES2;
		this.TEXTE = texte;
	}

	Personnage[] getListePersonnages1() {
		return LISTE_PERSONNAGES1;
	}

	Personnage[] getListePersonnages2() {
		return LISTE_PERSONNAGES2;
	}

	String getTexte() {
		return TEXTE;
	}

}
