package dao; 


import java.util.GregorianCalendar;
import metier.Adherent;
import metier.Employe;
import metier.EnumCategorieEmploye;
import metier.Utilisateur;



public class UtilisateursDAO  
{	
	 
	// Emulation DAO Utilisateurs
	private static Utilisateur[] utilisateursDB =
		{
			new Adherent ( "Francis", "Bacon", new GregorianCalendar(1878,10,5), "H", "maths", "FB", 01, "01-02-03-04-05"),
			new Utilisateur ( "Henri", "Bergson", new GregorianCalendar(1900,2,4), "H", "ourson", "HB", 02),
			
			new Employe ( "Francis", "Lalanne", new GregorianCalendar(1970,2,5), 
						"H", "tignasse", "FL", 03, "Emp01", EnumCategorieEmploye.BIBLIOTHECAIRE),
			
		};
	
	
	/* Recherche d'un utilisateur par sa clef */
	public Utilisateur findByKey (int idUtilisateur)
	{
		Utilisateur user = new Utilisateur();
		
		for (Utilisateur temp : utilisateursDB)
		{ if ( temp.getIdUtilisateur() == idUtilisateur ) user = temp ;}
		
		return user;
	}
		
}
