package practica2;



import java.util.Random;
import java.util.Scanner;





public class Principal extends Thread{
	
	public static int cantidadJinetes;
	public static int distanciaMeta;
	static boolean finCarrera = false;
	
	
	public static class Camello implements Runnable{
		
		String name;
		int recorrido = 0;
		int recorre;
		
		Random random = new Random();
		int[] falta = new int[cantidadJinetes];
		
		
		public Camello(String string) {
			name = string;
		}
			
	
		public void run() {
			
			while(finCarrera==false) {
				
				try {
					Thread.sleep(new Random().nextInt(2000));
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				recorre = anda(recorrido, random.nextInt(100));
				
				muestra(recorre);
				
			}
			
		}

		public synchronized void muestra(int recorre) {
			int restante;
			
			if (recorrido<distanciaMeta) {
				recorrido += recorre;
				restante = distanciaMeta - recorrido;
				restante = fijarCero(restante);
				
				String nombre = currentThread().getName();
				int numero = Integer.parseInt(nombre.substring(7));
				
				falta[numero-1]=restante;
				
				System.out.println(currentThread().getName() + " ha avanzado " + recorre + " metros, está a " + falta[numero-1] + " metros de la meta.");
				
			}
			else if (recorrido>=distanciaMeta){
				finCarrera=true;
				System.out.println(currentThread().getName() + " ha avanzado " + recorre + " metros, está a " + falta[Integer.parseInt(currentThread().getName().substring(7))-1] + " metros de la meta.");
				System.out.println(currentThread().getName() + "ha ganado la carrera.");
				for (int i = 1; i <= cantidadJinetes; i++) {
					if (i!=Integer.parseInt(currentThread().getName().substring(7))) {
						System.out.println("Camello"+i+" ha quedado a "+ falta[i-1] + " metros de la meta.");
					}
				}
				System.exit(-1);
			}
			
		}
		
	}

	
	
	
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Indique el numero de jinetes:");
		cantidadJinetes = teclado.nextInt();
		
		System.out.println("Indique la distancia a la que está la meta:");
		distanciaMeta = teclado.nextInt();
		
		try {
			for (int i=1; i<=cantidadJinetes;i++) {
				
				Camello c = new Camello("Camello" + i);
				Thread t = new Thread(c);
				t.setName("Camello" + i);
				t.start();
			}
			
			
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
			
	
		
		teclado.close();
	}
	
	
	
	public static int anda(int recorrido, int avanza) {
		
		int corre;
		
		
		
			if (avanza < 30) {
			
				corre = 0;
				
			}
		
			if ((avanza >= 30)&&(avanza < 70)) {
			
				corre = 1;					
				
			}
		
			if ((avanza >=70)&&(avanza < 90)) {
			
				corre = 2;
			
			}
		
			else {
			
				corre = 3;				
				
			}
			return corre;	
	}

	public static int fijarCero (int numero) {
		if (numero<0) {
			return 0;
		}
		else {
			return numero;
		}
	}
	
}
