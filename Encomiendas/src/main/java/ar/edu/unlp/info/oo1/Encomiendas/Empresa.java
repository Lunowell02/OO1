package ar.edu.unlp.info.oo1.Encomiendas;

import java.util.*;
import java.time.LocalDate;
public class Empresa {
    private List<Camion>camiones;
    private List<Envio>envios;

    public Empresa() {
        this.camiones=new ArrayList<Camion>();
        this.envios=new ArrayList<Envio>();
    }

    public void agregarEnvio(LocalDate f,String d) {
        Envio envio= new Envio(f,d);
        this.envios.add(envio);
    }
    public void agregarCamion (double unaCarga, double unVolumen) {
        Camion camion = new Camion(unaCarga, unVolumen);
        this.camiones.add(camion);
    }
    public void cargarCamion(Camion c,String d) {
        c.cargarCamion(d, this.envios);
    }
}