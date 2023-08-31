class Complex:

    def __init__(self, real, imag):
        self.real = real
        self.imag = imag

    def __str__(self):
        
        if self.real == 0 and self.imag == 0:
            return "("+str(self.real) + "+" + str(self.imag) + "j)"
        elif self.real == 0:
            return "(0"+str(self.imag) + "j)"
        elif self.imag == 0:
            return str(self.real)
        elif self.imag > 0:
            if self.imag == 1:
                return "("+ str(self.real) + "+j)"
            else:
                return "("+str(self.real) + "+" + str(self.imag) + "j)"
        else:
            if self.imag == -1:
                return "("+str(self.real) + "-j)"
            else:
                return "("+str(self.real) + str(self.imag) + "j)"

    
    def __add__(self, other):
        if isinstance(other, Complex):
            return Complex(self.real + other.real, self.imag + other.imag)
        elif isinstance(other, int) or isinstance(other, float):
            return self + Complex(other, 0)
        else:
            raise TypeError('unsuported operand type')

    def __sub__(self, other):
        if isinstance(other, Complex):
            return Complex(self.real - other.real, self.imag - other.imag)
        elif isinstance(other, int) or isinstance(other, float):
            return self - Complex(other, 0)
        else:
            raise TypeError('unsuported operand type')

    def __neg__(self, other):
        return Complex(-self.real, -self.imag)


    def __mul__(self, other):
        if isinstance(other, Complex):
            real = self.real * other.real - self.imag * other.imag
            imag = self.real * other.imag + self.imag * other.real
            return Complex(real, imag)
        elif isinstance(other, int) or isinstance(other, float):
            return self * Complex(other, 0)
        else: # something is wrong
            raise TypeError('unsuported operand type')

    def __truediv__(self, other):
        if isinstance(other, Complex):
            result = self * Complex(other.real, -other.imag)
            ratio = other.real * other.real + other.imag * other.imag
            result.real /= ratio
            result.imag /= ratio
            return result
        elif isinstance(other, int) or isinstance(other, float):
            return self / Complex(other, 0)
        else: # something is wrong
            raise TypeError('unsuported operand type')


    def __radd__(self, other):
        return self + other

    def __rsub__(self, other):
        return Complex(0, 0) + other - self

    def __rmul__(self, other):
        return self * other

    def __rtruediv__(self, other):
        return Complex(1, 0) * other / self


if __name__ == '__main__':
    a = Complex(1, 3)
    b = Complex(2, 3)

    i = 5

    print('%s + %s = %s' % (a, b, a + b))
    print('%s - %s = %s' % (a, b, a - b))
    print('%s * %s = %s' % (a, b, a * b))
    print('%s / %s = %s' % (a, b, a / b))

    print('%s + %i = %s' % (a, i, a + i))
    print('%s - %i = %s' % (a, i, a - i))
    print('%s * %i = %s' % (a, i, a * i))
    print('%s / %i = %s' % (a, i, a / i))
    
    print('%i + %s = %s' % (i, a, i + a))
    print('%i - %s = %s' % (i, a, i - a))
    print('%i * %s = %s' % (i, a, i * a))
    print('%i / %s = %s' % (i, a, i / a))