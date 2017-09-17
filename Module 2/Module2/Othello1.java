package Module2;
import java.io.PrintStream;
import java.util.Scanner;
class Othello1 {
	static final int AMOUNT_OF_SQUARES= 64;
	PrintStream out;
	Othello1(){
		out= new PrintStream(System.out);
	}
	void start(){	
		Scanner in = new Scanner(System.in);
	
		out.printf("Enter the number of white pieces on the board:");
		int amountWhitePieces = in.nextInt();
	
		out.printf("Enter the number of black pieces on the board:");
		int amountBlackPieces =  in.nextInt();
	
		out.printf("The percentage of black pieces on the board is: %.2f%%\n", ((double) amountBlackPieces/AMOUNT_OF_SQUARES)*100);
		out.printf("The percentage of black pieces of all the pieces on the board is: %.2f%%", ((double) (amountBlackPieces/(amountBlackPieces + amountWhitePieces))*100));
}
	public static void main(String[] args) {
		new Othello1().start();
	}
}
