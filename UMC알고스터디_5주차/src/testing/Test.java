package testing;


public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "94864";
		StringBuffer s = new StringBuffer(str);
		int num = Integer.parseInt(str);
		int revNum = Integer.parseInt(s.reverse().toString());
		System.out.println(Math.sqrt(num));
		System.out.println(Math.pow((int)Math.sqrt(num),2));
		if(Math.pow((int)Math.sqrt(num),2) == num)
			System.out.println("제곱수이다");
		else 
			System.out.println("제곱수가 아니다");
		System.out.println("----------reverse------------\n");
		System.out.println(revNum);
		System.out.println(Math.sqrt(revNum));
		System.out.println(Math.pow((int)Math.sqrt(revNum),2));
		if(Math.pow((int)Math.sqrt(revNum),2) == revNum)
			System.out.println("제곱수이다");
		else 
			System.out.println("제곱수가 아니다");
	}

}


/*
public class Main {
	static int min = Integer.MAX_VALUE;
	static int count  = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//int n = 5;//Integer.parseInt(br.readLine());
		String[][] str1 = {
				{"0", "3", "1", "1", "1"}, 
				{"3", "0", "1", "1", "1"}, 
				{"1", "1", "0", "1", "1"}, 
				{"1", "1", "1", "0", "1"},
				{"1", "1", "1", "1", "0"}
		};
		
		String[][] str2 = {
				{"0", "1", "2", "3", "4", "5"},
				{"1", "0", "2", "3", "4", "5"},
				{"1", "2", "0", "3", "4", "5"},
				{"1", "2", "3", "0", "4", "5"},
				{"1", "2", "3", "4", "0", "5"},
				{"1", "2", "3", "4", "5", "0"}
		};
		
		String[][] str = {
				{"0", "5", "4", "5", "4", "5", "4", "5"}, 
				{"4", "0", "5", "1", "2", "3", "4", "5"}, 
				{"9", "8", "0", "1", "2", "3", "1", "2"}, 
				{"9", "9", "9", "0", "9", "9", "9", "9"},
				{"1", "1", "1", "1", "0", "1", "1", "1"},
				{"8", "7", "6", "5", "4", "0", "3", "2"},
				{"9", "1", "9", "1", "9", "1", "0", "9"},
				{"6", "5", "4", "3", "2", "1", "9", "0"}
		};
		int n = str.length;
		// 능력치 테이블 초기화
		int[][] arr = new int[n][n];
		int[] link = new int[n];
		int[] start = new int[n];
		for (int i = 0; i < n; i++) {
			String[] strr = str[i];
			link[i] = 1;
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(strr[j]);
			}
		}
		findMin(arr, n, link, start, 0);
		System.out.println(min);
		
	}
	
	public static void findMin(int[][] arr, int arrSize, int[] link, int[] start, int bound) {
		if(bound >= arrSize/2 || min==0) {
			return;
		}
		for(int i=bound; i<arrSize; i++) {
			int[] ltemp = Arrays.copyOf(link, arrSize);
			int[] stemp = Arrays.copyOf(start, arrSize);
			ltemp[i] = 0; 
			stemp[i] = 1;
			int l = tableCalculate(arr, ltemp,arrSize);
			int s = tableCalculate(arr, stemp,arrSize);
			int diff = Math.abs(l-s);
			if(diff < min) min = diff;
			findMin(arr, arrSize, ltemp, stemp, bound+1);
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
*/