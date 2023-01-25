package beans;

import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import exception.AppException;

public class Utilisateur {

	private String name;

	private String password;

	public String getName() {
		return name;
	}

	public void setName(String name) throws AppException {
		if (!Pattern.matches("[a-zA-Z0-9]{1,}", name))
			throw new AppException(
					"Format pseudo : lettres et chiffres sans espaces");
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Utilisateur(HttpServletRequest request) throws AppException {
		String nom = request.getParameter("nom");
		String motDePasse = request.getParameter("password");
		String confirm = request.getParameter("confirmer");
		this.setName(nom);
		if (motDePasse.equals(""))
			throw new AppException("Mot de passe oublié");
		if (confirm.equals(""))
			throw new AppException("Confirmer le mot de passe");
		if (!motDePasse.equals(confirm))
			throw new AppException("Mot de passe non confirmé");
		this.setPassword(motDePasse);
	}

}
