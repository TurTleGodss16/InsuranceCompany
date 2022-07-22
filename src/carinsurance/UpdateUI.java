/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package carinsurance;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class UpdateUI extends javax.swing.JFrame {

    InsurancePolicies policy;
    UserUI userUI;
    
    public UpdateUI(InsurancePolicies policy, UserUI UI) {
        this.policy = policy;
        this.userUI = UI;
        
        initComponentsNew();
        
        this.policyIDText.setText(policy.getID() + "");
        this.policyUsernameText.setText(policy.getPolicyHolderName());
        this.modelText.setText(policy.getCar().getModel());
        this.manufacturingYearText.setText(policy.getCar().getYear() + "");
        this.priceText.setText(policy.getCar().getPrice() + "");
        this.numberOfClaimsText.setText(policy.getNumberOfClaims() + "");
        this.typeText.setSelectedItem(policy.getCar().getType().toString());
        this.dayText.setText(policy.getExpiryDate().getDay() + "");
        this.monthText.setText(policy.getExpiryDate().getMonth() + "");
        this.yearText.setText(policy.getExpiryDate().getYear() + "");
        
        if(policy instanceof ThirdPartyPolicy)
        {
            this.thirdpartyChoice.setSelected(true);
            this.comprehensiveChoice.setSelected(false);
            this.commentAgeLabel.setText("Comment");
            this.commentAgeText.setText(((ThirdPartyPolicy)policy).comments);
            this.levelText.setText("");
            this.levelLabel.setVisible(false);
            this.levelText.setVisible(false);
        }
        else
        {
            this.thirdpartyChoice.setSelected(false);
            this.comprehensiveChoice.setSelected(true);
            this.commentAgeLabel.setText("Age");
            this.commentAgeText.setText(((ComprehensivePolicy)policy).driverAge + "");
            this.levelText.setText(((ComprehensivePolicy)policy).level + "");
            this.levelLabel.setVisible(true);
            this.levelText.setVisible(true);
        }
    }
    
    private void initComponentsNew(){
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
    this.manufacturingYearText = new JTextField(); //memoryText
    this.priceText = new JTextField();
    this.numberOfClaimsText = new JTextField(); //internetText
    this.modelText = new JTextField();
    this.typeText = new JComboBox<>();
    this.monthText = new JTextField();
    this.yearText = new JTextField();
    this.levelText = new JTextField();
    this.dayText = new JTextField();
    this.thirdpartyChoice = new JRadioButton();
    this.comprehensiveChoice = new JRadioButton();
    this.jButton1 = new JButton();
    this.jButton2 = new JButton();
    setDefaultCloseOperation(3);
    
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
    this.commentAgeLabel.setHorizontalAlignment(4);
    this.commentAgeLabel.setText("Comment");
    this.levelLabel.setFont(new Font("TimesRoman", Font.ITALIC, 18));
    this.levelLabel.setText("Level");
    this.policyUsernameText.setFont(new Font("TimesRoman", Font.ITALIC, 18));
    this.policyIDText.setFont(new Font("TimesRoman", Font.ITALIC, 18));
    this.policyIDText.setEnabled(false);
    this.commentAgeText.setFont(new Font("TimesRoman", Font.ITALIC, 18));
    this.commentAgeText.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            UpdateUI.this.commentAgeTextActionPerformed(evt);
          }
        });
    
    this.manufacturingYearText.setFont(new Font("TimesRoman", Font.ITALIC, 18));
    this.priceText.setFont(new Font("TimesRoman", Font.ITALIC, 18));
    this.numberOfClaimsText.setFont(new Font("TimesRoman", Font.ITALIC, 18));
    this.modelText.setFont(new Font("TimesRoman", Font.ITALIC, 18));
    this.typeText.setFont(new Font("TimesRoman", Font.ITALIC, 18));
    this.typeText.setModel(new DefaultComboBoxModel<>(new String[] { "SUV", "SED", "LUX", "HATCH" }));
    this.monthText.setFont(new Font("TimesRoman", Font.ITALIC, 18));
    this.yearText.setFont(new Font("TimesRoman", Font.ITALIC, 18));
    this.levelText.setFont(new Font("TimesRoman", Font.ITALIC, 18));
    this.dayText.setFont(new Font("TimesRoman", Font.ITALIC, 18));
    this.thirdpartyChoice.setFont(new Font("TimesRoman", Font.ITALIC, 18));
    this.thirdpartyChoice.setSelected(true);
    this.thirdpartyChoice.setText("Third Party Policy");
    this.thirdpartyChoice.setEnabled(false);
    this.thirdpartyChoice.addChangeListener(new ChangeListener() {
          public void stateChanged(ChangeEvent evt) {
            UpdateUI.this.thirdpartyChoiceStateChanged(evt);
          }
        });
    
    this.comprehensiveChoice.setFont(new Font("TimesRoman", Font.ITALIC, 18));
    this.comprehensiveChoice.setText("Comprehensive Policy");
    this.comprehensiveChoice.setEnabled(false);
    this.jButton1.setFont(new Font("TimesRoman", Font.ITALIC, 18));
    this.jButton1.setForeground(new Color(255, 51, 51));
    this.jButton1.setText("UPDATE");
    this.jButton1.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            UpdateUI.this.jButton1ActionPerformed(evt);
          }
        });
    
    this.jButton2.setFont(new Font("TimesRoman", Font.ITALIC, 18));
    this.jButton2.setForeground(new Color(255, 51, 51));
    this.jButton2.setText("CLEAR");
    this.jButton2.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            UpdateUI.this.jButton2ActionPerformed(evt);
          }
        });
    
    GroupLayout layout = new GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(layout
        .createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
          .addGap(61, 61, 61)
          .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
              .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                  .addComponent(this.jLabel19)
                  .addComponent(this.jLabel16)
                  .addComponent(this.jLabel20))
                .addGroup(layout.createSequentialGroup()
                  .addGap(48, 48, 48)
                  .addComponent(this.thirdpartyChoice)
                  .addGap(18, 18, 18)
                  .addComponent(this.comprehensiveChoice)))
              .addGap(265, 265, 265))
            .addGroup(layout.createSequentialGroup()
              .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                .addComponent(this.jLabel11)
                .addComponent(this.jLabel13)
                .addComponent(this.jLabel10))
              .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                  .addGap(310, 310, 310)
                  .addComponent(this.jButton2, -1, -1, 32767))
                .addGroup(layout.createSequentialGroup()
                  .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
                  .addComponent(this.jButton1, -2, 118, -2)))
              .addGap(98, 98, 98))))
        .addGroup(layout.createSequentialGroup()
          .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
              .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                .addComponent(this.jLabel15)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                  .addGroup(layout.createSequentialGroup()
                    .addGap(144, 144, 144)
                    .addComponent(this.jLabel14))
                  .addGroup(layout.createSequentialGroup()
                    .addGap(35, 35, 35)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                      .addComponent(this.jLabel22)
                      .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(this.levelLabel)
                        .addGroup(layout.createSequentialGroup()
                          .addGap(109, 109, 109)
                          .addComponent(this.jLabel18))
                        .addComponent(this.commentAgeLabel, GroupLayout.Alignment.TRAILING, -2, 44, -2)))))
                .addComponent(this.jLabel12)
                .addComponent(this.jLabel17))
              .addGap(21, 21, 21))
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
              .addComponent(this.jLabel21)
              .addGap(20, 20, 20)))
          .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
            .addComponent(this.manufacturingYearText, GroupLayout.Alignment.TRAILING, -1, 164, 32767)
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
            .addComponent(this.modelText, GroupLayout.Alignment.TRAILING))
          .addGap(98, 314, 32767)));
    layout.setVerticalGroup(layout
        .createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
          .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            .addComponent(this.comprehensiveChoice)
            .addComponent(this.thirdpartyChoice))
          .addGap(21, 21, 21)
          .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
              .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(this.jLabel11)
                .addComponent(this.policyIDText, -2, -1, -2)
                .addComponent(this.jButton2))
              .addGap(9, 9, 9)
              .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(this.policyUsernameText, -2, -1, -2)
                .addComponent(this.jLabel10))
              .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
              .addComponent(this.jLabel13))
            .addComponent(this.jButton1))
          .addGap(4, 4, 4)
          .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            .addComponent(this.modelText, -2, -1, -2)
            .addComponent(this.jLabel14))
          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
          .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            .addComponent(this.jLabel15, -2, 28, -2)
            .addComponent(this.typeText, -2, 28, -2))
          .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
          .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(this.jLabel12)
            .addComponent(this.manufacturingYearText, -2, -1, -2))
          .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
          .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            .addComponent(this.jLabel17)
            .addComponent(this.priceText, -2, -1, -2))
          .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
          .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            .addComponent(this.jLabel16)
            .addComponent(this.numberOfClaimsText, -2, -1, -2))
          .addGap(18, 18, 18)
          .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            //.addComponent(this.capText, -2, -1, -2)
            .addComponent(this.jLabel19))
          .addGap(18, 18, 18)
          .addComponent(this.jLabel20)
          .addGap(13, 13, 13)
          .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            .addComponent(this.jLabel21)
            .addComponent(this.dayText, -2, -1, -2))
          .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
          .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            .addComponent(this.jLabel18)
            .addComponent(this.monthText, -2, -1, -2))
          .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
          .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            .addComponent(this.jLabel22)
            .addComponent(this.yearText, -2, -1, -2))
          .addGap(18, 18, 18)
          .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            .addComponent(this.commentAgeText, -2, -1, -2)
            .addComponent(this.commentAgeLabel))
          .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
          .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            .addComponent(this.levelLabel, -2, 33, -2)
            .addComponent(this.levelText, -2, -1, -2))
          .addContainerGap(172, 32767)));
    pack();
    }
    
    //commentAgeText action perform
    private void commentAgeTextActionPerformed(ActionEvent evt){
        
    }
    
    //thirdpartyChoice change state
    private void thirdpartyChoiceStateChanged(ChangeEvent evt){
        if(this.thirdpartyChoice.isSelected())
        {
            this.levelLabel.setVisible(false);
            this.levelText.setVisible(false);
            this.commentAgeLabel.setText("Comment");
        }
        else
        {
            this.levelLabel.setVisible(true);
            this.levelText.setVisible(true);
            this.commentAgeLabel.setText("Age");
        }
    }
    
    //jButton1
    private void jButton1ActionPerformed(ActionEvent evt){
        try
        {
            String username = this.policyUsernameText.getText();
            String model = this.modelText.getText();
            CarType type = CarType.valueOf(this.typeText.getSelectedItem().toString());
            int manufacturingYear = Integer.parseInt(this.manufacturingYearText.getText());
            double price = Double.parseDouble(this.priceText.getText());
            int numberOfClaims = Integer.parseInt(this.numberOfClaimsText.getText());
            int day = Integer.parseInt(this.dayText.getText());
            int month = Integer.parseInt(this.monthText.getText());
            int year = Integer.parseInt(this.yearText.getText());
            MyDate date = new MyDate(year, month, day);
            Car car = new Car(model, type, manufacturingYear, price);

            this.policy.policyHolderName = username;
            this.policy.expiryDate = date;
            this.policy.car = car;
            this.policy.numberOfClaims = numberOfClaims;

            if(this.thirdpartyChoice.isSelected())
            {
                String comment = this.commentAgeText.getText();
                ((ThirdPartyPolicy)this.policy).comments = comment;
            }
            else
            {
                int age = Integer.parseInt(this.commentAgeText.getText());
                int level = Integer.parseInt(this.levelText.getText());
                ((ComprehensivePolicy)this.policy).driverAge = age;
                ((ComprehensivePolicy)this.policy).level = level;
            }
            JOptionPane.showMessageDialog(this, "Policy has been updated");
            this.userUI.fillTable();
            dispose();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, e);
        }
    }
    
    //jButton2
    private void jButton2ActionPerformed(ActionEvent evt){
        this.policyIDText.setText("");
        this.policyUsernameText.setText("");
        this.modelText.setText("");
        this.manufacturingYearText.setText("");
        this.priceText.setText("");
        this.numberOfClaimsText.setText("");
        this.dayText.setText("");
        this.monthText.setText("");
        this.yearText.setText("");
        this.commentAgeText.setText("");
        this.levelText.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        commentAgeLabel = new javax.swing.JLabel();
        commentAgeText = new javax.swing.JTextField();
        dayText = new javax.swing.JTextField();
        numberOfClaimsText = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
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
        manufacturingYearText = new javax.swing.JTextField();
        modelText = new javax.swing.JTextField();
        monthText = new javax.swing.JTextField();
        levelLabel = new javax.swing.JLabel();
        levelText = new javax.swing.JTextField();
        policyIDText = new javax.swing.JTextField();
        policyUsernameText = new javax.swing.JTextField();
        priceText = new javax.swing.JTextField();
        typeText = new javax.swing.JComboBox<>();
        yearText = new javax.swing.JTextField();
        thirdpartyChoice = new javax.swing.JRadioButton();
        comprehensiveChoice = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        commentAgeLabel.setText("jLabel1");

        commentAgeText.setText("jTextField1");

        dayText.setText("jTextField1");

        numberOfClaimsText.setText("jTextField1");

        jButton1.setText("jButton1");

        jButton2.setText("jButton2");

        jLabel10.setText("jLabel1");

        jLabel11.setText("jLabel1");

        jLabel12.setText("jLabel1");

        jLabel13.setText("jLabel1");

        jLabel14.setText("jLabel1");

        jLabel15.setText("jLabel1");

        jLabel16.setText("jLabel1");

        jLabel17.setText("jLabel1");

        jLabel18.setText("jLabel1");

        jLabel19.setText("jLabel1");

        jLabel20.setText("jLabel1");

        jLabel21.setText("jLabel1");

        jLabel22.setText("jLabel1");

        manufacturingYearText.setText("jTextField1");

        modelText.setText("jTextField1");

        monthText.setText("jTextField1");

        levelLabel.setText("jLabel1");

        levelText.setText("jTextField1");

        policyIDText.setText("jTextField1");

        policyUsernameText.setText("jTextField1");

        priceText.setText("jTextField1");

        typeText.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        yearText.setText("jTextField1");

        thirdpartyChoice.setText("jRadioButton1");

        comprehensiveChoice.setText("jRadioButton1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addComponent(commentAgeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(81, 81, 81)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(commentAgeText, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(dayText, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(numberOfClaimsText, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(53, 53, 53)
                                        .addComponent(jButton1))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGap(24, 24, 24)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(manufacturingYearText, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(modelText, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(0, 0, Short.MAX_VALUE)
                                                        .addComponent(thirdpartyChoice))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(policyIDText, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(policyUsernameText, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(14, 14, 14)))))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(26, 26, 26)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jButton2)
                                            .addComponent(monthText, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(priceText, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(46, 46, 46)
                                        .addComponent(comprehensiveChoice)))))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(typeText, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(56, 56, 56)
                                .addComponent(yearText, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(levelLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(levelText, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(commentAgeLabel)
                    .addComponent(commentAgeText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dayText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(numberOfClaimsText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2))))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21)
                    .addComponent(jLabel22))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(manufacturingYearText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(modelText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(monthText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(levelLabel)
                    .addComponent(levelText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(policyIDText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(policyUsernameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(priceText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(typeText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(yearText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(68, 68, 68)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(thirdpartyChoice)
                    .addComponent(comprehensiveChoice))
                .addContainerGap(155, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    /*public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UpdateUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateUI().setVisible(true);
            }
        });
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel commentAgeLabel;
    private javax.swing.JTextField commentAgeText;
    private javax.swing.JRadioButton comprehensiveChoice;
    private javax.swing.JTextField dayText;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
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
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel levelLabel;
    private javax.swing.JTextField levelText;
    private javax.swing.JTextField manufacturingYearText;
    private javax.swing.JTextField modelText;
    private javax.swing.JTextField monthText;
    private javax.swing.JTextField numberOfClaimsText;
    private javax.swing.JTextField policyIDText;
    private javax.swing.JTextField policyUsernameText;
    private javax.swing.JTextField priceText;
    private javax.swing.JRadioButton thirdpartyChoice;
    private javax.swing.JComboBox<String> typeText;
    private javax.swing.JTextField yearText;
    // End of variables declaration//GEN-END:variables
}
