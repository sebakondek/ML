package main;

import java.util.Scanner;

import conversion.Translate;
import decoding.Decode;

public class Main {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		while(true) {
			System.out.println("Enter the code to translate(2 to exit): ");
			Scanner scanner = new Scanner(System.in);
			//obtengo el texto de la consola sin espacios exteriores
			String text = scanner.nextLine().trim();
			
			//si el texto esta compuesto solamente por 0 y 1
			if(text.matches("^[0-1]+$")) {
				Decode decode = new Decode();
				
				System.out.println("\nTranslation:");
				//imprimo el texto decodificado
				System.out.println(decode.decodeBits2Morse(text) + "\n");
				
			//si el texto esta compuesto por - o . o espacios interiores
			} else if(text.matches("^[-\\.\\s]+$")) {
				Translate translate = new Translate();
				
				System.out.println("\nTranslation:");
				//imprimo el texto traducido a ascii
				System.out.println(translate.translate2Human(text) + "\n");
				
			//si el codigo esta compusto por alfabeto [A-Z] o [a-z] o . con espacios internos
			} else if(text.matches("^[A-Za-z\\.\\s]+$")) {
				Translate translate = new Translate();
				
				System.out.println("\nTranslation:");
				//imprimo el texto codificado a morse
				System.out.println(translate.translate2Morse(text) + "\n");
				
			//si el texto ingresado es igual a 2
			} else if(text.equals("2")){
				System.out.println("\nSuccesfully exited the program.");
				//salgo del programa
				return;
				
			//sino el texto no corresponde con ningun criterio de conversion
			}else {
				System.out.println("\nERROR:");
				System.out.println("The text entered does not match any accepted format.");
				System.out.println("The text must contain only [0-1] for binary, [. -] for morse, [A-Z a-z .] for ascii or 2 to exit the program.\n");
			}
		}
	}
}
