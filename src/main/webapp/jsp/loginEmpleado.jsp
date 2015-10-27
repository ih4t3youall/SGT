<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->
<script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootbox.min.js"></script>
<script src="${pageContext.request.contextPath}/js/validacion.js"></script>



<title>SGT</title>
</head>
<body>
	<c:url value="j_spring_security_check" var="loginUrl" />
	


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
	<%-- <form name='f' action="${loginUrl}" method='POST'> --%>

	<%-- 	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /> --%>

	<%-- <form id="loginEmpleadoForm" method="post" action="/loginEmpleadoSucces.htm"> --%>
	<!-- 	commandName="carForm"> -->
	<div class="container">

		


		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<div class="panel panel-default">
					<div class="panel-heading">
						<div class="panel-title">
							<!-- 	                                <i class="glyphicon glyphicon-wrench pull-right"></i> -->
							<h4>Ingreso Usuario</h4>
						</div>
					</div>
					<div class="panel-body">
						<form name='f' action="${loginUrl}" method='POST'
							class="form form-vertical">
							<c:if test="${not empty error}">
			<div class="alert alert-danger fade in">Usuario o contrase�a
				incorrecta.</div>
		</c:if>
							<label>Usuario</label>
							<div class="input-group">
								<!-- 	                                    <label>Usuario</label> -->
								<!-- 	                                    <div class="controls"> -->
								<span class="input-group-addon" id="basic-addon1"><span
									class="glyphicon glyphicon-user" aria-hidden="true"></span></span> <input
									name='j_username' id="user" type="text" class="form-control"
									placeholder="Ingrese Usuario" aria-describedby="basic-addon1" />

								<!-- 	                                    </div> -->
							</div>

							<label>Contrase�a</label>
							<div class="input-group">
								<span class="input-group-addon" id="basic-addon1"><span
									class="glyphicon glyphicon-lock" aria-hidden="true"></span></span> <input
									id="pass" name='j_password' type="password"
									class="form-control" placeholder="Ingrese Contrase�a"
									aria-describedby="basic-addon1" />

							</div>
							<div class="control-group">
								<label></label>
								<div class="controls">
									<button type="submit" class="btn btn-primary"
										onclick="return validarEmpleado('user','pass');">Aceptar</button>
								</div>
							</div>
						</form>
					</div>
					<!--/panel content-->
				</div>
			</div>
		</div>
	</div>
	<%-- 	</form> --%>
</body>
</html>