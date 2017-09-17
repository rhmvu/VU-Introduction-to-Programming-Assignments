package LongestPath;
import java.util.Scanner;
import ui.LabyrinthUserInterface;
import ui.UIAuxiliaryMethods;
import ui.UserInterfaceFactory;

public class LongestPath {
	static final int MAX_WIDTH = 32;
	static final int MAX_HEIGHT = 24;
	int fps;
	CoordinateArray longestPath;
	CoordinateArray currentPath;
	CoordinateArray wall;
	Coordinate startingCoordinate;
	Coordinate finalCoordinate;
	LabyrinthUserInterface ui;

	LongestPath(){
		ui = UserInterfaceFactory.getLabyrinthUI(MAX_WIDTH, MAX_HEIGHT);
		longestPath = new CoordinateArray();
		currentPath = new CoordinateArray();
		wall = new CoordinateArray();
	}

	void start(){
		inputScanner();
		findLongestPath(startingCoordinate);
		printArray(longestPath,LabyrinthUserInterface.PATH);
		ui.showChanges();
		ui.printf("Longest path length: %d", longestPath.numberOfElements);
	}

	void inputScanner(){
		Scanner input = UIAuxiliaryMethods.askUserForInput().getScanner();
		parseLevelInput(input);
		printArray(wall,LabyrinthUserInterface.WALL);
		String fpsQuestion = "With how many FPS would you like to find the longest path?";
		fpsQuestion = fpsQuestion + "\n(Above 1000 fps will result in the maximum fps possible)";
		Scanner fpsScanner = new Scanner(UIAuxiliaryMethods.askUserForString(fpsQuestion));
		fps = (int) fpsScanner.nextDouble();
		fpsScanner.close();
	}

	void parseLevelInput(Scanner levelInput){
		levelInput.useDelimiter("=");
		Scanner startScanner = new Scanner(levelInput.next());
		startScanner.useDelimiter("\\D");
		int x = startScanner.nextInt();			
		startScanner.skip(" ");
		int y = startScanner.nextInt();
		startingCoordinate = new Coordinate(x, y);
		ui.encircle(x, y);

		startScanner.close();
		levelInput.skip("=");
		Scanner finalScanner = new Scanner(levelInput.next());

		finalScanner.useDelimiter("\\D");
		x = finalScanner.nextInt();			
		finalScanner.skip(" ");
		y = finalScanner.nextInt();
		finalScanner.close();
		finalCoordinate=  new Coordinate(x, y);
		ui.encircle(x, y);
		levelInput.skip("=");

		while(levelInput.hasNextLine()){
			Scanner wallScanner = new Scanner(levelInput.nextLine());
			wallScanner.useDelimiter("\\D");
			x = wallScanner.nextInt();
			wallScanner.skip(" ");
			y = wallScanner.nextInt();
			wall.addCoordinate(x,y);
			wallScanner.close();
		}
	}

	void findLongestPath(Coordinate currentCoordinate){
		int x = currentCoordinate.x;
		int y = currentCoordinate.y;
		ui.wait(1000/fps);
		currentPath.addCoordinate(x, y);
		printArray(currentPath,LabyrinthUserInterface.PATH);
		if (currentCoordinate.x  == finalCoordinate.x && currentCoordinate.y == finalCoordinate.y){ 
			if(currentPath.numberOfElements > longestPath.numberOfElements){
				moveCurrentToLongestPath();
			}
		} 
		Coordinate rightCoordinate =  new Coordinate(x+1,y);
		Coordinate downCoordinate =  new Coordinate(x,y-1);
		Coordinate leftCoordinate =  new Coordinate(x-1,y);
		Coordinate upCoordinate =  new Coordinate(x,y+1);
		if (!pathCollision(rightCoordinate)){
			findLongestPath(rightCoordinate);
		}
		if (!pathCollision(downCoordinate)){
			findLongestPath(downCoordinate);	    	
		}
		if (!pathCollision(leftCoordinate)){
			findLongestPath(leftCoordinate);    	
		}
		if (!pathCollision(upCoordinate)){
			findLongestPath(upCoordinate);	
		}
		goBack(x,y);
	}

	void goBack(int x,int y){
		currentPath.deleteCoordinate();
		ui.place(x, y, LabyrinthUserInterface.EMPTY);
		ui.showChanges();
	}

	boolean pathCollision(Coordinate coordinateToCheck){
		for (int j = 0; j < currentPath.numberOfElements; j++) {
			if(coordinateToCheck.x == currentPath.array[j].x &&coordinateToCheck.y == currentPath.array[j].y){
				return true;	
			}
		}
		for (int j = 0; j < wall.numberOfElements; j++) {
			if (coordinateToCheck.x == wall.array[j].x &&coordinateToCheck.y == wall.array[j].y){
				return true;				
			}
		}
		return false;
	}

	void moveCurrentToLongestPath(){
		for (int i = 0; i < currentPath.numberOfElements; i++){
			longestPath.array[i] = currentPath.array[i];
		}
		longestPath.numberOfElements = currentPath.numberOfElements;
	}

	void printArray(CoordinateArray current,int type){
		for (int i = 0; i<current.numberOfElements ; i++){
			ui.place(current.array[i].x, current.array[i].y, type);	
		}
		ui.showChanges();
	}

	public static void main(String[] args) {
		new LongestPath().start();
	}
}
