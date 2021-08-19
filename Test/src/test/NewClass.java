/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;
import java.util.*;
import static test.NewClass.getter;
/**
 *
 * @author Tunwashe Daniel
 */
public class NewClass {
    static char []set;
    static int sum =0;
    static char []getter = new char[50];
    
    public static void printPowerSet(char []set,
                            int set_size)
    {
         
        /*set_size of power set of a set
        with set_size n is (2**n -1)*/
        long pow_set_size =
            (long)Math.pow(2, set_size);
        int counter, j;
        
     
        /*Run from counter 000..0 to
        111..1*/
        for(counter = 0; counter < pow_set_size; counter++)
        {
            for(j = 0; j < set_size; j++)
            {
                /* Check if jth bit in the
                counter is set If set then
                print jth element from set */
                if((counter & (1 << j)) > 0)
                    System.out.print(set[j]); 
        
                
            }
             
            System.out.println();
        }
        
        for(int i =0; i<pow_set_size; i++){
            
            System.out.println(getter[i]);
       }
    }
    
    public void powerset(String nam){
    
     set = nam.toCharArray();   
}
    
   
    
    
    public static void main(String[] args) {
        
        NewClass ne = new NewClass();
        String name;
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your name....");
        name = scan.next();
        
        ne.powerset(name);
        printPowerSet(set, set.length);
        
        
        
        
    }
    
}
