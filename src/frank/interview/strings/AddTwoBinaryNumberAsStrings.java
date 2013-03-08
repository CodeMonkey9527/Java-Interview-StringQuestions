package frank.interview.strings;

/*
 * Write a program to sum two binary numbers represented as strings.
 * Example:
 * Input: "110", "01101" 
 * Output: "10011" 
 */
public class AddTwoBinaryNumberAsStrings {
	public static String add(String op1, String op2) {
		if (!validateInput(op1) || !validateInput(op2)) {
			throw new IllegalArgumentException("Check input!");
		}
		StringBuffer buffer = new StringBuffer();
		int length1 = op1.length();
		int length2 = op2.length();
		int length = length1 > length2 ? length1 : length2;
		int carryover = 0;
		for (int i = 0; i < length; i++) {
			int bit1 = getBitAt(op1, i);
			int bit2 = getBitAt(op2, i);
			int bit = bit1 + bit2 + carryover;
			if (bit == 0) {
				carryover = 0;
				buffer.append('0');
			} else if (bit == 1) {
				carryover = 0;
				buffer.append('1');
			} else if (bit == 2) {
				carryover = 1;
				buffer.append('0');
			} else if (bit == 3) {
				carryover = 1;
				buffer.append('1');
			} else {
				throw new IllegalStateException("Impossible!");
			}
		}
		if (carryover == 1) {
			buffer.append('1');
		}
		return buffer.reverse().toString();
	}
	
	private static boolean validateInput(String op) {
		if (op == null || op.length() == 0) {
			return false;
		}
		if (op.length() > 1 && op.charAt(0) != '1') {
			return false;
		}
		for (int i = 1; i < op.length(); i++) {
			char c = op.charAt(i);
			if (c != '0' && c != '1') {
				return false;
			}
		}
		return true;
	}
	
	private static int getBitAt(String op, int index) {
		int bit = 0;
		char c = '0';
		if (index < op.length()) {
			c = op.charAt(op.length() - 1 - index);
			if (c == '1') {
				bit = 1;
			}
		}
		return bit;
	}
}
