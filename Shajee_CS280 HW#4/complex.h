#ifndef COMPLEX_H
#define COMPLEX_H

#include <iostream>

using std::ostream;

struct complex {

    complex(double = 0, double = 0);

    complex operator+(const complex &) const;
    complex operator-(const complex &) const;
    complex operator*(const complex &) const;
    complex operator/(const complex &) const;

    complex operator+(double) const;
    complex operator-(double) const;
    complex operator*(double) const;
    complex operator/(double) const;

    friend complex operator+(double, const complex &);
    friend complex operator-(double, const complex &);
    friend complex operator*(double, const complex &);
    friend complex operator/(double, const complex &);

    friend ostream &operator<<(ostream &, const complex &);

private:

    double real;
    double imag;
};

#endif /* COMPLEX */