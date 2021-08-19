
package deengame;
import java.net.*;
import java.io.*;
import java.util.*;

public class Server {
    
    public static ArrayList<String> words = new ArrayList<String>();
    public static ArrayList<String> Answers = new ArrayList<String>();
    static int wordIndex;
    static String s5;
    static String s6;
    
    
    public static void populateWords(){
        words.add("TMAE");
        words.add("ESOL");
    }
    
    public static void populateAnswers(){
        Answers.add("TEAM");
        Answers.add("EAT");
        Answers.add("AT");
        Answers.add("MAT");
        Answers.add("TEA");
        Answers.add("ME");
        Answers.add("MEAT"); 
        Answers.add("LOSE");
        Answers.add("SOLE");
        Answers.add("SOEL");
        Answers.add("SO");
        Answers.add("SOE");
    }
    
    
    public static void checkClientAnswers(){
        for( int i =0; i< Answers.size(); i++){
            if(Answers.get(i).equals(s5)){
                s6 = "Yea you are correct you have  earned a point";
            }
            else{
                s6 = "Oops... you are worong and you have lost a point";
            }
        }
    }
    
     public static void main(String[] args) {
         
         try{
             ServerSocket ss = new ServerSocket(5678);
             Socket s = ss.accept();
             
             DataInputStream dis = new DataInputStream(s.getInputStream());
             DataOutputStream dos = new DataOutputStream(s.getOutputStream());
             
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             populateWords();
             populateAnswers();
             
            
             
             String s1 = "------------------------------->Hello Client let's play a word re-arranging game, let's see how well you can re-arrange words<----------------------";
             dos.writeUTF(s1);
             String s2 = "Enter the number of times you want to play the game";
             dos.writeUTF(s2);
             
             String s3 = dis.readUTF();
             String s4;
             
             
             for(int i =0; i<Integer.parseInt(s3); i++){
                 Random x = new Random();
                 wordIndex = x.nextInt(1);
                 
                 s4 = "Re-arrange this word to make a meaningful word ----> " + words.get(wordIndex);
                 dos.writeUTF(s4);
                 s5 = dis.readUTF();
                checkClientAnswers();
                 dos.writeUTF(s6);
             }
             
         }
         catch(IOException ex){
             
             System.out.println(ex.getMessage());
         }
         
        
    }
    
}
