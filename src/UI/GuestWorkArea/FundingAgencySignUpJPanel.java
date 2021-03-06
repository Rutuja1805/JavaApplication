/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.GuestWorkArea;

import Healthplus.FundRaiser.FundRaiser;
import Healthplus.DB4OUtil.DB4OUtil;
import Healthplus.E_System;
import Healthplus.Enterprises.Enterprise;
import Healthplus.Network.City;
import Healthplus.Network.Country;
import Healthplus.Network.State;
import Healthplus.Org.ManagerOrg;
import Healthplus.Org.Org;
import Healthplus.WorkQueue.AgencyWorkRequest;
import java.awt.CardLayout;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class FundingAgencySignUpJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private E_System system;
    private Enterprise enterprise;
    private DB4OUtil dB4OUtil;

    /**
     * Creates new form FundingAgencySignUPJPanel
     */
    public FundingAgencySignUpJPanel(JPanel userProcessContainer, E_System system, DB4OUtil dB4OUtil) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.system = system;
        this.dB4OUtil = dB4OUtil;
        populateCountry();
        populateState();
        populateCity();
        populateEnterpriseType();
    }

    private void populateCountry() {
        combo_country.removeAllItems();
        for (Country c : system.getNetworkList()) {
            combo_country.addItem(c);
        }
    }

    private void populateState() {
        combo_state.removeAllItems();
        if (combo_country.getSelectedItem() != null) {
            for (Country c : system.getNetworkList()) {
                if (c.equals(combo_country.getSelectedItem())) {
                    for (State s : c.getStateList()) {
                        combo_state.addItem(s);
                    }
                }
            }
        }
    }

    private void populateCity() {
        combo_city.removeAllItems();
        if (combo_state.getSelectedItem() != null) {
            for (Country c : system.getNetworkList()) {
                for (State s : c.getStateList()) {
                    if (s.equals(combo_state.getSelectedItem())) {
                        for (City city : s.getCityList()) {
                            combo_city.addItem(city);
                        }
                    }
                }
            }
        }
    }

    public void populateEnterpriseType() {
        combo_trust.removeAllItems();
        if (combo_city.getSelectedItem() != null) {
            for (Country c : system.getNetworkList()) {
                for (State s : c.getStateList()) {
                    for (City city : s.getCityList()) {
                        if (city.equals(combo_city.getSelectedItem())) {
                            for (Enterprise e : city.getEnterpriseDirectory().getEnterpriseList()) {
                                if(e.getEnterpriseType().getValue().equals("Trust")){
                                    combo_trust.addItem(e);
                                }
                            }
                        }
                    }
                }
            }
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

        lblHeader = new javax.swing.JLabel();
        label_budget = new javax.swing.JLabel();
        label_fundraisername = new javax.swing.JLabel();
        label_country = new javax.swing.JLabel();
        label_state = new javax.swing.JLabel();
        btn_Submit = new javax.swing.JButton();
        label_city = new javax.swing.JLabel();
        text_fundraisername = new javax.swing.JTextField();
        text_fundraisersBudget = new javax.swing.JTextField();
        combo_country = new javax.swing.JComboBox<>();
        combo_state = new javax.swing.JComboBox<>();
        combo_city = new javax.swing.JComboBox<>();
        label_trustname = new javax.swing.JLabel();
        combo_trust = new javax.swing.JComboBox();
        btn_Back = new javax.swing.JButton();
        lblWarning = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 222, 212));
        setMaximumSize(new java.awt.Dimension(700, 700));
        setMinimumSize(new java.awt.Dimension(700, 700));
        setPreferredSize(new java.awt.Dimension(700, 700));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblHeader.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        lblHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHeader.setText("Sign Up As Funding Agency");
        add(lblHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, 250, 24));

        label_budget.setFont(new java.awt.Font("Comic Sans MS", 0, 13)); // NOI18N
        label_budget.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        label_budget.setText("Budget:");
        add(label_budget, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 330, 96, 20));

        label_fundraisername.setFont(new java.awt.Font("Comic Sans MS", 0, 13)); // NOI18N
        label_fundraisername.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        label_fundraisername.setText("Agency Name:");
        add(label_fundraisername, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 290, 96, 20));

        label_country.setFont(new java.awt.Font("Comic Sans MS", 0, 13)); // NOI18N
        label_country.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        label_country.setText("Country:");
        add(label_country, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 130, 96, 27));

        label_state.setFont(new java.awt.Font("Comic Sans MS", 0, 13)); // NOI18N
        label_state.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        label_state.setText("State:");
        add(label_state, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 170, 96, 27));

        btn_Submit.setBackground(new java.awt.Color(255, 255, 255));
        btn_Submit.setFont(new java.awt.Font("Comic Sans MS", 0, 13)); // NOI18N
        btn_Submit.setText("Submit");
        btn_Submit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btn_Submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SubmitActionPerformed(evt);
            }
        });
        add(btn_Submit, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 380, 70, 30));

        label_city.setFont(new java.awt.Font("Comic Sans MS", 0, 13)); // NOI18N
        label_city.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        label_city.setText("City:");
        add(label_city, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 210, 96, 27));

        text_fundraisername.setFont(new java.awt.Font("Comic Sans MS", 0, 13)); // NOI18N
        text_fundraisername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_fundraisernameActionPerformed(evt);
            }
        });
        add(text_fundraisername, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 290, 150, -1));

        text_fundraisersBudget.setFont(new java.awt.Font("Comic Sans MS", 0, 13)); // NOI18N
        add(text_fundraisersBudget, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 330, 150, -1));

        combo_country.setFont(new java.awt.Font("Comic Sans MS", 0, 13)); // NOI18N
        combo_country.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_countryActionPerformed(evt);
            }
        });
        add(combo_country, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 130, 150, -1));

        combo_state.setFont(new java.awt.Font("Comic Sans MS", 0, 13)); // NOI18N
        combo_state.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_stateActionPerformed(evt);
            }
        });
        add(combo_state, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 170, 150, -1));

        combo_city.setFont(new java.awt.Font("Comic Sans MS", 0, 13)); // NOI18N
        combo_city.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_cityActionPerformed(evt);
            }
        });
        add(combo_city, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 210, 150, -1));

        label_trustname.setFont(new java.awt.Font("Comic Sans MS", 0, 13)); // NOI18N
        label_trustname.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        label_trustname.setText("Trust Name:");
        add(label_trustname, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 250, 80, 20));

        combo_trust.setFont(new java.awt.Font("Comic Sans MS", 0, 13)); // NOI18N
        add(combo_trust, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 250, 150, -1));

        btn_Back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/backicon.jpeg"))); // NOI18N
        btn_Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_BackActionPerformed(evt);
            }
        });
        add(btn_Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 510, 110, 80));

        lblWarning.setFont(new java.awt.Font("Comic Sans MS", 0, 13)); // NOI18N
        lblWarning.setForeground(new java.awt.Color(255, 0, 51));
        lblWarning.setText("* Budget currency is considered to be in US Dollar");
        add(lblWarning, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 650, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/hi.gif"))); // NOI18N
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 60, 370, 400));
    }// </editor-fold>//GEN-END:initComponents

    private void btn_SubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SubmitActionPerformed
        // TODO add your handling code here:

        enterprise = (Enterprise) combo_trust.getSelectedItem();
        AgencyWorkRequest request = new AgencyWorkRequest();
        String agencyName = text_fundraisername.getText();
        String budgetStr = text_fundraisersBudget.getText();

        if (agencyName.equals("") || budgetStr.equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter values for both agency name and budget", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        // validate username
        String regex = "^[a-z A-Z]+$";
        Pattern namePattern = Pattern.compile(regex);
        Matcher nameMatcher = namePattern.matcher(agencyName);

        regex = "^[0-9]+$";
        Pattern intPattern = Pattern.compile(regex);
        Matcher intMatcher = intPattern.matcher(budgetStr);

        if (!intMatcher.matches()) {
            JOptionPane.showMessageDialog(null, "Invalid characters in budget, enter only numbers", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (!nameMatcher.matches()) {
            JOptionPane.showMessageDialog(null, "Invalid characters in agency name", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int budget = Integer.parseInt(budgetStr);

        FundRaiser agency = new FundRaiser();
        agency.setName(agencyName);
        agency.setAmount(budget);
        agency.setCountry(combo_country.getSelectedItem().toString());
        agency.setState(combo_state.getSelectedItem().toString());
        agency.setCity(combo_city.getSelectedItem().toString());
        agency.setStatus(true);

        request.setAgency(agency);

        for (Org organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
            if (organization instanceof ManagerOrg) {
                organization.getWorkQueue().getWorkRequestList().add(request);
            }
            
        }

        JOptionPane.showMessageDialog(null, "Sign up request successfully submitted", "Information", JOptionPane.INFORMATION_MESSAGE);
        text_fundraisername.setText("");
        text_fundraisersBudget.setText("");
    }//GEN-LAST:event_btn_SubmitActionPerformed

    private void btn_BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_BackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btn_BackActionPerformed

    private void combo_stateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_stateActionPerformed
        // TODO add your handling code here:
        populateCity();
    }//GEN-LAST:event_combo_stateActionPerformed

    private void combo_countryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_countryActionPerformed
        // TODO add your handling code here:
        populateState();
    }//GEN-LAST:event_combo_countryActionPerformed

    private void combo_cityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_cityActionPerformed
        // TODO add your handling code here:
        populateEnterpriseType();
    }//GEN-LAST:event_combo_cityActionPerformed

    private void text_fundraisernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_fundraisernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_fundraisernameActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Back;
    private javax.swing.JButton btn_Submit;
    private javax.swing.JComboBox<Object> combo_city;
    private javax.swing.JComboBox<Object> combo_country;
    private javax.swing.JComboBox<Object> combo_state;
    private javax.swing.JComboBox combo_trust;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel label_budget;
    private javax.swing.JLabel label_city;
    private javax.swing.JLabel label_country;
    private javax.swing.JLabel label_fundraisername;
    private javax.swing.JLabel label_state;
    private javax.swing.JLabel label_trustname;
    private javax.swing.JLabel lblHeader;
    private javax.swing.JLabel lblWarning;
    private javax.swing.JTextField text_fundraisername;
    private javax.swing.JTextField text_fundraisersBudget;
    // End of variables declaration//GEN-END:variables
}
