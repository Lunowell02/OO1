package ar.edu.unlp.info.oo1.Encomiendas;

import java.util.*;
public abstract class Paquete {
    private double gr;
    private double volumen;
    private double valor;
    private List<Producto> productos;

    public Paquete (double unosGr, double unVolumen, double unValor) {
        this.gr = unosGr;
        this.volumen = unVolumen;
        this.valor = unValor;
        this.productos= new ArrayList<Producto>();
    }

    public double getGr() {
        return gr;
    }

    public void setGr(double gr) {
        this.gr = gr;
    }

    public double getVolumen() {
        return volumen;
    }

    public void setVolumen(double volumen) {
        this.volumen = volumen;
    }

    public double getValor() {
        return valor;
    }
    public double getPesoTotal(Producto producto) {
        double pesoTotal = this.productos.stream()
                .mapToDouble(p -> p.getPeso())
                .sum() + producto.getPeso();
        return pesoTotal;
    }
    public double getVolumenTotal(Producto producto) {
         double volumenTotal = this.productos.stream()
                    .mapToDouble(p -> p.getVolumen())
                    .sum() + producto.getVolumen();
         return volumenTotal;
    }
    public void agregarProducto(Producto producto) {
        if (this.puedeAgregarProducto(this.getPesoTotal(producto), this.getVolumenTotal(producto))) {
            this.productos.add(producto);
        } else {
            System.out.println("El producto no cabe en el paquete.");
        }
    }


    public void setValor(double valor) {
        this.valor = valor;
    }
    public boolean puedeAgregarProducto(double pesoTotal, double volumenTotal) {
            return pesoTotal <= this.getGr() && volumenTotal <= this.getVolumen();
        }
}
