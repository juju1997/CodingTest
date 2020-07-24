package practice;

public class NnumberToX {

	public static void main(String[] args) {
//		int x=2; int n=5;	//2,4,6,8,10
//		int x=4; int n=3;	//4,8,12
		int x=-4; int n=2;	//-4,-8
		solution(x, n);
	}
	/*
	 * 함수 solution은 정수 x와 자연수 n을 입력 받아, x부터 시작해 x씩 증가하는 
	 * 숫자를 n개 지니는 리스트를 리턴해야 합니다. 
	 * 다음 제한 조건을 보고, 조건을 만족하는 함수, solution을 완성해주세요.
	 * */
	public static long[] solution(int x, int n) {
		long[] answer = new long[n];
		int index = 0;
		long sum = 0;
		while(index < n){
			sum+=x;
			answer[index] = sum;
			if(index == n-1) break;
			index++;
		}
        return answer;
    }

}
