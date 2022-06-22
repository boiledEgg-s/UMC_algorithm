package findingSquare_1025;

import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);
		int[][] nums = new int[n][m];
		for(int i = 0; i<n; i++) {
			String s = br.readLine();
			for(int j = 0; j<m; j++) {
				nums[i][j] = (int)(s.charAt(j)-'0');
			}
		}
		
		int max = -1;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				int res = findMax(nums, i, j, n, m);
				int resRev = findMaxRev(nums, i, j, n, m);
//				if(res != 0)
//					System.out.println(res);
				if(max < ((res>resRev)?res:resRev)) {
					max = ((res>resRev)?res:resRev);
				}
			}
		}
		System.out.println(max);
	}
	
	
	public static int findMax(int[][] arr, int i, int j, int n, int m) {
		int max = -1;
		for(int x=0; i+x<n; x++) {
			for(int y = 0; j+y<m; y++) {
				
				String str = "";
				int tempX = i;
				int tempY = j;
				while(tempX<n && tempY<m) {
					str+=arr[tempX][tempY];
					tempX+=x;
					tempY+=y;
					
					StringBuffer s = new StringBuffer(str);
					int res = Integer.parseInt(str);
					int revRes = Integer.parseInt(s.reverse().toString());
					if(isSquare(revRes)) {
						if(isSquare(res)) {
							if(res < revRes) res = revRes;
						}else {
							res = revRes;
						}
					}
					if(isSquare(res) && max < res) max = res;
					if(x==0&&y==0) break;
				}
			}
		}
		return max;
	}
	
	public static int findMaxRev(int[][] arr, int i, int j, int n, int m) {
		int max = -1;
		for(int x=0; i+x<n; x++) {
			for(int y = 0; j+y>=0; y--) {
				
				String str = "";
				int tempX = i;
				int tempY = j;
				while(tempX<n && tempY>=0) {
					str+=arr[tempX][tempY];
					tempX+=x;
					tempY+=y;
					
					StringBuffer s = new StringBuffer(str);
					int res = Integer.parseInt(str);
					int revRes = Integer.parseInt(s.reverse().toString());
					if(isSquare(revRes)) {
						if(isSquare(res)) {
							if(res < revRes) res = revRes;
						}else {
							res = revRes;
						}
					}
					if(isSquare(res) && max < res) max = res;
					if(x==0&&y==0) break;
				}
			}
		}
		return max;
	}
	
	public static boolean isSquare(int num) {
		if(Math.pow((int)Math.sqrt(num),2) == num)
			return true;
		return false;
	}	
}
