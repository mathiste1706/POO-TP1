package batailles;


import java.util.Random;

import personnages.Equipement;
import personnages.Gaulois;
import personnages.Grade;
import personnages.Personnage;
import personnages.Soldat;
import sites.*;

public class Embuscade implements IBataille {
	
	Random random=new Random();
	private Village village;
	private Camp camp;
	private Gaulois[] listeChoixGaulois;
	private Soldat[] listeChoixSoldats;
	
	public Embuscade(Village village, Camp camp) {
		this.village=village;
		this.camp=camp;
	}

	@Override
	public String decrireContexte() {
		return "Dans une sombre foret dans un coin recule de la Gaule, quatre comparses se promenent.\n";
	}

	@Override
	public String choisirCombattants() {
		
		
		StringBuilder texte=new StringBuilder();
		listeChoixGaulois=choisirGaulois(village.getListeGaulois());
		
		listeChoixSoldats=choisirSoldats(camp.getListeSoldats());
		
		
		texte.append("Il s'agit de "+afficherlistePersonnages(listeChoixGaulois)+".\n");
		texte.append("Mais caches derriere des bosquets se cachent "+afficherlistePersonnages(listeChoixSoldats)+".\n\n");
		
		
		return texte.toString();
	}

	@Override
	public String preparerCombat() {
		StringBuilder texte=new StringBuilder();
		for (int i=0; i<listeChoixSoldats.length;i++) {
			texte.append(listeChoixSoldats[i].equiper(Equipement.BOUCLIER));
			texte.append(listeChoixSoldats[i].equiper(Equipement.CASQUE));
			texte.append(listeChoixSoldats[i].equiper(Equipement.PLASTRON));
			texte.append("\n");
		}
		return texte.toString();
	}

	@Override
	public String decrireCombat() {
		boolean finCombat=false;
		StringBuilder texte=new StringBuilder();
		
		while(!finCombat) {
			
			
			finCombat=tourPersonnages(listeChoixGaulois, listeChoixSoldats, texte);
		}
			
		return texte.toString();
	}

	@Override
	public String donnerResultat() {
		StringBuilder texte=new StringBuilder();
		boolean victoireGaulois=false;
		for (int i=0; i<listeChoixGaulois.length && !victoireGaulois ;i++) {
			victoireGaulois=!(listeChoixGaulois[i].estATerre());
		}
		
		if (victoireGaulois) {
			texte.append("Malgré cette sournoise attaque, nos promeneurs s'en sont sortis indemnes. "
					+ "Ils pouvaient compter sur la force de "
					+afficherlistePersonnages(listeChoixGaulois));
		}
		else {
			texte.append("L'attaque fut tellement rapide et inattendue que nos malheureux gaulois n'ont pas eu le temps de réagir. "
					+ "Ils furent ligotés et emmenés dans le camp de " +camp.getCenturion().getNom()+".");
		}
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
		
		// Selectionner aleatoirement
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
	
	private int selection(Personnage[] listePersonnage, int nbCombattants) {
		int choix;
		choix=random.nextInt(nbCombattants);
		return choix;
	}
	
	private boolean tourPersonnages( Personnage[] listeGaulois, Personnage[] listeSoldats, StringBuilder texte) {
		
		boolean finCombat=false;
		int choixGaulois=0;
		int choixSoldat=0;
		Personnage frappe;
		Personnage estFrapee;
		int nbCombattants=0;
		Gaulois [] listeGauloisSontEnVie=new Gaulois[listeGaulois.length];
		Soldat[] listeSoldatsSontEnVie=new Soldat[listeSoldats.length];
		
		//Selection Gaulois
		for (int i=0; i<listeGaulois.length;i++) {
			if (!(listeGaulois[i].estATerre())) {
				listeGauloisSontEnVie[nbCombattants]=(Gaulois) listeGaulois[i];
				nbCombattants++;
			}
		}
		if (nbCombattants==0) {
			finCombat=true;
		}
		
		if (!finCombat) {
			choixGaulois=selection(listeGauloisSontEnVie, nbCombattants);
			
			//Selection Soldats
			nbCombattants=0;
			for (int i=0; i<listeSoldats.length;i++) {
				if (!listeSoldats[i].estATerre()) {
					listeSoldatsSontEnVie[nbCombattants]=(Soldat) listeSoldats[i];
					nbCombattants++;
				}
			}
			if (nbCombattants==0) {
				finCombat=true;
			}
			
			if (!finCombat) {
			choixSoldat=selection(listeSoldatsSontEnVie, nbCombattants);
			
				if (random.nextInt(2)==0) {
					frappe=listeGauloisSontEnVie[choixGaulois];
					estFrapee=listeSoldatsSontEnVie[choixSoldat];
				}
				else {
					frappe=listeSoldatsSontEnVie[choixSoldat];
					estFrapee=listeGauloisSontEnVie[choixGaulois];
				}
					
				texte.append(frappe.frapper(estFrapee)+"\n");
			}
		}
			
		return finCombat;
	}
	}