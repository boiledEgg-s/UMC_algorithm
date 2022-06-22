//숫자로 찾는 배열과 문자열로 찾는 맵을 따로 만들어서 입력받는 조건에 따라 다른 저장매체를 탐색한다.
package pocketmonMaster_1620;

import java.io.*;
import java.util.*;

public class Main {


	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		HashMap<String, Integer> mon1 = new HashMap<>();
		ArrayList<String> mon2 = new ArrayList<>();
		String[] str = br.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);
		for(int i = 0; i<n; i++) {
			String s = br.readLine();
			mon1.put(s, i);
			mon2.add(s);
		}
		
		for(int i = 0; i<m; i++) {
			String s = br.readLine();
			if(s.charAt(0) <= '9') 
				bw.write((mon2.get(Integer.parseInt(s)-1))+"\n");
			else
				bw.write((mon1.get(s)+1)+"\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}

}
