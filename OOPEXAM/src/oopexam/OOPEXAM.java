
package oopexam;

import java.text.NumberFormat;
import java.util.Scanner;


public class OOPEXAM {
static Scanner scan = new Scanner(System.in);
static float[] table = new float[10];
    
    public void inputData(){
        for(int i =0; i<table.length; i++){
            System.out.print("Enter the values for your table  " + (i+1) + "  ");
            table[i] = scan.nextFloat();
        }
    }
    
    public void outputData(){
        for(int i =0; i<table.length; i++){
            System.out.println("The table data is  " + table[i]);
        }
    }

    public void mean(){
        float sum = 0;
        for(int i =0; i<table.length; i++){
            sum+=i;
            
        }
        float mean = sum/table.length;
        System.out.println("The mean is -----> "+ mean);
    }
    
    public void bubblesort(){
        float temp;
        for(int i =0; i<table.length; i++){
            for(int j =0; j<table.length - 1; j++){
                while(table[j] < table[j+1]){
                    temp = table[j];
                    table[j] = table[j+1];
                    table[j+1] = temp;
                }
            }
        }
    }
    
    public void median(){
        int i =0;
        int j = table.length - 1;
        float median = 0;
        int check = ((i+j)/2);
        for(int k =0; k<table.length; k++){
            if(k == check)
                median = (table[k] + table[k+1])/2;
        }
        
        System.out.println("The median is  " + median);
    }
    
    
    public int search(float numb){
        
    }
    
    
    public String format(double numb){
        NumberFormat nf =  NumberFormat.getInstance();
        nf.setMaximumIntegerDigits(3);
        nf.setMinimumIntegerDigits(3);
        String res = nf.format(numb);
        
        return res;
        
    }
    
    
   // public void bestProcessingTime()
    
    
    
    
    
    public static void main(String[] args) {
        
      //QUSETION FOUR
      double start1, end1, start2, end2, start3, end3;
      OOPEXAM oop = new OOPEXAM();
      
      
      oop.inputData();
      
      oop.outputData();
      
      start1 = System.currentTimeMillis();
      oop.mean();
      end1 = System.currentTimeMillis();
      end1 = (end1 - start1)/100000;
      String meanFormatted = oop.format(end1);
      System.out.println("The mean formatted to two decimal places is "+ meanFormatted);
      
      
      
      start2 = System.currentTimeMillis();
      oop.bubblesort();
      System.out.println("   ");
      oop.outputData();
      oop.median();
      end2 = System.currentTimeMillis();
      end2 = (end1 - start1)/100000;
      String medianFormatted = oop.format(end2);
      System.out.println("The mean formatted to two decimal places is "+ meanFormatted);
      
      
      
      
      
      
        
    }
    
}
