package frank.interview.strings;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import frank.interview.strings.AddTwoBinaryNumberAsStrings;


public class AddTwoBinaryNumberAsStringsTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		assertEquals("10011", AddTwoBinaryNumberAsStrings.add("110", "1101"));
	}
	
	@Test
	public void test2() {
		assertEquals("100", AddTwoBinaryNumberAsStrings.add("10", "10"));
	}
	
	@Test
	public void autoTest() {
		for (int i = 0; i < 50; i++) {
			for (int j = 0; j < 50; j++) {
				assertEquals(numberToString(i + j), 
						AddTwoBinaryNumberAsStrings.add(
								numberToString(i), 
								numberToString(j)));
			}
		}
	}
	
	public void testConverter() {
		for (int i = 0; i < 50; i++) {
			System.out.println(i+": \t"+numberToString(i));
		}
	}

	private static String numberToString(int number) {
		if (number == 0) {
			return "0";
		}
		StringBuffer buffer = new StringBuffer();
		while (number > 0) {
			if ((number & 1) == 1) {
				buffer.append('1');
			} else {
				buffer.append('0');
			}
			number = number >> 1;
		}
		return buffer.reverse().toString();
	}
}
