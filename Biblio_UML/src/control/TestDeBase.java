package control;


import java.util.GregorianCalendar;

import dao.ExemplairesDAO;
import dao.UtilisateursDAO;
import metier.EmpruntEnCours;
import metier.Exemplaire;
import metier.Utilisateur;


public class TestDeBase 
{

	
	public static void main(String[] args) 
	{
		ExemplairesDAO exDAO = new ExemplairesDAO();
		UtilisateursDAO utilDAO = new UtilisateursDAO();
		
		System.out.println("Affichage de deux exemplaires de livres par leur ID : ");
		System.out.println( exDAO.findByKey(1) );
		System.out.println( exDAO.findByKey(2) );
	
		
		System.out.println("\nAffichage d'un adhérent par son ID aux DAO : ");
		System.out.println( utilDAO.findByKey(1) );
			
		
		System.out.println("\nAffichage d'un employé par son ID aux DAO : ");
		System.out.println( utilDAO.findByKey(3) );
			
		
		System.out.println("\nCreation d'un emprunt en cours pour un adhérent");
		System.out.println( utilDAO.findByKey(1) );
		Utilisateur user = utilDAO.findByKey(1);
		Exemplaire exemp = exDAO.findByKey(1);
		EmpruntEnCours emprunt = new EmpruntEnCours ( new GregorianCalendar(2016,01,01), user, exemp );
		System.out.println( "Nombre d'emprunts en cours : " + user.getNbEmpruntsEnCours() );
		user.addEmpruntEnCours(emprunt);
		System.out.println( "Nombre d'emprunts en cours : " + user.getNbEmpruntsEnCours() );
				
		
		System.out.println("\nCreation d'un emprunt en cours pour un employé");
		System.out.println( utilDAO.findByKey(3) );
		user = utilDAO.findByKey(3);
		exemp = exDAO.findByKey(2);
		emprunt = new EmpruntEnCours ( new GregorianCalendar(2016,01,01), user, exemp );
		System.out.println( "Nombre d'emprunts en cours : " + user.getNbEmpruntsEnCours() );
		user.addEmpruntEnCours(emprunt);
		System.out.println( "Nombre d'emprunts en cours : " + user.getNbEmpruntsEnCours() );
		
		
		System.out.println("\nImpossible d'emprunter pour un adhérent en retard");
		System.out.println( utilDAO.findByKey(1) );
		user = utilDAO.findByKey(1);
		exemp = exDAO.findByKey(3);
		emprunt = new EmpruntEnCours ( new GregorianCalendar(), user, exemp );
		System.out.println( "Nombre d'emprunts en cours : " + user.getNbEmpruntsEnCours() );
		user.addEmpruntEnCours(emprunt);
		System.out.println( "Nombre d'emprunts en cours : " + user.getNbEmpruntsEnCours() );
		
		
		System.out.println("\nEmprunt possible pour un employé en retard");
		System.out.println( utilDAO.findByKey(3) );
		user = utilDAO.findByKey(3);
		exemp = exDAO.findByKey(4);
		emprunt = new EmpruntEnCours ( new GregorianCalendar(), user, exemp );
		System.out.println( "Nombre d'emprunts en cours : " + user.getNbEmpruntsEnCours() );
		user.addEmpruntEnCours(emprunt);
		System.out.println( "Nombre d'emprunts en cours : " + user.getNbEmpruntsEnCours() );
		
		
		System.out.println("\nEmprunt impossible sur un livre déjà emprunté");
		System.out.println( utilDAO.findByKey(3) );
		user = utilDAO.findByKey(3);
		exemp = exDAO.findByKey(4);
		emprunt = new EmpruntEnCours ( new GregorianCalendar(), user, exemp );
		System.out.println( "Nombre d'emprunts en cours : " + user.getNbEmpruntsEnCours() );
		System.out.println("Statut exemplaire : " + exemp.getStatus());
		user.addEmpruntEnCours(emprunt);
		System.out.println( "Nombre d'emprunts en cours : " + user.getNbEmpruntsEnCours() );
		
		
	}

}
