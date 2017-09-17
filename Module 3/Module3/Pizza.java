package Module3;
import java.io.PrintStream;
class Pizza {
	PrintStream out;
Pizza(){
	out=new PrintStream(System.out);	
}
void start(){
	int resultMario= amountOfPossibilities(10,3);
	int resultLuigi= amountOfPossibilities(9,4);
	if(resultMario > resultLuigi){
		out.printf("Mario has %d possibilities", resultMario);
		out.printf("\nLuigi has %d possibilities", resultLuigi);
		out.printf("\nMario wins the bet");
	}else{
		out.printf("Mario has %d possibilities", resultMario);
		out.printf("\nLuigi has %d possibilities", resultLuigi);
		out.printf("\nLuigi wins the bet");
	}
}

int amountOfPossibilities(int maxAvaliable,int maxChosen){
	int result= factorialOfN(maxAvaliable)/((factorialOfN(maxChosen)*(factorialOfN(maxAvaliable-maxChosen))));
	return result;	
}

int factorialOfN(int n){
	int result=1;
	int N=n;
	for (int loopcount=0;loopcount<N;loopcount++){
		result*=n;
		n-=1;
		}
	return result;
}
	public static void main(String[] args) {
		new Pizza().start();

	}

}
