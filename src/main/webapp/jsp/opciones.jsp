<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<script src="resources/jquery/jquery-1.11.3.min.js"></script>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="resources/bootstrap-3.3.5-dist/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet"
	href="resources/bootstrap-3.3.5-dist/css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->
<script src="resources/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="well">

		<ul class="nav nav-pills nav-justified">


			<c:if test="${not empty clienteDTO}">

				<h1>Bienvenido ${clienteDTO.nombre}</h1>
			</c:if>

			<c:forEach var="entry" items="${opciones}">


				<ul class="nav nav-pills nav-justified">
					<li class="active" role="presentation"><a
						href="<c:out value="${entry.value}"/>"><c:out
								value="${entry.key}" /></a></li>
				</ul>
				<br />

			</c:forEach>


		</ul>

		<ul class="nav nav-pills nav-justified">
			<li class="active" role="presentation"><a
				href="seleccionarUsuario.htm" />Volver</a></li>
				</ul>

	</div>

</body>

</html>