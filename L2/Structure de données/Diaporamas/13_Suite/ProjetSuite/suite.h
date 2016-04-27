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

  // Accès aux éléments en lecture et écriture
  string& operator[](int i);
  string operator[](int i) const;
  int taille() const;
  /* Insérer une valeur à une position donnée
   position<1 => insertion en tête, 
   position trop grand => ajout en fin */
  void inserer(string valeur, int position = 0);
  void inserer(string valeur, double autre);
  // Retirer un élément à une position donnée. 
  void retirer(int position = 0);
  /* Retrait de la première occurence d'une valeur donnée (si elle existe) */
  void retirer(string valeur);
  /* Ajouter v1 après la dernière occurence de v2 */
  void ajouterApresLeDernier(string v1, string v2);
private:
  // Toujours le même "genre" de structure récursive

  class element {
  public:
    string d_info;
    element * d_suivant;

    /*~element() {
      delete d_suivant;
    }*/

    element(string info, element* suivant = 0) :
    d_info(info), d_suivant(suivant) {
    }
  };
  element* d_tete; // Et la tête
  // Comme d'habitude ...
  // friend ostream& operator<<(ostream& os, const suite& s);

public: // Classe interne
  
  class iterateur_constant {
  public:
    // Déréférencement pour consultation
    string operator *() const;
    // Le déréférencement pour modification est absent
    // string& operator *();
    iterateur_constant& operator++(); // Au suivant !
    bool fin() const; // Y en a-t'il encore ?
    friend class suite;
  private:
    const element* d_crt; // L'itérateur encapsule un élément
    // ainsi que son constructeur.
    iterateur_constant(const element* crt = 0) : d_crt(crt) {
    }
  };
  
  iterateur_constant premier_constant() const;

  class iterateur {
  public:
    // Déréférencement pour consultation
    string operator *() const;
    // Déréférencement pour modification
    string& operator *();
    iterateur& operator++(); // Au suivant !
    bool fin() const; // Y en a-t'il encore ?
    friend class suite;
  private:
    element* d_crt; // L'itérateur encapsule un élément
    // ainsi que son constructeur.
    iterateur(element* crt = 0) : d_crt(crt) {
    }
  };
  // La méthode premier() retourne un itérateur 
  // indiquant le premier de la suite.
  iterateur premier();

};
ostream& operator<<(ostream& os, const suite& s);
#endif	/* SUITE_H */

