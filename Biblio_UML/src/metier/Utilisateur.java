package metier;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
//import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;


public class Utilisateur extends Personne
{
	
	private int idUtilisateur = 0 ;
	private String pwd = "";
	private String pseudonyme = "";
	private List <EmpruntEnCours> empruntsEnCours = new ArrayList <EmpruntEnCours> ();
	private List <EmpruntArchive> empruntsArchive = new ArrayList<EmpruntArchive>(); 
	private int nbRetards = 0;
	
	public Utilisateur () { this( "", "", new GregorianCalendar(0,0,0), "", "", "", 0 ); }
	public Utilisateur (String nom, String prenom, GregorianCalendar dateNaissance, String sexe, 
						String pwd, String pseudonyme, int idUtilisateur)
	{ super(nom, prenom, dateNaissance, sexe); setPwd(pwd); setPseudonyme(pseudonyme);
		setIdUtilisateur(idUtilisateur); }
	
	public Utilisateur (String pseudonyme) {
		this.setPseudonyme(pseudonyme);
	}
	
	public String getPwd() {return pwd;}
	public String getPseudonyme() {return pseudonyme;}
	public int getIdUtilisateur() {return idUtilisateur;}
	
	
	public void setPwd (String pwd) {this.pwd = pwd;}
	public void setPseudonyme (String pseudonyme) {this.pseudonyme = pseudonyme;}
	public void setIdUtilisateur (int idUtilisateur) {this.idUtilisateur = idUtilisateur;}
	
	
	public boolean isConditionsPretAcceptees() {return true;}
	
	public int getNbRetards () { return this.nbRetards; }
	public int setNbRetards (int nouveauNbRetards) {
		this.nbRetards = nouveauNbRetards;
		return this.nbRetards; 
	}
	
	
	public void addEmpruntEnCours (EmpruntEnCours emprunt) {
		if (this.isConditionsPretAcceptees() == true)
			empruntsEnCours.add(emprunt);
		else
			try {
				throw new BiblioException("Les conditions de prêts ne sont pas remplies...");
			} catch (BiblioException e) {
				// TODO Auto-generated catch block
				System.err.println(e);
			}
	}
		
	
	/** Retire un emprunt de la liste d'emprunt en cours de l'utilisateur
	 * Crée un emprunt archive et l'ajoute à la liste EmpruntArchive de l'utilisateur */
	public void removeEmpruntEnCours (EmpruntEnCours emprunt) {
		EmpruntArchive ea = new EmpruntArchive(emprunt.getEmprunteur() , emprunt.getExemplaire(), new GregorianCalendar(), emprunt.getDateEmprunt());
		emprunt.getEmprunteur().addEmpruntArchive(ea);
		empruntsEnCours.remove(emprunt);
		}
	
	
	public void addEmpruntArchive (EmpruntArchive archive) {empruntsArchive.add(archive);}
	public List<EmpruntEnCours> getEmpruntEnCours() {return empruntsEnCours;}
	public int getNbEmpruntsEnCours() {return empruntsEnCours.size();}

	public void afficheEmpruntEnCours() {
		for (EmpruntEnCours e : empruntsEnCours)
			System.out.println(e.toString());
	}
	
	public void afficheEmpruntsArchive() {
		for (EmpruntArchive ea : empruntsArchive)
			System.out.println(ea.toString());
	}
	
	

	@Override
	public String toString() {
		return "Utilisateur [idUtilisateur = " + idUtilisateur + ", pseudonyme = " + pseudonyme + ", empruntsEnCours = "
				+ empruntsEnCours + ", empruntsArchive = " + empruntsArchive + "]";
	}
	public void main(String[]args) {
		
	}
}
