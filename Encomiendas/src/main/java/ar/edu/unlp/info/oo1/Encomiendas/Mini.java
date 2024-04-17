package ar.edu.unlp.info.oo1.Encomiendas;

import java.util.ArrayList;
import java.util.List;

public class Mini extends Paquete {
	
	public Mini () { //(double unosGr, double unVolumen, double unValor) {
		super (1200, 1300, 750);	
	}
	
	protected boolean puedeAgregarProducto(double pesoTotal, double volumenTotal) {
        return pesoTotal <= this.getGr() && volumenTotal <= this.getVolumen();
    }
		
}
