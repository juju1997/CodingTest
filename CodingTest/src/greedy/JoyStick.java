package greedy;

import java.util.*;

public class JoyStick {

	public static void main(String[] args) {
//		String name = "JEROEN";
//		//56
//		String name = "JAN";
//		23
		String name = "JAZ";
		//11
		solution(name);
	}
	
	public static int solution(String name) {
        int answer = -1;
        // A = 65
        //ASCII 65 ~ 90
        int mid  = (65+90)/2;
        int A = 65;
        char[] arr = name.toCharArray();
        int[] intArr = new int[arr.length];
        for(int i=0; i<intArr.length; i++) {
        	intArr[i] = (int)arr[i];
        }
        Queue<String> q = new LinkedList<>();
        //정상진행 right 비정상진행 left 
        for(int i=1; i<intArr.length; i++) {
        	if(intArr[i]!=A) {
        		System.out.println("zenProject중 ...아오,,,,,");
        		
        	}else {
        	}
        }
        
        
        for(int i=0; i<arr.length; i++) {
        	if(intArr[i]==65) { 
        		answer++;
        		continue;
        	}else {
        		if(intArr[i] < mid) {	//주어진 값이 중간값이랑 가까울 A까지 -하면서 가야함 
        			answer += (intArr[i]-A);
        		}else {	//주어진 값이 중간값보다 멀때 +하면서 가야함
        			
        			
        		}
        	}
        	answer++;
        }
        
        System.out.println(answer);
        return answer;
    }

}
