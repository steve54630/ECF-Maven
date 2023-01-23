package beans;

import java.time.LocalDate;
import java.util.ArrayList;

public class Groupe {

	private String nom;

	private LocalDate dateCreation;

	private ArrayList<Musicien> membres = new ArrayList<>();

	public Groupe(String nom, String date) {
		this.setNom(nom);
		this.setDateCreation(date);
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public LocalDate getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(String dateCreation) {
		this.dateCreation = LocalDate.parse(dateCreation);
	}

	public ArrayList<Musicien> getMembres() {
		return membres;
	}

	public void setMembres(ArrayList<Musicien> membres) {
		this.membres = membres;
	}

	public void setMembre(Musicien membre) {
		if (membre != null)
			membres.add(membre);
	}

	public void removeMembre(Musicien membre) {
		Musicien musicienSuppr = null;
		for (Musicien musicien : membres) {
			if (membre.getNom().equals(musicien.getNom())
					&& membre.getPrenom().equals(musicien.getPrenom())) {
				musicienSuppr = musicien;
			}
		}
		if (musicienSuppr != null)
			membres.remove(musicienSuppr);
	}

}
