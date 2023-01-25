package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class ConnexionFilter
 */
@WebFilter(description = "Verification de connexion", urlPatterns = {
		"/Musicien", "/Groupe" })
public class ConnexionFilter extends HttpFilter implements Filter {

	private static final long serialVersionUID = 1L;
	private static final String URL_INDEX = "/WEB-INF/jsp/index.jsp";

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpSession session = ((HttpServletRequest) request).getSession();
		if (session.getAttribute("user") == null) {
			request.setAttribute("erreur",
					"Vous n'êtes pas connecté pour utiliser cette fonctionnalité");
			this.getServletContext().getRequestDispatcher(URL_INDEX)
					.forward(request, response);
		} else {
			chain.doFilter(request, response);
		}
	}

}
