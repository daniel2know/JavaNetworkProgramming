/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;

/**
 *
 * @author Tunwashe Daniel
 */
public class file00 extends javax.swing.JPanel {

    public void bb(){
        ButtonGroup bb = new ButtonGroup();
        bb.add(jRadioButton1);
        bb.add(jRadioButton2);
        bb.add(jRadioButton3);
        bb.add(jRadioButton4);
        bb.add(jRadioButton5);
    }
    
    /**
     * Creates new form file00
     */
    public file00() {
        initComponents();
        bb();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblhead = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtarea = new javax.swing.JTextArea();
        btnClick2 = new javax.swing.JButton();
        btnClick1 = new javax.swing.JButton();

        lblhead.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        lblhead.setForeground(new java.awt.Color(204, 32, 54));
        lblhead.setText("BUILDING WINDOWS APPLICATION WITH JAVA");

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel1.setText("SELECT YOUR AREA OF INTREST");

        jRadioButton1.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
        jRadioButton1.setText("Computer Science");
        jRadioButton1.setToolTipText("");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jRadioButton2.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
        jRadioButton2.setText("Physics");

        jRadioButton3.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
        jRadioButton3.setText("Statistics");
        jRadioButton3.setToolTipText("");

        jRadioButton4.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
        jRadioButton4.setText("Chemistry");

        jRadioButton5.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
        jRadioButton5.setText("Mathematics");

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel2.setText("SELECT YOUR DEPARTMENT");

        jCheckBox1.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
        jCheckBox1.setText("Programmer");

        jCheckBox2.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
        jCheckBox2.setText("Software Engineer");

        jCheckBox3.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
        jCheckBox3.setText("Software Designer");

        jCheckBox4.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
        jCheckBox4.setText("Web developer");

        jCheckBox5.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
        jCheckBox5.setText("System Analyst");

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel3.setText("SELECT YOUR FAVOURITE COLOUR");

        jComboBox1.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "RED", "BLUE", "GREEN", "YELLOW", "BLACK", "GREY", "PURPLE", "ORANGE", " " }));

        txtarea.setColumns(20);
        txtarea.setRows(5);
        jScrollPane1.setViewportView(txtarea);

        btnClick2.setBackground(javax.swing.UIManager.getDefaults().getColor("CheckBoxMenuItem.selectionBackground"));
        btnClick2.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnClick2.setText("Click Me");
        btnClick2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClick2ActionPerformed(evt);
            }
        });

        btnClick1.setBackground(javax.swing.UIManager.getDefaults().getColor("CheckBoxMenuItem.selectionBackground"));
        btnClick1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnClick1.setText("Click Me");
        btnClick1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClick1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblhead, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jRadioButton5)
                            .addComponent(jRadioButton4)
                            .addComponent(jRadioButton3)
                            .addComponent(jRadioButton2)
                            .addComponent(jRadioButton1)
                            .addComponent(jCheckBox5)
                            .addComponent(jCheckBox4)
                            .addComponent(jCheckBox3)
                            .addComponent(jCheckBox2)
                            .addComponent(jCheckBox1)
                            .addComponent(jLabel1))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnClick1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnClick2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnClick1, btnClick2});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lblhead, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton5))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jCheckBox1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnClick1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnClick2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnClick1, btnClick2});

    }// </editor-fold>//GEN-END:initComponents

    private void btnClick2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClick2ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnClick2ActionPerformed

    private void btnClick1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClick1ActionPerformed
    
        String selection = "";
        String Aintrest = "";
        String colour = "";
        if(jRadioButton1.isSelected()){
           selection = " "+ jRadioButton1.getText();
        }
        
        if(jRadioButton2.isSelected()){
           selection = " "+ jRadioButton2.getText();
        }
        
        if(jRadioButton3.isSelected()){
           selection = " "+ jRadioButton3.getText();
        }
        
        if(jRadioButton4.isSelected()){
           selection = " "+ jRadioButton4.getText();
        }
        
        if(jRadioButton5.isSelected()){
           selection = " "+ jRadioButton5.getText();
        }
        
        txtarea.setText("Your Department is: "+ selection+"\n");
        
        
        
        
        
        
    }//GEN-LAST:event_btnClick1ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
       
    }//GEN-LAST:event_jRadioButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClick1;
    private javax.swing.JButton btnClick2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblhead;
    private javax.swing.JTextArea txtarea;
    // End of variables declaration//GEN-END:variables
}
