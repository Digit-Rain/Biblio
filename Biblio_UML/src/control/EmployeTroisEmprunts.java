package control;

import java.util.GregorianCalendar;

import dao.ExemplairesDAO;
import dao.UtilisateursDAO;
import metier.EmpruntEnCours;
import metier.Exemplaire;
import metier.Utilisateur;

public class EmployeTroisEmprunts 
{

	public static void main(String[] args) 
	{
		
		ExemplairesDAO exDAO = new ExemplairesDAO();
		UtilisateursDAO utilDAO = new UtilisateursDAO();
		
		System.out.println("\nCreation premier emprunt employé");
		System.out.println( utilDAO.findByKey(1) );
		Utilisateur user = utilDAO.findByKey(3);
		Exemplaire exemp = exDAO.findByKey(1);
		EmpruntEnCours emprunt = new EmpruntEnCours ( new GregorianCalendar(), user, exemp );
		System.out.println( "Nombre d'emprunts en cours : " + user.getNbEmpruntsEnCours() );
		user.addEmpruntEnCours(emprunt);
		System.out.println( "Nombre d'emprunts en cours : " + user.getNbEmpruntsEnCours() );

		System.out.println("\nCreation deuxième emprunt employé");
		System.out.println( utilDAO.findByKey(1) );
		user = utilDAO.findByKey(3);
		exemp = exDAO.findByKey(2);
		emprunt = new EmpruntEnCours ( new GregorianCalendar(), user, exemp );
		System.out.println( "Nombre d'emprunts en cours : " + user.getNbEmpruntsEnCours() );
		user.addEmpruntEnCours(emprunt);
		System.out.println( "Nombre d'emprunts en cours : " + user.getNbEmpruntsEnCours() );
		
		System.out.println("\nCreation troisième emprunt employé");
		System.out.println( utilDAO.findByKey(1) );
		user = utilDAO.findByKey(3);
		exemp = exDAO.findByKey(3);
		emprunt = new EmpruntEnCours ( new GregorianCalendar(), user, exemp );
		System.out.println( "Nombre d'emprunts en cours : " + user.getNbEmpruntsEnCours() );
		user.addEmpruntEnCours(emprunt);
		System.out.println( "Nombre d'emprunts en cours : " + user.getNbEmpruntsEnCours() );
		
		System.out.println("\nCreation quatrième emprunt employé");
		System.out.println( utilDAO.findByKey(1) );
		user = utilDAO.findByKey(3);
		exemp = exDAO.findByKey(4);
		emprunt = new EmpruntEnCours ( new GregorianCalendar(), user, exemp );
		System.out.println( "Nombre d'emprunts en cours : " + user.getNbEmpruntsEnCours() );
		user.addEmpruntEnCours(emprunt);
		System.out.println( "Nombre d'emprunts en cours : " + user.getNbEmpruntsEnCours() );

	}

}
