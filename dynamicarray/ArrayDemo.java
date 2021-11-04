package dynamicarray;

/**
 *
 * @author agata jelen 
 */
public class ArrayDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		/**
		 * the first tests of the original array and the copied array 
		 * are proving that they are both pointing to two different objects.
		 */
		
		//FIRST ARRAY - NOT COPIED
		DynamicArray array1 = new DynamicArray();
		
		array1.push(5);
		array1.push(4);
		array1.push(3);
		array1.push(2);
		array1.push(51);
		
		System.out.println("The first array test - NOT COPIED YET");
		System.out.println("-------------------");
		System.out.println(array1.toString());
		System.out.println("-------------------\n");

		System.out.println("The first array's size is: " + array1.getSize());
		array1.add(3, 5);
		array1.add(5, 10);
		System.out.println("the element at ordinal value of three is: " + array1.get(3));
		System.out.println("The value of four is located at ordinal " + array1.indexOf(4));

		array1.shuffle();
		System.out.println("the size of the array is now " + array1.getSize());
		System.out.println("\nFirst array: testing");
		System.out.println(array1.toString());

		System.out.println();
		
		//SECOND ARRAY - COPIED
		DynamicArray array2 = new DynamicArray(array1);
		System.out.println("\nThe first array - COPIED");
		System.out.println("-------------------");
		System.out.println(array2.toString());
		System.out.println("-------------------\n");

		//if you remove this for-statement you will see the length of the array shrink by half: 2 / array.length
		//this is proving that i am successfully copying the array to another at which length is half
		for(int i = 0 + 1; i < 40; i++) {
			array2.push(i);
			if(i > 300)
				array2.pop();
		}
				
		System.out.println("The length of the second (copied) array: " + array2.toArray().length);
		System.out.println("\nSecond array: test");
		
		//here i am showing that in-fact these two references are pointing to different objects
		System.out.println("array: " + array1.toString());
		
		System.out.println("copied array: " + array2.toString());
		
		System.out.println();

		System.out.println("The second array's size (after removing an element) is: " + array2.getSize());
		
		//Throwing exceptions
		try {
			//null reference
			DynamicArray nullReference = null;
			
			DynamicArray noReference = new DynamicArray(nullReference);//throws IllegalArgumentException
			noReference.toString();
			
			//negative argument passed to constructor
			DynamicArray array3 = new DynamicArray(-7);//throw IllegalArgumentException
			System.out.println(array3.getSize());
			
			//out of bounds Exception
			DynamicArray array4 = new DynamicArray();
			array4.get(-5);
			array4.add(-5, 2);
			array4.remove(-2);
			int[] a = null;
			array4.copyOf(a);
			array4.pop();
			
			
		}catch(Exception e) {
			System.err.println("\n"+e.getMessage());
		}
	}

}