<!DOCTYPE html>
<html lang="fr">
<head>
	<meta charset="UTF-8">
	<link rel="icon" type="image/x-icon" href="images/Ma photo.jpg">
	<title>Groupe</title>
</head>
<body>
	<h1 class="titre">Groupe créé</h1>
	<h2>Renseignements du groupe</h2>
	<p>Nom = ${groupe.nom }</p>
	<p>Date = ${groupe.dateCreation }</p>
	<h2>Liste des membres</h2>
	<c:forEach items="${groupe.membres}" var="mem" varStatus="status">
		<h3>Membre <c:out value="${status.count}"></c:out> </h3>
		<p>Nom du membre : <c:out value="${mem.nom}"></c:out></p>
		<p>Prénom du membre : <c:out value="${mem.prenom}"></c:out></p>
	</c:forEach>
	<a href="/MusicSchool/Musicien">Retour à la création d'un musicien</a>
</body>
</html>