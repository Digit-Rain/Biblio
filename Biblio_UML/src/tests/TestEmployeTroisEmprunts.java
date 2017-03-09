package tests;

import java.util.GregorianCalendar;

import dao.ExemplairesDAO;
import dao.UtilisateursDAO;
import metier.BiblioException;
import metier.EmpruntEnCours;
import metier.Utilisateur;

public class TestEmployeTroisEmprunts {
	
	public static void main(String[]args) throws BiblioException {
		// Création des objets nécessaires
		ExemplairesDAO exDAO = new ExemplairesDAO();
		UtilisateursDAO userDAO = new UtilisateursDAO();
		Utilisateur em1 = userDAO.findByKey(03);
		
		System.out.println("\n\n1.5 TEST EMPLOYE 3 EMPRUNTS\nPossible d'avoir plus de 3 emprunts pour un employé :");
		EmpruntEnCours ep1 = new EmpruntEnCours(em1, exDAO.findByKey(123), new GregorianCalendar());
		EmpruntEnCours ep2 = new EmpruntEnCours(em1, exDAO.findByKey(456), new GregorianCalendar());
		EmpruntEnCours ep3 = new EmpruntEnCours(em1, exDAO.findByKey(789), new GregorianCalendar());
		EmpruntEnCours ep4 = new EmpruntEnCours(em1, exDAO.findByKey(147), new GregorianCalendar());
		System.out.println(em1.getEmpruntEnCours());
	}

 
}
