package sharkAndFireStorm_20058;

import java.io.*;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int l = Integer.parseInt(str[1]);

		n = (int) Math.pow(2, n);
		int[][] map = new int[n][n];
		for (int i = 0; i < n; i++) {
			str = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(str[j]);
			}
		}

		int ans1 = 0, ans2 = 0;
		str = br.readLine().split(" ");
		for (int i = 0; i < l; i++) {
			map = rotateMap(map, Integer.parseInt(str[i]), n);
			ans1 = meltingIce(map, n);
		}
		int temp = 0;
		for (int k = 0; k < n; k++) {
			for (int j = 0; j < n; j++) {
				temp = findLargest(copyArr(map, map.length), j, k, -1);
				if (temp != 0)
					System.out.println();
				if (ans2 < temp)
					ans2 = temp;
			}
			if (ans2 == n * n)
				break;
		}

		for (int k = 0; k < n; k++) {
			for (int j = 0; j < n; j++) {
				System.out.print(map[k][j] + " ");
			}
			System.out.println();
		}

		System.out.println(ans1 + " " + ans2);
	}

	public static int[][] rotateMap(int[][] map, int l, int n) {
		int len = (int) Math.pow(2, l);
		int[][] temp = new int[n][n];
		for (int h = 0; h < n; h += len) {
			for (int i = 0; i < n; i += len) {
				for (int j = 0; j < len; j++) {
					for (int k = 0; k < len; k++) {
						temp[h + k][i + len - 1 - j] = map[h + j][i + k];
					}
				}
			}
		}
		return temp;
	}

	public static int meltingIce(int[][] map, int n) {
		int[][] check = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
		int total = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int count = 0;
				for (int[] k : check) {
					try {
						if (map[i + k[0]][j + k[1]] != 0)
							count++;
					} catch (ArrayIndexOutOfBoundsException e) {
						continue;
					}
				}
				if (count < 3)
					map[i][j]--;
				if (map[i][j] > 0)
					total += map[i][j];
			}
		}
		return total;
	}

	public static int findLargest(int[][] map, int x, int y, int index) {
		if (map[y][x] <= 0)
			return 0;
		else {
			int[][] check = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
			int total = 1;
			for (int k=0; k<check.length; k++) {
				try {
					if(k == index) continue;
					total += findLargest(map, x + check[k][1], y + check[k][0], k);
					map[y + check[k][0]][x + check[k][1]] = 0;
				} catch (ArrayIndexOutOfBoundsException e) {
					continue;
				}
			}
			return total;
		}
	}

	public static int[][] copyArr(int[][] arr, int n) {
		int[][] temp = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				temp[i][j] = arr[i][j];
			}
		}
		return temp;
	}
}
