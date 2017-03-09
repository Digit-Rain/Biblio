package tests;

import java.util.GregorianCalendar;

import dao.ExemplairesDAO;
import dao.UtilisateursDAO;
import metier.BiblioException;
import metier.EmpruntEnCours;
import metier.Utilisateur;

public class TestAdherentEnRetard 
{
	 
	public static void main(String[]args) throws BiblioException 
	{
		// Création des objets nécessaires
		ExemplairesDAO exDAO = new ExemplairesDAO();
		UtilisateursDAO userDAO = new UtilisateursDAO();
		Utilisateur ad1 = userDAO.findByKey(01);
		
		System.out.println("\n\n1.2 TEST ADHERENT EN RETARD\nSi un emprunt en retard, impossible d'emprunter pour un adhérent :");

		EmpruntEnCours ep1 = new EmpruntEnCours(ad1, exDAO.findByKey(258), new GregorianCalendar(2017,1,20));
<<<<<<< HEAD
<<<<<<< HEAD
		//ad1.addEmpruntEnCours(ep1);
		System.out.println("\nListe d'emprunt de l'adhérent :\n" ) ;
		ad1.afficheEmpruntEnCours() ;
=======
		ad1.addEmpruntEnCours(ep1);
		System.out.println("\nListe d'emprunt de l'adhérent :\n"+ ad1.getEmpruntEnCours());
		
		System.out.println("Retrait de l'emprunt ce qui enclenche la méthode isPretEnRetard.");
		
		ad1.removeEmpruntEnCours(ep1);
>>>>>>> branch 'master' of https://github.com/Digit-Rain/Biblio.git
=======
		//ad1.addEmpruntEnCours(ep1);
		System.out.println("\nListe d'emprunt de l'adhérent :\n" ) ;
		ad1.afficheEmpruntEnCours() ;
>>>>>>> branch 'master' of https://github.com/Digit-Rain/Biblio.git
		
		System.out.println("La méthode isPretEnRetard renvoie true et le nbRetard de l'adhérent augmente de 1 => "+ ad1.getNbRetards());
<<<<<<< HEAD
<<<<<<< HEAD
		System.out.println("Emprunt en cours de ad1 :");
		ad1.afficheEmpruntEnCours();
		System.out.println("Retrait de l'emprunt ce qui enclenche la méthode isPretEnRetard.");
		//ad1.removeEmpruntEnCours(ep1);
		
		
		System.out.println("\nOn essaie de faire un autre emprunt (n°369) pour l'adhérent :\n=> Lève une BiblioException : ");
		EmpruntEnCours ep2 = new EmpruntEnCours(ad1, exDAO.findByKey(369), new GregorianCalendar());
		System.out.println("Emprunt en cours de ad1 :");
		ad1.afficheEmpruntEnCours();
=======
		System.out.println("\nOn essaie de faire un autre emprunt pour l'adhérent :\n=> Lève une BiblioException : ");
=======
		System.out.println("Emprunt en cours de ad1 :");
		ad1.afficheEmpruntEnCours();
		System.out.println("Retrait de l'emprunt ce qui enclenche la méthode isPretEnRetard.");
		//ad1.removeEmpruntEnCours(ep1);
		
		
		System.out.println("\nOn essaie de faire un autre emprunt (n°369) pour l'adhérent :\n=> Lève une BiblioException : ");
>>>>>>> branch 'master' of https://github.com/Digit-Rain/Biblio.git
		EmpruntEnCours ep2 = new EmpruntEnCours(ad1, exDAO.findByKey(369), new GregorianCalendar());
<<<<<<< HEAD
		ad1.addEmpruntEnCours(ep2);
>>>>>>> branch 'master' of https://github.com/Digit-Rain/Biblio.git
=======
		System.out.println("Emprunt en cours de ad1 :");
		ad1.afficheEmpruntEnCours();
>>>>>>> branch 'master' of https://github.com/Digit-Rain/Biblio.git
	}

}
