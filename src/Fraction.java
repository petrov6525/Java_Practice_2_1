public class Fraction {
    protected int numerator;
    protected int denominator;

    protected int full_part;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }
    public Fraction(){

    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public int getFull_part() {
        return full_part;
    }

    public void setFull_part(int full_part) {
        this.full_part = full_part;
    }

    @Override
    public String toString() {
        if (numerator == 0 || denominator == 0) {
            return "" + full_part;
        }
        else if(full_part == 0) {
            return numerator + "/" + denominator;
        }
        else {
            return full_part + ":" + numerator + "/" + denominator;
        }
    }


    public static Fraction shortFraction(Fraction fr){
        int num = fr.numerator;
        int den = fr.denominator;

        if (num == den){
            Fraction fraction = new Fraction();
            fraction.setFull_part(1);

            return fraction;
        }

        if (num > den){
            int full_part = num / den;
            int n = num % den;
            Fraction fraction = new Fraction(n, den);
            fraction = Fraction.shortFraction(fraction);
            fraction.setFull_part(full_part);

            return fraction;
        }

        int max_div = 1;
        for (int i = Math.abs(num); i > 0; i--) {
            if ( num % i == 0 && den % i == 0 ){
                max_div = i;
                break;
            }
        }
        Fraction fraction = new Fraction(num / max_div, den / max_div);

        return fraction;
    }

    public static Fraction plus(Fraction fr1, Fraction fr2){
        Fraction fraction = fr1.plus(fr2);

        return Fraction.shortFraction(fraction);
    }
    public Fraction plus (Fraction fract){
        int num1 = numerator * fract.denominator;
        int den1 = denominator * fract.denominator;

        int num2 = fract.numerator * denominator;
        int den2 = fract.denominator * denominator;

        int num = num1 + num2;
        int den = denominator * fract.denominator;

        return Fraction.shortFraction( new Fraction(num, den) );
    }



    public Fraction minus (Fraction fract){
        int num1 = numerator * fract.denominator;
        int den1 = denominator * fract.denominator;

        int num2 = fract.numerator * denominator;
        int den2 = fract.denominator * denominator;

        int num = num1 - num2;
        int den = denominator * fract.denominator;

        return Fraction.shortFraction( new Fraction(num, den) );
    }

    public static Fraction minus (Fraction fr1, Fraction fr2){
        Fraction fraction = fr1.minus(fr2);

        return Fraction.shortFraction(fraction);
    }


    public Fraction mult (Fraction fract){
        int num = numerator * fract.numerator;
        int den = denominator * fract.denominator;

        return Fraction.shortFraction(new Fraction(num, den));
    }

    public static Fraction mult (Fraction fr1, Fraction fr2){
        return Fraction.shortFraction(fr1.mult(fr2));
    }


    public Fraction divide (Fraction fract){
        Fraction fr = new Fraction(fract.denominator, fract.numerator);

        return this.mult(fr);
    }

    public static Fraction divide (Fraction fr1, Fraction fr2){

        return Fraction.shortFraction(fr1.divide(fr2));
    }
}
