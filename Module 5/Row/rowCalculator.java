package Row;
import java.io.PrintStream;
import java.util.Scanner;

public class rowCalculator {
	Scanner input = ui.UIAuxiliaryMethods.askUserForInput().getScanner();
	int i=1; 
	int place = 0;
	PrintStream out;
	int Row1largest;
	int Row2largest;
	rowCalculator(){
		out = new PrintStream(System.out);
	}
	void scanner(){
		while(input.hasNextLine()){
			Scanner rowScanner= new Scanner(input.nextLine());
			Row Row1 = new Row();
			inputParser(rowScanner,Row1);
			place = 0;
			rowScanner= new Scanner(input.nextLine());
			Row Row2 = new Row();
			inputParser(rowScanner,Row2);
		}
	}
	void inputParser(Scanner rowScanner,Row current){
		input.useDelimiter(";");
		
		while (rowScanner.hasNextInt()){
			int number = rowScanner.nextInt();
			current.store(number, place);
			place +=1;
			
		}
		
		reversePrint(current);
		evaluate(current);
	}
	void reversePrint(Row current){
		for (int iteration = place-1; iteration>1;iteration--){
			out.printf("%d ", current.numbers[iteration]);
		}
		out.printf("\n");
	}
	
	void evaluate(Row current){
		
		if(i == 1){
			Row1largest = current.largestNumber();
			i+=1;
			return;
		}else{
			Row2largest = current.largestNumber();
		}
		out.printf("\nLargest number of row 1:%d",Row1largest);
		out.printf("\nLargest number of row 2:%d",Row2largest);
		if(Row1largest > Row2largest){
			out.printf("\nRow 1 has the largest number");
		}else{
			out.printf("\nRow 2 has the largest number");
		}
		System.exit(0);
	}
	
	public static void main(String[] args) {
		new rowCalculator().scanner();

	}

}
