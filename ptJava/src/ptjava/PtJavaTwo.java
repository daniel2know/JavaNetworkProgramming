/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ptjava;

import java.text.NumberFormat;
import java.util.Scanner;

/**
 *
 * @author Tunwashe Daniel
 */
public class PtJavaTwo {
    public static int N=5;
    public static float[] tab = new float[N];
    public static Scanner scan = new Scanner(System.in);
    
    
    public void inputData(){
        for(int i=0; i<N; i++){
            System.out.print("Enter value for " + (i+1) + " : ");
            tab[i] = scan.nextFloat();
        }
    }
    
    public void outputData(){
        for(int i=0; i<N; i++){
            System.out.println((i+1) + "------->  : "+ tab[i]);
        }
    }
    
    public void linearSearch(float numb1){
        int loc =0;
        boolean found = false;
        
        for(int i=0; i<N; i++){
            if(tab[i] == numb1){
                loc = (i+1);
                found = true;
                break;
            }
        }
        
        if(found){
            System.out.println(numb1 + " found at location : "+(loc));
        }
        else{
            System.out.println(numb1 +" not found...");
        }
    }
    
    
    public String roundNum(double num){
        String d;
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumIntegerDigits(2);
        nf.setMinimumIntegerDigits(2);
        d = nf.format(num);
        return d;
    }
    
    
    public void bubbleSort(){
        float temp;
        for(int i=0; i<N; i++){
            for(int j=0; j<N-1; j++){
                if(tab[j] > tab[j+1]){
                temp = tab[j];
                tab[j] = tab[j+1];
                tab[j+1] = temp;
                }
            }
        }
    }
    
    
    public void binarySearch(float numb2){
        int start =0;
        int end = N-1;
        int mid = (start + end)/2;
        int loc;
        
        while(start <= end){
            if(numb2 < tab[mid]){
                end = mid -1 ;
                
            }
            else{
                start = mid + 1;
            }
            
            mid = (start + end )/2;
        }
        
        if(tab[mid] == numb2){
            loc = mid;
               
            System.out.println(numb2 + " found at location:  " +(loc+1));
        }
        else{
            System.out.println(numb2 + " not found....");
        }
         
    }
    
    
    public int tenary(float a[], float item, int start, int end){
    PtJava ptj = new PtJava();
    if(start > end)
        return -1;
    int mid1 = start + (end - start)/3;
    int mid2 = 2 * start + (end- start)/3;
    
    if(tab[mid1] == item)
        return mid1;
    else
        if(tab[mid2] == item)
            return mid2;
    else
            if(item < tab[mid1])
                return ptj.tenary(a, item, start, mid1 -1);
    else
                if(item > tab[mid2])
                    return ptj.tenary(a, item, mid2 + 1, end);
    else
                    return ptj.tenary(a, item, mid1, mid2);
}


public int tenary(float a[], float item){
    PtJava ptj = new PtJava();
    return ptj.tenary(a, item,0,tab.length-1);
}
    
    public void bestMethod(double num1, double num2, double num3){
        PtJavaTwo ptj = new PtJavaTwo();
        double better,best;
        String searchName;
        if(num1 < num2){
            better = num1;
            searchName = "Linear Search";
        }
        else{
            better = num2;
            searchName = "Binary Search";
        }
        if(better > num3){
            best = better;
            
        }
        else{
            best = num3;
            searchName = "Tenary Search";
        }
        
        String ans;
        ans = ptj.roundNum(best);
        
        System.out.println("The best method is " + searchName + " with time: " + ans);
        
    }
    
    public static void main(String[] args) {
        float item1,item2,item3;
        double start1, end1,start2,end2,start3,end3;
        PtJavaTwo ptj = new PtJavaTwo();
        
        System.out.println("Enter five floating numbers....");
        ptj.inputData();
        System.out.println(" ");
        ptj.outputData();
        System.out.println("");
        
        start1 = System.currentTimeMillis();
        System.out.print("Enter any floating point value in order to search using Linear search----> : ");
        item1 = scan.nextFloat();
        ptj.linearSearch(item1);
        end1 = System.currentTimeMillis();
        end1 = (end1 - start1)/100000;
        
        String linearRound = ptj.roundNum(end1); 
        System.out.println("The time taken for linear search in milliseconds is : "+linearRound);
        System.out.println(" ");
        
        start2 = System.currentTimeMillis();
        ptj.bubbleSort();
        ptj.outputData();
        System.out.print("Enter any value in order to search using binary search: ----> : ");
        item2 = scan.nextFloat();
        ptj.binarySearch(item2);
        end2 = System.currentTimeMillis();
        end2 = (end2 - start2)/100000;
        
        String binaryRound = ptj.roundNum(end2); 
        System.out.println("The time taken for binary search in milliseconds is : "+binaryRound);
        System.out.println(" ");
        
        start3 = System.currentTimeMillis();
        System.out.print("Enter any value in order to search using tenary search ---> : ");
        item3 = scan.nextFloat();
        int loc = ptj.tenary(tab,item3);
        if(loc == -1){
            System.out.println(item3 + " not found...");
        }
        else{
            System.out.println(item3 + " found at location: " +(loc+1));
        }
        end3 = System.currentTimeMillis();
        end3 = (end3 - start3)/100000;
        
        String tenaryRound = ptj.roundNum(end3);
        System.out.println("The time taken for tenary search in milliseconds is : "+tenaryRound);
        System.out.println(" ");
        
        ptj.bestMethod(end1,end2,end3);
    }
    
}
