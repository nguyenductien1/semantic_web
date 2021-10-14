package web_semantique;

import java.util.Date;

import org.apache.jena.rdf.model.Resource;
import org.apache.jena.vocabulary.RDFS;

public class Jeux_videos{
	// sans attrubuts 
	private String DeveloppePar;
	private String typeDeJeu;
	private String nomDuJeux;
	private int dateDeSortie;
	
	// constructeur
	
	
	public Jeux_videos() {
		
	}
	
	public Jeux_videos(String nom, int date, String typeDeJeu, String DeveloppePar) {
		this.setDateDeSortie(date);
		this.setNomDujeux(nom);
		this.setTypeDeJeu(typeDeJeu);
		this.setDeveloppePar(DeveloppePar);
	}
	// accesseurs : getteur et setteurs
	
	public String getNomDuJeux() {
		return nomDuJeux;
	}
	public void setNomDujeux(String nomDuJeux) {
		this.nomDuJeux = nomDuJeux;
	}
	
	public int getDateDeSortie() {
		return dateDeSortie;
	}
	public void setDateDeSortie(int dateDeSortie) {
		this.dateDeSortie = dateDeSortie;
	}
	public String getTypeDeJeu() {
		return typeDeJeu;
	}
	public void setTypeDeJeu(String typeDeJeu) {
		this.typeDeJeu = typeDeJeu;
	}
	public String getDeveloppePar() {
		return DeveloppePar;
	}
	public void setDeveloppePar(String DeveloppePar) {
		this.DeveloppePar = DeveloppePar;
	}
}
