/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package carinsurance;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
        
public class Login extends javax.swing.JFrame{
    
    InsuranceCompany insuranceCompany = new InsuranceCompany(); //Declare insurance company for test login
    //Declare all attributes of the frame
    /*private JButton jButton1;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JMenu jMenu1;
    private JMenu jMenu2;
    private JMenuBar jMenuBar1;
    private JMenuBar jMenuBar2;
    private JMenuItem jMenuItem1;
    private JMenuItem jMenuItem2;
    private JPasswordField passwordLog;
    private JTextField usernameLog;
    */
    public Login() /*throws PolicyException, PolicyHolderNameException*/ {
        test();
        //initComponents();
        initComponentsNew();
    }
    
    //Create Test for my program: 1 insurance company with 4 users
    public void test() /*throws PolicyException, PolicyHolderNameException*/{
        this.insuranceCompany = new InsuranceCompany("Dang Insurance Company", "adminname", "123456", 5); //Set up flatRate = 5
        Car newCar1 = new Car("SUV-12", CarType.SUV, 2021, 4500.5);
        MyDate expiryDate1 = new MyDate(2022, 01, 13);
        ThirdPartyPolicy newPolicy1 = new ThirdPartyPolicy("Dang Tran", 3123456, newCar1, 3, expiryDate1, "Good");
                    
        Address userAddress1 = new Address(159, "Street 1", "Suburb 1", "City 1");
        User userTest1 = new User("Dang Tran", 13, userAddress1, "dang_tran", "123456");

        userTest1.addPolicy(userTest1.getUserName(), userTest1.getUserPassword(), newPolicy1);
                    
        Car newCar3 = new Car("SUV-13", CarType.SUV, 2021, 4500.5);
        MyDate expiryDate3 = new MyDate(2022, 01, 13);
        ThirdPartyPolicy newPolicy3 = new ThirdPartyPolicy("Dang Tran", 3123456, newCar3, 3, expiryDate3, "Good");

        ComprehensivePolicy newPolicy4 = new ComprehensivePolicy("Sang Tran", 3111666, newCar3, 3, expiryDate3, 31, 2);
                    
        Address newAddress4 = new Address(200, "street4", "suburb4", "City 4");
        User userTest3 = new User("Boyce Avenue", 27, newAddress4, "boyceavenue", "123456");
        userTest3.addPolicy(userTest3.getUserNameLogin(), userTest3.getUserPassword(), newPolicy4);
        //userTest3.addPolicy1(newPolicy4);
        
        Address userAddress4 = new Address(159, "Street 1", "Suburb 1", "City 1");
        User userTest4 = new User("Dang Tran", 18, userAddress4, "dangtran", "123456");
        Car newCar10 = new Car("SUV-14", CarType.SUV, 2021, 100.0);
        MyDate expiryDate10 = new MyDate(2022, 01, 13);
        ThirdPartyPolicy newPolicy10 = new ThirdPartyPolicy("Dang Tran", 3123456, newCar10, 3, expiryDate1, "Good");
        
        userTest4.addPolicy(userTest4.getUserNameLogin(), userTest4.getUserPassword(), newPolicy10);
        userTest4.addPolicy(userTest4.getUserNameLogin(), userTest4.getUserPassword(), newPolicy4);
        
        Address userAddress2 = new Address(169, "Street 2", "Suburb 2", "City 2");
        User userTest2 = new User("Charlie Puth", 14, userAddress2, "charlieputh", "123456");
        Car newCar5 = new Car("SUV-12", CarType.SUV, 2022, 3500.5);
        MyDate expiryDate5 = new MyDate(2019, 1, 1);
        ThirdPartyPolicy newPolicy11 = new ThirdPartyPolicy("Charlie Puth", 3012456, newCar5, 3, expiryDate5, "Good");
        userTest2.addPolicy(userTest2.getUserNameLogin(), userTest2.getUserPassword(), newPolicy11);
        userTest2.addPolicy(userTest2.getUserNameLogin(), userTest2.getUserPassword(), newPolicy10);
        userTest2.addPolicy(userTest2.getUserNameLogin(), userTest2.getUserPassword(), newPolicy4);
        //insuranceCompany.createThirdPartyPolicy(14, "Charlie Puth", 3012456, newCar5, 3, expiryDate5, "Good");
                   
        
        insuranceCompany.addUser(userTest1);
        insuranceCompany.addUser(userTest2);
        insuranceCompany.addUser(userTest3);
        insuranceCompany.addUser(userTest4);
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jButton1 = new javax.swing.JButton();
        jPasswordField1 = new javax.swing.JPasswordField();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();

        jMenu1.setText("jMenu1");

        jMenu2.setText("jMenu2");

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        jMenu5.setText("jMenu5");

        jMenuItem3.setText("jMenuItem3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPasswordField1.setText("jPasswordField1");

        jTextField1.setText("jTextField1");

        jLabel1.setText("jLabel1");

        jLabel2.setText("jLabel2");

        jMenu3.setText("File");
        jMenuBar1.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(61, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(136, 136, 136))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(101, 101, 101))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(96, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(27, 27, 27)
                .addComponent(jButton1)
                .addGap(70, 70, 70))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //jButton1 - Action event
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        login();
    }//GEN-LAST:event_jButton1ActionPerformed
    
