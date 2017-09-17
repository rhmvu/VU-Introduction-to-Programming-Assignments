package Module2;
import java.io.PrintStream;
import java.util.Scanner;
class Othello2 {
	static final int MINUTES_IN_HOURS_AND_SECONDS = 60;
	static final int SECOND_IN_MS= 1000;
	PrintStream out;
	
	Othello2(){
		out = new PrintStream(System.out);
	}
	void start(){
		Scanner in= new Scanner(System.in);
		out.printf("Input the amount of ms of the black player:\n");
		int msBlack = in.nextInt();
		out.printf("Input the amount of ms of the white player:\n");
		int msWhite = in.nextInt();
		int msHuman;	
		if (msBlack > msWhite){
			msHuman = msBlack;
		}
		else{
			msHuman = msWhite;
		}
		int secondsHuman= msHuman/SECOND_IN_MS;
		int minutesHuman= (int) ((secondsHuman/ MINUTES_IN_HOURS_AND_SECONDS) +0.5);
		int hoursHuman= (minutesHuman /MINUTES_IN_HOURS_AND_SECONDS);
		int minutesHumanCorrected = (int) ((minutesHuman)- (hoursHuman*MINUTES_IN_HOURS_AND_SECONDS)  +0.5);
		int secondsHumanCorrected= (secondsHuman- minutesHuman* MINUTES_IN_HOURS_AND_SECONDS);
		out.printf("%02d:%02d:%02d",hoursHuman, minutesHumanCorrected, secondsHumanCorrected);
		}
	public static void main(String[] args) {
		new Othello2().start();
	}
}
