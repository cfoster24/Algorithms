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
public class Shellsort {
    public static void sort(int[] a)
    {
        int N = a.length;
        
        int h = 1;
        while (h < N/3) 
            h = 3*h + 1;
        
        while (h >= 1)
        {
            for (int i = h; i < N; i++)
            {
                for (int j = i; j >= h && (a[j] < a[j-h]); j -= h)
                {
                    int temp = a[j-h];
                    a[j-h] = a[j];
                    a[j] = temp;
                }
            }
            
            h = h/3;
        }
    }
}
