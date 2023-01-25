package servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Servlet implementation class MeteoServlet
 */
@WebServlet("/Meteo")
public class MeteoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/meteo.jsp")
				.forward(request, response);
	}

	/**
	 * @throws IOException
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			String urlText = String.format(
					"https://nominatim.openstreetmap.org/search?q=%s&format=json",
					request.getParameter("adress"));
			urlText = urlText.replaceAll("\\s", "+");
			StringBuilder result = getJSON(urlText);
			JSONParser parser = new JSONParser();
			JSONArray jsonArr = (JSONArray) parser.parse(result.toString());
			JSONObject json = (JSONObject) jsonArr.get(0);
			String lat = (String) json.get("lat");
			String lon = (String) json.get("lon");
			
			String lien = "https://api.openweathermap.org/data/2.5/weather?units=metric&lang=fr&lat=%s&lon=%s&appid=%s";
			String appid = "6f6b89d44d8f74c76154886f45a6412e";
			String urlText2 = String.format(lien, lat, lon, appid);
			result = getJSON(urlText2);
			parser = new JSONParser();
			json = (JSONObject) parser.parse(result.toString());
			String city = (String) json.get("name");
			request.setAttribute("city", city);
			JSONObject main = (JSONObject) json.get("main");
			String temperature = (String) main.get("temp").toString();
			request.setAttribute("temperature", temperature);
			JSONArray weather = (JSONArray) json.get("weather");
			Iterator<JSONObject> i = weather.iterator();
			String description = null;
			String icon = null;
			while (i.hasNext()) {
				JSONObject obj = i.next();
				description = (String) obj.get("description");
				icon = (String) obj.get("icon").toString();
			}
			request.setAttribute("temps", "c" + icon);
			request.setAttribute("description", description);
			request.setAttribute("icone",
					"http://openweathermap.org/img/wn/" + icon + "@2x.png");
			doGet(request, response);
		} catch (IndexOutOfBoundsException | ParseException e) {
			request.setAttribute("erreur",
					"Erreur lors de la saisie de l'adresse");
			e.printStackTrace();
			this.getServletContext()
					.getRequestDispatcher("/WEB-INF/jsp/meteo.jsp")
					.forward(request, response);
		} catch (IOException | ServletException e) {
			request.setAttribute("erreur", "Erreur lors de la connexion");
			e.printStackTrace();
			this.getServletContext()
					.getRequestDispatcher("/WEB-INF/jsp/meteo.jsp")
					.forward(request, response);
		}
	}

	protected StringBuilder getJSON(String lien) throws IOException {
		URL url = new URL(lien);
		HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		con.connect();
		BufferedReader br = new BufferedReader(new InputStreamReader(
				con.getInputStream(), StandardCharsets.UTF_8));
		StringBuilder result = new StringBuilder();
		String line;
		while ((line = br.readLine()) != null) {
			result.append(line + "\n");
		}
		br.close();
		return result;
	}

}
