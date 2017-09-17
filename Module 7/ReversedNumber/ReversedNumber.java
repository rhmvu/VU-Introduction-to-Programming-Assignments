package ReversedNumber;
import java.util.Scanner;
public class ReversedNumber {
	
	ReversedNumber(){
		
	}

	void reverseMethod(int number) {
		       if (number < 10) {
			   System.out.println(number);
			   return;
		       }
		       else {
		           System.out.print(number % 10);
		           //Method is calling itself: recursion
		           reverseMethod(number/10);
		       }
		   }
	void numberScanner()
		   {
			int num=0;
			System.out.println("Input your number and press enter: ");
			Scanner in = new Scanner(System.in);
			num = in.nextInt();
			System.out.print("Reverse of the input number is:");
			reverseMethod(num);
			System.out.println();
		   }
		
	public static void main(String[] args) {
		new ReversedNumber().numberScanner();

	}

}
