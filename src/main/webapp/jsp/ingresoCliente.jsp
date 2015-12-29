<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
<script type="text/javascript">
	$(document).ready(function() {
		$('#pin').val("");
	});

	var cadena = "";
	function pulsar(numero) {
		cadena += numero;
		$('#pin').val(cadena);

	}

	function aceptar() {
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
	<div class="container-fluid">
		<form:form style="display: none;" method="post" name="pin"
			id="ingresoPin" action="verificarPin.htm" modelAttribute="pinDTO">
			<div class="input-control text full-size">
				<form:input type="text" path="pin" id="numeroPin" />
			</div>
		</form:form>
            <c:if test="${not empty error}">
                                    <div class="alert alert-danger fade in">PIN inválido</div>
                                </c:if>
		<div class="input-group input-group-lg">
			<span id="sizing-addon1" class="input-group-addon">PIN</span> <input
				type="text" id="pin" aria-describedby="sizing-addon1" placeholder=""
				class="form-control " disabled="disabled">
		</div>



		<div class="btn-group btn-group-justified">
			<a onclick="pulsar(1)" class="btn btn-default">1</a> <a
				onclick="pulsar(2)" class="btn btn-default">2</a> <a
				onclick="pulsar(3)" class="btn btn-default">3</a>
		</div>

		<div class="btn-group btn-group-justified">
			<a onclick="pulsar(4)" class="btn btn-default">4</a> <a
				onclick="pulsar(5)" class="btn btn-default">5</a> <a
				onclick="pulsar(6)" class="btn btn-default">6</a>
		</div>

		<div class="btn-group btn-group-justified">
			<a onclick="pulsar(7)" class="btn btn-default">7</a> <a
				onclick="pulsar(8)" class="btn btn-default">8</a> <a
				onclick="pulsar(9)" class="btn btn-default">9</a>
		</div>
		<div class="btn-group btn-group-justified">
			<a  class="btn btn-default disabled"></a> 
			<a onclick="pulsar(0)" class="btn btn-default">0</a> 
			<a  class="btn btn-default disabled"></a>
		</div>

		<div class="btn-group btn-group-justified">
			<a onclick="borrar()" class="btn btn-primary">Borrar</a> <a
				onclick="aceptar()" class="btn btn-primary">Aceptar</a> <a
				onclick="window.location.replace('seleccionarUsuario.htm');"
				class="btn btn-primary">Volver</a>
		</div>

	</div>


</body>

</html>