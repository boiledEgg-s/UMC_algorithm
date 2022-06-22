package sharkAndRain_21610;

import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);
		int[][] map = new int[n][n];
		byte[][] cloud = new byte[n][n];
		// map 초기화
		for (int i = 0; i < n; i++) {
			str = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(str[j]);
			}
		}

		cloud[n - 1][0] = 1;
		cloud[n - 1][1] = 1;
		cloud[n - 2][0] = 1;
		cloud[n - 2][1] = 1;
		while ((m--) > 0) {
			str = br.readLine().split(" ");
			int[] move = { Integer.parseInt(str[0]), Integer.parseInt(str[1]) };
			cloud = moveCloudAndPour(map, cloud, move, n);
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (cloud[i][j] == 1) {
						copyingSkill(map, i, j);
					}
				}
			}
			initCloud(map, cloud, n);
		}

		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				count += map[i][j];
			}
		}
		System.out.println(count);
	}

	// 구름 이동
	public static byte[][] moveCloudAndPour(int[][] map, byte[][] cloud, int[] movement, int n) {
		int[][] move = { { 0, 0 }, { -1, 0 }, { -1, -1 }, { 0, -1 }, { 1, -1 }, { 1, 0 }, { 1, 1 }, { 0, 1 },
				{ -1, 1 } };
		byte[][] temp = new byte[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (cloud[i][j] == 1) {
					int x = (j + move[movement[0]][0] * movement[1]) % n;
					int y = (i + move[movement[0]][1] * movement[1]) % n;
					if (y < 0)
						y = n + y;
					if (x < 0)
						x = n + x;
					map[y][x]++;
					temp[y][x] = 1;
				}
			}
		}
		return temp;
	}

	// 비구름 초기화
	public static void initCloud(int[][] map, byte[][] cloud, int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] >= 2 && cloud[i][j] == 0) {
					map[i][j] -= 2;
					cloud[i][j] = 1;
				} else {
					cloud[i][j] = 0;
				}
			}
		}
	}

	// 4번 요구사항 물 복사 스킬
	public static void copyingSkill(int[][] map, int r, int c) {
		int[][] check = { { -1, -1 }, { -1, 1 }, { 1, 1 }, { 1, -1 } };
		for (int i = 0; i < 4; i++) {
			try {
				if (map[(r + check[i][1])][(c + check[i][0])] > 0) {
					map[r][c]++;
				}
			} catch (IndexOutOfBoundsException e) {
				continue;
			}
		}
	}
}
