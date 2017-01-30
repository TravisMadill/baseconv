package baseconv;

public class NumberConverter {

	private int number = -1;
	
	/**
	 * Takes in a number from the user (as a String)
	 *  and saves its real value using the base value specified.
	 * @param num The user input (as a String)
	 * @param base The base this number is in (valid values: 2-16)
	 */
	public void readNumber(String num, int base){
		number = Integer.parseInt(num, base);
	}
	
	/**
	 * Returns this number as a string, in the specified base.
	 * @param base The base to use for conversion
	 * @return The number in the appropriate base,
	 *  as a String from the stored real value.
	 */
	public String convertNumber(int base){
		return Integer.toString(number, base);
	}
}
