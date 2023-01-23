package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Adresse;
import beans.Musicien;
import exception.AppException;

/**
 * Servlet implementation class Musicien
 */
@WebServlet("/Musicien")
public class MusicienServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext()
				.getRequestDispatcher("/WEB-INF/jsp/creationMusicien.jsp")
				.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			Adresse adresse = new Adresse(request.getParameter("numero"),
					request.getParameter("rue"),
					request.getParameter("codePostal"),
					request.getParameter("ville"));
			String telephone = request.getParameter("tel");
			String email = request.getParameter("email");
			String instrument = request.getParameter("instrument");
			Musicien musicien = new Musicien(nom, prenom, adresse, telephone,
					email, instrument);
			request.setAttribute("musicien", musicien);
			this.getServletContext()
					.getRequestDispatcher("/WEB-INF/jsp/musicien.jsp")
					.forward(request, response);
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
