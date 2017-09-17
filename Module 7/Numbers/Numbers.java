package Numbers;
import java.io.PrintStream;
public class Numbers {
PrintStream out;
int i = 1;
	Numbers(){
		out = new PrintStream(System.out);
	}
	
	void PrintNumber(){
		if (i<= 10){
			out.printf("%d ", i);
		}else{
			if (i<=20){
				out.printf("%d ", 21-i);
			}else{
				System.exit(0);
			}
		}
		i+=1;
		PrintNumber();
	}
	public static void main(String[] args) {
		new Numbers().PrintNumber();

	}

}
