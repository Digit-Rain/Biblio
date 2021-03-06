package metier;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import metier.Exemplaire.EnumStatusExemplaire;

public class EmpruntArchive {
	
	private Utilisateur emprunteur;
	private Exemplaire exemplaire;
	private GregorianCalendar dateRestitutionEff;
	private GregorianCalendar dateEmprunt;
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	
	public EmpruntArchive (Utilisateur lemprunteur, Exemplaire lexemplaire, GregorianCalendar laDateRestitutionEff, GregorianCalendar laDateEmprunt) {
		this.setEmprunteur(lemprunteur);
		this.setExemplaire(lexemplaire);
		this.setDateRestitutionEff(laDateRestitutionEff);
		this.setDateEmprunt(laDateEmprunt);
	}

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
		this.exemplaire = unExemplaire;
		unExemplaire.setStatus(EnumStatusExemplaire.DISPONIBLE);
	}

	public Calendar getDateRestitutionEff() {
		return dateRestitutionEff;
	}

	public void setDateRestitutionEff(GregorianCalendar dateRestitutionEff) {
		this.dateRestitutionEff = dateRestitutionEff;
	}

	public Calendar getDateEmprunt() {
		return dateEmprunt;
	}

	public void setDateEmprunt(GregorianCalendar dateEmprunt) {
		this.dateEmprunt = dateEmprunt;
	}

	@Override
	public String toString() {
		return "Emprunts archiv�s :\n[emprunteur = " + emprunteur.getPseudonyme() + ", exemplaire = " + exemplaire.getIdExemplaire() + ", date de restitution = "
				+ sdf.format(dateRestitutionEff.getTime()) + ", date d'emprunt = " + sdf.format(dateEmprunt.getTime()) + "]";
	}

	
	
}
