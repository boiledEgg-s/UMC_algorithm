package tetroDomino_14500;

/*
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][][] blocks = {		//	[13][4][2]
				{{0,0},{1,0},{2,0},{3,0}},	//길쭉 가로
				{{0,0},{0,1},{0,2},{0,3}},	//길쭉 세로	
				{{0,0},{0,1},{1,0},{1,1}},	//정사각형
				{{0,0},{0,1},{0,2},{1,2}},	//갈고리 ver 1
				{{0,1},{1,1},{2,1},{2,0}},	//갈고리 ver 2
				{{0,0},{1,0},{1,1},{1,2}},	//갈고리 ver 3
				{{0,0},{1,0},{2,0},{0,1}},	//갈고리 ver 4
				{{0,0},{0,1},{1,1},{1,2}},	//뱀 ver 1
				{{0,1},{1,1},{1,0},{2,0}},	//뱀 ver 2
				{{0,1},{1,1},{2,1},{1,0}},	//ㅗ
				{{0,1},{1,0},{1,1},{1,2}},	//ㅓ
				{{0,0},{1,0},{2,0},{1,1}},	//ㅜ
				{{0,0},{0,1},{0,2},{1,1}},	//ㅏ
		};
		String[] str = br.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);
		int[][] arr = new int[n][m];
		for(int i=0; i<n; i++) {
			str = br.readLine().split(" ");
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(str[j]);
			}
		}
		int max = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				for(int b = 0; b<blocks.length; b++) {
					int temp = findMax(arr, blocks[b], i, j, max);
					if(temp == -1) {
						//System.out.println("Searching stops here : "+i+", "+j);
					}else {
						if(max < temp) {
							max = temp;
							System.out.print("갱신!! new max : "+max);
						}
						System.out.print("("+i+", "+j+")");
						getType(b);
					}
				}
			}
		}
		System.out.println(max);
	}
	
	@SuppressWarnings("finally")
	public static int findMax(int[][] arr, int[][] block, int i, int j, int max) throws IndexOutOfBoundsException {
		try {
			int sum = 0;
			for(int x = 0; x<block.length; x++) {
				sum += arr[i+block[x][1]][j+block[x][0]];
			}
			if(max < sum) max = sum;
			return max;
		} catch(IndexOutOfBoundsException e) {
			//System.out.println("Searching stops here : "+i+", "+j);
			return -1;
		}
	}

	public static void getType(int b) {
		String str = "";
		switch(b) {
		case 0:
			System.out.println("길쭉 가로");
			break;
		case 1:
			System.out.println("길쭉 세로");
			break;
		case 2:
			System.out.println("정사각형");
			break;
		case 3:
			System.out.println("ㄴ");
			break;
		case 4:
			System.out.println("ㄴ 반대");
			break;
		case 5:
			System.out.println("ㄱ");
			break;
		case 6:
			System.out.println("ㄱ 반대");
			break;
		case 7:
			System.out.println("세운 ㄹ");
			break;
		case 8:
			System.out.println("눕힌 ㄹ");
			break;
		case 9:
			System.out.println("ㅗ");
			break;
		case 10:
			System.out.println("ㅓ");
			break;
		case 11:
			System.out.println("ㅜ");
			break;
		case 12:
			System.out.println("ㅏ");
			break;
		}
	}
	
}
*/


import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[][][] blocks = {		//	[19][4][2]
				{{0,0},{1,0},{2,0},{3,0}},	//길쭉 가로
				{{0,0},{0,1},{0,2},{0,3}},	//길쭉 세로	
				{{0,0},{0,1},{1,0},{1,1}},	//정사각형
				{{0,0},{0,1},{0,2},{1,2}},	//갈고리 ver 1
				{{0,1},{1,1},{2,1},{2,0}},	//갈고리 ver 2
				{{0,0},{1,0},{1,1},{1,2}},	//갈고리 ver 3
				{{0,0},{1,0},{2,0},{0,1}},	//갈고리 ver 4
				{{0,2},{1,2},{1,1},{1,0}},	//갈고리rev ver 1
				{{0,0},{1,0},{2,0},{2,1}},	//갈고리rev ver 2
				{{0,0},{1,0},{0,1},{0,2}},	//갈고리rev ver 3
				{{0,0},{0,1},{1,1},{2,1}},	//갈고리rev ver 4
				{{0,0},{0,1},{1,1},{1,2}},	//뱀 ver 1
				{{0,1},{1,1},{1,0},{2,0}},	//뱀 ver 2
				{{1,0},{1,1},{0,1},{0,2}},	//뱀rev ver 1
				{{0,0},{1,0},{1,1},{2,1}},	//뱀rev ver 2
				{{0,1},{1,1},{2,1},{1,0}},	//ㅗ
				{{0,1},{1,0},{1,1},{1,2}},	//ㅓ
				{{0,0},{1,0},{2,0},{1,1}},	//ㅜ
				{{0,0},{0,1},{0,2},{1,1}}	//ㅏ
		};
		
		for(int del = 0; del<19; del++) { ///////////////////////
		String[] str = br.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);
		int[][] arr = new int[n][m];
		for(int i=0; i<n; i++) {
			str = br.readLine().split(" ");
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(str[j]);
			}
		}
		int max = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				for(int b = 0; b<blocks.length; b++) {
					    int temp = findMax(arr, blocks[b], i, j, max);
					    if(max < temp) max = temp;
					
				}
			}
		}
		bw.write(max+"\n");
		}//////////////////////////////////////////////////////
		bw.flush();
	}
	
	@SuppressWarnings("finally")
	public static int findMax(int[][] arr, int[][] block, int i, int j, int max) throws IndexOutOfBoundsException {
		try {
			int sum = 0;
			for(int x = 0; x<block.length; x++) {
				sum += arr[i+block[x][1]][j+block[x][0]];
			}
			if(max < sum) max = sum;
			return max;
		} catch(IndexOutOfBoundsException e) {
			return -1;
		}
	}
	
}