package practice;

public class SumBetweenNumber {

	public static void main(String[] args) {
//		int a = 3;
//		int b = 5;
		//12
		
//		int a = 3;
//		int b = 3;
		//3
		
		int a = 5;
		int b = 3;
		//12
		
		solution(a, b);
	}
	
	
	public static long solution(int a, int b) {
        long answer = 0;
        int tmp = 0;
        if(a>b) {tmp=a; a=b; b=tmp;};
        for(int i=a; i<=b; i++){
        	answer += i;
        }
        System.out.println(answer);
        return answer;
    }
}
