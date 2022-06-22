//priority_queue 예제
//new PriorityQueue<>() -> ascending
//new PriorityQueue<>(Collections.reverseOrder()) -> descending
// ~> reverseOrder(Comparator c) -> c가 정의하는 순서

package biggestHeap_11279;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> qu = new PriorityQueue<>(Collections.reverseOrder());
		int size = 0;
		
		while((n--)>0) {
			int num = Integer.parseInt(br.readLine());
			if(num==0) {
				if(qu.isEmpty()) bw.write("0\n");
				else bw.write(qu.poll()+"\n");
			} else {
				qu.add(num);
			}
		}	
		bw.flush();
	}
}
