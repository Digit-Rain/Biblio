package tests;

import java.util.GregorianCalendar;

import javax.swing.JOptionPane;

import dao.ExemplairesDAO;
import dao.UtilisateursDAO;
import metier.Adherent;
import metier.BiblioException;
import metier.EmpruntEnCours;
import metier.Exemplaire;
import metier.Utilisateur;

public class TestDeBase {

	public static void main(String[] args) throws BiblioException 
		{
			System.out.println("1.1 TEST DE BASE\nDemande de deux exemplaires par leur id aux Dao :");
			// Création de la Dao
			ExemplairesDAO exDao = new ExemplairesDAO();
			// On demande un Exemplaire
			int idEx1 = Integer.parseInt(JOptionPane.showInputDialog("Saisissez un ID d'exemplaire :"));
			Exemplaire ex1 = exDao.findByKey(idEx1);
			System.out.println(ex1);
			// On demande un autre Exemplaire
			int idEx2 = Integer.parseInt(JOptionPane.showInputDialog("Saisissez un ID d'exemplaire :"));
			Exemplaire ex2 = exDao.findByKey(idEx2);
			System.out.println(ex2);
			
			/////////////////////////////////////////////////////////////
			System.out.println("\nDemande d'un adhérent par son ID aux Dao :");
			// Création de la Dao
			UtilisateursDAO userDAO = new UtilisateursDAO();
			// On Demande un Adhérent (ID 01)
			int keyAd1 = Integer.parseInt(JOptionPane.showInputDialog("Saisissez la clé d'un adhérent :")); 
			Utilisateur ad1 = userDAO.findByKey(keyAd1);
			System.out.println((Adherent)ad1);

			
			/////////////////////////////////////////////////////////////
			System.out.println("\nDemande d'un employé par son ID aux Dao :\n");
			// On Demande un Employé (ID 03)
			int keyEm1 = Integer.parseInt(JOptionPane.showInputDialog("Saisissez la clé d'un employé :")); 
			Utilisateur em1 = userDAO.findByKey(keyEm1);
			System.out.println(em1);
		
			/////////////////////////////////////////////////////////////
			System.out.println("\nCréation d'un emprunt en cours pour un adhérent :");
			EmpruntEnCours ep1 = new EmpruntEnCours(ad1, ex1, new GregorianCalendar());
		//	ad1.addEmpruntEnCours(ep1);
			ad1.afficheEmpruntEnCours();
			
			System.out.println("\nCréation d'un emprunt en cours pour un employé :");
			EmpruntEnCours ep2 = new EmpruntEnCours(em1, ex2, new GregorianCalendar());
		//	em1.addEmpruntEnCours(ep2);
			em1.afficheEmpruntEnCours();
			

		}

}
