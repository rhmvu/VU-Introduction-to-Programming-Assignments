package Module2;
import java.io.PrintStream;
import java.util.Scanner;
class SecondSmallest {
	PrintStream out;
	SecondSmallest(){
		out= new PrintStream(System.out);
	}		
	void start(){
		Scanner in = new Scanner(System.in);
		int smallest;
		int secondSmallest;
		out.printf("input numbers:");
		secondSmallest= smallest = in.nextInt();

		while(in.hasNextInt()){
			int input = in.nextInt();		
			if (input <= smallest){
				secondSmallest= smallest;
				smallest = input;
			}
		}
		out.printf("\n%d is the secondsmallest number in the list \n%d is smallest number in the list", secondSmallest, smallest);
	}
	public static void main(String[] args) {
		new SecondSmallest().start();
	}
}
