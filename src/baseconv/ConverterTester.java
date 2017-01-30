package baseconv;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ConverterTester {
	
	@Rule
	public final ExpectedException exception = ExpectedException.none();
	
	NumberConverter nc = new NumberConverter();

	@Test
	public void test() {
		//Standard conversion
		nc.readNumber("1001", 2);
		assertEquals("9", nc.convertNumber(10));
		
		//Unique conversion
		nc.readNumber("4ab", 12);
		assertEquals("15b", nc.convertNumber(24));
		
		//For bad input, expect NumberFormatException,
		// since the Main class handles it properly
		exception.expect(NumberFormatException.class);
		nc.readNumber("Bad input", 10);
		nc.convertNumber(2);
	}

}
