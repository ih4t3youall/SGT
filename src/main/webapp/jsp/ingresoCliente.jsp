<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
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


<script type="text/javascript">
	$(document).ready(function() {
		$('#pin').val("");
	});

	var cadena = "";
	function pulsar(numero) {
		cadena += numero;
		$('#pin').val(cadena);

	}

	
	function aceptar(){
		$('#numeroPin').val(cadena);
		$('#ingresoPin').submit();
		
	}
	
	function borrar() {

		cadena = cadena.slice(0, -1);
		$('#pin').val(cadena);

	}
</script>

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

<form:form style="display: none;" method="post" name="pin" id="ingresoPin"
						action="verificarPin.htm" modelAttribute="pinDTO" >
						<div class="input-control text full-size">
							<form:input type="text" path="pin" id="numeroPin" />
						</div>
					</form:form>
<!-- 	<div class="well"> -->
<div class="container">
		<ul class="nav nav-pills nav-justified">



			<ul class="nav nav-pills nav-justified">
				<div class="input-group input-group-lg">
					<span id="sizing-addon1" class="input-group-addon">PIN</span> <input
						type="text" id="pin" aria-describedby="sizing-addon1"
						placeholder="" class="form-control " disabled="disabled" >
				</div>
			</ul>
		</ul>
		<br />



  <table class="table">
    <tbody>
      <tr>
        <td onclick="pulsar(1)" class="btn btn-default">1</td>
        <td onclick="pulsar(2)" class="btn btn-default">2</td>
        <td onclick="pulsar(3)" class="btn btn-default">3</td>
      </tr>
      <tr>
        <td onclick="pulsar(4)" class="btn btn-default">4</td>
        <td onclick="pulsar(5)" class="btn btn-default">5</td>
        <td onclick="pulsar(6)" class="btn btn-default">6</td>
      </tr>
      <tr>
        <td onclick="pulsar(7)" class="btn btn-default">7</td>
        <td onclick="pulsar(8)" class="btn btn-default">8</td>
        <td onclick="pulsar(9)" class="btn btn-default">9</td>
      </tr>
      <tr>
        <td></td>
        <td onclick="pulsar(0)" class="btn btn-default">0</td>
        <td></td>
      </tr>
      <tr>
        <td onclick="borrar()" class="btn-primary">Borrar</td>
        <td onclick="aceptar()" class="btn-primary">Aceptar</td>
        <td onclick="window.location.replace('seleccionarUsuario.htm');" class="btn-primary">Volver</td>
      </tr>
    </tbody>
  </table>
</div>




<!-- 	</div> -->

</body>

</html>