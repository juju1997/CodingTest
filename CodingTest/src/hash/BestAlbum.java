package hash;

import java.util.*;

public class BestAlbum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] genres = {"classic","pop", "classic", "classic", "pop", "z"};
//		String[] genres = {"classic","pop", "classic", "classic", "pop", "hip"};
		int[] plays = {500, 600, 150, 800, 2500, 30};
//		int[] plays = {500, 600, 150, 800, 2500, 1300};
		//기대값 : 4,1,3,0
		System.out.println(solution(genres, plays));

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
   
   
   public static <K, V> K getKey(Map<K, V> map, V value) {
       
        for (K key : map.keySet()) {
            if (value.equals(map.get(key))) {
                return key;
            }
        }
        return null;
    }
   
   public static int[] solution(String[] genres, int[] plays) {
        
        
        
        HashMap<String, Integer> hash1 = new HashMap<String, Integer>();
        for(int i=0; i<genres.length; i++) {
           hash1.put(genres[i], hash1.getOrDefault(genres[i], 0) + plays[i]);
        }
        List<Integer> list = new ArrayList<Integer>(hash1.values());
        Collections.sort(list); Collections.reverse(list);
//        System.out.println(list +" list");
        List<String> sort = new ArrayList<String>();
        for(int a : list) {
           sort.add(getKey(hash1, a));
        }
//        System.out.println(sort + " sort");
        
        HashMap<Integer, String> hash2 = new HashMap<Integer, String>();
        for(int i=0; i<genres.length; i++) {
           hash2.put(plays[i], genres[i]);
        }
//        System.out.println(hash2 + " hash2");
        
        
        List<Integer> playList = new ArrayList<Integer>(plays.length);
        for (int play : plays) { playList.add(play); }
        Collections.sort(playList); Collections.reverse(playList);
//        System.out.println(playList + " playList");
        
        List<Integer> realList = new ArrayList<Integer>();
        for(String forSort : sort) {
           for(int forPlayList : playList) {
              if(hash2.get(forPlayList) == forSort) {
                 realList.add(forPlayList);
              }
           }
        }
        System.out.println(realList +" realList");
        
        List<Integer> li = new ArrayList<Integer>();
        int temp = 0;
        String past = sort.get(0);
        for(int real : realList) {
           if(temp <= 1 && past.equals(hash2.get(real))) {
              li.add(real);
              temp++;
              past = hash2.get(real);
           }else if(temp == 2){
              temp = 0;
           }
           if(!past.equals(hash2.get(real))) {
              li.add(real);
              temp++;
              past = hash2.get(real);
           }
        }
        int[] answer = new int[li.size()];
        for(int i=0; i<answer.length; i++) {
           answer[i] = li.get(i);
        }
        //2500,600,2000,10,800,500
        
//        for (String hash1Key : hash1.keySet()) {
//         for(String hash2Value : hash2.values()) {
//            if(hash1Key.equals(hash2Value)) {
//               System.out.println(hash1Key);
//            }
//         }
//      }
        
        
//        HashMap<String, Integer> hash = new HashMap<String, Integer>();
//        for(int i=0; i<genres.length; i++) {
//           hash.put(genres[i], hash.getOrDefault(genres[i], 0) + plays[i]);
//        }
//        System.out.println(hash);
//        
//        List<String> sortGenresList = new ArrayList<String>(hash.keySet());
//        Collections.sort(sortGenresList, (o1, o2) -> (hash.get(o2).compareTo(hash.get(o1))));   //value로 sorting
//        System.out.println(sortGenresList);
//        //처음 사용한 람다식 (인자,인자,...) -> {실행문} o1,o2 타입 추론 가능  .sort(List<T> list, Comparator<? super T> c)
//        //즉 Comparator dd = (o1, o2) -> hash.get(o2).compareTo(hash.get(o1)); 이런식으로 인자를 넣는 것 
//        // Comparator<T> 의 형식으로 T Class는 인터페이스를 생성할 때 구체적인 타입으로 변경된다.
//        // o2 o1 순서인건 내림차 순을 위해
//        List<Integer> playList = new ArrayList<Integer>(hash.values());
//        List<Integer> playList = new ArrayList<Integer>(plays.length);
//        for (int play : plays) { playList.add(play); }
//        Collections.sort(playList); //Collections.reverse(playList);
//        System.out.println(playList);
//        
//        List<String> genreList = new ArrayList<String>(genres.length);
//        for(String genre : genres) { genreList.add(genre); }
//        System.out.println(genreList);
// 
//        // List genresList = 장르모음, 중복제거 되었고 큰 순으로 정렬되어있음
//        // List playList  = 재생 횟수, 더해지지 않은것이며 내림차순으로 정렬되어있
//        // List genreList = 장르, 정렬이 안되어있는 array를 List로 convert 한 
//        
//        HashMap<String, Integer> map = new HashMap<String, Integer>();
//        for(int i=0; i<genres.length; i++) {
//           map.put(genres[i], playList.get(i));
//        }
//        
//        System.out.println(map);
        return answer;
    }

}
		
