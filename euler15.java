/* Problem 15

Starting in the top left corner of a 2×2 grid, and only being able to move to the right and down, 
there are exactly 6 routes to the bottom right corner.


How many such routes are there through a 20×20 grid?

*/

import java.lang.*;
import java.util.*;

class euler15 {
	
	public static long paths(int n){
		long paths = 1; 
		for (int i = 0; i < n; i++) {
			paths *= (2 * n) - i;
			paths /= i + 1;
		}
		return paths;
	}
	 
	public static void main(String[] args){
		System.out.println(paths(20));
	}
}
