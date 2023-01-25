package utilitaires;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieHelper {

	public static Cookie createCookie(String name,
			HttpServletResponse response) {
		Cookie cookie = new Cookie(name, TokenHelper.generateCSRF());
		cookie.setMaxAge(60 * 60 * 24 * 7);
		response.addCookie(cookie);
		return cookie;
	}

	public static void destroyCookie(Cookie cookie, HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie2 : cookies) {
			if ((cookie.getName()).equals(cookie2.getName())
					&& (cookie.getValue()).equals(cookie2.getValue()))
				cookie2.setMaxAge(0);
		}
	}

}
