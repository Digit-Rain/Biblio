package control;

import java.util.GregorianCalendar;

import dao.ExemplairesDAO;
import dao.UtilisateursDAO;
import metier.EmpruntEnCours;
import metier.Exemplaire;
import metier.Utilisateur;

public class EmployeTroisEmprunts 
{
<<<<<<< HEAD
  
	public static void main(String[] args) 
=======

	public static void main(String[] args) // Modif des constructeurs et des n° d'exemplaire
>>>>>>> branch 'master' of https://github.com/Digit-Rain/Biblio.git
	{
		
		ExemplairesDAO exDAO = new ExemplairesDAO();
		UtilisateursDAO utilDAO = new UtilisateursDAO();
		
		System.out.println("\nCreation premier emprunt employé");
		System.out.println( utilDAO.findByKey(1) );
		Utilisateur user = utilDAO.findByKey(3);
		Exemplaire exemp = exDAO.findByKey(123);
<<<<<<< HEAD
		EmpruntEnCours emprunt = new EmpruntEnCours ( user, exemp, new GregorianCalendar()  );
=======
		EmpruntEnCours emprunt = new EmpruntEnCours ( user, exemp, new GregorianCalendar());
>>>>>>> branch 'master' of https://github.com/Digit-Rain/Biblio.git
		System.out.println( "Nombre d'emprunts en cours : " + user.getNbEmpruntsEnCours() );
		//user.addEmpruntEnCours(emprunt);
		System.out.println( "Nombre d'emprunts en cours : " + user.getNbEmpruntsEnCours() );

		System.out.println("\nCreation deuxième emprunt employé");
		System.out.println( utilDAO.findByKey(1) );
		user = utilDAO.findByKey(3);
		exemp = exDAO.findByKey(456);
<<<<<<< HEAD
		emprunt = new EmpruntEnCours ( user, exemp, new GregorianCalendar() );
=======
		emprunt = new EmpruntEnCours ( user, exemp, new GregorianCalendar());
>>>>>>> branch 'master' of https://github.com/Digit-Rain/Biblio.git
		System.out.println( "Nombre d'emprunts en cours : " + user.getNbEmpruntsEnCours() );
		//user.addEmpruntEnCours(emprunt);
		System.out.println( "Nombre d'emprunts en cours : " + user.getNbEmpruntsEnCours() );
		
		System.out.println("\nCreation troisième emprunt employé");
		System.out.println( utilDAO.findByKey(1) );
		user = utilDAO.findByKey(3);
		exemp = exDAO.findByKey(789);
<<<<<<< HEAD
		emprunt = new EmpruntEnCours (  user, exemp, new GregorianCalendar() );
=======
		emprunt = new EmpruntEnCours ( user, exemp, new GregorianCalendar());
>>>>>>> branch 'master' of https://github.com/Digit-Rain/Biblio.git
		System.out.println( "Nombre d'emprunts en cours : " + user.getNbEmpruntsEnCours() );
		//user.addEmpruntEnCours(emprunt);
		System.out.println( "Nombre d'emprunts en cours : " + user.getNbEmpruntsEnCours() );
		
		System.out.println("\nCreation quatrième emprunt employé");
		System.out.println( utilDAO.findByKey(1) );
		user = utilDAO.findByKey(3);
		exemp = exDAO.findByKey(147);
<<<<<<< HEAD
		emprunt = new EmpruntEnCours (  user, exemp, new GregorianCalendar() );
=======
		emprunt = new EmpruntEnCours ( user, exemp, new GregorianCalendar());
>>>>>>> branch 'master' of https://github.com/Digit-Rain/Biblio.git
		System.out.println( "Nombre d'emprunts en cours : " + user.getNbEmpruntsEnCours() );
		//user.addEmpruntEnCours(emprunt);
		System.out.println( "Nombre d'emprunts en cours : " + user.getNbEmpruntsEnCours() );

	}

}
