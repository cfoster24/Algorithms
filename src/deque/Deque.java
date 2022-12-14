/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deque;

/**
 *
 * @author cfoster24
 * @param <Item>
 */
import edu.princeton.cs.algs4.StdOut;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class Deque<Item> implements Iterable<Item>{
    
    private Node first;
    private Node last;
    
    // adding this comment for github push 
    
    // construct an empty deque
    public Deque (Node first, Node last) {
        this.first = first;
        this.last = last;
    } // Deque (Node, Node)
    
    public Deque() {
        this(null, null);
    } // Deque()
    
    // is the deque empty?
    public boolean isEmpty() {
        return(size() == 0);
    }//isEmpty()

    // return the number of items on the deque
    public int size() {
        int counter = 0;
        Node current = this.first;
        while(current != null) {
            current = current.getNext();
            counter++;
        }
        return counter;
    } // size()

    // add the item to the front
    public void addFirst(Item data) {
        if (data == null)
        {
            throw new IllegalArgumentException("Illegal Argument");
        }
        if (this.isEmpty()) {
            this.first = new Node(data);
            this.last = this.first;
        }
        else {
            Node oldFirst = this.first; 
            this.first = new Node(data);
            this.first.setNext(oldFirst);
            oldFirst.setPrev(this.first);
        }
        
    }//addFirst(Item)

    // add the item to the back
    public void addLast(Item data) throws IllegalArgumentException {
        if (data == null)
        {
            throw new IllegalArgumentException("Illegal Argument");
        }
        if (this.isEmpty()){
            addFirst(data);
        }
        else {
            Node oldLast = this.last;
            this.last = new Node(data);
            this.last.setPrev(oldLast);
            oldLast.setNext(this.last);
        }
    
    }//addLast(Item)
      
    // remove and return the item from the front
    public Item removeFirst() throws NoSuchElementException {
        if (this.isEmpty()){
            throw new NoSuchElementException
                ("Cannot remove items from empty Deque");
        }
        Item payload = (Item) this.first.getPayload();
        
        this.first = this.first.getNext();
        if (this.first != null)
            this.first.setPrev(null);
        
        return payload;
        
    }//removeFirst()

    // remove and return the item from the back
    public Item removeLast() throws NoSuchElementException {
        if (this.isEmpty()){
            throw new NoSuchElementException
                    ("Cannot remove items from empty Deque");
        }
        
        Node oldlast = this.last;
        this.last = oldlast.getPrev();
        
        if (isEmpty())
            this.first = null;
        else if (this.last != null)
            this.last.setNext(null);
        
        
        return (Item) oldlast.getPayload();
    }//removeLast()

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        return new listIterator();
    }// iterator()
    
    private class listIterator implements Iterator<Item> {
            private Node current = first;
            
            public boolean hasNext() {
                return current != null;
            }//hasNext()
            public Item next() throws NoSuchElementException {
                
                if (!hasNext()) throw new NoSuchElementException("There are no more elements"); 
                Item item = (Item) current.getPayload();
                current = current.getNext();
                return item;
            }//next()
            public void remove() throws UnsupportedOperationException {
                // Unsupported
                throw new UnsupportedOperationException("UnsupportedOperationException");
            } //remove()
    } // listIterator
 
    // unit testing (required)
    public static void main(String[] args) {
        Deque dq = new Deque(null, null);

        dq.addFirst("Chicken");
        dq.addFirst(1);
        dq.addFirst(2);
        dq.addFirst(4);
        dq.removeLast();
        dq.removeFirst();
        
        

        //System.out.println(dq.size());
        //System.out.println(dq.isEmpty());

        

        /*while (current != null){
            System.out.println(current.getPayload());
            current = current.getNext();
        }//while*/

        for (Object d : dq)
            StdOut.println(d);
       
    } // main(String[])

} // Deque
