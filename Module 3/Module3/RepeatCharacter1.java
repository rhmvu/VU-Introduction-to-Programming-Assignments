package Module3;

import java.io.PrintStream;
import java.util.Scanner;

class RepeatCharacter1 {
PrintStream out;
	RepeatCharacter1(){
		out = new PrintStream(System.out);
}
	void printer (int amountOfMarks){
		for(int loopCount = 0; loopCount < amountOfMarks; loopCount++){
			out.printf("!");
		}
	}
	public void start(){
		Scanner input= new Scanner(System.in);
		out.printf("input the number of exclamationmarks here:");
		printer(input.nextInt());
	}



	public static void main(String[] args) {
		new RepeatCharacter1().start();

	}

}
