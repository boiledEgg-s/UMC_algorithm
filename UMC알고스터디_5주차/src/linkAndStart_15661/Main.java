package linkAndStart_15661;

import java.io.*;
import java.util.*;


public class Main {
	static int min = Integer.MAX_VALUE; //�ּڰ� ����
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); //�ο� ��
		int[][] arr = new int[n][n];	//�ɷ�ġ ���̺�
		int[] link = new int[n];		//link[Ư�� ����� ��ȣ] == 1 -> link�� ���
		int[] start = new int[n];		//start[Ư�� ����� ��ȣ] == 1 -> start�� ���
		for (int i = 0; i < n; i++) {
			String[] strr = br.readLine().split(" ");
			link[i] = 1;	//��ũ���� ���Ƴְ� �Ѹ� start ������ �Ѱܼ� ���ϴ� ����� ä��
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(strr[j]);
			}
		}
		
		findMin(arr, n, link, start, 0, 0);
		System.out.println(min);
		
	}
	
	public static void findMin(int[][] arr, int arrSize, int[] link, int[] start, int bound, int index) {
		if(bound >= arrSize/2 || min==0) {					//��ü Ž�� �� ���� ����� �ι��� �ϱ� ������ bound ���� �� Ž�� ���� ������ ����
			return;									
		}
		for(int i=index; i<arrSize; i++) {
			int[] ltemp = Arrays.copyOf(link, arrSize);		//�ڹٴ� �迭�� �Ű������� �ѱ� �� �ּҰ��� �ѱ�⿡ ���纻�� ����	
			int[] stemp = Arrays.copyOf(start, arrSize);	//���� ����;;
			ltemp[i] = 0; 									//link������ �Ѹ� ����
			stemp[i] = 1;									//start���� �Ѹ� �߰�
			int l = tableCalculate(arr, ltemp,arrSize);		
			int s = tableCalculate(arr, stemp,arrSize);
			int diff = Math.abs(l-s);						
			if(diff < min) min = diff;
			findMin(arr, arrSize, ltemp, stemp, bound+1, i+1);	//link���� start�� �Ѹ�� �߰��ϱ� ���� ����Լ� ���
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



