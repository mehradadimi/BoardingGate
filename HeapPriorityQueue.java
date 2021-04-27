
/*
* HeapPriorityQueue.java
*
* An implementation of a minimum PriorityQueue using a heap.
* based on the implementation in "Data Structures and Algorithms
* in Java", by Goodrich and Tamassia
*
* This implementation will throw a Runtime, HeapEmptyException
*	if the heap is empty and removeLow is called.
*
* This implementation will throw a Runtime, HeapFullException
*	if the heap is full and insert is called.
*
*/

public class HeapPriorityQueue implements PriorityQueue {

	protected final static int DEFAULT_SIZE = 10000;

	protected Comparable[] storage;
	protected int currentSize;

	/*
	 * Constructor that initializes the array to hold DEFAULT_SIZE elements
	 */
	public HeapPriorityQueue() {
		int size = DEFAULT_SIZE+1;
		storage = new Comparable[size];
		currentSize = 0;
	}
	
	/*
	 * Constructor that initializes the array to hold size elements
	 */
	public HeapPriorityQueue(int size) {
		size = size + 1;
		storage = new Comparable[size];
		currentSize = 0;
	}


	/*
	 * PURPOSE:
	 *	Adds element into the PriorityQueue at the position
	 *	according to the element's priority 	.
	 *
	 * PRECONDITIONS:
	 *	None.
	 *
	 * RETURNS:
	 *	None.
	 *
	 * Examples:
	 * 	If q contains elements that would be accessed in the
	 * 	following order:  {5,13,21} after q.insert(20) returns,
	 * 	then q will contain elements that will be accessed
	 * 	in the following order: {5,13,20,21}.
	 * // 5,13,21,20
	 */



/*	public void insert ( Comparable element) throws HeapFullException {
		//TODO: Implement this
		if(currentSize == storage.length) {
			throw new HeapFullException();
		} else if (currentSize == 0){
			storage[0] = element;
			currentSize++;
//		}else if (currentSize == 1){
//			storage[currentSize] = element;
//			currentSize++;
//			if (storage[1].compareTo(storage[0]) < 0 ){
//				Comparable value = storage[1];
//				storage[1] = storage[0];
//				storage[0] = value;
//			}
		}else{
			//System.out.println(isAscendingOrder(0,currentSize-1) + "IS AS");
			storage[currentSize] = element;
			currentSize++;
			if (currentSize > 1){
				if(!isAscendingOrder(0,currentSize-1)){
					changeTheOrder(currentSize-1);
				}
			}
		}

	}*/

	/*public void changeTheOrder (int size){
		if(size == 0){
			return;
		}else{
			if (storage[size].compareTo(storage [size-1]) < 0){
				swapPlaces(size);
				changeTheOrder(size-1);
			}
		}
	}
*/

	/*public boolean isAscendingOrder(int i, int size){
		if (i==size){
			return true;
		}
			return storage[i+1].compareTo( storage[i]) > 0 && isAscendingOrder(i+1,size) ;
	}*/


	public void swapPlaces(int index, int index2){
		Comparable rightOne = storage[index];
		Comparable leftOne = storage[index2];
		storage[index] = leftOne;
		storage[index2] = rightOne;
	}

	// ***IMPORTANT***  Code written with the help of code from Mr. Anthony Estey's class.
	public void insert ( Comparable element) throws HeapFullException {
		//TODO: Implement this
		int length = storage.length;
		if (currentSize + 1 == length) {
			throw new HeapFullException();
		} else {
			storage[++currentSize] = element;
			bubbleUp(currentSize);
		}
	}

// ***IMPORTANT***  Code written with the help of code from Mr. Anthony Estey's class.
	private void bubbleUp(int ind) {
		if (ind <= 1){
			return;
		}else {
			if (storage[ind / 2].compareTo(storage[ind]) > 0) {
				swapPlaces(ind, ind / 2);
				bubbleUp(ind / 2);
			}
		}
	}


// ****IMPORTANT***  Code sourced from Mr.Anthony's class.
	public Comparable removeMin() throws HeapEmptyException {

		if (isEmpty() == true){
			throw new HeapEmptyException();
		}else{
			Comparable minimum = storage[1];
			swapPlaces(1,currentSize);
			storage[currentSize] = null;
			currentSize--;
			bubbleDown(1);
			return minimum;
		}
	}

// ****IMPORTANT***  Code sourced from Mr.Anthony's class.
	private void bubbleDown(int ind) {
		if (isLeaf(ind) == true){
		}else{
			int smallChild  = smallestChild(ind);
			if (storage[smallChild].compareTo(storage[ind]) < 0) {
				swapPlaces(ind, smallChild);
				bubbleDown(smallChild);
			}
		}
	}


	private boolean isLeaf(int ind) {
		int lastIndex = currentSize;
		int child = ind * 2;
		if (child > lastIndex){
			return true;
		}else if (storage[ind*2] == null && storage[ind*2+1] == null){
			return true;
		}
		return false;
	}

	private int smallestChild(int ind) {
		if (storage[ind*2+1] == null){
			return ind*2;
		}else if (storage[ind*2] == null){
			return (ind*2+1);
		}else{
			if (storage[ind*2+1].compareTo(storage[ind*2]) < 0){
				return ind*2+1;
			}
			return ind*2;
		}

	}


	public boolean isEmpty(){
		if (currentSize == 0){
			return true;
		}
		return false;
	}
	
	public int size () {

		return currentSize; // so it compiles
	}

	public String toString() {
		String s = "";
		String sep = "";
		for(int i=0;i<currentSize;i++) {
			s += sep + storage[i];
			sep = " ";
		}
		return s;
	}

}
