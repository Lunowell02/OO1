package ar.edu.unlp.info.oo1.Encomiendas;

public class Producto {
	private String descripcion;
	private double peso;
	private double volumen;
	
	public Producto (String unaDescripcion, Double unPeso, double unVolumen) {
		this.descripcion = unaDescripcion;
		this.peso = unPeso;
		this.volumen = unVolumen;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getVolumen() {
		return volumen;
	}

	public void setVolumen(double volumen) {
		this.volumen = volumen;
	}
	
	
}
