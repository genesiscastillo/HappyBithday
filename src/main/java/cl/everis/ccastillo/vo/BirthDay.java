package cl.everis.ccastillo.vo;

import java.util.ArrayList;
import java.util.List;

public class BirthDay {

	private String nombre ="";
	private String apellido = "";
	private String fecha;
	private Integer edad;
	private Integer diasFaltante;
	private List<Poema> poemas = new ArrayList<Poema>();
	
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
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	public Integer getDiasFaltante() {
		return diasFaltante;
	}
	public void setDiasFaltante(Integer diasFaltante) {
		this.diasFaltante = diasFaltante;
	}
	public List<Poema> getPoemas() {
		return poemas;
	}
	public void setPoemas(List<Poema> poemas) {
		this.poemas = poemas;
	}
	@Override
	public String toString() {
		return "BirthDay [nombre=" + nombre + ", apellido=" + apellido + ", fecha=" + fecha + ", edad=" + edad
				+ ", diasFaltante=" + diasFaltante + "]";
	}
}
