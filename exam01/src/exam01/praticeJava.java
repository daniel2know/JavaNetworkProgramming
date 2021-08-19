/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exam01;

import java.util.Scanner;

/**
 *
 * @author Tunwashe Daniel
 */
public class praticeJava {
    
public static int N;
public static float[] tab = new float[N];
static Scanner scan = new Scanner(System.in);
    
    
    
  public void inputData(float a[], int size){
    for(int i=0; i<a.length; i++){
        System.out.print("Enter the values for the table at position   ----> "+ (i+1));
        a[i] = scan.nextFloat();
    }
}
 
    /**
     *
     * @param a
     * @param size
     */
     public void outputData(float a[], int size){
     for(int i=0; i<a.length; i++){
         System.out.print("The table values are..............  ");
         System.out.println((i+1)+" -------->  " +a[i]);
     }
 }
    
    
    
    
    
    
    
    
    public static void main (String args[]){
        
        
        System.out.print("Enter the size of your table:   -------> ");
        N = scan.nextInt();
        praticeJava pj = new praticeJava();
        pj.inputData(tab, N);
        pj.outputData(tab, N);
        
    }
    
    
}



