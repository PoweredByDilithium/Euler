/* Project Euler Problem 17

If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?

NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) contains 23 letters and 115 (one hundred and fifteen) contains 20 letters. 
The use of "and" when writing out numbers is in compliance with British usage
*/

import java.lang.*;
import java.util.*;
import java.io.*;

class euler17 {	
	public static int analysis(ArrayList<String> theList){
		String temp = "";
		int strLength = 0, oneToNine = 0, tenToNineteen = 0, oneToNinetyNine = 0;
		for(int n = 0; n < theList.size(); n++){
			temp = theList.get(n);
			if(temp.equals("nine")){
				strLength += temp.length();
				oneToNine = strLength;
			}
			else if(temp.equals("nineteen")){
				strLength += temp.length();
				tenToNineteen = strLength - oneToNine;
			}
			else if(temp.equals("twenty")){
				for(int p = 0; p < 10; p++) strLength += temp.length();
				strLength += oneToNine;
			}
			else if(temp.equals("thirty")){
				for(int p = 0; p < 10; p++) strLength += temp.length();
				strLength += oneToNine;
			}
			else if(temp.equals("forty")){
				for(int p = 0; p < 10; p++) strLength += temp.length();
				strLength += oneToNine;
			}
			else if(temp.equals("fifty")){
				for(int p = 0; p < 10; p++) strLength += temp.length();
				strLength += oneToNine;
			}
			else if(temp.equals("sixty")){
				for(int p = 0; p < 10; p++) strLength += temp.length();
				strLength += oneToNine;
			}
			else if(temp.equals("seventy")){
				for(int p = 0; p < 10; p++) strLength += temp.length();
				strLength += oneToNine;
			}
			else if(temp.equals("eighty")){
				for(int p = 0; p < 10; p++) strLength += temp.length();
				strLength += oneToNine;
			}
			else if(temp.equals("ninety")){
				for(int p = 0; p < 10; p++) strLength += temp.length();
				strLength += oneToNine;
				oneToNinetyNine = strLength;
				System.out.println(oneToNinetyNine);
			}
			else if(temp.equals("hundred")){
				strLength += temp.length();
				for(int r = 0; r < 9; r++){
					for(int p = 0; p < 100; p++){
						if (p == 0) strLength += temp.length();
						else strLength += (3 + temp.length());
						switch(r){
							case 0:
							case 5:
							case 1: strLength += 3; break;
							case 6:
							case 7:
							case 2: strLength += 5; break;
							case 3:
							case 8:
							case 4: strLength += 4; break;
							default: break;
						}
					}
					strLength += oneToNinetyNine;
				}
			}
			else strLength += temp.length();			
		}
		return strLength + 4;
	}
	
	public static void main(String[] args) throws IOException {
		if(args.length < 1) {
				System.exit(1);
		}
		ArrayList<String> lines = new ArrayList<String>();
		Scanner reader = new Scanner(new FileInputStream(args[0]));
		while (reader.hasNext()) {
			lines.add(reader.next());
		}		
		System.out.println(analysis(lines));
	}
}
