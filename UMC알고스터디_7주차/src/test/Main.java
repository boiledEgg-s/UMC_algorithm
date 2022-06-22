package test;

import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		Stack<Integer> st = new Stack<>();
		
		while((n--)>0) {
			st.push(sc.nextInt());
		}
		
		int ans = 0;
		while(!st.isEmpty() && k != 0) {
			int temp = st.pop();
			ans += k/temp;
			k %= temp;
			//System.out.println(temp +" "+k+" "+ans);
		}
		
		System.out.println(ans);
	}

}
