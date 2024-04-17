package ar.edu.unlp.info.oo1.Encomiendas;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Envio {
	private int demora;
	private LocalDate fecha;
	private String destino;
	private ArrayList<Paquete> paquetes;
	
	public Envio (int unaPrioridad, LocalDate unaFecha, String unDestino) {
		this.demora = unaPrioridad;
		this.fecha = unaFecha;
		this.destino = unDestino;
		this.paquetes = new ArrayList<Paquete>();
	}
	
	
	 public int getDemora() {
		return demora;
	}


	public LocalDate getFecha() {
		return fecha;
	}


	public String getDestino() {
		return destino;
	}


	public ArrayList<Paquete> getPaquetes() {
		return paquetes;
	}


	public void crearEncomiendaMini(ArrayList<Producto> productos) {
	        Mini mini = new Mini();
	        for (Producto producto : productos) {
	            mini.agregarProducto(producto);
	        }
	        this.paquetes.add(mini);
	    }

	    public void crearEncomiendaNormal(ArrayList<Producto> productos) {
	        Normal normal = new Normal();
	        for (Producto producto : productos) {
	            normal.agregarProducto(producto);
	        }
	        this.paquetes.add(normal);
	    }

	    public void crearEncomiendaMax(ArrayList<Producto> productos, double unValor) {
	        Max max = new Max(unValor);
	        for (Producto producto : productos) {
	            max.agregarProducto(producto);
	        }
	        this.paquetes.add(max);
	    }
	    
	    public int calcularDemora() {
	        LocalDate fechaActual = LocalDate.now();
	        long dias = ChronoUnit.DAYS.between(this.fecha, fechaActual);
	        // Puedes ajustar la demora según tus necesidades, por ejemplo, considerando horas o semanas
	        return Math.toIntExact(dias);
	    }
	
}
