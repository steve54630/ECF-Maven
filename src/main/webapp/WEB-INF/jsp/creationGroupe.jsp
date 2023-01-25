<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="UTF-8">
<title>Création d'un groupe</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="icon" type="image/x-icon" href="images/Music.jpg">
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<link rel="stylesheet" type="text/css" href="css/styleMenu.css">
</head>
<body>
	<c:import url="/WEB-INF/jsp/menu.jsp"></c:import>
	<c:if test="${not empty membres }">
	<form class="creation" method="post" action="">
		<h1 class="titre">Création d'un groupe</h1>
		<label for="nomGroupe">Nom du groupe: </label> <input type="text"
			id="nomGroupe" name="nomGroupe" required="required"> <label
			for="dateGroupe">Date de création du groupe: </label> <input
			type="date" id="dateGroupe" name="dateGroupe" required="required">
		<button class="button" type="submit" name="btn" value="valider">Valider</button>
	</form>
	</c:if>
	<form class="creation" method="post" action="">
		<h3>Création membre</h3>
		<label for="nom">Nom du membre: </label> <input type="text" id="nom"
			name="nom"> <label for="prenom">Prénom du membre: </label> <input
			type="text" id="prenom" name="prenom">
		<button class="button" type="submit" name="btn" value="ajout">Ajouter</button>
	</form>
	<ul class="erreur">Liste des membres en cours</ul>
	<c:forEach items="${membres}" var="mem">
		<li>${mem.nom }${mem.prenom }</li>
	</c:forEach>
</body>
</html>