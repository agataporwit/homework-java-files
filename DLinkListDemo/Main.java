package DLinkListDemo;

/**
@author: Agata Jelen CSD 143
Assignment number 7
create a generic doubly linked list that includes the following:
A private class Node. This class should describe a single node in a doubly linked list
A no-arg constructor
public boolean isEmpty()
public int size()
public void add(T e)
public void add( int index, T element)
public String toString()
public T remove( int index )
public Boolean remove( T elem )
*/

public class Main {

    public static void main(String[] args) {
        System.out.println("Test Number 1");
        DLinkedList ll = new DLinkedList();
        //**** From CodeListing 20-5 *****
        ll.add("Amy");
        ll.add("Bob");
        ll.add(0, "Agata");
        ll.add(2, "Beth");
        ll.add(4, "Carol");
        System.out.println("\nList Elements: ");
        System.out.println(ll);

        // Test 2
        System.out.println("\nTest number 2");
        System.out.println("Add Anna!! as the first element of the list : \n");
        //test push( T elem ) method --add elem as the first element of the list (add name "Anna" to the top of the list)
        ll.push("Anna!!");
        System.out.println(ll); // Out put
        System.out.println("Pop");
        System.out.println(" Good Bye "+ll.pop()+"!!");//test pop() method. Remove and return the first element of the list ( remove " Anna" out of the list)
        System.out.println("\nCurrent list : \n"+ll);

        // Test 3
        System.out.println("\nTest number 3");
        System.out.println("Adding Name Elena!! as the last element of the list : ");
        //test enqueue( T elem ) method -- add add elem as the last element of the list ( add name "Elena" to the last of list)
        ll.enqueue("Elena !!");
        System.out.println(ll);// out put
        System.out.println("Remove first Element ");
        //test dequeue() method (remove and return the first element of the list)
        System.out.println("Good Bye "+ll.dequeue()+"!!");
        System.out.println("\nCurrent list :\n"+ll);


    }

}
