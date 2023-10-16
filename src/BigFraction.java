import java.math.BigInteger;
import java.lang.String;


/**
 * A simple implementation of Fractions.
 * 
 * @author Samuel A. Rebelsky
 * @author YOUR NAME HERE
 * @version 1.2 of August 2023
 */
public class BigFraction {
  // +------------------+---------------------------------------------
  // | Design Decisions |
  // +------------------+
  /*
   * (1) Denominators are always positive. Therefore, negative fractions are represented 
   * with a negative numerator. Similarly, if a fraction has a negative numerator, it 
   * is negative.
   * 
   * (2) Fractions are not necessarily stored in simplified form. To obtain a fraction 
   * in simplified form, one must call the `simplify` method.
   */

  // +--------+-------------------------------------------------------
  // | Fields |
  // +--------+

  /** The numerator of the fraction. Can be positive, zero or negative. */
  BigInteger num;

  /** The denominator of the fraction. Must be non-negative. */
  BigInteger denom;

  // +--------------+-------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Build a new fraction with numerator num and denominator denom.
   * 
   * Warning! Not yet stable.
   */
  public BigFraction(BigInteger num, BigInteger denom) {
    this.num = num;
    this.denom = denom;
  } // Fraction(BigInteger, BigInteger)

  /**
   * Build a new fraction with numerator num and denominator denom.
   * 
   * Warning! Not yet stable.
   */
  public BigFraction(int num, int denom) {
    this.num = BigInteger.valueOf(num);
    this.denom = BigInteger.valueOf(denom);
  } // Fraction(int, int)

  /**
   * Build a new fraction by parsing a string.
   *
   * Warning! Not yet implemented.
   */
  // public Fraction(String str) {
  //   this.num = BigInteger.valueOf(2);
  //   this.denom = BigInteger.valueOf(7);
  // } // Fraction

  public BigFraction (String str){
      this.num = new BigInteger (str.substring(0, str.indexOf("/")));
      this.denom = new BigInteger (str.substring(str.indexOf("/")+1, str.length()));
  }
  // +---------+------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Express this fraction as a double.
   */
  public double doubleValue() {
    return this.num.doubleValue() / this.denom.doubleValue();
  } // doubleValue()

  /**
   * Add the fraction `addMe` to this fraction.
   */
  public BigFraction add(BigFraction addMe) {
    BigInteger resultNumerator;
    BigInteger resultDenominator;
    resultDenominator = this.denom.multiply(addMe.denom);
    resultNumerator = (this.num.multiply(addMe.denom)).add(addMe.num.multiply(this.denom));

    return new BigFraction(resultNumerator, resultDenominator);
  }// add(Fraction)


  public BigFraction subtract(BigFraction subtractMe){
    BigInteger resultNumerator;
    BigInteger resultDenominator;
    resultDenominator = this.denom.multiply(subtractMe.denom);
    resultNumerator = (this.num.multiply(subtractMe.denom)).subtract(subtractMe.num.multiply(this.denom));

    return new BigFraction(resultNumerator, resultDenominator);
  }
    
  /**
   * Get the denominator of this fraction.
   */
  public BigInteger denominator() {
    return this.denom;
  } // denominator()
  
  /**
   * Get the numerator of this fraction.
   */
  public BigInteger numerator() {
    return this.num;
  } // numerator()
  
  /**
   * Convert this fraction to a string for ease of printing.
   */
  public String toString() {
    // Special case: It's zero
    if (this.num.equals(BigInteger.ZERO)) {
      return "0";
    } // if it's zero
  else{
    // Lump together the string represention of the numerator,
    // a slash, and the string representation of the denominator
    // return this.num.toString().concat("/").concat(this.denom.toString());
    return this.num + "/" + this.denom;
  } // toString()
  }


  public BigFraction multiply (BigFraction other){
    BigInteger resultDenominator;
    BigInteger resultNominator;
    resultDenominator = this.denom.multiply(other.denom);
    resultNominator = this.num.multiply(other.num);

    return new BigFraction(resultNominator, resultDenominator);

  }


  public BigFraction divide(BigFraction other){
    BigInteger resultDenominator;
    BigInteger resultNominator;
    resultDenominator = this.denom.multiply(other.num);
    resultNominator = this.num.multiply(other.denom);

    return new BigFraction(resultNominator, resultDenominator);
  }
  
/* 
  public BigFraction subtract(BigFraction first){
    BigInteger x = BigInteger.valueOf(0);
      if (first.num.equals(BigInteger.ZERO)){
      throw new ArithmeticException("Cannot divide by zero.");
       }
    BigInteger firstD = first.denom; 
    BigInteger secondD = this.denom;
    BigInteger newD = firstD.gcd(secondD);
    BigInteger firstN = first.num.multiply(newD.divide(firstD));
    BigInteger secondN = this.num.multiply(newD.divide(secondD));
    BigInteger newN; //secondN.subtract(firstN);

    int n1 = firstN.intValue();
    int n2 = secondN.intValue();
    if (firstN.compareTo(secondN) > 0) {
      newN = firstN.subtract(secondN);
    }
    else {
      newN = secondN.subtract(firstN);
    } 
    
    return new BigFraction(newN, newD);

  }
  */
  public BigFraction fractional (){
    BigInteger resultNumerator;
    resultNumerator = this.num.mod(this.denom);
    return new BigFraction(resultNumerator, this.denom);

  }


  public BigFraction simplest(){
    BigInteger resultN = this.num;
    BigInteger resultD = this.denom;
    BigInteger gcd = resultN.gcd(resultD);

    resultN = resultN.divide(gcd);
    resultD = resultD.divide(gcd);
    return new BigFraction (resultN, resultD);
  }
}