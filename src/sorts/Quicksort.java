/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorts;

/**
 *
 * @author cfoster24
 */
public class Quicksort {
    public void sort(int a[], int lo, int hi){
        if(lo < hi) {
            int partitionIndex = partition(a, lo, hi);
            
            sort(a, lo, partitionIndex-1);
            sort(a, partitionIndex+1, hi);
        }// if
    }// sort(int[], int, int)
    
    private static int partition(int[] a, int lo, int hi)
    {
        int pivot = a[hi];
        int i = (lo - 1);
        
        for(int j = lo; j < hi; j++) {
            if(a[j] <= pivot){
                i++;
                
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }// if
        }// for
        
        int temp = a[i + 1];
        a[i + 1] = a[hi];
        a[hi] = temp;
        
        return i+1;
    }// partition(int[], int, int)
} //Quicksort
