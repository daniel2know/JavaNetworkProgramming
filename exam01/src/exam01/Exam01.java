

package exam01;

import java.text.NumberFormat;
import java.util.Scanner;


public class Exam01 {
public static int N = 5;
public static float[] tab = new float[N];


public static void inputData(float a[], int size){
    
    Scanner  scan = new Scanner(System.in);
    for(int i=0; i<size; i++){
        System.out.print("Please enter the value of "+ (i+1)+" :------> ");
        a[i] = scan.nextFloat();
    }   
}
    
public static void outputData(float a[], int size){
    
    for(int i=0; i<size; i++)
        System.out.println(a[i]+ " ");     
}


public static void linearSearch(float a[], int size, float item){
   
    int loc = 0;
    boolean found = false;
    for(int i=0; i<size; i++){
        if(a[i] == item){
            loc = i;
            found = true;
            break;
    
        }
        
     }
    
    if(found){
        System.out.println( item + " is found at location " + (loc+1));
    }else{
        System.out.println("Item not found.......");
    }
       
}


// to format
public static String roundNum(double num){
    
    String d;
    NumberFormat nf = NumberFormat.getInstance();
    nf.setMaximumIntegerDigits(2);
    nf.setMinimumIntegerDigits(2);
    
    d = nf.format(num);
    
    return(d);
    
}



public static String roundNumb(double num){
    
    
    NumberFormat nf = NumberFormat.getInstance();
    nf.setMaximumIntegerDigits(2);
    nf.setMinimumIntegerDigits(2);
    
    
    
    return(nf.format(num));
    
}



public static void bubble(float a[], int size){
    float temp;
    for(int i=0; i<size; i++){
        
        for(int j=0; j<size-1; j++){
            
            if(a[j] > a[j+1]){
                
                temp = a[j];
                a[j] = a[j+1];
                a[j+1] = temp;
            }
        }
        
    }
}



public static void binarySearch(float a[], int size, float num){
    
    int i =0;
    int j = size - 1;
    int mid = (i+j)/2;
    int loc;
    
    while(i<=j){
        if(num < a[mid]){
            j = mid -1;
        }else{
            i = mid + 1;
        }
        
        mid = (i+j)/2;
    }
    
    if(a[mid] == num){
        loc = mid;
        System.out.println(num + " is found at location  " + (loc + 1));
    }
    else{
        System.out.println(num + " is not found");
    }
}



public static int tenary(float a[], float num, int start, int end){
    if(start > end)
        return -1;
    int mid1 = start + (end -start)/3;
    int mid2 = start + 2 * (end - start)/ 3;
    
    if(a[mid1] == num)
        return mid1;
    else
        if(a[mid2] == num)
            return mid2;
        else
            if(num < a[mid1])
                return tenary(a, num, start, mid1 - 1);
            else
                if(num > a[mid2])
                    return tenary(a, num, mid2 + 1, end);
            else
            return tenary(a, num, mid1, mid2);
    
    
}

public static void bestMethod(double num1, double num2, double num3){
    double better, best;
    if(num1 < num2){
        better = num1;
    }
    else{
        better = num2;
    }
    
    if(better < num3){
        best = better;
    }
    else{
        best = num3;
    }
    
    
    String ans;
    ans = roundNumb(best);
    
    System.out.println("The best is : "+ ans);
    
    
}

public static int  tenary( float a[], float num){
    
    
    return tenary(a, num, 0, a.length -1);
}

    public static void main(String[] args) {
        
        double start1,end1,start2,end2, start3,end3;
        
        Scanner  scan = new Scanner(System.in);
        float item1, item2, item3;
        inputData(tab, N); 
        outputData(tab, N);
        
        
        
        
        start1 = System.currentTimeMillis();
        System.out.print("Enter number to be searched ----------> ");
        item1 = scan.nextFloat();
        linearSearch(tab,N,item1);
        end1 = System.currentTimeMillis();
        
        end1 = (end1 - start1)/100000;
        
        System.out.println("Linear search for the given item is " + end1 + " ms");
        String nn = roundNum(end1);
        System.out.println("Linear search for the given item in two decimal places is: " + nn + " ms");
        
        
        start2 = System.currentTimeMillis();
        bubble(tab, N);
        System.out.println("See sorted data....");
        outputData(tab,N);
        
        
        System.out.print("Enter number to be searched : Binary search --------> ");
        item2 = scan.nextFloat();
        binarySearch(tab,N,item2);
        end2 = System.currentTimeMillis();
        end2 = (end2 - start2)/100000;
        String n2 = roundNum(end2);
        System.out.println("Binary search for the given item in two decimal places is: " + n2 + " ms");
        
        
        
        start3 = System.currentTimeMillis();
        System.out.print("enter item for tenary search: ----> ");
        item3 = scan.nextFloat();
        int loc = tenary(tab, item3);
        
        if(loc == -1){
            System.out.println( item3 +" is not found...");
        }else{
            System.out.println( item3 +" is found at location " + (loc + 1));
        }
        end3 = System.currentTimeMillis();
        end3 = (end3 - start3)/100000;
        
        String n3 = roundNum(end3);
        System.out.println("Tenary search for the given item in two decimal places is: " + n3 + " ms");
        
        
        bestMethod(end1,end2,end3);
        
   }
    
}
