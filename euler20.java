/* Problem 20

n! means n × (n − 1) × ... × 3 × 2 × 1

For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.

Find the sum of the digits in the number 100!

*/

import java.util.*;
import java.math.*;

public class euler20 {
 
    public static BigInteger sumFact(int bint){
		ArrayList<BigInteger> digits = new ArrayList<BigInteger>();
		BigInteger fact = BigInteger.ONE;
		BigInteger sum = BigInteger.ZERO;
		while(bint > 0){
			BigInteger newn = new BigInteger(Integer.toString(bint));
			fact = fact.multiply(newn);
			bint--;
		}
		while (fact.compareTo(BigInteger.ZERO) == 1) {
			digits.add(fact.mod(BigInteger.TEN));
			fact = fact.divide(BigInteger.TEN);
		}
		for(int n = 0; n < digits.size(); n++){
			sum = sum.add(digits.get(n));
		}
		return sum;
	}
	
	public static void main(String[] args) {
		System.out.println(sumFact(100));
	}
}
