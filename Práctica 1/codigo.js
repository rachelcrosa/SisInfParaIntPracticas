// author: rachelcrosa
function validar(){
	var nombre= document.formulario.nombre.value;
	var apellido= document.formulario.apellidos.value;
	var email= document.formulario.email.value;
	var pass= document.formulario.pass.value;
	var rpass= document.formulario.rpass.value;
	var error= "Falta: \n";
	var validar=true;

	if(nombre.length==0){
		error=error+("El nombre esta vacío\n");
		validar= false;
	}
	if(apellido.length==0){
		error=error+("El apellido esta vacío\n");
		validar= false;
	}
	if(!email.includes("@")){
		error=error+("El correo no está bien escrito, le falta el @\n");
		validar= false;
	}
	if(email.indexOf(".",email.indexOf("@",0))==-1){
		error=error+("No hay . después del @\n");
		validar= false;
	}
	if(pass.length<8){
		error=error+("La contraseña es muy corta, mínimo 8 caráctereres\n");
		validar= false;
	}
	if(pass!=rpass){
		error=error+("No coinciden las contraseñas\n");
		validar= false;
	}
	if(!validar) {
		alert(error);
	}
		return validar;

}
