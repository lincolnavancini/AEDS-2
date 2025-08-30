import java.util.*;

//Palindromo 
public class TP01Q01 {

	 public static void main(String[] args){
	    	Scanner input = new Scanner(System.in);
	    	int x = 1;
	    	String str;
	    	while(x == 1) {
	    		str = input.nextLine();
	    		if(str.equals("FIM")){
	    			x = -1;
	    		}else{
	    			if(palindromo(str) == true) {
	    				System.out.println("SIM");
	    			}else {
	    				System.out.println("NAO");
	    			}
	    		}
	    	}
	    	input.close();
	    }
	    public static boolean palindromo(String str){
	    	int tam = str.length();
	    	return palindromo(str, tam);
	    }
	    public static boolean palindromo(String str, int tam) {
	    	int j = tam-1;
	    	for(int i = 0; i < tam/2; i++) {
	    		if(str.charAt(i) != str.charAt(j)) {
	    			return false;
	    		}else {
	    			j--;
	    		}
	    	}
	    	return true;
	    }
	}
