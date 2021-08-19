



package tab;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;


public class test1 {
    public static int N = 5;
    static Scanner scan = new Scanner(System.in);
    static float sum =0;
    static float avg;
    static double var;
    static double sd;
    
    public static void inputData(float[] a, int size){
        
        for(int i=0; i<size; i++){
            System.out.print("Enter the value for : "+ (i+1)+ " : ");
            a[i] = scan.nextFloat();
        }
        
    }
    
    public static void outputData(float[] a, int size){
        for(int i=0; i<size; i++){
            System.out.println((i+1)+" is : ----> " + a[i]);
        }
    }
    
    public static void sumData(float[] a, int size){
        
        for(int i=0; i<size; i++){
            sum+=a[i];
        }
        
        System.out.println("The sum of the array values are: "+ sum);
        
        avg = sum/size;
        
        System.out.println("The average is:  " + avg);
    }
    
    public static void var(float [] a, int size){
        
        for(int i=0; i< size; i++){
            var = ((a[i] - avg) * (a[i] - avg));
        }
        
        System.out.println("Varience is: "+ var);
        
        sd = Math.sqrt(var);
        
        System.out.println("The standard deviation is:   " + sd);
        
        
    }
    
    public static void roundNumberFormat(){
        
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumIntegerDigits(1);
        nf.setMinimumIntegerDigits(2);
        String d = nf.format(var);
        
        System.out.println("New varience but formatted to 1.d.p using NumberFormat:  " + d);
        
    }
    
    public static void decimalFormat(){
        DecimalFormat df = new DecimalFormat("#.#");
        String d = df.format(sd);
        
        System.out.println("The new standard deviation rounded is: "+ d);
    }
    
    
    
    public static void main(String[] args) {
        
        float [] data = new float[N];
        
        inputData(data,N);
        
        outputData(data, N);
        
        sumData(data, N);
        
        var(data,N);
        
        roundNumberFormat();
        decimalFormat();
        
        
        
        
    }
    
}
