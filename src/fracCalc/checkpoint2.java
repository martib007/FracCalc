package fracCalc;
import java.util.Arrays;
import java.util.Scanner;

public class checkpoint2 {

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
    
    // 'whole:0 numerator:27 demominator:21'
    // 'whole:0 numerator:27 denominator:21'
    
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
		
		String operandOne = splitInput[0]; // 1/4
		String operator = splitInput[1]; // +, -, *, /
		String operandTwo = splitInput[2]; // 1_1/2
		
		// TODO
		// Int[] = operandOne = describeOperand(operandOne)
		// Int[] operandTwo = describeOperand(operandTwo)
		
		operandTwo = describeOperand(operandTwo);
		
        return operandTwo;
    }
    
    public static String describeOperand(String input) {
		int whole = 0;
		int numerator = 0;
		int denominator = 0;
		
		// calculate mixed fraction
		if (input.contains("_"))
		{
			// 5_3/4 => ["5", "3/4"]
			String[] splitOperand = input.split("_");
			String[] operandFraction = splitOperand[1].split("/");
			whole = Integer.parseInt(splitOperand[0]);
			numerator = Integer.parseInt(operandFraction[0]);
			denominator = Integer.parseInt(operandFraction[1]);
		}
		else if (input.contains("/"))
		{
			// "3/4" => ["3", "4"]
			String[] operandFraction = input.split("/");
			whole = 0;
			numerator = Integer.parseInt(operandFraction[0]);
			denominator = Integer.parseInt(operandFraction[1]);
		}
		else
		{
			whole = Integer.parseInt(input);
			numerator = 0;
			denominator = 1;
		}
		
		if (whole < 0)
		{
			numerator = numerator * -1;
			denominator = denominator * -1;
		}
		
		return "whole:" + whole + " numerator:" + numerator + " denominator:" + denominator;
    }

    // TODO: Fill in the space below with any helper methods that you think you will need
    
}
