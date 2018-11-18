import java.util.ArrayList;
import java.util.Scanner;

public class Lab4 {
	int sequenceSize;
	ArrayList<String> array = new ArrayList<>();
	public static void main(String[] args) {
		new Lab4();
	}
	public Lab4() {
		Scanner scan = new Scanner(System.in);
		String s = scan.nextLine();
		//try to parse first line to an int, if you cannot return error and quit.
		try {
			sequenceSize = Integer.parseInt(s.trim());
			System.out.println("Sequence size " + sequenceSize);
		} catch(Exception e) {
			System.out.println("Please input valid number for size of input");
			
		}
		/*
		 * add each line to arraylist starting at index 0
		 */
		for(int i=0; i<sequenceSize; i++) {
			s = scan.nextLine();
			array.add(s);
		}
		new HeapSort(array);
		//print the array
		for(int i=0; i<sequenceSize; i++) {
			System.out.println(array.get(i) + " input " + i);
		}
		
	}
}

