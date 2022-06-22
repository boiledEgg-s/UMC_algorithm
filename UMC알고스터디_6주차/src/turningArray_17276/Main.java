package turningArray_17276;

import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		int[][] steps = new int[][] {	//�� ���� �̵� ����
			{1,1}, {0,1}, {-1,1}, {-1,0}, {-1,-1}, {0,-1}, {1,-1}, {1,0} 
		};
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());
		while((t--)>0) {
			String[] str = br.readLine().split(" ");
			int n = Integer.parseInt(str[0]);
			int mid = n/2;
			int[][] begin = new int[][] {	//�� ���� ���� ����
				{0,0}, {mid,0}, {n-1,0}, {n-1,mid}, {n-1,n-1}, {mid, n-1}, {0, n-1}, {0, mid}
			};
			
			int angle = Integer.parseInt(str[1]);
			if(angle<0) angle = 360+angle;
			angle /= 45;
			
			int[][] arr = new int[n][n];
			int[][] ans = new int[n][n];
			for(int i = 0; i<n; i++) {
				str = br.readLine().split(" ");
				for(int j=0; j<n; j++) {
					arr[i][j] = Integer.parseInt(str[j]);
					ans[i][j] = Integer.parseInt(str[j]);
				}
			}
			
			if(angle != 8) rotateArr(steps, begin, arr, ans, n, angle);	//angle = 8 = 360��
			for(int i = 0; i<ans.length; i++) {
				for(int j=0; j<ans[i].length; j++) {
					bw.write(ans[i][j]+ " ");
				}
				bw.write("\n");
			}
		}
		bw.flush();
		
	}
	
	public static int[][] rotateArr(int[][] steps, int[][] begin, int[][] arr, int[][] ans, int n, int angle) {
		for(int i=0; i<steps.length; i++) {
			int x=begin[i][0], y=begin[i][1];
			int change = ((i+angle) >= steps.length)?(i+angle)%steps.length:i+angle; //�������� �ش� ��ġ������ ���� + ȸ���ϴ� ���� > 360�϶� ��� ����
			int chX = begin[change][0], chY = begin[change][1];
			for(int j = 0; j<n; j++){
				ans[chY][chX] = arr[y][x];
				x += steps[i][0];
				y += steps[i][1];
				chX += steps[change][0];
				chY += steps[change][1];
			}
		}
		return ans;
	}
}
