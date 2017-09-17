package Pirate2;

import java.io.PrintStream;
import java.util.Scanner;
class routeFinder {
Scanner input = ui.UIAuxiliaryMethods.askUserForInput().getScanner();
PrintStream out;
	routeFinder(){
		out= new PrintStream(System.out);
	}

	
	void scanner(){
		input.useDelimiter("=");
		Row coordinate = new Row();
		Scanner coordinateScanner= new Scanner(input.next());
		String place= "Behind";
		inputParser(coordinateScanner, coordinate, place);
		while(input.hasNext()){
			input.skip("=");
			Scanner addBehindScanner= new Scanner(input.next());
			place = "Behind";
			inputParser(addBehindScanner, coordinate,place);
			input.skip("=");
			Scanner addFrontScanner= new Scanner(input.next());
			place = "Front";
			inputParser(addFrontScanner, coordinate,place);
		}
		outputPrinter(coordinate);
	}
	
	void inputParser(Scanner addScanner,Row coordinate, String place){
		addScanner.useDelimiter(" ");
		int x;
		double y;
		while(addScanner.hasNext()){
			addScanner.useDelimiter(",");
			x = addScanner.nextInt()+1;
			addScanner.useDelimiter("\\D");
			addScanner.skip(",");
			y =  (double) addScanner.nextInt()/10;
			if(addScanner.hasNext()){
				addScanner.skip(" ");
			}
			double newNumber= x+y;
		//	out.printf("%f", newNumber);
			if (place.equals("Front")){
				coordinate.addToRowFront(newNumber);
			}else{
			coordinate.addBehind(newNumber);
			}
		}
		if (place.equals("Front")){
			coordinate.mergeCoordinates();
		}
	}
		
	void outputPrinter(Row coordinates){
		
		
		for(int i= 0; i < coordinates.coordinates.length-coordinates.numberOfElementsLeft;i++){
			out.printf("%.1f\n", coordinates.coordinates[i]);
		}
		System.exit(0);
	}
	
	public static void main(String[] args) {
			new routeFinder().scanner();
	}
}