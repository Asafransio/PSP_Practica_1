package practica;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Funciones {
	
	public static void directorio (String pathname) {
		
		File filePathName = new File (pathname);
		
		File[] files = filePathName.listFiles();
		
		List<File> listTotal = Arrays.asList(files);
		List<File> listFiles = new ArrayList<File>();
		List<File> listDirectories = new ArrayList<File>();
		
		for (File element: listTotal) {
			
			if (element.isDirectory()) {
				listDirectories.add(element);
			} else {
				listFiles.add(element);
			}
			
		}
	}
	public static void desactivaBoton() {
		
	}
}
