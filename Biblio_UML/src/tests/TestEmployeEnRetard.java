package tests;

import java.util.Calendar;
import java.util.GregorianCalendar;

import dao.ExemplairesDAO;
import dao.UtilisateursDAO;
import metier.BiblioException;
import metier.EmpruntEnCours;
import metier.Utilisateur;

public class TestEmployeEnRetard {
	
	public static void main(String[]args) throws BiblioException {
		// Création des objets nécessaires
		ExemplairesDAO exDAO = new ExemplairesDAO();
		UtilisateursDAO userDAO = new UtilisateursDAO();
		Utilisateur em1 = userDAO.findByKey(03);
		
		System.out.println("1.3 TEST EMPLOYE EN RETARD\nSi un emprunt en retard, emprunt possible pour un employé :");
		
		EmpruntEnCours ep1 = new EmpruntEnCours(em1, exDAO.findByKey(258), new GregorianCalendar(2017,1,20));
		
		System.out.println("\nListe d'emprunt de employé :\n"+ em1.getEmpruntEnCours());
		
		System.out.println("Retrait de l'emprunt ce qui enclenche la méthode isPretEnRetard.");
		em1.removeEmpruntEnCours(ep1);
		
		System.out.println("La méthode isPretEnRetard renvoie true et le nbRetard de l'employé augmente de 1 => "+ em1.getNbRetards());
		System.out.println("\nOn essaie de faire un autre emprunt pour l'employé :\n=> Pas de BiblioException levée : ");
		EmpruntEnCours ep2 = new EmpruntEnCours(em1, exDAO.findByKey(369), new GregorianCalendar());
	}


}
