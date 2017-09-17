package Snake;
import java.util.Scanner;
import ui.UIAuxiliaryMethods;
import ui.Event;
import ui.SnakeUserInterface;
import ui.UserInterfaceFactory;

public class Snake {
int MAXIMUM_WIDTH = 32;
int MAXIMUM_HEIGHT = 24;
SnakeUserInterface ui;
String previousDirection;
int xCorrection;
int yCorrection;
int printImage;
boolean moveLock;
boolean apple;
boolean eventLock;
	Snake(){
		ui = UserInterfaceFactory.getSnakeUI(MAXIMUM_WIDTH, MAXIMUM_HEIGHT);
		xCorrection = 0;
		yCorrection = 0;
		printImage = ui.SNAKE;
		apple = false;
		moveLock = false;
		eventLock = true;
		previousDirection = "R";
	}
	
	void start(){
		String fpsQuestion = "How many Fps would you like to play with?\n(The higher the fps, the harder the game will be)";
		Scanner levelScanner = new Scanner(UIAuxiliaryMethods.askUserForString(fpsQuestion));
		int fPS = (int) levelScanner.nextDouble();
		ui.setFramesPerSecond(fPS);
		boolean manualInput = UIAuxiliaryMethods.askUserForBoolean("Would you like to input a level manually?");
		CoordinateArray snakeArray = new CoordinateArray();
		if (manualInput){
			parseLevelInput(snakeArray);
		}else{
			processArrow("R");
			ui.place(0, 0, printImage);
			snakeArray.addToHeadSnake(0,0);
			ui.place(0, 1, printImage);
			snakeArray.addToHeadSnake(0,1);
		}
		showStartMessage();
		ui.showChanges();
		while (eventLock == false){
			Event event = ui.getEvent();
			processEvent(event,snakeArray);
			ui.showChanges();
		}
	}
		
	void parseLevelInput(CoordinateArray snakeArray){
		Scanner levelInput = UIAuxiliaryMethods.askUserForInput().getScanner();
		levelInput.useDelimiter("=");
		Scanner snakeScanner = new Scanner(levelInput.next());
		while(snakeScanner.hasNext()){
			snakeScanner.useDelimiter("\\D");
			int x = snakeScanner.nextInt();			
			snakeScanner.skip(" ");
			int y = snakeScanner.nextInt();
			snakeArray.addToHeadSnake(x, y);
		}
		snakeScanner.close();
		levelInput.skip("=");
		processArrow(levelInput.next()); 
		levelInput.skip("=");
		while(levelInput.hasNextLine()){
			Scanner WallScanner = new Scanner(levelInput.nextLine());
			WallScanner.useDelimiter("\\D");
			int x = WallScanner.nextInt();
			WallScanner.skip(" ");
			int y = WallScanner.nextInt();
			String wall = x +" "+ y;
			processClick(wall,snakeArray);
		}
	}
		
	void showStartMessage(){
		String message = "Press 'g' to change the snake's looks to a wall\n";
		message = message + "Click to deploy a wall\n";
		message = message + "Press the spacebar to remove all walls\n";
		message = message + "Press enter to start";
		UIAuxiliaryMethods.showMessage(message);
		eventLock = false;
	}
	
	void processEvent(Event event,CoordinateArray snakeArray){
			
		if (event.name.equals("click")) {
			processClick(event.data, snakeArray);
		} 
		if (event.name.equals("other_key")) {
			processkey(event.data,snakeArray);
		}
		if (event.name.equals("arrow")) {
			processArrow(event.data);
		}
		if (event.name.equals("letter")) {
			processLetter(event.data);
		}
		if (event.name.equals("alarm")) {
			checkApple(snakeArray);
			moveSnake(snakeArray);
			checkCoordinates(snakeArray);
			moveLock = false;		
		}
	}
		
	void processArrow(String arrowData){	
		if(arrowData.equals("L")&& !previousDirection.equals("R")&& !moveLock){
			xCorrection= -1;
			yCorrection = 0;
			moveLock = true;
			previousDirection = arrowData;
		}
		if(arrowData.equals("R")&& !previousDirection.equals("L")&& !moveLock){
			xCorrection= +1;
			yCorrection = 0;
			moveLock = true;
			previousDirection = arrowData;
		}
		if(arrowData.equals("U")&& !previousDirection.equals("D")&& !moveLock){
			xCorrection= 0;
			yCorrection = -1;
			moveLock = true;
			previousDirection = arrowData;
		}
		if(arrowData.equals("D")&& !previousDirection.equals("U") && !moveLock){
			xCorrection= 0;
			yCorrection = +1;
			moveLock = true;
			previousDirection = arrowData;
		}
	}
	
