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
			// Cr�ation de la Dao
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
			System.out.println("\nDemande d'un adh�rent par son ID aux Dao :");
			// Cr�ation de la Dao
			UtilisateursDAO userDAO = new UtilisateursDAO();
			// On Demande un Adh�rent (ID 01)
			int keyAd1 = Integer.parseInt(JOptionPane.showInputDialog("Saisissez la cl� d'un adh�rent :")); 
			Utilisateur ad1 = userDAO.findByKey(keyAd1);
			System.out.println((Adherent)ad1);

			
			/////////////////////////////////////////////////////////////
			System.out.println("\nDemande d'un employ� par son ID aux Dao :\n");
			// On Demande un Employ� (ID 03)
			int keyEm1 = Integer.parseInt(JOptionPane.showInputDialog("Saisissez la cl� d'un employ� :")); 
			Utilisateur em1 = userDAO.findByKey(keyEm1);
			System.out.println(em1);
		
			/////////////////////////////////////////////////////////////
			System.out.println("\nCr�ation d'un emprunt en cours pour un adh�rent :");
			EmpruntEnCours ep1 = new EmpruntEnCours(ad1, ex1, new GregorianCalendar());
		//	ad1.addEmpruntEnCours(ep1);
			ad1.afficheEmpruntEnCours();
			
			System.out.println("\nCr�ation d'un emprunt en cours pour un employ� :");
			EmpruntEnCours ep2 = new EmpruntEnCours(em1, ex2, new GregorianCalendar());
		//	em1.addEmpruntEnCours(ep2);
			em1.afficheEmpruntEnCours();
			

		}

}
