package metier;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import dao.ExemplairesDAO;

public class Exemplaire {
	private int idExemplaire;
	private Date dateAchat;
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private EnumStatusExemplaire status;
	private String isbn = "isbn inconnu";
//	ExemplaireDao exDao = new ExemplaireDao();
	
	public Exemplaire(int idExemplaire, Date dateAchat, EnumStatusExemplaire status, String isbn) {
		this.setIdExemplaire(idExemplaire);
		this.setDateAchat(dateAchat);
		this.setStatus(status);
		this.setIsbn(isbn);
	//	exDao.addExemplaire(this); // Chaque Exemplaire crée est ajouté à la DataBase virtuelle ExemplaireDB.
	}
	
	public Exemplaire() {}
	
	
	public int getIdExemplaire() {
		return idExemplaire;
	}

	public void setIdExemplaire(int idExemplaire) {
		this.idExemplaire = idExemplaire;
	}


	
	public Date getDateAchat() {
		return dateAchat;
	}

	public void setDateAchat(Date dateAchat) {
		this.dateAchat = dateAchat;
	}



	public EnumStatusExemplaire getStatus() {
		return status;
	}

	public void setStatus(EnumStatusExemplaire status) {
		this.status = status;
	}



	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}



	public enum EnumStatusExemplaire {
		DISPONIBLE,
		PRETE,
		SUPPRIME
	}



	@Override
	public String toString() {
		return "Exemplaire [N° Id Exemplaire = " + idExemplaire + ", Date d'achat = " + sdf.format(dateAchat) + ", Status = " + status
				+ ", N° ISBN = " + isbn +"]";
	}
	
	
	public static void main(String[]args) {
		ExemplairesDAO exd = new ExemplairesDAO();
		
		System.out.println("Test ce qu'il y a dans la Dao avant création d'un exemplaire :");
		for (Exemplaire ex : exd.getExemplaireDB()) {
			System.out.println(ex.toString());
		}
		
		System.out.println("\nCréation Exemplaire id n° 01");
		Exemplaire essais = new Exemplaire(01, new GregorianCalendar(2016,10,9).getTime(), EnumStatusExemplaire.DISPONIBLE, "isbn46");
		
		System.out.println("\nTest ce qu'il y a dans ExemplaireDB après création d'un exemplaire :");
		for (Exemplaire ex : exd.getExemplaireDB()) {
			System.out.println(ex.toString());
		}
	}

}
