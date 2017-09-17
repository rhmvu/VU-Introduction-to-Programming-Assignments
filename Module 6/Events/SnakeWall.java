package Events;

import java.io.PrintStream;
import java.util.Scanner;

import ui.Event;
import ui.SnakeUserInterface;
import ui.UserInterfaceFactory;
public class SnakeWall {
	int MAXIMUM_WIDTH = 40;
	int MAXIMUM_HEIGHT = 30;
	SnakeUserInterface ui;
	PrintStream out;
	SnakeWall(){
		ui = UserInterfaceFactory.getSnakeUI(MAXIMUM_WIDTH, MAXIMUM_HEIGHT);
		out = new PrintStream(System.out);
	}
	void start(){
		ui.showChanges();
		//levelSelector();

		while (true) { // infinite loop
			Event event = ui.getEvent();
			processEvent(event);
			ui.showChanges();
		}
	}
	
	/*void getEvent(){
		while (true) { // infinite loop
			Event event = getEvent();
			processEvent(event);
		}
	}*/
	void processEvent(Event event) {
		if (event.name.equals("click")) {
		processClick(event.data);
		} else if (event.name.equals("other_key")) {
		processOtherKey(event.data);
		} 
	}
	
	void processClick(String clickData){
		Scanner coordinateScanner = new Scanner(clickData);
		coordinateScanner.useDelimiter(" ");
		int x = coordinateScanner.nextInt();
		coordinateScanner.skip(" ");
		int y= coordinateScanner.nextInt();
		coordinateScanner.close();
		ui.place(x, y, SnakeUserInterface.WALL);
		ui.printf("Wall placed at %d,%d\n",x,y);
	}
	 
	void processOtherKey(String keyData){
		if (keyData.equals("Space")){
			
			for(int i = 0; i < MAXIMUM_WIDTH; i++) {
				for (int j = 0; j < MAXIMUM_HEIGHT; j++) {
				ui.place(i, j, ui.EMPTY);
				}
			}
			ui.printf("All walls are removed");
		}
	}
	
	void levelSelector(){
		out.printf("Input how many FPS you would like to play with");
		out.printf("\n (The higher the FPS the harder the game is)");
		Scanner levelScanner = new Scanner(System.in);
		int fPS = levelScanner.nextInt();
		ui.setFramesPerSecond(fPS);
	}

	public static void main(String[] args) {
		new SnakeWall().start();

	}

}
