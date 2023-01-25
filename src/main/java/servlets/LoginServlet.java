package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Utilisateur;
import exception.AppException;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String URL_SERVLET = "/WEB-INF/jsp/login.jsp";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			if(cookie.getName().equals("user.name"))
				request.setAttribute("loginName", cookie.getValue());
		}
		HttpSession session = request.getSession();
		session.removeAttribute("user");
		this.getServletContext().getRequestDispatcher(URL_SERVLET)
				.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			Utilisateur user = new Utilisateur(request);
			if (request.getParameterValues("souvenir") != null) {
				Cookie cookie = new Cookie("user.name", user.getName());
				cookie.setComment("Se souvenir de l'utilisateur");
				cookie.setMaxAge(24 * 60 * 60);
				response.addCookie(cookie);
			}
			else {
				Cookie[] cookies = request.getCookies();
				for (Cookie cookie : cookies) {
					if(cookie.getName().equals("user.name"))
						cookie.setMaxAge(0);
				}
			}
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			response.sendRedirect("index");
		} catch (AppException e) {
			String error = e.getMessage();
			request.setAttribute("erreur", error);
			this.getServletContext().getRequestDispatcher(URL_SERVLET)
					.forward(request, response);
		}
	}

}
