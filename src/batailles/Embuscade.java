package batailles;

import personnages.Gaulois;
import personnages.Soldat;
import sites.Camp;
import sites.Village;

public class Embuscade implements IBataille {

	@Override
	public String decrireContexte() {
		return "Dans une sombre forêt dans un coin reculé de la Gaule, quatre comparses se promènent.\n";
	}

	@Override
	public String choisirPersonnage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String preparerCombat() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String decrireCombat() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String donnerResultat() {
		// TODO Auto-generated method stub
		return null;
	}
	
// Ds le village cree, on cherche les nom des gaulois qui nous interresse, que l'on est trouve le nom ds le village, 
// une fois qu'on a parcouru le village en entier, on passe au nom cherche suivant 
	private Gaulois[] choisirGaulois(Village village, String[] listeNom) {
		boolean nomTrouve=false;
		Gaulois [] listeChoisirGaulois=new Gaulois[4];
		
		for (int j=0; j<listeNom.length;j++) {
			for (int i=0; i<village.getListeGaulois().length && !nomTrouve; i++) {
				if (village.getListeGaulois()[i]!=null && listeNom[j].equals(village.getListeGaulois()[i].getNom())) {
					listeChoisirGaulois[j]=village.getListeGaulois()[i];
				}
			}
		}
		return listeChoisirGaulois;
	}
	
private Soldat[] choisirSoldat(Camp camp, String[] listeNom) {
	
}
}