#include <iostream>
#include "complex.h"

complex::complex(double real, double imag) : real(real), imag(imag) {}

complex complex::operator+(const complex &o) const {

    return complex(real + o.real,imag+ o.imag);
}

complex complex::operator+(double n) const {

    return complex(real + n , imag);
}

complex complex::operator-(const complex &o) const {

    return complex(real - o.real , imag - o.imag);
}

complex complex::operator-(double n) const {

    return complex(real - n , imag);
}

complex complex::operator*(const complex &o) const {

    return complex((real * o.real)+((-1)*imag * o.imag),((real*o.imag)+(imag*o.real)));
}

complex complex::operator*(double n) const {

    return complex(real * n, n*imag);
}

complex complex::operator/(const complex &o) const {
  double  den =(o.real * o.real)+((-1)*(o.imag*(o.imag*(-1))));
    return complex((((real * o.real)+((-1)*imag * o.imag*(-1)))/(den)),((real*o.imag*(-1))+(imag*o.real))/den);
}

complex complex::operator/(double n) const {

    return complex(real/n, imag /n);
}


complex operator+(double n, const complex &o) {

    return o + n;
}

complex operator-(double n, const complex &o) {

    return complex(n) - o;
}

complex operator*(double n, const complex &o) {

    return o * n;
}

complex operator/(double n, const complex &o) {

    return complex(n) / o;
}

ostream &operator<<(ostream &out, const complex &o) {

    if(o.imag>=0&&o.real>=0){
      out <<"("<<(double) o.real << "+" << (double)o.imag << "j)";
      return out;
    }
    else{
      if(o.imag>=0&&o.real<=0){
         out<<"(" <<(double) o.real << "+" << (double)o.imag << "j)";
         return out;
      }
      else{
         out <<"("<< (double)o.real << (double)o.imag << "j)";
         return out;
      }
    }
}