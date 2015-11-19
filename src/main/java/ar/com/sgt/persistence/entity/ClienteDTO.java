package ar.com.sgt.persistence.entity;

public class ClienteDTO {

    private int id_usuario;
    private String nombre;
    private String apellido;
    private String cbu;
    private int pin;

    public int getId_usuario() {
	return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
	this.id_usuario = id_usuario;
    }

    public String getNombre() {
	return nombre;
    }

    public void setNombre(String nombre) {
	this.nombre = nombre;
    }

    public String getApellido() {
	return apellido;
    }

    public void setApellido(String apellido) {
	this.apellido = apellido;
    }

    public String getCbu() {
	return cbu;
    }

    public void setCbu(String cbu) {
	this.cbu = cbu;
    }

    public int getPin() {
	return pin;
    }

    public void setPin(int pin) {
	this.pin = pin;
    }

}
