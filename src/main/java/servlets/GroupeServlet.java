package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Groupe;
import beans.Musicien;

/**
 * Servlet implementation class GroupeServlet
 */
@WebServlet("/Groupe")
public class GroupeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext()
				.getRequestDispatcher("/WEB-INF/jsp/creationGroupe.jsp")
				.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Musicien music1 = null;
		Musicien music2 = null;
		Musicien music3 = null;
		if (!request.getParameter("nomMembre1").equals("")
				&& !request.getParameter("prenomMembre1").equals("")) {
			music1 = new Musicien(request.getParameter("nomMembre1"),
					request.getParameter("prenomMembre1"));
		}
		if (!request.getParameter("nomMembre2").equals("")
				&& !request.getParameter("prenomMembre2").equals("")) {
			music2 = new Musicien(request.getParameter("nomMembre2"),
					request.getParameter("prenomMembre2"));
		}
		if (!request.getParameter("nomMembre3").equals("")
				&& !request.getParameter("prenomMembre3").equals("")) {
			music3 = new Musicien(request.getParameter("nomMembre3"),
					request.getParameter("prenomMembre3"));
		}
		Groupe groupe = new Groupe(request.getParameter("nomGroupe"),
				request.getParameter("dateGroupe"));
		groupe.setMembre(music1);
		groupe.setMembre(music2);
		groupe.setMembre(music3);
		request.setAttribute("groupe", groupe);
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/groupe.jsp")
				.forward(request, response);
	}

}
