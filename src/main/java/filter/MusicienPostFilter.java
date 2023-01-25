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
 * Servlet Filter implementation class MusicienPostFilter
 */
@WebFilter("/Musicien")
public class MusicienPostFilter extends HttpFilter implements Filter {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3154730119906125229L;

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest requete = (HttpServletRequest) request;
		HttpSession session = requete.getSession();
		String csrf = (String) session.getAttribute("auth-token");
		String csrfPage = requete.getParameter("auth-token");
		if (requete.getMethod().equals("POST")) {
			if (session.getAttribute("auth-token") != null) {
				csrfPage = (String) session.getAttribute("auth-token");
			} else {
				request.setAttribute("erreur", "Le token CSRF n'existe pas");
				this.getServletContext()
				.getRequestDispatcher(requete.getRequestURI())
				.forward(request, response);
			}
			if (!csrf.equals(csrfPage)) {
				System.out.println("Les token CSRF ne sont pas identiques");
				request.setAttribute("erreur",
						"Les token CSRF ne sont pas identiques");
				this.getServletContext()
						.getRequestDispatcher(requete.getRequestURI())
						.forward(request, response);
			}
		} 
		System.out.println("Filtre passé");
		chain.doFilter(request, response);
		}
	}
