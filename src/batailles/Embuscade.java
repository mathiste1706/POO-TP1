package batailles;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import personnages.Equipement;
import personnages.Gaulois;
import personnages.Grade;
import personnages.Personnage;
import personnages.Soldat;


public class Embuscade implements IBataille {

	@Override
	public String decrireContexte() {
		return "Dans une sombre forêt dans un coin reculé de la Gaule, quatre comparses se promènent.\n";
	}

	@Override
	public TupleChoixCombattants<Personnage, String> choisirCombattants(Personnage[] listeGaulois, Personnage[] listeSoldats) {
		
		TupleChoixCombattants<Personnage, String> tupleChoixCombattants;
		
		StringBuilder texte=new StringBuilder();
		Personnage[] listeChoixGaulois=choisirGaulois((Gaulois[]) listeGaulois);
		
		Personnage[] listeChoixSoldats=choisirSoldats((Soldat[]) listeSoldats);
		
		
		texte.append("Il s'agit de "+afficherlistePersonnages(listeChoixGaulois)+".\n");
		texte.append("Mais cachés derrière des bosquets se cachent "+afficherlistePersonnages(listeChoixSoldats)+".\n\n");
		
		
		tupleChoixCombattants=new TupleChoixCombattants<>(listeChoixGaulois, listeChoixSoldats, texte.toString());
		
		
		return tupleChoixCombattants;
	}

	@Override
	public String preparerCombat(Personnage[] listeGaulois, Personnage[] listeSoldats) {
		StringBuilder texte=new StringBuilder();
		for (int i=0; i<listeSoldats.length;i++) {
			texte.append(((Soldat) listeSoldats[i]).equiper(Equipement.BOUCLIER));
			texte.append(((Soldat) listeSoldats[i]).equiper(Equipement.CASQUE));
			texte.append(((Soldat) listeSoldats[i]).equiper(Equipement.PLASTRON));
			texte.append("\n");
		}
		return texte.toString();
	}

	@Override
	public String decrireCombat(Personnage[] listeGaulois, Personnage[] listeSoldats) {
		boolean finCombat=false;
		int choixGaulois=0;
		int choixSoldat=0;
		StringBuilder texte=new StringBuilder();
		
		while(!finCombat) {
			
			// Tour des Gaulois
			for (int j=0; j<listeGaulois.length && !finCombat;j++) {
				
				if (listeSoldats[choixSoldat].estATerre()) {
					choixSoldat++;
				}
				if (choixSoldat==listeSoldats.length) {
					finCombat=true;
				}
				else if (!listeGaulois[j].estATerre()) {
					texte.append(listeGaulois[j].frapper(listeSoldats[choixSoldat]));
					texte.append("\n");
					
				}
			}
			
			// Tour des Soldats
			for (int j=0; j<listeSoldats.length && !finCombat;j++) {
				if (listeGaulois[choixGaulois].estATerre()) {
					choixGaulois++;
				}
				
				if (choixGaulois==listeGaulois.length) {
					finCombat=true;
				}
				else if (!listeSoldats[j].estATerre()){
					texte.append(listeSoldats[j].frapper(listeGaulois[choixGaulois]));
					texte.append("\n");
				}
			}
		}
		return texte.toString();
	}

	@Override
	public String donnerResultat(Personnage[] listeGaulois, Personnage[] listeSoldats) {
		StringBuilder texte=new StringBuilder();
		boolean victoireGaulois=false;
		for (int i=0; i<listeGaulois.length && !victoireGaulois ;i++) {
			victoireGaulois=!(listeGaulois[i].estATerre());
		}
		
		if (victoireGaulois) {
			texte.append("Les gaulois "+afficherlistePersonnages(listeGaulois));
		}
		else {
			texte.append("Les soldats romains "+afficherlistePersonnages(listeSoldats));
		}
		texte.append(" sont victorieux!\n");
		return texte.toString();
	}
	
	
	
// Choisi 4 gaulois du village de maniere aleatoire 
	private Gaulois[] choisirGaulois(Gaulois [] listeGaulois) {
	
		Gaulois [] listeChoisirGaulois=new Gaulois[4];
		
		// Permet de choisir un nombre aleatoire unique dans un intervalle
		List<Integer> listeRandom=new ArrayList<>();
		        
		for (int i = 0; i < listeGaulois.length; i++) {
			if (listeGaulois[i]!=null) {
				listeRandom.add(i);
			}
		 }
		Collections.shuffle(listeRandom);
		
		
		for (int i=0; i<listeChoisirGaulois.length;i++) {
			listeChoisirGaulois[i]=listeGaulois[listeRandom.get(0)];
			listeRandom.remove(0);
		}
		
		
		return listeChoisirGaulois;
	}
	
	// Choisi 2 Soldats de grade soldat aleatoirement
	private Soldat[] choisirSoldats(Soldat [] listeSoldat) {
		
		Soldat [] listeChoisirSoldats=new Soldat[2];
		List<Integer> listeRandom=new ArrayList<>();
		
		for (int i=0; i<listeSoldat.length; i++) {
			if (listeSoldat[i]!=null && (listeSoldat[i]).getGrade()==Grade.SOLDAT) {
				listeRandom.add(i);
			}
		}
		
		Collections.shuffle(listeRandom);
		
		for (int i=0; i<listeChoisirSoldats.length;i++) {
			
			listeChoisirSoldats[i]=listeSoldat[listeRandom.get(0)];
			listeRandom.remove(0);
		}
				
				
		
		
	return listeChoisirSoldats;
	}
	
	private String afficherlistePersonnages(Personnage [] listePersonnages) {
		
		StringBuilder texte=new StringBuilder();
		
		for (int i=0; i<listePersonnages.length;i++) {
			if (i<listePersonnages.length-2) {
				texte.append(listePersonnages[i].getNom()+", ");
			}
			else if (i<listePersonnages.length-1) {
				texte.append(listePersonnages[i].getNom());
			}
			
			else {
				texte.append(" et "+listePersonnages[i].getNom());
			}
		}
		
		
		return texte.toString();
	}
}