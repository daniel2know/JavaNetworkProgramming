


package profassignment;
import java.util.*;
import java.net.*;
import java.io.*;



public class Server {
    
    
     public static void main(String[] args) throws Exception {
         
         

         
             
             Server s = new Server();
             ServerSocket ss = new ServerSocket(6928);
             
             while (true){
                 
                 Socket sc;
                 try {

                     sc = ss.accept();
                     System.out.println("client participants that connected " + sc);

                     DataInputStream dis = new DataInputStream(sc.getInputStream());
                     DataOutputStream dos = new DataOutputStream(sc.getOutputStream());

                     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                     
                     Thread t = new Clients(sc,dos,dis,br);
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
    static String s9 = "---------------------------------";
    static String s10 = "Game is over and here is the statistics of the game";
    static String s11 = "--------------------------------------";

    
    public static ArrayList<String> colours = new ArrayList<>();
    public static ArrayList<String> coloursHint = new ArrayList<>();
    public static ArrayList<String> coloursAns = new ArrayList<>();
    
    public  String colour( int selectedIndex){
        colours.add("_ P P _ _  _ R _ _ N");
        colours.add("A _ _ I _ O T");
        colours.add("A _ U _ R _ M _ N _");
        colours.add("P _ A _ _ ");
        colours.add("G _ L _");
        colours.add("P _ N _");
        colours.add("_ _ O _ _ T");
        colours.add("L _ _ _ I _ O _");
        colours.add("R _ _ Y");
        colours.add("B _ _ _ N");
        
      
        
        myselectedColourtwo = mySelectedColourIndex ;
        
        
        String colourResult = colours.get(myselectedColourtwo);
        return colourResult;
        
     }
    
    private String gamestat(){
        String res;
        res = " You answered "+ pointCorrect + " correctly and "+ pointNotCorrect + " wrongly Out of " + totalAmountOFTimePlayed;
        return res;
    }
    
    public  String colourAnswer( int selectedIndex){
        coloursAns.add("APPLEGREEN");
        coloursAns.add("APRICOT");
        coloursAns.add("AQUAMARINE");
        coloursAns.add("PEACH");
        coloursAns.add("GOLD");
        coloursAns.add("PINK");
        coloursAns.add("VIOLET"); 
        coloursAns.add("LOLLIPOP");
        coloursAns.add("RUBY");
        coloursAns.add("BROWN");
        
      
        
        String colourAnswerHint = coloursAns.get(myselectedColourtwo);
        return colourAnswerHint;
        
     }
    
    
    public String colourHint( int selectedIndex){
        coloursHint.add(" Something you eat and it has a nigeria colour in it");
        coloursHint.add(" just think of the colour........");
        coloursHint.add(" Lyk water and a machine inside water with its first three letters removed");
        coloursHint.add(" Lyk a thing used for sport games between two teams");
        coloursHint.add(" Lyk a thing given to an athlete that came first");
        coloursHint.add("Just think of what the colour is.........");
        coloursHint.add(" Just think of what the colour is.......");
        coloursHint.add(" Lyk one of the names of an android version....");
        coloursHint.add(" Lyk one of the name of a programming language");
        coloursHint.add(" Just think of the colour.........");
        
        String colourResultHint = coloursHint.get(myselectedColourtwo);
        
        
        return colourResultHint;
        
     }
    
    
    @Override
    public void run(){
        
        try{
            String s1 = "Lets play a colour name, enter the number of times of you want to play if you get above average the number of times you played then you can move on to the next stage else you will repeat this stage";
                     dos.writeUTF(s1);

                     String s2 = dis.readUTF();
                     totalAmountOFTimePlayed = Integer.parseInt(s2);
                     System.out.println("message form client: " + s2);
                     String s3;
                     String s4;
                     String s5;
                     String s6;
                     String Ans;
                     String s7;
                     String s8;

                     for (int i = 0; i < Integer.parseInt(s2); i++) {

                         Random x = new Random();
                         mySelectedColourIndex = x.nextInt(9);

                         s3 = colour(mySelectedColourIndex);
                         s4 = colourHint(mySelectedColourIndex);
                         dos.writeUTF(s3);
                         dos.writeUTF(s4);
                         s5 = dis.readUTF();
                         System.out.println("message form client: " + s5);

                         Ans = colourAnswer(mySelectedColourIndex);

                         if (s5.equals(Ans)) {
                             s6 = " Message form client:  Correct you have a point";
                             dos.writeUTF(s6);
                             pointCorrect += 1;
                         } else {
                             s6 = " Message form server: Wrong you lost a point";
                             dos.writeUTF(s6);
                             pointNotCorrect += 1;
                         }

                     }

                     s7 = gamestat();

                     dos.writeUTF(s9);
                     dos.writeUTF(s10);
                     dos.writeUTF(s11);
                     dos.writeUTF(s7);

                     if (pointCorrect > (totalAmountOFTimePlayed / 2)) {
                         s8 = "Welcome to the next stage....";
                         dos.writeUTF(s8);
                     } else {
                         s8 = "Oh no you are not qualified for the next stage...";
                         dos.writeUTF(s8);
                     }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
    }
    
}
