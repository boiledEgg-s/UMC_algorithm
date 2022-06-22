package tastyFoodByDoYoung_2961;

import java.util.*;
import java.io.*;

public class Main {

	static int min = Integer.MAX_VALUE;
	
	//arr=입력값 배열, cur=누적 계산값, bounds=시작 인덱스
	public static void tasteDiff(ArrayList<int[]> arr, int[] cur, int bounds) {
		if(bounds == arr.size() || min == 0) {		//포함되는 첫 요소의 인덱스 > 입력값의 수 || 맛 차이의 최솟값
			return;		
		}
		for(int i = bounds; i<arr.size(); i++) {
			int[] temp = {arr.get(i)[0],arr.get(i)[1]};		
			temp[0] = cur[0]*temp[0];
			temp[1] = cur[1]+temp[1];
			int minTemp = (int)Math.abs(temp[0]-temp[1]);
			if(min > minTemp) min = minTemp;
			//System.out.println("bounds:"+bounds+" "+"min="+min+" ---temp{"+temp[0]+", "+temp[1]+"}"+" ---cur{"+cur[0]+", "+cur[1]+"}");
			tasteDiff(arr, temp, i+1);
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ArrayList<int[]> arr = new ArrayList<>();
		for(int i = 0; i<n; i++) {
			String[] str = br.readLine().split(" ");
			arr.add(new int[]{Integer.parseInt(str[0]),Integer.parseInt(str[1])});
		}
		
		tasteDiff(arr, new int[] {1,0}, 0);
		//System.out.println(arr.get(1)[1]);
		System.out.println(min);
	}
}
