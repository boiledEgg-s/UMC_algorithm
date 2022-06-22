package ecology_4358;
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Scanner sc = new Scanner(System.in);
		int count = 0;
		HashMap<String, Integer> trees = new HashMap<>();
		ArrayList<String> names = new ArrayList<>();
		/*
		String[] str1 = {
				"Red Alder",
				"Ash",
				"Aspen",
				"Basswood",
				"Ash",
				"Beech",
				"Yellow Birch",
				"Ash",
				"Cherry",
				"Cottonwood",
				"Ash",
				"Cypress",
				"Red Elm",
				"Gum",
				"Hackberry",
				"White Oak",
				"Hickory",
				"Pecan",
				"Hard Maple",
				"White Oak",
				"Soft Maple",
				"Red Oak",
				"Red Oak",
				"White Oak",
				"Poplan",
				"Sassafras",
				"Sycamore",
				"Black Walnut",
				"Willow"
		};
		*/
		//for(int i = 0; i<str1.length; i++) {
		while(sc.hasNext()) {
			String str = sc.nextLine();
			//String str = str1[i];
			count++;
			if(!trees.containsKey(str)) {
				trees.put(str, 1);
				names.add(str);
			}
			else trees.replace(str, trees.get(str)+1);
		}
		Collections.sort(names);
		
		for(int i = 0; i<names.size(); i++) {
			System.out.printf("%s %.4f\n", names.get(i),((double)trees.get(names.get(i))/count*100));
		}
	}
}
