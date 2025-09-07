import java.util.*;

public class AlgebraBooleana{
    public static boolean operacao(String exp){
        Stack<String> stack = new Stack<String>();
        Stack<String> valores = new Stack<String>();
        exp = exp.replace(",", "");
        String[] expressao = exp.split("(?<=\\b(or|and|not)\\b)|(?=[(),])|(?<=[(),])|\\s+");
        for (int i = 0; i < expressao.length; i++) {
            expressao[i] = expressao[i].trim();
        }
        for (int i = 0; i < expressao.length; i++) {
            String item = expressao[i];
            if (item.equals("not") || item.equals("(") || item.equals("and") || item.equals("or") || item.equals("false") || item.equals("true")) {
                stack.push(item);
            }else if(item.equals(")")) {
                while(!stack.isEmpty() && !stack.peek().equals("(")) {
                    valores.push(stack.pop());
                }
                if (!stack.isEmpty() && stack.peek().equals("(")) {
                    stack.pop();
                }
                do {
                    String operador = stack.pop();
                    if (operador.equals("not")) {
                        boolean a = Boolean.parseBoolean(valores.pop());
                        valores.push(Boolean.toString(!a));
                    } else if (operador.equals("and")) {
                        if(valores.size() == 2){
                            boolean b = Boolean.parseBoolean(valores.pop());
                            boolean a = Boolean.parseBoolean(valores.pop());
                            valores.push(Boolean.toString(a && b));
                        }else if(valores.size() == 3){
                            boolean c = Boolean.parseBoolean(valores.pop());
                            boolean b = Boolean.parseBoolean(valores.pop());
                            boolean a = Boolean.parseBoolean(valores.pop());
                            valores.push(Boolean.toString(a && b && c));
                        }else if(valores.size() == 4){
                            boolean d = Boolean.parseBoolean(valores.pop());
                            boolean c = Boolean.parseBoolean(valores.pop());
                            boolean b = Boolean.parseBoolean(valores.pop());
                            boolean a = Boolean.parseBoolean(valores.pop());
                            valores.push(Boolean.toString(a && b && c && d));
                        }
                    } else if (operador.equals("or")) {
                        if(valores.size() == 2){
                            boolean b = Boolean.parseBoolean(valores.pop());
                            boolean a = Boolean.parseBoolean(valores.pop());
                            valores.push(Boolean.toString(a || b));
                        }else if(valores.size() == 3){
                            boolean c = Boolean.parseBoolean(valores.pop());
                            boolean b = Boolean.parseBoolean(valores.pop());
                            boolean a = Boolean.parseBoolean(valores.pop());
                            valores.push(Boolean.toString(a || b || c));
                        }else if(valores.size() == 4){
                            boolean d = Boolean.parseBoolean(valores.pop());
                            boolean c = Boolean.parseBoolean(valores.pop());
                            boolean b = Boolean.parseBoolean(valores.pop());
                            boolean a = Boolean.parseBoolean(valores.pop());
                            valores.push(Boolean.toString(a || b || c || d));
                        }
                    }
                
                } while (!stack.isEmpty() && valores.size() != 1 && !stack.peek().equals("("));
                stack.push(valores.pop());
            }
        }
        return Boolean.parseBoolean(stack.pop());
    }
    
    public static boolean trocaDeValores(int[] vet, String exp){
        String novaExp = "";
        for(int i = 0; i < exp.length(); i++){
            char letra = exp.charAt(i);
            if(letra == 'A'){
                if(vet[0] == 1){
                    novaExp = novaExp + "true";
                }else{
                    novaExp = novaExp + "false";
                }
            }else if(letra == 'B'){
                if(vet[1] == 1){
                    novaExp = novaExp + "true";
                }else{
                    novaExp = novaExp + "false";
                }
            }else if(letra == 'C'){
                if(vet[2] == 1){
                    novaExp = novaExp + "true";
                }else{
                    novaExp = novaExp + "false";
                }
            }else{
               novaExp = novaExp + letra; 
            }
            
        }
        return operacao(novaExp);
    }
    
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		while(n != 0){
		    int[] vet = new int[n];
    		String exp = "";
    		for(int i = 0; i < n; i++){
    		    vet[i] = input.nextInt();
    		}
    		exp = input.nextLine();
    		boolean result = trocaDeValores(vet, exp);
    		if(result == true){
    		    System.out.println(1);
    		}else{
    		    System.out.println(0);
    		}
    		n = input.nextInt();
		}
	}
}