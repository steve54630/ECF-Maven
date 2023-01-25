package utilitaires;

public class TokenHelper {

	public static String generateToken(final int quantite) {

		String choix = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
				+ "abcdefghijklmnopqrstuvwxyz" + "0123456789";
		StringBuilder s = new StringBuilder(quantite);
		for (int i = 0; i < quantite; i++) {
			int index = (int) (choix.length() * Math.random());
			s.append(choix.charAt(index));
		}
		return s.toString();
	}
	
	public static String generateCSRF() {
		return generateToken(100);
	}

}
