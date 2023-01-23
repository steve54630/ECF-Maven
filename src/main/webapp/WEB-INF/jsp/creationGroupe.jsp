<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="UTF-8">
<title>Création d'un groupe</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="icon" type="image/x-icon" href="images/Ma photo.jpg">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/styleMenu.css">
</head>
<body>
	<c:import url="/WEB-INF/jsp/menu.jsp"></c:import>
	<form class="creation" method="post" action="">
		<h1 class="titre">Création d'un groupe</h1>
		<label for="nomGroupe">Nom du groupe: </label> <input type="text"
			id="nomGroupe" name="nomGroupe" required="required"> <label
			for="dateGroupe">Date de création du groupe: </label> <input
			type="date" id="dateGroupe" name="dateGroupe" required="required">

		<h3>Création membre 1</h3>
		<label for="nomMembre1">Nom du membre: </label> <input type="text"
			id="nomMembre1" name="nomMembre1" required="required"> <label
			for="prenomMembre1">Prénom du membre: </label> <input type="text"
			id="prenomMembre1" name="prenomMembre1" required="required">

		<h3>Création membre 2</h3>
		<label for="nomMembre2">Nom du membre: </label> <input type="text"
			id="nomMembre2" name="nomMembre2"> <label for="prenomMembre2">Prénom
			du membre: </label> <input type="text" id="prenomMembre2"
			name="prenomMembre2">

		<h3>Création membre 3</h3>
		<label for="nomMembre3">Nom du membre: </label> <input type="text"
			id="nomMembre3" name="nomMembre3"> <label for="prenomMembre3">Prénom
			du membre: </label> <input type="text" id="prenomMembre3"
			name="prenomMembre3">

		<button type="submit">Valider</button>
		<button type="reset">Annulez</button>
	</form>
</body>
</html>