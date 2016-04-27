/* 
 * File:   suite.cpp
 * Author: yvan
 * 
 * Created on 26 mars 2014, 11:06
 */

#include "suite.h"

// Le constructeur par défaut crée une liste vide

suite::suite() : d_tete(0) {
}

// Le constructeur par recopie

suite::suite(const suite& orig) : d_tete(0) {
  if (orig.d_tete != 0) {
    d_tete = new element(orig.d_tete->d_info);
    element* crt = d_tete;
    element* ocrt = orig.d_tete->d_suivant;
    while (ocrt != 0) {
      crt->d_suivant = new element(ocrt->d_info);
      crt = crt->d_suivant;
      ocrt = ocrt->d_suivant;
    }
  }
}

// détruire la tête détruit récursivement toute la liste
// grâve au destructeur d'élément qui détruit son suivant.

suite::~suite() {
  // delete d_tete;
  while (d_tete) {
    retirer();
  }
}

void suite::inserer(string valeur, int position) {
  // cas d'insertion en tête ou dans une liste vide
  if (position <= 0 || d_tete == 0) {
    d_tete = new element(valeur, d_tete);
  } else {
    element* crt = d_tete;
    // Recherche de la position, à moins que la liste
    // ne soit trop courte.
    while (position > 1 && crt->d_suivant != 0) {
      crt = crt->d_suivant;
      --position;
    }
    // Insertion à la bonne position ou en bout de liste
    // si elle est trop courte.
    crt->d_suivant = new element(valeur, crt->d_suivant);
  }
}

ostream& operator<<(ostream& os, const suite& s) {
  os << '[';
  /*if (s.d_tete) {
    os << s.d_tete->d_info;
    suite::element* crt = s.d_tete->d_suivant;
    while (crt) {
      os << ", " << crt->d_info;
      crt = crt->d_suivant;
    }
  }*/
  suite::iterateur_constant i = s.premier_constant();
  if (!i.fin()) {
    os << *i;
    ++i;
    while(!i.fin()) {
      os << ", " << *i;
      ++i;
    }
  }
  os << ']';
  return os;
}

void suite::retirer(int position) {
  // Rien à faire dans une suite vide,
  // ni si la position est négative.
  if (d_tete != 0 || position >= 0) {
    if (position == 0) { // Cas de l'insertion en tête
      element* as = d_tete;
      d_tete = d_tete->d_suivant;
      // Pour éviter la desctruction du reste de la liste.
      as->d_suivant = 0;
      delete as;
    } else { // Recherche de la position.
      element* crt = d_tete;
      while (position > 1 && crt->d_suivant != 0) {
        crt = crt->d_suivant;
        --position;
      }
      if (crt->d_suivant != 0) { // La position existe
        element* as = crt->d_suivant;
        crt->d_suivant = as->d_suivant;
        as->d_suivant = 0;
        delete as;
      } // Sinon, sortie de liste.
    }
  }
}

string& suite::operator[](int n) {
  element* crt = d_tete;
  for (int i = 0; i < n; i++) {
    crt = crt->d_suivant;
  }
  return crt->d_info;
}
string suite::operator[](int n) const {
  element* crt = d_tete;
  for (int i = 0; i < n; i++) {
    crt = crt->d_suivant;
  }
  return crt->d_info;
}

int suite::taille() const {
  element* crt = d_tete;
  int n = 0;
  while (crt) {
    n++;
    crt = crt->d_suivant;
  }
  return n;
}

suite::iterateur_constant suite::premier_constant() const {
  return suite::iterateur_constant(d_tete);
}

bool suite::iterateur_constant::fin() const {
  return d_crt == 0;
}
string suite::iterateur_constant::operator *() const {
  return d_crt->d_info;
}
suite::iterateur_constant& suite::iterateur_constant::operator++() {
  if (d_crt != 0)
    d_crt = d_crt->d_suivant;
  return *this;
}

suite::iterateur suite::premier() {
  return suite::iterateur(d_tete);
}
bool suite::iterateur::fin() const {
  return d_crt == 0;
}
string suite::iterateur::operator *() const {
  return d_crt->d_info;
}
string& suite::iterateur::operator *() {
  return d_crt->d_info;
}
suite::iterateur& suite::iterateur::operator++() {
  if (d_crt != 0)
    d_crt = d_crt->d_suivant;
  return *this;
}