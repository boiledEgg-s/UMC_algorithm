package linkAndStart_15661;

import java.io.*;
import java.util.*;


public class Main {
	static int min = Integer.MAX_VALUE; //최솟값 변수
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); //인원 수
		int[][] arr = new int[n][n];	//능력치 테이블
		int[] link = new int[n];		//link[특정 사람의 번호] == 1 -> link팀 멤버
		int[] start = new int[n];		//start[특정 사람의 번호] == 1 -> start팀 멤버
		for (int i = 0; i < n; i++) {
			String[] strr = br.readLine().split(" ");
			link[i] = 1;	//링크팀에 몰아넣고 한명씩 start 팀으로 넘겨서 비교하는 방식을 채택
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(strr[j]);
			}
		}
		
		findMin(arr, n, link, start, 0, 0);
		System.out.println(min);
		
	}
	
	public static void findMin(int[][] arr, int arrSize, int[] link, int[] start, int bound, int index) {
		if(bound >= arrSize/2 || min==0) {					//전체 탐색 시 같은 계산을 두번씩 하기 때문에 bound 설정 및 탐색 수를 반으로 줄임
			return;									
		}
		for(int i=index; i<arrSize; i++) {
			int[] ltemp = Arrays.copyOf(link, arrSize);		//자바는 배열을 매개변수로 넘길 때 주소값을 넘기기에 복사본을 생성	
			int[] stemp = Arrays.copyOf(start, arrSize);	//위와 동일;;
			ltemp[i] = 0; 									//link팀에서 한명 제거
			stemp[i] = 1;									//start팀에 한명 추가
			int l = tableCalculate(arr, ltemp,arrSize);		
			int s = tableCalculate(arr, stemp,arrSize);
			int diff = Math.abs(l-s);						
			if(diff < min) min = diff;
			findMin(arr, arrSize, ltemp, stemp, bound+1, i+1);	//link에서 start로 한명더 추가하기 위해 재귀함수 사용
		}
		
	}
	
	public static int tableCalculate(int[][] arr, int[] table, int arrSize) {
		int res = 0;
		for (int i = 0; i < arrSize; i++) {
			if(table[i] != 1) continue;
			for (int j = i; j < arrSize; j++) {
				if(table[j] != 1 || i == j) continue;
				res += arr[i][j];
				res += arr[j][i];
			}
			
		}
		return res;
	}
}



