/* Problem 16

2^(15) = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.

What is the sum of the digits of the number 2^(1000)?

*/

import java.lang.*;
import java.util.*;
import java.math.*;

class euler16 {
	 
	public static BigInteger getDigSum(int n){
		BigInteger thePow = BigInteger.ONE.add(BigInteger.ONE);
		thePow = thePow.pow(n);
		BigInteger theSum = BigInteger.ZERO;
		String strThePow = thePow.toString();
		for(int p = 0; p < strThePow.length(); p++){
			theSum = theSum.add(new BigInteger(String.valueOf(Character.getNumericValue(strThePow.charAt(p)))));
		}
		return theSum;
	}
	
	public static void main(String[] args){
		System.out.println(getDigSum(1000));
	}
}
