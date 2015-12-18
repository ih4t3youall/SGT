<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
		setTimeout(esconder("datosCliente"), 1000);
		$("#datosCliente").hide();
		$("#noHayClientes").show();
		setTimeout(mostrar("noHayClientes"), 1000);
	});

	function noHayCliente() {
		setTimeout(esconder("datosCliente"), 1000);
		$("#datosCliente").hide();
		$("#noHayClientes").show();
		setTimeout(mostrar("noHayClientes"), 1000);
	}

	function hayCliente() {
		setTimeout(esconder("noHayClientes"), 1000);
		$("#noHayClientes").hide();
		$("#datosCliente").show();
		setTimeout(mostrar("datosCliente"), 1000);
	}

	function unaFuncion() {
		setTimeout(esconder("noHayClientes"), 1000);
		$("#noHayClientes").hide();
		$("#datosCliente").show();
		setTimeout(mostrar("datosCliente"), 1000);
	}

	function desEsconder() {
		setTimeout(esconder("datosCliente"), 1000);
		$("#datosCliente").hide();
		$("#noHayClientes").show();
		setTimeout(mostrar("noHayClientes"), 1000);
	}

	function nuevoCliente() {

		mostrar(nuevoCliente);

	}

	function buscarNuevosClientes() {
		//TODO arreglar esto
		var numeroPuesto = 1;

		$.ajax({
			type : "POST",
			contentType : "application/json",
			url : "puestoLibre.htm",
			data : "numeroPuesto=" + numeroPuesto,
			dataType : 'json',
			timeout : 100000,
			success : function(data) {
				cleanForm();
				populateForm(data);
				hayCliente();

			},
			error : function(e) {
				if (e.status == 200) {
					alert("no hay cliente!");
					noHayCliente();
				} else {

					alert("se produjo un error intente otra vez.");
				}
			},
			done : function(e) {
				console.log("DONE");
				enableSearchButton(true);
			}
		});

	}

	function populateForm(data) {
		$("#nombreYApellido").val(data.nombre + ",  " + data.apellido);
		$("#dni").val(data.dni);
		$("#cbu").val(data.cbu);
		$("#numeroCliente").val(data.numeroCliente);

	}

	function cleanForm() {
		$("#nombreYApellido").val("");
		$("#dni").val("");
		$("#cbu").val("");
		$("#numeroCliente").val("");

	}

	function esconder(tag) {

		$("#" + tag).animate({
			opacity : 0,
		}, function() {
		});

	}

	function mostrar(tag) {

		$("#" + tag).animate({
			opacity : 1,
		}, function() {
		});

	}

	function asignarNuevoCliente() {
		
		alert("websocket");
		$("#nuevoCliente").animate({
			opacity : 0,
		}, 1000, function() {
		});
		
		
	}

	function nuevoCliente() {

		$('#nmbCliente').val("bla");
		$("#nuevoCliente").animate({
			opacity : 1,
		}, 1000, function() {
		});

	}
</script>

</head>

<body>
	<div class="navbar navbar-inverse navbar-static-top" id="top-nav">
		<div class="container-fluid">
			<div class="navbar-header">
				<button data-target=".navbar-collapse" data-toggle="collapse"
					class="navbar-toggle" type="button">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a href="#" class="navbar-brand">${empleadoDTO.nombre},
					${empleadoDTO.apellido} </a>
			</div>
		</div>
	</div>


	<div class="container">
		<div class="row">



			<div class="col-md-3">
				<div class="panel panel-default">

					<div class="panel-heading">
						<div class="panel-title">
							<!-- 	                                <i class="glyphicon glyphicon-wrench pull-right"></i> -->
							<h3>Manejo turnos</h3>
						</div>
					</div>

					<div class="panel-body">
						<div aria-label="Vertical button group" role="group"
							class="btn-group-vertical col-md-12">

							<button onclick="buscarNuevosClientes()" class="btn btn-default"
								type="button">
								<h4>Libre</h4>
							</button>



							<button onclick="alert('no se presento')" class="btn btn-default"
								type="button">
								<h4>No se Presento</h4>
							</button>


						</div>
					</div>

				</div>
			</div>

			<div id="datosCliente" class="col-md-6 col-md-offset-0">
				<div class="panel panel-default">

					<div class="panel-heading">
						<div class="panel-title">
							<h3>Datos cliente</h3>
						</div>
					</div>

					<div class="panel-body">
						<div aria-label="Vertical button group" role="group"
							class="btn-group-vertical col-md-12">

							<div class="form-group">
								<label for="exampleInputEmail1">Nombre y apellido</label> <input
									type="text" placeholder="nombre y apellido" value="" readonly
									id="nombreYApellido" class="form-control">
							</div>

							<div class="form-group">
								<label for="exampleInputEmail1">DNI</label> <input type="text"
									placeholder="dni" id="dni" class="form-control" value=""
									readonly>
							</div>

							<div class="form-group">
								<label for="exampleInputEmail1">CBU</label> <input type="text"
									placeholder="CBU" id="cbu" class="form-control" value=""
									readonly>
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">numeroCliente</label> <input
									type="text" placeholder="numeroCliente" id="numeroCliente"
									class="form-control" value="" readonly>
							</div>
							<button type="submit" class="btn btn-primary"
								onclick="alert('finalizo')">Finalizar</button>
						</div>


					</div>



				</div>
			</div>

			<!-- 			lara -->

			<div id="noHayClientes" class="col-md-6 col-md-offset-0">
				<div class="panel panel-default">

					<div class="panel-heading">
						<div class="panel-title">
							<h3>Datos cliente</h3>
						</div>
					</div>

					<div class="panel-body">
						<div aria-label="Vertical button group" role="group"
							class="btn-group-vertical col-md-12">
							<h1>No hay nadie :(</h1>
						</div>


					</div>



				</div>
			</div>

			<!-- 			lara -->

			<div id="nuevoCliente" class="col-md-2">
				<div class="panel panel-default">

					<div class="panel-heading">
						<div class="panel-title">
							<h3>Nuevo cliente</h3>
						</div>
					</div>

					<div class="panel-body">
						<p id="nmbCliente">Aca Nombre nuevo cliente</p>
						<button type="submit" class="btn btn-primary"
							onclick="asignarNuevoCliente()">Aceptar</button>
					</div>

				</div>
			</div>



		</div>
	</div>


	<input type="button" value="esconder" onclick="unaFuncion()" />
	<input type="button" value="mostrar" onclick="desEsconder()" />
	<input type="button" value="nuevoCliente" onclick="nuevoCliente()" />









</body>
</html>
