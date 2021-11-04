package dynamicarray;

import java.util.*;

/**
 * 
 * @author Agata Jelen
 *
 */
public final class DynamicArray {
	private int array[];
	private int size;

	// Constructor - setting initial values 
        
	public DynamicArray(int size) {
		//if size (the array length) is less than zero, throw a IllegalArgumentException 
		if (size < 0)
			throw new IllegalArgumentException(size + " - must be a positive integer");
		this.array = new int[size];
		this.size = 0;
	}

	// Constructor - setting default values 
        
	public DynamicArray() {
		this.array = new int[10];
		this.size = 0;
	}

	/* Copy constructor
	 * takes an object of type DynamicArray as a parameter;
	 * if the passed object is null, meaning that it does not point to a reference; an IllegalArgumentException is thrown
	 * 
	 */
	public DynamicArray(DynamicArray cpy) throws IllegalArgumentException {
		if (cpy == null)
			throw new IllegalArgumentException("there is a null Error!");
		
		array = copyOf(cpy.array);//the deep copy of an array
		size = cpy.size;
	}

	//getSize() returns the size of the array
	public int getSize() {
		return this.size;
	}

	/**
	 * since 'array' is a private field to our DynamicArray if we return it
	 * then the user has full access to manipulate 'array' which is not what we want.
	 * copying the items of 'array' to a new array
	 * @return the copied array
	 */
	public int[] toArray() {
		int[] copiedArray = new int[array.length];
            System.arraycopy(array, 0, copiedArray, 0, array.length);

		return copiedArray;
	}

	/**
	 * the push() method adds a new element to the end of the array and then increments the size field
	 * if the size is equal to the length of the array - meaning that the array is full
           to circumvent a OutOfBoundsException to be thrown we copy the items of 'array' to a new array doubled in length 
         * then  'array' references new array
	 * 
	 * if condition is false number will be added  to the end of the array 
	 * 
	 * @param num the item of the array to add
	 */
	public void push(int num) {
		int[] copiedArray = new int[2 * array.length];
		if (size == array.length) {
			for (int i = 0; i < copiedArray.length; i++) {
				if(i < size)
					copiedArray[i] = array[i];
			}
			array = copiedArray;
		}
		array[size] = num;
		size++;
	}

	// removes the last element of the array and returns it
	/**
	 * the pop() method removes the last element of the array and returns it
	 *
	 * if size is four times the size of the array length we shrink the array
	 * **copying the items of 'array' to a new array that is half the length**
	 * 
	 * to remove the array item, shift the items that are to right of the removed element to the left
	 * then we decrement size in order to keep a accurate record of populated data locations
	 * 
	 * @return the removed item of the array
	 * @throws RuntimeException if the array is empty
	 */
	public int pop() throws RuntimeException {
		int removedValue = array[size - 1];
		int[] copiedArray = new int[array.length / 2];
		
		if (empty() == true)
			throw new RuntimeException("The array is empty");
		
		if (size == 4 * array.length) {
			
                    System.arraycopy(array, 0, copiedArray, 0, copiedArray.length);
			
			array = copiedArray;
			
		}
		
		array[size - 1] = array[size + 1];//removing the last item of the array
		size--;

		return removedValue;// value removed from array
	}

	/**
	 * the get() method will return the element of the array at the specified ordinal value
	 * 
	 * @param index to look up
	 * @return that element at the specified index
	 * @throws IndexOutOfBoundsException if index is invalid
	 */
	public int get(int index) throws IndexOutOfBoundsException {
		if (index > array.length || index < 0)
			throw new IndexOutOfBoundsException("Illegal index: " + index);
		return array[index];
	}

	
	/**
	 * the indexOf() method will return the index of the first occurrence of key
	 * 
	 * @param key the value to look up in the array
	 * @return the index of key
	 */
	public int indexOf(int key) {
		for (int i = 0; i < size; i++) {
			if (array[i] == key)
				return i;// first occurrence of key, return the index
		}
		return -1;// return -1 if not found
	}

	// adds new element to array
	/**
	 * the add() method will add a bew element to the location of the array specified by index
	 * parameter. if the index is larger than the length of the array or is less than zero - 
	 * IndexOutOfBoundsException will be thrown. 
	 * 
	 * if the array is full, we will then have to copy all elements of the array to a new array
	 * that is doubled in length
	 * 
	 * When adding an element to the middle of the array we will have to shift all elements to the right
	 * in order to make room for the new element that is specified by num. 
	 * 
	 * @param index the specified location for num to be inserted
	 * @param num the element to be placed at the specified location
	 * @throws IndexOutOfBoundsException
	 */
	public void add(int index, int num) throws IndexOutOfBoundsException {
		int[] copiedArray = new int[array.length * 2];

		// if illegal index is posed
		if (index < 0 || index > array.length)
			throw new IndexOutOfBoundsException();

		// if array is full
		if (getSize() == array.length) {
                    System.arraycopy(array, 0, copiedArray, 0, size);
			array = copiedArray;
		}

		for (int j = 0; j < 1; j++) {
			int a = array[array.length - 1];
			int i;
			for (i = array.length - 1; i > index; i--)
				array[i] = array[i - 1];
			array[i] = a;
		}
		array[index] = num;
		size++;
	}

