package Row;
import java.io.PrintStream;

public class Row {
	int[] numbers;
//int i;
PrintStream out;	
	Row(){
		out = new PrintStream(System.out);
		numbers = new int [20];
	}

	public void store(int newNumber, int place){
		//for(int i = 0; i >= 0; i++){
		numbers[0+place] = newNumber;
		//out.printf("%d, ", numbers[0+place]);
	}
	int largestNumber(){
		int largest= numbers[0];
		for (int i = 19; i>=0 ;i--){
			if (numbers[i] > largest){
				largest= numbers[i];
			}
		}
		return largest;
	}
	void rowCleaner(){
		for (int i = 0; i<20; i++){
			numbers[i]= 0;
		}
	}
}
