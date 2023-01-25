<%@ page import="utilitaires.TokenHelper" %>
<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="UTF-8">
<title>Cr�ation d'un musicien</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="icon" type="image/x-icon" href="images/Music.jpg">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/css/style.css' />">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/css/styleMenu.css' />">
</head>

<body>
	<c:import url="/WEB-INF/jsp/menu.jsp"></c:import>
	<c:if test="${not empty erreur }">
		<p class="erreur">${erreur }</p>
	</c:if>
	<h1 class="titre">Cr�ation d'un nouveau Musicien</h1>
	<form method="post" class="creation">
			<c:set var="csrfToken" value ="${TokenHelper.generateCSRF()}"></c:set>
			<c:set var="auth-token" value="${csrfToken}" scope="session"></c:set>
			<input type="hidden" value="${csrfToken}" name="auth-token">
			<label for="nom">Nom: </label><input type="text" name="nom" id="nom">

			<label for="prenom">Pr�nom: </label><input type="text" name="prenom"
				id="prenom"> <label for="numero">Num�ro de rue: </label><input
				type="text" name="numero" id="numero"> <label for="rue">Rue:</label><input
				type="text" name="rue" id="rue"> <label for="codePostal">Code
				postal: </label> <input type="text" name="codePostal" id="codePostal">

			<label for="ville">Ville: </label><input type="text" name="ville"
				id="ville"> <label for="tel">T�l�phone: </label><input
				type="text" name="tel" id="tel"> <label for="email">E-Mail:
			</label><input type="text" name="email" id="email"> <label
				for="instrument">Instrument jou�: </label><input type="text"
				name="instrument" id="instrument">

			<button type="submit" class="bouton">Cr�er</button>
			<button type="reset" class="bouton">Annulez</button>
		</form>
</body>
</html>