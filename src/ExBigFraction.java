import java.io.PrintWriter;
/**
 * A simple experiment using fractions.
 *
 * @author Samuel A. Rebelsky.
 * @author YOUR NAME HERE
 */
public class ExBigFraction {
  public static void main(String[] args) throws Exception {
    PrintWriter pen = new PrintWriter(System.out, true);
    BigFraction f1;
    f1 = new BigFraction(4, 10);
    BigFraction f2;
    f2 = new BigFraction(2, 5);
    
    pen.println("First fraction: " + f1);
    pen.println("Second fraction: " + f2);
    pen.println("Sum: " + (f1.add(f2)));
    pen.println("multiplication: " + f1.multiply(f2));
    pen.println("fractional: " + f1.fractional());
    pen.println("simplest " + f1.simplest());
    BigFraction f3 = new BigFraction(2, 3);
    BigFraction f4;
    f4 = new BigFraction(1, 4);
    pen.println("subtract " + f3.subtract(f4));
    pen.println("divide " + f1.divide(f4));
    BigFraction f;
    f = new BigFraction("1/4");
    pen.println(f.numerator());   // 1
    pen.println(f.denominator()); // 4
    f = new BigFraction("11/5");
    pen.println(f.numerator());   // 11
    pen.println(f.denominator()); // 5
    f = new BigFraction("120/3");
    pen.println(f.doubleValue()); // Approximately 4


  //pen.println(f1.simplest());
  } // main(String[])
} // class FractionExpt
