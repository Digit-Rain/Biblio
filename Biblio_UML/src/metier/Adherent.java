package metier;

import java.util.GregorianCalendar;

public class Adherent extends Utilisateur {
	
	private String telephone;
	private static int nbMaxPrets = 3;
	private static int dureeMaxPrets = 15;
	
	
	public Adherent (String nom, String prenom, GregorianCalendar dateNaissance, String sexe, 
			String pwd, String pseudonyme, int idUtilisateur, String telephone) {
		super(nom, prenom, dateNaissance, sexe, pwd, pseudonyme, idUtilisateur);
		this.setTelephone(telephone);
	}
	public Adherent () {};


	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	public static int getNbMaxPrets() {
		return nbMaxPrets;
	}
	
	public static void setNbMaxPrets(int nbMaxPrets) {
		Adherent.nbMaxPrets = nbMaxPrets;
	}


	public static int getDureeMaxPrets() {
		return dureeMaxPrets;
	}

	public static void setDureeMaxPrets(int dureeMaxPrets) {
		Adherent.dureeMaxPrets = dureeMaxPrets;
	}

	
	
	@Override
	public boolean isConditionsPretAcceptees() {
		boolean okNok = true;
		if (this.getNbEmpruntsEnCours() >= 3) {
			okNok = false;
			try {
				throw new BiblioException("Le nombre de pr�ts maxi autoris�s est d�j� atteint !");
			} catch (BiblioException e) {
				// TODO Auto-generated catch block
				System.err.println(e);
				//System.err.println("Le nombre de pr�ts maxi autoris�s est d�j� atteint !");
			}
		} 
		
		if (this.getNbRetards() > 0) {
			okNok = false;
			try {
				throw new BiblioException("Emprunt refus� ! L'adh�rent a "+ this.getNbRetards()+" retard(s).");
			} catch (BiblioException e) {
				// TODO Auto-generated catch block
				System.err.println(e);
			}
		}
		return okNok;
	}
	
	@Override
	public String toString() {
		return "Adherent [N� ID = "+ super.getIdUtilisateur() +", Nom = "+ super.getNom() +", Pr�nom = "+ super.getPrenom() +", Nombre d'emprunt en cours = "
				+ super.getNbEmpruntsEnCours() +", Retard = "+ super.getNbRetards() +", N� telephone = " + telephone + "]";
	}
	
	/*@Override
	public void addEmpruntEnCours (EmpruntEnCours emprunt) {
		System.out.println("Adh�rent addEmprunt : ");
		if (this.isConditionsPretAcceptees() == true)
			this.addEmpruntEnCours(emprunt);
		else
			try {
				throw new BiblioException("Les conditions de pr�ts ne sont pas remplies...");
			} catch (BiblioException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
	
}
