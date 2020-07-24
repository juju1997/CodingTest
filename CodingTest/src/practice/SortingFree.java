package practice;

import java.util.*;

public class SortingFree {

	public static void main(String[] args) {
//		String[] strings = {"sun", "bed", "car"};
//		int n = 1;
		//car, bed, sun
		
		String[] strings = {"abce", "abcd", "cdx"};
		int n = 2;
		//abcd, abce, cdx
		
		solution(strings, n);
	}
	
	/*
	 * 문자열로 구성된 리스트 strings와, 정수 n이 주어졌을 때,
	 *  각 문자열의 인덱스 n번째 글자를 기준으로 오름차순 정렬하려 합니다.
	 *   예를 들어 strings가 [sun, bed, car]이고 n이 1이면 각 단어의 인덱스 1의 문자 u, e, a로 strings를 정렬합니다.
	 * */
	public static String[] solution(String[] strings, int n) {
		Map<Integer, String> map = new HashMap<>();
		for(int i=0; i<strings.length; i++) {
			String[] c = strings[i].split("");
			map.put(i, c[n]);
		}
		List<Map.Entry<Integer, String>> entries = new LinkedList<>(map.entrySet());
		Collections.sort(entries, (o1, o2) -> o1.getValue().compareTo(o2.getValue()));
		
		String[] answer = new String[entries.size()];
		
		for(int i=0; i<entries.size(); i++){
			answer[i] = strings[entries.get(i).getKey()];
		}
		
        return answer;
    }
}
