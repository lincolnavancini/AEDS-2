#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <locale.h>

#define MAX_NOME 100
#define MAX_NOMES 100

int main (void){

    setlocale(LC_ALL, "");

    FILE* arqNomes;
    FILE* arqSaida;
    char** listaNomes; //Array de ponteiros pra armazenar os nomes
    char nome[MAX_NOME]; //Array de caracteres (strin) de tamanho 50 para ler cada nome
    int n = 0; //Indice pra coletar os nomes na lista do arquivo

    arqNomes = fopen("nomes.txt", "r");
    if(arqNomes == NULL){
        printf("Nao foi possivel abrir o arquivo\n");
        return 1;
    }else {
        printf("Arquivo aberto com sucesso\n");
    }

    listaNomes = malloc(MAX_NOMES * sizeof(char*)); // Aloca um array de ponterios para um array de caracteres (nomes)

    while(fgets(nome, sizeof(nome), arqNomes) != NULL && n < MAX_NOMES){ // Loop para ler os nomes do arquivo nomes.txt
        nome[strcspn(nome, "\n")] = '\0';
        listaNomes[n] = malloc((strlen(nome) + 1) * sizeof(char));
        strcpy(listaNomes[n], nome);
        n++;
    }

    fclose(arqNomes);
    
    for(int i = 0; i < n - 1; i++){ //Bubblesort pra colocar os nomes em ordem alfabetica
        for(int j = 0; j < n-i-1; j++){
            if(strcmp(listaNomes[j], listaNomes[j+1]) > 0){
                char *temp = listaNomes[j];
                listaNomes[j] = listaNomes[j+1];
                listaNomes[j+1] = temp;
            }
        }
    }

    arqSaida = fopen("ordenado.txt", "w"); // Abre o arquivo ordenado.txt para escrever os nomes em ordem alfabetica
    if(arqSaida == NULL){
        printf("Erro ao criar arquivo de saida\n");
        return 1;
    }else {
        printf("Arquivo de saida criado com sucesso\n");
    }

    for(int i = 0; i < n; i++){ // Escreve os nomes em ordem alfabética dentro do arquivo
        fprintf(arqSaida, "%s\n", listaNomes[i]);
        free(listaNomes[i]);
    }

    free(listaNomes);

    fclose(arqSaida);

    printf("Nomes ordenados em ordem alfabetica com sucesso");

    return 0;
}