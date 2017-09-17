package Array;
import java.io.PrintStream;
import java.util.Scanner;

class Array {
	PrintStream out;
	Array(){
		out = new PrintStream(System.out);
	}
	
	void start(){
		scanner();
	}
	
	void scanner(){
		Scanner numberScanner = new Scanner(System.in);
		int [] numbers= new int[20];
		out.printf("input 20 numbers, each number followed by an enter:\n56");
		for(int i= 0; i< 20 && numberScanner.hasNextInt(); i++){
			numbers[i] = numberScanner.nextInt();	
		}
		numberScanner.close();
		arrayPrinter(numbers);	
	}
		
	void arrayPrinter(int[] numbers){
		for(int i = 19; i >= 0; i--){
			out.printf("%d ", numbers[i]);
		}
		System.exit(0);
	}
	
	public static void main(String[] args) {
		new Array().start();
	}
}