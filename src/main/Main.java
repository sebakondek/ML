package main;

import java.util.Scanner;

import conversion.Translate;
import decoding.Decode;

public class Main {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		while(true) {
			System.out.println("Enter the code to translate(2 to exit): ");
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
			String text = scanner.nextLine().trim();
			
			if(text.matches("^[0-1]+$")) {
				Decode decode = new Decode();
				
				System.out.println("\nTranslation:");
				System.out.println(decode.decodeBits2Morse(text) + "\n");
			} else if(text.matches("^[-\\.\\s]+$")) {
				Translate translate = new Translate();
				
				System.out.println("\nTranslation:");
				System.out.println(translate.translate2Human(text) + "\n");
			} else if(text.matches("^[A-Za-z\\.\\s].*")) {
				Translate translate = new Translate();
				
				System.out.println("\nTranslation:");
				System.out.println(translate.translate2Morse(text) + "\n");
			} else if(text.equals("2")){
				System.out.println("\nSuccesfully exited the program.");
				return;
			}else {
				System.out.println("\nERROR:");
				System.out.println("The text entered does not match any accepted format.");
				System.out.println("The text must contain only [0-1] for binary, [. -] for morse, [A-Z a-z .] for ascii or 2 to exit the program.\n");
			}
		}
	}
}
