package stringSet_14425;

import java.io.*;
import java.util.*;

public class Main {


	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		HashSet<String> set = new HashSet<>();
		String[] str = br.readLine().split(" ");
		int n = Integer.parseInt(str[0]);	//���� ���� ����
		int m = Integer.parseInt(str[1]);	//�˻��ؾ� �ϴ� ���ڿ� ��
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
