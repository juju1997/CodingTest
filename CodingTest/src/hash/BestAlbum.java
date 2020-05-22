package hash;

import java.util.*;


public class BestAlbum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String[] genres = {"classic","pop", "classic", "classic", "pop"};
		String[] genres = {"a", "a","a", "b", "b", "c"};
//		String[] genres = {"classic","pop", "classic", "classic", "pop", "hip"};
		int[] plays = {100, 200, 250, 300, 400, 600};
//		int[] plays = {500, 600, 150, 800, 2500};
//		int[] plays = {500, 600, 150, 800, 2500, 1300};
		//기대값 : 4,1,3,0
		
		
//		String[] genres = {"classic", "pop", "classic", "classic", "pop", "zazz", "zazz"};
//		int[] plays = {500, 600, 150, 800, 2500, 2000, 6000};
//				[6, 5, 4, 1, 3, 0]
//		String[] genres = {"classic", "pop", "classic", "classic", "pop", "zazz", "zazz"};
//		int[] plays = {500, 600, 150, 800, 2500, 2100, 1000};
//				[4, 1, 5, 6, 3, 0]
//		String[] genres = {"classic", "pop", "classic", "pop", "classic", "classic", "classic"};
//		int[] plays = {400, 600, 150, 2500, 500, 500, 500};
//				[3, 1, 4, 5]
		int[] a = solution(genres,plays);
		for(int b : a) {
			System.out.println(b);
		}
	}
	
	
	/*
	 * 
	 * 스트리밍 사이트에서 장르 별로 가장 많이 재생된 노래를 두 개씩 모아 베스트 앨범을 출시하려 합니다. 노래는 고유 번호로 구분하며,  
	 * 노래를 수록하는 기준은 다음과 같습니다.
		속한 노래가 많이 재생된 장르를 먼저 수록합니다.
		장르 내에서 많이 재생된 노래를 먼저 수록합니다.
		장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
		노래의 장르를 나타내는 문자열 배열 genres와 노래별 재생 횟수를 나타내는 정수 배열 plays가 주어질 때, 
		베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 return 하도록 solution 함수를 완성하세요.
		
		제한사항
		genres[i]는 고유번호가 i인 노래의 장르입니다.
		plays[i]는 고유번호가 i인 노래가 재생된 횟수입니다.
		genres와 plays의 길이는 같으며, 이는 1 이상 10,000 이하입니다.
		장르 종류는 100개 미만입니다.
		장르에 속한 곡이 하나라면, 하나의 곡만 선택합니다.
		모든 장르는 재생된 횟수가 다릅니다. map쓰라는거같은
	 * 
	*/
	
	
	public static int[] solution(String[] genres, int[] plays) {
		
		HashMap<String, Integer> hash1 = new HashMap<>();
		for(int i=0; i<genres.length; i++) {
			hash1.put(genres[i], hash1.getOrDefault(genres[i], 0) + plays[i]);
		}
		System.out.println(hash1 + " hash1");
		
		List<Integer> sortP = new ArrayList<>();
		for(int gen : hash1.values()) {
			sortP.add(gen);
		}
		Collections.sort(sortP); Collections.reverse(sortP);
		
		List<String> sortG = new ArrayList<>();
		for(int s : sortP) {
			sortG.add(getKey(hash1, s));
			hash1.remove(getKey(hash1, s));
		}
		System.out.println(hash1 + " after hash1");
 		System.out.println(sortG + " sortG");
		
		HashMap<String, Integer> hash2 = new HashMap<>();
		for(int i=0; i<genres.length; i++) {
			hash2.put(genres[i]+i, plays[i]);
		}
		System.out.println(hash2 + " hash2");
		
		List<String> keys = new ArrayList<>(hash2.keySet());
		Collections.sort(keys);
		System.out.println(keys +" keys");
		
		HashMap<String, Integer> hash3 = new LinkedHashMap<>();
		for(String keysS : keys) {
			hash3.put(keysS, hash2.get(keysS));
		}
		System.out.println(hash3 + " hash3");
		
		List<Integer> list = new ArrayList<>();
		for(int pl : plays) {
			list.add(pl);
		}
		Collections.sort(list); Collections.reverse(list);
		System.out.println(list + " list");
		
		int cnt = 0;
		String temp = sortG.get(0);
		
		List<Integer> solve = new ArrayList<>();
		
		for(String sg : sortG) {
			if(!temp.equals(sg)) cnt=0;
			for(int l : list) {
				if(cnt==2) {
					cnt = 0;
					break;
				}
				for(String ha : hash3.keySet()) {
					if(cnt==2) break;
					if(ha.indexOf(sg) >= 0 && hash3.get(ha) == l) {
						cnt++;
						solve.add(Integer.parseInt((ha.replace(sg, ""))));
						temp = sg;
					}
				}
				
			}
		}
		
		System.out.println(solve);
		int[] answer = new int[solve.size()];
		for(int i=0; i<answer.length; i++) {
			answer[i] = solve.get(i);
		}
		return answer;
	}
	
	public static <K, V> K getKey(Map<K, V> map, V value) {
        for (K key : map.keySet()) { 
            if (value.equals(map.get(key))) {
                return key;
            }
        }
        return null;
   }

//	
//
	


}
		
