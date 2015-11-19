<html>
<head>
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
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<div class="panel panel-default">
					<div class="panel-heading">
						<div class="panel-title">
							<!-- 	                                <i class="glyphicon glyphicon-wrench pull-right"></i> -->
							<h3>Ingreso Cliente</h3>
						</div>
					</div>

					<div class="panel-body">
						<div class="btn-group-vertical col-md-12" role="group"
							aria-label="Vertical button group">

							<button type="button" class="btn btn-default"
								onclick="document.getElementById('usuarioCliente').click();">
								<h4>Cliente</h4>
							</button>



							<button type="button" class="btn btn-default"
								onclick="document.getElementById('usuarioNoCliente').click();">
								<h4>No Cliente</h4>
							</button>


						</div>
					</div>
					<!-- 							<button type="submit" class="btn btn-primary" -->
					<!-- 								onclick="return validarEmpleado('user','pass');">Aceptar</button> -->

				</div>
			</div>

		</div>
	</div>
	<!-- 	<div class="well"> -->

	<!-- 		<ul class="nav nav-pills nav-justified"> -->
	<!-- 			<li class="active" role="presentation"><a -->
	<!-- 				href="usuarioCliente.htm">Cliente</a></li> -->
	<!-- 			<li role="presentation"><a href="usuarioNoCliente.htm">No -->
	<!-- 					cliente</a></li> -->
	<!-- 		</ul> -->

	<%-- <a id="privacyLink" style="visibility: hidden;" data-rel="dialog" href="${pageContext.request.contextPath}/privacy.do"></a> --%>
	<!-- 	</div> -->


	<a id="usuarioCliente" href="usuarioCliente.htm"
		style="visibility: hidden;" />
	<a id="usuarioNoCliente" href="usuarioNoCliente.htm" style="visibility: hidden;" />
</body>

</html>