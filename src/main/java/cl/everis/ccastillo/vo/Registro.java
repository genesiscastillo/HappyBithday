package cl.everis.ccastillo.vo;

public class Registro {

	private String nombreCompleto;
	private String fechaNacimiento;
	
	public String getNombreCompleto() {
		return nombreCompleto;
	}
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	@Override
	public String toString() {
		return "Registro [nombreCompleto=" + nombreCompleto + ", fechaNacimiento=" + fechaNacimiento + "]";
	}
}
