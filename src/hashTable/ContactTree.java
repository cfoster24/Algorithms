/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashTable;

/**
 *
 * @author cfoster24
 */
public class ContactTree {
    private Node emailRoot;
    private Node phoneRoot;
    
    private class Node {
        private Node prev;
        private Node next;
        private String val;
        private String key;
        
        public Node(Node prev, Node next, String val, String key){
            this.prev = prev;
            this.next = next;
            this.val = val;
            this.key = key;
        }// Node(Node, Node, String, String)
    }// Node
}// contactTree
