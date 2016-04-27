/* 
 * File:   Matrice.h
 * Author: yvan
 *
 * Created on 30 janvier 2015, 20:00
 */

#ifndef MATRICE_H
#define	MATRICE_H

#include <ostream>

using namespace std;

class MatriceCreuse {
public:
    MatriceCreuse();
    MatriceCreuse(int, int);
    MatriceCreuse(const MatriceCreuse&);
    ~MatriceCreuse();
    double& operator()(int, int);
    double operator()(int, int) const;
    int get_nl() const;
    int get_nc() const;
    MatriceCreuse& operator=(const MatriceCreuse&);
    MatriceCreuse operator+(MatriceCreuse&);
    MatriceCreuse operator*(const MatriceCreuse&);
    bool operator==(const MatriceCreuse&) const;
    bool inferieur(int, MatriceCreuse, int) const;
    bool superieur(int, MatriceCreuse, int) const;
    friend ostream& operator<<(ostream& os, const MatriceCreuse&);
    

private:

    double* d_valeur;
    int* d_ligne;
    int* d_colonne;
    int d_nv;
    int d_nl;
    int d_nc;
    
    int position(int, int) const;
    int inserer(int, int);
    void inserer(int, int, int);
};

ostream& operator<<(ostream& os, const MatriceCreuse&);


#endif	/* MATRICE_H */

