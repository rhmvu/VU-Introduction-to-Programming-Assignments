package Module3;
import java.io.PrintStream;

public class Pyramid {
	PrintStream out;
	char letter = 'a';
	int amountOfSpaces=39;
	static final int SCREEN_WIDHT = 27;

	Pyramid(){
	out = new PrintStream(System.out);
	}
	void spacePrinter (int amountOfSpaces){
		for(int loopCount = 0; loopCount < amountOfSpaces; loopCount++){
			out.printf(" ");
		}
	}
	void letterPrinter (int amountOfLetters){
		for(int loopCount = 0; loopCount <= amountOfLetters; loopCount++){
		out.printf("%c",letter);
		}
	letter+=1;	
	out.printf("\n");
	}

	void pyraPrinter(){
		for (int Height= 0; Height<= SCREEN_WIDHT;Height+=2){
		spacePrinter(amountOfSpaces);
		letterPrinter(Height);
		amountOfSpaces-=1;
		}
	}

	public static void main(String[] args) {
		new Pyramid().pyraPrinter();

	}

}
