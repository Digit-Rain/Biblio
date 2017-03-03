package metier;


//import java.util.Date;
import java.util.GregorianCalendar;


public class Personne 
{
	private String nom = "Non renseigné";
	private String prenom = "Non renseigné";
	private GregorianCalendar dateNaissance = new GregorianCalendar(0,0,0);
	private String sexe = "Non renseigné";
	
	
	
	public Personne () { }
	
	public Personne ( String nom, String prenom, GregorianCalendar dateNaissance, String sexe) 
	{ setNom(nom) ; setPrenom(prenom) ; setDateNaissance(dateNaissance); setSexe(sexe); }
	
	
	public String getNom() {return nom;}
	public String getSexe() {return sexe;}
	public String getPrenom() {return prenom;}
	public GregorianCalendar getDateNaissance() {return dateNaissance;}
	
	
	public void setNom(String nom) {this.nom = nom;}
	public void setSexe(String sexe) {this.sexe = sexe;}
	public void setPrenom(String prenom) {this.prenom = prenom;}
	public void setDateNaissance(GregorianCalendar dateNaissance) {this.dateNaissance = dateNaissance;}
	
	
	/*public static void main(String[] args) 
	{

	}*/
	
}
