package main;

import decoding.Decode;

public class Main {

	public static void main(String[] args) {
				
		Decode decode = new Decode();
		
		System.out.println(decode.decodeBits2Morse("000000001101101100111000001111110001111110011111100000001110111111110111011100000001100011111100000111111001111110000000110000110111111110111011100000011011100000000"));
		
	}
}