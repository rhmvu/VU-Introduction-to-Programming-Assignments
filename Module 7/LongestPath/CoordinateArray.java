package LongestPath;

class CoordinateArray {
	static final int MAX_NUMBER_OF_ELEMENTS = 1500;
	Coordinate[] array;
	int numberOfElements;

	CoordinateArray(){
		array = new Coordinate[MAX_NUMBER_OF_ELEMENTS];
	}

	void addCoordinate(int x,int y){
		Coordinate newCoordinate = new Coordinate(x,y);
		array[numberOfElements] = newCoordinate;
		numberOfElements+=1;
	}

	void addCoordinate(Coordinate newCoordinate){

		array[numberOfElements] = newCoordinate;
		numberOfElements+=1;
	}

	void deleteCoordinate(){
		array[numberOfElements-1] = null;
		numberOfElements -=1;
	}
}