	void moveSnake(CoordinateArray snakeArray){
		int x = snakeArray.snake[0].x +xCorrection;
		int y = snakeArray.snake[0].y +yCorrection;
		int correctedX = correctCoordinate(x,MAXIMUM_WIDTH);
		int correctedY = correctCoordinate(y,MAXIMUM_HEIGHT);
		snakeArray.addToHeadSnake(correctedX,correctedY);
		uiPrintSnake(snakeArray);
		int xEndSnake = snakeArray.snake[snakeArray.snakeLength].x;
		int yEndSnake = snakeArray.snake[snakeArray.snakeLength].y;
		ui.place(xEndSnake, yEndSnake, ui.EMPTY);
	}
	
	int correctCoordinate(int number, int MAX){
		if (number >= MAX){
			return 0;
		}
		if (number < 0){
			return MAX-1;
		}
		return number;
	}
	
	void uiPrintSnake(CoordinateArray snakeArray){
		for(int i= 0; i < snakeArray.snakeLength; i++){
			ui.place(snakeArray.snake[i].x, snakeArray.snake[i].y, printImage);
		}
	}
	
	void checkApple(CoordinateArray snakeArray){
		if(apple == false){
			int x;
			int y;
			do{
			x = UIAuxiliaryMethods.getRandom(0, MAXIMUM_WIDTH);
			y = UIAuxiliaryMethods.getRandom(0, MAXIMUM_HEIGHT);
			snakeArray.addApple(x,y);
			apple = true;
			}while(snakeArray.appleCollision().equals("AppleHitsSnake") || snakeArray.appleCollision().equals("AppleHitsWall") );
			ui.place(x, y, ui.FOOD);
		}
		ui.clearStatusBar();
		ui.printf("Snake length is now: %d", snakeArray.snakeLength);
	}
		
	void checkCoordinates(CoordinateArray snakeArray){
		if (snakeArray.snakeCollision().equals("Wall")){
			gameOver("A WALL",snakeArray);
		}
		if (snakeArray.snakeCollision().equals("Itself")){
			gameOver("THE SNAKE",snakeArray);
		}
		if (snakeArray.snakeCollision().equals("Apple")){
			eatApple(snakeArray);
		}
	}
	
	void eatApple(CoordinateArray snakeArray){
		snakeArray.eatApple();
		snakeArray.snakeLength +=1;
		uiPrintSnake(snakeArray);
		apple = false;
	}
		 
	void processClick(String clickData, CoordinateArray snakeArray){
		Scanner coordinateScanner = new Scanner(clickData);
		coordinateScanner.useDelimiter(" ");
		int x = coordinateScanner.nextInt();
		coordinateScanner.skip(" ");
		int y= coordinateScanner.nextInt();
		coordinateScanner.close();
		Coordinate newWall = new Coordinate(x,y);
		snakeArray.addWall(newWall);
		ui.place(x, y, SnakeUserInterface.WALL);
		if(apple&&snakeArray.appleCollision().equals("AppleHitsWall")){
			apple = false;
		}
	}
		
	void processkey(String keyData, CoordinateArray snakeArray){
		if (keyData.equals("Space")){
			for(int i = 0; i < snakeArray.amountOfWalls; i++) {
				ui.place(snakeArray.wall[i].x, snakeArray.wall[i].y, ui.EMPTY);
				snakeArray.wall[i] = null;
			}
			snakeArray.removeWalls();
		}
		ui.printf("All walls are removed");
	}
	
	void processLetter(String letterData){
		if(letterData.equals("g")){
			if (printImage == ui.SNAKE){
				printImage = ui.WALL;
			}
			else{
				printImage = ui.SNAKE;
			}
		}
	}
	
	 void gameOver(String Object,CoordinateArray snakeArray){
		String gameOver = "YOU HIT "+Object+", GAME OVER!!\n YOUR SNAKELENGTH WAS:"+snakeArray.snakeLength;
		UIAuxiliaryMethods.showMessage(gameOver);
		System.exit(0);
	}
	
	public static void main(String[] args) {
		new Snake().start();
	}
}