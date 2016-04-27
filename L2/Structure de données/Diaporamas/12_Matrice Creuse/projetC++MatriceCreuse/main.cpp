/* 
 * File:   main.cpp
 * Author: yvan
 *
 * Created on 30 janvier 2015, 19:59
 */
#include <cstdlib>
#include <iostream>

#include "MatriceCreuse.h"

using namespace std;

/*
 * 
 */
int main(int argc, char** argv) {

    MatriceCreuse m1(3,4);
    
    cout << m1 << endl;
    
    m1(0,0) = 1;
    
    cout << m1 << endl;
    
    m1(1,1) = 2;
    
    cout << m1 << endl;
    
    MatriceCreuse m2(m1);
    
    cout << m2 << endl;
    
    m2(2,2) = 3;
    
    cout << m2 << endl;
    
    m2(2,3) = 4;
    
    cout << m1 << endl << m2 << endl;
    
    MatriceCreuse m3(5,5), m4(5,5);
    
    m3(0,2)=2;
    m3(1,0)=8;
    m3(1,3)=6;
    m3(3,3)=5;
    
    m4(0,2)=3;
    m4(1,3)=-6;
    m4(2,1)=2;
    m4(3,3)=-1;
    m4(4,2)=3;
    
    MatriceCreuse m5;
    
    m5 = m3+m4;
    
    cout << m3 << " + " << endl << m4 << " = " << endl << (m3+m4) << endl;
    
    return 0;
}

