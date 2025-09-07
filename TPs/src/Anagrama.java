import java.util.*;

public class Anagrama{
    public static String[] separarString(String frase){
        int tam = frase.length(), j = 0;
        char c;
        String[] str = new String[2];
        str[0] = "";
        str[1] = "";
        for(int i = 0; i < tam; i++){
            c = frase.charAt(i);
            if(c == '-'){
                j++;
            }else if(c != ' '){
                str[j] = str[j] + c;
            }
        }
        return str;
    }
    
    public static boolean verificacaoDeAnagrama(String p1, String p2){
        if(p1.length() != p2.length()){
            return false;
        }
        for(int i = 0; i < p1.length(); i++){
            int rept = 0, cont = 0;
            for(int j = 0; j < p1.length(); j++){
                if(p1.charAt(j) == p2.charAt(i)){
                    rept++;
                }
            }
            for(int k = 0; k < p1.length(); k++){
                if(p2.charAt(k) == p2.charAt(i)){
                    cont++;
                }
            }
            if(cont != rept){
                return false;
            }
        }
        return true;
    }
    
	public static void main(String[] args) {
		String frase = "", p1, p2;
		int x = 1, a = 195;
		boolean result;
		while(x == 1){
		    frase = MyIO.readLine();
		    if(frase.equals("FIM")){
		        x = -1;
		    }else{
		        String [] str = separarString(frase);
		        p1 = str[0].toLowerCase();
		        p2 = str[1].toLowerCase();
		        result = verificacaoDeAnagrama(p1,p2);
		        if(result == true){
		            System.out.println("SIM");
		        }else{
		            System.out.println("N" + (char)a + "O");
		        }
		    }
		}
	}
}