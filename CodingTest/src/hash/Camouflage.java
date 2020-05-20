package hash;

import java.util.HashMap;

public class Camouflage {

	
	/*
	 * 스파이들은 매일 다른 옷을 조합하여 입어 자신을 위장합니다.
		예를 들어 스파이가 가진 옷이 아래와 같고 오늘 스파이가 동그란 안경, 긴 코트, 파란색 티셔츠를 입었다면 다음날은 청바지를 추가로 입거나 
		동그란 안경 대신 검정 선글라스를 착용하거나 해야 합니다.
		종류	이름
		얼굴	동그란 안경, 검정 선글라스
		상의	파란색 티셔츠
		하의	청바지
		겉옷	긴 코트
		스파이가 가진 의상들이 담긴 2차원 배열 clothes가 주어질 때 서로 다른 옷의 조합의 수를 return 하도록 solution 함수를 작성해주세요.
	 */
	
	public static int solution(String[][] clothes) {
       int answer = 1;	//기존 0이지만 String을 Int로 바꾸며 0*의 문제를 없애기 위해 1로 변경 
       HashMap<String, Integer> hash = new HashMap<String, Integer>();	//중복되는 값 체크와 카운하트하기 위한 Map
       for(String[] arr : clothes) {	//2차원 배열을 for문 돌려 하나씩 가져온다. 
    	   hash.put(arr[1], hash.getOrDefault(arr[1], 0) +1 );	//같은 값은+1씩 해준다. 
       }
       
       for(String key : hash.keySet()) {	//HashMap안에 들어있는 key들을 for문 돌린다. 
    	   answer *= hash.get(key)+1;	//key에 해당하는 value 들을 answer에 *= 해준다. 1*1 방지를 위한 +1  
       }
        return answer-1;	//기존 answer을 1 더해준걸 1빼준다.
    }
}
