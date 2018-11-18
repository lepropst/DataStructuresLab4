import java.util.ArrayList;

public class HeapSort extends LexographicCompare {
	String[] arrayA;
	Heap<String> curHeap;
	public HeapSort(ArrayList<String> array) {
		arrayA = new String[array.size()];
		arrayA = 
		curHeap = array.toArray(new String[array.size()]);
	}

}
