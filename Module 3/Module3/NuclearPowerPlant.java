package Module3;

import java.io.PrintStream;

public class NuclearPowerPlant {
	PrintStream out;
	
NuclearPowerPlant(){
out=new PrintStream(System.out);
}
void start(){
	for(int count= 0;count < 3;count++){
		Warning();
	}
}
void Warning(){
	out.printf("NUCLEAR CORE UNSTABLE!!!\nQuarantine is in effect.\nSurrounding hamlets will be evacuated.\nAnti-radiationsuits and iodine pills are mandatory.\n\n");
	}
	public static void main(String[] args) {
		new NuclearPowerPlant().start();

	}

}
