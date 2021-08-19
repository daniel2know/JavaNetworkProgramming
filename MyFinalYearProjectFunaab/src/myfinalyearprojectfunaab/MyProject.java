
package myfinalyearprojectfunaab;

import com.sun.glass.events.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.sql.PreparedStatement;
import javax.swing.table.DefaultTableModel;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class MyProject extends javax.swing.JFrame {
    
    
    Connection con;
    Statement stm;
    ResultSet rs;
    int cuRow;
    PreparedStatement ps = null;
    Color paneldefault;
    Color panelClick;
    Color neCol;
    static int countcand = 0;
    static int countweight = 0;
    
    Statement stm2;
    ResultSet rs2;
    
    // for weighted jaccard
    
    static float minRes;
    static float maxRes;
    static String difference = "";
    static String differencetwo;
    static String differencethree;
    static float totalRes;
    static String totalResFormatted;
    static double restotal = 0;
    static double total;
    static int sum;
    static float length = 0;
    static float res2 = (float) 0.0;
    static boolean isOut = false;
    static long start1,end1;
    static long start2,end2;
    static String timeCandidate;
    static String timeWeighted;
    static float smValue;
    static float smValue2;
    static boolean threadWeightedDone = false;
    static boolean ThreadCandidateDone = false;
    static int noOfRec = 0;
    static String resultUnion;
    
    
    static DecimalFormat df = new DecimalFormat("#.#");
    
    // for candidate key algrithm
    public static Scanner scan = new Scanner(System.in);
    static String res;
    public static ArrayList<String> store = new ArrayList<>();
    public static ArrayList<String> store1 = new ArrayList<>();
    public static ArrayList<String> store2 = new ArrayList<>();
    public static Set<String> set1;
    static boolean showrec = false;
    int tblIndex = 0;
    static double totalPrecentage;
    static int sizeOfDatabase;
    static int sizeOfDatabaseTwo;
    
    static float AvgsimValueJaccard;
    static float AvgProcessingTimeJaccard;
    static double AvgProcessingTimeJaccardRound;
    static float AvgProcessingTimeAllRecords = 0;
    static float totalSimilarityValueJaccard;
    static int numberOfRetrievedValue;
    static float costJaccard;
    
    static float AvgsimValueCandidate;
    static float AvgProcessingTimeCandidateRound;
    static long AvgProcessingTimeCandidate;
    static float totalSimilarityValueCandidate;
    static int numberOfRetrievedValueCandidate;
    static float costCandidate;
    
    
    
    
    
    
    // jaccard simlarity methods
    
    public void min(String input1, String input2){
        
        MyProject mp = new MyProject();
        differencetwo = mp.getdifference(input1, input2);
        
        
        minRes = ((input1.length() + input2.length()) - differencetwo.length())/2;
        //System.out.println(minRes);
        
    }
    
    public String getdifference(String input1, String input2){ 
        char[] c = input1.toCharArray();
        
        for (char ch: c){
            if(!input2.contains("" + ch)) {
                difference+=ch;
              
            }
        }
        //System.out.println(difference);
        return difference;
    }
    
    public void max(String input1, String input2){
       
        maxRes = ((input1.length() + input2.length()) + differencetwo.length())/2;
        //System.out.println(maxRes);
    } 
    
    
    public void getSimilarity(float min, float max){
         smValue = min/max;
        totalRes = ((min/max)*100);
        //System.out.println(totalRes);
    
    }
    
  
    //candidate key algorithm methods
    public void powerSet(String str, int index, String curr){
        int n = str.length();
        
        if(index == n){
            //System.out.println(curr);
            store.add(curr);
            return;
        }
        
        powerSet(str, index +1, curr + str.charAt(index));
        powerSet(str,index + 1, curr);
    }
    
     public void saveIntoAnother(ArrayList<String> save){
         for (int i=0; i<store.size(); i++){
             if(i == (store.size() -1) )
                 continue;
            save.add(store.get(i));     
        }
         
         set1 = new HashSet<>(save);
         save.clear();
         save.addAll(set1);
     }
     
     public void printArray(ArrayList<String> savedList){
         System.out.println("--------------------------------");
         for(int i=0; i<savedList.size(); i++){
             System.out.println(savedList.get(i));
         }
         System.out.println("--------------------------------");
     }
     
     public void clearArrayList(){
         store.clear();
     }
     
     public void clearstoretwo(){
         store2.clear();
     }
     
     public String Union(String nameOne, String nameTwo){
        
        String s = (nameOne + nameTwo).toLowerCase();
        int i =0;
        while(i < s.length()){
            char c = s.charAt(i);
            if( i != s.lastIndexOf(c))
                s = s.substring(0, i) + s.substring(i+1, s.length());
            else i++;
        }
        return s;
    }
     
     public void compare(ArrayList<String> Aone, ArrayList<String> Atwo){
         try{
             total = 0;
             sum = 0;
//             System.out.println(Aone.size());
//             System.out.println(Atwo.size());

//                if(Atwo.size() == Aone.size()){
//                    for(int i =0; i< Aone.size(); i++){
//                        for(int j =0; j< Aone.size(); j++){
//                            if(i != Aone.size() +1){
//                                if(Aone.get(i).equals(Atwo.get(j))){
//                                    sum+=1;
//                                }
//                            }
//                        }
//                    }
//                    length = Aone.size();
//                }
//                
//                
//                
//                if(Atwo.size() > Aone.size()){
//                    for(int i =0; i< Aone.size(); i++){
//                        for(int j =0; j< Atwo.size(); j++){
//                            if(i != Aone.size() +1){
//                                if(Aone.get(i).equals(Atwo.get(j))){
//                                    sum+=1;
//                                }
//                            }
//                        }
//                    }
//                    length = Aone.size();
//                }


              if(Aone.size() == Atwo.size()){
                  for(int i =0; i<Aone.size(); i++){
                  if(Aone.get(i).equals(Atwo.get(i))){
                      sum+=1;
                  }
              }
              }
              else{
                  sum=0;
              }

             res2 = (float) sum / Aone.size();
             total = (Math.round(res2 * 100.0) / 100.0);
             totalPrecentage = (total * 100);
             

//               res2 = sum / length;
////             System.out.println(sum);
////             System.out.println(length);
//               total = (Math.round(res2 * 100.0)/100.0);
//               totalPrecentage = (total * 100);
////             System.out.println(total);
         } catch (Exception ex) {
             JOptionPane.showMessageDialog(this, ex.getMessage());
         }

    }
    
     
   // round up a specified decimal number format to a specified value
   public  String roundNumb(double num){
  
    NumberFormat nf = NumberFormat.getInstance();
    nf.setMaximumIntegerDigits(2);
    nf.setMinimumIntegerDigits(2);
    
    return(nf.format(num));
    
}
     // round up a specified decimal number format to a specified value
   public  String roundNumbtwo(double num){
  
    NumberFormat nf = NumberFormat.getInstance();
    nf.setMaximumIntegerDigits(2);
    nf.setMinimumIntegerDigits(2);
    
    return(nf.format(num));
    
}
    
    
    
    // connection string
    public void konet(){
        try{
            
        String host = "jdbc:derby://localhost:1527/InformationKeeper";
        String uName = "daniel";
        String uPass = "12345";
        
        
        
        // WE WILL THEN USE CONNECTION TO CONNECT AND PICK THE CONNECTION THAT WILL CONTAIN THREE VARIABLE AS SPECIFIED IN THE 
        con = DriverManager.getConnection(host, uName, uPass);
        
        stm = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
        
        // THIS CREATE STATEMENT ALLOWS US TO SLECT MODE
        
        }catch(SQLException err){
            
            JOptionPane.showMessageDialog(MyProject.this, err.getMessage());
        }
        
    }
    // populate table from records in the database
    private void displayRecordsFromDb(){
        
        try{
            
            Statement stm = con.createStatement();
            String sql = "select * from UPLOADTBLONEHUNDRED order by Surname ASC";
            ResultSet rs  = stm.executeQuery(sql);
            while(rs.next()){
                String surname  = rs.getString("SURNAME");
                String firstname  = rs.getString("FIRSTNAME");
                String middlename  = rs.getString("MIDDLENAME");
                String accounttype  = rs.getString("ACCOUNTTYPE");
                String branch  = rs.getString("BRANCH");
                String category  = rs.getString("CATEGORY");
                String mstatus  = rs.getString("MARITALSTATUS");
                String validationmeans  = rs.getString("VALIDATIONIDENTIFICATION");
                String nationality  = rs.getString("NATIONALITY");
                String citizenship  = rs.getString("DUALCITIZENSHIP");
                
                
                String tbData[] = {surname,firstname,middlename,accounttype,branch,category,mstatus,validationmeans,nationality,citizenship};
                DefaultTableModel tblModel = (DefaultTableModel)tblviewall.getModel();
                
                tblModel.addRow(tbData);
                noOfRec +=1;
            }
            
            lblNoOfRecordsInDb.setText(Integer.toString(noOfRec));
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, "Cannot retrieve data from Database "+ ex.getMessage());
        }

}
 
    
    // thread class that runs concurrently...........
 class myThreadWeighted extends Thread{
     MyProject mp = new MyProject();
     @Override
     public void run(){
         
                try{

                    start2 = System.currentTimeMillis();
                    Statement stm = con.createStatement();
                    String sql = "select * from UPLOADTBLONEHUNDRED";
                    ResultSet rs = stm.executeQuery(sql);
                    
                    while(rs.next()){
                        
                        String surname = rs.getString("SURNAME");
                        String firstname = rs.getString("FIRSTNAME");
                        String middlename = rs.getString("MIDDLENAME");
                        String accounttype = rs.getString("ACCOUNTTYPE");
                        String branch = rs.getString("BRANCH");
                        String category = rs.getString("CATEGORY");
                        String mstatus = rs.getString("MARITALSTATUS");
                        String validationmeans = rs.getString("VALIDATIONIDENTIFICATION");
                        String nationality = rs.getString("NATIONALITY");
                        String citizenship = rs.getString("DUALCITIZENSHIP");
                        mp.min(searchlbl.getText().toUpperCase(), surname);
                        mp.max(searchlbl.getText().toUpperCase(), surname);
                        mp.getSimilarity(minRes, maxRes);
                        String similarityValue = Float.toString(smValue);
                        
                        if(totalRes >= 85.0){

                            String tbData[] = {surname, firstname, middlename, accounttype, branch, category, mstatus, validationmeans, nationality, citizenship, similarityValue};
                            DefaultTableModel tblModel = (DefaultTableModel) tblviewallone.getModel();
                            tblModel.addRow(tbData);
                            
                            totalSimilarityValueJaccard += smValue;
                            numberOfRetrievedValue += 1;

                        }
                        
                        
                        differencetwo = "";
                        maxRes = 0;
                        minRes = 0;
                        differencethree = "";
                        totalRes = 0;
                        difference = "";
                        smValue = 0;
                        
                        sizeOfDatabase+=1;
                    }

//                    Thread.sleep(2);
                    end2 = System.currentTimeMillis();
                    end2 = ((end2 - start2));
                    end2 = (end2  * 1000);
                    //AvgProcessingTimeAllRecords += end2;
                    AvgProcessingTimeJaccard =  ((end2 / sizeOfDatabase));
                    //AvgProcessingTimeJaccardRound = (Math.round(AvgProcessingTimeJaccard * 100.0) / 100.0);
                    //timeWeighted = mp.roundNumb(AvgProcessingTimeJaccard);
                    lblwjt.setText(AvgProcessingTimeJaccard + " micro sec");
                    AvgsimValueJaccard = (totalSimilarityValueJaccard / numberOfRetrievedValue);
                    costJaccard = (AvgsimValueJaccard / AvgProcessingTimeJaccard);
                    costJaccard = (float) (Math.round(costJaccard * 1000000.0) / 1000000.0);
                    lblcaw.setText(costJaccard + "");
                    lblavgsimvaluew.setText(Float.toString(AvgsimValueJaccard));
                    threadWeightedDone = true;
                    if (threadWeightedDone) {
                        JOptionPane.showMessageDialog(null, "Searching complete for Weighted Jaccard Algorithm..");
//                        JOptionPane.showMessageDialog(null, end2);
//                        JOptionPane.showMessageDialog(null, AvgProcessingTimeJaccard);
//                        JOptionPane.showMessageDialog(null, AvgProcessingTimeJaccard * 1000 + "microsec");
//                        JOptionPane.showMessageDialog(null, sizeOfDatabase);
                          JOptionPane.showMessageDialog(null, numberOfRetrievedValue);
//                        JOptionPane.showMessageDialog(null, totalSimilarityValueJaccard);
//                        JOptionPane.showMessageDialog(null, AvgsimValueJaccard);
//                        JOptionPane.showMessageDialog(null, costJaccard);
                }
                    
                }catch(Exception ex){
                    
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
                
                
     }
    
}
 
 
 class myThreadCandidate extends Thread{
     MyProject mp = new MyProject();
     @Override
     public void run(){
          
                try{
                    
                    int index = 0;
                    String curr = "";
                   

                    start1 = System.currentTimeMillis();
                    Statement stm = con.createStatement();
                    String sql = "select * from UPLOADTBLONEHUNDRED";
                    ResultSet rs = stm.executeQuery(sql);
                    rs2 = stm2.executeQuery(sql);
                    
                    mp.powerSet(searchlbl.getText().toUpperCase(), index, curr);
                    mp.saveIntoAnother(store1);
                    while (rs.next()) {
                        
                        
                        String surname = rs.getString("SURNAME");
                        String firstname = rs.getString("FIRSTNAME");
                        String middlename = rs.getString("MIDDLENAME");
                        String accounttype = rs.getString("ACCOUNTTYPE");
                        String branch = rs.getString("BRANCH");
                        String category = rs.getString("CATEGORY");
                        String mstatus = rs.getString("MARITALSTATUS");
                        String validationmeans = rs.getString("VALIDATIONIDENTIFICATION");
                        String nationality = rs.getString("NATIONALITY");
                        String citizenship = rs.getString("DUALCITIZENSHIP");
                        

                        
                        // clear the arraylist
                        mp.clearArrayList();
                        
                        mp.powerSet(surname, index, curr);
                        mp.saveIntoAnother(store2);
                        
                        
                        mp.compare(store1, store2);
 
                        if(totalPrecentage >= 85.0){
                            String tbData[] = {surname, firstname, middlename, accounttype, branch, category, mstatus, validationmeans, nationality, citizenship, Double.toString(total)};
                            DefaultTableModel tblModel = (DefaultTableModel) tblviewalltwo.getModel();
                            tblModel.addRow(tbData);
                            tblIndex +=1;
                            
                            totalSimilarityValueCandidate +=total;
                            numberOfRetrievedValueCandidate+=1;
                        }
                        
                        sizeOfDatabaseTwo+=1;
                        mp.clearArrayList();
                        mp.clearstoretwo();

                        sum = 0;
                        smValue2 = 0;
//                        total = 0.0;
//                        res2 = (float) 0.0;
//                        length = 0; 
                    }
                    
                    if(tblIndex == 0){
                        JOptionPane.showMessageDialog(null, "No record found for the specified or typed query");
                    }
//                    Thread.sleep(2);
                    
                    end1 = System.currentTimeMillis();
                    end1 = ((end1 - start1));
                    end1 = (end1  * 1000);
                    AvgProcessingTimeCandidate =  ((end1 / sizeOfDatabaseTwo));
                    //timeCandidate = mp.roundNumbtwo(end1);
                    lblcat.setText(AvgProcessingTimeCandidate + " micro sec");
                    AvgsimValueCandidate = (totalSimilarityValueCandidate / numberOfRetrievedValueCandidate);
                    costCandidate = (AvgsimValueCandidate / AvgProcessingTimeCandidate);
                    costCandidate = (float) (Math.round(costCandidate * 1000000.0) / 1000000.0);
                    lblcac.setText(costCandidate+ "");
                    lblavgsimvaluec.setText(Float.toString(AvgsimValueCandidate));
                    ThreadCandidateDone = true;
                if(ThreadCandidateDone){
                    JOptionPane.showMessageDialog(mp, "Searching complete for candidate key Algorithm..");
//                    JOptionPane.showMessageDialog(null, end1);
//                    JOptionPane.showMessageDialog(null, AvgProcessingTimeCandidate);
//                    JOptionPane.showMessageDialog(null, AvgProcessingTimeCandidate * 1000 + "microsec");
                      JOptionPane.showMessageDialog(null, numberOfRetrievedValueCandidate);
//                    JOptionPane.showMessageDialog(null, totalSimilarityValueCandidate);
//                    JOptionPane.showMessageDialog(null, AvgsimValueCandidate);
//                    JOptionPane.showMessageDialog(null, costCandidate);
                }

                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
                
                
     }
 }
       
    
    
    
    public MyProject() {
        initComponents();
        konet();
        lblUserType.setText("");
        
        panelUpload.setVisible(false);
        panelSearch.setVisible(false);
        panelViewRec.setVisible(false);
        panelAbout.setVisible(false);
        panelLogout.setVisible(false);
        panelLoginPage.setVisible(false);
        panelHome.setVisible(false);
        
        
        panelSearchPage.setVisible(false);
        panelViewRecPage.setVisible(false);
        panelAboutPage.setVisible(false);
        panelSignUpPage.setVisible(false);
        panelLoginPage.setVisible(false);
        panelViewIndividualRec.setVisible(false);
        panelUploadPage.setVisible(false);
        panelHomePage.setVisible(false);
        panelToLogin.setVisible(true);
        
        
        
      
        
        
        paneldefault = new Color(255, 255, 255);
        panelClick = new Color(124, 25, 83);
        panel1.setBackground(paneldefault);
        panel2.setBackground(paneldefault);
        
        
        tblviewall.setRowHeight(70);
        
        displayRecordsFromDb();
        
        
//        MyThreadWeighted mtw = new MyThreadWeighted();
//        MyThreadCandidate mtc = new MyThreadCandidate();
//        mtw.start();
//        mtc.start();
        
        
        
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblUserType = new javax.swing.JLabel();
        panelContainer = new javax.swing.JPanel();
        panelUpload = new javax.swing.JPanel();
        panel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        panelHome = new javax.swing.JPanel();
        panel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        panelSearch = new javax.swing.JPanel();
        panel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        panelViewRec = new javax.swing.JPanel();
        panel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        panelAbout = new javax.swing.JPanel();
        panel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        panelLogout = new javax.swing.JPanel();
        panel6 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        panelHomePage = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        panelUploadPage = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        firstname = new javax.swing.JTextField();
        seperatorusername1 = new javax.swing.JSeparator();
        jLabel31 = new javax.swing.JLabel();
        middlename = new javax.swing.JTextField();
        seperatorusername2 = new javax.swing.JSeparator();
        jLabel32 = new javax.swing.JLabel();
        surname = new javax.swing.JTextField();
        seperatorusername3 = new javax.swing.JSeparator();
        jLabel33 = new javax.swing.JLabel();
        seperatorusername4 = new javax.swing.JSeparator();
        cmbaccounttype = new javax.swing.JComboBox<>();
        jLabel34 = new javax.swing.JLabel();
        seperatorusername5 = new javax.swing.JSeparator();
        cmbbranch = new javax.swing.JComboBox<>();
        jLabel40 = new javax.swing.JLabel();
        seperatorusername6 = new javax.swing.JSeparator();
        cmbcoaccount = new javax.swing.JComboBox<>();
        jLabel41 = new javax.swing.JLabel();
        seperatorusername7 = new javax.swing.JSeparator();
        cmbmaritalstatus = new javax.swing.JComboBox<>();
        jLabel42 = new javax.swing.JLabel();
        seperatorusername8 = new javax.swing.JSeparator();
        cmbmeansofid = new javax.swing.JComboBox<>();
        jLabel43 = new javax.swing.JLabel();
        seperatorusername9 = new javax.swing.JSeparator();
        cmbnationality = new javax.swing.JComboBox<>();
        jLabel44 = new javax.swing.JLabel();
        seperatorusername10 = new javax.swing.JSeparator();
        cmbcitizenship = new javax.swing.JComboBox<>();
        btndelete = new javax.swing.JButton();
        btnSubmit1 = new javax.swing.JButton();
        btnupdate = new javax.swing.JButton();
        panelSearchPage = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblviewalltwo = new javax.swing.JTable();
        jLabel46 = new javax.swing.JLabel();
        searchlbl = new javax.swing.JTextField();
        seperatorusername11 = new javax.swing.JSeparator();
        jLabel50 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblviewallone = new javax.swing.JTable();
        lblwjt = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        lblcat = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        lblcaw = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        lblcac = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        lblavgsimvaluec = new javax.swing.JLabel();
        lblavgsimvaluew = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        panelViewRecPage = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblviewall = new javax.swing.JTable();
        jLabel57 = new javax.swing.JLabel();
        lblNoOfRecordsInDb = new javax.swing.JLabel();
        panelAboutPage = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        panelSignUpPage = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        username1 = new javax.swing.JTextField();
        btnLogin4 = new javax.swing.JButton();
        jLabel49 = new javax.swing.JLabel();
        password1 = new javax.swing.JPasswordField();
        seperatorusername12 = new javax.swing.JSeparator();
        seperatorpass1 = new javax.swing.JSeparator();
        panelLoginPage = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        btnLogin2 = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        seperatorusername = new javax.swing.JSeparator();
        seperatorpass = new javax.swing.JSeparator();
        panelViewIndividualRec = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        panelToLogin = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        btnLogin3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myfinalyearprojectfunaab/Cancel_48px.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1276, 0, 54, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myfinalyearprojectfunaab/Administrator Male_48px.png"))); // NOI18N
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel11.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel11.setText("Welcome");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 3, -1, 50));

        lblUserType.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        lblUserType.setText("Welcome");
        jPanel1.add(lblUserType, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 3, -1, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1330, 50));

        panelContainer.setBackground(new java.awt.Color(0, 18, 50));
        panelContainer.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelUpload.setBackground(new java.awt.Color(0, 51, 153));
        panelUpload.setForeground(new java.awt.Color(255, 255, 255));
        panelUpload.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelUploadMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelUploadMousePressed(evt);
            }
        });

        panel2.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 16, Short.MAX_VALUE)
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 46, Short.MAX_VALUE)
        );

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myfinalyearprojectfunaab/Upload_25px.png"))); // NOI18N
        jLabel3.setText("Upload");

        javax.swing.GroupLayout panelUploadLayout = new javax.swing.GroupLayout(panelUpload);
        panelUpload.setLayout(panelUploadLayout);
        panelUploadLayout.setHorizontalGroup(
            panelUploadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelUploadLayout.createSequentialGroup()
                .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(panelUploadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelUploadLayout.createSequentialGroup()
                    .addGap(52, 52, 52)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(53, Short.MAX_VALUE)))
        );
        panelUploadLayout.setVerticalGroup(
            panelUploadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelUploadLayout.createSequentialGroup()
                .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelUploadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelUploadLayout.createSequentialGroup()
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        panelContainer.add(panelUpload, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 53, -1, 46));

        panelHome.setBackground(new java.awt.Color(0, 51, 153));
        panelHome.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                panelHomeMouseMoved(evt);
            }
        });
        panelHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelHomeMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelHomeMousePressed(evt);
            }
        });

        panel1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 16, Short.MAX_VALUE)
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myfinalyearprojectfunaab/Home_25px.png"))); // NOI18N
        jLabel2.setText("Home");

        javax.swing.GroupLayout panelHomeLayout = new javax.swing.GroupLayout(panelHome);
        panelHome.setLayout(panelHomeLayout);
        panelHomeLayout.setHorizontalGroup(
            panelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHomeLayout.createSequentialGroup()
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelHomeLayout.setVerticalGroup(
            panelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHomeLayout.createSequentialGroup()
                .addGroup(panelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE))
                .addContainerGap())
        );

        panelContainer.add(panelHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 230, 46));
        panelHome.getAccessibleContext().setAccessibleDescription("");
        panelHome.getAccessibleContext().setAccessibleParent(this);

        panelSearch.setBackground(new java.awt.Color(0, 51, 153));
        panelSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelSearchMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelSearchMousePressed(evt);
            }
        });

        panel3.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panel3Layout = new javax.swing.GroupLayout(panel3);
        panel3.setLayout(panel3Layout);
        panel3Layout.setHorizontalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 16, Short.MAX_VALUE)
        );
        panel3Layout.setVerticalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 46, Short.MAX_VALUE)
        );

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myfinalyearprojectfunaab/Search_25px.png"))); // NOI18N
        jLabel4.setText("Search");

        javax.swing.GroupLayout panelSearchLayout = new javax.swing.GroupLayout(panelSearch);
        panelSearch.setLayout(panelSearchLayout);
        panelSearchLayout.setHorizontalGroup(
            panelSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSearchLayout.createSequentialGroup()
                .addComponent(panel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 214, Short.MAX_VALUE))
            .addGroup(panelSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelSearchLayout.createSequentialGroup()
                    .addGap(52, 52, 52)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(53, Short.MAX_VALUE)))
        );
        panelSearchLayout.setVerticalGroup(
            panelSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSearchLayout.createSequentialGroup()
                .addComponent(panel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSearchLayout.createSequentialGroup()
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        panelContainer.add(panelSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 106, -1, 46));

        panelViewRec.setBackground(new java.awt.Color(0, 51, 153));
        panelViewRec.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelViewRecMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelViewRecMousePressed(evt);
            }
        });

        panel4.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panel4Layout = new javax.swing.GroupLayout(panel4);
        panel4.setLayout(panel4Layout);
        panel4Layout.setHorizontalGroup(
            panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 16, Short.MAX_VALUE)
        );
        panel4Layout.setVerticalGroup(
            panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 46, Short.MAX_VALUE)
        );

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myfinalyearprojectfunaab/Database View_25px.png"))); // NOI18N
        jLabel5.setText("View Rec");

        javax.swing.GroupLayout panelViewRecLayout = new javax.swing.GroupLayout(panelViewRec);
        panelViewRec.setLayout(panelViewRecLayout);
        panelViewRecLayout.setHorizontalGroup(
            panelViewRecLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelViewRecLayout.createSequentialGroup()
                .addComponent(panel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 214, Short.MAX_VALUE))
            .addGroup(panelViewRecLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelViewRecLayout.createSequentialGroup()
                    .addGap(52, 52, 52)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(26, Short.MAX_VALUE)))
        );
        panelViewRecLayout.setVerticalGroup(
            panelViewRecLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelViewRecLayout.createSequentialGroup()
                .addComponent(panel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelViewRecLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelViewRecLayout.createSequentialGroup()
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        panelContainer.add(panelViewRec, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 159, -1, 46));

        panelAbout.setBackground(new java.awt.Color(0, 51, 153));
        panelAbout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelAboutMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelAboutMousePressed(evt);
            }
        });

        panel5.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panel5Layout = new javax.swing.GroupLayout(panel5);
        panel5.setLayout(panel5Layout);
        panel5Layout.setHorizontalGroup(
            panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 16, Short.MAX_VALUE)
        );
        panel5Layout.setVerticalGroup(
            panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 46, Short.MAX_VALUE)
        );

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myfinalyearprojectfunaab/About_25px.png"))); // NOI18N
        jLabel6.setText("About");

        javax.swing.GroupLayout panelAboutLayout = new javax.swing.GroupLayout(panelAbout);
        panelAbout.setLayout(panelAboutLayout);
        panelAboutLayout.setHorizontalGroup(
            panelAboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAboutLayout.createSequentialGroup()
                .addComponent(panel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 214, Short.MAX_VALUE))
            .addGroup(panelAboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelAboutLayout.createSequentialGroup()
                    .addGap(52, 52, 52)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(53, Short.MAX_VALUE)))
        );
        panelAboutLayout.setVerticalGroup(
            panelAboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAboutLayout.createSequentialGroup()
                .addComponent(panel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelAboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAboutLayout.createSequentialGroup()
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        panelContainer.add(panelAbout, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 212, -1, 46));

        panelLogout.setBackground(new java.awt.Color(0, 51, 153));
        panelLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelLogoutMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelLogoutMousePressed(evt);
            }
        });

        panel6.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panel6Layout = new javax.swing.GroupLayout(panel6);
        panel6.setLayout(panel6Layout);
        panel6Layout.setHorizontalGroup(
            panel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 16, Short.MAX_VALUE)
        );
        panel6Layout.setVerticalGroup(
            panel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 46, Short.MAX_VALUE)
        );

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myfinalyearprojectfunaab/Lock_25px.png"))); // NOI18N
        jLabel7.setText("Logout");

        javax.swing.GroupLayout panelLogoutLayout = new javax.swing.GroupLayout(panelLogout);
        panelLogout.setLayout(panelLogoutLayout);
        panelLogoutLayout.setHorizontalGroup(
            panelLogoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLogoutLayout.createSequentialGroup()
                .addComponent(panel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 214, Short.MAX_VALUE))
            .addGroup(panelLogoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelLogoutLayout.createSequentialGroup()
                    .addGap(52, 52, 52)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(53, Short.MAX_VALUE)))
        );
        panelLogoutLayout.setVerticalGroup(
            panelLogoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLogoutLayout.createSequentialGroup()
                .addComponent(panel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelLogoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLogoutLayout.createSequentialGroup()
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        panelContainer.add(panelLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 265, -1, 46));

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myfinalyearprojectfunaab/System Information_250px.png"))); // NOI18N
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        panelContainer.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 490, 230, 230));

        getContentPane().add(panelContainer, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 230, 720));

        jPanel2.setBackground(new java.awt.Color(32, 47, 90));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelHomePage.setBackground(new java.awt.Color(32, 47, 90));
        panelHomePage.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setFont(new java.awt.Font("Century Gothic", 0, 48)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("INFORMATION RETRIEVAL SYSTEM");
        panelHomePage.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, 822, 95));

        jLabel19.setFont(new java.awt.Font("Century Gothic", 1, 48)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("IR SYSTEM");
        panelHomePage.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 230, 95));

        jLabel20.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Information Retrieval (IR) is the science of searching for documents and information within documents.");
        panelHomePage.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, 30));

        jLabel21.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("This application was created to apply two techniques for retrieving of information.The main objective of this application is to compare the two ");
        panelHomePage.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, 30));

        jLabel22.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("similarity measure techniques in terms of precision and recall rate of retrieving information. The techniques used include:");
        panelHomePage.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, -1, 30));

        jLabel23.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myfinalyearprojectfunaab/Ok_15px.png"))); // NOI18N
        jLabel23.setText("Weighted Jaccard similarity ");
        panelHomePage.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, -1, 30));

        jLabel24.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myfinalyearprojectfunaab/Ok_15px.png"))); // NOI18N
        jLabel24.setText("Candidate Key Algorithm");
        panelHomePage.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, -1, 30));

        jLabel25.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("You can start working on the system by clicking the button below in order to select the various options in the side bar menu:");
        panelHomePage.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 550, -1, 30));

        jPanel2.add(panelHomePage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 720));

        panelUploadPage.setBackground(new java.awt.Color(32, 47, 90));
        panelUploadPage.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel35.setFont(new java.awt.Font("Century Gothic", 0, 48)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myfinalyearprojectfunaab/Ok_15px.png"))); // NOI18N
        jLabel35.setText("UPLOAD");
        panelUploadPage.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, 220, 50));

        jLabel30.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("FIRST NAME");
        panelUploadPage.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 90, 110, 30));

        firstname.setBackground(new java.awt.Color(32, 47, 90));
        firstname.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        firstname.setForeground(new java.awt.Color(18, 159, 72));
        firstname.setBorder(null);
        firstname.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                firstnameMouseClicked(evt);
            }
        });
        panelUploadPage.add(firstname, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 120, 220, 40));

        seperatorusername1.setBackground(new java.awt.Color(18, 159, 72));
        seperatorusername1.setForeground(new java.awt.Color(18, 159, 72));
        panelUploadPage.add(seperatorusername1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 160, 220, 20));

        jLabel31.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("MIDDLE NAME");
        panelUploadPage.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 90, 140, 30));

        middlename.setBackground(new java.awt.Color(32, 47, 90));
        middlename.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        middlename.setForeground(new java.awt.Color(18, 159, 72));
        middlename.setBorder(null);
        middlename.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                middlenameMouseClicked(evt);
            }
        });
        panelUploadPage.add(middlename, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 120, 220, 40));

        seperatorusername2.setBackground(new java.awt.Color(18, 159, 72));
        seperatorusername2.setForeground(new java.awt.Color(18, 159, 72));
        panelUploadPage.add(seperatorusername2, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 160, 220, 20));

        jLabel32.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("SURNAME");
        panelUploadPage.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 130, 30));

        surname.setBackground(new java.awt.Color(32, 47, 90));
        surname.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        surname.setForeground(new java.awt.Color(18, 159, 72));
        surname.setBorder(null);
        surname.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                surnameMouseClicked(evt);
            }
        });
        surname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                surnameKeyPressed(evt);
            }
        });
        panelUploadPage.add(surname, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 220, 40));

        seperatorusername3.setBackground(new java.awt.Color(18, 159, 72));
        seperatorusername3.setForeground(new java.awt.Color(18, 159, 72));
        panelUploadPage.add(seperatorusername3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 220, 20));

        jLabel33.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("ACCOUNT TYPE");
        panelUploadPage.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 140, 30));

        seperatorusername4.setBackground(new java.awt.Color(18, 159, 72));
        seperatorusername4.setForeground(new java.awt.Color(18, 159, 72));
        panelUploadPage.add(seperatorusername4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, 320, 20));

        cmbaccounttype.setBackground(new java.awt.Color(32, 47, 90));
        cmbaccounttype.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        cmbaccounttype.setForeground(new java.awt.Color(18, 159, 72));
        cmbaccounttype.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Individual current", "Individual saving tier 1", "Individual saving tier 2", "Premier savings", "Premium current", "Gold current" }));
        cmbaccounttype.setBorder(null);
        panelUploadPage.add(cmbaccounttype, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, 320, 40));

        jLabel34.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("BRANCH");
        panelUploadPage.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 190, 140, 30));

        seperatorusername5.setBackground(new java.awt.Color(18, 159, 72));
        seperatorusername5.setForeground(new java.awt.Color(18, 159, 72));
        panelUploadPage.add(seperatorusername5, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 270, 320, 20));

        cmbbranch.setBackground(new java.awt.Color(32, 47, 90));
        cmbbranch.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        cmbbranch.setForeground(new java.awt.Color(18, 159, 72));
        cmbbranch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Branch 1", "Branch 2", "Branch 3", "Branch 4", "Branch 5" }));
        cmbbranch.setBorder(null);
        panelUploadPage.add(cmbbranch, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 230, 320, 40));

        jLabel40.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setText("CATEGORY OF ACCOUNT");
        panelUploadPage.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, 240, 30));

        seperatorusername6.setBackground(new java.awt.Color(18, 159, 72));
        seperatorusername6.setForeground(new java.awt.Color(18, 159, 72));
        panelUploadPage.add(seperatorusername6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, 230, 20));

        cmbcoaccount.setBackground(new java.awt.Color(32, 47, 90));
        cmbcoaccount.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        cmbcoaccount.setForeground(new java.awt.Color(18, 159, 72));
        cmbcoaccount.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Individual", "Joint", "Fixed Investment", "Others" }));
        cmbcoaccount.setBorder(null);
        panelUploadPage.add(cmbcoaccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 360, 230, 40));

        jLabel41.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setText("Marital status");
        panelUploadPage.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 320, 140, 30));

        seperatorusername7.setBackground(new java.awt.Color(18, 159, 72));
        seperatorusername7.setForeground(new java.awt.Color(18, 159, 72));
        panelUploadPage.add(seperatorusername7, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 400, 120, 20));

        cmbmaritalstatus.setBackground(new java.awt.Color(32, 47, 90));
        cmbmaritalstatus.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        cmbmaritalstatus.setForeground(new java.awt.Color(18, 159, 72));
        cmbmaritalstatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Single", "Married" }));
        cmbmaritalstatus.setBorder(null);
        panelUploadPage.add(cmbmaritalstatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 360, 120, 40));

        jLabel42.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setText("VALIDATION MEANS OF IDENTIFICATION");
        panelUploadPage.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 320, 370, 30));

        seperatorusername8.setBackground(new java.awt.Color(18, 159, 72));
        seperatorusername8.setForeground(new java.awt.Color(18, 159, 72));
        panelUploadPage.add(seperatorusername8, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 400, 360, 20));

        cmbmeansofid.setBackground(new java.awt.Color(32, 47, 90));
        cmbmeansofid.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        cmbmeansofid.setForeground(new java.awt.Color(18, 159, 72));
        cmbmeansofid.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "National ID card", "Drivers license", "International Passport", "Voters card" }));
        cmbmeansofid.setBorder(null);
        cmbmeansofid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbmeansofidActionPerformed(evt);
            }
        });
        panelUploadPage.add(cmbmeansofid, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 360, 360, 40));

        jLabel43.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setText("NATIONALITY");
        panelUploadPage.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 460, 140, 30));

        seperatorusername9.setBackground(new java.awt.Color(18, 159, 72));
        seperatorusername9.setForeground(new java.awt.Color(18, 159, 72));
        panelUploadPage.add(seperatorusername9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 540, 320, 20));

        cmbnationality.setBackground(new java.awt.Color(32, 47, 90));
        cmbnationality.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        cmbnationality.setForeground(new java.awt.Color(18, 159, 72));
        cmbnationality.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nigerian", "Others" }));
        cmbnationality.setBorder(null);
        panelUploadPage.add(cmbnationality, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 500, 320, 40));

        jLabel44.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setText("DO YOU HAVE DUAL CITIZENSHIP");
        panelUploadPage.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 460, 320, 30));

        seperatorusername10.setBackground(new java.awt.Color(18, 159, 72));
        seperatorusername10.setForeground(new java.awt.Color(18, 159, 72));
        panelUploadPage.add(seperatorusername10, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 540, 320, 20));

        cmbcitizenship.setBackground(new java.awt.Color(32, 47, 90));
        cmbcitizenship.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        cmbcitizenship.setForeground(new java.awt.Color(18, 159, 72));
        cmbcitizenship.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Yes", "No" }));
        cmbcitizenship.setBorder(null);
        panelUploadPage.add(cmbcitizenship, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 500, 320, 40));

        btndelete.setBackground(new java.awt.Color(0, 51, 153));
        btndelete.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        btndelete.setForeground(new java.awt.Color(255, 255, 255));
        btndelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myfinalyearprojectfunaab/Trash Can_25px.png"))); // NOI18N
        btndelete.setText("DELETE");
        btndelete.setBorder(null);
        btndelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btndeleteMouseClicked(evt);
            }
        });
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });
        panelUploadPage.add(btndelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 600, 140, 50));

        btnSubmit1.setBackground(new java.awt.Color(0, 51, 153));
        btnSubmit1.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        btnSubmit1.setForeground(new java.awt.Color(255, 255, 255));
        btnSubmit1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myfinalyearprojectfunaab/Upload_25px.png"))); // NOI18N
        btnSubmit1.setText("SUBMIT");
        btnSubmit1.setBorder(null);
        btnSubmit1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSubmit1MouseClicked(evt);
            }
        });
        btnSubmit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmit1ActionPerformed(evt);
            }
        });
        panelUploadPage.add(btnSubmit1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 600, 140, 50));

        btnupdate.setBackground(new java.awt.Color(0, 51, 153));
        btnupdate.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        btnupdate.setForeground(new java.awt.Color(255, 255, 255));
        btnupdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myfinalyearprojectfunaab/Restart_25px.png"))); // NOI18N
        btnupdate.setText("UPDATE");
        btnupdate.setBorder(null);
        btnupdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnupdateMouseClicked(evt);
            }
        });
        btnupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateActionPerformed(evt);
            }
        });
        panelUploadPage.add(btnupdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 600, 140, 50));

        jPanel2.add(panelUploadPage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 720));

        panelSearchPage.setBackground(new java.awt.Color(32, 47, 90));
        panelSearchPage.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel36.setFont(new java.awt.Font("Century Gothic", 0, 48)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myfinalyearprojectfunaab/Ok_15px.png"))); // NOI18N
        jLabel36.setText("SEARCH FOR SIMILAR RECORDS");
        panelSearchPage.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 750, 50));

        tblviewalltwo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        tblviewalltwo.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        tblviewalltwo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Surname", "First Name", "Middle Name", "Account Type", "Branch", "Category", "Marital Status", "Validation Means", "Nationality", "Dual Citizenship", "Similarity value"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblviewalltwo.setColumnSelectionAllowed(true);
        tblviewalltwo.setInheritsPopupMenu(true);
        tblviewalltwo.setName("VIEW ALL RECORDS"); // NOI18N
        tblviewalltwo.setRowHeight(70);
        tblviewalltwo.getTableHeader().setReorderingAllowed(false);
        tblviewalltwo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblviewalltwoMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblviewalltwo);
        tblviewalltwo.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        panelSearchPage.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 490, 1100, 230));

        jLabel46.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setText("ENTER SUNRNAME TO SEARCH");
        panelSearchPage.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 60, 270, 30));

        searchlbl.setBackground(new java.awt.Color(32, 47, 90));
        searchlbl.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        searchlbl.setForeground(new java.awt.Color(18, 159, 72));
        searchlbl.setBorder(null);
        searchlbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchlblMouseClicked(evt);
            }
        });
        searchlbl.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                searchlblInputMethodTextChanged(evt);
            }
        });
        searchlbl.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchlblKeyPressed(evt);
            }
        });
        panelSearchPage.add(searchlbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 90, 380, 40));

        seperatorusername11.setBackground(new java.awt.Color(18, 159, 72));
        seperatorusername11.setForeground(new java.awt.Color(18, 159, 72));
        panelSearchPage.add(seperatorusername11, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 130, 380, 20));

        jLabel50.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(255, 255, 255));
        jLabel50.setText("Candidate Key Algorithm");
        panelSearchPage.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 420, 290, 40));

        tblviewallone.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        tblviewallone.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        tblviewallone.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Surname", "First Name", "Middle Name", "Account Type", "Branch", "Category", "Marital Status", "Validation Means", "Nationality", "Dual Citizenship", "Similarity value"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblviewallone.setColumnSelectionAllowed(true);
        tblviewallone.setInheritsPopupMenu(true);
        tblviewallone.setName("VIEW ALL RECORDS"); // NOI18N
        tblviewallone.setRowHeight(70);
        tblviewallone.getTableHeader().setReorderingAllowed(false);
        tblviewallone.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblviewalloneMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblviewallone);
        tblviewallone.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        panelSearchPage.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 1100, 240));

        lblwjt.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        lblwjt.setForeground(new java.awt.Color(255, 255, 255));
        panelSearchPage.add(lblwjt, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 140, 180, 30));

        jLabel52.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(255, 255, 255));
        jLabel52.setText("weighted Jaccard Coefficient");
        panelSearchPage.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 290, 30));

        jLabel53.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(255, 255, 255));
        jLabel53.setText("Average Processing time");
        panelSearchPage.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 140, 230, 30));

        jLabel54.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(255, 255, 255));
        jLabel54.setText("Average Processing time");
        panelSearchPage.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 420, 230, 40));

        lblcat.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        lblcat.setForeground(new java.awt.Color(255, 255, 255));
        panelSearchPage.add(lblcat, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 420, 180, 40));

        jLabel55.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(255, 255, 255));
        jLabel55.setText("Cost of Algorithm");
        panelSearchPage.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 140, 170, 30));

        lblcaw.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        lblcaw.setForeground(new java.awt.Color(255, 255, 255));
        panelSearchPage.add(lblcaw, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 140, 160, 30));

        jLabel56.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(255, 255, 255));
        jLabel56.setText("Cost of Algorithm");
        panelSearchPage.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 420, 170, 40));

        lblcac.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        lblcac.setForeground(new java.awt.Color(255, 255, 255));
        panelSearchPage.add(lblcac, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 420, 160, 40));

        jLabel58.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(255, 255, 255));
        jLabel58.setText("Average sim Value");
        panelSearchPage.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 460, 170, 30));

        lblavgsimvaluec.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        lblavgsimvaluec.setForeground(new java.awt.Color(255, 255, 255));
        panelSearchPage.add(lblavgsimvaluec, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 460, 160, 30));

        lblavgsimvaluew.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        lblavgsimvaluew.setForeground(new java.awt.Color(255, 255, 255));
        panelSearchPage.add(lblavgsimvaluew, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, 160, 30));

        jLabel59.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(255, 255, 255));
        jLabel59.setText("Average sim Value");
        panelSearchPage.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 170, 30));

        jPanel2.add(panelSearchPage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 720));

        panelViewRecPage.setBackground(new java.awt.Color(32, 47, 90));
        panelViewRecPage.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel37.setFont(new java.awt.Font("Century Gothic", 0, 48)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myfinalyearprojectfunaab/Ok_15px.png"))); // NOI18N
        jLabel37.setText("VIEW ALL RECORDS");
        panelViewRecPage.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, 470, -1));

        tblviewall.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        tblviewall.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        tblviewall.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Surname", "First Name", "Middle Name", "Account Type", "Branch", "Category", "Marital Status", "Validation Means", "Nationality", "Dual Citizenship"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblviewall.setColumnSelectionAllowed(true);
        tblviewall.setInheritsPopupMenu(true);
        tblviewall.setName("VIEW ALL RECORDS"); // NOI18N
        tblviewall.setRowHeight(70);
        tblviewall.getTableHeader().setReorderingAllowed(false);
        tblviewall.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblviewallMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblviewall);
        tblviewall.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        panelViewRecPage.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 1100, 600));

        jLabel57.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(255, 255, 255));
        jLabel57.setText("TOTAL NO OF RECORDS");
        panelViewRecPage.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 80, 230, 30));

        lblNoOfRecordsInDb.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        lblNoOfRecordsInDb.setForeground(new java.awt.Color(255, 255, 255));
        panelViewRecPage.add(lblNoOfRecordsInDb, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 80, 140, 30));

        jPanel2.add(panelViewRecPage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 720));

        panelAboutPage.setBackground(new java.awt.Color(32, 47, 90));
        panelAboutPage.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel38.setFont(new java.awt.Font("Century Gothic", 0, 48)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myfinalyearprojectfunaab/Ok_15px.png"))); // NOI18N
        jLabel38.setText("ABOUT");
        panelAboutPage.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 10, 180, 95));

        jPanel2.add(panelAboutPage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 720));

        panelSignUpPage.setBackground(new java.awt.Color(32, 47, 90));
        panelSignUpPage.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel39.setFont(new java.awt.Font("Century Gothic", 0, 48)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myfinalyearprojectfunaab/Ok_15px.png"))); // NOI18N
        jLabel39.setText("SIGN UP");
        panelSignUpPage.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, -1, 95));

        jLabel48.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(255, 255, 255));
        jLabel48.setText("USERNAME");
        panelSignUpPage.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 280, 110, 40));

        username1.setBackground(new java.awt.Color(32, 47, 90));
        username1.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        username1.setForeground(new java.awt.Color(18, 159, 72));
        username1.setBorder(null);
        username1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                username1MouseClicked(evt);
            }
        });
        panelSignUpPage.add(username1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 280, 280, 40));

        btnLogin4.setBackground(new java.awt.Color(0, 51, 153));
        btnLogin4.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        btnLogin4.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myfinalyearprojectfunaab/Unlock_25px.png"))); // NOI18N
        btnLogin4.setText("Add New Admin");
        btnLogin4.setBorder(null);
        btnLogin4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLogin4MouseClicked(evt);
            }
        });
        btnLogin4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogin4ActionPerformed(evt);
            }
        });
        panelSignUpPage.add(btnLogin4, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 540, 200, 50));

        jLabel49.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(255, 255, 255));
        jLabel49.setText("PASSWORD");
        panelSignUpPage.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 380, 110, 40));

        password1.setBackground(new java.awt.Color(32, 47, 90));
        password1.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        password1.setForeground(new java.awt.Color(18, 159, 72));
        password1.setToolTipText("");
        password1.setBorder(null);
        panelSignUpPage.add(password1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 380, 280, 40));

        seperatorusername12.setBackground(new java.awt.Color(18, 159, 72));
        seperatorusername12.setForeground(new java.awt.Color(18, 159, 72));
        panelSignUpPage.add(seperatorusername12, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 320, 280, 20));

        seperatorpass1.setBackground(new java.awt.Color(18, 159, 72));
        seperatorpass1.setForeground(new java.awt.Color(18, 159, 72));
        panelSignUpPage.add(seperatorpass1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 420, 280, 20));

        jPanel2.add(panelSignUpPage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 720));

        panelLoginPage.setBackground(new java.awt.Color(32, 47, 90));
        panelLoginPage.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel26.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("USERNAME");
        panelLoginPage.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 280, 110, 40));

        username.setBackground(new java.awt.Color(32, 47, 90));
        username.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        username.setForeground(new java.awt.Color(18, 159, 72));
        username.setBorder(null);
        username.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                usernameMouseClicked(evt);
            }
        });
        panelLoginPage.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 280, 280, 40));

        btnLogin2.setBackground(new java.awt.Color(0, 51, 153));
        btnLogin2.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        btnLogin2.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myfinalyearprojectfunaab/Unlock_25px.png"))); // NOI18N
        btnLogin2.setText("Login");
        btnLogin2.setBorder(null);
        btnLogin2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLogin2MouseClicked(evt);
            }
        });
        btnLogin2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogin2ActionPerformed(evt);
            }
        });
        btnLogin2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnLogin2KeyPressed(evt);
            }
        });
        panelLoginPage.add(btnLogin2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 540, 130, 50));

        jLabel27.setFont(new java.awt.Font("Century Gothic", 0, 48)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myfinalyearprojectfunaab/Ok_15px.png"))); // NOI18N
        jLabel27.setText("LOGIN");
        panelLoginPage.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, 200, 95));

        jLabel28.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("PASSWORD");
        panelLoginPage.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 380, 110, 40));

        password.setBackground(new java.awt.Color(32, 47, 90));
        password.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        password.setForeground(new java.awt.Color(18, 159, 72));
        password.setToolTipText("");
        password.setBorder(null);
        password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passwordKeyPressed(evt);
            }
        });
        panelLoginPage.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 380, 280, 40));

        seperatorusername.setBackground(new java.awt.Color(18, 159, 72));
        seperatorusername.setForeground(new java.awt.Color(18, 159, 72));
        panelLoginPage.add(seperatorusername, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 320, 280, 20));

        seperatorpass.setBackground(new java.awt.Color(18, 159, 72));
        seperatorpass.setForeground(new java.awt.Color(18, 159, 72));
        panelLoginPage.add(seperatorpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 420, 280, 20));

        jPanel2.add(panelLoginPage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 720));

        panelViewIndividualRec.setBackground(new java.awt.Color(32, 47, 90));
        panelViewIndividualRec.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel29.setFont(new java.awt.Font("Century Gothic", 0, 48)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myfinalyearprojectfunaab/Ok_15px.png"))); // NOI18N
        jLabel29.setText("VIEW INDIVIDUAL RECORDS");
        panelViewIndividualRec.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 660, 95));

        jPanel2.add(panelViewIndividualRec, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 720));

        panelToLogin.setBackground(new java.awt.Color(32, 47, 90));
        panelToLogin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel47.setFont(new java.awt.Font("Century Gothic", 0, 48)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setText("INFORMATION RETRIEVAL SYSTEM");
        panelToLogin.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, 822, 95));

        btnLogin3.setBackground(new java.awt.Color(0, 51, 153));
        btnLogin3.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        btnLogin3.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myfinalyearprojectfunaab/Unlock_25px.png"))); // NOI18N
        btnLogin3.setText("Click here to Login");
        btnLogin3.setBorder(null);
        btnLogin3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLogin3MouseClicked(evt);
            }
        });
        btnLogin3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogin3ActionPerformed(evt);
            }
        });
        panelToLogin.add(btnLogin3, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 370, 210, 50));

        jPanel2.add(panelToLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 720));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 50, 1100, 720));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    int x,y;
    
    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        x= evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_jPanel1MousePressed

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        
        int xx = evt.getXOnScreen();
        int yy = evt.getYOnScreen();
        
        this.setLocation(xx-x, yy-y);
        
    }//GEN-LAST:event_jPanel1MouseDragged

    private void panelHomeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelHomeMousePressed
        panel1.setBackground(panelClick);
        panel2.setBackground(paneldefault);
        panel3.setBackground(paneldefault);
        panel4.setBackground(paneldefault);
        panel5.setBackground(paneldefault);
        panel6.setBackground(paneldefault);
    }//GEN-LAST:event_panelHomeMousePressed

    private void panelUploadMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelUploadMousePressed
        panel2.setBackground(panelClick);
        panel1.setBackground(paneldefault);
        panel3.setBackground(paneldefault);
        panel4.setBackground(paneldefault);
        panel5.setBackground(paneldefault);
        panel6.setBackground(paneldefault);
    }//GEN-LAST:event_panelUploadMousePressed

    private void panelSearchMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelSearchMousePressed
        panel1.setBackground(paneldefault);
        panel2.setBackground(paneldefault);
        panel3.setBackground(panelClick);
        panel4.setBackground(paneldefault);
        panel5.setBackground(paneldefault);
        panel6.setBackground(paneldefault);
    }//GEN-LAST:event_panelSearchMousePressed

    private void panelViewRecMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelViewRecMousePressed
        panel1.setBackground(paneldefault);
        panel2.setBackground(paneldefault);
        panel3.setBackground(paneldefault);
        panel4.setBackground(panelClick);
        panel5.setBackground(paneldefault);
        panel6.setBackground(paneldefault);
    }//GEN-LAST:event_panelViewRecMousePressed

    private void panelAboutMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelAboutMousePressed
        panel1.setBackground(paneldefault);
        panel2.setBackground(paneldefault);
        panel3.setBackground(paneldefault);
        panel4.setBackground(paneldefault);
        panel5.setBackground(panelClick);
        panel6.setBackground(paneldefault);
    }//GEN-LAST:event_panelAboutMousePressed

    private void panelLogoutMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelLogoutMousePressed
        panel1.setBackground(paneldefault);
        panel2.setBackground(paneldefault);
        panel3.setBackground(paneldefault);
        panel4.setBackground(paneldefault);
        panel5.setBackground(paneldefault);
        panel6.setBackground(panelClick);
    }//GEN-LAST:event_panelLogoutMousePressed

    private void panelHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelHomeMouseClicked
        panelSearchPage.setVisible(false);
        panelViewRecPage.setVisible(false);
        panelAboutPage.setVisible(false);
        panelSignUpPage.setVisible(false);
        panelLoginPage.setVisible(false);
        panelViewIndividualRec.setVisible(false);
        panelUploadPage.setVisible(false);
        panelHomePage.setVisible(true);
    }//GEN-LAST:event_panelHomeMouseClicked

    private void panelLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelLogoutMouseClicked
        panelUpload.setVisible(false);
        panelSearch.setVisible(false);
        panelViewRec.setVisible(false);
        panelAbout.setVisible(false);
        panelLogout.setVisible(false);
        panelHome.setVisible(false);
        
        
        panelSearchPage.setVisible(false);
        panelViewRecPage.setVisible(false);
        panelAboutPage.setVisible(false);
        panelSignUpPage.setVisible(false);
        panelLoginPage.setVisible(false);
        panelViewIndividualRec.setVisible(false);
        panelUploadPage.setVisible(false);
        panelHomePage.setVisible(false);
        panelToLogin.setVisible(true);
        
        lblUserType.setText("");
    }//GEN-LAST:event_panelLogoutMouseClicked

    private void panelHomeMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelHomeMouseMoved
        
    }//GEN-LAST:event_panelHomeMouseMoved

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel9MouseClicked

    private void btnLogin2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogin2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLogin2MouseClicked

    private void btnLogin2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogin2ActionPerformed
        String login = "SELECT * FROM AdminLogin WHERE Username = ? and Password = ?";
        try{
            ps = con.prepareStatement(login);
            ps.setString(1, username.getText());
            ps.setString(2, password.getText());
            rs = ps.executeQuery();
            
            if(rs.next()){
                JOptionPane.showMessageDialog(null, "Login Successful...." );
                lblUserType.setText(username.getText());
                panelSearchPage.setVisible(false);
                panelViewRecPage.setVisible(false);
                panelAboutPage.setVisible(false);
                panelSignUpPage.setVisible(false);
                panelLoginPage.setVisible(false);
                panelViewIndividualRec.setVisible(false);
                panelUploadPage.setVisible(false);
                panelHomePage.setVisible(true);
                panelToLogin.setVisible(false);
                
                
                panelUpload.setVisible(true);
                panelSearch.setVisible(true);
                panelViewRec.setVisible(true);
                panelAbout.setVisible(true);
                panelLogout.setVisible(true);
                panelHome.setVisible(true);
                
                username.setText("");
                password.setText("");
                
                
                 
            }else{
                JOptionPane.showMessageDialog(null, "Login unsuccessful try again or contact the admin...." );
                username.setText("");
                password.setText("");
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex );
        }
    }//GEN-LAST:event_btnLogin2ActionPerformed

    private void panelUploadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelUploadMouseClicked
        // TODO add your handling code here:
        
        panelSearchPage.setVisible(false);
        panelViewRecPage.setVisible(false);
        panelAboutPage.setVisible(false);
        panelSignUpPage.setVisible(false);
        panelLoginPage.setVisible(false);
        panelViewIndividualRec.setVisible(false);
        panelUploadPage.setVisible(true);
        panelHomePage.setVisible(false);
    }//GEN-LAST:event_panelUploadMouseClicked

    private void panelSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelSearchMouseClicked
        // TODO add your handling code here:
        panelSearchPage.setVisible(true);
        panelViewRecPage.setVisible(false);
        panelAboutPage.setVisible(false);
        panelSignUpPage.setVisible(false);
        panelLoginPage.setVisible(false);
        panelViewIndividualRec.setVisible(false);
        panelUploadPage.setVisible(false);
        panelHomePage.setVisible(false);
    }//GEN-LAST:event_panelSearchMouseClicked

    private void panelViewRecMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelViewRecMouseClicked
        // TODO add your handling code here:
        
        panelSearchPage.setVisible(false);
        panelViewRecPage.setVisible(true);
        panelAboutPage.setVisible(false);
        panelSignUpPage.setVisible(false);
        panelLoginPage.setVisible(false);
        panelViewIndividualRec.setVisible(false);
        panelUploadPage.setVisible(false);
        panelHomePage.setVisible(false);
    }//GEN-LAST:event_panelViewRecMouseClicked

    private void panelAboutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelAboutMouseClicked
        // TODO add your handling code here:
        
        panelSearchPage.setVisible(false);
        panelViewRecPage.setVisible(false);
        panelAboutPage.setVisible(true);
        panelSignUpPage.setVisible(false);
        panelLoginPage.setVisible(false);
        panelViewIndividualRec.setVisible(false);
        panelUploadPage.setVisible(false);
        panelHomePage.setVisible(false);
    }//GEN-LAST:event_panelAboutMouseClicked

    private void usernameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usernameMouseClicked
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_usernameMouseClicked

    private void firstnameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_firstnameMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_firstnameMouseClicked

    private void middlenameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_middlenameMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_middlenameMouseClicked

    private void surnameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_surnameMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_surnameMouseClicked

    private void cmbmeansofidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbmeansofidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbmeansofidActionPerformed

    private void btndeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btndeleteMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btndeleteMouseClicked

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        
        try{
            String Surname = surname.getText();
            String deleteQuery = "DELETE FROM UPLOADTBL WHERE SURNAME = '"+ Surname+"' ";
                Statement stm = con.createStatement();
                stm.execute(deleteQuery);
                JOptionPane.showMessageDialog(null,Surname + " Record Deleted successfully...");

                surname.setText("");
                firstname.setText("");
                middlename.setText("");
                cmbaccounttype.setSelectedIndex(0);
                cmbbranch.setSelectedIndex(0);
                cmbcoaccount.setSelectedIndex(0);
                cmbmaritalstatus.setSelectedIndex(0);
                cmbnationality.setSelectedIndex(0);
                cmbcitizenship.setSelectedIndex(0);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        
    }//GEN-LAST:event_btndeleteActionPerformed

    private void btnSubmit1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSubmit1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSubmit1MouseClicked

    private void btnSubmit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmit1ActionPerformed
        // TODO add your handling code here:
        try{
            
            if(surname.getText().equals("") || middlename.getText().equals("") || firstname.getText().equals("") ){
                
                JOptionPane.showMessageDialog(this, "Pls make sure you have correctly filled all the form!!!");
              
            }
            else{
                String Surname = surname.getText();
                String Firstname = firstname.getText();
                String Middlename = middlename.getText();
                String Cmbaccounttype = (String) cmbaccounttype.getSelectedItem();
                String Cmbranch = (String) cmbbranch.getSelectedItem();
                String Cmbcoaccount = (String) cmbcoaccount.getSelectedItem();
                String Cmbamaritalstatus = (String) cmbmaritalstatus.getSelectedItem();
                String Cmbmeansofid = (String) cmbmeansofid.getSelectedItem();
                String Cmbnationality = (String) cmbnationality.getSelectedItem();
                String Cmbcitizenship = (String) cmbcitizenship.getSelectedItem();

                String insertQuery = "insert into UploadTbl(SURNAME,FIRSTNAME,MIDDLENAME,ACCOUNTTYPE,BRANCH,CATEGORY,MARITALSTATUS,VALIDATIONIDENTIFICATION,NATIONALITY,DUALCITIZENSHIP) values ('" + Surname + "','" + Firstname + "','" + Middlename + "','" + Cmbaccounttype + "','" + Cmbranch + "','" + Cmbcoaccount + "','" + Cmbamaritalstatus + "','" + Cmbmeansofid + "','" + Cmbnationality + "','" + Cmbcitizenship + "')";
                Statement stm = con.createStatement();
                stm.execute(insertQuery);
                JOptionPane.showMessageDialog(null, "Record saved successfully...");

                surname.setText("");
                firstname.setText("");
                middlename.setText("");
                cmbaccounttype.setSelectedIndex(0);
                cmbbranch.setSelectedIndex(0);
                cmbcoaccount.setSelectedIndex(0);
                cmbmaritalstatus.setSelectedIndex(0);
                cmbnationality.setSelectedIndex(0);
                cmbcitizenship.setSelectedIndex(0);
            }
            
            
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_btnSubmit1ActionPerformed

    private void btnupdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnupdateMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnupdateMouseClicked

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed
        // TODO add your handling code here:
        
        try{
                String Surname = surname.getText();
                String Firstname = firstname.getText();
                String Middlename = middlename.getText();
                String Cmbaccounttype = (String) cmbaccounttype.getSelectedItem();
                String Cmbranch = (String) cmbbranch.getSelectedItem();
                String Cmbcoaccount = (String) cmbcoaccount.getSelectedItem();
                String Cmbamaritalstatus = (String) cmbmaritalstatus.getSelectedItem();
                String Cmbmeansofid = (String) cmbmeansofid.getSelectedItem();
                String Cmbnationality = (String) cmbnationality.getSelectedItem();
                String Cmbcitizenship = (String) cmbcitizenship.getSelectedItem();

                String updateQuery = "UPDATE UPLOADTBL SET FIRSTNAME = '"+ Firstname+"',MIDDLENAME = '"+ Middlename+"',ACCOUNTTYPE = '"+ Cmbaccounttype+"',BRANCH = '"+ Cmbranch+"',CATEGORY = '"+ Cmbcoaccount+"',MARITALSTATUS = '"+ Cmbamaritalstatus+"',VALIDATIONIDENTIFICATION = '"+ Cmbmeansofid+"',NATIONALITY = '"+ Cmbnationality+"',DUALCITIZENSHIP = '"+ Cmbcitizenship+"' where SURNAME = '"+ Surname+"' ";
                Statement stm = con.createStatement();
                stm.execute(updateQuery);
                JOptionPane.showMessageDialog(null, " Record Updated successfully...");

                surname.setText("");
                firstname.setText("");
                middlename.setText("");
                cmbaccounttype.setSelectedIndex(0);
                cmbbranch.setSelectedIndex(0);
                cmbcoaccount.setSelectedIndex(0);
                cmbmaritalstatus.setSelectedIndex(0);
                cmbnationality.setSelectedIndex(0);
                cmbcitizenship.setSelectedIndex(0);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        
    }//GEN-LAST:event_btnupdateActionPerformed

    private void tblviewallMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblviewallMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblviewallMouseClicked

    private void tblviewalltwoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblviewalltwoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblviewalltwoMouseClicked

    private void searchlblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchlblMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_searchlblMouseClicked

    private void searchlblKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchlblKeyPressed
        // TODO add your handling code here:
        
        
        try{
            MyProject mp = new MyProject();
            stm2 = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
       
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            
            myThreadWeighted mtw = new myThreadWeighted();
            myThreadCandidate mtc = new myThreadCandidate();
            mtw.start();
            mtc.start();
            
            
               
            
        }
        
    }//GEN-LAST:event_searchlblKeyPressed

    private void searchlblInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_searchlblInputMethodTextChanged
         System.out.println("Hello text changd");
    }//GEN-LAST:event_searchlblInputMethodTextChanged

    private void surnameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_surnameKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            try{
                Statement stm = con.createStatement();
                    String sql = "select * from UploadTbl where surname = '"+surname.getText()+"'";
                    ResultSet rs = stm.executeQuery(sql);
                    
                    while(rs.next()){
                        String Firstname = rs.getString("FIRSTNAME");
                        String Middlename = rs.getString("MIDDLENAME");
                        String Accounttype = rs.getString("ACCOUNTTYPE");
                        String Branch = rs.getString("BRANCH");
                        String Category = rs.getString("CATEGORY");
                        String Mstatus = rs.getString("MARITALSTATUS");
                        String Validationmeans = rs.getString("VALIDATIONIDENTIFICATION");
                        String Nationality = rs.getString("NATIONALITY");
                        String Citizenship = rs.getString("DUALCITIZENSHIP");
                        
                        firstname.setText(Firstname);
                        middlename.setText(Middlename);
                        cmbaccounttype.setSelectedItem(Accounttype);
                        cmbbranch.setSelectedItem(Branch);
                        cmbcoaccount.setSelectedItem(Category);
                        cmbmaritalstatus.setSelectedItem(Mstatus);
                        cmbmeansofid.setSelectedItem(Validationmeans);
                        cmbnationality.setSelectedItem(Nationality);
                        cmbcitizenship.setSelectedItem(Citizenship);
                        
                    }
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        }
    }//GEN-LAST:event_surnameKeyPressed

    private void btnLogin3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogin3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLogin3MouseClicked

    private void btnLogin3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogin3ActionPerformed
        // TODO add your handling code here:
                panelSearchPage.setVisible(false);
                panelViewRecPage.setVisible(false);
                panelAboutPage.setVisible(false);
                panelSignUpPage.setVisible(false);
                panelLoginPage.setVisible(true);
                panelViewIndividualRec.setVisible(false);
                panelUploadPage.setVisible(false);
                panelHomePage.setVisible(false);
                panelToLogin.setVisible(false);
    }//GEN-LAST:event_btnLogin3ActionPerformed

    private void username1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_username1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_username1MouseClicked

    private void btnLogin4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogin4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLogin4MouseClicked

    private void btnLogin4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogin4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLogin4ActionPerformed

    private void tblviewalloneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblviewalloneMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblviewalloneMouseClicked

    private void btnLogin2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnLogin2KeyPressed
        
    }//GEN-LAST:event_btnLogin2KeyPressed

    private void passwordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            
            String login = "SELECT * FROM AdminLogin WHERE Username = ? and Password = ?";
        try{
            ps = con.prepareStatement(login);
            ps.setString(1, username.getText());
            ps.setString(2, password.getText());
            rs = ps.executeQuery();
            
            if(rs.next()){
                JOptionPane.showMessageDialog(null, "Login Successful...." );
                lblUserType.setText(username.getText());
                panelSearchPage.setVisible(false);
                panelViewRecPage.setVisible(false);
                panelAboutPage.setVisible(false);
                panelSignUpPage.setVisible(false);
                panelLoginPage.setVisible(false);
                panelViewIndividualRec.setVisible(false);
                panelUploadPage.setVisible(false);
                panelHomePage.setVisible(true);
                panelToLogin.setVisible(false);
                
                
                panelUpload.setVisible(true);
                panelSearch.setVisible(true);
                panelViewRec.setVisible(true);
                panelAbout.setVisible(true);
                panelLogout.setVisible(true);
                panelHome.setVisible(true);
                
                username.setText("");
                password.setText("");
                
                
                 
            }else{
                JOptionPane.showMessageDialog(null, "Login unsuccessful try again or contact the admin...." );
                username.setText("");
                password.setText("");
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex );
        }
        }
    }//GEN-LAST:event_passwordKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MyProject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MyProject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MyProject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MyProject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MyProject().setVisible(true);
            }
        });
    }
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin2;
    private javax.swing.JButton btnLogin3;
    private javax.swing.JButton btnLogin4;
    private javax.swing.JButton btnSubmit1;
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btnupdate;
    private javax.swing.JComboBox<String> cmbaccounttype;
    private javax.swing.JComboBox<String> cmbbranch;
    private javax.swing.JComboBox<String> cmbcitizenship;
    private javax.swing.JComboBox<String> cmbcoaccount;
    private javax.swing.JComboBox<String> cmbmaritalstatus;
    private javax.swing.JComboBox<String> cmbmeansofid;
    private javax.swing.JComboBox<String> cmbnationality;
    private javax.swing.JTextField firstname;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    public javax.swing.JLabel lblNoOfRecordsInDb;
    public javax.swing.JLabel lblUserType;
    public javax.swing.JLabel lblavgsimvaluec;
    public javax.swing.JLabel lblavgsimvaluew;
    public javax.swing.JLabel lblcac;
    public javax.swing.JLabel lblcat;
    public javax.swing.JLabel lblcaw;
    public javax.swing.JLabel lblwjt;
    private javax.swing.JTextField middlename;
    private javax.swing.JPanel panel1;
    private javax.swing.JPanel panel2;
    private javax.swing.JPanel panel3;
    private javax.swing.JPanel panel4;
    private javax.swing.JPanel panel5;
    private javax.swing.JPanel panel6;
    public javax.swing.JPanel panelAbout;
    private javax.swing.JPanel panelAboutPage;
    public javax.swing.JPanel panelContainer;
    public javax.swing.JPanel panelHome;
    private javax.swing.JPanel panelHomePage;
    private javax.swing.JPanel panelLoginPage;
    public javax.swing.JPanel panelLogout;
    public javax.swing.JPanel panelSearch;
    private javax.swing.JPanel panelSearchPage;
    private javax.swing.JPanel panelSignUpPage;
    private javax.swing.JPanel panelToLogin;
    public javax.swing.JPanel panelUpload;
    private javax.swing.JPanel panelUploadPage;
    private javax.swing.JPanel panelViewIndividualRec;
    public javax.swing.JPanel panelViewRec;
    private javax.swing.JPanel panelViewRecPage;
    private javax.swing.JPasswordField password;
    private javax.swing.JPasswordField password1;
    public javax.swing.JTextField searchlbl;
    private javax.swing.JSeparator seperatorpass;
    private javax.swing.JSeparator seperatorpass1;
    private javax.swing.JSeparator seperatorusername;
    private javax.swing.JSeparator seperatorusername1;
    private javax.swing.JSeparator seperatorusername10;
    private javax.swing.JSeparator seperatorusername11;
    private javax.swing.JSeparator seperatorusername12;
    private javax.swing.JSeparator seperatorusername2;
    private javax.swing.JSeparator seperatorusername3;
    private javax.swing.JSeparator seperatorusername4;
    private javax.swing.JSeparator seperatorusername5;
    private javax.swing.JSeparator seperatorusername6;
    private javax.swing.JSeparator seperatorusername7;
    private javax.swing.JSeparator seperatorusername8;
    private javax.swing.JSeparator seperatorusername9;
    private javax.swing.JTextField surname;
    private javax.swing.JTable tblviewall;
    public javax.swing.JTable tblviewallone;
    public javax.swing.JTable tblviewalltwo;
    private javax.swing.JTextField username;
    private javax.swing.JTextField username1;
    // End of variables declaration//GEN-END:variables
}



