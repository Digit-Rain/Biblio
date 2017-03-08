package metier;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class EmpruntEnCours 
{
	private GregorianCalendar dateEmprunt = new GregorianCalendar(0,0,0);
	private Utilisateur emprunteur ;
	private Exemplaire exemplaire ;
	
	
	public GregorianCalendar getDateEmprunt() {return dateEmprunt;}
	public Utilisateur getUtilisateur() {return emprunteur;}
	
	public Exemplaire getExemplaire(){return exemplaire;}
	public void setExemplaire(Exemplaire exemplaire){this.exemplaire = exemplaire;}
	public void setUtilisateur(Utilisateur emprunteur) {this.emprunteur = emprunteur;}
	public void setDateEmprunt(GregorianCalendar dateEmprunt) {this.dateEmprunt = dateEmprunt;}

	
	public EmpruntEnCours () { this( new Utilisateur(), new Exemplaire(), new GregorianCalendar() ); }
	
	public EmpruntEnCours (Utilisateur utilisateur, Exemplaire exemplaire, GregorianCalendar dateEmprunt  ) 
	{ setDateEmprunt(dateEmprunt); setUtilisateur(utilisateur); setExemplaire(exemplaire);}

	
	public boolean isPretEnRetard ()
	{
		
			// Calcul date actuelle moins durée max prêt
			GregorianCalendar gc = new GregorianCalendar();
			gc.set ( gc.get  ( GregorianCalendar.YEAR ),
					 gc.get  ( GregorianCalendar.MONTH ),
					 gc.get  ( GregorianCalendar.DAY_OF_MONTH ),
					 0, 0, 0 );
			
			gc.add ( Calendar.DAY_OF_YEAR, -Adherent.getDureeMaxPrets() );
			
			
			if ( this.getDateEmprunt().before(gc) ) return true;
			else return false ;
			
	}
		
}
