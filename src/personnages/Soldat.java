package personnages;

public class Soldat extends Romain {
	
	private Grade grade;
	private Equipement[] tabEquipement;

	public Soldat(String nom, int force, Grade grade) {
		super(nom, force);
		this.grade=grade;
		tabEquipement=new Equipement[3];
		
	}
	
	protected String donnerAuteur() {
		return grade.toString();
	}
	public Grade getGrade() {
		return grade;
	}
	
	public void equiper(Equipement equipement) {
		boolean boolDejaEquipe=false;
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
						System.out.println("Le "+ grade + " "+getNom()+ " s'equipe avec un "+equipement.getNom());
					}
			}
		}
	}
	@Override
	public void recevoirCoup(int forceCoup) {
		int armure=0;
		int degat=0;
		for (int i=0; i<tabEquipement.length;i++) {
			if (tabEquipement[i]!=null) {
				armure+=tabEquipement[i].defense;
				System.out.println("Le "+tabEquipement[i].nom+" absorbe "+tabEquipement[i].defense+" du coup");
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
			parler("Aie!");
		}
		else {
			parler("J'abandonne...");
		}
	}

}
