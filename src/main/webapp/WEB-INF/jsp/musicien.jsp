<!DOCTYPE html>
<html lang="fr">
<head>
	<meta charset="UTF-8">
	<title>Musicien créé</title>
	<link rel="icon" type="image/x-icon" href="Ma photo.jpg">
	<link rel="stylesheet" type="text/css" href="<c:url value='/css/style.css' />">
</head>
<body>
	<h1 class="titre">Confirmer le musicien enregistré</h1>
	<p>Nom : ${musicien.nom }</p>
	<p>Prénom: ${musicien.prenom }</p>
	<h2>Adresse</h2>
	<p>Numero de rue : ${musicien.adresse.numero }</p>
	<p>Rue : ${musicien.adresse.rue }</p>
	<p>Code Postal : ${musicien.adresse.codePostal }</p>
	<p>Ville : ${musicien.adresse.ville }</p>
	<h2>Renseignements complémentaires</h2>
	<p>Téléphone : ${musicien.telephone }</p>
	<p>E-Mail : ${musicien.email }</p>
	<p>Instrument joué : ${musicien.instrument }</p>
	<a href="/MusicSchool/Groupe">Lien vers un groupe</a>
</body>
</html>