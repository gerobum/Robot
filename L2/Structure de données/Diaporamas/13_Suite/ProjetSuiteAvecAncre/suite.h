/* 
 * File:   suite.h
 * Author: yvan
 *
 * Created on 26 mars 2014, 11:06
 */

#ifndef SUITE_H
#define	SUITE_H

#include<string>
#include<ostream>

using namespace std;

class suite {
public:
  suite();
  suite(const suite& orig);
  ~suite();
  bool vide() const {
    return d_ancre.d_suivant == &d_ancre;
  }
  suite& operator=(const suite& s);
  // Accès aux éléments en lecture et écriture
  //suite::iterateur operator[](int i);
  //suite::iterateur_constant operator[](int i) const;
  //int taille() const;
  // void inserer(string valeur, int position = 0);
  // void inserer(string valeur, double autre);
  // void retirer(int position = 0);
  // void retirer(string valeur);
  // void ajouterApresLeDernier(string v1, string v2);

private:

  class element {
  public:
    string d_info;
    element * d_suivant;

    element(string info, element* suivant = 0) :
    d_info(info), d_suivant(suivant) { }
  };
  // Il faut un élément (l'ancre)
  element d_ancre;
  // Il est toujours présent donc 
  // ce peut être un objet (plutôt qu'un pointeur).

public: // Classe interne
  class iterateur_constant {
  public:
    string operator *() const; // Déréférencement
    iterateur_constant& operator++(); // Au suivant !
    bool fin() const; // Y en a-t'il encore ?
    friend class suite;
  private:
    // L'itérateur encapsule l'élément "courant"
    const element* d_crt;
    // et un pointeursur l'ancre (pour reconnaître la fin)
    const element* d_ancre;
    // ainsi que son constructeur.

    iterateur_constant(const element* crt) : d_ancre(crt), d_crt(crt) {
    }
  };
  iterateur_constant premier_constant() const;

  class iterateur {
  public:
    string operator *() const; // Déréférencement
    string& operator *(); // Déréférencement
    iterateur& operator++(); // Au suivant !
    bool fin() const; // Y en a-t'il encore ?
    friend class suite;
  private:
    // L'itérateur encapsule l'élément "courant"
    element* d_crt;
    // et un pointeursur l'ancre (pour reconnaître la fin)
    element* d_ancre;
    // ainsi que son constructeur.

    iterateur(element* crt) : d_ancre(crt), d_crt(crt) {
    }
  };
  iterateur premier();
  
  void inserer(string s, const iterateur& i);
  void retirer(const iterateur& i);
  
  void inserer(string s);
  void retirer();

};

ostream& operator<<(ostream& os, const suite& s);
#endif	/* SUITE_H */

