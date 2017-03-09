package dao;


import java.util.ArrayList;
import java.util.GregorianCalendar;


import metier.BiblioException;
import metier.EnumStatusExemplaire;
import metier.Exemplaire;

public class ExemplairesDAO {
	
	private static ArrayList<Exemplaire> exemplaireDB = new ArrayList<Exemplaire>();
	
  
	
	public ExemplairesDAO() {
		ExemplairesDAO.exemplaireDB.add(new Exemplaire(123, new GregorianCalendar(2017,1,15).getTime(), EnumStatusExemplaire.DISPONIBLE, "isbn123"));
		ExemplairesDAO.exemplaireDB.add(new Exemplaire(456, new GregorianCalendar(2016,11,18).getTime(), EnumStatusExemplaire.DISPONIBLE, "isbn456"));
		ExemplairesDAO.exemplaireDB.add(new Exemplaire(789, new GregorianCalendar(2016,10,3).getTime(), EnumStatusExemplaire.DISPONIBLE, "isbn789"));
		ExemplairesDAO.exemplaireDB.add(new Exemplaire(147, new GregorianCalendar(2017,0,5).getTime(), EnumStatusExemplaire.DISPONIBLE, "isbn147"));
		ExemplairesDAO.exemplaireDB.add(new Exemplaire(258, new GregorianCalendar(2016,10,8).getTime(), EnumStatusExemplaire.DISPONIBLE, "isbn258"));
		ExemplairesDAO.exemplaireDB.add(new Exemplaire(369, new GregorianCalendar(2016,2,9).getTime(), EnumStatusExemplaire.DISPONIBLE, "isbn369"));

	}
	
	
	public ArrayList<Exemplaire> getExemplaireDB() {
		return exemplaireDB;
	}

	
	/** Permet d'ajouter un exemplaire manuellement dans la DataBase virtuelle (exemplaireDB). */
	public void addExemplaire (Exemplaire exemplaire) {
		exemplaireDB.add(exemplaire);
	}
	
	/** Affiche le contenu de la DataBase virtuelle (exemplaireDB) avec un toString
	 * sur chaque Exemplaire trouvé. */
	public void afficheExemplaire() {
		for (Exemplaire ex : exemplaireDB)
			System.out.println(ex.toString());
	}
	
	/** Permet de trouver un Exemplaire dans la DataBase virtuelle (exemplaireDB) grâce à son ID. */
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
