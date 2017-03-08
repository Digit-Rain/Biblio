package tests;

import java.util.GregorianCalendar;

import dao.ExemplairesDAO;
import dao.UtilisateursDAO;
import metier.BiblioException;
import metier.EmpruntEnCours;
import metier.Utilisateur;

public class TestAdherentTroisEmprunts {
	
	public static void main(String[]args) throws BiblioException {
		// Création des objets nécessaires
		ExemplairesDAO exDAO = new ExemplairesDAO();
		UtilisateursDAO userDAO = new UtilisateursDAO();
		Utilisateur ad1 = userDAO.findByKey(01); 
		
		System.out.println("\n\n1.4 TEST ADHERENT 3 EMPRUNTS\nImpossible d'avoir plus de 3 emprunts pour un adhérent.\nLève une BiblioException :");
		EmpruntEnCours ep1 = new EmpruntEnCours(ad1, exDAO.findByKey(123), new GregorianCalendar());
		EmpruntEnCours ep2 = new EmpruntEnCours(ad1, exDAO.findByKey(456), new GregorianCalendar());
		EmpruntEnCours ep3 = new EmpruntEnCours(ad1, exDAO.findByKey(789), new GregorianCalendar());
		EmpruntEnCours ep4 = new EmpruntEnCours(ad1, exDAO.findByKey(147), new GregorianCalendar());
		System.out.println(ad1.getEmpruntEnCours());
	}

}
