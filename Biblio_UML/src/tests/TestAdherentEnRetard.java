package tests;

import java.util.GregorianCalendar;

import dao.ExemplairesDAO;
import dao.UtilisateursDAO;
import metier.BiblioException;
import metier.EmpruntEnCours;
import metier.Utilisateur;

public class TestAdherentEnRetard {
	
	public static void main(String[]args) throws BiblioException {
		// Cr�ation des objets n�cessaires
		ExemplairesDAO exDAO = new ExemplairesDAO();
		UtilisateursDAO userDAO = new UtilisateursDAO();
		Utilisateur ad1 = userDAO.findByKey(01);
		
		System.out.println("\n\n1.2 TEST ADHERENT EN RETARD\nSi un emprunt en retard, impossible d'emprunter pour un adh�rent :");

		EmpruntEnCours ep1 = new EmpruntEnCours(ad1, exDAO.findByKey(258), new GregorianCalendar(2017,1,20));
		
		System.out.println("\nListe d'emprunt de l'adh�rent :\n"+ ad1.getEmpruntEnCours());
		
		System.out.println("Retrait de l'emprunt ce qui enclenche la m�thode isPretEnRetard.");
		ad1.removeEmpruntEnCours(ep1);
		
		System.out.println("La m�thode isPretEnRetard renvoie true et le nbRetard de l'adh�rent augmente de 1 => "+ ad1.getNbRetards());
		System.out.println("\nOn essaie de faire un autre emprunt pour l'adh�rent :\n=> L�ve une BiblioException : ");
		EmpruntEnCours ep2 = new EmpruntEnCours(ad1, exDAO.findByKey(369), new GregorianCalendar());
		
	}

}