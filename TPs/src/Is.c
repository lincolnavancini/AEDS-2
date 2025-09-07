#include <stdio.h>
#include <string.h>
#include <ctype.h>

int vogais(char str[]) {
    int tam = strlen(str);
    for (int i = 0; i < tam; i++) {
        char c = tolower(str[i]);
        if (c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u') {
            return 0;
        }
    }
    return 1;
}

int consoante(char str[]) {
    int tam = strlen(str);
    for (int i = 0; i < tam; i++) {
        char c = tolower(str[i]);
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || isdigit(c) || !isalpha(c)) {
            return 0;
        }
    }
    return 1;
}

int inteiro(char str[]) {
    int tam = strlen(str);
    for (int i = 0; i < tam; i++) {
        if (!isdigit(str[i])) {
            return 0;
        }
    }
    return (tam > 0);
}

int real(char str[]) {
    int tam = strlen(str);
    int cont = 0;
    for (int i = 0; i < tam; i++) {
        char c = str[i];
        if (!isdigit(c)) {
            if ((c == '.' || c == ',') && cont == 0) {
                cont++;
            } else {
                return 0;
            }
        }
    }
    return (tam > 0);
}

const char* resp(int x) {
    return (x ? "SIM " : "NAO ");
}

int main() {
    char str[1000];

    while (1) {
        fgets(str, sizeof(str), stdin);

        str[strcspn(str, "\n")] = '\0';

        if (strcmp(str, "FIM") == 0) {
            break;
        }

        printf("%s%s%s%s\n", resp(vogais(str)), resp(consoante(str)), resp(inteiro(str)), resp(real(str)));
    }

    return 0;
}
