
package binarySearchTree;

/**
 *
 * @author cfoster24
 * @param <Key>
 * @param <Value>
 */
public class BinarySearchTree<Key extends Comparable<Key>, Value>{
    private Node root;
    
    private class Node{
        private Key key;
        private Value val;
        private Node left, right;
        private int size;
        
        public Node(Key key, Value val, int size){
            this.key = key;
            this.val = val;
            this.size = size;
        }// Node(Key, Value, int)
    }// Node
    
    public int size(){
        return size(root);
    }// size()

    public int size(Node x){
        return x.size;
    }// size(Node)

    public Value get(Key key){
        Node x = root;
        while(x != null)
        {
            int cmp = key.compareTo(x.key);
            if(cmp < 0)
                x = x.left;
            else if (cmp > 0)
                x = x.right;
            else
                return x.val;
        }// while

        return null;  
    }// get(Key)

    public void put(Key key, Value val){
        root = put(root, key, val);
    }// put(Key, Value)

    private Node put(Node x, Key key, Value val){
        if (x == null) 
            return new Node(key, val, 1);
        int cmp = key.compareTo(x.key);

        if(cmp < 0)
            x.left = put(x.left, key, val);
        else if (cmp > 0)
            x.right = put(x.right, key, val);
        else
            x.val = val;
        x.size = 1 + size(x.left) + size(x.right);
        return x;
    }// put(Node, Key, Value)
    
    public int rank(Key key){
        return rank(key, root);
    }// rank(Key)
    
    private int rank(Key key, Node x){
        if (x == null)
            return 0;
        
        int cmp = key.compareTo(x.key);
        
        if (cmp < 0)
            return rank(key, x.left);
        else if (cmp > 0)
            return 1 + size(x.left) + rank(key, x.right);
        else
            return size(x.left);
    }// rank(Key, Node)
    
    public Iterable<Key> keys(){
        Queue<Key> q = new Queue<Key>();
        inorder(root, q);
        return q;
    }// keys()
    
    private void inorder(Node x, Queue<Key> q){
        if (x == null)
            return;
        inorder(x.left, q);
        q.enqueue(x.key);
        inorder(x.right, q);
    }// inorder(Node, Queue<Key>)
    
    public void deleteMin(){
        root = deleteMin(root);
    }// deleteMin()
    
    private Node deleteMin(Node x){
        if (x.left == null)
            return x.right;
        x.left = deleteMin(x.left);
        x.size = 1 + size(x.left) + size(x.right);
        
        return x;
    }// deleteMin(Node)
    
    public void delete(Key key){
        root = delete(root, key);
    }// delete(Key)
    
    private Node delete(Node x, Key key){
       if (x == null)
           return null;
       
       int cmp = key.compareTo(x.key);
       if (cmp < 0)
           x.left = delete(x.left, key);
       else if (cmp > 0)
           x.right = delete(x.right, key);
       else {
           if (x.right == null)
               return x.left;
           if (x.left == null)
               return x.right;
           
           Node t = x;
           
           x = min(t.right);
           x.right = deleteMin(t.right);
           x.left = t.left;
       }// else
       x.size = size(x.left) + size(x.right) + 1;
       return x;
    }// delete(Node, Key)
    
    public Key min(){
        return min(root).key;
    }// min()

    private Node min(Node x){
        if (x.left == null) 
            return x;
        else                
            return min(x.left);
    }// min(Node)
    
    public Key max(){
        return max(root).key;
    }// max()

    private Node max(Node x){
        if (x.right == null)
            return x;
        else                 
            return max(x.right);
    }// max(Node)
    
    public Key floor(Key key){
        Node x = floor(root, key);
        if (x == null)
            return null;
        return x.key;
    }// floor(Key)
    
    private Node floor(Node x, Key key){
        if (x == null)
            return null;
        int cmp = key.compareTo(x.key);
        
        if (cmp == 0)
            return x;
        if (cmp < 0)
            return floor(x.left, key);
        
        Node t = floor(x.right, key);
        if(t != null)
            return t;
        else
            return x;
        
    }// floor(Node, Key)
    
}// BinarySearchTree
 