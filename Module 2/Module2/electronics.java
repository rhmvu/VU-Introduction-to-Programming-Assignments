package Module2;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
class electronics {
	static final double SALEREDUCTOR = 0.85;
	static final double SALEREDUCTION = 0.15;
	PrintStream out;

electronics(){
	out = new PrintStream(System.out);
}
	void start(){
		Scanner in = new Scanner(System.in);
	
		out.printf("Enter the price of the first article:");
		double priceFirst = in.nextDouble();
	
		out.printf("Enter the price of the second article:");
		double priceSecond = in.nextDouble();
	
		out.printf("Enter the price of the third article:");
		double priceThird = in.nextDouble();
	
		double priceHighest = Collections.max(Arrays.asList(priceFirst,priceSecond,priceThird));
		double discount = priceHighest*SALEREDUCTION;
	
		out.printf("%s","Discount: ");
		out.printf("%.2f\n", (discount));
		out.printf("%s", "Total: ");
		out.printf("%.2f", (priceFirst+priceSecond+priceThird-discount));
	
}
	public static void main(String[] args) {
		new electronics().start();
	}

}
