import java.util.*;

public class Inversao {
	public static String inversao(String palavra) {
		String novaPalavra = "";
		char letra;
		int tam = palavra.length();
		for(int i = tam; i > 0; i--) {
			letra = palavra.charAt(i-1);
			novaPalavra = novaPalavra + letra;
		}
		return novaPalavra;
	}
	public static void main(String[] args) {
	    Scanner input = new Scanner(System.in);
    	String palavra;
	    int x = 1;
	    while(x == 1){
		    palavra = input.nextLine();
	        if(palavra.equals("FIM")){
	            x = -1;
	        }else{
	            System.out.println(inversao(palavra));
	        }
	    }
	}
}