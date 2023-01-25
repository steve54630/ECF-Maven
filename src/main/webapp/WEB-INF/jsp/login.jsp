<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="UTF-8">
<link rel="icon" type="image/x-icon" href="images/Music.jpg">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/styleLogin.css">
<title>Page de connexion</title>
</head>
<body>
	<fieldset>
		<legend>Login</legend>
		<form method="post">
			<div>
				<label>Nom </label> <input class="choix" type="text" name="nom"
					id="nom" placeholder="Saisir votre nom"
					<c:if test="${not empty loginName }">value="${loginName }"</c:if>>
			</div>

			<div>
				<label>Mot de passe </label> <input class="choix" type="password"
					name="password" id="password" placeholder="Saisir un mot de passe">
			</div>

			<div>
				<label>Confirmer le mot de passe </label> <input class="choix"
					type="password" name="confirmer" id="confirmer"
					placeholder="Confirmer le mot de passe">
			</div>

			<div>
				<label>Se souvenir de moi</label> <input class="choix"
					type="checkbox" name="souvenir" id="souvenir">
			</div>
			<button type="submit">S'inscrire</button>
		</form>
		
	</fieldset>
	<a class="button" href="index">Retour</a>
	<c:if test="${not empty erreur }">
		<p class="erreur">${erreur }</p>
	</c:if>
</body>
</html>