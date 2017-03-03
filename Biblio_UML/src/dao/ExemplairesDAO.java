package dao;

import java.util.GregorianCalendar;
import java.util.Scanner;

import metier.EnumStatusExemplaire;
import metier.Exemplaire;


public class ExemplairesDAO 
{
	
	
	private static Exemplaire [] exemplaireDB =
		{
				new Exemplaire(1, new GregorianCalendar(1,2,3), EnumStatusExemplaire.DISPONIBLE, "12345"),
				new Exemplaire(2, new GregorianCalendar(3,4,5), EnumStatusExemplaire.DISPONIBLE, "23456"),
				new Exemplaire(3, new GregorianCalendar(5,6,7), EnumStatusExemplaire.DISPONIBLE, "34567"),
				new Exemplaire(4, new GregorianCalendar(8,9,10), EnumStatusExemplaire.DISPONIBLE, "45678"),
		};
	
	
	/* Recherche d'un utilisateur par sa clef */
	public static Exemplaire findByKey (int idExemplaire)
	{
		Exemplaire user = new Exemplaire();
		
		for (Exemplaire temp : exemplaireDB)
		{ if ( temp.getIdExemplaire() == idExemplaire ) user = temp ;}
		
		return user;
	}
	
	
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("Entrez une id de livre : ");
		int id = scan.nextInt();
		System.out.println();
		
		
		Exemplaire trouveLeMoi = findByKey(id);
		
		System.out.println(
							trouveLeMoi.getIdExemplaire() + " " +
							//trouveLeMoi.getDateAchat() + " " +
							trouveLeMoi.getStatus() + " " +
							trouveLeMoi.getIsbn()
							);
		
		scan.close();

	}

	
}
