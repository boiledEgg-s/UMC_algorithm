package rainWater_14719;

import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int h = Integer.parseInt(str[0]);
		int w = Integer.parseInt(str[1]);
		
		int[] arr = new int[w];
		int max = 0, min = 0; //�ּҰ��� �ִ��� �ε���
		int res = 0; //��
		str = br.readLine().split(" ");
		for(int i=0; i<w; i++) {
			arr[i] = Integer.parseInt(str[i]);
			
			if(arr[min] >= arr[i]) min = i;	//�ּڰ����� ���� ��� ��ü�Ѵ�
			
			else if(arr[max] <= arr[i]) {	//�ִ񰪺��� Ŭ ���, 
				for(int x = max+1; x < i; x++) {	//�߰��� �ִ� �������� ���� ���	
					res += arr[max] - arr[x];
					//System.out.println("MAX-> "+arr[max]+" - "+arr[x]+" = "+res+" �ε��� arr["+max+"] - arr["+x+"]");
				}
				max = i;			
			} else {	
				//���� ���� ���� �ִ��ּ��� ���հ��� ���,
				int j = max+1;
				//�ִ�� ���հ��� ���̿� �ּڰ��� �����ϰ� ���̰����� �۾����� �κ��� ã�´�.
				for(; j<i; j++) {	
					if(arr[j] < arr[i]) break;
				}
				
				//�۾����� �κк��� ���̰� ������ ������ ũ�⸦ ����Ѵ�.
				for(int x = j; x < i; x++) {
					res += arr[i] - arr[x];
					arr[x] = arr[i];
					//System.out.println("MID-> "+arr[i]+" - "+arr[x]+" = "+res+" �ε��� arr["+i+"] - arr["+x+"]");
					
				}
				min = i;
			}
		}
		
		System.out.println(res);
	}
	
}
