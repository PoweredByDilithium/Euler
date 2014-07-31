import java.io.*;
import java.util.*;
import java.math.*;

class adjprod {

	public static Integer product(ArrayList<Integer> lst){
		int maxProduct  = 1;
		int tempProduct = 1;
		List<Integer> horProds    = new ArrayList<Integer>();
		List<Integer> vertProds   = new ArrayList<Integer>();
		List<Integer> diagLRProds = new ArrayList<Integer>();
		List<Integer> diagRLProds = new ArrayList<Integer>();
		List<Integer> temp        = new ArrayList<Integer>();
		List<Integer> maxProds    = new ArrayList<Integer>();

		// Diagonal products Left -> Right
		for (int step = 0; step < 16; step++){
			for (int lookingFor = 0; lookingFor <= 16; lookingFor++){
				for (int p = 0; p < 80; p++){
					if ((p+(step*21)-lookingFor)%21 == 0) tempProduct *= lst.get(p+(step*21));
				}
				diagLRProds.add(tempProduct);
				tempProduct = 1;
			}
		}
		//System.out.println(diagLRProds.toString());
		maxProds.add(Collections.max(diagLRProds));
		
		// Diagonal products Right -> Left
		Collections.reverse(lst);
		for (int step = 0; step < 16; step++){
			for (int lookingFor = 0; lookingFor <= 16; lookingFor++){
				for (int p = 0; p < 80; p++){
					if ((p+(step*21)-lookingFor)%21 == 0) tempProduct *= lst.get(p+(step*21));
				}
				diagRLProds.add(tempProduct);
				tempProduct = 1;
			}
		}
		Collections.reverse(lst);
		maxProds.add(Collections.max(diagRLProds));
		//System.out.println(diagRLProds.toString());
		
		// Vertical products
		for (int step = 0; step <= 16; step++){
			for (int lookingFor = 0; lookingFor < 20; lookingFor++){
				for (int p = 0; p < 80; p++){
					if((p+(step*20)-lookingFor)%20 == 0) tempProduct *= lst.get(p+(step*20));
				}
				vertProds.add(tempProduct);
				tempProduct = 1;
			}
		}		
		//System.out.println(vertProds.toString());
		maxProds.add(Collections.max(vertProds));
		
		// Horizontal products
		int n = 0; int tmp = 0; int r = 0;
		while(r <= lst.size()-20){
			while(tmp <= 16){
				tempProduct *= lst.get(n+r);
				temp.add(tempProduct);
				if (temp.size() % 4 == 0){
					horProds.add(temp.get(temp.size()-1));
					temp.clear();
					tempProduct = 1;
					tmp++;
					n = tmp;
				}
				else n++;
			}
			n = 0;
			tmp = 0;
			r+=20;
		}
		//System.out.println(horProds.toString());
		maxProds.add(Collections.max(horProds));

		return Collections.max(maxProds);
	}
	
	public static void main(String[] args) throws IOException {

		List<String> lines = new ArrayList<String>();
		ArrayList<Integer> cells = new ArrayList<Integer>();
		
		
		if(args.length < 1) {
		    System.exit(1);
		}
		
		Scanner reader = new Scanner(new FileInputStream(args[0]));
		while (reader.hasNext()) {
			lines.add(reader.next());
		}
		int n = 0;
		int digit = 0;
		while (n <= lines.size()-1){			
			digit = Integer.parseInt(lines.get(n));
			cells.add(digit);
			n++;
		}
		System.out.println("Max Product = " + product(cells));
	}

}
