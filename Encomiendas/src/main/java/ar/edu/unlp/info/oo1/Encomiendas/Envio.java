package ar.edu.unlp.info.oo1.Encomiendas;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
public class Envio {
    private LocalDate fecha;
    private String destino;
    private ArrayList<Paquete> paquetes;

    public Envio (LocalDate unaFecha, String unDestino) {
        this.fecha = unaFecha;
        this.destino = unDestino;
        this.paquetes = new ArrayList<Paquete>();
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String getDestino() {
        return destino;
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
        return Math.toIntExact(dias);
    }

    public ArrayList<Paquete> getPaquetes() {
        return paquetes;
    }
}