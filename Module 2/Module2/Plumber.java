package Module2;
import java.io.PrintStream;
import java.util.Scanner;

class Plumbercalculator {
static final int CALLOUTCOST= 16;
	PrintStream out;
	
	Plumbercalculator(){	
	out = new PrintStream(System.out);		
	}
	
	void start(){
		Scanner in = new Scanner(System.in);
		
		out.printf("Enter the hourly wages:");
		double hourlyWages = in.nextDouble();
		
		out.printf("Enter the number of billable hours:");
		int billableHours = (int) in.nextDouble();
		
		out.printf("%s","The total cost of this repair is:€");
		out.printf("%.2f", ((hourlyWages * billableHours) + CALLOUTCOST));
	}
	public static void main(String[] args) {
		new Plumbercalculator().start();
	}
}
