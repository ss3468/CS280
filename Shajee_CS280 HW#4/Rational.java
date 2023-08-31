public class Rational {

    public Rational() {

        this(0);
    }

    public Rational(int num) {

        this(num, 1);
    }

    public Rational(int num, int den) {

        this.num = num;
        this.den = den;
    }

    public Rational add(Rational o) {

        return new Rational(num * o.den + o.num * den, den * o.den);
    }

    public Rational add(int n) {

        return new Rational(num + n * den, den);
    }

    public Rational div(Rational o) {

        return new Rational(num * o.den, den * o.num);
    }

    public Rational div(int n) {

        return new Rational(num, den * n);
    }

    public Rational mul(Rational o) {

        return new Rational(num * o.num, den * o.den);
    }

    public Rational mul(int n) {

        return new Rational(num * n, den);
    }

    public Rational sub(Rational o) {

        return new Rational(num * o.den - o.num * den, den * o.den);
    }

    public Rational sub(int n) {

        return new Rational(num - n * den, den);
    }

    public String toString() {

        return "(" + num + " / " + den + ")";
    }

    private int den;
    private int num;
}