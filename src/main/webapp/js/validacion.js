/**
 * 
 */

function validarEmpleado(user, pass){
	
	if ($('#'+user).val() == ""){
		bootbox.alert("Por favor ingrese un usuario.");
		return false;
	}else{
		if($('#'+pass).val() == ""){
			bootbox.alert("Por favor ingrese la contraseña");
			return false;
		}	
		return true;
	}
	
}