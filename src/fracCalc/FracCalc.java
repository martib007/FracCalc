package fracCalc;
import java.util.Arrays;
import java.util.Scanner;

public class FracCalc {

    public static void main(String[] args) 
    {
    	// reads input statement of the user
		Scanner in = new Scanner (System.in);
		String statement = in.nextLine();
		
		// continues to read user statements until user says quit
		while (!statement.equals("quit"))
		{
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
    
    /**
     * Reads the input from the user and chops it into three different parts of an array
     * @param input user's statement/words
     * @return an array that holds 3 parts; 2 numbers(operands) and 1 operator
     */
    
    public static String produceAnswer(String input)
    { 
		// ex. 1/4 + 1_1/2 => ["1/4", "+", "1_1/2"]
		String[] splitInput = input.split(" ");
		
		String operandOne = splitInput[0]; // 1/4
		String operator = splitInput[1]; // +, -, *, /
		String operandTwo = splitInput[2]; // 1_1/2

		String anwser = calculateEquation(operandOne, operator, operandTwo);
		
        return anwser;
    }
    
    // -3_3/4 + 2_2/4
    
    /**
     * Evaluates a given formula based on the format given
     * @param operandOne a mixed number, faction, or whole number
     * @param operator +, -, *, /
     * @param operandTwo a mixed number, faction, or whole number
     * @return
     */
    
    public static String calculateEquation(String operandOne, String operator, String operandTwo) 
    {   	
    	// parsed operands, from string to parsed values
		int[] operandOneDescribed = describeOperand(operandOne);
		int[] operandTwoDescribed = describeOperand(operandTwo);
		
		
		
		//defining of variables used
    	int whole = 0;
    	int numerator1 = operandOneDescribed[1];
    	int denominator1 = operandOneDescribed[2];
    	int numerator2 = operandTwoDescribed[1];
    	int denominator2 = operandTwoDescribed[2];
    	int numeratorFinal = 0;
    	int denominatorFinal = 0;
    	String fraction = "";
    	String result = "";
    	
		// support the 4 basic arithmetic operations: 
		// add (+), subtract (-), multiply (*), and divide (/).
		if (operator.equals("+")) // sum of the operands
		{
			// combination of whole numbers
			whole = operandOneDescribed[0] + operandTwoDescribed[0];
			
			// proper evaluation of numeratorFinal and denominatorFinal
			if (denominator1 != denominator2)
			{
				numeratorFinal = (denominator2 * numerator1) + (denominator1 * numerator2);
				denominatorFinal = denominator1 * denominator2;
			}
			else
			{
				numeratorFinal = numerator1 + numerator2;
				denominatorFinal = denominator1;
			}
			
			//checking/evaluation of fraction based on improperness, value, etc.
			if (numeratorFinal == 0) // the fraction is equal to 0
			{
				numeratorFinal = 0;
		    	denominatorFinal = 1;
				fraction = "";
			}
			else if (numeratorFinal == denominatorFinal) // the fraction is equal to 1
			{
				whole++;
				numeratorFinal = 0;
		    	denominatorFinal = 1;
		    	numeratorFinal = Math.abs(numeratorFinal);
				denominatorFinal = Math.abs(denominatorFinal);
				fraction = "";
			}
			else if (Math.abs(numeratorFinal) > Math.abs(denominatorFinal)) // the fraction is improper
			{
				if (numeratorFinal % denominatorFinal == 0) // the fraction is perfectly divisible
				{
					int temp = numeratorFinal / denominatorFinal;
					whole = whole + temp;
					numeratorFinal = 0;
			    	denominatorFinal = 1;
			    	numeratorFinal = Math.abs(numeratorFinal);
					denominatorFinal = Math.abs(denominatorFinal);
					fraction = "";
				}
				else // the fraction is not perfectly divisible ()
				{
					int temp = numeratorFinal / denominatorFinal;
					whole = whole + temp;
					numeratorFinal = numeratorFinal % denominatorFinal;
					numeratorFinal = Math.abs(numeratorFinal);
					denominatorFinal = Math.abs(denominatorFinal);
					fraction = numeratorFinal + "/" + denominatorFinal;
				}
			}
			else // the fraction is proper
			{
				numeratorFinal = Math.abs(numeratorFinal);
				denominatorFinal = Math.abs(denominatorFinal);
				fraction = numeratorFinal + "/" + denominatorFinal;
			}
			
		}
		

		else if (operator.equals("-")) // difference of the operands
		{
			// combination of whole numbers
			whole = operandOneDescribed[0] - operandTwoDescribed[0];
			
			// proper evaluation of numeratorFinal and denominatorFinal
			if (denominator1 != denominator2)
			{
				numeratorFinal = (denominator2 * numerator1) - (denominator1 * numerator2);
				denominatorFinal = denominator1 * denominator2;
			}
			else
			{
				numeratorFinal = numerator1 - numerator2;
				denominatorFinal = denominator1;
			}
			
			//checking/evaluation of fraction based on improperness, value, etc.
			if (numeratorFinal == 0) // the fraction is equal to 0
			{
				numeratorFinal = 0;
		    	denominatorFinal = 1;
				fraction = "";
			}
			else if (numeratorFinal == denominatorFinal) // the fraction is equal to 1
			{
				whole--;
				numeratorFinal = 0;
		    	denominatorFinal = 1;
		    	numeratorFinal = Math.abs(numeratorFinal);
				denominatorFinal = Math.abs(denominatorFinal);
				fraction = "";
			}
			else if (numeratorFinal > denominatorFinal) // the fraction is improper
			{
				if (numeratorFinal % denominatorFinal == 0) // the fraction is perfectly divisible
				{
					int temp = numeratorFinal / denominatorFinal;
					whole = whole - temp;
					numeratorFinal = 0;
			    	denominatorFinal = 1;
			    	numeratorFinal = Math.abs(numeratorFinal);
					denominatorFinal = Math.abs(denominatorFinal);
					fraction = "";
				}
				else // the fraction is not perfectly divisible ()
				{
					int temp = numeratorFinal / denominatorFinal;
					whole = whole - temp;
					numeratorFinal = numeratorFinal % denominatorFinal;
					numeratorFinal = Math.abs(numeratorFinal);
					denominatorFinal = Math.abs(denominatorFinal);
					fraction = numeratorFinal + "/" + denominatorFinal;
				}
			}
			else // the fraction is proper
			{
				numeratorFinal = Math.abs(numeratorFinal);
				denominatorFinal = Math.abs(denominatorFinal);
				fraction = numeratorFinal + "/" + denominatorFinal;
			}
			
		}
		else if (operator.equals("*")) // product of the operands
		{	
			// proper evaluation of numeratorFinal and denominatorFinal
			numeratorFinal = 0;
			denominatorFinal = denominator1 * denominator2;
			
			// multiply all together (FOIL)
			int temp1 = operandOneDescribed[0] * operandTwoDescribed[0];
			int temp2 = operandOneDescribed[0] * numerator2; 
			int temp3 = numerator1 * operandTwoDescribed[0];
			int temp4 = numerator1 * numerator2;
				
			temp1 = temp1 * denominator1 * denominator2 * denominatorFinal;
			temp2 = temp2 * denominator1 * denominatorFinal;
			temp3 = temp3 * denominator2 * denominatorFinal;
			temp4 = temp4 * denominator1 * denominator2;
			
			numeratorFinal = temp1 + temp2 + temp3 + temp4;
			denominatorFinal = denominator1 * denominator2 * denominatorFinal;
			
			
			// checking/evaluation of fraction based on improperness, value, etc.
			if (numeratorFinal == 0) // the fraction is equal to 0
			{
				numeratorFinal = 0;
		    	denominatorFinal = 1;
				fraction = "";
			}
			else if (numeratorFinal == denominatorFinal) // the fraction is equal to 1
			{
				whole++;
				numeratorFinal = 0;
		    	denominatorFinal = 1;
		    	numeratorFinal = Math.abs(numeratorFinal);
				denominatorFinal = Math.abs(denominatorFinal);
				fraction = "";
			}
			else if (Math.abs(numeratorFinal) > Math.abs(denominatorFinal)) // the fraction is improper
			{
				if (numeratorFinal % denominatorFinal == 0) // the fraction is perfectly divisible
				{
					int temp = numeratorFinal / denominatorFinal;
					whole = whole + temp;
					numeratorFinal = 0;
			    	denominatorFinal = 1;
			    	numeratorFinal = Math.abs(numeratorFinal);
					denominatorFinal = Math.abs(denominatorFinal);
					fraction = "";
				}
				else // the fraction is not perfectly divisible ()
				{
					int temp = numeratorFinal / denominatorFinal;
					whole = whole + temp;
					numeratorFinal = numeratorFinal % denominatorFinal;
					numeratorFinal = Math.abs(numeratorFinal);
					denominatorFinal = Math.abs(denominatorFinal);
					fraction = numeratorFinal + "/" + denominatorFinal;
				}
			}
			else // the fraction is proper
			{
				fraction = numeratorFinal + "/" + denominatorFinal;
			}
			
		}
		else if (operator.equals("/")) // quotient of the operands	
		{	
			// proper evaluation of numeratorFinal and denominatorFinal
			
			numeratorFinal = numerator1 * numerator2;
			denominatorFinal = denominator1 * denominator2;
			
			// multiply all together (FOIL)
			int temp1 = operandOneDescribed[0] * denominator1;
			int temp2 = numerator1; 
			int temp3 = operandTwoDescribed[0] * denominator2;
			int temp4 = numerator2;
				
			int temp5 = temp1 + temp2;
			int temp6 = temp3 + temp4;
			
			numeratorFinal = temp5 * denominator2;
			denominatorFinal = denominator1 * temp6;
			
		
			
			// checking/evaluation of fraction based on improperness, value, etc.
			if (numeratorFinal == 0) // the fraction is equal to 0
			{
				numeratorFinal = 0;
		    	denominatorFinal = 1;
				fraction = "";
			}
			else if (numeratorFinal == denominatorFinal) // the fraction is equal to 1
			{
				whole++;
				numeratorFinal = 0;
		    	denominatorFinal = 1;
		    	numeratorFinal = Math.abs(numeratorFinal);
				denominatorFinal = Math.abs(denominatorFinal);
				fraction = "";
			}
			else if (Math.abs(numeratorFinal) > Math.abs(denominatorFinal)) // the fraction is improper
			{
				if (numeratorFinal % denominatorFinal == 0) // the fraction is perfectly divisible
				{
					int temp = numeratorFinal / denominatorFinal;
					whole = whole + temp;
					numeratorFinal = 0;
			    	denominatorFinal = 1;
			    	numeratorFinal = Math.abs(numeratorFinal);
					denominatorFinal = Math.abs(denominatorFinal);
					fraction = "";
				}
				else // the fraction is not perfectly divisible ()
				{
					int temp = numeratorFinal / denominatorFinal;
					whole = whole + temp;
					numeratorFinal = numeratorFinal % denominatorFinal;
					numeratorFinal = Math.abs(numeratorFinal);
					denominatorFinal = Math.abs(denominatorFinal);
					fraction = numeratorFinal + "/" + denominatorFinal;
				}
			}
			else // the fraction is proper
			{
//				numeratorFinal = Math.abs(numeratorFinal);
//				denominatorFinal = Math.abs(denominatorFinal);
				fraction = numeratorFinal + "/" + denominatorFinal;
			}
			
		}
		
		//result
		if (fraction.equals("") || numeratorFinal == 0)
		{
			return whole + "";
		}
		else 
		{
			return whole + "_" + fraction;
		}
		
    }
    
    /**
     * Describes the whole number, numerator, and denominator of input
     * @method: describeOperand
     * @param input		a string fraction or mixed fraction (e.g. 1/4 or 1_1/4)
     * @return whole number, numerator, and denominator 
     */
    
    public static int[] describeOperand(String input) 
    {
		int whole = 0;
		int numerator = 0;
		int denominator = 0;
		
		if (input.contains("_"))// calculates a mixed fraction
		{
			// ex. 5_3/4 => ["5", "3/4"]
			String[] splitOperand = input.split("_");
			String[] operandFraction = splitOperand[1].split("/");
			whole = Integer.parseInt(splitOperand[0]); // 5
			numerator = Integer.parseInt(operandFraction[0]); // 3
			denominator = Integer.parseInt(operandFraction[1]); // 4
		}
		else if (input.contains("/"))// calculates a fraction
		{
			// ex. "3/4" => ["3", "4"]
			String[] operandFraction = input.split("/");
			whole = 0; // 0
			numerator = Integer.parseInt(operandFraction[0]); // 3
			denominator = Integer.parseInt(operandFraction[1]); // 4
		}
		else// cacluates a whole number
		{
			// ex. 5 => [5]
			whole = Integer.parseInt(input); // 5
			numerator = 0; // 0
			denominator = 1; // 1
		}
		
		//checks if the number is negative, distributes it
		if (whole < 0)
		{
			numerator = numerator * -1;
		}
		
		int[] result = new int[3];
		result[0] = whole;
		result[1] = numerator;
		result[2] = denominator;
		
		return result;
    } 
}
