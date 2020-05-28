package heap;

import java.util.*;

public class MoreSpicy {

	public static void main(String[] args) {
//		int[] scoville = {1,2,3,9,10,12};	//2
		int[] scoville = {1,100,100};
		int K = 7;
		
		System.out.println((solution(scoville, K) + " answer"));
	}
	
	/*
	 * 매운 것을 좋아하는 Leo는 모든 음식의 스코빌 지수를 K 이상으로 만들고 싶습니다.
	 *  모든 음식의 스코빌 지수를 K 이상으로 만들기 위해 Leo는 스코빌 지수가 가장 낮은 두 개의 음식을 아래와 같이 특별한 방법으로 섞어 
	 *  새로운 음식을 만듭니다.
	섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
	Leo는 모든 음식의 스코빌 지수가 K 이상이 될 때까지 반복하여 섞습니다.
	Leo가 가진 음식의 스코빌 지수를 담은 배열 scoville과 원하는 스코빌 지수 K가 주어질 때, 
	모든 음식의 스코빌 지수를 K 이상으로 만들기 위해 섞어야 하는 최소 횟수를 return 하도록 solution 함수를 작성해주세요.
	제한 사항
	scoville의 길이는 2 이상 1,000,000 이하입니다.
	K는 0 이상 1,000,000,000 이하입니다.
	scoville의 원소는 각각 0 이상 1,000,000 이하입니다.
	모든 음식의 스코빌 지수를 K 이상으로 만들 수 없는 경우에는 -1을 return 합니다.
	 * */
	
	 public static int solution(int[] scoville, int K) {
	        int answer = 0;
	        Heap h = new Heap();
	        for(int m : scoville) {
	        	h.insert(m);
	        }
	        
	        while(true) {
	        	int com = h.delete();
	        	if(h.heapSize()==1 && com<K) {
	        		return -1;
	        	}
	        	if(com < K) {	
	        		answer++;
	        		h.insert(com+(h.delete()*2));
	        	}else {
	        		break;
	        	}
	        }
	        return answer;
	    }
}



class Heap {	//MinimumHeap 
    List<Integer> heap;

    public Heap() {
        heap = new ArrayList<Integer>();
        heap.add(0);
    }
    public int heapSize() {
    	return heap.size();
    }
    public void insert(int n) {
        heap.add(n);
        int p = heap.size() - 1;
        while (p < 1 || heap.get(p / 2) > heap.get(p)) {
            // 부모노드와 자식 노드의 값 교환
            int tmp = heap.get(p / 2);
            heap.set(p / 2, heap.get(p));
            heap.set(p, tmp);
            p = p / 2;
        }
    }

    public int delete() {
        if (heap.size() <= 1)
            return 0;
        int deleteItem = heap.get(1); // 삭제할 노드 = 루트노드

        heap.set(1, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);

        int pos = 1;
        while ((pos * 2) < heap.size()) {
            int min = heap.get(pos * 2);
            int minPos = pos * 2;

            if (((pos * 2 + 1) < heap.size()) && min > heap.get(pos * 2 + 1)) {
                min = heap.get(pos * 2 + 1);
                minPos = pos * 2 + 1;
            }
            if (heap.get(pos) < min)
                break;
            // 부모노드 자식노드 교환
            int tmp = heap.get(pos);
            heap.set(pos, heap.get(minPos));
            heap.set(minPos, tmp);
            pos = minPos;
        }

        return deleteItem;
    }
}
