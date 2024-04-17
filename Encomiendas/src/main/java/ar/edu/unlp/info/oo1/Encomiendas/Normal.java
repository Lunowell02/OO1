package ar.edu.unlp.info.oo1.Encomiendas;

public class Normal extends Paquete {

	public Normal () {// (double unosGr, double unVolumen, double unValor) {
		super (5000, 10000, 1800);
	}
	
	protected boolean puedeAgregarProducto(double pesoTotal, double volumenTotal) {
        return pesoTotal <= this.getGr() && volumenTotal <= this.getVolumen();
    }
}
