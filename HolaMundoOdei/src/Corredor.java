public class Corredor implements Runnable { // extends Thread {
	private int dorsal, posicion;
	boolean seguirCorriendo = true;

	public void parar() {
		seguirCorriendo = false;
	}

	public Corredor(int dorsal) {
		this.dorsal = dorsal;
	}

	public int getPosicion() {
		return posicion;
	}

	public int getDorsal() {
		return dorsal;
	}

	@Override
	public void run() {
		for (posicion = 0; posicion <= 10 && seguirCorriendo; posicion++) {
			if (posicion == 9) {

				System.out.println("Dentro" + dorsal + ": FINISH");
			} else {

				System.out.println("Dentro" + dorsal + ": " + posicion);
			}
			try {
				Thread.sleep((long) (Math.random() * 1000));// milisegundos
			} catch (InterruptedException e) {
			}
		}
	}

}
