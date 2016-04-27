/* 
 * File:   Matrice.cpp
 * Author: yvan
 * 
 * Created on 30 janvier 2015, 20:00
 */

#include "MatriceCreuse.h"

#include <cmath>

using namespace std;

MatriceCreuse::MatriceCreuse() :
d_valeur(0),
d_ligne(0),
d_colonne(0),
d_nv(0),
d_nl(0),
d_nc(0) {
}

MatriceCreuse::MatriceCreuse(int nl, int nc) :
d_valeur(0),
d_ligne(0),
d_colonne(0),
d_nv(0),
d_nl(nl),
d_nc(nc) {
}

MatriceCreuse::MatriceCreuse(const MatriceCreuse& m) :
d_valeur(new double[m.d_nv]),
d_ligne(new int[m.d_nv]),
d_colonne(new int[m.d_nv]),
d_nv(m.d_nv),
d_nl(m.d_nl),
d_nc(m.d_nc) {
    for (int i = 0; i < d_nv; ++i) {
        d_valeur[i] = m.d_valeur[i];
        d_ligne[i] = m.d_ligne[i];
        d_colonne[i] = m.d_colonne[i];
    }
}

MatriceCreuse::~MatriceCreuse() {
    delete[] d_valeur;
    delete[] d_ligne;
    delete[] d_colonne;
}

int MatriceCreuse::get_nc() const {
    return d_nc;
}

int MatriceCreuse::get_nl() const {
    return d_nl;
}

int MatriceCreuse::position(int l, int c) const {
    int p = 0;
    while (p < d_nv && d_ligne[p] < l) p++;
    while (p < d_nv && d_ligne[p] == l && d_colonne[p] < c)
        p++;
    if (p == d_nv || (p < d_nv &&
            (d_ligne[p] != l || d_colonne[p] != c)))
        return -p - 1;
    else
        return p;
}

double MatriceCreuse::operator()(int l, int c) const {
    int p = position(l, c);
    if (p < 0)
        return 0;
    return d_valeur[p];
}

int MatriceCreuse::inserer(int l, int c) {
    int p = position(l, c);
    if (p < 0) {
        inserer(l, c, -p - 1);
    }
    return p;
}

void MatriceCreuse::inserer(int l, int c, int k) {
    double* n_valeur = new double[d_nv + 1];
    int* n_ligne = new int[d_nv + 1];
    int* n_colonne = new int[d_nv + 1];

    for (int i = 0; i < k; ++i) {
        n_valeur[i] = d_valeur[i];
        n_ligne[i] = d_ligne[i];
        n_colonne[i] = d_colonne[i];
    }

    n_valeur[k] = NAN;
    n_ligne[k] = l;
    n_colonne[k] = c;

    for (int i = k; i < d_nv; ++i) {
        n_valeur[i + 1] = d_valeur[i];
        n_ligne[i + 1] = d_ligne[i];
        n_colonne[i + 1] = d_colonne[i];
    }

    d_valeur = n_valeur;
    d_ligne = n_ligne;
    d_colonne = n_colonne;

    d_nv++;
}

MatriceCreuse& MatriceCreuse::operator=(const MatriceCreuse& m) {
    if (this != &m) {
        delete[] d_valeur;
        delete[] d_ligne;
        delete[] d_colonne;
        d_valeur = new double[m.d_nv];
        d_ligne = new int[m.d_nv];
        d_colonne = new int[m.d_nv];
        d_nc = m.d_nc;
        d_nl = m.d_nl;
        d_nv = m.d_nv;
        for (int i = 0; i < d_nv; i++) d_valeur[i] = m.d_valeur[i];
        for (int i = 0; i < d_nv; i++) d_ligne[i] = m.d_ligne[i];
        for (int i = 0; i < d_nv; i++) d_colonne[i] = m.d_colonne[i];
    }
    return *this;
}


// Modification. Cette méthode a une GROSSE FAIBLESSE
// Laquelle selon vous ?

double& MatriceCreuse::operator()(int l, int c) {
    int p = position(l, c);
    if (p < 0) {
        p = -p - 1;
        inserer(l, c, p);
    }
    return d_valeur[p];
}

ostream & operator<<(ostream& os, const MatriceCreuse& m) {
    int k = 0, l = 0, c = 0;
    while (k < m.d_nv) {
        while (l < m.d_ligne[k] || c < m.d_colonne[k]) {
            os << 0 << ' ';
            c++;
            if (c == m.d_nc) {
                c = 0;
                l++;
                os << endl;
            }
        }
        os << m.d_valeur[k++] << ' ';
        c++;
        if (c == m.d_nc) {
            c = 0;
            l++;
            os << endl;
        }
    }
    while (l < m.d_nl) {
        os << 0 << ' ';
        c++;
        if (c == m.d_nc) {
            c = 0;
            l++;
            os << endl;
        }
    }
    return os;
}

bool MatriceCreuse::inferieur(int i, MatriceCreuse m, int j) const {
    return d_ligne[i] < m.d_ligne[j] || (d_ligne[i] == m.d_ligne[j] && d_colonne[i] < m.d_colonne[j]);
}

bool MatriceCreuse::superieur(int i, MatriceCreuse m, int j) const {
    return d_ligne[i] > m.d_ligne[j] || (d_ligne[i] == m.d_ligne[j] && d_colonne[i] > m.d_colonne[j]);
}

MatriceCreuse MatriceCreuse::operator+(MatriceCreuse& m) {
    MatriceCreuse r;
    r.d_nl = m.d_nl;
    r.d_nc = m.d_nc;
    r.d_nv = 0;
    int i = 0, j = 0, k = 0;
    while (i < d_nv && j < m.d_nv) {
        if (inferieur(i, m, j)) {
            r(d_ligne[i], d_colonne[i]) = d_valeur[i];
            r.d_nv++;
            i++;
        } else if (superieur(i, m, j)) {
            r(m.d_ligne[j], m.d_colonne[j]) = m.d_valeur[j];
            r.d_nv++;
            j++;
        } else {
            double v = d_valeur[i] + m.d_valeur[j];
            if (v != 0) {
                r(d_ligne[i], d_colonne[i]) = v;
                r.d_nv++;
            }
            i++;
            j++;
        }
    }
    while (i < d_nv) {
        r(d_ligne[i], d_colonne[i]) = d_valeur[i];
        r.d_nv++;
        i++;
    }
    while (j < m.d_nv) {
        r(m.d_ligne[j], m.d_colonne[j]) = m.d_valeur[j];
        r.d_nv++;
        j++;
    }
    return r;
}
