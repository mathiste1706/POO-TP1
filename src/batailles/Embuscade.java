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
		
		String texte="";
		Personnage[] listeChoixGaulois=choisirGaulois((Gaulois[]) listeGaulois);
		
		Personnage[] listeChoixSoldats=choisirSoldats((Soldat[]) listeSoldats);
		
		
		texte="Il s'agit de "+afficherListePersonnage(listeChoixGaulois)+".\n";
		texte+="Mais cachés derrière des bosquets se cachent "+afficherListePersonnage(listeChoixSoldats)+".\n\n";
		
		tupleChoixCombattants=new TupleChoixCombattants<>(listeChoixGaulois, listeChoixSoldats, texte);
		
		
		return tupleChoixCombattants;
	}

	@Override
	public String preparerCombat(Personnage[] listeGaulois, Personnage[] listeSoldats) {
		String texte="";
		for (int i=0; i<listeSoldats.length;i++) {
			texte+=((Soldat) listeSoldats[i]).equiper(Equipement.BOUCLIER);
			texte+=((Soldat) listeSoldats[i]).equiper(Equipement.CASQUE);
			texte+=((Soldat) listeSoldats[i]).equiper(Equipement.PLASTRON);
			texte+="\n";
		}
		return texte;
	}

	@Override
	public String decrireCombat(Personnage[] listeGaulois, Personnage[] listeSoldats) {
		boolean finCombat=false;
		int choixGaulois=0;
		int choixSoldat=0;
		String texte="";
		
		while(!finCombat) {
			
			// Tour des Gaulois
			for (int j=0; j<listeGaulois.length && !finCombat;j++) {
				
				if (listeSoldats[choixSoldat].estATerre()) {
					choixSoldat++;
				}
				if (choixSoldat==listeSoldats.length) {
					finCombat=true;
				}
				else {
					texte+=listeGaulois[j].frapper(listeSoldats[choixSoldat]);
				}
			}
			
			// Tour des Soldats
			for (int j=0; j<listeSoldats.length && !finCombat;j++) {
				if (listeGaulois[choixGaulois].estATerre()) {
					choixGaulois++;
				}
				
				if (choixSoldat==listeSoldats.length) {
					finCombat=true;
				}
				else {
					texte+=listeGaulois[j].frapper(listeSoldats[choixGaulois]);
				}
			}
		}
		return texte;
	}

	@Override
	public String donnerResultat(Personnage[] listeGaulois, Personnage[] listeSoldats) {
		String texte="";
		boolean victoireGaulois=false;
		for (int i=0; i<listeGaulois.length && !victoireGaulois ;i++) {
			victoireGaulois=!(listeGaulois[i].estATerre());
		}
		
		if (victoireGaulois) {
			texte="Les gaulois "+afficherListePersonnage(listeGaulois);
		}
		else {
			texte="Les soldats romains "+afficherListePersonnage(listeGaulois);
		}
		texte+=" sont victorieux!\n";
		return texte;
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
	
	private String afficherListePersonnage(Personnage [] listePersonnage) {
		
		String texte="";
		
		for (int i=0; i<listePersonnage.length;i++) {
			if (i<listePersonnage.length-2) {
				texte+=listePersonnage[i].getNom()+", ";
			}
			else if (i<listePersonnage.length-1) {
				texte+=listePersonnage[i].getNom();
			}
			
			else {
				texte+=" et "+listePersonnage[i].getNom();
			}
		}
		
		
		return texte;
	}
}