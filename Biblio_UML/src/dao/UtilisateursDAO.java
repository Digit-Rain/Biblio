package dao;
//import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

import metier.Utilisateur;



public class UtilisateursDAO 
{	
	
	
	// Emulation DAO Utilisateurs
	private static Utilisateur[] utilisateursDB =
		{
			new Utilisateur ( "Francis", "Bacon", new GregorianCalendar(1878,10,5), "H", "maths", "FB", 01),
			new Utilisateur ( "Henri", "Bergson", new GregorianCalendar(1900,2,4), "H", "ourson", "HB", 02),
			new Utilisateur ( "Francis", "Lalanne", new GregorianCalendar(1970,2,5), "H", "tignasse", "FL", 03),	
		};
	
	
	/* Recherche d'un utilisateur par sa clef */
	public static Utilisateur findByKey (int idUtilisateur)
	{
		Utilisateur user = new Utilisateur();
		
		for (Utilisateur temp : utilisateursDB)
		{ if ( temp.getIdUtilisateur() == idUtilisateur ) user = temp ;}
		
		return user;
	}
	
	
	// Test fonction de recherche
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("Entrez une id d'utilisateur : ");
		int id = scan.nextInt();
		System.out.println();
		
		
		Utilisateur trouveLeMoi = findByKey(id);
		
		System.out.println(
							trouveLeMoi.getIdUtilisateur() + " " +
							trouveLeMoi.getNom() + " " +
							trouveLeMoi.getPrenom()
							);
		
		scan.close();
	}
		
}
