package helloWorld1;

import java.io.PrintStream;

class HelloWorld1 {
//name		: Ruben
//Assignment: Hello World1
//Date		: 9-9-2016
	
	PrintStream out;
	
	HelloWorld1() {
		
		out= new PrintStream(System.out);
	}
	void start(){
		out.printf("Hello world!! ");
		out.printf("written by: %s\n",  "...");
		
	}
	

	
	public static void main(String[] args) {
		new HelloWorld1().start();

	}

}
