package BodyMassIndex;
import java.io.PrintStream;
import java.util.Scanner;
public class BodyMassIndex {
	Scanner in = ui.UIAuxiliaryMethods.askUserForInput().getScanner();
	PrintStream out;
BodyMassIndex(){
	out= new PrintStream(System.out);
}
	void start(){
		scanner();
	}
	
	void scanner(){
		while(in.hasNextLine()){
			Scanner firstLineScanner= new Scanner(in.nextLine());
			inputParser(firstLineScanner);
			in.useDelimiter(";");
			Scanner secondLineScanner= new Scanner(in.nextLine());
			inputParser(secondLineScanner);
			System.exit(0);
		}
	}
	void inputParser(Scanner input){
		input.useDelimiter("\\s");
		input.next();
		input.skip("\\s");
		String lastName = input.next(); 
		String gender = input.next();
		input.skip("\\s");
		double length = input.nextDouble();
		input.skip("\\s");
		int weight = input.nextInt();
		person current = new person(lastName,length, weight,gender);
		outputPrinter(current);
	}
		
	void outputPrinter(person current){
		out.printf("%s ", current.aanhef());
		out.printf("%s's BMI is ", current.lastName);
		out.printf("%.1f and is %s\n", current.BMI(), current.health());
	}
	public static void main(String[] args) {
		new BodyMassIndex().start();

	}

}
