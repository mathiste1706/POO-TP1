package batailles;


import java.util.Random;

import personnages.Equipement;
import personnages.Gaulois;
import personnages.Grade;
import personnages.Personnage;
import personnages.Soldat;


public class Embuscade implements IBataille {
	
	Random random=new Random();

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
		StringBuilder texte=new StringBuilder();
		
		while(!finCombat) {
			
			
			// Tour des Gaulois
			finCombat=tourPersonnages(random, listeGaulois, listeSoldats, texte);
			
			// Tour des Soldats
			if (!finCombat) {
				finCombat=tourPersonnages(random, listeSoldats, listeGaulois, texte);
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
		
		int choix;
		int tailleGaulois=listeGaulois.length;
		
		// Permet de choisir un nombre aleatoire unique dans un intervalle
		      
		for (int i=0; i<listeChoisirGaulois.length;i++) {
			choix=random.nextInt(tailleGaulois-1);
			listeChoisirGaulois[i]=listeGaulois[choix];
			listeGaulois[choix]=listeGaulois[tailleGaulois-1];
			tailleGaulois--;
		}
		
		
		return listeChoisirGaulois;
	}
	
	// Choisi 2 Soldats de grade soldat aleatoirement
	private Soldat[] choisirSoldats(Soldat [] listeSoldat) {
		
		Soldat [] listeChoisirSoldats=new Soldat[2];
		int[] listeIndexGradeSoldat=new int[listeSoldat.length];
		
		int choix;
		int tailleGradeSoldats=0;
		
		// Selectionner les soldats de grade Soldat
		for (int i=0; i<listeSoldat.length;i++) {
			
			if (listeSoldat[i]!=null && listeSoldat[i].getGrade()==Grade.SOLDAT) {
			listeIndexGradeSoldat[tailleGradeSoldats]=i;
			tailleGradeSoldats++;
			}
		}
		
		// Selectionner aléatoirement
		for (int i=0; i<listeChoisirSoldats.length;i++) {
			
			choix=random.nextInt(tailleGradeSoldats-1);
			listeChoisirSoldats[i]=listeSoldat[listeIndexGradeSoldat[choix]];
			listeIndexGradeSoldat[choix]=listeIndexGradeSoldat[tailleGradeSoldats-1];
			tailleGradeSoldats--;
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
	
	private boolean tourPersonnages(Random random, Personnage[] listeAllies, Personnage[] listeEnnemis, StringBuilder texte) {
		
		boolean finCombat=false;
		boolean ennemisATerre;
		int choixEnnemi=0;
		
		for (int j=0; j<listeAllies.length && !finCombat;j++) {
			
			choixEnnemi=random.nextInt(listeEnnemis.length-1);
			ennemisATerre=true;
			
			
			for (int i=0; i<listeEnnemis.length && ennemisATerre;i++) {
				
				if (!listeEnnemis[choixEnnemi].estATerre()) {
					ennemisATerre=false;
				}
				else {
					choixEnnemi=(choixEnnemi+1)%listeEnnemis.length;
				}
			}
			
			if (!ennemisATerre) {
			
				if (!listeAllies[j].estATerre()) {
					texte.append(listeAllies[j].frapper(listeEnnemis[choixEnnemi]));
					texte.append("\n");
				}	
			}
			else {
				finCombat=true;
			}
			
		}
		return finCombat;
	}
}