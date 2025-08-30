#include <stdio.h>
#include <string.h>

//Pal�ndromo recursivo
int isPalindromo(char palavra [], int tam){
    int i = 0;
    while(i != tam){
        if(palavra[i] != palavra[tam-1-i]){
            return -1;
        }else{
          i++;
        }
    }
    return 1;
}

int palindromo(char palavra []){
    int tam = strlen(palavra);
    return isPalindromo(palavra, tam);
}

int main(){
    char palavra[1000];
    int result, x = 1;
    while(x == 1){
        scanf(" %[^\n]", palavra);
        result = palindromo(palavra);
        if(strcmp(palavra, "FIM") == 0){
            x = -1;
        }else{
            if(result == 1){
                printf("SIM\n");
            }else{
                printf("NAO\n");
            }
        }
    }
    return 0;
}
