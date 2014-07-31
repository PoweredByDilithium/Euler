/* Problem 22

Using names.txt (right click and 'Save Link/Target As...'), a 46K text file containing over 
five-thousand first names, begin by sorting it into alphabetical order. 
Then working out the alphabetical value for each name, multiply this value by its 
alphabetical position in the list to obtain a name score.

For example, when the list is sorted into alphabetical order, 
COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. 
So, COLIN would obtain a score of 938 × 53 = 49714.

What is the total of all the name scores in the file?

*/

import java.util.*;
import java.io.*;
import java.lang.*;

public class euler22 {

	public static int alphaval(String n){
		int value = 0;
		for (int p = 0; p < n.length(); p++){
			int temp = (int)(n.charAt(p) - 64);
			value += temp;
		}
		return value;
	}
	
	public static String removeChr(String str, char x){
        StringBuilder strBuilder = new StringBuilder();
        char[] rmString = str.toCharArray();
        for(int i = 0; i < rmString.length; i++)
            if(rmString[i] != x) strBuilder.append(rmString[i]);
        return strBuilder.toString();
    }
	
	public static void main(String[] args) throws IOException{
		ArrayList<String> names = new ArrayList<String>();
		if(args.length < 1) {
		    System.exit(1);
		}
		Scanner reader = new Scanner(new FileInputStream(args[0]));
		reader.useDelimiter(",");
		while (reader.hasNext()) {
			String temp = removeChr(reader.next(), '\"');
			names.add(temp);
		}
		Collections.sort(names);
		int theSum = 0;
		for(int m = 0; m < names.size(); m++){
			theSum += alphaval(names.get(m))*(m+1);
		}
		System.out.println(theSum);
	}
}
