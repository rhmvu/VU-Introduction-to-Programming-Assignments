package Module3;
	import java.io.PrintStream;
	import java.util.Scanner;
	public class RepeatCharacter2 {
	PrintStream out;
		RepeatCharacter2(){
			out = new PrintStream(System.out);
	}
		void excPrinter (int amountOfMarks){
			for(int loopCount = 0; loopCount < amountOfMarks; loopCount++){
				out.printf("!");
			}
		}
		void comPrinter (int amountOfCommas){
			for(int loopCount = 0; loopCount < amountOfCommas; loopCount++){
				out.printf(",");
			}
		}
		
		public void start(){
			Scanner input= new Scanner(System.in);
			out.printf("input the number of exclamationmarks here:");
			excPrinter(input.nextInt());
			out.printf("\ninput the number of comma's here:");
			comPrinter(input.nextInt());
		}



		public static void main(String[] args) {
			new RepeatCharacter2().start();

		}

	}
