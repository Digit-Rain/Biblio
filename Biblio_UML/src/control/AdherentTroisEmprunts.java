
import java.util.GregorianCalendar;

import dao.ExemplairesDAO;
import dao.UtilisateursDAO;
import metier.EmpruntEnCours;
import metier.Exemplaire;
import metier.Utilisateur;

public class AdherentTroisEmprunts 
{

	 
	public static void main(String[] args) 
	{
		
		ExemplairesDAO exDAO = new ExemplairesDAO();
		UtilisateursDAO utilDAO = new UtilisateursDAO();
		
		System.out.println("\nCreation premier emprunt adh�rent");
		System.out.println( utilDAO.findByKey(1) );
		Utilisateur user = utilDAO.findByKey(1);
		Exemplaire exemp = exDAO.findByKey(123);
		EmpruntEnCours emprunt = new EmpruntEnCours (  user, exemp, new GregorianCalendar() );
		System.out.println( "Nombre d'emprunts en cours : " + user.getNbEmpruntsEnCours() );
		//user.addEmpruntEnCours(emprunt);
		System.out.println( "Nombre d'emprunts en cours : " + user.getNbEmpruntsEnCours() );

		System.out.println("\nCreation deuxi�me emprunt adh�rent");
		System.out.println( utilDAO.findByKey(1) );
		user = utilDAO.findByKey(1);
		exemp = exDAO.findByKey(456);
		emprunt = new EmpruntEnCours ( user, exemp, new GregorianCalendar() );
		System.out.println( "Nombre d'emprunts en cours : " + user.getNbEmpruntsEnCours() );
		//user.addEmpruntEnCours(emprunt);
		System.out.println( "Nombre d'emprunts en cours : " + user.getNbEmpruntsEnCours() );
		
		System.out.println("\nCreation troisi�me emprunt adh�rent");
		System.out.println( utilDAO.findByKey(1) );
		user = utilDAO.findByKey(1);
		exemp = exDAO.findByKey(789);
		emprunt = new EmpruntEnCours ( user, exemp, new GregorianCalendar() );
		System.out.println( "Nombre d'emprunts en cours : " + user.getNbEmpruntsEnCours() );
		//user.addEmpruntEnCours(emprunt);
		System.out.println( "Nombre d'emprunts en cours : " + user.getNbEmpruntsEnCours() );
		
		System.out.println("\nCreation quatri�me emprunt adh�rent");
		System.out.println( utilDAO.findByKey(1) );
		user = utilDAO.findByKey(1);
		exemp = exDAO.findByKey(147);
		emprunt = new EmpruntEnCours ( user, exemp, new GregorianCalendar() );
		System.out.println( "Nombre d'emprunts en cours : " + user.getNbEmpruntsEnCours() );
		//user.addEmpruntEnCours(emprunt);
		System.out.println( "Nombre d'emprunts en cours : " + user.getNbEmpruntsEnCours() );
		
	}

	
}
