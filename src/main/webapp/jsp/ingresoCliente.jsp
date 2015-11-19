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



<form:form style="display: none;" method="post" name="pin" id="ingresoPin"
						action="verificarPin.htm" modelAttribute="pinDTO" >
						<div class="input-control text full-size">
							<form:input type="text" path="pin" id="numeroPin" />
						</div>
					</form:form>
	<div class="well">

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


<div class="container">
  <table class="table table-bordered">
    <tbody>
      <tr>
        <td onclick="pulsar(1)">1</td>
        <td onclick="pulsar(2)">2</td>
        <td onclick="pulsar(3)">3</td>
      </tr>
      <tr>
        <td onclick="pulsar(4)">4</td>
        <td onclick="pulsar(5)">5</td>
        <td onclick="pulsar(6)">6</td>
      </tr>
      <tr>
        <td onclick="pulsar(7)">7</td>
        <td onclick="pulsar(8)">8</td>
        <td onclick="pulsar(9)">9</td>
      </tr>
      <tr>
        <td></td>
        <td onclick="pulsar(0)">0</td>
        <td></td>
      </tr>
      <tr>
        <td onclick="borrar()">Borrar</td>
        <td onclick="aceptar()">Aceptar</td>
        <td onclick="window.location.replace('seleccionarUsuario.htm');">Volver</td>
      </tr>
    </tbody>
  </table>
</div>




	</div>

</body>

</html>