package batailles;

import personnages.Personnage;

public class TupleChoixCombattants<Personnage, String> {
	private final Personnage [] listePersonnages1;
	private final Personnage [] listePersonnages2;
	private final String texte;

    public TupleChoixCombattants(Personnage [] listePersonnages1, Personnage [] listePersonnages2, String texte) {
        this.listePersonnages1 = listePersonnages1;
        this.listePersonnages2 = listePersonnages2;
        this.texte=texte;
    }
    
    Personnage [] getListePersonage1(){
    	return listePersonnages1;
    }
    
    Personnage [] getListePersonage2(){
    	return listePersonnages2;
    }
    
    String getTexte() {
    	return texte;
    }

}
