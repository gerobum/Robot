/* 
 * File:   suite.cpp
 * Author: yvan
 * 
 * Created on 26 mars 2014, 11:06
 */

#include "suite.h"

// Le constructeur par défaut crée une liste vide

suite::suite() : d_ancre("@") {
  d_ancre.d_suivant = &d_ancre;
}

suite::suite(const suite& orig) : d_ancre("@") {
  element* crt = &d_ancre;
  element* ocrt = orig.d_ancre.d_suivant;
  while (ocrt != &orig.d_ancre) {
    crt->d_suivant = new element(ocrt->d_info);
    crt = crt->d_suivant;
    ocrt = ocrt->d_suivant;
  }
  crt->d_suivant = &d_ancre;
}

// détruire la tête détruit récursivement toute la liste
// grâve au destructeur d'élément qui détruit son suivant.

suite::~suite() {
  while(!vide())
    retirer();
}

ostream& operator<<(ostream& os, const suite& s) {
  os << '[';
  suite::iterateur_constant i = s.premier_constant();
  if (!i.fin()) {
    os << *i;
    ++i;
    while (!i.fin()) {
      os << ", " << *i;
      ++i;
    }
  }
  os << ']';
  return os;
}

/*
suite::iterateur suite::operator[](int n) {
  iterateur i = premier();
  for(int i = 0; i < n; i++) {
    ++i;
  }
  return i;
}
suite::iterateur_constant suite::operator[](int n) const {
  iterateur_constant i = premier_constant();
  for(int i = 0; i < n; i++) {
    ++i;
  }
  return i;
}

int suite::taille() const {
  element* crt = &d_ancre;
  int n = 0;
  while (crt) {
    n++;
    crt = crt->d_suivant;
  }
  return n;
}*/

void suite::inserer(string s, const iterateur& i) {
  i.d_crt->d_suivant = new element(s, i.d_crt->d_suivant);
}

void suite::retirer(const iterateur& i) {
  if (!i.fin()) {
    element* as = i.d_crt->d_suivant;
    i.d_crt->d_suivant = i.d_crt->d_suivant->d_suivant;
    delete as;
  }
}

void suite::inserer(string s) {
  d_ancre.d_suivant = new element(s, d_ancre.d_suivant);
}

void suite::retirer() {
  if (d_ancre.d_suivant != &d_ancre) {
    element* as = d_ancre.d_suivant;
    d_ancre.d_suivant = d_ancre.d_suivant->d_suivant;
    delete as;
  }
}

suite::iterateur_constant suite::premier_constant() const {
  return suite::iterateur_constant(&d_ancre);
}

bool suite::iterateur_constant::fin() const {
  return d_crt->d_suivant == d_ancre;
}

string suite::iterateur_constant::operator *() const {
  return d_crt->d_suivant->d_info;
}

suite::iterateur_constant& suite::iterateur_constant::operator++() {
  d_crt = d_crt->d_suivant;
  return *this;
}

suite::iterateur suite::premier() {
  return suite::iterateur(&d_ancre);
}

bool suite::iterateur::fin() const {
  return d_crt->d_suivant == d_ancre;
}

string& suite::iterateur::operator *() {
  return d_crt->d_suivant->d_info;
}

string suite::iterateur::operator *() const {
  return d_crt->d_suivant->d_info;
}

suite::iterateur& suite::iterateur::operator++() {
  d_crt = d_crt->d_suivant;
  return *this;
}

suite& suite::operator=(const suite& s) {
  if (this != &s) {
    iterateur dest = premier();
    iterateur_constant orig = s.premier_constant();
    // Pour éviter des allocations inutiles
    while (!dest.fin() && !orig.fin()) {
      *dest = *orig;
      ++dest;
      ++orig;
    }
    // Vidage de la destination si l'origine est vide.
    while (!dest.fin())
      retirer(dest);
    // Insertion à la fin des éléments restants.
    while (!orig.fin()) {
      inserer(*orig, dest);
      ++dest;
      ++orig;
    }
  }
  return *this;
}