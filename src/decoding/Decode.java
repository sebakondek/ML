package decoding;

public class Decode {

	public String decodeBits2Morse(String bits) {
		
		StringBuilder stringBuilder = new StringBuilder();
		
		String morse;
		String pulse;
		String auxBits;
		boolean flag = false;
		
		//inicializo auxbits ignorando la primer pausa larga para evitar errores de corte
		auxBits = bits.substring(bits.indexOf("1"));
		
		while(auxBits.length() > 0) {
			
			//utilizo un flag para saber cuando busca espacios y cuando pulsos
			if(!flag) {
				
				//si el infexof(0) de auxbits retorna -1 utiliza la posicion del ultimo 1 +1
				pulse = auxBits.substring(0, auxBits.indexOf("0") < 0 ? auxBits.lastIndexOf("1") + 1 : auxBits.indexOf("0"));
				flag = true;
				
			} else {
				
				//si el infexof(1) de auxbits retorna -1 utiliza la posicion del ultimo 0 +1
				pulse = auxBits.substring(0, auxBits.indexOf("1") < 0 ? auxBits.lastIndexOf("0") + 1 : auxBits.indexOf("1"));
				flag = false;
			}
			
			//envio el pulso y el flag a la funcion
			morse = transformBits2Morse(pulse, flag);
			
			//si la respuesta de la funcion es distinta de null, apendo la respuesta al stringbuilder
			if(morse != null) {
				stringBuilder.append(morse);
			//si la respuesta era null, significa que era un espacio largo por lo que corto la ejecucion retornando el stringbuilder
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
