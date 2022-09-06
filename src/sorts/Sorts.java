/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorts;
//comment for initial commit to repo.
/**
 *
 * @author cfoster24
 */
public class Sorts {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] a = new int[]{3, 1, 2, 12, 5, 400, 15, 4, 3, 13};
        
        Shellsort.sort(a);
        
        for (int i = 0; i < a.length; i ++)
            System.out.println(a[i]);
    }
    
}
