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
  s.inserer("trois", s.premier());
  cout << s << endl;
  s.inserer("deux", s.premier());
  cout << s << endl;
  s.inserer("un", s.premier());
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
  s.inserer("quatre", s.premier());
  cout << s << endl;
  s.inserer("six", s.premier());
  cout << s << endl;
  s.inserer("cinq", s.premier());


  // Affichage des éléments de la suite
  for (suite::iterateur i = s.premier(); !i.fin(); ++i)
    cout << *i << endl;

  cout << s << endl;

  



  s.inserer("1");
  s.inserer("6");
  s.inserer("5");
  s.inserer("4");
  s.inserer("3");
  s.inserer("2");
  
  cout << "----------------------------" << endl;
  cout << s << endl;
  
  suite::iterateur i = s.premier();
  ++++++i;
  *i = "quatre";
  

  // Affichage des éléments de la suite
  for (suite::iterateur i = s.premier(); !i.fin(); ++i)
    cout << *i << ' ';
  cout << endl;

  {
    cout << "------------------------------------" << endl;
    suite s;
    suite::iterateur i = s.premier();
    s.inserer("1", i);
    s.inserer("2", ++i);
    s.inserer("3", ++i);
    s.inserer("4", ++i);
    s.inserer("5", ++i);
    cout << s << endl;
    for (suite::iterateur i = s.premier(); !i.fin(); ++i)
      cout << "--->" << *i << endl;
    i = s.premier();
    s.inserer("0.5", i);
    ++++i;
    s.inserer("1.5", i);
    ++++++++++++++++++++i;
    for (i = s.premier(); !i.fin(); ++i)
      cout << "--->" << *i << endl;
    s.inserer("100", i); 
    cout << s << endl;
    
    suite t;
    t.inserer("trois", t.premier());
    t.inserer("deux", t.premier());
    t.inserer("un", t.premier());
    
    cout << t << endl;
    t = s;
    cout << t << endl;
    
    suite u;
    u.inserer("trois", u.premier());
    u.inserer("deux", u.premier());
    u.inserer("un", u.premier());
    
    
    cout << t << endl;
    t = u;
    cout << t << endl;
    
    s.retirer();
    i = s.premier();
    s.retirer();
    s.retirer();
    ++++i;
    s.retirer();
  }

  return 0;
}

