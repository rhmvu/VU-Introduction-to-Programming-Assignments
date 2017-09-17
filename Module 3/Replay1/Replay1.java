package Replay1;
import ui.UserInterfaceFactory;
import java.io.PrintStream;
import java.util.Scanner;
import ui.OthelloReplayUserInterface;
import ui.UIAuxiliaryMethods;

class Replay1 {
	static final int BLACK = 2;
	static final int WHITE = 1;
	int waitingTime,
	x,
	y,
	player;
	Boolean move;
	OthelloReplayUserInterface ui;
	PrintStream out;
	Scanner input = UIAuxiliaryMethods.askUserForInput().getScanner();
	
	Replay1(){
		ui = UserInterfaceFactory.getOthelloReplayUI();
		out = new PrintStream(System.out);
	}
	void start(){
		ui.place(4-1, 5-1, BLACK);
		ui.place(5-1, 4-1, BLACK);
		ui.place(5-1, 5-1, WHITE);
		ui.place(4-1, 4-1, WHITE);
		ui.showChanges();
		scanner();
	}
	
	void scanner(){
		while(input.hasNextLine()){
		Scanner lineScanner= new Scanner(input.nextLine());
		inputParser(lineScanner);
		changer();
		}
	}
		
	void inputParser(Scanner lineScanner){
		String inputPlayer= lineScanner.next();
		player= setPlayer(inputPlayer);
		waitingTime= lineScanner.nextInt();
		String stringMove= lineScanner.next();
		move = stringMove.equals("move")? true: false;
		if(move==false){
			scanner();
		}
		String xaxis = lineScanner.next();
		int yaxis= lineScanner.nextInt();
		getLocation(xaxis.charAt(0),yaxis);
	}
	
	int setPlayer(String inputPlayer){
		int result= inputPlayer.equals("white") ? WHITE: BLACK;
		return result;
	}
	
	void getLocation(char xaxis,int yaxis){
		switch (xaxis){
			case 'a': x=0; break;
			case 'b': x=1; break;
			case 'c': x=2; break;
			case 'd': x=3; break;
			case 'e': x=4; break;
			case 'f': x=5; break;
			case 'g': x=6; break;
			case 'h': x=7; break;
		}
		switch(yaxis){
			case 1: y= 0; break;
			case 2: y= 1; break;
			case 3: y= 2; break;
			case 4: y= 3; break;
			case 5: y= 4; break;
			case 6: y= 5; break;
			case 7: y= 6; break;
			case 8: y= 7; break;
		}
	}	
	
	void changer(){
		
		ui.place(x,y, player);
		if(waitingTime >0){
			ui.wait(waitingTime);
			ui.showChanges();
		}
		if(input.hasNextLine()){
			scanner();
		} else{
			out.printf("The game is finished, the GUI wil close in 10 seconds");
			ui.wait(10000);
			System.exit(0);
		}
	}
	
	public static void main(String[] args) {
		new Replay1().start();
	}
}