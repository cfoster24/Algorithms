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
        
public class Node<Item>{
    
    
    private Node prev;
    private Node next;
    private Item payload;
    // construct an empty deque
    public Node ( Node prev, Node next, Item payload) {
        this.prev = prev;
        this.next = next;
        this.payload = payload;
    } // Deque (Deque, Deque, int)
    
    public Node (Item payload) {
        this(null, null, payload);
    } // Deque (int) 

    /**
     * @return the prev
     */
    public Node getPrev() {
        return prev;
    } // getPrev()

    /**
     * @param prev the prev to set
     */
    public void setPrev(Node prev) {
        this.prev = prev;
    } // setPrev(Node)

    /**
     * @return the next
     */
    public Node getNext() {
        return next;
    } // getNext()

    /**
     * @param next the next to set
     */
    public void setNext(Node next) {
        this.next = next;
    } // setNext(Node)

    /**
     * @return the payload
     */
    public Item getPayload() {
        return payload;
    } // getPayload()
}
