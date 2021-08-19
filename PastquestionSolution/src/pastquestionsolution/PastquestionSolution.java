
package pastquestionsolution;
import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author Tunwashe Daniel
 */
public class PastquestionSolution {
    
//     public  void generate(){
//         int[] A = new int[20];
//        Random random = new Random();
//         int i;
//         for( i = 0; i<20; i++){
//            int randomNumber = random.nextInt(70);
//            A[i] = randomNumber;
//            
//            if(A[i] == 65 || A[i] == 5){
//                
//                
//            }
//        }
//     }
    
    Scanner scan = new Scanner(System.in);
    int m,n,c,d;
    int[][] A = new int[m][n];
    int[][] B = new int[m][n];
    
    
    
    public void enter(){
        
        System.out.println("Enter the size of the array in terms of m by n ie): 2 by 3 matrix, 4 by 4 matrix ");
        m = scan.nextInt();
        n = scan.nextInt();
        
        
        for(c=0; c<m; c++){
            for(d=0; d<n; d++){
                System.out.print("Enter the value for Row "+c+ " Column"+d+" For matrix A: ------>");
                A[c][d] = scan.nextInt();
            }
        }
        
        System.out.print("\n");
        
        for(c=0; c<m; c++){
            for(d=0; d<n; d++){
                System.out.print("Enter the value for Row "+c+ " Column"+d+" For matrix B: ------>");
                B[c][d] = scan.nextInt();
            }
        }
        
        
    }
    
    
    public void addMatrix(){
        
        
        
    }
    
    
    public void multiplyMatrix(){
        
        
        
    }
    
    public void welcome(){
        int selection;
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter 1: To enter values into two matrix\nPlease enter 2: To add the two matrix together\nPlease enter 3: To multiply the two matrix together\nPlease press 4: To Exit the application");
        selection = scan.nextInt();
        
        PastquestionSolution past = new PastquestionSolution();
                
        switch(selection){
            
            case 1:
                System.out.print("\n");
                past.enter();
                System.out.print("\n");
                System.out.println("Entery performed");
                System.out.print("\n");
                past.welcome();
                
                
                break;
            case 2:
                System.out.print("\n");
                past.addMatrix();
                System.out.print("\n");
                System.out.println("Addition performed");
                System.out.print("\n");
                past.welcome();
                break;
            case 3:
                System.out.print("\n");
                past.multiplyMatrix();
                System.out.print("\n");
                System.out.println("Multiplication performed");
                System.out.print("\n");
                past.welcome();
                break;
            case 4:
                System.out.print("\n");
                System.out.println("Thank you.....");
                break;
                
            default:
                System.out.print("\n");
                System.out.println("Error eccoured you entered the wrong option... pls check the options again. A nd press 4 to Exit the application");
                System.out.print("\n");
                past.welcome();
                System.out.print("\n");
                break;
            
        }
            
                
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
//        int[] A = new int[20];
//        Random random = new Random();
//        int i;
//        
//        
        PastquestionSolution past = new PastquestionSolution();
//         
//        past.generate();
        
        
        
        //Program to for user to select operation entering addition and multiplication of matrix through switch case statements
        
        past.welcome();
        
        
        
        
         
    }
    
}
