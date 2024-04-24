package ar.edu.unlp.info.oo1.Encomiendas;

import java.util.*;
import java.util.stream.Collectors;

public class Camion {
    private double carga;
    private double volumen;
    private List<Envio> envios;

    public Camion (double unaCarga, double unVolumen) {
        this.carga = unaCarga;
        this.volumen = unVolumen;
        this.envios = new ArrayList<>();
    }
    
    public List<Envio> cargarCamion(String destino,List<Envio> envios) {
        List<Envio> encomiendasValidas = filtrarEnvios(destino, envios);
        cargarEncomiendas(encomiendasValidas);
        return encomiendasValidas;
    }

    private List<Envio> filtrarEnvios(String destino, List<Envio> envios) {
        return envios.stream()
                .filter(envio -> envio.getDestino().equals(destino)) //filtra los envios por destino
                .sorted(Comparator.comparingInt(envio -> ((Envio) envio).calcularDemora())//ordena los envios por dias de demora
                        .reversed())// como sorted ordena de forma creciente lo damos vuelta
                .collect(Collectors.toList());
    }

    public void cargarEncomiendas(List<Envio> enviosValidados) {
        double cargaActual = 0;
        double volumenActual = 0;

        for (Envio envio : enviosValidados) {
            double pesoTotal = calcularPesoTotal(envio.getPaquetes());
            double volumenTotal = calcularVolumenTotal(envio.getPaquetes());

            if (cargaActual + pesoTotal <= this.carga &&
                volumenActual + volumenTotal <= this.volumen) {
                envios.add(envio);
                cargaActual += pesoTotal;
                volumenActual += volumenTotal;
            }
        }
    }
    
    public double getCarga() {
return carga;
}

public double getVolumen() {
return volumen;
}

public List<Envio> getEnvios() {
        return this.envios;
    }

    public double calcularPesoTotal(List<Paquete> paquetes) {
        return paquetes.stream()
                .mapToDouble(paquete -> paquete.getGr())
                .sum();
    }

    public double calcularVolumenTotal(List<Paquete> paquetes) {
        return paquetes.stream()
                .mapToDouble(paquete -> paquete.getVolumen())
                .sum();
    }
}
