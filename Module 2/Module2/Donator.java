package Module2;
import java.io.PrintStream;
import java.util.Scanner;
class Donator{
	PrintStream out;
	Donator(){
		out = new PrintStream(System.out);
		}

	void start(){
		Scanner in = new Scanner(System.in);
		double donateAmount = 0;
		do{
		out.printf("Input the amount of money you want to donate: ");
		donateAmount = in.nextDouble();
		} while(donateAmount <50);
		out.printf("Thank you for your contribution of %.2f euro", donateAmount);
		}
	public static void main(String[] args) {
		new Donator().start();
		}
}
