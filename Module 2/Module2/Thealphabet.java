package Module2;

import java.io.PrintStream;

class Thealphabet {
	PrintStream out;
	
	Thealphabet(){
		out = new PrintStream(System.out);
		}
	void start(){
		for(char i = 'a'; i<= 'z';i++ ){
			out.printf( "%c", i);
		}
	}
	public static void main(String[] args) {
		new Thealphabet().start();
	}
}