    //jPasswordField - Action event
    private void jPasswordField1ActionPerformed(ActionEvent evt){
        login();
    }
    
    //jMenuItem1 - Action event
    private void jMenuItem1ActionPerformed(ActionEvent evt){
        try
        {
            this.insuranceCompany = InsuranceCompany.load();
        }
        catch(IOException ex)
        {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, (String)null, ex);
        }
        catch (ClassNotFoundException ex)
        {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, (String)null, ex);
        }
    }
    
    //jMenuItem2 - Action event
    private void jMenuItem2ActionPerformed(ActionEvent evt){
        try
        {
            this.insuranceCompany.save();
        }
        catch(IOException ex)
        {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, (String)null, ex);
        }
    }
    
    //jMenu2 event - Mouse event - Display List of Users
    private void jMenu2MouseClicked(MouseEvent evt){
        String output = "";
        for(User user:this.insuranceCompany.getUsersList().values())
        {
            output += "username: " + user.getUserNameLogin() + ", password: " + user.getUserPassword() + "\n";
        }
        JOptionPane.showMessageDialog(this, output);
    }
    
    //jMenu5 event - Mouse event - Display information of Admin login
    private void jMenu5MouseClicked(MouseEvent evt){
        String output = "";
        output += "Admin username: " + this.insuranceCompany.getName() + ", password: " + this.insuranceCompany.getPassword() + "\n";
        JOptionPane.showMessageDialog(this, output);
    }
    
    
    //Login as An User or as An Admin
    public void login(){
        User user = this.insuranceCompany.validateUser(this.jTextField1.getText(), this.jPasswordField1.getText());
        InsuranceCompany company = this.insuranceCompany.validateAdmin1(this.jTextField1.getText(), this.jPasswordField1.getText());
        this.jPasswordField1.setText("");
        //Check Login is User or Admin or Wrong
        if(user != null && company == null)
        {
            ArrayList<String> cities = this.insuranceCompany.populateDistinctCityNames();
            UserUI userUI = new UserUI(user, this, cities);
            userUI.setVisible(true);
            setVisible(false);
        }
        else if(user == null && company != null)
        {
            ArrayList<String> cities = this.insuranceCompany.populateDistinctCityNames();
            ArrayList<String> listUserID = this.insuranceCompany.getAllUserID();
            AdminUI adminUI = new AdminUI(insuranceCompany, this, cities, listUserID);
            adminUI.setVisible(true);
            setVisible(false);
        }
        else if(company == null && user == null)
        {
            JOptionPane.showMessageDialog(this, "Username or Password is Wrong!!");
        }
        
        //Check before working on User UI
        /*if(user == null)
        {
            JOptionPane.showMessageDialog(this, "Username or password is wrong");
        }*/
    }
          
    private void initComponentsNew(){
        this.jLabel1 = new JLabel();
        this.jLabel2 = new JLabel();
        this.jTextField1 = new JTextField();
        this.jButton1 = new JButton();
        this.jPasswordField1 = new JPasswordField();
        this.jMenuBar1 = new JMenuBar();
        this.jMenu1 = new JMenu();
        this.jMenuItem1 = new JMenuItem();
        this.jMenuItem2 = new JMenuItem();
        this.jMenu2 = new JMenu();
        this.jMenu5 = new JMenu();
        setDefaultCloseOperation(3);
        
        //Set username field display
        this.jLabel1.setFont(new Font("TimesRoman", Font.ITALIC, 18));
        this.jLabel1.setText("Username");
        //Set password field display
        this.jLabel2.setFont(new Font("TimesRoman", Font.ITALIC, 18));
        this.jLabel2.setText("Password");
        
        this.jTextField1.setFont(new Font("TimesRoman", 1, 18)); // Set username properties
        this.jButton1.setFont(new Font("TimesRoman", 1, 18)); //Set Font for Login button
        this.jButton1.setForeground(new Color(255, 102, 102)); //Set Color for Login button
        this.jButton1.setText("Login"); //Name the button 1 is "Login" button
        
        this.jButton1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                Login.this.jButton1ActionPerformed(evt);
            }
        });
        
        //Password Field
        this.jPasswordField1.setFont(new Font("TimesRoman", 1, 18));
        this.jPasswordField1.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
                Login.this.jPasswordField1ActionPerformed(evt);
            }
        });
        
        //Set up Menu1 - File: Load and Save data from File
        
        //jMenuItem1 - Load data
        this.jMenu1.setText("File");
        this.jMenu1.setFont(new Font("Calibri", 1, 18));
        this.jMenuItem1.setFont(new Font("Calibri", 1, 18));
        this.jMenuItem1.setText("Load");
        this.jMenuItem1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt){
                Login.this.jMenuItem1ActionPerformed(evt);
            }
        });
        this.jMenu1.add(this.jMenuItem1); //Menu1 add MenuItem1
        
        //jMenuIterm2 - Save data
        this.jMenuItem2.setFont(new Font("Calibri", 1, 18));
        this.jMenuItem2.setText("Save");
        this.jMenuItem2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt){
                Login.this.jMenuItem2ActionPerformed(evt);
            }
        });
        this.jMenu1.add(this.jMenuItem2); //Menu1 add MenuItem2
        
        this.jMenuBar1.add(this.jMenu1); //MenuBar add Menu1
        
        //Set up Menu2 - List of Users
        this.jMenu2.setText("List of Users");
        this.jMenu2.setFont(new Font("Calibri", 1, 18));
        this.jMenu2.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent evt){
                Login.this.jMenu2MouseClicked(evt);
            }
        });
        
        this.jMenuBar1.add(this.jMenu2); // MenuBar add Menu2
        
        //Set up Menu3 - Information of Admin login
        this.jMenu5.setText("Information of Admin Login");
        this.jMenu5.setFont(new Font("Calibri", 1, 18));
        this.jMenu5.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent evt){
                Login.this.jMenu5MouseClicked(evt);
            }
        });
        
        this.jMenuBar1.add(this.jMenu5);
        
        
        setJMenuBar(this.jMenuBar1);
        
        //Set up layout
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout
        .createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
          .addGap(142, 142, 142)
          .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
            .addComponent(this.jButton1)
            .addGroup(layout.createSequentialGroup()
              .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(this.jLabel1, -2, 110, -2)
                .addComponent(this.jLabel2))
              .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
              .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                .addComponent(this.jTextField1)
                .addComponent(this.jPasswordField1, -1, 125, 32767))))
          .addContainerGap(298, 32767)));
        layout.setVerticalGroup(layout
        .createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
          .addGap(114, 114, 114)
          .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            .addComponent(this.jLabel1, -2, 29, -2)
            .addComponent(this.jTextField1, -2, -1, -2))
          .addGap(29, 29, 29)
          .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            .addComponent(this.jLabel2)
            .addComponent(this.jPasswordField1, -2, -1, -2))
          .addGap(34, 34, 34)
          .addComponent(this.jButton1)
          .addContainerGap(126, 32767)));
        pack();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws PolicyException, PolicyHolderNameException {
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
