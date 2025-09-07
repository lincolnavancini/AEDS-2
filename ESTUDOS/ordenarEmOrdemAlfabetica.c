#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main (void){

    char** listaNomes; //Array de ponteiros pra armazenar os nomes
    char nome[50]; //Array de caracteres (strin) de tamanho 50 para ler cada nome
    int n; //Quantidade de nomes da lista

    scanf("%d", &n); //Lê a quantidade de nomes
    getchar();

    listaNomes = malloc(n * sizeof(char*)); // Aloca 

    for(int i = 0; i < n; i++){ //Lê um nome a cada iteração e aloca na lista com o tamanho do nome
        fgets(nome, sizeof(nome), stdin);
        nome[strcspn(nome, "\n")] = '\0';

        listaNomes[i] = malloc ((strlen(nome) + 1) * sizeof(char));
        strcpy(listaNomes[i], nome);
    }
    
    for(int i = 0; i < n - 1; i++){ //Bubblesort pra colocar os nomes em ordem alfabetica
        for(int j = 0; j < n-i-1; j++){
            if(strcmp(listaNomes[j], listaNomes[j+1]) > 0){
                char *temp = listaNomes[j];
                listaNomes[j] = listaNomes[j+1];
                listaNomes[j+1] = temp;
            }
        }
    }

    for(int i = 0; i < n; i++){
        printf("%s\n", listaNomes[i]);
        free(listaNomes[i]);
    }

    free(listaNomes);

    return 0;
}