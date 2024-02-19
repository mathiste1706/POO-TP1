package personnages;

public class Soldat extends Romain {
	
	private Grade grade;
	private Equipement[] tabEquipement;

	public Soldat(String nom, int force, Grade grade) {
		super(nom, force);
		this.grade=grade;
		tabEquipement=new Equipement[3];
		
	}
	
	@Override
	protected String donnerAuteur() {
		return grade.toString();
	}
	public Grade getGrade() {
		return grade;
	}
	
	public String equiper(Equipement equipement) {
		boolean boolDejaEquipe=false;
		String texte="";
		for (int i=0; i<tabEquipement.length;i++) {
			if (tabEquipement[i]!=null && tabEquipement[i].equals(equipement.getNom())) {
				boolDejaEquipe=true;
			}
		}
		if (!boolDejaEquipe) {
			boolean equipe=false;
			for (int i=0; i<tabEquipement.length && !equipe;i++) {
					if (tabEquipement[i]==null) {
						tabEquipement[i]=equipement;
						equipe=true;
						texte="Le "+ grade + " "+getNom()+ " s'equipe avec un "+equipement.getNom()+"\n";
					}
			}
		}
		return texte;
	}
	

	@Override
	public String recevoirCoup(int forceCoup) {
		int armure=0;
		int degat=0;
		String texte="";
		for (int i=0; i<tabEquipement.length;i++) {
			if (tabEquipement[i]!=null) {
				armure+=tabEquipement[i].getDefense();
				texte+="Le "+tabEquipement[i].getNom()+" absorbe "+tabEquipement[i].getDefense()+" du coup\n";
			}
		}
		
		degat=forceCoup-armure;
		if (degat<0) {
			degat=0;
		}
		setForce(getForce()-degat);
		if (getForce()<0) {
			setForce(0);
		}
		if (getForce()>0) {
			texte+=parler("Aie!");
		}
		else {
			texte+=parler("J'abandonne...");
		}
		return texte;
	}

}
