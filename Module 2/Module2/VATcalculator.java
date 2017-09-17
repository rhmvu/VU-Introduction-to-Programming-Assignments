package Module2;

import java.io.PrintStream;
import java.util.Scanner;
class VATcalculator {
PrintStream out;
	VATcalculator(){
	out= new PrintStream(System.out);		
	}
	void start(){
	
		Scanner in= new Scanner(System.in);
		out.printf("Input the price with VAT:");
		double priceWithVat = in.nextDouble();

		out.printf("your price without VAT is:€  ");
		out.printf("%.2f", ((priceWithVat/121) *100));
	}
	public static void main(String[] args) {
		new VATcalculator().start();
	}
}
