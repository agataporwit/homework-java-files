package DLinkListDemo;

import java.util.EmptyStackException;

/**
@author: Agata Jelen CSD 143
Assignment number 7
create a generic doubly linked list that includes the following:
•	A private class Node. This class should describe a single node in a doubly linked list
•	A no-arg constructor
•	public boolean isEmpty()
•	public int size()
•	public void add(T e)
•	public void add( int index, T element)
•	public String toString()
•	public T remove( int index )
•	public Boolean remove( T elem )
*/

class DLinkedList<T>{
    /**
     The Node class stores a list element and a reference to the next node.
     */
    private class Node<T>
    {
        T value;   // Value of a list element
        Node<T> next;      // Next node in the list
        Node<T> prev;      // Previous element in the list

        /**
         Constructor.
         @param val The element to be stored in the node.
         @param n The reference to the successor node.
         @param p The reference to the predecessor node.
         */

        Node(T val, Node<T> n, Node<T> p)
        {
            value = val;
            next = n;
            prev = p;
        }

        /**
         Constructor.
         @param val The element to be stored in the node.
         */

        Node(T val)
        {
            // Just call the other (sister) constructor
            this(val, null, null);
        }
    }

    private Node first;   // Head of the list
    private Node last;    // Last element on the list

    /**
     Constructor.
     */

    public DLinkedList()
    {
        first = null;
        last = null;
    }

    /**
     The isEmpty method checks to see if the list is empty.
     @return true if list is empty, false otherwise.
     */

    public boolean isEmpty()
    {
        return first == null;
    }

    /**
     The size method returns the length of the list.
     @return The number of elements in the list.
     */

    public int size()
    {
        int count = 0;
        Node p = first;
        while (p != null)
        {
            // There is an element at p
            count ++;
            p = p.next;
        }
        return count;
    }

    /**
     The add method adds to the end of the list.
     @param e The value to add.
     */

    public void add(T e)
    {
        if (isEmpty())
        {
            last = new Node<>(e);
            first = last;
        }
        else
        {
            // Add to end of existing list
            last.next = new Node<>(e, null, last);
            last = last.next;
        }
    }

    /**
     This add method adds an element at an index.
     @param element The element to add to the list.
     @param index The index at which to add.
     @exception IndexOutOfBoundsException When the index is out of bounds.
     */

    public void add(int index, T element)
    {
        if (index < 0  || index > size())
        {
            String message = String.valueOf(index);
            throw new IndexOutOfBoundsException(message);
        }

        // Index is at least 0
        if (index == 0)
        {
            // New element goes at beginning
            Node p = first;            // Old first
            first = new Node<>(element, p, null);
            if (p != null)
                p.prev = first;
            if (last == null)
                last = first;
            return;
        }

        // pred will point to the predecessor
        // of the new node.
        Node<T> pred = first;
        for (int k = 1; k <= index - 1; k++)
        {
            pred = pred.next;
        }

        // Splice in a node with the new element
        // We want to go from  pred-- succ to
        // pred--middle--succ
        Node<T> succ = pred.next;
        Node<T> middle = new Node<>(element, succ, pred);
        pred.next = middle;
        if (succ == null)
            last = middle;
        else
            succ.prev = middle;
    }
    /**
     The toString method computes the string representation of the list.
     @return The string representation of the linked list.
     */
    @Override
    public String toString()
    {
        StringBuilder strBuilder = new StringBuilder();

        // Use p to walk down the linked list
        Node<T> p = first;
        while (p != null)
        {
            strBuilder.append(p.value).append("\n");
            p = p.next;
        }
        return strBuilder.toString();
    }
    /**
     The remove method removes the element at a given position.
     @param index The position of the element to remove.
     @return The element removed.
     @exception IndexOutOfBoundsException When index is out of bounds.
     */
    public T remove( int index )
    {
        if (index < 0 || index >= size())
        {
            String message = String.valueOf(index);
            throw new IndexOutOfBoundsException(message);
        }
        // Locate the node targeted for removal
        Node<T> target = first;
        for (int k = 1; k <= index; k++)
            target = target.next;

        T element = target.value;  // Element to return
        Node<T> pred = target.prev;        // Node before the target
        Node<T> succ = target.next;        // Node after the target

        // Route forward and back pointers around
        // the node to be removed
        if (pred == null)
            first = succ;
        else
            pred.next = succ;

        if (succ == null)
            last = pred;
        else
            succ.prev = pred;

        return element;
    }
    /**
     The remove method removes an element from the list.
     @param elem The element to remove.
     @return true if the element was removed, false otherwise.
     */

    public boolean remove( T elem )
    {
        if (isEmpty())
            return false;

        // Locate the node targeted for removal
        Node <T> target = first;
        while (target != null
                && !elem.equals(target.value))
            target = target.next;

        if (target == null)
            return false;

        Node<T> pred = target.prev;        // Node before the target
        Node<T> succ = target.next;        // Node after the target

        // Route forward and back pointers around
        // the node to be removed
        if (pred == null)
            first = succ;
        else
            pred.next = succ;

        if (succ == null)
            last = pred;
        else
            succ.prev = pred;

        return true;
    }
    //---------------------------------------Add these methods to the class---------------------------//

    /**
     * The push method adds elem as the first element of the list.
     * @param elem the value to be pushed onto the list.
     */
    public void push( T elem )
    {
        Node p = first;            // Old first
        first = new Node<>(elem, p, null);
        if (p != null)
            p.prev = first;
        if (last == null)
            last = first;
    }
    /**
     * The pop method removes and return the first element of the list.
     * @return item at the top of the list.
     */
    public T pop()
    {
        return dequeue();
    }
    /**
     * The enqueue method adds an element as the last element of the list.
     * @param elem The element to be added to the list.
     */
    public void enqueue(T elem )
    {
        if (last != null)
        {
            last.next = new Node(elem);
            last = last.next;
        }
        else
        {
            last = new Node(elem);
            first = last;
        }
    }
    /**
     * The dequeue method remove and return the first element of the list.
     * @return The element at the front of the list.
     */

    public T dequeue()
    {
        if(isEmpty())
        {
            throw new EmptyStackException();
        }
        Node<T>target = first;
        T element = target.value;  // Element to return
        first = target.next;
        return element;
    }
}