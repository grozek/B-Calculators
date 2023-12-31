/**
 * BFCalculator
 * 
 * Performs calculations requested by the user that include fractions and 
 * returns the outputs to the user
 * 
 * CSC-207 October 16th 2023 
 * Mini-Project-2-Redo Gabriela Roznawska 
 * Acknowledgements: 
 * Extremely helpful prof. Rebelsky and the class mentors: Pom and Micah 
 * Online directions for thisbmini-project on prof. Rebelsky's website 
 * Java documentation
 */

import java.math.BigInteger;
import java.lang.String;


public class BFCalculator {

    /**
     * Fields
     * register : stores value of the latest fraction
     * strRegister : array that stores fractions in indexes of numericValues of letters
     */

    BigFraction register;
    BigFraction[] strRegister;
    Integer errorMessage;
    Character singular;

    /**
     * Simple constructor
     * @param register BigFraction
     */
    public BFCalculator(BigFraction register) {
        this.strRegister = new BigFraction[26];
        this.register = register;
        this.errorMessage = 0;
        this.singular = ' ';
    } // BFCalculator


    /**
     * Methods
     */

    /**
     * pre: input equation form the user post: perform mathematical processes and output the
     * fractional result
     * 
     * Takes in the input, compares it to various strings: expressions and numbers. Then perform
     * mathematical analysis based on the provided input. Evaluates the command "STORE".
     */
    public BigFraction evaluate(String exp) {
        String[] result = exp.split(" ");
        BigFraction output = null;
        BigFraction temp1 = null;
        BigFraction temp2 = null;
        String expression = "";
        int i = 0;

        while (i < result.length) { 
            String str = result[i];
            char value = (str.charAt(0));
            int num = Character.getNumericValue(value);

            if (result.length <= 1) {
                this.errorMessage = 1;
                this.singular = value;
                return output;
            } // if
            if ((expression != "") && ((value == '+') || (value == '*') || (value == '/'))) {
                this.errorMessage = 3;
                return output;
            } // if
            if ((value == '-') && (result.length + 1 < i)) {
                if (('0' <= result[i].charAt(1)) && ('9' >= result[i].charAt(1))) {
                    this.errorMessage = 3;
                    return output;
                } // if
            } // if

            /**
             * if the numerator is equal to 0 then make both nominator and denominator equal to 0
             */
            if (Character.getNumericValue('0') == num) {
                if (temp1 == null) {
                    temp1 = new BigFraction(BigInteger.valueOf(0), BigInteger.valueOf(0));
                } else {
                    temp2 = new BigFraction(BigInteger.valueOf(0), BigInteger.valueOf(0));
                } // else
            } // if

            /**
             * if the numericalValue of first index of input is a number, then check if it is a
             * natural number or a fraction. Assigns each of those cases appropiately - with the
             * denominator for the natural number always being equal to 1.
             */
            if (((Character.getNumericValue('1') <= num)
                    && (num <= Character.getNumericValue('9'))))
                if (str.contains("/")) {
                    if (temp1 == null) {
                        temp1 = new BigFraction(str);
                    } else {
                        temp2 = new BigFraction(str);
                    } // else
                } else {
                    if (temp1 == null) {
                        temp1 = new BigFraction(str, 1);
                    } else {
                        temp2 = new BigFraction(str, 1);
                    } // else
                } // else

            /**
             * if the numericalValue of first index of input is a letter, then either assign it as
             * temp1 or temp2. Produces error if more than 2 numeric values are inputed in a row.
             */
            if ((value <= 'z') && (value >= 'a')) {
                if (temp1 == null) {
                    temp1 = this.strRegister[value - 'a'];
                } else {
                    temp2 = this.strRegister[value - 'a'];
                } // else
            } // if

            /**
             * if the numericalValue of first index of input is a '/' or it is already stored in an
             * "expresesion" variable, then if not both temp1 and temp2 are present: save '/' as an
             * "expression" variable. If both temp1 and temp2 are present then perform division,
             * assign the result of it to temp1 and clear temp2 and expression variable, so they are
             * ready for new input fractions and expressions.
             */
            if ((value == ('/')) || (expression.equals("/"))) {
                if ((temp1 == null) || (temp2 == null)) {
                    expression = str;
                } else {
                    output = temp1.divide(temp2);
                    temp1 = output;
                    temp2 = null;
                    expression = "";
                } // else
            } // if

            /**
             * if the numericalValue of first index of input is a '*' or it is already stored in an
             * "expresesion" variable, then if not both temp1 and temp2 are present: save '*' as an
             * "expression" variable. If both temp1 and temp2 are present then perform
             * multiplication, assign the result of it to temp1 and clear temp2 and expression
             * variable, so they are ready for new input fractions and expressions.
             */
            if ((value == ('*')) || (expression.equals("*"))) {
                if ((temp1 == null) || (temp2 == null)) {
                    expression = str;
                } else {
                    output = temp1.multiply(temp2);
                    temp1 = output;
                    temp2 = null;
                    expression = "";
                } // else
            } // if

            /**
             * if the numericalValue of first index of input is a '+' or it is already stored in an
             * "expresesion" variable, then if not both temp1 and temp2 are present: save '+' as an
             * "expression" variable. If both temp1 and temp2 are present then perform addition,
             * assign the result of it to temp1 and clear temp2 and expression variable, so they are
             * ready for new input fractions and expressions.
             */
            if ((value == ('+')) || (expression.equals("+"))) {
                if ((temp1 == null) || (temp2 == null)) {
                    expression = str;
                } else {
                    output = temp1.add(temp2);
                    temp1 = output;
                    temp2 = null;
                    expression = "";
                } // else
            } // if

            /**
             * if the numericalValue of first index of input is a '-' or it is already stored in an
             * "expresesion" variable, then if not both temp1 and temp2 are present: save '-' as an
             * "expression" variable. If both temp1 and temp2 are present then perform subtraction,
             * assign the result of it to temp1 and clear temp2 and expression variable, so they are
             * ready for new input fractions and expressions.
             */
            if ((value == ('-')) || (expression.equals("-"))) {
                if ((temp1 == null) || (temp2 == null)) {
                    expression = str;
                } else {
                    output = temp1.subtract(temp2);
                    temp1 = output;
                    temp2 = null;
                    expression = "";
                } // else
            } // if
            i++;
        } // while
        if ((temp1 != null) && (temp2 != null)) {
            this.errorMessage = 2;
            return output;
        } // if
        /**
         * if the end of the array of strings (input) is reached, then change it to simplest form
         * and return
         */
        output = output.simplest();
        this.register = output;
        return output;
    } // evaluate (String)


    /**
     * when called assigns a BigFraction value to an letter-ordered index in a array of fractions
     */
    public BigFraction store(char reg) {
        this.strRegister[reg - 'a'] = this.register; // character name idintificator for number
        return register;
    } // store (char)
} // BFCalculator
