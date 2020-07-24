package practice;

import java.util.*;

public class DivisionNumber {

	public static void main(String[] args) {
//		int[] arr = {5,9,7,10};
//		int divisor = 5;
		//5,10
		
//		int[] arr = {2,36,1,3};
//		int divisor = 1;
		//1,2,3,36
		
		int[] arr = {2,3,6};
		int divisor = 10;
		//-1
		
		solution(arr, divisor);
	}
	/*
	 * array의 각 element 중 divisor로 나누어 떨어지는 값을 오름차순으로 정렬한 배열을 반환하는 함수, solution을 작성해주세요.
		divisor로 나누어 떨어지는 element가 하나도 없다면 배열에 -1을 담아 반환하세요.
	 * 
	 * */
	public static int[] solution(int[] arr, int divisor) {
		List<Integer> list = new ArrayList<>();
		for(int i : arr) {
			if(i%divisor == 0){
				list.add(i);
			}
		}
		Collections.sort(list);
		int[] answer = new int[list.size()];
		if(list.size() == 0){
			answer = new int[1];
			answer[0] = -1;
		}
		for(int i=0; i<list.size(); i++){
			answer[i] = list.get(i);
		}
        return answer;
    }

}
