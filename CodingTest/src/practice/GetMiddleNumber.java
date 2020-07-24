package practice;

public class GetMiddleNumber {

	public static void main(String[] args) {
//		String s = "abcde"; //c
		String s = "qwer";	//we
		solution(s);
	}
	/*
	 * 단어 s의 가운데 글자를 반환하는 함수, solution을 만들어 보세요.
	 *  단어의 길이가 짝수라면 가운데 두글자를 반환하면 됩니다.
	 * */
	public static String solution(String s) {
        String answer = "";
        String[] arr = s.split("");
        if(arr.length % 2 == 0){
        	//2개
        	int div = arr.length/2;
        	answer += arr[div-1];
        	answer += arr[div];
        }else{
        	//1개
        	answer = arr[arr.length/2];
        }
        System.out.println(answer);
        return answer;
    }

}
