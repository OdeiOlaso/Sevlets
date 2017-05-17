public class Threads {

	public static void main(String[] args) {

		Corredor c1 = new Corredor(1);
		Corredor c2 = new Corredor(2);
		Corredor c3 = new Corredor(3);
		Corredor c4 = new Corredor(4);
		Corredor c5 = new Corredor(5);
		Corredor c6 = new Corredor(6);
		Corredor c7 = new Corredor(7);

		Thread t1 = new Thread(c1);
		Thread t2 = new Thread(c2);
		Thread t3 = new Thread(c3);
		Thread t4 = new Thread(c4);
		Thread t5 = new Thread(c5);
		Thread t6 = new Thread(c6);
		Thread t7 = new Thread(c7);

		t1.start();// c1.run();
		t2.start();// c2.run();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		t7.start();

		boolean finCarrera = false;

		while (!finCarrera) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.println("Corredor" + c1.getDorsal() + ": " + c1.getPosicion());
			System.out.println("Corredor" + c2.getDorsal() + ": " + c2.getPosicion());
			System.out.println("Corredor" + c3.getDorsal() + ": " + c3.getPosicion());
			System.out.println("Corredor" + c4.getDorsal() + ": " + c4.getPosicion());
			System.out.println("Corredor" + c5.getDorsal() + ": " + c5.getPosicion());
			System.out.println("Corredor" + c6.getDorsal() + ": " + c6.getPosicion());
			System.out.println("Corredor" + c7.getDorsal() + ": " + c7.getPosicion());

			finCarrera = c1.getPosicion() >= 9 || c2.getPosicion() >= 9 || c3.getPosicion() >= 9 || c4.getPosicion() >= 9 || c5.getPosicion() >= 9 || c6.getPosicion() >= 9 || c7.getPosicion() >= 9;
		}

		c1.parar();
		c2.parar();
		c3.parar();
		c4.parar();
		c5.parar();
		c6.parar();
		c7.parar();

		int ganador = c1.getPosicion() >= 9 ? c1.getDorsal() : c2.getDorsal();
		ganador = c2.getPosicion() >= 9 ? c2.getDorsal() : ganador;
		ganador = c3.getPosicion() >= 9 ? c3.getDorsal() : ganador;
		ganador = c4.getPosicion() >= 9 ? c4.getDorsal() : ganador;
		ganador = c5.getPosicion() >= 9 ? c5.getDorsal() : ganador;
		ganador = c6.getPosicion() >= 9 ? c6.getDorsal() : ganador;
		ganador = c7.getPosicion() >= 9 ? c7.getDorsal() : ganador;

		System.out.println("GANADOR: " + ganador);

	}

}
