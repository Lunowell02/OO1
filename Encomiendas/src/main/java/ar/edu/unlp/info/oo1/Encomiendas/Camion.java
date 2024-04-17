package ar.edu.unlp.info.oo1.Encomiendas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
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
	
	/*public List<Envio> cargarCamion(String destino,List<Envio> encomiendas) {
        List<Envio> encomiendasValidas = encomiendas.stream()
                .filter(envio -> envio.getDestino().equals(destino))
                .sorted(Comparator.comparingInt(Envio::calcularDemora).reversed())
                .collect(Collectors.toList());

        double cargaActual = 0;
        double volumenActual = 0;

        for (Envio envio : encomiendasValidas) {
        	double pesoTotal = envio.getPaquetes().stream()
                    .mapToDouble(paquete -> paquete.getGr())
                    .sum();
            if (cargaActual + pesoTotal <= cargaMaxima &&
                volumenActual + envio.getVolumenTotal() <= volumenMaximo) {
                envios.add(envio);
                cargaActual += pesoTotal;
                volumenActual += envio.getVolumenTotal();
            }
        }

        return envios;
    }*/
	
	public List<Envio> cargarCamion(String destino,List<Envio> encomiendas) {
		List<Envio> encomiendasValidas = filtrarEncomiendas(destino, encomiendas);
        cargarEncomiendas(encomiendasValidas);
        return encomiendasValidas;
    }

    private List<Envio> filtrarEncomiendas(String destino, List<Envio> encomiendas) {
        return encomiendas.stream()
                .filter(envio -> envio.getDestino().equals(destino))
                .sorted(Comparator.comparingInt(envio -> calcularDemora(envio.getFecha()))
                        .reversed())
                .collect(Collectors.toList());
    }

    private void cargarEncomiendas(List<Envio> encomiendasValidas) {
        double cargaActual = 0;
        double volumenActual = 0;

        for (Envio envio : encomiendasValidas) {
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

    private double calcularPesoTotal(List<Paquete> paquetes) {
        return paquetes.stream()
                .mapToDouble(paquete -> paquete.getGr())
                .sum();
    }

    private double calcularVolumenTotal(List<Paquete> paquetes) {
        return paquetes.stream()
                .mapToDouble(paquete -> paquete.getVolumen())
                .sum();
    }
	}

