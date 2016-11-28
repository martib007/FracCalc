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
		System.out.println("Goodbye");
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
		// 1/4 + 1_1/2 => ["1/4", "+", "1_1/2"]
		String[] splitInput = input.split(" ");
		
		String operandOne = splitInput[0]; // 1/4
		String operator = splitInput[1]; // +, -, *, /
		String operandTwo = splitInput[2]; // 1_1/2

		String anwser = calculcateEquation(operandOne, operator, operandTwo);
		
        return anwser;
    }
    
    /**
     * Evaluates a given formula 
     * @param operandOne a fraction or mixed fraction
     * @param operator +, -, *, /
     * @param operandTwo a fraction or mixed fraction
     * @return
     */
    public static String calculcateEquation(String operandOne, String operator, String operandTwo) {
    	
    	// parsed operands, from string to parsed values
		int[] operandOneDescribed = describeOperand(operandOne);
		int[] operandTwoDescribed = describeOperand(operandTwo);
		
		if (operator.equals("+")) {
			// sum up the operands
		} else if (operator.equals("-")) {
			// find the difference between the operands
		} else if (operator.equals("*")) {
			// find the product of the operands
		} else if (operator.equals("%")) {
			// find the quotiant of the two operands			
		}
	
    	return "";
    }
    
    /**
     * Describes the whole number, numerator, and denominator of input
     * @method: describeOperand
     * @param input		a string fraction or mixed fraction (e.g. 1/4 or 1_1/4)
     * @return whole number, numerator, and denominator 
     */
    public static int[] describeOperand(String input) {	

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
		
		int[] result = new int[3];
		result[0] = whole;
		result[1] = numerator;
		result[2] = denominator;
		
		return result;
    }

    
}
