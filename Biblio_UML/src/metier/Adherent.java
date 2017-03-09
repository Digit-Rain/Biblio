package metier;

import java.util.GregorianCalendar;

public class Adherent extends Utilisateur {
	
	private String telephone;
	private static int nbMaxPrets = 3;
	private static int dureeMaxPrets = 15;
	
	public Adherent () {};
	
	 
	public Adherent (String nom, String prenom, GregorianCalendar dateNaissance, String sexe, 
			String pwd, String pseudonyme, int idUtilisateur, String telephone) {
		super(nom, prenom, dateNaissance, sexe, pwd, pseudonyme, idUtilisateur);
		this.setTelephone(telephone);
	}
	
	
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

	
	@ Override
	public boolean isConditionsPretAcceptees() 
	{
		
		if ( getNbRetards() > 0 || getNbEmpruntsEnCours() >= nbMaxPrets ) return false ;
		else return true;
		
	}
	
	
	
	public int getNbRetards () 
	{ 
		int nbRetards = 0;
		
		for ( EmpruntEnCours temp : getEmpruntEnCours() )
		if ( temp.isPretEnRetard() ) nbRetards++;
		
		if ( nbRetards >= 1 )
		{
			try {
				throw new BiblioException("Désolé vous avez trop de retards pour pouvoir emprunter");
			} catch (BiblioException e) {System.err.println(e); }	
		}
		return nbRetards; 
	}

	
	
	/*@Override
	public boolean isConditionsPretAcceptees() {
		System.out.println("isConditionsPretAcceptees dav");
		boolean okNok = true;
		if (this.getNbEmpruntsEnCours() >= 3) {
			okNok = false;
			try {
				throw new BiblioException("Le nombre de prêts maxi autorisés est déjà atteint !");
			} catch (BiblioException e) {
				// TODO Auto-generated catch block
				System.err.println(e);
			}
		} 
		
		if (this.getNbRetards() > 0) {
			System.out.println("salut");
			okNok = false;
			try {
				throw new BiblioException("Emprunt refusé ! L'adhérent a "+ this.getNbRetards()+" retard(s).");
			} catch (BiblioException e) {
				// TODO Auto-generated catch block
				System.err.println(e);
			}
		}
		return okNok;
	}*/
	
	@Override
	public String toString() 
	{
		return "Adherent [N° ID = "+ super.getIdUtilisateur() +", Nom = "+ super.getNom() +", Prénom = "+ super.getPrenom() +", Nombre d'emprunt en cours = "
				+ super.getNbEmpruntsEnCours() +", Retard = "+ super.getNbRetards() +", N° telephone = " + telephone + "]";
	}
	
}
