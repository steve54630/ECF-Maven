<!DOCTYPE html>
<html lang="fr">
<head>
	<meta charset="UTF-8">
	<link rel="icon" type="image/x-icon" href="images/Music.jpg">
	<link type="text/css" rel="stylesheet" href="css/styleMenu.css">
	<link type="text/css" rel="stylesheet" href="css/styleMeteo.css">
	<title>Affichage de la météo</title>
</head>
<body class="${temps }">
	<c:import url="/WEB-INF/jsp/menu.jsp"></c:import>
	<c:if test="${not empty erreur }">
		<p class="erreur">${erreur }</p>
	</c:if>
	<section class="meteo">
	<h1>Météo de la journée</h1>
	<h2>Recherche du lieu</h2>
		<form method="post">
			<input type="text" required="required" name="adress" placeholder="Adresse voulu" >
			<button type="submit">Validez</button>
		</form>
	</section>
	<c:if test="${not empty city }">
	<section class="meteo">
	<h2>Météo locale</h2>
		<p> Ville = ${city } </p>
		<p> Température = ${temperature } °C</p>
		<figure>
		<img alt="Icône météo" src="${icone }">
		<figcaption>${description }</figcaption>
		</figure>
	</section>
	</c:if>
	<a class="button meteoBtn" href="index">Retour</a>
</body>
</html>