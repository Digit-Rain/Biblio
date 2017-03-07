package metier;
import java.text.SimpleDateFormat;
//import java.util.Date;
import java.util.GregorianCalendar;

import dao.ExemplairesDAO;
import dao.UtilisateursDAO;
import metier.Exemplaire.EnumStatusExemplaire;


public class EmpruntEnCours 
{
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private GregorianCalendar dateEmprunt;
	private Utilisateur emprunteur;
	private Exemplaire exemplaire;

	
	public EmpruntEnCours () { } // constructeur sans param
	public EmpruntEnCours (Utilisateur lemprunteur, Exemplaire lexemplaire, GregorianCalendar dateEmprunt) throws BiblioException { 
		this.setEmprunteur(lemprunteur);
		this.setExemplaire(lexemplaire);
		this.setDateEmprunt(dateEmprunt);
		lemprunteur.addEmpruntEnCours(this);
		}

	public GregorianCalendar getDateEmprunt() {return dateEmprunt;}
	
	public void setDateEmprunt(GregorianCalendar dateEmprunt) {this.dateEmprunt = dateEmprunt;}

	public Utilisateur getEmprunteur() {
		return emprunteur;
	}
	public void setEmprunteur(Utilisateur emprunteur) {
		this.emprunteur = emprunteur;
	}
	public Exemplaire getExemplaire() {
		return exemplaire;
	}
	public void setExemplaire(Exemplaire unExemplaire) {
		if (unExemplaire.getStatus() == EnumStatusExemplaire.DISPONIBLE) {
		this.exemplaire = unExemplaire;
		unExemplaire.setStatus(EnumStatusExemplaire.PRETE);
		}
		else
			try {
				throw new BiblioException("Emprunt impossible. L'exemplaire n° "+ unExemplaire.getIdExemplaire()+" est déjà prêté.");
			} catch (BiblioException e) {
				// TODO Auto-generated catch block
				System.err.println(e);
			}
	}
	

	@Override
	public String toString() {
		return "EmpruntEnCours [Date d'Emprunt = " + sdf.format(dateEmprunt.getTime()) + ", emprunteur = " 
				+ emprunteur.getPseudonyme() + ", exemplaire = "+ exemplaire.getIdExemplaire() + "]\n";
	}
	
	
	public static void main(String[] args) throws BiblioException 
	{
		UtilisateursDAO userDAO = new UtilisateursDAO();
		ExemplairesDAO exDAO = new ExemplairesDAO();
		Utilisateur ad1 = userDAO.findByKey(01);
		Exemplaire ex = exDAO.findByKey(147);
		
		EmpruntEnCours ep = new EmpruntEnCours(ad1, ex, new GregorianCalendar());
		System.out.println("On essaye d'emprunter l'exemplaire n° 147 qui est déjà "+ ex.getStatus()+" => lève BiblioException :");
		EmpruntEnCours ep2 = new EmpruntEnCours(userDAO.findByKey(02), ex, new GregorianCalendar());
	}

}
