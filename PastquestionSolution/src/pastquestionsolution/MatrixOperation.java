
package pastquestionsolution;
import java.util.Scanner;
/**
 *
 * @author Tunwashe Daniel
 */
public class MatrixOperation {
    
    public static void main(String agrs[]){
        
        int selection, m,n,c,d,p,q,k,sum=0;
        Scanner scan = new Scanner(System.in);
        System.out.println("Select the various options to perform the following operation\nPress 1: enter values into two matrix\n Press 2: to add the the two matrix together\n Press 3 : to multiply two two matrix");
        selection = scan.nextInt();
        System.out.print("Enter the size of the matrix in terms of row and column for matrix A: ");
         m= scan.nextInt();
         n= scan.nextInt();
         
         System.out.print("\n");
         
        System.out.print("Enter the size in terms of row and coloumn for matrix B: ");
        p = scan.nextInt();
        q= scan.nextInt();
        
        
        int [][] A = new int[m][n];
        int [][] B = new int[p][q];
        
        
        
        int [][] addAB = new int[m][n];
        int [][] mulAB = new int[m][q];
        
        switch(selection){
            case 1:

                
                if(m!=p && n!=q){
                    
                    System.out.println("Something went wrong invalid size of array for entry to be performed");
                    
                    
                }
                else{
                    System.out.println("Enter the values for the first matrix: matrix A: \n");
                for(c=0; c<m; c++){
                    for(d=0; d<n; d++){
                        
                        A[c][d] = scan.nextInt();
                    }
                }
                
                
                System.out.println("Enter the values for the first matrix: matrix B: ");
                for(c=0; c<p; c++){
                    for(d=0; d<q; d++){
                        
                        B[c][d] = scan.nextInt();
                    }
                }
                }
                
                break;
                
            case 2:

                for(c=0;c<m;c++){
                    for(d=0;d<n;d++){
                        addAB[c][d] = A[c][d] + B[c][d];
                    }
                }
                break;
                
            case 3:
                if( n!= p){
                    System.out.print("The matrices cant be multiplied with each other");
                }
                else{
                    
                    for(c=0; c<m; c++){
                        for(d=0; d<q; d++){
                            for(k=0; k<p; k++){
                                sum = sum + A[c][k] * B[k][d];
                                mulAB[c][d] = sum;
                                sum =0;
                            }
                        }
                    }
                    
                    for(c=0; c<m; c++){
                        for(d=0; d<q; d++){
                            System.out.print(mulAB[c][d] + "\t");
                            System.out.print("\n");
                        }
                    }
                }
                break;
            default:
                System.out.print("Error");
                break;
        }
        
    }
    
}
