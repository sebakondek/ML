package decoding;

public class Decode {

	public String decodeBits2Morse(String bits) {
		
		StringBuilder stringBuilder = new StringBuilder();
		
		String morse;
		String pulse;
		String auxBits;
		boolean flag = false;
		
		auxBits = bits.substring(bits.indexOf("1"));
		
		while(auxBits.length() > 0) {
			
			//utilizo un flag para saber cuando busca espacios y cuando pulsos
			if(!flag) {
				
				pulse = auxBits.substring(0, auxBits.indexOf("0") < 0 ? auxBits.lastIndexOf("1") + 1 : auxBits.indexOf("0"));
				flag = true;
				
			} else {
				
				//si el infexof(1) de auxbits retorna -1 utiliza la posicion del ultimo 0 +1
				pulse = auxBits.substring(0, auxBits.indexOf("1") < 0 ? auxBits.lastIndexOf("0") + 1 : auxBits.indexOf("1"));
				flag = false;
			}
			
//			//agrego al stringbuilder el resultado de pasarle los pulsos a la funcion
//			stringBuilder.append(transformBits2Morse(pulse, flag));
			
			morse = transformBits2Morse(pulse, flag);
			if(morse != null) {
				stringBuilder.append(morse);
			}else
				return String.valueOf(stringBuilder);
			
			//extraigo del string auxiliar los pulsos ya agregados
			auxBits = auxBits.substring(pulse.length());
		}		
		
		//convierto el stringbuilder a string y lo retorno
		 return String.valueOf(stringBuilder);
	}
	
	
	private String transformBits2Morse(String string, boolean flag) {
		
		String morse = "";
		
		//chequeo si la string existe
		if(string != null && !string.isEmpty()) {
			
			int strLen = string.length();
			
			//el flag es para saber si estoy trabajando con pausa o pulso y el strLen para saber si es . o -
			if(flag && strLen <= 4) {
				
				morse = ".";
				
			} else if (flag && strLen > 4) {
				
				morse = "-";
				
			} else if(!flag && strLen >= 4 && strLen < 8) {
				
				morse = " ";
				
			} else if(!flag && strLen >= 8) {
				
				return null;
			}
		}
		
		return morse;
	}
}
