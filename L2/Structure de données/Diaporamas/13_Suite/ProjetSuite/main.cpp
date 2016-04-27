/* 
 * File:   main.cpp
 * Author: yvan
 *
 * Created on 26 mars 2014, 11:05
 */

#include <cstdlib>
#include <iostream>
#include "suite.h"

using namespace std;

/*
 * 
 */
int main(int argc, char** argv) {
  suite s;
  //cout << s.taille() << endl;
  cout << s << endl;
  s.inserer("trois");
  cout << s << endl;
  s.inserer("deux");
  cout << s << endl;
  s.inserer("un");
  cout << s << endl;
  /*cout << s.taille() << endl;
  cout << s[0] << endl;
  s[0] = "trois";
  cout << s[0] << endl;
  s.inserer("un");
  cout << s[0] << " " << s[1] << endl;
  s.inserer("deux", 1);
  cout << s[0] << " " << s[1] << " " << s[2] << endl;
  cout << s[0] << " " << s[1] << " " << s[2] << endl;*/
  s.inserer("quatre", 4);
  cout << s << endl;
  s.inserer("six", 5);
  cout << s << endl;
  s.inserer("cinq", 4);
  
    
  // Affichage des éléments de la suite
  for (suite::iterateur i = s.premier(); !i.fin(); ++i)
    cout << *i << endl;
  
  cout << s << endl;

  for (int i = 0; i < s.taille(); i++) {
    cout << s[i] << ' ';
  }
  cout << endl;
  s.retirer();

  for (int i = 0; i < s.taille(); i++) {
    cout << s[i] << ' ';
  }
  cout << endl;
  s.retirer(5);

  for (int i = 0; i < s.taille(); i++) {
    cout << s[i] << ' ';
  }
  cout << endl;
  s.retirer(2);

  for (int i = 0; i < s.taille(); i++) {
    cout << s[i] << ' ';
  }
  cout << endl;
  s.retirer(3);

  for (int i = 0; i < s.taille(); i++) {
    cout << s[i] << ' ';
  }
  cout << endl;
  s.retirer(1);

  for (int i = 0; i < s.taille(); i++) {
    cout << s[i] << ' ';
  }
  cout << endl;
  s.retirer(1);

  for (int i = 0; i < s.taille(); i++) {
    cout << s[i] << ' ';
  }
  cout << endl;
  s.retirer();

  for (int i = 0; i < s.taille(); i++) {
    cout << s[i] << ' ';
  }
  cout << '-' << endl;
  
  
  s.inserer("6");  s.inserer("5");
  s.inserer("4");  s.inserer("3");
  s.inserer("2");  s.inserer("1");
  
  // Affichage des éléments de la suite
  for (suite::iterateur i = s.premier(); !i.fin(); ++i)
    cout << *i << ' ';
  cout << endl;
  return 0;
}

