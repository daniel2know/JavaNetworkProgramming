
package lindaassignment;
import java.util.*;
import java.net.*;
import java.io.*;

public class Server {
    
    
    
     public static void main(String[] args)  throws Exception{

        Server s = new Server();
        ServerSocket ss = new ServerSocket(7645);

        while (true) {
            
            Socket sc;
            try {
                
            sc = ss.accept();
            System.out.println("client participants that connected " + sc);
                
                DataInputStream dis = new DataInputStream(sc.getInputStream());
                DataOutputStream dos = new DataOutputStream(sc.getOutputStream());

                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

                Thread t = new Clients(sc, dos, dis, br);
                t.start();

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

        }

    }

}




class Clients extends Thread {

    Socket sc;
    DataOutputStream dos;
    DataInputStream dis;
    BufferedReader br;

    public Clients(Socket s, DataOutputStream dos, DataInputStream dis, BufferedReader br) {
        this.sc = s;
        this.dos = dos;
        this.dis = dis;
        this.br = br;
    }
    
    
    
    static Scanner scan = new Scanner(System.in);
    static int myselectedColourtwo;
    static int mySelectedColourIndex;
    static int pointCorrect;
    static int pointNotCorrect;
    static int totalAmountOFTimePlayed;
    static String s9 = "---------------------------------------";
    static String s10 = "Game is over and here is the statistics of the game";
    static String s11 = "--------------------------------------";

    
    public static ArrayList<String> states = new ArrayList<>();
    public static ArrayList<String> statesAns = new ArrayList<>();
    
    public  String state( int selectedIndex){
        states.add("KWARA");
        states.add("EKITI");
        states.add("BENUE");
        states.add("BAYLESA");
        states.add("ABUJA");
        states.add("GOMBE");
        states.add("KEBBI");
        states.add("TARABA");
        states.add("RIVERS");
        states.add("OSUN");
        
      
        
        myselectedColourtwo = mySelectedColourIndex ;
        
        
        String stateResult = states.get(myselectedColourtwo);
        return stateResult;
        
     }
    
    private String gamestat(){
        String res;
        res = " You answered "+ pointCorrect + " correctly and "+ pointNotCorrect + " wrongly Out of " + totalAmountOFTimePlayed;
        return res;
    }
    
    public  String stateAns( int selectedIndex){
        statesAns.add("NORTH CENTRAL");
        statesAns.add("SOUTH WEST");
        statesAns.add("NORTH CENTRAL");
        statesAns.add("SOUTH SOUTH");
        statesAns.add("NORTH CENTRAL");
        statesAns.add("NORTH EAST");
        statesAns.add("NORTH WEST"); 
        statesAns.add("NORTH EAST");
        statesAns.add("SOUTH SOUTH");
        statesAns.add("SOUTH WEST");
        
      
        
        String countriesAnswerHint = statesAns.get(myselectedColourtwo);
        return countriesAnswerHint;
        
     }
    
    
    @Override
    public void run(){
        
        try{
            
             String s1 = "How well dou you know the different regions, different states in Nigeria are located ----> Alright lets play this game to be sure about that: Enter the number of times you want to play";
             dos.writeUTF(s1);
             
             String s2 = dis.readUTF();
             totalAmountOFTimePlayed = Integer.parseInt(s2);
             System.out.println("message form client: "+s2);
             String s3;
             String s4;
             String s5;
             String s6;
             String Ans;
             String s7;
             String s8;
             
             for(int i =0; i< Integer.parseInt(s2); i++){

                 Random x = new Random();
                 mySelectedColourIndex = x.nextInt(9);
                 
                 s3 = state(mySelectedColourIndex);
                 dos.writeUTF(s3);
                 s5 = dis.readUTF();
                 System.out.println("message form client: "+s5);
                 
                 Ans = stateAns(mySelectedColourIndex);
                 
                 if(s5.equals(Ans)){
                     s6 = " Message form client:  Correct you've been awarded a point";
                     dos.writeUTF(s6);
                     pointCorrect+=1;
                 }else{
                     s6 = " Message form server: Wrong you lost a point";
                     dos.writeUTF(s6);
                     pointNotCorrect+=1;
                 }
                 
             }
             
             s7 = gamestat();

             dos.writeUTF(s9);
             dos.writeUTF(s10);
             dos.writeUTF(s11);
             dos.writeUTF(s7);
             
             if(pointCorrect > (totalAmountOFTimePlayed/2)){
                s8 = "Welcome to the next stage....";
                dos.writeUTF(s8);
             }
             else{
                 s8 = "Oh no you are not qualified for the next stage...";
                 dos.writeUTF(s8);
             }
            
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
    }
}