package practica2;

import java.util.Random;

public class Jinete implements Runnable{

	private String Jinete;
	int recorrido = 0, corre, falta;
	boolean gana = false;
	

	public Jinete (String nombre) {
		this.setJinete(nombre);
	}
	public int fijarCero (int numero) {
		if (numero<0) {
			return 0;
		}
		else {
			return numero;
		}
	}

	
	public void run() {
		while(recorrido<Principal.distanciaMeta) {
			Random random = new Random();
			int avanza = random.nextInt(100);
			
			synchronized (this) {
				
				if (avanza < 30) {
				
					try {
						Thread.sleep(new Random().nextInt(4000));
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				
					corre = 0;
					recorrido += corre;
					falta = Principal.distanciaMeta - recorrido;
					falta = fijarCero(falta);
					System.out.println(Jinete + " ha avanzado " + corre + " metros, está a " + falta + " metros de la meta.");
				}
			
				if ((avanza >= 30)&&(avanza < 70)) {
				
					try {
						Thread.sleep(new Random().nextInt(4000));
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				
					corre = 1;
					recorrido += corre;
					falta = Principal.distanciaMeta - recorrido;
					falta = fijarCero(falta);
					System.out.println(Jinete + " ha avanzado " + corre + " metros, está a " + falta + " metros de la meta.");	
				}
			
				if ((avanza >=70)&&(avanza < 90)) {
				
					try {
						Thread.sleep(new Random().nextInt(4000));
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				
					corre = 2;
					recorrido += corre;
					falta = Principal.distanciaMeta - recorrido;
					falta = fijarCero(falta);
					System.out.println(Jinete + " ha avanzado " + corre + " metros, está a " + falta + " metros de la meta.");
				}
			
				else {
				
					try {
						Thread.sleep(new Random().nextInt(4000));
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				
					corre = 3;
					recorrido += corre;
					falta = Principal.distanciaMeta - recorrido;
					falta = fijarCero(falta);
					System.out.println(Jinete + " ha avanzado " + corre + " metros, está a " + falta + " metros de la meta.");
				}	
			}
			
			gana = true;
		}
		
		
		System.out.println(Jinete + "ha llegado a la meta.");
		System.out.println(Jinete + "ha ganado la carrera.");
		System.exit(1);
	}
	
	
	public synchronized int getFalta() {
		return falta;
	}
	
	
	
	
	
	
	public String getJinete() {
		return Jinete;
	}

	public void setJinete(String jinete) {
		Jinete = jinete;
	}
}
