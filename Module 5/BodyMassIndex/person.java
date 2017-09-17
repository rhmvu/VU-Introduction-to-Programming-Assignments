package BodyMassIndex;

public class person {
	public double length;
	public int weight;
	public String gender;
	public String lastName;
	public String health;

	public person(String a,double b,int c,String d){
		lastName = a;
		length = b;
		weight = c;
		gender = d;
	}
	

void storeVars(){
	
}
	public double BMI() {
	        double BMInumber = weight / (Math.pow(length, 2));
	        return BMInumber;     		
	 }
	String health(){
		if (this.BMI() > 18.5 && this.BMI() < 25){
			return "Healthy";
		}else{
			return "Unhealty";
		}
	}
	
	String aanhef(){
		
		if(gender.equals("M")){
			String result = "Mr.";
			return result;
		}else{
			String result = "Mrs.";
			return result;
		}
		
	}
}
