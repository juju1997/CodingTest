package stack_queue;

import java.util.*;

public class Printer {

	public static void main(String[] args) {
		int[] priorities = {2,1,3,2};
		int location = 2;
		
//		int[] priorities = {1,1,9,1,1,1};
//		int location = 5;
		System.out.println(solution(priorities, location));

	}

	public static int solution(int[] priorities, int location) {
        int answer = 0;
        
        Queue<Integer> q = new LinkedList<>();
        for(int p : priorities) {
        	q.offer(p);
        }
        
        System.out.println(q);
        return answer;
    }
}
