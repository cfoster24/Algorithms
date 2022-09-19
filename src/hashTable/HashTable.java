/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashTable;

import edu.princeton.cs.algs4.Queue;

/**
 *
 * @author cfoster24
 */
public class HashTable <Key, Value> {
    
    private int m;
    private int n;
    private Value[] vals;
    private Key[] keys;
    
    public HashTable(int capacity){
        m = capacity;
        n = 0;
        keys = (Key[]) new Object[m];
        vals = (Value[]) new Object[m];
        
    }// HashTable(int)
    
    public int size() {
        return n;
    }// size()
    
    public boolean isEmpty() {
        return size() == 0;
    }// isEmpty()
    
    public int hash(Key key) {
        return (key.hashCode() & 0x7ffffff) % m;
    }// hash(Key)
    
    public void put(Key key, Value val) {
        int i;
        for(i = hash(key); keys[i] != null; i = (i+1)% m)
            if(keys[i] == key)
                break;
        keys[i] = key;
        vals[i] = val;
        n++;
    }// put(Key, Value)
    
    public Value get(Key key) {
        for(int i = hash(key); keys[i] != null; i = (i+1) % m)
            if(key.equals(keys[i]))
                return vals[i];
        return null;
    }// get(Key)
    
    public void delete(Key key) {
        if(!contains(key))
            return;
        
        int i = hash(key);
        while(key != keys[i]){
            i = (i + 1) % m;
        }// while
        
        keys[i] = null;
        vals[i] = null;
        
        i = (i + 1) % m;
        while (keys[i] != null) {
            // delete keys[i] an vals[i] and reinsert
            Key   keyToRehash = keys[i];
            Value valToRehash = vals[i];
            keys[i] = null;
            vals[i] = null;
            n--;
            put(keyToRehash, valToRehash);
            i = (i + 1) % m;
        }// while
        
        n--;
    }// delete(Key)
    
    public boolean contains(Key key) {
        return get(key) != null;
    }// contains(Key)
    
    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<Key>();
        for (int i = 0; i < m; i++)
            if (keys[i] != null) queue.enqueue(keys[i]);
        return queue;
    } // keys()
    
    public static void main(String[] args){
        HashTable contactList = new HashTable(12);
        contactList.put("Doe, John", "920-251-3061");
        
        System.out.println(contactList);
        
    }// main(String[])
}// HashTable
