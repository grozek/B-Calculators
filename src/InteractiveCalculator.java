import java.io.PrintWriter;
import java.util.Scanner;
import java.lang.String;


public class InteractiveCalculator{
    public static void main(String[]args) throws Exception{
        BigFraction saved = new BigFraction (1, 3);
        BFCalculator bf = new BFCalculator (saved);
        PrintWriter pen = new PrintWriter(System.out, true);
        Scanner scans = new Scanner(System.in);
        String input = "";
        int i = 0;

        while (!input.contains("QUIT")){
            i++;

            pen.println("give input");
            input = scans.nextLine();

            if (input.contains("STORE")){
                char x = input.charAt(input.length()-1);
                saved = bf.store(x);
                pen.println("stored" + saved );     
            }
            else{
            saved = bf.evaluate(input);
            pen.println(saved);
            pen.println("processing fractional input");
            }

            
       }
           scans.close(); 
        
        
        //scans.close(); 
        }
    }
    




/*
 * 
 * if (input.contains("STORE")){
                storeLetter = input.substring(6, input.length);
                storeNumber = store();
            }
            if(input.contains (storeLetter)){
                index = indexOf(storeLetter);
                //input[index] = storeNumber;
                }
            
 * 
 * 
 */