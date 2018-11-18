import java.util.Arrays;
public class Heap<E extends LexographicCompare<E>> {
	private static final int CAPACITY = 2;
	E[] array;
	int size;
	public Heap(E[] e) {
		array = e.clone();
		
	}
	public Heap() {
		array= (E[])new Comparable[CAPACITY];
		size = 0;
	}
	
	public void add(E value) {
		if(size>= array.length) array = resize();
		
		size++;
		int index = size;
		array[index] = value;
		
		upBubble();
		
	}
	
	
	
	public E peek() {
		if(this.isEmpty()) throw new IllegalStateException();
		
		return array[1];
	}
	
	public E remove() {
		E result = peek();
		
		array[1] = array[size];
		array[size] = null;
		size--;
		
		downBubble();
		
		return result;
		
	}
	
	public String toString() {
	return Arrays.toString(array); 
	}
	/*
	 * Bubbles
	 */ 
	void downBubble() { 
		int index =1;
		
		while(hasLeftChild(index)) {
			int smallerChild = leftIndex(index);
			
			if(hasRightChild(index) && array[leftIndex(index)].compareTo(array[rightIndex(index)]) > 0) {
				smallerChild = rightIndex(index);
			}
			//parent is higher on keys than child
			if (array[index].compareTo(array[smallerChild]) > 0) {
                swap(index, smallerChild);
            } else {
                break;
            }
			index = smallerChild;
		}
	}
	private void upBubble() {
		int index = this.size;
		
		while(hasParent(index) && (parent(index).compareTo(array[index]) > 0)) {
			swap(index, parentIndex(index));
			index = (int) parentIndex(index);
		}
	}
	 
/*
 * return indexes of whatever
 */
	

	private int rightIndex(int index) {
		return index*2+1;
	}

	private int leftIndex(int index) {
		return index*2+2;
	}
	private int parentIndex(int index) {
		return index/2;
	}
/*
 * boolean has__________* methods
 */
	private boolean hasLeftChild(int index) {
		return leftIndex(index) <= size;
	}
	private boolean hasRightChild(int index) {
				return rightIndex(index) <=size;
	}
	private boolean hasParent(int index) {
		return index>1;
	}
	public boolean isEmpty() {
		return size==0;
	}

	
	/*
	 * misc
	 */
	private E parent(int index) {
		return array[parentIndex(index)];
	}

	private void swap(int index, int parentIndex) {
		E tmp = array[index];
		array[index] = array[parentIndex];
		array[parentIndex] = tmp;
	}
	
	

	private E[] resize() {
		return Arrays.copyOf(array, array.length*2);
	}



	

	

}
