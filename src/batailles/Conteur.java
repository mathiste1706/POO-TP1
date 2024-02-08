package batailles;

public class Conteur {
	private String nom;

	public Conteur(String nom) {
		this.nom=nom;
	}
	
	public void raconterHistoire(IBataille bataille) {
		String texte="Je suis "+nom+". "
				+ "Je vais vous conter une histoire qui se déroule en 50 avant Jésus-Christ, "
				+ "du temps où la Gaule est occupée par les Romains.\n\n";
		
		texte+=bataille.decrireContexte(); 
		texte+=bataille.choisirPersonnage();
		texte+=bataille.preparerCombat();
		texte+=bataille.decrireCombat();
		texte+=bataille.donnerResultat();
		System.out.println(texte);
	}

}