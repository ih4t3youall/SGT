<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
	<div id="top-nav" class="navbar navbar-inverse navbar-static-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Sistema de Gestion de turnos</a>
			</div>
			<!--         <div class="navbar-collapse collapse"> -->
			<!--             <ul class="nav navbar-nav navbar-right"> -->
			<!--                 <li class="dropdown"> -->
			<!--                     <a class="dropdown-toggle" role="button" data-toggle="dropdown" href="#"><i class="glyphicon glyphicon-user"></i> Admin <span class="caret"></span></a> -->
			<!--                     <ul id="g-account-menu" class="dropdown-menu" role="menu"> -->
			<!--                         <li><a href="#">My Profile</a></li> -->
			<!--                     </ul> -->
			<!--                 </li> -->
			<%--                 <li><a href="<c:url value="j_spring_security_logout"/>"><i class="glyphicon glyphicon-lock"></i> Logout</a></li> --%>
			<!--             </ul> -->
			<!--         </div> -->
		</div>
		<!-- /container -->
	</div>
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



						<!-- 				<ul class="nav nav-pills nav-justified"> -->
						<!-- 					<li class="active" role="presentation"><a -->
						<%-- 						href="<c:out value="${entry.value}"/>"><c:out --%>
						<%-- 								value="${entry.key}" /></a></li> --%>
						<!-- 				</ul> -->
						<!-- 				<br /> -->

					</c:forEach>


					<!-- 		</ul> -->

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