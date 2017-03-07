package metier;

import java.util.GregorianCalendar;

public class Employe extends Utilisateur
{
	
	private String codeMatricule = "Non Renseigné";
	private EnumCategorieEmploye categorieEmploye = EnumCategorieEmploye.BIBLIOTHECAIRE ;
	
	
	public String getCodeMatricule() {return codeMatricule;}
	public EnumCategorieEmploye getCategorieEmploye() {return categorieEmploye;}
	
	
	public void setCodeMatricule(String codeMatricule) {this.codeMatricule = codeMatricule;}
	public void setCategorieEmploye(EnumCategorieEmploye categorieEmploye) {this.categorieEmploye = categorieEmploye;}

	
	public Employe() { this("", "", new GregorianCalendar(0,0,0), "", "", "", 0, "", EnumCategorieEmploye.BIBLIOTHECAIRE); }
	
	public Employe( String nom, String prenom, GregorianCalendar dateNaissance, String sexe, 
					String pwd, String pseudonyme, int idUtilisateur, 
					String codeMatricule, EnumCategorieEmploye categorieEmploye) 
	{ super(nom, prenom, dateNaissance, sexe, pwd, pseudonyme, idUtilisateur); 
	setCodeMatricule(codeMatricule) ; setCategorieEmploye(categorieEmploye);}
	
	
	@Override public String toString() 
	{
		return super.toString() + " Matricule=[" + codeMatricule 
								+ "] Catégorie Employé=[" + getCategorieEmploye() + "]" ; 
	}
	
	
}
