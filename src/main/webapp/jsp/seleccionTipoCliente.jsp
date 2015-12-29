<html>
<head>
</head>
<body>
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

				</div>
			</div>

		</div>
	</div>

	<a id="usuarioCliente" href="usuarioCliente.htm"
		style="visibility: hidden;" />
	<a id="usuarioNoCliente" href="usuarioNoCliente.htm"
		style="visibility: hidden;" />
</body>

</html>