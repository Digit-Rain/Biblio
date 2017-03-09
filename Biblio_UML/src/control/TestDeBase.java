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
		System.out.println( exDAO.findByKey(123) );
		System.out.println( exDAO.findByKey(456) );
	
		
		System.out.println("\nAffichage d'un adhérent par son ID aux DAO : ");
		System.out.println( utilDAO.findByKey(1) );
			
		
		System.out.println("\nAffichage d'un employé par son ID aux DAO : ");
		System.out.println( utilDAO.findByKey(3) );
			
		
		System.out.println("\nCreation d'un emprunt en cours pour un adhérent");
		System.out.println( utilDAO.findByKey(1) );
		Utilisateur user = utilDAO.findByKey(1);
		Exemplaire exemp = exDAO.findByKey(123);
		EmpruntEnCours emprunt = new EmpruntEnCours (  user, exemp, new GregorianCalendar(2016,01,01) );
		System.out.println( "Nombre d'emprunts en cours : " + user.getNbEmpruntsEnCours() );
		user.afficheEmpruntEnCours();
		//user.addEmpruntEnCours(emprunt);
		System.out.println( "Nombre d'emprunts en cours : " + user.getNbEmpruntsEnCours() );
				
		
		System.out.println("\nCreation d'un emprunt en cours pour un employé");
		System.out.println( utilDAO.findByKey(3) );
		user = utilDAO.findByKey(3);
		exemp = exDAO.findByKey(456);
		emprunt = new EmpruntEnCours ( user, exemp, new GregorianCalendar(2016,01,01) );
		System.out.println( "Nombre d'emprunts en cours : " + user.getNbEmpruntsEnCours() );
		user.afficheEmpruntEnCours();
		//user.addEmpruntEnCours(emprunt);
		System.out.println( "Nombre d'emprunts en cours : " + user.getNbEmpruntsEnCours() );
		
		
		System.out.println("\nImpossible d'emprunter pour un adhérent en retard");
		System.out.println( utilDAO.findByKey(1) );
		user = utilDAO.findByKey(1);
		exemp = exDAO.findByKey(789);
		emprunt = new EmpruntEnCours ( user, exemp, new GregorianCalendar() );
		System.out.println( "Nombre d'emprunts en cours : " + user.getNbEmpruntsEnCours() );
		user.afficheEmpruntEnCours();
		//user.addEmpruntEnCours(emprunt);
		System.out.println( "Nombre d'emprunts en cours : " + user.getNbEmpruntsEnCours() );
		
		
		System.out.println("\nEmprunt possible pour un employé en retard");
		System.out.println( utilDAO.findByKey(3) );
		user = utilDAO.findByKey(3);
		exemp = exDAO.findByKey(147);
		System.out.println( "Nombre d'emprunts en cours : " + user.getNbEmpruntsEnCours() );
		emprunt = new EmpruntEnCours ( user, exemp, new GregorianCalendar()  );
		System.out.println( "Nombre d'emprunts en cours : " + user.getNbEmpruntsEnCours() );
		user.afficheEmpruntEnCours();
		//user.addEmpruntEnCours(emprunt);
		
		
		
		System.out.println("\nEmprunt impossible sur un livre déjà emprunté");
		System.out.println( utilDAO.findByKey(3) );
		user = utilDAO.findByKey(3);
		exemp = exDAO.findByKey(147);
		emprunt = new EmpruntEnCours ( user, exemp, new GregorianCalendar()  );
		System.out.println( "Nombre d'emprunts en cours : " + user.getNbEmpruntsEnCours() );
		System.out.println("Statut exemplaire : " + exemp.getStatus());
		user.afficheEmpruntEnCours();
		//user.addEmpruntEnCours(emprunt);
		System.out.println( "Nombre d'emprunts en cours : " + user.getNbEmpruntsEnCours() );
		
		
	}

}
