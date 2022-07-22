/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package carinsurance;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import java.util.*;

public class UserUI extends javax.swing.JFrame {
    
    ArrayList<String> cities;
    User user;
    Login login;
    
    
    public UserUI(User user, Login login, ArrayList<String> cities) {
        //initComponents();
        this.user = user;
        this.login = login;
        this.cities = cities;
        initComponentsNew();
    }
    
    //Display Software after login success
    private void initComponentsNew(){
        this.buttonGroup1 = new ButtonGroup();
        this.policyTablePopUp = new JPopupMenu();
        this.jMenuItem1 = new JMenuItem();
        this.jMenuItem2 = new JMenuItem();
        this.jTabbedPane1 = new JTabbedPane();
        this.jPanel1 = new JPanel();
        this.jLabel1 = new JLabel();
        this.jLabel2 = new JLabel();
        this.jLabel3 = new JLabel();
        this.jLabel4 = new JLabel();
        this.jLabel5 = new JLabel();
        this.jLabel6 = new JLabel();
        this.jLabel7 = new JLabel();
        this.jLabel8 = new JLabel();
        this.jLabel9 = new JLabel();
        this.idText = new JTextField();
        this.cityText = new JTextField();
        this.nameText = new JTextField();
        this.usernameText = new JTextField();
        this.streetNoText = new JTextField();
        this.passwordText = new JTextField();
        this.streetText = new JTextField();
        this.suburbText = new JTextField();
        this.cityChoice = new JCheckBox();
        this.cityCombo = new JComboBox<>();
        this.changeButton = new JButton();
        this.jPanel2 = new JPanel();
        this.jLabel10 = new JLabel();
        this.jLabel11 = new JLabel();
        this.jLabel12 = new JLabel();
        this.jLabel13 = new JLabel();
        this.jLabel14 = new JLabel();
        this.jLabel15 = new JLabel();
        this.jLabel16 = new JLabel();
        this.jLabel17 = new JLabel();
        this.jLabel18 = new JLabel();
        this.jLabel19 = new JLabel();
        this.jLabel20 = new JLabel();
        this.jLabel21 = new JLabel();
        this.jLabel22 = new JLabel();
        this.commentAgeLabel = new JLabel();
        this.levelLabel = new JLabel();
        this.policyUsernameText = new JTextField();
        this.policyIDText = new JTextField();
        this.commentAgeText = new JTextField();
        this.manufacturingText = new JTextField();
        this.priceText = new JTextField();
        this.numberOfClaimsText = new JTextField();
        this.modelText = new JTextField();
        this.typeText = new JComboBox<>();
        this.monthText = new JTextField();
        this.yearText = new JTextField();
        this.levelText = new JTextField();
        this.dayText = new JTextField();
        //this.capText = new JTextField();
        this.thirdpartyChoice = new JRadioButton();
        this.comprehensiveChoice = new JRadioButton();
        this.jButton1 = new JButton();
        this.jButton2 = new JButton();
        this.jPanel5 = new JPanel();
        this.findBut = new JButton();
        this.jScrollPane2 = new JScrollPane();
        this.policyArea = new JTextArea();
        this.IDFindText = new JTextField();
        this.jLabel23 = new JLabel();
        this.jPanel3 = new JPanel();
        this.jScrollPane1 = new JScrollPane();
        this.policyTable = new JTable();
        this.updateBut = new JButton();
        this.delBut = new JButton();
        this.jPanel4 = new JPanel();
        this.jScrollPane3 = new JScrollPane();
        this.policyTable1 = new JTable();
        this.modelFilterText = new JTextField();
        this.jLabel24 = new JLabel();
        this.jLabel25 = new JLabel();
        this.dateFilterText = new JTextField();
        this.jButton3 = new JButton();
        this.sort = new JCheckBox();
        this.jMenuBar1 = new JMenuBar();
        this.jMenu1 = new JMenu();
        
        //Delete button of policies table
        this.jMenuItem1.setText("Delete");
        this.jMenuItem1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt){
                UserUI.this.jMenuItem1ActionPerformed(evt);
            }
        });
        this.policyTablePopUp.add(this.jMenuItem1);
        
        //Update button of policies table
        this.jMenuItem2.setText("Update");
        this.jMenuItem2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt){
                UserUI.this.jMenuItem2ActionPerformed(evt);
            }
        });
        this.policyTablePopUp.add(this.jMenuItem2);
        
        setDefaultCloseOperation(3);
        
        this.jTabbedPane1.setForeground(new Color(255, 255, 255));
        this.jTabbedPane1.setFont(new Font("TimesRoman", 1, 18));
        this.jTabbedPane1.addChangeListener(new ChangeListener(){
            public void stateChanged(ChangeEvent evt){
                UserUI.this.jTabbedPane1StateChanged(evt);
            }
        });
        
        this.jTabbedPane1.addFocusListener(new FocusAdapter(){
            public void focusGained(FocusEvent evt){
                UserUI.this.jTabbedPane1FocusGained(evt);
            }
        });
        
        //Set Name for first Tab - Edit Personal Data Tab
        this.jLabel1.setFont(new Font("TimesRoman", Font.ITALIC, 18));
        this.jLabel1.setText("User ID");
        
        this.jLabel2.setFont(new Font("TimesRoman", Font.ITALIC, 18));
        this.jLabel2.setText("Name of user");
        
        this.jLabel3.setFont(new Font("TimesRoman", Font.ITALIC, 18));
        this.jLabel3.setText("Username Login");
        
        this.jLabel4.setFont(new Font("TimesRoman", Font.ITALIC, 18));
        this.jLabel4.setText("Password Login");
        
        this.jLabel5.setFont(new Font("TimesRoman", Font.ITALIC, 18));
        this.jLabel5.setText("Address");
        
        this.jLabel6.setFont(new Font("TimesRoman", Font.ITALIC, 18));
        this.jLabel6.setText("Street Number");
        
        this.jLabel7.setFont(new Font("TimesRoman", Font.ITALIC, 18));
        this.jLabel7.setText("Street Name");
        
        this.jLabel8.setFont(new Font("TimesRoman", Font.ITALIC, 18));
        this.jLabel8.setText("Suburb");
        
        this.jLabel9.setFont(new Font("TimesRoman", Font.ITALIC, 18));
        this.jLabel9.setText("City");
        
        this.idText.setEditable(false);
        this.idText.setFont(new Font("TimesRoman", Font.ITALIC, 18));
        this.idText.setEnabled(false);
        
        this.cityText.setFont(new Font("TimesRoman", Font.ITALIC, 18));
        this.cityText.setEnabled(false);
        
        this.nameText.setFont(new Font("TimesRoman", Font.ITALIC, 18));
        
        this.usernameText.setEditable(false);
        this.usernameText.setFont(new Font("TimesRoman", Font.ITALIC, 18));
        this.usernameText.setEnabled(false);
        
        this.streetNoText.setFont(new Font("TimesRoman", 0, 18));
        this.passwordText.setFont(new Font("TimesRoman", 0, 18));
        this.streetText.setFont(new Font("TimesRoman", 0, 18));
        this.suburbText.setFont(new Font("TimesRoman", 0, 18));
        this.cityChoice.setFont(new Font("TimesRoman", 0, 18));
        this.cityChoice.setText("New City");
        
        this.cityChoice.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent evt){
                UserUI.this.cityChoiceItemStateChanged(evt);
            }
        });
        
        this.cityCombo.setFont(new Font("TimesRoman", 0, 18));
        this.changeButton.setFont(new Font("TimesRoman", 1, 18));
        this.changeButton.setForeground(new Color(255, 5, 50));
        this.changeButton.setText("Change");
        this.changeButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                UserUI.this.changeButtonActionPerformed(evt);
            }
        });
        
        //Set up layut for First Tav - Edit Personal Data Tab
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout
            .createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
              .addGap(21, 21, 21)
              .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                  .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(this.jLabel5)
                    .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                      .addComponent(this.jLabel9)
                      .addComponent(this.jLabel8)
                      .addComponent(this.jLabel7)
                      .addComponent(this.jLabel6)))
                  .addGap(25, 25, 25)
                  .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(this.streetText, -2, 112, -2)
                    .addComponent(this.streetNoText, -2, 112, -2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                      .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(this.changeButton)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                          .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                            .addComponent(this.cityCombo, 0, -1, 32767)
                            .addComponent(this.suburbText, -1, 112, 32767))
                          .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                          .addComponent(this.cityText, -2, 112, -2)))
                      .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                      .addComponent(this.cityChoice))))
                .addGroup(jPanel1Layout.createSequentialGroup()
                  .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(this.jLabel4)
                    .addComponent(this.jLabel3)
                    .addComponent(this.jLabel2)
                    .addComponent(this.jLabel1, -2, 108, -2))
                  .addGap(29, 29, 29)
                  .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(this.idText, -2, 112, -2)
                    .addComponent(this.nameText, -2, 112, -2)
                    .addComponent(this.usernameText, -2, 112, -2)
                    .addComponent(this.passwordText, -2, 112, -2))))
              .addContainerGap(1158, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout
            .createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
              .addGap(38, 38, 38)
              .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(this.jLabel1, -2, 29, -2)
                .addComponent(this.idText))
              .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
              .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(this.jLabel2)
                .addComponent(this.nameText))
              .addGap(18, 18, 18)
              .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(this.jLabel3)
                .addComponent(this.usernameText))
              .addGap(18, 18, 18)
              .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(this.jLabel4)
                .addComponent(this.passwordText))
              .addGap(18, 18, 18)
              .addComponent(this.jLabel5)
              .addGap(18, 18, 18)
              .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(this.jLabel6)
                .addComponent(this.streetNoText))
              .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
              .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(this.jLabel7)
                .addComponent(this.streetText))
              .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
              .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(this.jLabel8)
                .addComponent(this.suburbText))
              .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
              .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(this.jLabel9)
                .addComponent(this.cityText)
                .addComponent(this.cityChoice)
                .addComponent(this.cityCombo, -2, -1, -2))
              .addGap(33, 33, 33)
              .addComponent(this.changeButton)
              .addContainerGap(321, 32767)));

        this.jTabbedPane1.addTab("Edit Personal Data", this.jPanel1);
        
        this.jLabel10.setFont(new Font("TimesRoman", Font.ITALIC, 18));
        this.jLabel10.setText("Username");
        
        this.jLabel11.setFont(new Font("TimesRoman", Font.ITALIC, 18));
        this.jLabel11.setText("Policy ID");
        
        this.jLabel12.setFont(new Font("TimesRoman", Font.ITALIC, 18));
        this.jLabel12.setText("Manufacturing Year");
        
        this.jLabel13.setFont(new Font("TimesRoman", Font.ITALIC, 18));
        this.jLabel13.setText("Mobile Phone");
        
        this.jLabel14.setFont(new Font("TimesRoman", Font.ITALIC, 18));
        this.jLabel14.setText("Model");
        
        this.jLabel15.setFont(new Font("TimesRoman", Font.ITALIC, 18));
        this.jLabel15.setText("Car Type");
        
        this.jLabel16.setFont(new Font("TimesRoman", Font.ITALIC, 18));
        this.jLabel16.setText("Number Of Claims");
        
        this.jLabel17.setFont(new Font("TimesRoman", Font.ITALIC, 18));
        this.jLabel17.setText("Price");
        
        this.jLabel18.setFont(new Font("TimesRoman", Font.ITALIC, 18));
        this.jLabel18.setText("Month");
        
        this.jLabel19.setFont(new Font("TimesRoman", Font.ITALIC, 18));
        this.jLabel19.setText("");
        
        this.jLabel20.setFont(new Font("TimesRoman", Font.ITALIC, 18));
        this.jLabel20.setText("Expiry Date");
        
        this.jLabel21.setFont(new Font("TimesRoman", Font.ITALIC, 18));
        this.jLabel21.setText("Day");
        
        this.jLabel22.setFont(new Font("TimesRoman", Font.ITALIC, 18));
        this.jLabel22.setText("Year");
        
        this.commentAgeLabel.setFont(new Font("TimesRoman", Font.ITALIC, 18));
        this.commentAgeLabel.setHorizontalAlignment(10);
        this.commentAgeLabel.setText("Comment");
        
        this.levelLabel.setFont(new Font("TimesRoman", Font.ITALIC, 18));
        this.levelLabel.setText(("Level"));
        
        this.policyUsernameText.setFont(new Font("TimesRoman", Font.ITALIC, 18));
        this.policyIDText.setFont(new Font("TimesRoman", Font.ITALIC, 18));
        this.commentAgeText.setFont(new Font("TimesRoman", Font.ITALIC, 18));
        this.modelText.setFont(new Font("TimesRoman", Font.ITALIC, 18));
        this.typeText.setFont(new Font("TimesRoman", Font.ITALIC, 18));
        this.typeText.setModel(new DefaultComboBoxModel<>(new String[] {"SUV", "SED", "HATCH", "LUX"}));
        this.priceText.setFont(new Font("TimesRoman", Font.ITALIC, 18));
        this.manufacturingText.setFont(new Font("TimesRoman", Font.ITALIC, 18));
        this.numberOfClaimsText.setFont(new Font("TimesRoman", Font.ITALIC, 18));
        this.dayText.setFont(new Font("TimesRoman", Font.ITALIC, 18));
        this.monthText.setFont(new Font("TimesRoman", Font.ITALIC, 18));
        this.yearText.setFont(new Font("TimesRoman", Font.ITALIC, 18));
        this.levelText.setFont(new Font("TimesRoman", Font.ITALIC, 18));
        this.buttonGroup1.add(this.thirdpartyChoice);
        this.thirdpartyChoice.setFont(new Font("TimesRoman", Font.ITALIC, 18));
        this.thirdpartyChoice.setSelected(true);
        this.thirdpartyChoice.setText("Third Party Policy");
        this.thirdpartyChoice.addChangeListener(new ChangeListener(){
            public void stateChanged(ChangeEvent evt){
                UserUI.this.thirdpartyChoiceStateChanged(evt);
            }
        });
        
        this.buttonGroup1.add(this.comprehensiveChoice);
        this.comprehensiveChoice.setFont(new Font("TimesRoman", Font.ITALIC, 18));
        this.comprehensiveChoice.setText("Comprehensive Policy");
        
        //ADD Button in Tab Add Policy
        this.jButton1.setFont(new Font("TimesRoman", Font.ITALIC, 18));
        this.jButton1.setForeground(new Color(255, 0, 125));
        this.jButton1.setText("ADD");
        this.jButton1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                UserUI.this.jButton1ActionPerformed(evt);
            }
        });
        
        //CLEAR Button in Tab Clear Policy
        this.jButton2.setFont(new Font("TimesRoman", Font.ITALIC, 18));
        this.jButton2.setForeground(new Color(255, 0, 125));
        this.jButton2.setText("CLEAR");
        this.jButton2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                UserUI.this.jButton2ActionPerformed(evt);
            }
        });
        
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout
            .createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
              .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                  .addGap(61, 61, 61)
                  .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                      .addComponent(this.jLabel19)
                      .addComponent(this.jLabel16)
                      .addComponent(this.jLabel20))
                    .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                      .addComponent(this.jLabel11)
                      .addComponent(this.jLabel13)
                      .addComponent(this.jLabel10))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                      .addGap(48, 48, 48)
                      .addComponent(this.thirdpartyChoice)
                      .addGap(18, 18, 18)
                      .addComponent(this.comprehensiveChoice))))
                .addGroup(jPanel2Layout.createSequentialGroup()
                  .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                      .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(this.jLabel15)
                        .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                          .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(144, 144, 144)
                            .addComponent(this.jLabel14))
                          .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(35, 35, 35)
                            .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                              .addComponent(this.jLabel22)
                              .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(this.levelLabel)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                  .addGap(109, 109, 109)
                                  .addComponent(this.jLabel18))
                                .addComponent(this.commentAgeLabel, GroupLayout.Alignment.TRAILING, -2, 44, -2)))))
                        .addComponent(this.jLabel12)
                        .addComponent(this.jLabel17))
                      .addGap(21, 21, 21))
                    .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                      .addComponent(this.jLabel21)
                      .addGap(20, 20, 20)))
                  .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(this.manufacturingText, GroupLayout.Alignment.TRAILING, -1, 164, 32767)
                    .addComponent(this.priceText, GroupLayout.Alignment.TRAILING)
                    //.addComponent(this.capText, GroupLayout.Alignment.TRAILING)
                    .addComponent(this.numberOfClaimsText, GroupLayout.Alignment.TRAILING)
                    .addComponent(this.dayText)
                    .addComponent(this.monthText)
                    .addComponent(this.policyIDText)
                    .addComponent(this.yearText)
                    .addComponent(this.commentAgeText)
                    .addComponent(this.levelText)
                    .addComponent(this.typeText, 0, 164, 32767)
                    .addComponent(this.policyUsernameText)
                    .addComponent(this.modelText, GroupLayout.Alignment.TRAILING)
                    .addComponent(this.jButton1, -1, -1, 32767))))
              .addGap(106, 106, 106)
              .addComponent(this.jButton2, -2, 101, -2)
              .addContainerGap(1106, 32767)));
            jPanel2Layout.setVerticalGroup(jPanel2Layout
            .createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
              .addGap(12, 12, 12)
              .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(this.thirdpartyChoice)
                .addComponent(this.comprehensiveChoice))
              .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
              .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(this.jLabel11)
                .addComponent(this.policyIDText, -2, -1, -2)
                .addComponent(this.jButton2))
              .addGap(9, 9, 9)
              .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(this.policyUsernameText, -2, -1, -2)
                .addComponent(this.jLabel10))
              .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
              .addComponent(this.jLabel13)
              .addGap(4, 4, 4)
              .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(this.modelText, -2, -1, -2)
                .addComponent(this.jLabel14))
              .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
              .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(this.jLabel15, -2, 28, -2)
                .addComponent(this.typeText, -2, 28, -2))
              .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
              .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(this.jLabel12)
                .addComponent(this.manufacturingText, -2, -1, -2))
              .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
              .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(this.jLabel17)
                .addComponent(this.priceText, -2, -1, -2))
              .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
              .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(this.jLabel16)
                .addComponent(this.numberOfClaimsText, -2, -1, -2))
              .addGap(18, 18, 18)
              .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                //.addComponent(this.capText, -2, -1, -2)
                .addComponent(this.jLabel19))
              .addGap(18, 18, 18)
              .addComponent(this.jLabel20)
              .addGap(13, 13, 13)
              .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(this.jLabel21)
                .addComponent(this.dayText, -2, -1, -2))
              .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
              .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(this.jLabel18)
                .addComponent(this.monthText, -2, -1, -2))
              .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
              .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(this.jLabel22)
                .addComponent(this.yearText, -2, -1, -2))
              .addGap(18, 18, 18)
              .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(this.commentAgeText, -2, -1, -2)
                .addComponent(this.commentAgeLabel))
              .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
              .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(this.levelLabel, -2, 33, -2)
                .addComponent(this.levelText, -2, -1, -2))
              .addGap(26, 26, 26)
              .addComponent(this.jButton1)
              .addContainerGap(105, 32767)));
            
        this.jTabbedPane1.addTab("Add Policies", this.jPanel2);
        
        this.findBut.setFont(new Font("TimesRoman", Font.ITALIC, 18));
        this.findBut.setForeground(new Color(255, 0, 102));
        this.findBut.setText("FIND");
        this.findBut.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                UserUI.this.findButActionPerformed(evt);
            }
        });
        
        this.policyArea.setBackground(new Color(255, 255, 255));
        this.policyArea.setColumns(20);
        this.policyArea.setFont(new Font("Arial", Font.BOLD, 18));
        this.policyArea.setRows(5);
        
        this.jScrollPane2.setViewportView(this.policyArea);
        this.IDFindText.setFont(new Font("TimesRoman", 0, 18));
        this.jLabel23.setFont(new Font("TimesRoman", 0, 18));
        this.jLabel23.setText("Policy ID");
        
        GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
        this.jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(jPanel5Layout
            .createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
              .addGap(46, 46, 46)
              .addComponent(this.jLabel23)
              .addGap(18, 18, 18)
              .addComponent(this.IDFindText, -2, 138, -2)
              .addGap(20, 20, 20)
              .addComponent(this.findBut, -2, 85, -2)
              .addContainerGap(1343, 32767))
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
              .addContainerGap()
              .addComponent(this.jScrollPane2)
              .addContainerGap()));
        jPanel5Layout.setVerticalGroup(jPanel5Layout
            .createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
              .addGap(30, 30, 30)
              .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(this.findBut)
                .addComponent(this.IDFindText, -2, -1, -2)
                .addComponent(this.jLabel23, -2, 31, -2))
              .addGap(56, 56, 56)
              .addComponent(this.jScrollPane2, -2, 518, -2)
              .addContainerGap(161, 32767)));
        
        this.jTabbedPane1.addTab("Find Policy", this.jPanel5);
        this.policyTable.setFont(new Font("TimesRoman", Font.ITALIC, 18));
        this.policyTable.setModel(new DefaultTableModel(new Object[][] { {}, {}, {}, {} }, (Object[])new String[0]));
        this.policyTable.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                UserUI.this.policyTableMousePressed(evt);
            }
        });
        
        this.jScrollPane1.setViewportView(this.policyTable);
        this.updateBut.setFont(new Font("TimesRoman", 1, 18));
        this.updateBut.setForeground(new Color(255, 0, 125));
        this.updateBut.setText("UPDATE");
        this.updateBut.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                UserUI.this.updateButActionPerformed(evt);
            }
        });
        
        this.delBut.setFont(new Font("TimesRoman", 1, 18));
        this.delBut.setForeground(new Color(255, 0, 125));
        this.delBut.setText("DELETE");
        this.delBut.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                UserUI.this.delButActionPerformed(evt);
            }
        });
        
        GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
        this.jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout
            .createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(this.jScrollPane1, -1, 1708, 32767)
            .addGroup(jPanel3Layout.createSequentialGroup()
              .addGap(268, 268, 268)
              .addComponent(this.updateBut)
              .addContainerGap(-1, 32767))
            .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
              .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(143, 143, 143)
                .addComponent(this.delBut)
                .addContainerGap(1464, 32767))));
        jPanel3Layout.setVerticalGroup(jPanel3Layout
            .createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
              .addComponent(this.jScrollPane1, -2, 444, -2)
              .addGap(37, 37, 37)
              .addComponent(this.updateBut)
              .addGap(0, 284, 32767))
            .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
              .addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(482, 32767)
                .addComponent(this.delBut)
                .addGap(283, 283, 283))));
        
        this.jTabbedPane1.addTab("Policies Information", this.jPanel3);
        this.policyTable1.setFont(new Font("TimesRoman", 0, 18));
        this.policyTable1.setModel(new DefaultTableModel(new Object[][] { {}, {}, {}, {}}, (Object[])new String[0]));
        this.jScrollPane3.setViewportView(this.policyTable1);
        this.modelFilterText.setFont(new Font("TimesRoman", 0, 18));
        this.modelFilterText.addKeyListener(new KeyAdapter(){
            public void keyReleased(KeyEvent evt){
                UserUI.this.modelFilterTextKeyReleased(evt);
            }
        });
        
        this.jLabel24.setFont(new Font("TimesRoman", Font.ITALIC, 18));
        this.jLabel24.setText("Car Model");
        this.jLabel25.setFont(new Font("TimesRoman", Font.ITALIC, 18));
        this.jLabel25.setText("Expiry Date");
        this.dateFilterText.setFont(new Font("TimesRoman", 0, 18));
        this.jButton3.setFont(new Font("TimesRoman", Font.ITALIC, 18));
        this.jButton3.setText("Filter By Date");
        this.jButton3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                UserUI.this.jButton3ActionPerformed(evt);
            }
        });
        
        this.sort.setFont(new Font("TimesRoman", Font.ITALIC, 18));
        this.sort.setText("Sort By Name");
        this.sort.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                UserUI.this.sortActionPerformed(evt);
            }
        });
        
        GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
        this.jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(jPanel4Layout
            .createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(this.jScrollPane3, -1, 1708, 32767)
            .addGroup(jPanel4Layout.createSequentialGroup()
              .addGap(44, 44, 44)
              .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                  .addComponent(this.jLabel25)
                  .addGap(29, 29, 29)
                  .addComponent(this.dateFilterText, -2, 136, -2))
                .addGroup(jPanel4Layout.createSequentialGroup()
                  .addComponent(this.jLabel24)
                  .addGap(29, 29, 29)
                  .addComponent(this.modelFilterText, -2, 136, -2)))
              .addGap(30, 30, 30)
              .addComponent(this.jButton3)
              .addGap(204, 204, 204)
              .addComponent(this.sort)
              .addContainerGap(-1, 32767)));
        jPanel4Layout.setVerticalGroup(jPanel4Layout
            .createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
              .addComponent(this.jScrollPane3, -2, 512, -2)
              .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                  .addGap(33, 33, 33)
                  .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(this.jLabel24)
                    .addComponent(this.modelFilterText, -2, -1, -2))
                  .addGap(18, 18, 18)
                  .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(this.jLabel25)
                    .addComponent(this.dateFilterText, -2, -1, -2)
                    .addComponent(this.jButton3)))
                .addGroup(jPanel4Layout.createSequentialGroup()
                  .addGap(73, 73, 73)
                  .addComponent(this.sort)))
              .addContainerGap(174, 32767)));
        
        this.jTabbedPane1.addTab("Filter Policies", this.jPanel4);
        this.jMenu1.setText("Logout");
        this.jMenu1.setFont(new Font("TimesRoman", 1, 18));
        this.jMenu1.addMouseListener(new MouseAdapter() {
              public void mousePressed(MouseEvent evt) {
                UserUI.this.jMenu1MousePressed(evt);
              }
            });
        
        this.jMenuBar1.add(this.jMenu1);
        setJMenuBar(this.jMenuBar1);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout
            .createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
              .addContainerGap()
              .addComponent(this.jTabbedPane1)
              .addGap(97, 97, 97)));
        layout.setVerticalGroup(layout
            .createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
              .addGap(0, 0, 0)
              .addComponent(this.jTabbedPane1, -2, 832, -2)
              .addContainerGap(-1, 32767)));
        
        pack();
    }
    
    //jMenuItem1 - Delete, action event
    private void jMenuItem1ActionPerformed(ActionEvent evt){
        int ind = this.policyTable.getSelectedRow();
        if(ind >= 0)
        {
            int ind_temp = 0;
            for(int policyid : this.user.getPolicies().keySet())
            {
                if(ind_temp == ind)
                {
                    this.user.getPolicies().remove(policyid);
                    break;
                }
                ind_temp++;
            }
            fillTable();
        }
    }
    
    //jMenuItem2 - Update, action event
    private void jMenuItem2ActionPerformed(ActionEvent evt){
        int ind = this.policyTable.getSelectedRow();
        if(ind >= 0)
        {
            InsurancePolicies policy;
            int ind_temp = 0;
            for(int policyid : this.user.getPolicies().keySet())
            {
                if(ind_temp == ind)
                {
                    policy = this.user.getPolicies().get(policyid);
                    UpdateUI updateUI = new UpdateUI(policy, this);
                    updateUI.setVisible(true);
                    break;
                }
                ind_temp++;
            }
        }
    }
    
    //jTabbedPane1 - Change Event
    private void jTabbedPane1StateChanged(ChangeEvent evt){
        this.policyArea.setText("");
        this.idText.setText(this.user.getUserID() + "");
        this.nameText.setText(this.user.getUserName());
        this.usernameText.setText(this.user.getUserNameLogin());
        this.passwordText.setText(this.user.getUserPassword());
        this.streetNoText.setText(this.user.getAddress().getStreetNum() + "");
        this.streetText.setText(this.user.getAddress().getStreet());
        this.suburbText.setText(this.user.getAddress().getSuburb());
        this.cityCombo.setModel(new DefaultComboBoxModel<>(this.cities.toArray(new String[0])));
        this.cityCombo.setSelectedItem(this.user.getAddress().getCity());
        this.cityText.setText(this.user.getAddress().getCity());
        
        if(this.thirdpartyChoice.isSelected())
        {
            this.levelLabel.setVisible(false);
            this.levelText.setVisible(false);
            this.commentAgeLabel.setText("Cmt");
        }
        else
        {
            this.levelLabel.setVisible(true);
            this.levelText.setVisible(true);
            this.commentAgeLabel.setText("Age");
        }
        
        this.policyTable.setComponentPopupMenu(this.policyTablePopUp);
        fillTable();
        fillTable1();
    }
    
    //jTabbedPane1 - Focus Event
    private void jTabbedPane1FocusGained(FocusEvent evt){
        fillTable1();
    }
    
    //cityChoice - ItemEvent, select new city
    private void cityChoiceItemStateChanged(ItemEvent evt){
        if(this.cityChoice.isSelected())
        {
            this.cityCombo.setEnabled(false);
            this.cityText.setEnabled(true);
        }
        else
        {
            this.cityCombo.setEnabled(true);
            this.cityText.setEnabled(false);
        }
    }
    
    //change button - Action event, change city from distinct cities or new city
    private void changeButtonActionPerformed(ActionEvent evt){
        try
        {
            this.user.setName(this.nameText.getText());
            this.user.setPassword(this.passwordText.getText());
            this.user.getAddress().setStreetNum(Integer.parseInt(this.streetNoText.getText()));
            this.user.getAddress().setStreet(this.streetText.getText());
            this.user.getAddress().setSuburb(this.suburbText.getText());
            
            if(this.cityChoice.isSelected())
            {
                this.user.getAddress().setCity(this.cityText.getText());
                this.cities.add(this.cityText.getText());
                this.cityCombo.setModel(new DefaultComboBoxModel<>(this.cities.toArray(new String[0])));
                this.cityCombo.setSelectedItem(this.cityText.getText());
            }
            else
            {
                this.user.getAddress().setCity((String)this.cityCombo.getSelectedItem());
                this.cityText.setText(this.user.getAddress().getCity());
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, e);
        }
    }
    
    //personalChoice - Select Third Party or Comprehensive Policy
    private void thirdpartyChoiceStateChanged(ChangeEvent evt){
        if(this.thirdpartyChoice.isSelected())
        {
            this.levelLabel.setVisible(false);
            this.levelText.setVisible(false);
            this.commentAgeLabel.setText("Cmt");
        }
        else
        {
            this.levelLabel.setVisible(true);
            this.levelText.setVisible(true);
            this.commentAgeLabel.setText("Age");
        }
    }
    
    //jButton1 - ADD policy feature
    private void jButton1ActionPerformed(ActionEvent evt){
        try
        {
            InsurancePolicies policy;
            int id = Integer.parseInt(this.policyIDText.getText());
            String username = this.policyUsernameText.getText();
            String model = this.modelText.getText();
            CarType type = CarType.valueOf(this.typeText.getSelectedItem().toString());
            int manufacturingYear = Integer.parseInt(this.manufacturingText.getText());
            double price = Double.parseDouble(this.priceText.getText());
            int numberOfClaims = Integer.parseInt(this.numberOfClaimsText.getText());
            int day = Integer.parseInt(this.dayText.getText());
            int month = Integer.parseInt(this.monthText.getText());
            int year = Integer.parseInt(this.yearText.getText());
            
            MyDate date = new MyDate(year, month, day);
            Car car = new Car(model, type, manufacturingYear, price);
            
            if(this.thirdpartyChoice.isSelected())
            {
                String comment = this.commentAgeText.getText();
                policy = new ThirdPartyPolicy(username, id, car, numberOfClaims, date, comment);
            }
            else
            {
                int age = Integer.parseInt(this.commentAgeText.getText());
                int level = Integer.parseInt(this.levelText.getText());
                policy = new ComprehensivePolicy(username, id, car, numberOfClaims, date, age, level);
            }
            
            if(this.user.addPolicy(this.user.getUserNameLogin(), this.user.getUserPassword(), policy))
            {
                JOptionPane.showMessageDialog(this, "Policy has been added");
                this.policyIDText.setText("");
                this.policyUsernameText.setText("");
                this.modelText.setText("");
                this.manufacturingText.setText("");
                this.priceText.setText("");
                this.numberOfClaimsText.setText("");
                this.dayText.setText("");
                this.monthText.setText("");
                this.yearText.setText("");
                this.commentAgeText.setText("");
                this.levelText.setText("");
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Policy has not been added");
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, e);
        }
    }
    
    //jButton2 - CLEAR policy feature
    private void jButton2ActionPerformed(ActionEvent evt){
        this.policyIDText.setText("");
        this.policyUsernameText.setText("");
        this.modelText.setText("");
        this.manufacturingText.setText("");
        this.priceText.setText("");
        this.numberOfClaimsText.setText("");
        this.dayText.setText("");
        this.monthText.setText("");
        this.yearText.setText("");
        this.commentAgeText.setText("");
        this.levelText.setText("");
    }
    
    //findBut - FIND Policies button in tab Find Policy
    private void findButActionPerformed(ActionEvent evt){
        try
        {
            InsurancePolicies policy=  this.user.findPolicy(Integer.parseInt(this.IDFindText.getText()));
            if(policy != null)
            {
                this.policyArea.append(policy.toString() + "\n");
            }
            else
            {
                this.policyArea.append("Policy with ID = " + this.IDFindText.getText() + " has not been found \n");
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, e);
        }
    }
    
    //policyTableMousePressed - Table Policy in Policy Information Tab, Mouse Event
    private void policyTableMousePressed(MouseEvent evt){
        
    }
    
    //updateBut - Update Button in Policy Information Tab
    private void updateButActionPerformed(ActionEvent evt){
        int ind = this.policyTable.getSelectedRow();
        if(ind >= 0)
        {
            InsurancePolicies policy;
            int ind_temp = 0;
            for(int policyid : this.user.getPolicies().keySet())
            {
                if(ind_temp == ind)
                {
                    policy = this.user.getPolicies().get(policyid);
                    UpdateUI updateUI = new UpdateUI(policy, this);
                    updateUI.setVisible(true);
                    break;
                }
                ind_temp++;
            }
            /*UpdateUI updateUI = new UpdateUI(this.user.getPolicies1().get(ind), this);
            updateUI.setVisible(true);*/
        }
    }
    
    //deleteBut - Delete Button in Policy Information Tab
    private void delButActionPerformed(ActionEvent evt){
        int ind = this.policyTable.getSelectedRow();
        if(ind >= 0)
        {
            int ind_temp = 0;
            for(int policyid : this.user.getPolicies().keySet())
            {
                if(ind_temp == ind)
                {
                    this.user.getPolicies().remove(policyid);
                    break;
                }
                ind_temp++;
            }
            //this.user.getPolicies().remove(this.user.getPolicies().get(ind));
            fillTable();
        }
    }
    
    //modelFilterText - Key Event
    private void modelFilterTextKeyReleased(KeyEvent evt){
        fillTable1();
    }
    
    //jButton3 - Filter By Date Button in Filter Policy - Action event
    private void jButton3ActionPerformed(ActionEvent evt){
        fillTable1();
    }
    
    //Sort By Name Button - Filter Policy
    private void sortActionPerformed(ActionEvent evt)
    {
        fillTable1();
    }
    
    //jMenu1
    private void jMenu1MousePressed(MouseEvent evt){
        dispose();
        this.login.setVisible(true);
    }
    
    public void fillTable(){
        String[] header = {
            "Policy ID", "username", "Model", "Car Type", "Manufacturing Year", "Price", "Number of Claims" ,"ExpiryDate",
            "Comment", "Age", "Level", "Payment"
        };
        DefaultTableModel model = new DefaultTableModel((Object[])header, 0);
        this.policyTable.setModel(model);
        for(InsurancePolicies policy:this.user.getPolicies().values())
        {
            String[] row = new String[12];
            row[0] = policy.getID() + "";
            row[1] = policy.getPolicyHolderName();
            row[2] = policy.getCar().getModel();
            row[3] = policy.getCar().getType().toString();
            row[4] = policy.getCar().getYear() + "";
            row[5] = policy.getCar().getPrice() + "";
            row[6] = policy.numberOfClaims + "";
            row[7] = policy.getExpiryDate().toString();
            if(policy instanceof ThirdPartyPolicy)
            {
                row[8] = ((ThirdPartyPolicy)policy).comments;
                row[9] = "NA";
                row[10] = "NA";
            }
            else
            {
                row[8] = "NA";
                row[9] = ((ComprehensivePolicy)policy).driverAge + "";
                row[10] = ((ComprehensivePolicy)policy).level + "";
            }
            
            row[11] = String.format("$%.2f", new Object[] { Double.valueOf(policy.calcPayment(5)) });
            model.addRow((Object[])row);
        }
    }
    
    public void fillTable1(){
        ArrayList<InsurancePolicies> policiesCopy = new ArrayList<InsurancePolicies>();
        for(InsurancePolicies policy:this.user.getPolicies().values())
        {
            policiesCopy.add(policy);
            //policiesCopyNew.put(policy.getID(), policy);
        }
        try
        {
            if(!this.modelFilterText.getText().isEmpty())
            {
                policiesCopy = InsurancePolicies.filterByCarModel(policiesCopy, this.modelFilterText.getText());
            }
            if(!this.dateFilterText.getText().isEmpty())
            {
                String[] fields = this.dateFilterText.getText().split("/");
                int year = Integer.parseInt(fields[0]);
                int month = Integer.parseInt(fields[1]);
                int day = Integer.parseInt(fields[2]);
                MyDate date = new MyDate(year, month, day);
                policiesCopy = InsurancePolicies.filterByExpiryDate(policiesCopy, date);
                //policiesCopyNew = InsurancePolicies.filterByExpiryDate(policiesCopyNew, date);
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, e);
        }
        if (this.sort.isSelected())
        {
            Collections.sort(policiesCopy); 
        }
        String[] header = {
            "Policy ID", "username", "Model", "Car Type", "Manufacturing Year", "Price", "Number of Claims" ,"ExpiryDate",
            "Comment", "Age", "Level", "Payment"
            };
            DefaultTableModel model = new DefaultTableModel((Object[])header, 0);
            this.policyTable1.setModel(model);
            for(InsurancePolicies policy:policiesCopy)
            {
                String[] row = new String[12];
                row[0] = policy.getID() + "";
                row[1] = policy.getPolicyHolderName();
                row[2] = policy.getCar().getModel();
                row[3] = policy.getCar().getType().toString();
                row[4] = policy.getCar().getYear() + "";
                row[5] = policy.getCar().getPrice() + "";
                row[6] = policy.numberOfClaims + "";
                row[7] = policy.getExpiryDate().toString();
                if(policy instanceof ThirdPartyPolicy)
                {
                    row[8] = ((ThirdPartyPolicy)policy).comments;
                    row[9] = "NA";
                    row[10] = "NA";
                }
                else
                {
                    row[8] = "NA";
                    row[9] = ((ComprehensivePolicy)policy).driverAge + "";
                    row[10] = ((ComprehensivePolicy)policy).level + "";
                }

                row[11] = String.format("$%.2f", new Object[] { Double.valueOf(policy.calcPayment(5)) });
                model.addRow((Object[])row);
            }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        policyTablePopUp = new javax.swing.JPopupMenu();
        IDFindText = new javax.swing.JTextField();
        comprehensiveChoice = new javax.swing.JRadioButton();
        changeButton = new javax.swing.JButton();
        cityChoice = new javax.swing.JCheckBox();
        cityCombo = new javax.swing.JComboBox<>();
        commentAgeText = new javax.swing.JTextField();
        cityText = new javax.swing.JTextField();
        dateFilterText = new javax.swing.JTextField();
        dayText = new javax.swing.JTextField();
        delBut = new javax.swing.JButton();
        findBut = new javax.swing.JButton();
        idText = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        modelFilterText = new javax.swing.JTextField();
        modelText = new javax.swing.JTextField();
        monthText = new javax.swing.JTextField();
        nameText = new javax.swing.JTextField();
        passwordText = new javax.swing.JTextField();
        thirdpartyChoice = new javax.swing.JRadioButton();
        priceText = new javax.swing.JTextField();
        sort = new javax.swing.JCheckBox();
        streetNoText = new javax.swing.JTextField();
        streetText = new javax.swing.JTextField();
        suburbText = new javax.swing.JTextField();
        typeText = new javax.swing.JComboBox<>();
        updateBut = new javax.swing.JButton();
        usernameText = new javax.swing.JTextField();
        yearText = new javax.swing.JTextField();
        commentAgeLabel = new javax.swing.JLabel();
        levelLabel = new javax.swing.JLabel();
        levelText = new javax.swing.JTextField();
        policyUsernameText = new javax.swing.JTextField();
        policyIDText = new javax.swing.JTextField();
        manufacturingText = new javax.swing.JTextField();
        numberOfClaimsText = new javax.swing.JTextField();
        policyTable1 = new javax.swing.JTable();
        policyTable = new javax.swing.JTable();
        policyArea = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();

        jMenu1.setText("jMenu1");

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        IDFindText.setText("jTextField1");

        comprehensiveChoice.setText("jRadioButton1");

        changeButton.setText("jButton1");

        cityChoice.setText("jCheckBox1");

        cityCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        commentAgeText.setText("jTextField1");

        cityText.setText("jTextField1");

        dateFilterText.setText("jTextField1");

        dayText.setText("jTextField1");

        delBut.setText("jButton1");

        findBut.setText("jButton1");

        idText.setText("jTextField1");

        jButton1.setText("jButton1");

        jButton2.setText("jButton2");

        jButton3.setText("jButton3");

        jLabel1.setText("jLabel1");

        jLabel2.setText("jLabel2");

        jLabel3.setText("jLabel3");

        jLabel4.setText("jLabel4");

        jLabel5.setText("jLabel5");

        jLabel6.setText("jLabel6");

        jLabel7.setText("jLabel7");

        jLabel8.setText("jLabel8");

        jLabel9.setText("jLabel9");

        jLabel10.setText("jLabel10");

        jLabel11.setText("jLabel11");

        jLabel12.setText("jLabel12");

        jLabel13.setText("jLabel13");

        jLabel14.setText("jLabel14");

        jLabel15.setText("jLabel15");

        jLabel16.setText("jLabel16");

        jLabel17.setText("jLabel17");

        jLabel18.setText("jLabel18");

        jLabel19.setText("jLabel19");

        jLabel20.setText("jLabel20");

        jLabel21.setText("jLabel21");

        jLabel22.setText("jLabel22");

        jLabel23.setText("jLabel23");

        jLabel24.setText("jLabel24");

        jLabel25.setText("jLabel25");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 191, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 126, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 270, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 199, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        modelFilterText.setText("jTextField1");

        modelText.setText("jTextField1");

        monthText.setText("jTextField1");

        nameText.setText("jTextField1");

        passwordText.setText("jTextField1");

        thirdpartyChoice.setText("jRadioButton1");

        priceText.setText("jTextField1");

        sort.setText("jCheckBox1");

        streetNoText.setText("jTextField1");

        streetText.setText("jTextField1");

        suburbText.setText("jTextField1");

        typeText.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        updateBut.setText("jButton4");

        usernameText.setText("jTextField1");

        yearText.setText("jTextField1");

        commentAgeLabel.setText("jLabel26");

        levelLabel.setText("jLabel26");

        levelText.setText("jTextField1");

        policyUsernameText.setText("jTextField1");

        policyIDText.setText("jTextField1");

        manufacturingText.setText("jTextField1");

        numberOfClaimsText.setText("jTextField1");

        policyTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));

        policyTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));

        policyArea.setColumns(20);
        policyArea.setRows(5);

        jMenu2.setText("File");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("Edit");
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(67, 67, 67)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(67, 67, 67)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(264, 264, 264)
                                .addComponent(levelLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(95, 95, 95)
                                .addComponent(manufacturingText, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(numberOfClaimsText, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(delBut)
                            .addComponent(cityText, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(dateFilterText, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(findBut)
                                .addGap(18, 18, 18)
                                .addComponent(idText, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(policyUsernameText, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(policyIDText, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(30, 30, 30))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(IDFindText, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(9, 9, 9)
                                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(comprehensiveChoice)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(87, 87, 87)
                                                        .addComponent(commentAgeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(changeButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 702, Short.MAX_VALUE)
                                        .addComponent(cityChoice)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton3))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(usernameText, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(35, 35, 35)
                                        .addComponent(yearText, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cityCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(78, 78, 78)
                                        .addComponent(commentAgeText, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(dayText, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(70, 70, 70))))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(71, 71, 71)
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(116, 116, 116)
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(36, 36, 36))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(78, 78, 78)))
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(typeText, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(128, 128, 128)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(streetNoText, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(28, 28, 28)
                                        .addComponent(streetText, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap())
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(modelFilterText, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(nameText, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(29, 29, 29)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(modelText, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(monthText, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(suburbText, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(passwordText, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(priceText, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                            .addGap(81, 81, 81))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(thirdpartyChoice)
                                            .addGap(41, 41, 41)
                                            .addComponent(sort)
                                            .addGap(100, 100, 100)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(221, 221, 221)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(110, 110, 110)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(219, 219, 219)
                                                        .addComponent(updateBut))))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(levelText, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(0, 0, Short.MAX_VALUE))))))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(policyArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(policyTable, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(policyTable1, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(commentAgeLabel)))
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(IDFindText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comprehensiveChoice)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jButton3)
                                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(cityCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(commentAgeText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(cityText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(dateFilterText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(dayText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(delBut)
                                                    .addComponent(findBut)
                                                    .addComponent(idText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel16)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel22)
                                                        .addComponent(jLabel25)))))
                                        .addGap(41, 41, 41))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGap(11, 11, 11)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(changeButton)
                                            .addComponent(cityChoice)
                                            .addComponent(jLabel7))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel11)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel12)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(usernameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(yearText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(187, 187, 187)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 609, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(policyUsernameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(policyIDText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(manufacturingText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(numberOfClaimsText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(modelFilterText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(modelText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(monthText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(passwordText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(priceText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(thirdpartyChoice)
                            .addComponent(sort))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(jLabel21)
                            .addComponent(streetNoText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(streetText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(suburbText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(updateBut))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel20)
                        .addGap(14, 14, 14))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(typeText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel18)
                                        .addGap(39, 39, 39))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel23)
                                            .addComponent(jLabel17))
                                        .addGap(21, 21, 21))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(levelLabel)
                                .addGap(86, 86, 86)
                                .addComponent(levelText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)
                                .addComponent(jLabel24)
                                .addGap(30, 30, 30))))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(policyArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(policyTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(policyTable1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    
    //public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        /*try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UserUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }*/
        //</editor-fold>

        /* Create and display the form */
    /*    java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserUI().setVisible(true);
            }
        });
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField IDFindText;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton changeButton;
    private javax.swing.JCheckBox cityChoice;
    private javax.swing.JComboBox<String> cityCombo;
    private javax.swing.JTextField cityText;
    private javax.swing.JLabel commentAgeLabel;
    private javax.swing.JTextField commentAgeText;
    private javax.swing.JRadioButton comprehensiveChoice;
    private javax.swing.JTextField dateFilterText;
    private javax.swing.JTextField dayText;
    private javax.swing.JButton delBut;
    private javax.swing.JButton findBut;
    private javax.swing.JTextField idText;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel levelLabel;
    private javax.swing.JTextField levelText;
    private javax.swing.JTextField manufacturingText;
    private javax.swing.JTextField modelFilterText;
    private javax.swing.JTextField modelText;
    private javax.swing.JTextField monthText;
    private javax.swing.JTextField nameText;
    private javax.swing.JTextField numberOfClaimsText;
    private javax.swing.JTextField passwordText;
    private javax.swing.JTextArea policyArea;
    private javax.swing.JTextField policyIDText;
    private javax.swing.JTable policyTable;
    private javax.swing.JTable policyTable1;
    private javax.swing.JPopupMenu policyTablePopUp;
    private javax.swing.JTextField policyUsernameText;
    private javax.swing.JTextField priceText;
    private javax.swing.JCheckBox sort;
    private javax.swing.JTextField streetNoText;
    private javax.swing.JTextField streetText;
    private javax.swing.JTextField suburbText;
    private javax.swing.JRadioButton thirdpartyChoice;
    private javax.swing.JComboBox<String> typeText;
    private javax.swing.JButton updateBut;
    private javax.swing.JTextField usernameText;
    private javax.swing.JTextField yearText;
    // End of variables declaration//GEN-END:variables
}
