package holHolHo_20164;

import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int res = oddHollic(str, Integer.parseInt(str));
		System.out.println(res);
	}
	
	public static int oddHollic(String str, int num) {
		int count = 0;
		if(str.length()<=1) {
			if(num%2 == 1) count++;
		} else if(str.length()<=2){
			int n1 = (int)(str.charAt(0)-'0');
			int n2 = (int)(str.charAt(1)-'0');
			count+=oddHollic(Integer.toString(n1+n2), n1+n2);
		} else {
			for(int c=0; c<str.length(); c++) {
				if((int)(str.charAt(c)-'0')%2==1)	count++;
			}
			for(int i=1; i<str.length()-1; i++) {
				int n1 = Integer.parseInt(str.substring(0, i));
				for(int j=i+1; j<str.length(); j++) {
					int n2 = Integer.parseInt(str.substring(i, j));
					int n3 = Integer.parseInt(str.substring(j, str.length()));
					int total = n1+n2+n3;
					String temp = Integer.toString(total);
					for(int c=0; c<temp.length(); c++) {
						if(((int)(temp.charAt(c)-'0'))%2==1)	count++;
					}
					count+=oddHollic(temp, total);
				}
			}
		}
		return count;
	}
}
