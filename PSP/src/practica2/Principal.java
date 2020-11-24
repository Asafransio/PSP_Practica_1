package practica2;

import java.util.Scanner;



public class Principal extends Thread{

	public static int cantidadJinetes;
	public static int distanciaMeta;
	public Jinete camello;
	
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Indique el numero de jinetes:");
		cantidadJinetes = teclado.nextInt();
		
		System.out.println("Indique la distancia a la que está la meta:");
		distanciaMeta = teclado.nextInt();
		
		try {
			for (int i=1; i<=cantidadJinetes;i++) {
				
				Jinete j = new Jinete("Camello" + (i));
				Thread t = new Thread(j);
				t.start();
			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		
		
		teclado.close();
	}
	
	
	
}
