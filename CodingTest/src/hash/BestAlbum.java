package hash;

import java.util.*;


public class BestAlbum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String[] genres = {"classic","pop", "classic", "classic", "pop"};
//		String[] genres = {"a", "a","a", "b", "b", "c"};
//		String[] genres = {"classic","pop", "classic", "classic", "pop", "hip"};
//		int[] plays = {100, 200, 250, 300, 400, 500};
//		int[] plays = {500, 600, 150, 800, 2500};
//		int[] plays = {500, 600, 150, 800, 2500, 1300};
		//기대값 : 4,1,3,0
		
		
//		String[] genres = {"classic", "pop", "classic", "classic", "pop", "zazz", "zazz"};
//		int[] plays = {500, 600, 150, 800, 2500, 2000, 6000};
//				[6, 5, 4, 1, 3, 0]
//		String[] genres = {"classic", "pop", "classic", "classic", "pop", "zazz", "zazz"};
//		int[] plays = {500, 600, 150, 800, 2500, 2100, 1000};
//				[4, 1, 5, 6, 3, 0]
		String[] genres = {"classic", "pop", "classic", "pop", "classic", "classic"};
		int[] plays = {400, 600, 150, 2500, 500, 500};
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
		int[] answer = {};
		
		HashMap<String, Integer> hash1 = new HashMap<>();
		for(int i=0; i<genres.length; i++) {
			hash1.put(genres[i], hash1.getOrDefault(genres[i], 0) + plays[i]);
		}
		System.out.println(hash1 + " hash1");
		
		List<String> sortG = new ArrayList<>();
		for(String gen : hash1.keySet()) {
			sortG.add(gen);
		}
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
		String temp = "";
		
//		{pop=3100, classic=1550} hash1
//		[2500, 600, 500, 500, 400, 150] list
//		{classic0=400, classic2=150, classic4=500, classic5=500, pop1=600, pop3=2500} hash3
		for(String sg : sortG) {
			for(int l : list) {
				for(String ha : hash3.keySet()) {
					if(ha.indexOf(sg) >= 0 && hash3.get(ha) == l) {
						cnt++;
						System.out.println(ha);
						if(cnt == 2) {
							cnt = 0;
							continue;
						}
					}
				}
				if(cnt==2) {
					cnt = 0;
					break;
				}
			}
		}
		
		return answer;
	}

   public static <K, V> K getKey(Map<K, V> map, V value) {
        V com = value;
        for (K key : map.keySet()) {
            if (value.equals(map.get(key))) {
                return key;
            }
        }
        return null;
   }
//   
//   public static int[] solution(String[] genres, int[] plays) {
//        
//        
//        
//        HashMap<String, Integer> hash1 = new HashMap<String, Integer>();
//        for(int i=0; i<genres.length; i++) {
//           hash1.put(genres[i], hash1.getOrDefault(genres[i], 0) + plays[i]);
//        }
//        System.out.println(hash1);
//        List<Integer> list = new ArrayList<Integer>(hash1.values());
//        Collections.sort(list); Collections.reverse(list);
//        List<String> sort = new ArrayList<String>();
//        System.out.println(list);
//        for(int a : list) {
//           sort.add(getKey(hash1, a));
//        }
//        
//        HashMap<Integer, String> hash2 = new HashMap<Integer, String>();
//        for(int i=0; i<genres.length; i++) {
//           hash2.put(plays[i], genres[i]);
//        }
//        List<Integer> playList = new ArrayList<Integer>(plays.length);
//        for (int play : plays) { playList.add(play); }
//        Collections.sort(playList); Collections.reverse(playList);
//        
//        List<Integer> realList = new ArrayList<Integer>();
//        for(String forSort : sort) {
//           for(int forPlayList : playList) {
//              if(hash2.get(forPlayList).equals(forSort)) {
//                 realList.add(forPlayList);
//              }
//           }
//        }
////        {100, 200, 300, 400, 500};
//        System.out.println(sort);	//b c a
//        System.out.println(realList);	//400,300,500,200,100
//        
//        List<Integer> li = new ArrayList<Integer>();
//        int temp = 0;
//        String past = sort.get(0);
//        for(int real : realList) {
//           if(temp <= 1 && past.equals(hash2.get(real))) {
//              li.add(real);
//              temp++;
//              past = hash2.get(real);
//           }else if(temp == 2){
//              temp = 0;
//           }
//           if(!past.equals(hash2.get(real))) {
//              li.add(real);
//              temp++;
//              past = hash2.get(real);
//           }
//        }
//        
//        System.out.println(li);
//        int[] answer = new int[li.size()];
//        
//        int cnt = 0;
//        for(int i=0; i<li.size(); i++) {
//        	for(int j=0; j<plays.length; j++) {
//        		if(li.get(i)==plays[j]) {
//        			answer[cnt] = j;
//        			cnt++;
//        		}
//        	}
//        }
//        return answer;
//    }

}
		
