package greedy;


public class JoyStick {

	public static void main(String[] args) {
//		String name = "JEROEN";
//		//56
		String name = "JAN";
//		23
//		String name = "JAZ";
//		11
		System.out.println(solution(name));
	}
	
	public static int solution(String name) {
        int ans = 0;
        for(int i = 0 ; i < name.length() ; i++) {
            if(name.charAt(i)!= 'A') {
                int up = name.charAt(i) - 'A';
                int down = 1 + 'Z' - name.charAt(i);
                ans += (up < down)? up : down;
            }
        }
        
        int minMove = name.length() - 1;
        for(int i = 0 ; i < name.length() ; i++) {
            if(name.charAt(i) != 'A') {
                int next = i+1;
                while(next < name.length() && name.charAt(next) == 'A') {
                    next++;
                }
                int move = 2 * i + name.length() - next;
                minMove = Math.min(move, minMove);
            }
        }
        
        return ans + minMove;
	}
}
