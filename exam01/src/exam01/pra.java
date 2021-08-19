/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exam01;

import java.text.NumberFormat;
import java.util.Scanner;

/**
 *
 * @author Tunwashe Daniel
 */
public class pra {
    
    public static int N = 5;
    public static float[] table = new float[N];
    static Scanner scan = new Scanner(System.in);
    
    public static void inputData(float a[], int size){
        System.out.println("Enter data into the table");
        for(int i=0; i < table.length; i++){
            System.out.print("Enter value of for index " + (i+1) + "    ");
            table[i] = scan.nextFloat();
        }
    }
    
    public static void outputData(float a[], int size){
        for(int i=0; i< table.length; i++){
            System.out.println("the table values are: " + table[i]);
        }
    }
    
    
    public static void linearSearch(float a[], int size, float item){
        boolean found = false;
        int loc = 0;
        for(int i=0; i< table.length; i++){
            if(a[i] == item){
                found = true;
                loc = (i+1);
            }
        }
        
        if(found){
            System.out.println(item + " found at location  "+ (loc));
        }
        else{
            System.out.println(item + " Not found.........");
        }
    }
    
    public static String format(double end1){
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumIntegerDigits(1);
        nf.setMinimumIntegerDigits(1);
        
        String res = nf.format(end1); 
        
        return res;
    }
    
    public static void bubbleSort(float a[], int size){
        float temp;
        for(int i=0; i<size; i++){
            for(int j=0; j<size - 1; j++){
                if(a[j] > a[j+1]){
                    temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
    }
    
    public static void binarySearch(float a[], int size, float item){
        int i =0;
        int j = size - 1;
        int mid = (i + j)/ 2;
        int loc = 0;
        
        while(i <= j){
            if(item < a[mid] ){
                j = mid - 1;
            }
            else{
                i = mid + 1;
            }
            
            mid = (i + j)/ 2;
        }
        
        if(a[mid] == item){
            loc = mid;
            System.out.println(item+" found at location " + (loc + 1));
        }
        else{
            System.out.println(item+" not found.......");
        }
    }
    
    public static int tenary(float a[], float item, int start, int end){
        if(start > end)
            return -1;
        int mid1 = start + (end - start)/3;
        int mid2 = start + 2 *(end - start)/3;
        
        if(a[mid1] == item)
            return mid1;
        else
            if(a[mid2] == item)
                return mid2;
        else
                if(item < a[mid1])
                    return tenary(a, item, 0, mid1 - 1);
        else
                    if(item > a[mid2])
                        return tenary(a, item, mid2 + 1, end);
        else
                        return tenary(a, item, mid1, mid2);
    }
    
    public static int tenary(float a[], float item){
        return tenary(a, item, 0, a.length-1);
    }
    
   
    public static void main(String[] args){
        
        double end1, start1, end2, start2;
        
        inputData(table,N);
        System.out.println("   ");
        outputData(table, N);
        System.out.println("  ");
        
        start1 = System.currentTimeMillis();
        System.out.print("Enter number to be searched using Linear search.....   ");
        float numbLinear;
        numbLinear = scan.nextFloat();
        linearSearch(table, N, numbLinear);
        end1 = System.currentTimeMillis();
        end1 = (end1 - start1)/100000;
        
        String end1Formatted = format(end1);
        System.out.println("Time for Linear Search is: "+ end1Formatted);
        
        
        start2 = System.currentTimeMillis();
        bubbleSort(table,N);
        outputData(table,N);
        System.out.print("Enter number to be searched in Binary search ");
        float numberBinary = scan.nextFloat();
        binarySearch(table, N, numberBinary);
        end2 = System.currentTimeMillis();
        end2 = (end2 - start2)/100000;
        
        String end2Formatted = format(end2);
        System.out.println("Time for Linear Search is: "+ end2Formatted);
        
        System.out.println("Enter the number to be searched using tenary search ");
        float numberTenary = scan.nextFloat();
        int loc = tenary(table,numberTenary);
        if(loc == -1){
            System.out.println(numberTenary + " could not be found");
        }
        else{
            System.out.println(numberTenary +" Found at loction "+ (loc+1));
        }
        
    }
    
    
}
