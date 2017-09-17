package Pirate;

class coordinateArray {
static final int MAX_NUMBER_OF_ELEMENTS = 1000;
Coordinate[] coordinateArray,
frontCoordinateArray;
int numberOfElementsLeft,
numberOfElementsFrontLeft;
	
	coordinateArray() {
		coordinateArray = new Coordinate[MAX_NUMBER_OF_ELEMENTS];
		numberOfElementsLeft = MAX_NUMBER_OF_ELEMENTS;
		frontCoordinateArray= new Coordinate[MAX_NUMBER_OF_ELEMENTS];
		numberOfElementsFrontLeft = MAX_NUMBER_OF_ELEMENTS;
	}
		
	void addBehind(Coordinate newCoordinate) {
		coordinateArray[coordinateArray.length-numberOfElementsLeft] = newCoordinate;;
		numberOfElementsLeft -= 1;
	}
	
	void addToRowFront(Coordinate newCoordinate) {
		frontCoordinateArray[frontCoordinateArray.length-numberOfElementsFrontLeft] = newCoordinate;
		numberOfElementsFrontLeft -= 1;
	}
	
	void concatinatecoordinateArrays(){
		Coordinate[] result = new Coordinate[frontCoordinateArray.length + coordinateArray.length];
		for (int i = 0; i < frontCoordinateArray.length-numberOfElementsFrontLeft; i++) {
			result[i] = frontCoordinateArray[i];
		}
		for (int i = 0; i < coordinateArray.length; i++) {
			result[frontCoordinateArray.length-numberOfElementsFrontLeft + i] = coordinateArray[i];
		}
		for(int i = 0; i < result.length- numberOfElementsLeft- numberOfElementsFrontLeft; i++){
			coordinateArray[i] = result[i];
		}
		for (int i = 0; i < frontCoordinateArray.length; i++){
			frontCoordinateArray[i] = null;
		}
		for (int i = 0; coordinateArray[i] !=null; i++){
			numberOfElementsLeft = MAX_NUMBER_OF_ELEMENTS-i-1;
		}	
		numberOfElementsFrontLeft = MAX_NUMBER_OF_ELEMENTS;
	}
}