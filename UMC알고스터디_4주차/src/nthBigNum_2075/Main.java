package nthBigNum_2075;
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		PriorityQueue<Integer> qu = new PriorityQueue<>(Collections.reverseOrder());
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i<n; i++) {
			String[] str = br.readLine().split(" ");
			for(int j = 0; j<n; j++) {
				qu.add(Integer.parseInt(str[j]));
			}
		}
		
		while((n--)>1) {
			qu.poll();
		}
		bw.write(qu.poll()+"\n");
		bw.flush();
	}
}
