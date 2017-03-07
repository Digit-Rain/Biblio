package metier;
//import java.util.Date;
import java.util.GregorianCalendar;


public class EmpruntEnCours 
{
	private GregorianCalendar dateEmprunt = new GregorianCalendar(0,0,0);
	private int idExemplaire = 0 ;
	private int idUtilisateur = 0 ;
	
	
	public GregorianCalendar getDateEmprunt() {return dateEmprunt;}
	public int getIdExemplaire() {return idExemplaire;}
	public int getIdUtilisateur() {return idUtilisateur;}
	
	
	public void setIdExemplaire(int idExemplaire) {this.idExemplaire = idExemplaire;}
	public void setIdUtilisateur(int idUtilisateur) {this.idUtilisateur = idUtilisateur;}
	public void setDateEmprunt(GregorianCalendar dateEmprunt) {this.dateEmprunt = dateEmprunt;}

	
	public EmpruntEnCours () { this( new GregorianCalendar(), new Utilisateur(), new Exemplaire() ); }
	
	public EmpruntEnCours (GregorianCalendar gregorianCalendar, Utilisateur utilisateur, Exemplaire exemplaire ) 
	{ setDateEmprunt(gregorianCalendar); setIdUtilisateur(idUtilisateur); setIdExemplaire(idExemplaire);}

}
