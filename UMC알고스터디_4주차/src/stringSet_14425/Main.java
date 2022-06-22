package stringSet_14425;

import java.io.*;
import java.util.*;

public class Main {


	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		HashSet<String> set = new HashSet<>();
		String[] str = br.readLine().split(" ");
		int n = Integer.parseInt(str[0]);	//집합 원소 개수
		int m = Integer.parseInt(str[1]);	//검사해야 하는 문자열 수
		int ans = 0;
		while((n--)>0) {
			set.add(br.readLine());
		}
		
		while((m--)>0) {
			String s = br.readLine();
			if(set.contains(s)) ans++;
		}
		
		System.out.println(ans);
	}

}
