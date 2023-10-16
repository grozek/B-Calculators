// import java.io.PrintWriter;
import java.math.BigInteger;
// import java.lang.Integer;
import java.lang.String;


public class BFCalculator {

    // fields
    BigFraction register;
    BigFraction[] strRegister;

    // costructor
    public BFCalculator(BigFraction register) {
        this.strRegister = new BigFraction[26];
        this.register = register; // the only constructor. not sure if there is a need for more
    }
    /*
     * public BFCalculator (Character x){ this.strRegister = new Character[26]; this.n = 0;
     * this.strRegister[n] = x; this.tracked = x; }
     */
    // }


    public BigFraction evaluate(String exp) {
        String[] result = exp.split(" "); // splitting input string into expressions
        // char tempRegister = ' ';
        BigFraction output = null;
        BigFraction temp1 = null; // temp1 will hold tempraily the numerator value
        BigFraction temp2 = null; // temp2 will hold temoraily the denominator value
        String expression = "";
        int i = 0; // declare and initialize index

        // Repeat until we reach the end of the array
        while (i < result.length) { // until the end of string is reached
            String str = result[i]; // temporary holder "str" takes in a value of first expression -
                                    // most likely a fraction
            char value = (str.charAt(0)); // value holds a uni value of the first character in str:
                                          // most likely a number, nominator
            int num = Character.getNumericValue(value); // num equals to the numeric value of the
                                                        // first char in str. most likely a number

            if ((Character.getNumericValue('0') <= num)
                    && (num <= Character.getNumericValue('9'))) { // if the string is number
                if (temp1 == null) {
                    temp1 = new BigFraction(str); // if the temp1 doesnt hold any value then assign
                } else {
                    temp2 = new BigFraction(str); // if temp1 holds a value then assign it
                }
            }
            if ((value <= 'z') && (value >= 'a')) {
                if (temp1 == null) {
                    temp1 = this.strRegister[value - 'a']; // if the temp1 doesnt hold any value
                                                           // then assign
                } else {
                    temp2 = this.strRegister[value - 'a']; // if temp1 holds a value then assign it
                }
            }
            if ((value == ('/')) || (expression.equals("/"))) { // if the expression at examined
                                                                // index is '/' or the previously
                                                                // saved expression is a division
                                                                // "/" string
                if ((temp1 == null) || (temp2 == null)) {
                    expression = str; // if there are no two saved fraction then save expression as
                                      // "/"
                } else {
                    output = temp1.divide(temp2); // if there are two fractions then perform
                                                  // division
                    temp1 = output; // temp1 value is the result of the division
                    temp2 = null; // initialising temp2 so its ready for new assignment
                    expression = ""; // neutralising expression so it can take on new values
                }
            }

            if ((value == ('+')) || (expression.equals("+"))) { // if the character is '+' or the
                                                                // previously saved expression is
                                                                // "+"
                if ((temp1 == null) || (temp2 == null)) {
                    expression = str; // if there are no two saved fraction then save expression as
                                      // "+"
                } else {
                    output = temp1.add(temp2); // if there are two fractions then perform addition
                    temp1 = output; // temp1 value is the result of addition
                    temp2 = null; // initializing to zero temp2 so its ready for taking on new input
                    expression = ""; // neutralising expression so it can take on new values
                }
            }

            if ((value == ('-')) || (expression.equals("-"))) { // if the character is '+' or the
                                                                // previously saved expression is
                                                                // "+"
                if ((temp1 == null) || (temp2 == null)) {
                    expression = str; // if there are no two saved fraction then save expression as
                                      // "+"
                } else {
                    output = temp1.subtract(temp2); // if there are two fractions then perform
                                                    // addition
                    temp1 = output; // temp1 value is the result of addition
                    temp2 = null; // initializing to zero temp2 so its ready for taking on new input
                    expression = ""; // neutralising expression so it can take on new values
                }
            }


            i++;

        }
        output = output.simplest();
        this.register = output;
        return output;
    }



    public BigFraction store(char reg) {
        this.strRegister[reg - 'a'] = this.register; // character name idintificator for number

       return register;
    }



    /*
     * if (result[i].equals("STORE")){ String temp = result[i+1]; tempRegister = temp.charAt(0);
     * store(tempRegister); i++; }
     */

    // if (value == tempRegister){

    // }

    /*
     * public BFCalculator evaluate (String exp){ String[]result = new String[26]; BigFraction
     * temp1; BigFraction temp2; String expression; result = exp.split(" ");
     * 
     * for (int i=0; i<result.length; i++){ String str = result[i]; char value = (str.charAt(0));
     * int num = Character.getNumericValue(value);
     * 
     * if ((97 <= num) && (num <= 122)){ if (temp1.num.equals(0)){ temp2 = new BigFraction
     * (result[i]); } else { temp1 = new BigFraction (result[i]); } } else
     * if(result[i].equals('/')){ if(result[i].equals("null")){ expression = result[i]; if
     * ((!(temp1.equals("null"))) && (!(temp1.equals("null")))){ temp1.divide(temp2); } } }
     */
    // else{
    // //error
    // }


}
// }
// }


/*
 * public BFCalculator store (char register){ String nominator = this.num.toString(); String
 * denominator = this.denom.toString(); register = (char) this.num;
 * 
 * 
 * }
 */



/*
 * public BFCalculator evaluate (String exp){ char temp; BigInteger num; BigInteger denom;
 * BigInteger output; for (int i=0; i <length(exp); i++){ temp = exp.charAt(i); if (temp == ('/')){
 * if (isWhitespace(exp.charAt(i-1))){ //im assuming that if the witespace is for nominator it is
 * also for the denominator num = BigInteger.valueOf(exp.charAt(i-2)); num =
 * BigInteger.valueOf(exp.charAt(i-2)); } else{ num = BigInteger.valueOf(exp.charAt(i-1)); denom =
 * BigInteger.valueOf(exp.charAt(i+1)); // output = divide(num, denom); } }//example dividing
 * method, same should be for all the other if statements if (temp == ('*')){ num =
 * BigInteger.valueOf(exp.charAt(i-1)); denom = BigInteger.valueOf(exp.charAt(i+1)); //output =
 * multiply(num, denom); } if (temp == ('+')){ num = BigInteger.valueOf(exp.charAt(i-1)); denom =
 * BigInteger.valueOf(exp.charAt(i+1)); //output = add(num, denom); } if (temp == ('-')){ num =
 * BigInteger.valueOf(exp.charAt(i-1)); denom = BigInteger.valueOf(exp.charAt(i+1)); //output =
 * subtract(num, denom); } //return new (this.num, this.denom);
 */
