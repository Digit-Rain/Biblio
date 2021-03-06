package dao;

import java.awt.TrayIcon.MessageType;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;

import metier.BiblioException;
import metier.EmpruntEnCours;
import metier.Exemplaire;
import metier.Exemplaire.EnumStatusExemplaire;

public class ExemplairesDAO {
	
	private static ArrayList<Exemplaire> exemplaireDB = new ArrayList<Exemplaire>();
	

	
	public ExemplairesDAO() {
		this.exemplaireDB.add(new Exemplaire(123, new GregorianCalendar(2017,1,15).getTime(), EnumStatusExemplaire.DISPONIBLE, "isbn123"));
		this.exemplaireDB.add(new Exemplaire(456, new GregorianCalendar(2016,11,18).getTime(), EnumStatusExemplaire.DISPONIBLE, "isbn456"));
		this.exemplaireDB.add(new Exemplaire(789, new GregorianCalendar(2016,10,3).getTime(), EnumStatusExemplaire.DISPONIBLE, "isbn789"));
		this.exemplaireDB.add(new Exemplaire(147, new GregorianCalendar(2017,0,5).getTime(), EnumStatusExemplaire.DISPONIBLE, "isbn147"));
		this.exemplaireDB.add(new Exemplaire(258, new GregorianCalendar(2016,10,8).getTime(), EnumStatusExemplaire.DISPONIBLE, "isbn258"));
		this.exemplaireDB.add(new Exemplaire(369, new GregorianCalendar(2016,2,9).getTime(), EnumStatusExemplaire.DISPONIBLE, "isbn369"));

	}
	
	
	public ArrayList<Exemplaire> getExemplaireDB() {
		return exemplaireDB;
	}

	
	/** Permet d'ajouter un exemplaire manuellement dans la DataBase virtuelle (exemplaireDB). */
	public void addExemplaire (Exemplaire exemplaire) {
		exemplaireDB.add(exemplaire);
	}
	
	/** Affiche le contenu de la DataBase virtuelle (exemplaireDB) avec un toString
	 * sur chaque Exemplaire trouv�. */
	public void afficheExemplaire() {
		for (Exemplaire ex : exemplaireDB)
			System.out.println(ex.toString());
	}
	
	/** Permet de trouver un Exemplaire dans la DataBase virtuelle (exemplaireDB) gr�ce � son ID. */
	public Exemplaire findByKey(int id) {
		Exemplaire ex = new Exemplaire(); 
		boolean trouve = false;
			for (Exemplaire e : exemplaireDB) {
				if (e.getIdExemplaire() == id) {
					ex = e;
					trouve = true;
				}
			}
			if (trouve != true) {
					try {
						throw new BiblioException("Exemplaire introuvable");
					} catch (BiblioException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
			return ex;
	}
}
