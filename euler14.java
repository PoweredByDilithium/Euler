import java.lang.*;
import java.util.*;

class collatz {
	 
	 public static void main(String[] args){
		int longest = 0;
		int terms = 0;
		int i;
		long j;
		for (i = 1; i <= 1000000; i++) {
			j = i;
			int this_terms = 1;
			while (j != 1){
				this_terms++;
				if (this_terms > terms) {
					terms = this_terms;
					longest = i;
			    }
			if (j % 2 == 0) j /= 2;
			else j = 3 * j + 1;
			}
		  }
		System.out.println("longest: "+longest+"\n"+terms);
		}
}
