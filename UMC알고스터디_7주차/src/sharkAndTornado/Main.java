/*
package sharkAndTornado;

import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] map = new int[n][n];
		for (int i = 0; i < n; i++) {
			String[] str = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(str[j]);
			}
		}

		int[] x = { n / 2, n / 2 };
		int[] y = { n / 2, n / 2 - 1 };
		int num = 1;
		int res = 0;
		int temp = 0;

		while (true) {
			try {
				for (int i = 0; i < 2; i++) {
					int[] dir = { y[0] - x[0], y[1] - x[1] };
					for (int j = 0; j < num; j++) {
						temp = transportSand(map, x, y);
						res += temp;
						x = y;
						y = new int[] { y[0] + dir[0], y[1] + dir[1] };
						
						for(int s = 0; s<n; s++) {
							for(int t = 0; t<n; t++) {
								System.out.print(map[s][t]+ " ");
							}
							System.out.println();
						}
						System.out.println("cur : ("+(x[1]+1)+","+(x[0]+1)+") lost : "+temp+" total : "+res+"\n");
					}
					if (dir[0] == 1) {
						y = new int[] { x[0], x[1] + 1 };
					} else if (dir[0] == -1) {
						y = new int[] { x[0], x[1] - 1 };
					} else if (dir[1] == 1) {
						y = new int[] { x[0] - 1, x[1] };
					} else if (dir[1] == -1) {
						y = new int[] { x[0] + 1, x[1] };
					}
				}
				num++;
			} catch (IndexOutOfBoundsException e) {
				System.out.println(y[0] + " " + y[1]);
				break;
			}
		}

		System.out.println(res);
	}

	// 모래를 운반하는 함수
	public static int transportSand(int[][] map, int[] x, int[] y) {
		int[][] right = { { 1, -1 }, { -1, -1 }, { 2, 0 }, { -2, 0 }, { 0, 2 }, { 1, 0 }, { -1, 0 }, { 1, 1 },
				{ -1, 1 }, { 0, 1 } };
		int[][] down = { { -1, 1 }, { -1, -1 }, { 0, 2 }, { 0, -2 }, { 2, 0 }, { 0, 1 }, { 0, -1 }, { 1, 1 }, { 1, -1 },
				{ 1, 0 } };
		int[] percent = { 1, 1, 2, 2, 5, 7, 7, 10, 10 };

		int[] diff = { y[0] - x[0], y[1] - x[1] };
		int lost = 0;
		int total = 0;
		int init = map[y[0]][y[1]]; // y에 있는 모래의 양
		int i = 0;
		if (diff[1] != 0) { // 오른쪽으로 이동
			if (diff[1] == 1)
				System.out.println("right");
			else if (diff[1] == -1)
				System.out.println("left");
			for (; i < percent.length; i++) {
				try {
					total += init * percent[i] / 100;
					map[y[0] + diff[1] * right[i][0]][y[1] + diff[1] * right[i][1]] += init * percent[i] / 100;
					// System.out.println(map[y[0] + diff[1] * right[i][0]][y[1] + diff[1] *
					// right[i][1]]);
				} catch (ArrayIndexOutOfBoundsException e) {
					lost += init * percent[i] / 100;
					continue;
				}
			}
			try {
				map[y[0] + diff[1] * right[i][0]][y[1] + diff[1] * right[i][1]] += init - total;
			} catch (ArrayIndexOutOfBoundsException e) {
				lost += init - total;
			}
		} else if (diff[0] != 0) { // 아래로 이동
			if (diff[0] == 1)
				System.out.println("down");
			else if (diff[0] == -1)
				System.out.println("up");
			for (; i < percent.length; i++) {
				try {
					total += init * percent[i] / 100;
					map[y[0] + diff[0] * down[i][0]][y[1] + diff[0] * down[i][1]] += init * percent[i] / 100;
				} catch (ArrayIndexOutOfBoundsException e) {
					lost += init * percent[i] / 100;
					continue;
				}
			}
			try {
				map[y[0] + diff[0] * down[i][0]][y[1] + diff[0] * down[i][1]] += init - total;
			} catch (ArrayIndexOutOfBoundsException e) {
				lost += init - total;
			}
		}
		map[y[0]][y[1]] = 0;
		return lost;
	}

}
*/
package sharkAndTornado;

import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] map = new int[n][n];
		for (int i = 0; i < n; i++) {
			String[] str = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(str[j]);
			}
		}

		int[] x = { n / 2, n / 2 };
		int[] y = { n / 2, n / 2 - 1 };
		int num = 1;
		int res = 0;
		int temp = 0;

		while (true) {
			try {
				for (int i = 0; i < 2; i++) {
					int[] dir = { y[0] - x[0], y[1] - x[1] };
					for (int j = 0; j < num; j++) {
						temp = transportSand(map, x, y);
						res += temp;
						x = y;
						y = new int[] { y[0] + dir[0], y[1] + dir[1] };
					}
					if (dir[0] == 1) {
						y = new int[] { x[0], x[1] + 1 };
					} else if (dir[0] == -1) {
						y = new int[] { x[0], x[1] - 1 };
					} else if (dir[1] == 1) {
						y = new int[] { x[0] - 1, x[1] };
					} else if (dir[1] == -1) {
						y = new int[] { x[0] + 1, x[1] };
					}
				}
				num++;
			} catch (IndexOutOfBoundsException e) {
				break;
			}
		}

		System.out.println(res);
	}

	// 모래를 운반하는 함수
	public static int transportSand(int[][] map, int[] x, int[] y) {
		int[][] right = { { 1, -1 }, { -1, -1 }, { 2, 0 }, { -2, 0 }, { 0, 2 }, { 1, 0 }, { -1, 0 }, { 1, 1 },
				{ -1, 1 }, { 0, 1 } };
		int[][] down = { { -1, 1 }, { -1, -1 }, { 0, 2 }, { 0, -2 }, { 2, 0 }, { 0, 1 }, { 0, -1 }, { 1, 1 }, { 1, -1 },
				{ 1, 0 } };
		int[] percent = { 1, 1, 2, 2, 5, 7, 7, 10, 10 };

		int[] diff = { y[0] - x[0], y[1] - x[1] };
		int lost = 0;
		int total = 0;
		int init = map[y[0]][y[1]]; // y에 있는 모래의 양
		int i = 0;
		if (diff[1] != 0) { // 오른쪽으로 이동
			for (; i < percent.length; i++) {
				try {
					total += init * percent[i] / 100;
					map[y[0] + diff[1] * right[i][0]][y[1] + diff[1] * right[i][1]] += init * percent[i] / 100;
				} catch (ArrayIndexOutOfBoundsException e) {
					lost += init * percent[i] / 100;
					continue;
				}
			}
			try {
				map[y[0] + diff[1] * right[i][0]][y[1] + diff[1] * right[i][1]] += init - total;
			} catch (ArrayIndexOutOfBoundsException e) {
				lost += init - total;
			}
		} else if (diff[0] != 0) { // 아래로 이동
			for (; i < percent.length; i++) {
				try {
					total += init * percent[i] / 100;
					map[y[0] + diff[0] * down[i][0]][y[1] + diff[0] * down[i][1]] += init * percent[i] / 100;
				} catch (ArrayIndexOutOfBoundsException e) {
					lost += init * percent[i] / 100;
					continue;
				}
			}
			try {
				map[y[0] + diff[0] * down[i][0]][y[1] + diff[0] * down[i][1]] += init - total;
			} catch (ArrayIndexOutOfBoundsException e) {
				lost += init - total;
			}
		}
		map[y[0]][y[1]] = 0;
		return lost;
	}

}

