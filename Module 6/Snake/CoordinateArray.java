package Snake;

class CoordinateArray {
static final int MAX_NUMBER_OF_ELEMENTS = 800;
int amountOfWalls;
Coordinate[] snake;
Coordinate headSnake;
Coordinate apple;
Coordinate[] wall;
int snakeLength;
	CoordinateArray(){
		snake = new Coordinate[MAX_NUMBER_OF_ELEMENTS];
		apple= null;
		wall = new Coordinate[MAX_NUMBER_OF_ELEMENTS];
		headSnake = null;
		snakeLength = 2;	
		amountOfWalls = 0;
	}
	
	void addWall(Coordinate newWall){
		wall[amountOfWalls] = newWall;
		amountOfWalls+=1;
	}
	
	void removeWalls(){
		for(int i= 0; i < amountOfWalls; i++){
			wall[i] = null;
			}
		amountOfWalls = 0;
	}
	
	void addApple(int x, int y){
		Coordinate newApple = new Coordinate(x,y);
		apple= newApple;
	}
	
	void eatApple(){
		apple = null;
	}
	
	void addToHeadSnake(Coordinate newCoordinate) {
		headSnake = newCoordinate;
		concatinateHeadBody();
	}
	
	void addToHeadSnake(int x, int y) {
		Coordinate newCoordinate = new Coordinate(x,y);
		headSnake = newCoordinate;
		concatinateHeadBody();
	}
	
	void concatinateHeadBody(){
		Coordinate[] result = new Coordinate[1 + snake.length];
		result[0] = headSnake;	
		for (int i = 0; i < snake.length; i++) {
			result[i+1] = snake[i];
		}
		for(int i = 0; i <= snakeLength; i++){
			snake[i] = result[i];
		}
		headSnake = null;	
	}
	
	public String appleCollision(){
		for (int i = 0; i < snakeLength; i++) {
			for (int j = 0; j < amountOfWalls; j++) {
				if (apple.x == wall[j].x && apple.y == wall[j].y){
					return "AppleHitsWall";
				}
				if(snake[i].x == apple.x && snake[i].y == apple.y){
					return "AppleHitsSnake";
				}
			}
		}
		return "Nothing";
	}
	
	public String snakeCollision(){
		for (int j = 1; j < snakeLength; j++) {
			if(snake[0].x == snake[j].x &&snake[0].y == snake[j].y){
			return "Itself";	
			}
		}
		for (int i = 0; i < snakeLength; i++) {
			for (int j = 0; j < amountOfWalls; j++) {
				if (snake[i].x == wall[j].x&&snake[i].y == wall[j].y){
					return "Wall";
				}
			}
		}
		if(snake[0].x == apple.x && snake[0].y == apple.y){
			return "Apple";
		}
		return "nothing";
	}
}