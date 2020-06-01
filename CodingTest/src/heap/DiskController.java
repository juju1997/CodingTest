package heap;

import java.util.*;

public class DiskController {

	public static void main(String[] args) {
		int[][] jobs = {{0,3}, {1,9}, {2,6}};
//				9
//		int[][] jobs = {{24, 10}, {18, 39}, {34, 20}, {37, 5}, {47, 22}, {20, 47}, {15, 2}, {15, 34}, {35, 43}, {26, 1}};
//				74
//		int[][] jobs = {{24, 10}, {18, 39}, {34, 20}, {37, 5}, {47, 22}, {20, 47}, {15, 34}, {15, 2}, {35, 43}, {26, 1}};
//				74
		solution(jobs);
	}
	
	
	
	
	
	/*
	 * jobs{}{}에 있는 작업들은 요청시간 순으로 정렬되어 있지 않음
		같은 요청시간을 갖는 작업들이 2개 이상 존재할 수 있음
	 * */
	
	public static int solution(int[][] jobs) {
        int answer = 0;
        
        PriorityQueue<Disk> before = new PriorityQueue<>();	//프로세싱 전 
        List<Disk> ing = new LinkedList<>();	//프로세싱 중 
        List<Integer> after = new ArrayList<>();	//프로세싱 끝 
        
        for(int i=0; i<jobs.length; i++) {
        	before.offer(new Disk(jobs[i][0], jobs[i][1]));
        }
        
//        while(!before.isEmpty()) {
//        	System.out.println(before.poll());
//        }
        
        // RealStart + Length - HopeStart
        int rs = 0;	//RealStart
        int ed = 0; //endTime
        System.out.println(before);
        while(!before.isEmpty()) {
        	Disk d = before.poll();
        	answer += rs+d.time-d.priority;
        	rs += d.time;
        }
        System.out.println(answer/jobs.length);
        return answer/jobs.length;
    }

}
class Disk implements Comparable<Disk>{
	int priority;
	int time;
	Disk(int priority, int time){
		this.priority = priority;
		this.time = time;
	}
	@Override
	public int compareTo(Disk d) {
		return this.priority >= d.priority ? 1 : -1;
	}
	@Override
	public String toString() {
		return "Disk [priority=" + priority + ", time=" + time + "]";
	}
	
}
