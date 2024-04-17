package ar.edu.unlp.info.oo1.Encomiendas;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Paquete {
	private double gr;
	private double volumen;
	private double valor;
	protected ArrayList<Producto> productos;
	
	public Paquete (double unosGr, double unVolumen, double unValor) {
		this.gr = unosGr;
		this.volumen = unVolumen;
		this.valor = unValor;
	}
	
	public double getcosto() {
		return this.valor;
	}
	
	public double getGr() {
		return this.gr;
	}
	
	public double getVolumen() {
		return this.volumen;
	}
	
	public void agregarProducto(Producto producto) {
        double pesoTotal = this.productos.stream()
                .mapToDouble(p -> p.getPeso())
                .sum() + producto.getPeso();
        double volumenTotal = this.productos.stream()
                .mapToDouble(p -> p.getVolumen())
                .sum() + producto.getVolumen();

        if (this.puedeAgregarProducto(pesoTotal, volumenTotal)) {
            this.productos.add(producto);
        } else {
            System.out.println("El producto no cabe en el paquete.");
        }
    }
	
	   protected abstract boolean puedeAgregarProducto(double pesoTotal, double volumenTotal);
	   
	/*public void agregarProducto(Producto producto) {
	    boolean productoCabe = this.productos.stream()
	            .mapToDouble(p -> p.getPeso()) // Expresión lambda
	            .sum() + producto.getPeso() <= this.getGr() &&
	            this.productos.stream()
	            .mapToDouble(p -> p.getVolumen()) // Expresión lambda
	            .sum() + producto.getVolumen() <= this.getVolumen();

	    if (productoCabe) {
	        this.productos.add(producto);
	    } else {
	        System.out.println("El producto no cabe en el paquete Mini.");
	    }
	}*/
	

}
