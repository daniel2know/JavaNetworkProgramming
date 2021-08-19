
package ebunassignment;
import java.util.*;
import java.net.*;
import java.io.*;

public class Server {
    
    public static void main(String[] args) throws Exception {

        Server s = new Server();
        ServerSocket ss = new ServerSocket(8923);

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

    
    public static ArrayList<String> countries = new ArrayList<>();
    public static ArrayList<String> countriesAns = new ArrayList<>();
    
    public  String countries( int selectedIndex){
        countries.add("CHILE");
        countries.add("ANGOLA");
        countries.add("BELGIUM");
        countries.add("BOTSWANA");
        countries.add("CHINA");
        countries.add("EGYPT");
        countries.add("ITALY");
        countries.add("JAPAN");
        countries.add("LESOTHO");
        countries.add("NIGERIA");
        
      
        
        myselectedColourtwo = mySelectedColourIndex ;
        
        
        String colourResult = countries.get(myselectedColourtwo);
        return colourResult;
        
     }
    
    private String gamestat(){
        String res;
        res = " You answered "+ pointCorrect + " correctly and "+ pointNotCorrect + " wrongly Out of " + totalAmountOFTimePlayed;
        return res;
    }
    
    public  String countriesAns( int selectedIndex){
        countriesAns.add("SANTIAGO");
        countriesAns.add("LUANDA");
        countriesAns.add("BRUSSELS");
        countriesAns.add("GABORONE");
        countriesAns.add("BEIJING");
        countriesAns.add("CAIRO");
        countriesAns.add("ROME"); 
        countriesAns.add("TOKYO");
        countriesAns.add("MASERU");
        countriesAns.add("ABUJA");
        
      
        
        String countriesAnswerHint = countriesAns.get(myselectedColourtwo);
        return countriesAnswerHint;
        
     }
    
    
    
    @Override
    public void run(){
        
        try{
            
            String s1 = "How well dou you know the caplital of different counteries!!!! well let play this game to see: Enter the number of times you want to play";
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
                 
                 s3 = countries(mySelectedColourIndex);
                 dos.writeUTF(s3);
                 s5 = dis.readUTF();
                 System.out.println("message form client: "+s5);
                 
                 Ans = countriesAns(mySelectedColourIndex);
                 
                 if(s5.equals(Ans)){
                     s6 = " Message form client:  Correct you have a point";
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
