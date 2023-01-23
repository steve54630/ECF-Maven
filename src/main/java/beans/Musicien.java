package beans;

public class Musicien {

	private String nom;

	private String prenom;

	private Adresse adresse;

	private String telephone;

	private String email;

	private String instrument;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getInstrument() {
		return instrument;
	}

	public void setInstrument(String instrument) {
		this.instrument = instrument;
	}

	public Musicien(String nom, String prenom, Adresse adresse,
			String telephone, String email, String instrument) {
		this.setNom(nom);
		this.setPrenom(prenom);
		this.setAdresse(adresse);
		this.setTelephone(telephone);
		this.setEmail(email);
		this.setInstrument(instrument);
	}

	public Musicien(String nom, String prenom) {
		this.setNom(nom);
		this.setPrenom(prenom);
	}

}
