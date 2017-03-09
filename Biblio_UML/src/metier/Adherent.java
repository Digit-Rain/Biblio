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

	
<<<<<<< HEAD
	@ Override
	public boolean isConditionsPretAcceptees() 
=======
	/*public boolean isConditionsPretAcceptees() 
>>>>>>> branch 'master' of https://github.com/Digit-Rain/Biblio.git
	{
		
		if ( getNbRetards() > 0 || getNbEmpruntsEnCours() >= nbMaxPrets ) return false ;
		else return true;
		
	}*/
	
	
	
	public int getNbRetards () 
	{ 
		/*int nbRetards = 0;
		
		for ( EmpruntEnCours temp : getEmpruntEnCours() )
		if ( temp.isPretEnRetard() ) nbRetards++;
		
		if ( nbRetards >= 1 )
		{
			try {
				throw new BiblioException("D�sol� vous avez trop de retards pour pouvoir emprunter");
<<<<<<< HEAD
			} catch (BiblioException e) {System.err.println(e); }	
		}
		return nbRetards; 
=======
			} catch (BiblioException e) {System.out.println(e); }	
		}*/
		return this.nbRetards; 
>>>>>>> branch 'master' of https://github.com/Digit-Rain/Biblio.git
	}

	
	
	@Override
	public boolean isConditionsPretAcceptees() {

		boolean okNok = true;
		if (this.getNbEmpruntsEnCours() >= 3) {
			okNok = false;
			try {
				throw new BiblioException("Le nombre de pr�ts maxi autoris�s est d�j� atteint !");
			} catch (BiblioException e) {
				System.err.println(e);
			}
		} 
		
		if (this.getNbRetards() > 0) {
			okNok = false;
			try {
				throw new BiblioException("Emprunt refus� ! L'adh�rent a "+ this.getNbRetards()+" retard(s).");
			} catch (BiblioException e) {
				System.err.println(e);
			}
		}
		return okNok;
	}
	
	@Override
	public String toString() 
	{
		return "Adherent [N� ID = "+ super.getIdUtilisateur() +", Nom = "+ super.getNom() +", Pr�nom = "+ super.getPrenom() +", Nombre d'emprunt en cours = "
				+ super.getNbEmpruntsEnCours() +", Retard = "+ super.getNbRetards() +", N� telephone = " + telephone + "]";
	}
	
}
