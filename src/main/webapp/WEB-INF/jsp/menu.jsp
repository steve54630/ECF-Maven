<div class="menu">
	<a class="button" href="Musicien"> Cr�ation d'un musicien</a>
	<a class="button" href="Groupe">Cr�ation d'un groupe</a>
	<a class="button" href="Meteo">M�t�o</a>
	<c:choose>
		<c:when test="${!empty sessionScope.user }">
		<section>
		<p>${sessionScope.user.name } est connect�</p>
		<a class="button" href="Login">D�connexion</a>
		</section>
		</c:when>
		<c:otherwise>
		<a class="button" href="Login">Login</a>
		</c:otherwise>
	</c:choose>
</div>