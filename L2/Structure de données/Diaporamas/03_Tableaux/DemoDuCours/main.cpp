
#include <cstdlib>
#include <iostream>

#include "TableauDynamique.h"

using namespace std;

int main() {
    /*int n;
     cout << "Combien d'éléments : ";
     cin >> n;
    int ti[n]; // Un tableau de n entiers

    for (int i = 0; i < n; i++) {
        cout << "Entrez la valeur d'indice " << i << " : ";
        cin >> ti[i];
    }
    double s = 0;
    for (int i = 0; i < n; i++) {
        s += ti[i];
    }
    cout << "La moyenne : " << s / n;*/


    int n;
    cout << "Combien d'éléments : ";
    cin >> n;

    TableauDynamique t;

    for (int i = 0; i < n; i++) {
        t.ajouter(rand());
    }
    double s = 0;
    for (int i = 0; i < n; i++) {
        s += t[i];
    }
    cout << "La moyenne : " << s / n;


}

