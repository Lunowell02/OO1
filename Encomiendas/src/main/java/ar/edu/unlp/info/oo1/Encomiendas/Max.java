package ar.edu.unlp.info.oo1.Encomiendas;

public class Max extends Paquete{

	public Max (double unValor){//(double unosGr, double unVolumen, double unValor) {
		super (15000, 25000,unValor);
	}
	
	protected boolean puedeAgregarProducto(double pesoTotal, double volumenTotal) {
        return pesoTotal <= this.getGr() && volumenTotal <= this.getVolumen();
    }
}
