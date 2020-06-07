package fullSearch;

import java.util.*;

public class MockTest {

	public static void main(String[] args) {
//		int[] answers = {1,2,3,4,5};
//		1
//		int[] answers = {1,3,2,4,2};
		//1,2,3
//		int[] answers = {1,2,3,4,5,1,2,3,4,5,1,2,3,4,5};
		//1
//		int[] answers = {1, 3, 3, 4, 5};
		//1
//		int[] answers = {0,0,0,0,0,0};
		//1,2,3
		int[] answers = {3,3,1,1,5,1};
		
		
		solution(answers);
	}
	
	/*
	 * 수포자는 수학을 포기한 사람의 준말입니다. 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다. 
	 * 수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.
	1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
	2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
	3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
	1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 
	가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.
	제한 조건
	시험은 최대 10,000 문제로 구성되어있습니다.
	문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
	가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.
	 * */
	public static int[] solution(int[] answers) {
        
        int[] test11 = {1, 2, 3, 4, 5};
        int[] test22 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] test33 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        Queue<Integer> test1 = new LinkedList<>();
        Queue<Integer> test2 = new LinkedList<>();
        Queue<Integer> test3 = new LinkedList<>();
        for(int go : test11) test1.offer(go); 
        for(int go : test22) test2.offer(go);
        for(int go : test33) test3.offer(go);
        
        HashMap<Integer, Integer> hash = new HashMap<>();
        hash.put(1, 0);
        hash.put(2, 0);
        hash.put(3, 0);
        for(int i=0; i<answers.length; i++) {
        	int move1 = test1.poll();
        	int move2 = test2.poll();
        	int move3 = test3.poll();
        	if(answers[i] == move1) {
        		hash.put(1, hash.getOrDefault(1, 0)+1);
        	}
        	if(answers[i] == move2) {
        		hash.put(2, hash.getOrDefault(2, 0)+1);
        	}
        	if(answers[i] == move3) {
        		hash.put(3, hash.getOrDefault(3, 0)+1);
        	}
        	test1.offer(move1);
        	test2.offer(move2);
        	test3.offer(move3);
        }
        List<Integer> list = new ArrayList<>(hash.keySet());
        Collections.sort(list, (o1, o2) -> (hash.get(o2).compareTo(hash.get(o1))));
        int master = hash.get(list.get(0));
        for(int key : list) {
        	if(hash.get(key)!= master) {
        		hash.remove(key);
        	}
        }
        
        
        int[] answer = new int[hash.size()];
        int index = 0;
        for(int ans : hash.keySet()) {
        	answer[index] = ans;
        	index ++;
        }
        
        for(int a : answer) {
        	System.out.println(a);
        }
        return answer;
    }
}
