package metier;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;


public class Utilisateur extends Personne
{
	
	private int idUtilisateur = 0 ;
	private String pwd = "";
	private String pseudonyme = "";
	private List <EmpruntEnCours> empruntEnCours = new ArrayList <EmpruntEnCours> ();
	
	
	public Utilisateur () { this( "", "", new GregorianCalendar(0,0,0), "", "", "", 0 ); }
	
	public Utilisateur (String nom, String prenom, GregorianCalendar dateNaissance, String sexe, 
						String pwd, String pseudonyme, int idUtilisateur)
	{ super(nom, prenom, dateNaissance, sexe); setPwd(pwd); setPseudonyme(pseudonyme);
		setIdUtilisateur(idUtilisateur); }
	
	
	public String getPwd() {return pwd;}
	public String getPseudonyme() {return pseudonyme;}
	public int getIdUtilisateur() {return idUtilisateur;}
	
	
	public void setPwd (String pwd) {this.pwd = pwd;}
	public void setPseudonyme (String pseudonyme) {this.pseudonyme = pseudonyme;}
	public void setIdUtilisateur (int idUtilisateur) {this.idUtilisateur = idUtilisateur;}
	
	
	public boolean isConditionPretAcceptees() {return true;}
	
	public int getNbRetards () { return 0; }
	
	public List<EmpruntEnCours> getEmpruntEnCours() {return empruntEnCours;}
	public int getNbEmpruntsEnCours() {return empruntEnCours.size();}

	
	public void addEmpruntEnCours (EmpruntEnCours emprunt) 
	{
		if ( isConditionPretAcceptees() && emprunt.getExemplaire().getStatus() == EnumStatusExemplaire.DISPONIBLE )
		{
			this.empruntEnCours.add(emprunt);
			emprunt.getExemplaire().setStatus(EnumStatusExemplaire.PRETE);
		}
		
		else 
		{
			emprunt = null ;
			try 
			{
				throw new BiblioException("Emprunt du livre par cet adhérent refusé");
			} catch (BiblioException e) { System.out.println(e); }
		}
		
	}
	
	
	@Override public String toString() 
	{
		return super.toString() + " ID Utilisateur=[" + idUtilisateur + "] Pseudonyme=[" + pseudonyme + "]";
	}
	
	/** Retire un emprunt de la liste d'emprunt en cours de l'utilisateur
	 * Crée un emprunt archive et l'ajoute à la liste EmpruntArchive de l'utilisateur */
	public void removeEmpruntEnCours (EmpruntEnCours emprunt) {
		EmpruntArchive ea = new EmpruntArchive(emprunt.getEmprunteur() , emprunt.getExemplaire(), new GregorianCalendar(), emprunt.getDateEmprunt());
		empruntsEnCours.remove(emprunt);
		emprunt.setDateRetour(new GregorianCalendar()); // Créer la date de retour à la date à laquelle le livre est restitué
		if (emprunt.isPretEnRetard() == true){
			emprunt.getEmprunteur().setNbRetards(emprunt.getEmprunteur().getNbRetards() + 1);
		}
	}
	
	/** Affiche la liste d'emprunts de l'emprunteur */
	public void afficheEmpruntEnCours() {
		for (EmpruntEnCours e : empruntsEnCours)
			System.out.println(e.toString());
	}
	
}
