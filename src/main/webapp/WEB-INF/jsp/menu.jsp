<div class="menu">
	<a class="button" href="Musicien"> Création d'un musicien</a>
	<a class="button" href="Groupe">Création d'un groupe</a>
	<a class="button" href="Meteo">Météo</a>
	<c:choose>
		<c:when test="${!empty sessionScope.user }">
		<section>
		<p>${sessionScope.user.name } est connecté</p>
		<a class="button" href="Login">Déconnexion</a>
		</section>
		</c:when>
		<c:otherwise>
		<a class="button" href="Login">Login</a>
		</c:otherwise>
	</c:choose>
</div>