package tests;

import java.util.GregorianCalendar;

import dao.ExemplairesDAO;
import dao.UtilisateursDAO;
import metier.BiblioException;
import metier.EmpruntArchive;
import metier.EmpruntEnCours;
import metier.Exemplaire;
import metier.Utilisateur;

public class TestRetour {
	
	public static void main(String[]args) throws BiblioException {
		ExemplairesDAO exDAO = new ExemplairesDAO();
		UtilisateursDAO userDAO = new UtilisateursDAO();
		Utilisateur em1 = userDAO.findByKey(03);
		Exemplaire ex = exDAO.findByKey(456);
		EmpruntEnCours ep1 = new EmpruntEnCours(em1, exDAO.findByKey(123), new GregorianCalendar());
		EmpruntEnCours ep2 = new EmpruntEnCours(em1, ex, new GregorianCalendar());
		EmpruntEnCours ep3 = new EmpruntEnCours(em1, exDAO.findByKey(789), new GregorianCalendar());
		System.out.println("\n\n1.6 TEST RETOUR\nOn rend un exemplaire.");
		System.out.println("\nCollection d'EmpruntEnCours de l'utilisateur avant restitution : ");
		em1.afficheEmpruntEnCours();
		 
		System.out.println("\nVérification du status de l'exemplaire 456 => PRETE :");
		System.out.println(ex);
		
		System.out.println("\nRetrait de l'exemplaire n° 456.\n=> em1.removeEmpruntEnCours(ep);");
		em1.removeEmpruntEnCours(ep2);
		
		System.out.println("\nL'exemplaire est passé à DISPONIBLE :");
		System.out.println(ex);
		
		System.out.println("\nLa collection de l'utilisateur est diminuée, plus que 2 emprunts sur 3 :");
		em1.afficheEmpruntEnCours();
		
		System.out.println("\nL'emprunt-Archivé est créé :");
		EmpruntArchive ea = new EmpruntArchive();
		ea.afficheEmpruntsArchive();
		
		System.out.println("\nL'empruntEnCours est garbageCollecté :\n=> ex = null");
		ex = null;
	}

}
