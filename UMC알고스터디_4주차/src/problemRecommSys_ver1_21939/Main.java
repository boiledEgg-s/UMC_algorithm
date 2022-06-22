package problemRecommSys_ver1_21939;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());	//초기 문제 개수
		
		Comparator<Integer[]> c1 = new Comparator<Integer[]>() {
			@Override
			public int compare(Integer[] o1, Integer[] o2) {
				// TODO Auto-generated method stub
				if(o1[0] > o2[0]) {
					return 1;
				} else {
					return -1;
				}
			}
		};
		
		Comparator<Integer[]> c2 = new Comparator<Integer[]>() {
			@Override
			public int compare(Integer[] o1, Integer[] o2) {
				// TODO Auto-generated method stub
				if(o1[0] < o2[0]) {
					return 1;
				} else {
					return -1;
				}
			}
		};

		PriorityQueue<Integer[]> max = new PriorityQueue<>(Collections.reverseOrder(c2));
		PriorityQueue<Integer[]> min = new PriorityQueue<>(Collections.reverseOrder(c1));
		
		while((n--)>0) {
			String[] k = br.readLine().split(" ");
			Integer[] q = {Integer.parseInt(k[0]), Integer.parseInt(k[1])};
			max.add(q);
			min.add(q);
		}
		
		bw.write("MAX->\n");
		for(int i = 0; i<max.size(); i++) {
			Integer[] q = max.poll();
			bw.write(q[0]+" "+q[1]+"\n");
		}
		bw.write("\nMIN->\n");
		for(int i = 0; i<min.size(); i++) {
			Integer[] q = min.poll();
			bw.write(q[0]+" "+q[1]+"\n");
		}
		
		bw.flush();
	}

}
