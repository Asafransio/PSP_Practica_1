package tema3;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class EjemploURL2{

	public static void main(String[] args){
		URL url = null;
		URLConnection urlCon = null;
		try{
			url = new URL("http://192.168.0.20:8080/PSP/procesa.php");
			urlCon=url.openConnection();
			urlCon.setDoOutput(true);
			String cadena = "nombre=Francisco&apellidos=Borrallo";
			PrintWriter out = new PrintWriter(urlCon.getOutputStream());
			out.write(cadena);
			out.flush();
			out.close();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(urlCon.getInputStream()));
			String linea;
			
			while((linea = br.readLine())!=null) {
				System.out.println(linea);
			}
			
			
		}
		catch (MalformedURLException e){
			System.out.println(e);
		}
		catch (IOException e){
			System.out.println(e);
		}
	}
}