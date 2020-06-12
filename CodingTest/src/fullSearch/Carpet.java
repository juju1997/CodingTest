package fullSearch;


public class Carpet {

	public static void main(String[] args) {
		int brown = 10;
		int yellow = 2;
		//4,3
		
//		int brown = 8;
//		int yellow = 1;
		//3,3
		
//		int brown = 24;
//		int yellow = 24;
		//8,6
		
		solution(brown, yellow);
	}
	
	public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int sum = brown+yellow;
        int h = (int)Math.pow(sum, 0.5);
//        int h = (int)Math.sqrt(sum);
        for(int i=3; i<=h; i++) {
        	if(sum%i==0) {
        		int t = sum/i;
        		if((t-2)*(i-2)==yellow) {
        			answer[0] = t;
        			answer[1] = i;
        		}
        	}
        }
        return answer;
    }

}
