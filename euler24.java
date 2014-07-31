/* Problem 24

A permutation is an ordered arrangement of objects. For example, 3124 is one possible permutation 
of the digits 1, 2, 3 and 4. If all of the permutations are listed numerically or alphabetically, 
we call it lexicographic order. The lexicographic permutations of 0, 1 and 2 are:

012   021   102   120   201   210

What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?

*/

import java.util.*;
import java.math.*;

public class euler24 {

    public static int counter = 0;
	
	public static boolean nextPermutation(int[] array) {
    // Find longest non-increasing suffix
    int i = array.length - 1;
	counter++;
    while (i > 0 && array[i - 1] >= array[i])
        i--;
    
    if (i == 0 || counter == 1000000){
        System.out.println(Arrays.toString(array));
		return false;
		}
		
    int j = array.length - 1;
    while (array[j] <= array[i - 1])
        j--;
    
    // Swap the pivot with j
    int temp = array[i - 1];
    array[i - 1] = array[j];
    array[j] = temp;
    
    // Reverse the suffix
    j = array.length - 1;
    while (i < j) {
        temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        i++;
        j--;
    }
    
    // Successfully computed the next permutation
    return true;
}

    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};  // Must start at lowest permutation
		while (nextPermutation(array));
		}
}
