package Pirate2;
//import java.io.PrintStream;
class Row {
static final int MAX_NUMBER_OF_ELEMENTS = 250;
double[] coordinates;
//PrintStream out;
double[] frontCoordinates;
int numberOfElementsLeft;
int numberOfElementsFrontLeft;
	Row() {
		coordinates = new double[MAX_NUMBER_OF_ELEMENTS];
		numberOfElementsLeft = 250;
		frontCoordinates= new double[MAX_NUMBER_OF_ELEMENTS];
		numberOfElementsFrontLeft = 250;
		//out = new PrintStream(System.out);
	}
	/*
	void addRowBehind(double[] coordinatesToAdd){
		int lenghtOfArray= coordinates.length;
		for (int i = coordinates.length; i < lenghtOfArray + coordinatesToAdd.length; i++){
		coordinates[i] = coordinatesToAdd [i];
		numberOfElements += 1;
		}
	}*/
	void addBehind(double coordinate) {
		coordinates[coordinates.length-numberOfElementsLeft] = coordinate;
		numberOfElementsLeft -= 1;
	}
	void addToRowFront(double frontCoordinate) {
		frontCoordinates[MAX_NUMBER_OF_ELEMENTS-numberOfElementsFrontLeft] = frontCoordinate;
		numberOfElementsFrontLeft -= 1;
	}
		
	//void PrintRow(double[] frontCoordinates2){
	//for(int i= 0; i<20; i++){
		//out.printf("%f\t", frontCoordinates2[i]);
	//}
	//out.printf("\n");
	//}
	
	
	void mergeCoordinates(){
		double[] result = new double[frontCoordinates.length + coordinates.length];
		for (int i = 0; i < frontCoordinates.length-numberOfElementsFrontLeft; i++) {
		result[i] = frontCoordinates[i];
		}
		for (int i = 0; i < coordinates.length; i++) {
		result[frontCoordinates.length-numberOfElementsFrontLeft + i] = coordinates[i];
		}
		for(int i = 0; i < result.length- numberOfElementsLeft- numberOfElementsFrontLeft; i++){
		coordinates[i] = result[i];
		}
		for (int i = 0; i < frontCoordinates.length; i++){
			frontCoordinates[i] = 0;
		}
		for (int i = 0; coordinates[i] != 0.000000; i++){
			numberOfElementsLeft = MAX_NUMBER_OF_ELEMENTS-i-1;
		}	
		numberOfElementsFrontLeft =250;
	}
}
