package cl.marely;


public class Utilidad {
	
	
	
	int sleepTimer = 15;

	public void tiempoEspera(String mensaje, int sleepTimer) {
		System.out.print("\n\n\t\t" + mensaje + "");
		for (int i = 0; i < 10; i++) {
			
			try {
				System.out.print(".");
				Thread.sleep(sleepTimer);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println();

	}



	

	



	

}
