<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="UTF-8">
<link rel="icon" type="image/x-icon" href="images/Music.jpg">
<link type="text/css" rel="stylesheet" href="css/styleIndex.css">
<title>Index</title>
</head>
<body>
	
	<h1>Bienvenue sur le site MusicSchool</h1>

	<p>A l'aide de cette application, il va vous être possible de créer
		des groupes et des adhérents pour ses groupes. Pour commencer,
		veuillez choisir une des options suivantes: </p>
		
	<c:import url="/WEB-INF/jsp/menu.jsp"></c:import>
	
	<c:if test="${not empty erreur }">
		<p class="erreur">${erreur }</p>
	</c:if>
</body>
</html>