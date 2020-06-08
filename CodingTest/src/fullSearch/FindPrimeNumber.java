package fullSearch;

import java.util.*;

public class FindPrimeNumber {

	public static void main(String[] args) {
//		String numbers = "17";
//		String numbers = "011";
//		String numbers = "13579";
		String numbers = "777";
		
		solution(numbers);
	}
	
	
	/*
	 * 한자리 숫자가 적힌 종이 조각이 흩어져있습니다. 흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.
	각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때, 
	종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성해주세요.
	제한사항
	numbers는 길이 1 이상 7 이하인 문자열입니다.
	numbers는 0~9까지 숫자만으로 이루어져 있습니다.
	013은 0, 1, 3 숫자가 적힌 종이 조각이 흩어져있다는 의미입니다.
	 * */
	public static int solution(String numbers) {
        int answer = 0;
        //3*1 , 3*2, 3*3 팩토리얼 순열
        String[] strArr = numbers.split("");
        
        Set<Integer> set=new HashSet<>();
        //1부터 만들 수 있는 최대 길이까지 숫자 조합
        for(int i=1;i<=strArr.length;i++){
            perm(strArr, 0, i, set);
        }
        answer=set.size();
        System.out.println(answer);
        return answer;
    }
	
	 public static void perm(String[] arr, int depth, int k, Set<Integer> set){//숫자 조합
	        if(depth==k){//원하는 k개의 숫자가 세팅됐으므로 더이상 순열생성X
	            print(arr, k, set);
	            return;
	        }
	        else{
	            for(int i=depth;i<arr.length;i++){
	                swap(arr, i, depth);
	                perm(arr, depth+1, k, set);
	                swap(arr, i, depth);
	            }
	        }
	    }
	    public static void swap(String[] arr, int i, int j){
	        String temp=arr[i];
	        arr[i]=arr[j];
	        arr[j]=temp;
	    }
	    public static void print(String[] arr, int k, Set<Integer> set){//숫자 연결
	        StringBuilder s=new StringBuilder();
	        for(int i=0;i<k;i++){
	            s.append(arr[i]);//숫자연결하기
	        }
//	        System.out.println(s);
	        System.out.println(set);
	        primeNumber(set, s);
	    }
	    public static void primeNumber(Set<Integer> set, StringBuilder s){//소수 체크
	        int num=Integer.parseInt(String.valueOf(s));
	        boolean prime=true;
	        if(num<=1){
	            return;
	        }
	        for(int i=2;i<=Math.sqrt(num);i++){
	            if(num%i==0){
	                prime=false;
	                break;
	            }
	        }
	        if(prime){
	            set.add(num);
	        }
	    }

}
