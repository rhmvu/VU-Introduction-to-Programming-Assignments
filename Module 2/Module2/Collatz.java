package Module2;
import java.io.PrintStream;
import java.util.Scanner;
class Collatz {
	PrintStream out;
Collatz(){
	out= new PrintStream(System.out);	
}
	void start(){
		Scanner in = new Scanner(System.in);
		out.printf("Input your number: ");
		int number = in.nextInt();
		do {
			if ((number%2) ==0){
				//even
				number = number/2;
				out.printf("%d  ", number);	
			}
			else{
				//odd
				number = 3*number+1;
				out.printf("%d  ", number);
			}
		}while (number !=1);
	}
	public static void main(String[] args) {
		new Collatz().start();
	}
}
