package Pirate;

import java.io.PrintStream;
import java.util.Scanner;
public class Pirate {
static final int TECTONIC_CORRECTION = 1;
Scanner input = ui.UIAuxiliaryMethods.askUserForInput().getScanner();
PrintStream out;
	
	Pirate(){
		out= new PrintStream(System.out);
	}
	
	void scanner(){
		input.useDelimiter("=");
		Scanner coordinateScanner= new Scanner(input.next());
		String place= "Behind";
		coordinateArray coordinates = new coordinateArray();
		inputParser(coordinateScanner, coordinates, place);
		while(input.hasNext()){
			input.skip("=");
			Scanner addBehindScanner= new Scanner(input.next());
			place = "Behind";
			inputParser(addBehindScanner,coordinates, place);
			input.skip("=");
			Scanner addFrontScanner= new Scanner(input.next());
			place = "Front";
			inputParser(addFrontScanner,coordinates, place);
		}
		outputPrinter(coordinates);
	}
	
	void inputParser(Scanner coordinateScanner, coordinateArray coordinates, String place){
		while(coordinateScanner.hasNext()){
			Coordinate newCoordinate = getNewCoordinate(coordinateScanner);
			if (place.equals("Front")){
				coordinates.addToRowFront(newCoordinate);
			}else{
				coordinates.addBehind(newCoordinate);
			}
		}
		if (place.equals("Front")){
			coordinates.concatinatecoordinateArrays();
		}
	}
	
	Coordinate getNewCoordinate(Scanner coordinateScanner){
		Coordinate newCoordinate = new Coordinate();
		coordinateScanner.useDelimiter(",");
		newCoordinate.x = coordinateScanner.nextInt()+TECTONIC_CORRECTION;
		coordinateScanner.useDelimiter("\\D");
		coordinateScanner.skip(",");
		newCoordinate.y = coordinateScanner.nextInt();
		if(coordinateScanner.hasNext()){
		coordinateScanner.skip(" ");
		}
		return newCoordinate;
	}
	
	void outputPrinter(coordinateArray coordinates){
		for(int i= 0; i < coordinates.coordinateArray.length-coordinates.numberOfElementsLeft;i++){
			out.printf("%d,%d\n",coordinates.coordinateArray[i].x,coordinates.coordinateArray[i].y);
		}
		System.exit(0);
	}
	
	public static void main(String[] args) {
		new Pirate().scanner();
	}
}