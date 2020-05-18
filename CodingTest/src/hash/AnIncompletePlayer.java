package hash;

import java.util.HashMap;
public class AnIncompletePlayer {

//		수많은 마라톤 선수들이 마라톤에 참여하였습니다. 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.
//		마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때, 완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.
//		제한사항
//		마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다.
//		completion의 길이는 participant의 길이보다 1 작습니다.
//		참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.
//		참가자 중에는 동명이인이 있을 수 있습니다.

	public static String solution(String[] participant, String[] completion) {
		String answer = "";
		HashMap<String, Integer> hash = new HashMap<>();	//key, value 로 저장할 hash map
		
		for(String par : participant) {			//참가자의 길이만큼 돌린다.
			hash.put(par, hash.getOrDefault(par, 0) + 1);	
			//hash에 참가자를 한명씩 넣는다. 
			//getOrDefault : 키 값을 검색하여 있으면 값 반환 없으면 기본 값 , 즉 없으면 1, 있으면 1을 가져와서 2가 된다.
		}
		
		for(String com : completion) {			//완주자의 길이만큼 돌린다. 
			hash.put(com, hash.getOrDefault(com, 0) - 1);
			//hash에 완주자를 한명씩 넣는다.
			// 위 코드와 다른 점은 이미 있는 값이면 1이 저장되어있으니 -1 해서 해당 키의 값을 0으로 바꾼다.
			// 완주자에 없어서 -1이 안된 참가자는 값이 1이 될 것이다.
			// * 동명이인은 참가자에서 2까지 올린 후 둘중 하나가 못들어오면 1, 둘 다 들어오면 0 으로 같은 방식으로 처리 가
		}
		
		for(String par : participant) {	//참가자의 길이만큼 돌린다.
			if(hash.get(par) == 1) {		//마찬가지로 참가자이름의 키에 값이 1이면 완주를 못한 사람이 된다.
				answer = par;
			}
		}
		return answer;
	}
}
