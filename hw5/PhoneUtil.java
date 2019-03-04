package hw5;
import java.math.BigInteger;
import java.util.*;

public final class PhoneUtil {

	private PhoneUtil() {};

	public static void prependOne(Map<String, BigInteger> m) {

		//make biginteger to hold max value
		BigInteger max_phone = new BigInteger("10000000000");
		BigInteger min_phone = new BigInteger("999999999");
		BigInteger add_digit = new BigInteger("10000000000");

		//iterate through all entries in phone book
		for (Map.Entry<String, BigInteger> entry : m.entrySet()) {
			//if the phone book numebr has exactly 10 digits, add 1000000000
			if (entry.getValue().min(min_phone) == min_phone  && (entry.getValue().max(max_phone) == max_phone)) {
				BigInteger temp = entry.getValue();
				temp = temp.add(add_digit);
				entry.setValue(temp);

			}	
		}

	}
}