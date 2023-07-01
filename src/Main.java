
public class Main {
    public static void main(String[] args) {

        Fraction fr1 = new Fraction( 4,6);
        Fraction fr2 = new Fraction( 2,6);

        Fraction fr = fr1.divide(fr2);

        System.out.println(fr.toString());
    }
}