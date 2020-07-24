package practice;

public class EvenOdd {

	public static void main(String[] args) {
		int num = 0;
		solution(num);
	}
	
	public static String solution(int num) {
	       String answer = "";
	       if(num%2==0){
	    	   answer = "Even";
	       }else{
	    	   answer = "Odd";
	       }
	       return answer;
	}
}
