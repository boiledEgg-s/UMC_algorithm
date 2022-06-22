package absoluteHeap_11279;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		
		Comparator<Integer> c = new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				int a = Math.abs(o1);
				int b = Math.abs(o2);
				if(a<b) return -1;
				else if(a>b) return 1;
				else {
					if(o1<o2) 
						return -1;
					else if(o1>o2)
						return 1;
					else 
						return 0;
				}
			}
			
		};
	
		PriorityQueue<Integer> qu = new PriorityQueue<>(c);
		while((n--)>0) {
			int num = Integer.parseInt(br.readLine());
			if(num == 0) {
				if(qu.isEmpty()) bw.write("0\n");
				else bw.write(qu.poll()+"\n");
			} else {
				qu.add(num);
			}
		}
		bw.flush();
		
	}

}
