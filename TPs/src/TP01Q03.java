//Ciframento de César
public class TP01Q03 {

	public static String criptografar(String str) {
		int tam = str.length();
		String novaPalavra = "";
		int letra ;
		for(int i = 0;  i < tam; i++){
		    letra = (int)str.charAt(i) + 3;
			novaPalavra = novaPalavra + (char)letra; 
		}
		return novaPalavra;
	}
	
	public static void main(String[] args) {
	    String str = "";
		int x = 1;
		while(x == 1) {
		    str = MyIO.readLine();
		    if (str.equals("FIM")) {
                x = -1;
	        } else {
	            MyIO.println(criptografar(str));
	        }
		}
	}
}