	// removes element at the specified index
	/**
	 * the remove() will remove the element at the specified position
	 * 
	 *  when the specified element is removed we will have to shifted all 
	 *  items of the array to the left to close the gap by the removed element. 
	 *  
	 *  if the specified index is less than zero or greater than the array's length
	 *  than a IndexOutOfBoundsException is thrown.
	 * 
	 *  we also need to check if the size is four times larger than the number
	 *  of occupied positions in the array - the capacity (size). 
	 *  	if this is true, we must shrink the array. We can achieve this if we copy
	 *  	the array to another with the length being divided by two.
	 * 
	 * @param index the item to be removed at the specified index
	 * @return the element that has been removed
	 * @throws IndexOutOfBoundsException
	 */
	public int remove(int index) throws IndexOutOfBoundsException {
		int[] copiedArray = new int[ 2 / array.length ];
		int remVal = array[index];
		// if illegal index is posed
		if (index < 0 || index >= array.length)
			throw new IndexOutOfBoundsException();

		// if size is four times
		if (size == 4 * array.length) {
                    System.arraycopy(array, 0, copiedArray, 0, copiedArray.length);
			array = copiedArray;
		}

		// shifting array to right
		// each item will be shifted by one to the right
		for (int j = index; j < array.length - 1; j++) {

			array[j] = array[j + 1];
		}

		size--;

		return remVal;
	}

	// returns true if array length is equal to 0
	//meaning there are no populated locations in the array
	public boolean empty() {
		return size == 0;
	}

	// organizes the array
	/**
	 * the sort() method will step through the entire array organizing it (sorting)
	 * we are switching elements of the array based on the condition if array[j] > array[i]
	 */
	public void sort() {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (array[j] > array[i]) {
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
	}

	// Fisher-Yates shuffle algorithm
	/**
	 * fisher yates shuffle algorithm that randomly places elements of an array
	 */
	public void shuffle() {
		Random rnd = new Random();
		for (int i = size - 1; i > 0; i--) {
			int index = rnd.nextInt(i) + 1;
			int a = array[index];
			array[index] = array[i];
			array[i] = a;
		}
	}

	// returns the smallest element in the array
	/**
	 * The findMin() method performs a Linear search of the array, meaning 
	 * the for-loop will step through the entire array, analyzing each element.
	 * the condition of the for-loop is only iterating over each populated locations of the array.
	 * 
	 * Through each iteration we are comparing each element of the array to the first.
	 * if this element is less than min (a localized variable) we re-bind min to that element.
	 * in turn finding the smallest value of the array.
	 * 
	 * @return the smallest element of the array
	 * @throws RuntimeException
	 */
	public int findMin() throws RuntimeException {
		int min = array[0];
		for (int i = 0; i < size; i++) {
			if (array[i] < min)
				min = array[i];
		}
		return min;
	}

	// returns the largest element in the array
	/**
	 * 
	 * the findMax() method will return the largest element of the array
	 * this method performs the same algorithm as the findMin() method. 
	 * The only difference is that the predicate of the branching statement is 
	 * different. Instead of finding if each element is less than the first, we 
	 * are finding if it is greater.
	 * 
	 * @return the largest element of the array
	 * @throws RuntimeException
	 */
	public int findMax() throws RuntimeException {
		int max = array[0];
		for (int i = 0; i < size; i++) {
			if (array[i] > max)
				max = array[i];
		}
		return max;
	}

	// returns the array as an sequence of comma separated values
	/**
	 * the toString() method will return the array as a comma separated sequence of characters
        * @return 
	 */
	@Override
	public String toString() {

		String values = "";
		for (int i : array) {
			values += i + ", ";
		}

		return values;
	}

	// compares two objects - element by element to determine if they are the same
	/**
	 * the equals() method compares two objects element by element to determine if they are the same
	 * 
	 * @param obj object to compare
	 * @return boolean value, indicating if the objects are equal
	 */
	public boolean equals(DynamicArray obj) {
		if (size != obj.size) {
			return false;
		}

		for (int i = 0; i < array.length; i++) {
			if (array[i] != obj.array[i]) {
				return false;
			}
		}
		return true;
	}

	/**
	 * The copyOf() method will perform a 'deep copy' of the array that is associated with the object
	 * that is passed to our copy constructor.
	 * 
	 * This method will simply copy the elements of 'origin' to a new array that will be returned
	 * 
     * @param origin
	 * @return the new array
	 * @throws IllegalArgumentException if the new length is less the zero or the passed array is referencing null
	 */
	public int[] copyOf(int[] origin) throws IllegalArgumentException {
		
		if (origin == null)
			throw new IllegalArgumentException("source object points to null");
		
		int[] copy = new int[origin.length];
		
            System.arraycopy(origin, 0, copy, 0, origin.length);
		
		return copy;
		
	}

}
