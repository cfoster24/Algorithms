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
public class Selection {
    public static void sort(int[] a)
    {
        int N = a.length;
        for (int i = 0; i < N; i++)
        {
            int min = i;
            for (int j = i+1; j < N; j++)
                if (a[j] < a[min])
                    min = j;
            
            int temp = a[min];
            a[min] = a[i];
            a[i] = temp;
        }
    }
}
