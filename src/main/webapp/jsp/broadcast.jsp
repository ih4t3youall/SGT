<html>
<head>


<script
	src="${pageContext.servletContext.contextPath}/js/jquery-1.11.3.min.js"></script>


<script type="text/javascript">


function enviarRequest(){
	var mensaje = $("#mensaje").val();
	console.log(mensaje);
	
	if(mensaje != ""){
	
$.ajax({
		
		url : "/sgt/admin/enviar",
    	data : "mensaje="+mensaje,
			
		success : function(response){
			$('#contenedor').append("<h1>"+response+"</h1>");
		}
		

	});
	
	}else {
		
		alert("debe ingresar un mensaje! ");
		
	}
	
}



</script>

</head>
<body>



	<input type="text" id="mensaje" placeholder="escriba un texto" />
	<input onclick="enviarRequest()" type="button" value="send request" />

	<div id="contenedor"></div>

</body>

</html>






