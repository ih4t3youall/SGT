<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
</head>
<body>
	  <div class="container">
	<form:form action="createTicket.htm" method="post">
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<!-- 	<div class="well"> -->

				<!-- 		<ul class="nav nav-pills nav-justified"> -->

        <c:choose>
            <c:when test="${not empty clienteDTO}">
                <input type="hidden" name="tipocliente" value="cliente">
                    <h1>Bienvenido ${clienteDTO.nombre}</h1>
            </c:when>
            <c:otherwise>
                <input type="hidden" name="tipocliente" value="nocliente">
            </c:otherwise>
        </c:choose>
				<div class="btn-group-vertical" role="group"
					aria-label="Vertical button group">
					<c:forEach var="entry" items="${opciones}">

						<button type="submit" class="btn btn-default" name="seleccion" onclick="document.getElementById('createTicket').click();" value="${entry.value}">
							<c:out value="${entry.key}"></c:out>
						</button>

					</c:forEach>

					<ul class="nav nav-pills nav-justified">
						<li class="active" role="presentation"><a
							href="seleccionarUsuario.htm" />Volver</a></li>
					</ul>
				</div>
			</div>
		</div>
		</form:form>
	</div> 
</body>

</html>