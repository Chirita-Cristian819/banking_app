/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainFrame;

import utils.ScoreCalculator;
import utils.RequestHandler;
import java.awt.Color;
import java.text.ParseException;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Cristi
 */
public class LoanApplicationForm extends javax.swing.JFrame {

    
    private final ButtonGroup group = new ButtonGroup();
    
    private Frame frame;
    private CreditScoreForm scoreForm;
    private final ScoreCalculator creditScoreCalculator = new ScoreCalculator();
    private final RequestHandler handler = new RequestHandler();
    
    private double interestRate, collateral, loan;
    private int number, creditDuration;
    private String clientEmail, employeeEmail;
    private final String[] ClientInfo = new String[6];
    
    public LoanApplicationForm() {
        initComponents();
        group.add(Single);
        group.add(Married);
        group.add(Divorced);
        Single.setSelected(true);
        this.setResizable(false);
        this.pack();
        this.setLocationRelativeTo(null);
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
        ClientName = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        loanValue = new javax.swing.JTextField();
        collateralValue = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        spouseIncome = new javax.swing.JTextField();
        Married = new javax.swing.JRadioButton();
        Single = new javax.swing.JRadioButton();
        Divorced = new javax.swing.JRadioButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        maritalStatus = new javax.swing.JLabel();
        numberOfChildren = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        scoreButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        InterestLabel = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        interestButton = new javax.swing.JButton();
        jobField = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        exit = new javax.swing.JButton();
        loanDuration = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ClientName.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        ClientName.setText("Requesting client name: *---------------------------*");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/banking_app/LoanForm/money.png"))); // NOI18N

        loanValue.setFont(new java.awt.Font("Times New Roman", 0, 17)); // NOI18N
        loanValue.setForeground(new java.awt.Color(102, 102, 102));
        loanValue.setText("Loan Value");
        loanValue.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                loanValueFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                loanValueFocusLost(evt);
            }
        });

        collateralValue.setFont(new java.awt.Font("Times New Roman", 0, 17)); // NOI18N
        collateralValue.setForeground(new java.awt.Color(102, 102, 102));
        collateralValue.setText("Collateral Value");
        collateralValue.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                collateralValueFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                collateralValueFocusLost(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/banking_app/LoanForm/collateral.png"))); // NOI18N

        spouseIncome.setFont(new java.awt.Font("Times New Roman", 0, 17)); // NOI18N
        spouseIncome.setForeground(new java.awt.Color(102, 102, 102));
        spouseIncome.setText("Spouse Income");
        spouseIncome.setEnabled(false);
        spouseIncome.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                spouseIncomeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                spouseIncomeFocusLost(evt);
            }
        });

        Married.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        Married.setText("Married");
        Married.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                MarriedItemStateChanged(evt);
            }
        });

        Single.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        Single.setText("Single");

        Divorced.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        Divorced.setText("Divorced");

        maritalStatus.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        maritalStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/banking_app/LoanForm/wedding.png"))); // NOI18N

        numberOfChildren.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        numberOfChildren.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0 Children", "1 Child", "2 Children", "3 Children", "3+ Children" }));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/banking_app/LoanForm/children.png"))); // NOI18N
        jLabel5.setOpaque(true);

        scoreButton.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        scoreButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/banking_app/LoanForm/score.png"))); // NOI18N
        scoreButton.setText("Calculate Credit Score");
        scoreButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scoreButtonActionPerformed(evt);
            }
        });

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        InterestLabel.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        InterestLabel.setForeground(new java.awt.Color(0, 51, 51));
        InterestLabel.setText("Interest Rate  =  ");

        interestButton.setFont(new java.awt.Font("Times New Roman", 0, 17)); // NOI18N
        interestButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/banking_app/LoanForm/calculate.png"))); // NOI18N
        interestButton.setText("Calculate Interest Rate");
        interestButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                interestButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator3)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(interestButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addComponent(InterestLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(InterestLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(interestButton, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jobField.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jobField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Accountancy", "Agriculture", "Administration", "Army", "Banking", "Client Support", "Cosmetics", "e-Commerce", "Education", "Entertainment", "Food Service", "Free Agent", "Law", "Law Enforcement", "Logistics", "Medical", "Retail", "Sports", "Tourism", "Transport services", "Others" }));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/banking_app/LoanForm/job.png"))); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/banking_app/LoanForm/euro2.png"))); // NOI18N

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/banking_app/LoanForm/euro2.png"))); // NOI18N

        exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/banking_app/exit.png"))); // NOI18N
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });

        loanDuration.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        loanDuration.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "3 Months (1/4 years)", "6 Months (1/2 years)", "12 Months  (1 year)", "18 Months (1.5 years)", "24 Months (2 years)", "36 Months (3 years)", "48 Months (4 years)", "60 Months (5 years)", "72 Months (6 years)", "84 Months (7 years)", "96 Months (8 years)", "108 Months (9 years)", "120 Months (10 years)" }));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/banking_app/LoanForm/duration1.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(98, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(ClientName, javax.swing.GroupLayout.PREFERRED_SIZE, 575, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(143, 143, 143))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(maritalStatus)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(57, 57, 57)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(Single)
                                                .addGap(29, 29, 29)
                                                .addComponent(Married)
                                                .addGap(18, 18, 18)
                                                .addComponent(Divorced))
                                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
                                            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(75, 75, 75)
                                        .addComponent(loanDuration, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(74, 74, 74)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(numberOfChildren, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jobField, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(spouseIncome, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(scoreButton)
                                .addGap(96, 96, 96))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(74, 74, 74)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(46, 46, 46))))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(57, 57, 57)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(collateralValue, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
                    .addComponent(loanValue, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(ClientName)
                .addGap(65, 65, 65)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(loanValue, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3))
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(collateralValue, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(loanDuration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(maritalStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Married)
                                    .addComponent(Single)
                                    .addComponent(Divorced))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(spouseIncome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(scoreButton, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(numberOfChildren, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(54, 54, 54)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jobField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(81, 81, 81))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loanValueFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_loanValueFocusGained
        removePlaceholder(loanValue, "Loan Value");
    }//GEN-LAST:event_loanValueFocusGained

    private void loanValueFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_loanValueFocusLost
        redrawPlaceholder(loanValue,"Loan Value");
    }//GEN-LAST:event_loanValueFocusLost

    private void collateralValueFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_collateralValueFocusGained
        removePlaceholder(collateralValue, "Collateral Value");
    }//GEN-LAST:event_collateralValueFocusGained

    private void collateralValueFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_collateralValueFocusLost
        redrawPlaceholder(collateralValue, "Collateral Value");
    }//GEN-LAST:event_collateralValueFocusLost

    private void spouseIncomeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_spouseIncomeFocusGained
        removePlaceholder(spouseIncome, "Spouse Income");
    }//GEN-LAST:event_spouseIncomeFocusGained

    private void spouseIncomeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_spouseIncomeFocusLost
        redrawPlaceholder(spouseIncome, "Spouse Income");
    }//GEN-LAST:event_spouseIncomeFocusLost

    private void MarriedItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_MarriedItemStateChanged
        if (Married.isSelected()) {
            spouseIncome.setEnabled(true);
        } else {
            spouseIncome.setEnabled(false);
        }
    }//GEN-LAST:event_MarriedItemStateChanged

    private void interestButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_interestButtonActionPerformed
        calculateRate();
        InterestLabel.setText("Interest Rate  =  " + interestRate + "%");
        
    }//GEN-LAST:event_interestButtonActionPerformed

    private void scoreButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scoreButtonActionPerformed
        JSONObject record = null;
        
        double DTI = 1;

        try {
            DTI = creditScoreCalculator.calculateDTI(clientEmail);
        } catch (JSONException ex) {
        }

        if (DTI > 0.44) {
            if (frame.getNivelAngajat() != 3) {
                errorWindow("<html>The customer's debt-to-income exceeds 44%, "
                        + "<p style=\"text-align:center\"> you cannot grant a loan!</p></html>");
            } else {
                checkAndAdd(record, DTI);

            }
        } else {
            checkAndAdd(record, DTI);
        }
    }//GEN-LAST:event_scoreButtonActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
             reinitialize();
    }//GEN-LAST:event_exitActionPerformed
    
    private void removePlaceholder(JTextField field, String text) {
        if (field.getText().equals(text)) {
            field.setText("");
            field.setForeground(Color.BLACK);
        }
    }

    private void redrawPlaceholder(JTextField field, String text) {
        if (field.getText().isEmpty() || !this.isVisible()) {
            field.setText(text);
            field.setForeground(new Color(102, 102, 102));
        }

    }
    
    private void calculateRate(){
        interestRate = 9;
        collateral = Double.parseDouble(collateralValue.getText());
        loan = Double.parseDouble(loanValue.getText());
        double proportion = collateral/loan;

        if (proportion > 0.1 && proportion <= 0.2){
            interestRate -= 0.5;
        } else if (proportion > 0.2 && proportion <= 0.4){
            interestRate -= 1.2;
        } else if (proportion > 0.4 && proportion <= 0.6){
            interestRate -= 2;
        } else if (proportion > 0.6){
            interestRate-= 2.5;
        }

    }
    
     private boolean checkNumberFieldsFormat(){
         if (!loanValue.getText().equals("Loan Value")) {
             try {
                 Float.parseFloat(loanValue.getText());
             } catch (NumberFormatException e) {
                 errorWindow("<html>The loan value needs to be <p style=\"text-align:center\"> be a number! </p></html>");
                 return false;
             }
         }

         if (!collateralValue.getText().equals("Collateral Value")) {
             try {
                 Float.parseFloat(collateralValue.getText());
             } catch (NumberFormatException e) {
                 errorWindow("<html>The collateral value needs to be <p style=\"text-align:center\"> a number! </p></html>");
                 return false;
             }
         }

         if (spouseIncome.isEnabled()) {
             try {
                 Float.parseFloat(spouseIncome.getText());
             } catch (NumberFormatException e) {
                 errorWindow("The income value needs to be a number!");
                 return false;
             }
         }
         return true;
    
    }
     
    private void checkAndAdd(JSONObject record, double DTI) {
        if (!(loanValue.getText().equals("Loan Value") || collateralValue.getText().equals("Collateral Value"))) {
            if (checkNumberFieldsFormat()) {
                collateral = Double.parseDouble(collateralValue.getText());
                loan = Double.parseDouble(loanValue.getText());
                number = numberOfChildren.getSelectedIndex();

                try {
                    String responseText = handler.RetrieveCredentials(clientEmail, "clienti");
                    record = new JSONObject(responseText);

                    if (record.has("age")) {
                        ClientInfo[0] = String.valueOf(record.getInt("age"));
                    } else {
                        ClientInfo[0] = "0";
                    }

                    if (Married.isSelected()) {
                        ClientInfo[1] = "true";
                        ClientInfo[2] = spouseIncome.getText();
                    } else {
                        ClientInfo[1] = "false";
                        ClientInfo[2] = "0";
                    }

                    if (number <= 3) {
                        ClientInfo[3] = String.valueOf(number);
                    } else {
                        ClientInfo[3] = "4";
                    }

                    ClientInfo[4] = String.valueOf(record.getInt("vechimeClient"));
                    ClientInfo[5] = String.valueOf(jobField.getSelectedItem());
                    
                    double score = creditScoreCalculator.Score(clientEmail, collateral, loan, ClientInfo);

                    this.setEnabled(false);
                    
                    scoreForm.setScore(String.format("%.2f", score));
                    scoreForm.setNivelAngajat(frame.getNivelAngajat());
                    scoreForm.setVisible(true);

                } catch (JSONException | ParseException ex) {
                }

            }
        } else {
            errorWindow("One of the fields is empty");
        }

    }
     
    protected void reinitialize(){
        this.setVisible(false);
        this.setLocationRelativeTo(null);
        frame.setFocusableWindowState(true); 
        
        this.setEmail("", "");
        interestRate = 0; 
        collateral = 0; 
        loan = 0;
        number = 0;
        for(int i = 0; i < ClientInfo.length; i++){
            ClientInfo[i] = "";
        }
        
        redrawPlaceholder(loanValue,"Loan Value");
        redrawPlaceholder(collateralValue,"Collateral Value");
        redrawPlaceholder(spouseIncome, "Spouse Income");
        Single.setSelected(true);
        numberOfChildren.setSelectedIndex(0);
        jobField.setSelectedIndex(0);
        
        spouseIncome.setEnabled(false);
        
    }
     
    private void errorWindow(String message){
        JLabel label = new JLabel(message);
        label.setFont(new java.awt.Font("Times New Roman", java.awt.Font.PLAIN, 17));
        JOptionPane.showMessageDialog(null, label, "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    private void warningWindow(String message){
        JLabel label = new JLabel(message);
        label.setFont(new java.awt.Font("Times New Roman", java.awt.Font.PLAIN, 17));
        JOptionPane.showMessageDialog(null, label, "Warning", JOptionPane.WARNING_MESSAGE);
    }
    
    public void setEmail(String em, String eml){
        clientEmail = em;
        employeeEmail = eml;
    }
    
    public String getClientEmail(){
        return clientEmail;
    }
    
    public String getEmployeeEmail(){
        return employeeEmail;
    }
    
    public void setClientName(String name){
        ClientName.setText(name);
    }
    
    public int getLoanDuration(){
        
        String selection = String.valueOf(loanDuration.getSelectedItem());
        String selectionNumber = selection.split("\\s+")[0];
        
        return Integer.parseInt(selectionNumber);
    }
    
    public double getLoanValue(){
        double value = Double.parseDouble(loanValue.getText());
        calculateRate();
        
        return value + interestRate/100 * value;
    }
    
     
    public void setFrame(Frame f, CreditScoreForm score){
        this.frame = f;
        this.scoreForm = score;
    }
    
    
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoanApplicationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoanApplicationForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ClientName;
    private javax.swing.JRadioButton Divorced;
    private javax.swing.JLabel InterestLabel;
    private javax.swing.JRadioButton Married;
    private javax.swing.JRadioButton Single;
    private javax.swing.JTextField collateralValue;
    private javax.swing.JButton exit;
    private javax.swing.JButton interestButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JComboBox<String> jobField;
    private javax.swing.JComboBox<String> loanDuration;
    private javax.swing.JTextField loanValue;
    private javax.swing.JLabel maritalStatus;
    private javax.swing.JComboBox<String> numberOfChildren;
    private javax.swing.JButton scoreButton;
    private javax.swing.JTextField spouseIncome;
    // End of variables declaration//GEN-END:variables
}