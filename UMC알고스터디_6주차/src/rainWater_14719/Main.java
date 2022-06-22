package rainWater_14719;

import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int h = Integer.parseInt(str[0]);
		int w = Integer.parseInt(str[1]);
		
		int[] arr = new int[w];
		int max = 0, min = 0; //최소값과 최댓값의 인덱스
		int res = 0; //답
		str = br.readLine().split(" ");
		for(int i=0; i<w; i++) {
			arr[i] = Integer.parseInt(str[i]);
			
			if(arr[min] >= arr[i]) min = i;	//최솟값보다 작을 경우 대체한다
			
			else if(arr[max] <= arr[i]) {	//최댓값보다 클 경우, 
				for(int x = max+1; x < i; x++) {	//중간에 있는 웅덩이의 공간 계산	
					res += arr[max] - arr[x];
					//System.out.println("MAX-> "+arr[max]+" - "+arr[x]+" = "+res+" 인덱스 arr["+max+"] - arr["+x+"]");
				}
				max = i;			
			} else {	
				//새로 들어온 값이 최대최소의 사잇값일 경우,
				int j = max+1;
				//최대와 사잇값의 사이에 최솟값을 제외하고 사이값보다 작아지는 부분을 찾는다.
				for(; j<i; j++) {	
					if(arr[j] < arr[i]) break;
				}
				
				//작아지는 부분부터 사이값 사이의 공간의 크기를 계산한다.
				for(int x = j; x < i; x++) {
					res += arr[i] - arr[x];
					arr[x] = arr[i];
					//System.out.println("MID-> "+arr[i]+" - "+arr[x]+" = "+res+" 인덱스 arr["+i+"] - arr["+x+"]");
					
				}
				min = i;
			}
		}
		
		System.out.println(res);
	}
	
}
