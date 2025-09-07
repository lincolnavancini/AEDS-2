#include <stdio.h>
#include <string.h>

int somaDigitos(int numeros[], int tam) {
    if (tam < 0) {
        return 0;
    } else {
        return numeros[tam] + somaDigitos(numeros, tam - 1);
    }
}

int somaDigitosStr(char digitos[]) {
    int tam = strlen(digitos);
    int numeros[100];

    for (int i = 0; i < tam; i++) {
        numeros[i] = digitos[i] - '0';
    }

    return somaDigitos(numeros, tam - 1);
}

int main() {
    char digitos[100];

    while (1) {
        fgets(digitos, sizeof(digitos), stdin);

        digitos[strcspn(digitos, "\n")] = '\0';

        if (strcmp(digitos, "FIM") == 0) {
            break;
        } else {
            printf("%d\n", somaDigitosStr(digitos));
        }
    }

    return 0;
}
