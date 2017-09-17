package HelloWorld2;

import java.io.PrintStream;
import java.util.Scanner;


class HelloWorld2 {
//name		: Ruben
//Assignment: Hello World1
//Date		: 9-9-2016
	
	PrintStream out;
	
	HelloWorld2() {
		
		out= new PrintStream(System.out);
	}
	void start(){
		
		Scanner in = new Scanner(System.in);
		
		out.printf("Enter your name: ");
		String name = in.nextLine();
		out.printf("Hello world!! ");
		out.printf("written by: %s\n",  name);
	}
	public static void main(String[] args) {
		new HelloWorld2().start();

	}

}
