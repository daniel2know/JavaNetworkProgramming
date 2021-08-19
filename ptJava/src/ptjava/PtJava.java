

package ptjava;

import java.util.Scanner;
import java.text.NumberFormat;


public class PtJava {
    
public static int N =5;
public static float[] tab = new float[N];
public static Scanner scan = new Scanner(System.in);



public void inputData(){
    
    for(int i=0; i<N; i++){
        System.out.print("Enter table values for position  --> " +(i+1) + "  : ");
        tab[i] = scan.nextFloat();
        
    }
}


public void outputData(){
    
    for(int i=0; i<N; i++){
        
    System.out.println((i+1) + "------> " + tab[i]);
    
    }
    
}

public void linearSearch(float item){
    
    int loc = 0;
    boolean found = false;
    
    for(int i=0; i<tab.length; i++){
        if(tab[i] == item){
            found = true;
            loc = i;
            break;
        } 
        
    }
    
    if(found){
        System.out.println(item + " found at location:  " + (loc+1));
    }
    else{
        System.out.println(item + " Could not be found");
    }
    
}


public String roundNum(double numb1){
    String result;
    
    NumberFormat nf = NumberFormat.getInstance();
    nf.setMaximumIntegerDigits(2);
    nf.setMinimumIntegerDigits(2);
    
    result = nf.format(numb1);
    return result;
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
    int start = 0;
    int end = N-1;
    int mid = (start+end)/2;
    int loc;
    
    
    while(start<=end){
        
        if(numb2 < tab[mid]){
            end = mid-1;
        }
        else{
            start = mid+1;
        }
        
        mid = (start + end)/2;
        
    }
    
    if(tab[mid] == numb2){
        loc = mid;
        System.out.println(numb2 + " found at location : "+ (loc+1));
    }
    else{
        System.out.println(numb2+" could not be found.....");
    }
    
}


public int tenary(float a[], float item, int start, int end){
    PtJava pj = new PtJava();
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
                return pj.tenary(a, item, start, mid1 -1);
    else
                if(item > tab[mid2])
                    return pj.tenary(a, item, mid2 + 1, end);
    else
                    return pj.tenary(a, item, mid1, mid2);
}


public int tenary(float a[], float item){
    PtJava pj = new PtJava();
    return pj.tenary(a, item,0,tab.length-1);
}


public void bestMethod(double num1, double num2, double num3){
    PtJava pj = new PtJava();
    double better, best;
    
    if(num1< num2){
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
    
    String ans = pj.roundNum(best);
    System.out.println("The best of the three method is:   " + ans);
    
}
    
    public static void main(String[] args) {
       
        try{
        double start1,end1,start2,end2;
        double start3,end3;
        float item1,item2,item3;
        PtJava pj = new PtJava();
        pj.inputData();
        pj.outputData();
        
        start1 = System.currentTimeMillis();
        System.out.print("Enter value to by searched with Linear search algorithm....");
        item1 =scan.nextFloat();
        pj.linearSearch(item1);
        end1 = System.currentTimeMillis();
        
        end1 = (end1 - start1)/100000;
        
        String linearRound = pj.roundNum(end1);
        System.out.println("The time for linear search in milli seconds is : " + linearRound+ "ms");
        
        
        start2 = System.currentTimeMillis();
        pj.bubbleSort();
        System.out.println("The table in the sorted way now is....");
        pj.outputData();
        System.out.print("Now enter the any value in order to be searched using Binary Search");
        item2 = scan.nextFloat();
        pj.binarySearch(item2);
        end2 = System.currentTimeMillis();
        end2 = (end2 - start2)/100000;
        
        String binaryRound = pj.roundNum(end2);
        System.out.println("The time for binary search in milli seconds is : " + binaryRound+ "ms");
        
        
        start3 = System.currentTimeMillis();
        System.out.print("Enter any value in order to be searched using tenary search : ");
        item3 = scan.nextFloat();
        
        int loc = pj.tenary(tab,item3);
        if(loc == -1){
            System.out.print(item3 + "Not found.....");
        }
        else{
            System.out.println(item3 + " found at location "+ (loc+1));
        }
        end3 = System.currentTimeMillis();
       
        end3 = (end3 - start3)/100000;
        
        String tenaryRound = pj.roundNum(end3);
        System.out.println("The time for tenary search in milli seconds is : " + tenaryRound+ "ms");
        
        
        pj.bestMethod(end1,end2,end3);
        
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
       
        
        
    }
    
}
