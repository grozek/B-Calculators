/* CSC-207
 * October 16th 2023
 * Mini-Project-2-Redo
 * Gabriela Roznawska
 * Acknowledgements:
 * Extremely helpful prof. Rebelsky and the class mentors: Pom and Micah
 * Online directions for this mini-project on prof. Rebelsky's website
 * Java documentation
 */


import java.io.PrintWriter;
import java.util.Scanner;
import java.lang.String;
import java.math.BigInteger;

/* Takes in input as a string of mathematical equation that can include fractions and expressions
 * that are: addition, subtraction, multiplication, and division. And prints the result, while 
 * continuing to scan user input. 
 * Can store latest result of evaluation in a character (such as "a"), and then use this character 
 * as a holder for the value
 */
public class InteractiveCalculator {
    public static void main(String[] args) throws Exception {
        BigFraction saved = new BigFraction(1, 3);
        BFCalculator bf = new BFCalculator(saved);
        PrintWriter pen = new PrintWriter(System.out, true);
        Scanner scans = new Scanner(System.in);
        String input = "";
        int i = 0;

        /* Loops until a string QUIT is an input
         * during the loop it evaluates the input
         */
        while (!input.contains("QUIT")) {
            i++;
            pen.println("give input");
            input = scans.nextLine();

            /* if the input string contains the word "STORE" then store the input as a keyholder
             * of the latest fraction result.
             */
            if (input.contains("STORE")) {
                char charStoreHolder = input.charAt(input.length() - 1);
                saved = bf.store(charStoreHolder);
            } 
            /* if the input does not contain the string "STORE then evaluate the input as a fraction 
             * if the value of output is equal to null, then the input must have been wrong so prints message
             * to the user reminding about the proper format of input
             * if the denominator is equal to 1, then simplify it further and print nominator,
             * else just print the whole fraction
             */
            else{
                saved = bf.evaluate(input);
                if (saved == null){
                    if (bf.errorMessage == 1){
                        pen.println("Provide valid input that consists of alternating numerical values and expressions");
                    }
                    else if (bf.errorMessage == 2){
                        pen.println("Provided two numbers/registers in a row. Ensure that your input consists of alternating numerical values and expressions");                    
                    }
                    else if (bf.errorMessage == 3){
                        pen.println("Provided two operations in a row. Ensure that your input consists of alternating numerical values and expressions");
                    }
                    else {
                        pen.println ("Unidentified error");
                    }
                }
                else if(saved.denom.equals(BigInteger.valueOf(1))){
                    pen.println(saved.num);
                }
                else{
                    pen.println(saved);
                }
            }
        }
        scans.close();
    } //InteractiveCalculator
}

