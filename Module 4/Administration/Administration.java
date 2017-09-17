package Administration;
import java.io.PrintStream;
import java.util.Scanner;
import ui.UIAuxiliaryMethods;

class Administration {
	static final double INT_CORRECTION= 0.5;
	static final int HIGHEST_GRADE = 10;
	static final int LOWEST_GRADE = 1;
	static final double ROUNDED_HALF_POINT = 0.5;
	PrintStream out;
	Scanner input = UIAuxiliaryMethods.askUserForInput().getScanner();
	
	Administration(){
		out = new PrintStream(System.out);
	}
	
	void start(){
		scanner();
	}
	
	void scanner(){
		while(input.hasNextLine()){
			Scanner firstLineScanner= new Scanner(input.nextLine());
			inputParserFirstline(firstLineScanner);
			input.useDelimiter(";");
			Scanner secondLineScanner= new Scanner(input.nextLine());
			inputParserSecondline(secondLineScanner);
			evaluate();
		}
	}
		
	void inputParserFirstline(Scanner nameScanner){
		nameScanner.useDelimiter("_");
		String studentName= nameScanner.next();
		out.printf("%s has an average of", studentName);
		gradeCorrector(calculateAverage(nameScanner));
	}
	
	double calculateAverage(Scanner firstLineScanner){
		double amountOfGrades = 0;
		double sumGrades = 0;
		firstLineScanner.useDelimiter("\\abc");
		Scanner gradeScanner = new Scanner(firstLineScanner.next());
		underScoreSkipper(gradeScanner);
		gradeScanner.useDelimiter(" ");
		
		while (gradeScanner.hasNext()){
			gradeScanner.useDelimiter(" ");
			int tempAvgGrade = gradeScanner.nextInt();
			readInRange(tempAvgGrade);
			sumGrades += tempAvgGrade;
			amountOfGrades ++;
		}
		double averageGrade = sumGrades/amountOfGrades;
		return averageGrade;
	}
	
	void readInRange(int grade){
		if(grade <= HIGHEST_GRADE && grade >= LOWEST_GRADE){
			return;
		}else{
			out.printf("inputgrade %d not in range", grade);
			System.exit(1);
		}
	}
	
	void underScoreSkipper(Scanner underscoreScanner){
		underscoreScanner.useDelimiter("\\d");
		underscoreScanner.next();	
	}
	
	void gradeCorrector(double averageGrade){
		int roundedGrade = (int) (averageGrade+INT_CORRECTION);
			if (averageGrade >= 5.5 && averageGrade < 6){
				out.printf(" 6-");
				return;
			}
			if((roundedGrade - averageGrade)  < 0.25 && (roundedGrade+1)-averageGrade <0.75){
				double Grade = roundedGrade+ROUNDED_HALF_POINT;
				out.printf(" %.1f", Grade);
			}else{
				out.printf(" %d", roundedGrade);
			}		
	}
	
	void inputParserSecondline(Scanner secondLineScanner){
		drawGraph(secondLineScanner);
		out.printf("\n");
		secondLineScanner.skip(";");
		
		if(secondLineScanner.hasNext()){
			Scanner nameScanner;
			while(secondLineScanner.hasNext()){
				secondLineScanner.useDelimiter(",");
				nameScanner = new Scanner(secondLineScanner.next());
				nameScanner.useDelimiter(",");
				String studentname = nameScanner.next();
				out.printf("\t%s\n", studentname);
			}
		}else{
			out.printf("\tNo matches found\n");
		}
	}

	void drawGraph(Scanner secondLineScanner){
		secondLineScanner.useDelimiter(";");
		Scanner graphScanner = new Scanner(secondLineScanner.next());
		graphScanner.useDelimiter("\\D");
		out.printf("\n\t");	
		
		for (int i= 0; i<=9;i++){
			int amount = graphScanner.nextInt();
			if (amount<20){
				if (amount == 0){
					out.printf("_");
				}else{
					out.printf("-");
				}
			}else{
				out.printf("^");
			}
		}
		graphScanner.close();
	}
	
	void evaluate(){
		if(input.hasNextLine()){
			scanner();
		} else{
			out.printf("The list has finished");
			System.exit(0);
		}
	}
	
	public static void main(String[] args) {
		new Administration().start();
	}
}