package metier;

import java.util.GregorianCalendar;


public class Exemplaire 
{
	private int idExemplaire = 0 ;
	private GregorianCalendar dateAchat = new GregorianCalendar();
	private EnumStatusExemplaire status = EnumStatusExemplaire.DISPONIBLE;
	private String isbn = "Non renseigné";
		
	
	public Exemplaire() {}
	
	public Exemplaire ( int idExemplaire, GregorianCalendar dateAchat, EnumStatusExemplaire status, String isbn)
	{ setIdExemplaire(idExemplaire); setDateAchat(dateAchat); setStatus(status); setIsbn(isbn); }	
	
	public int getIdExemplaire() {return idExemplaire;}
	public void setIdExemplaire(int idExemplaire) {this.idExemplaire = idExemplaire;}
	public GregorianCalendar getDateAchat() {return dateAchat;}
	public void setDateAchat(GregorianCalendar dateAchat) {this.dateAchat = dateAchat;}
	public EnumStatusExemplaire getStatus() {return status;}
	public void setStatus(EnumStatusExemplaire status) {this.status = status;}
	public String getIsbn() {return isbn;}
	public void setIsbn(String isbn) {this.isbn = isbn;}
	
}
