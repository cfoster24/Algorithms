/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heap;

/**
 *
 * @author cfoster24
 */
public class Heap {
    public static void sort(int[] pq)
    {
        int N = pq.length;
        // build heap
        for (int i = N/2 - 1; i >= 0; i--)
            sink(pq, i, N);
        
        
        for (int i = N - 1; i >= 0; i--)
        {
            exch(pq, 0, i);
            sink(pq, 0, i);
        }
    }
    
    private static void sink(int[] pq, int k, int n) {
        int largest = k; // initialize largest as root
        int l = 2*k + 1; // left
        int r = 2*k + 2; // right
        
        // If left child is larger than root
        if (l < n && pq[l] > pq[largest])
            largest = l;
        
        // If right child is largest so far
        if (r < n && pq[r] > pq[largest])
            largest = r;
        
        // If largest is not root
        if (largest != k)
        {   
            
            exch(pq, k, largest);
            
            // Repeatedly sink until largest is at the root
            sink(pq, n, largest);
        }
    } // sink(int[], int, int)
   
    
    private static void exch(int[] pq, int i, int j) {
        //swap the indexes of two items in an array
        int swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    } // exch(int[], int, int)
    
    public static void main(String[] args)
    {
        int a[] = {12, 11, 13, 5, 6, 7};
        int n = a.length;
        
        for(int i : a)
            System.out.println(i);
        System.out.println();
        
        Heap.sort(a);
        
        for(int i : a)
            System.out.println(i);
    }
}
