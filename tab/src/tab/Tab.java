package tab;
import java.util.Scanner;
import java.io.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;




public class Tab {
    
    
    
    
    // when declearing a variable out the static main class we must make sure the variableis static;
    public static int N = 5;
    
    //Methods using oop
    public float data[] = new float[N];
    
    public void getData(){
         int i;
        Scanner sc = new Scanner(System.in);
        for(i=0; i<N; i++){
            System.out.print("Pls enter array value------->  "+ i + "    ");
            data[i] = sc.nextFloat();
        }
    }
    
    
    public void showData(){
        int i;
        Scanner sc = new Scanner(System.in);
        
        for(i=0; i<N; i++){
            System.out.print(data[i] + "    ");
        }
    }
    
    
    public void stdDev1(){
         int i;
        double sum = 0.0;
        double ave;
        double var = 0.0;
        double st;
        
        for(i=0; i<N; i++){
            
            sum+=data[i];
   
        }
        //System.out.println("Sum of the weight is  " + sum);
        
        //How to print in a formatted style using (print format)
        System.out.printf("The sum of the weight is %6.3f%n  ", sum);
        
        
        
        ave = sum/N;
        
       // System.out.println("The average of the weight is:  "+ ave);
       
       // How to print in a formatted style using Format
       System.out.format("Average of the weight is %3.2fn   " , ave);
       
        for(i=0; i<N; i++){
            var += ((data[i] - ave) * (data[i] - ave))/N;
        }
        
        System.out.println("Variation of the weight is is   "+ var);
        
        
        //How to use decimal format
         DecimalFormat df = new DecimalFormat("###.###");
         String output1 = df.format(var);
         System.out.println("Second standard variation using decimal format" + output1);
        st = Math.sqrt(var);
        
        System.out.println("Standard variation is:  " + st);
        
        
        
        //How to use number format
        String st1 = formata(st);
        System.out.println("The second standard deviation output is  "+st1);
       
    }
    
    
    
    //Procedural functions
    public static String formata(double std){
        
        NumberFormat nf = NumberFormat.getInstance();
        nf.getMinimumIntegerDigits();
        nf.getMaximumIntegerDigits();
        return nf.format(std);
    }
    
    public static void inputData(float data[], int size){
        
        int i;
        Scanner sc = new Scanner(System.in);
        for(i=0; i<size; i++){
            System.out.print("Pls enter array value------->  "+ i+1 + "    ");
            data[i] = sc.nextFloat();
        }
        
    }
    
    
    public static void outputData(float data[], int size){
        int i;
        Scanner sc = new Scanner(System.in);
        
        for(i=0; i<size; i++){
            System.out.print(data[i] + "    ");
        }
    }
    
    
    public static void std(float data[], int size){
        
        int i;
        double sum = 0.0;
        double ave;
        double var = 0.0;
        double st;
        
        for(i=0; i<size; i++){
            
            sum+=data[i];
   
        }
        //System.out.println("Sum of the weight is  " + sum);
        
        //How to print in a formatted style using (print format)
        System.out.printf("The sum of the weight is %6.3f%n  ", sum);
        
        
        
        ave = sum/size;
        
       // System.out.println("The average of the weight is:  "+ ave);
       
       // How to print in a formatted style using Format
       System.out.format("Average of the weight is %3.2fn   " , ave);
       
        for(i=0; i<size; i++){
            var += ((data[i] - ave) * (data[i] - ave))/size;
        }
        
        System.out.println("Variation of the weight is is   "+ var);
        
        
        //How to use decimal format
         DecimalFormat df = new DecimalFormat("###.###");
         String output1 = df.format(var);
         System.out.println("Second standard variation using decimal format" + output1);
         st = Math.sqrt(var);
        
        System.out.println("Standard variation is:  " + st);
        
        
        
        //How to use number format
        String st1 = formata(st);
        System.out.println("The second standard deviation output is  "+st1);
       
    }
    
    public static void main(String[] args) {
        
        //PROCEDURAL PROGRAMMING LANGUAGE
        float[] tab = new float[N];
        
        //input data into an array through function
        inputData(tab, N);
        
        //output data from an array through a function
        outputData(tab, N);
        
        System.out.println();
        //how to calculate standard deviation through fiunction
        std(tab, N);
        
        
        
        //USING METHOD TO PERFORM ALL THE OPERATIONS
        
        Tab tt = new Tab();
        tt.getData();
        tt.showData();
        tt.stdDev1();
        
        
    }
    
}
