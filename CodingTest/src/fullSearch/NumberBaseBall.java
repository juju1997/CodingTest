package fullSearch;


public class NumberBaseBall {

	public static void main(String[] args) {
		
		int[][] baseball = {{123, 1, 1}, {356, 1, 0}, {327, 2, 0}, {489, 0, 1}};
		solution(baseball);		
	}
	
/*
	 * 각자 서로 다른 1~9까지 3자리 임의의 숫자를 정한 뒤 서로에게 3자리의 숫자를 불러서 결과를 확인합니다. 
	 * 그리고 그 결과를 토대로 상대가 정한 숫자를 예상한 뒤 맞힙니다.
	* 숫자는 맞지만, 위치가 틀렸을 때는 볼
	* 숫자와 위치가 모두 맞을 때는 스트라이크
	* 숫자와 위치가 모두 틀렸을 때는 아웃
	예를 들어, 아래의 경우가 있으면
	A : 123
	B : 1스트라이크 1볼.
	A : 356
	B : 1스트라이크 0볼.
	A : 327
	B : 2스트라이크 0볼.
	A : 489
	B : 0스트라이크 1볼.
	이때 가능한 답은 324와 328 두 가지입니다.
	질문한 세 자리의 수, 스트라이크의 수, 볼의 수를 담은 2차원 배열 baseball이 매개변수로 주어질 때,
	 가능한 답의 개수를 return 하도록 solution 함수를 작성해주세요.
	제한사항
	질문의 수는 1 이상 100 이하의 자연수입니다.
	baseball의 각 행은 [세 자리의 수, 스트라이크의 수, 볼의 수] 를 담고 있습니다.
 * */	

	
	public static int solution(int[][] baseball) {
        int answer = 0;
        for(int i=1; i<=9; i++) {
        	for(int j=1; j<=9; j++) {
        		for(int k=1; k<=9; k++) {
        			if(i==j & j==k) continue;
        			int comp = 0;
        			for(int[] base : baseball) {
        				int one = base[0]/100;
        				int two = base[0]%100/10;
        				int three = base[0]%10;
        				int strike = 0;
        				int ball = 0;
        				if(one==i) strike++;
        				if(two==i || three==i) ball++;
        				if(two==j) strike++;
        				if(one==j || three==j) ball++;
        				if(three==k) strike++;
        				if(one==k || two==k) ball++;
        				
        				if(base[1]==strike && base[2]==ball) comp++;
        			}
        			if(comp==baseball.length) answer++;
        		}
        	}
        }
        return answer;
    }
}
