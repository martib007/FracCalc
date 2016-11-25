package fracCalc;
import java.util.Arrays;
import java.util.Scanner;

public class FracCalc {

    public static void main(String[] args) 
    {
        // TODO: Read the input from the user and call produceAnswer with an equation
		Scanner in = new Scanner (System.in);
		String statement = in.nextLine();
		
		while (!statement.equals("quit"))
		{
//			System.out.println (statement);
			String answer = produceAnswer(statement);
			System.out.println (answer);
			statement = in.nextLine();
		}
    }
    
    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //        
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
    public static String produceAnswer(String input)
    { 
        // TODO: Implement this function to produce the solution to the input
		// 1/4 + 1_1/2 => ["1/4", "+", "1_1/2"]
		String[] splitInput = input.split(" ");
//		System.out.println (Arrays.toString(splitInput));
		
		String operandOne = splitInput[0];
		String operator = splitInput[1];
		String operandTwo = splitInput[2];
		
        return operandTwo;
    }

    // TODO: Fill in the space below with any helper methods that you think you will need
    
}
