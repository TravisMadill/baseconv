package baseconv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static NumberConverter nc = new NumberConverter();

	public static void main(String[] args) throws IOException {
		// Simple input
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		
		int inbase = -1;
		String in = null;
		int outbase = -1;
		
		/* Character.MIN_RADIX and Character.MAX_RADIX are Java constants that are used for converting numbers to unique bases.
		 * The characters they use in their conversions, in order for base-36 are 0-9, then a-z */
		
		while(inbase < Character.MIN_RADIX || inbase > Character.MAX_RADIX){
			System.out.print("Please input the base the number you will enter is in: ");
			
			// Make sure this is a valid base
			try {
				inbase = Integer.parseInt(r.readLine());
				if(inbase < Character.MIN_RADIX || inbase > Character.MAX_RADIX)
					System.err.printf("Invalid base. Please enter a value between %d and %d.", Character.MIN_RADIX, Character.MAX_RADIX);
			} catch(NumberFormatException e){
				System.err.println("Not a number. Please try again.");
			}
		}
		
		
		while(in == null){
			System.out.printf("Please input the base-%d number: ", inbase);
			in = r.readLine();
			
			// Make sure the number's actually a number
			try {
				Integer.parseInt(in, inbase);
			} catch(NumberFormatException e){
				System.err.println("Not a number. Please try again.");
				in = null;
			}
		}
		
		nc.readNumber(in, inbase);
		
		while(outbase < Character.MIN_RADIX || outbase > Character.MAX_RADIX){
			System.out.print("Please input the base you want to convert this number to: ");

			// Make sure this is a valid base
			try {
				outbase = Integer.parseInt(r.readLine());
				if(outbase < Character.MIN_RADIX || outbase > Character.MAX_RADIX)
					System.err.printf("Invalid base. Please enter a value between %d and %d.", Character.MIN_RADIX, Character.MAX_RADIX);
			} catch(NumberFormatException e){
				System.err.println("Not a number. Please try again.");
			}
		}
		
		
		System.out.println("Result: " + nc.convertNumber(outbase));
	}
	
}
