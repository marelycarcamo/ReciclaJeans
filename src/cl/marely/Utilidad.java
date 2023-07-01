package cl.marely;



public class Utilidad {
	int sleepTimer = 15;

	public void tiempoEspera(String mensaje, int sleepTimer) {
		System.out.println("\t" + mensaje + "");
		for (int i = 0; i < 10; i++) {
			try {
				System.out.println("\t*");
				Thread.sleep(sleepTimer);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println();

	}

	

	



	

}
