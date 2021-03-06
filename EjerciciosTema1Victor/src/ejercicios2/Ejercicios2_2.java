package ejercicios2;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicios2_2 {

	public static void escribirFichero(String entrada,StringBuffer cadena){
		OutputStream os;
		try {
			os=Files.newOutputStream(Paths.get(entrada).toRealPath());
			os.write(cadena.toString().getBytes());
			os.close();
		} catch (NoSuchFileException ex){
			System.out.println("No existe el fichero");
		} catch (IOException e) {
			System.out.println("Fallo");
		}
	}
	
	public static String leerTeclado(int i){
		Scanner keyb = new Scanner(System.in);
		System.out.println("Dime frase " + i + ". Pulse 'q' para salir.");
		return keyb.nextLine();
	}
	
	public static String leerNombreFichero(){
		Scanner keyb = new Scanner(System.in);
		System.out.println("Introduce nombre del archivo a crear:");
		return keyb.nextLine();
	}
	
	public static void main(String[] args) {
		int i=0;
		StringBuffer cadena = new StringBuffer();
		String entrada = "";
		boolean sal=false;
		while (!sal) {
			i++;
			entrada = leerTeclado(i);
			if (!entrada.equalsIgnoreCase("q")) {
				cadena.append(entrada).append(System.lineSeparator());
			}else{
				sal=true;
				entrada=leerNombreFichero();
			}
		}
		escribirFichero(entrada, cadena);
	}
}
