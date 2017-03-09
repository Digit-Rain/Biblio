package metier;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Exemplaire {
	private int idExemplaire;
	private Date dateAchat;
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private metier.EnumStatusExemplaire status;
	private String isbn = "isbn inconnu";
	
	public Exemplaire(int idExemplaire, Date dateAchat, EnumStatusExemplaire status, String isbn) {
		this.setIdExemplaire(idExemplaire);
		this.setDateAchat(dateAchat);
		this.setStatus(status);
		this.setIsbn(isbn);
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

	public void setStatus(metier.EnumStatusExemplaire status) {
		this.status = status;
	}



	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}


	@Override
	public String toString() {
		return "Exemplaire [N� Id Exemplaire = " + idExemplaire + ", Date d'achat = " + sdf.format(dateAchat) + ", Status = " + status
				+ ", N� ISBN = " + isbn +"]";
	}
	
}
