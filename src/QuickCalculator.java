/*
 * CSC-207 October 16th 2023 Mini-Project-2-Redo Gabriela Roznawska Acknowledgements: Extremely
 * helpful prof. Rebelsky and the class mentors: Pom and Micah Online directions for this
 * mini-project on prof. Rebelsky's website Java documentation
 */


import java.io.PrintWriter;
import java.util.Scanner;
import java.lang.String;
import java.math.BigInteger;

/*
 * Takes in input as command-line-arguments that are strings (of mathematical equations and STORE
 * requests) Can store latest result of evaluation in a character (such as "a"), and then use this
 * character as a holder for the value Once all in-line arguments have been evaluated prints each
 * step of mathematical equations (skips the STORE process) and ends its work.
 */
public class QuickCalculator {
  public static void main(String[] args) throws Exception {
    BigFraction saved = new BigFraction(1, 3);
    BFCalculator bfCalculator = new BFCalculator(saved);
    PrintWriter pen = new PrintWriter(System.out, true);

    /*
     * For every string provided in command-line-arguments perform evaluation of the input and act
     * accordingly: if the input contains the command STORE, then save the following character as a
     * holder for the latest evaluated number. If the input results in any error then print
     * appropiate error message. if the output's denominator is 1 then present result as natural
     * number, not fractional. Furthermore, while presenting the results of the evaluation print the
     * equation it is the result of.
     */
    for (String input : args) {
      if (input.contains("STORE")) {
        char charStoreHolder = input.charAt(input.length() - 1);
        saved = bfCalculator.store(charStoreHolder);
      } else {
        saved = bfCalculator.evaluate(input);
        if (saved == null) {
          if (bfCalculator.errorMessage == 1) {
            pen.println(
                "Provide valid input that consists of alternating numerical values and expressions");
          } else if (bfCalculator.errorMessage == 2) {
            pen.println(
                "Provided two numbers/registers in a row. Ensure that your input consists of alternating numerical values and expressions");
          } else if (bfCalculator.errorMessage == 3) {
            pen.println(
                "Provided two operations in a row. Ensure that your input consists of alternating numerical values and expressions");
          } else {
            pen.println("Unidentified error");
          }
        } else if (saved.denom.equals(BigInteger.valueOf(1))) {
          pen.println(input + " = " + saved.num);
        } else {
          pen.println(input + " = " + saved);
        }
      }
    }

  }
}

