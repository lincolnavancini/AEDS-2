import java.util.*;

//Alteração Aleatória
public class TP01Q04 {

	public static String alteracao(String palavra, char letra, char troca, int tam) {
		String novaPalavra = "";
		for(int i = 0; i < tam; i++) {
			if(palavra.charAt(i) == letra) {
				novaPalavra = novaPalavra + troca;
			}else {
				novaPalavra = novaPalavra + palavra.charAt(i);
			}
		}
		return novaPalavra;
	}

	public static String alteracao(String palavra,char letra, char troca) {
		int tam = palavra.length();
		return alteracao(palavra, letra, troca, tam);
	}
	
	public static void main(String[] args){
		int x = 1;
		String palavra;
		Random gerador = new Random();
		gerador.setSeed(4);
		while(x == 1) {
			palavra = MyIO.readLine();
			if(palavra.equals("FIM")) {
				x = -1;
			}else {
			    char letra = (char)('a' + (Math.abs(gerador.nextInt()) % 26));
		        char troca = (char)('a' + (Math.abs(gerador.nextInt()) % 26));
				MyIO.println(alteracao(palavra, letra, troca));
			}
		}
	}
}	