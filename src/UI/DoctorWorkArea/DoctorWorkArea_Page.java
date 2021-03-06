/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.DoctorWorkArea;

import Healthplus.E_System;
import Healthplus.Enterprises.Enterprise;
import Healthplus.Org.Org;
import Healthplus.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JPanel;


public class DoctorWorkArea_Page extends javax.swing.JPanel {

    /**
     * Creates new form VolunteerWorkAreaJPanel
     */
    private JPanel userProcessContainer;
    private E_System system;
    private UserAccount userAccount;
    private Org organization;
    private Enterprise enterprise;

    public DoctorWorkArea_Page(JPanel userProcessContainer, E_System system, UserAccount userAccount, Org organization, Enterprise enterprise) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.system = system;
        this.userAccount = userAccount;
        this.organization = organization;
        this.enterprise = enterprise;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_manageSeniorPatients = new javax.swing.JButton();
        lblHeader = new javax.swing.JLabel();
        btn_viewSeniorPatients = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 218, 191));
        setMaximumSize(new java.awt.Dimension(700, 700));
        setMinimumSize(new java.awt.Dimension(700, 700));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_manageSeniorPatients.setBackground(new java.awt.Color(255, 255, 255));
        btn_manageSeniorPatients.setFont(new java.awt.Font("Comic Sans MS", 0, 13)); // NOI18N
        btn_manageSeniorPatients.setText("Manage Senior Patients");
        btn_manageSeniorPatients.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btn_manageSeniorPatients.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_manageSeniorPatientsActionPerformed(evt);
            }
        });
        add(btn_manageSeniorPatients, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 240, 200, 30));

        lblHeader.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        lblHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHeader.setText("Doctor Work Area");
        add(lblHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 270, 26));

        btn_viewSeniorPatients.setBackground(new java.awt.Color(255, 255, 255));
        btn_viewSeniorPatients.setFont(new java.awt.Font("Comic Sans MS", 0, 13)); // NOI18N
        btn_viewSeniorPatients.setText("View Senior Patients");
        btn_viewSeniorPatients.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btn_viewSeniorPatients.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_viewSeniorPatientsActionPerformed(evt);
            }
        });
        add(btn_viewSeniorPatients, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 320, 200, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/doctor.gif"))); // NOI18N
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 80, 570, 540));
    }// </editor-fold>//GEN-END:initComponents

    private void btn_manageSeniorPatientsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_manageSeniorPatientsActionPerformed
        // TODO add your handling code here:
        CardLayout cardLayout = (CardLayout) userProcessContainer.getLayout();
        ManageTreatmentSenior_Page mtsj = new ManageTreatmentSenior_Page(userProcessContainer, system, userAccount, organization, enterprise);
        userProcessContainer.add("mtsj", mtsj);
        cardLayout.next(userProcessContainer);
    }//GEN-LAST:event_btn_manageSeniorPatientsActionPerformed

    private void btn_viewSeniorPatientsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_viewSeniorPatientsActionPerformed
        // TODO add your handling code here:
        CardLayout cardLayout = (CardLayout) userProcessContainer.getLayout();
        ViewTreatmentSenior_Page vtsj = new ViewTreatmentSenior_Page(userProcessContainer, system, userAccount, organization, enterprise);
        userProcessContainer.add("vtsj", vtsj);
        cardLayout.next(userProcessContainer);
    }//GEN-LAST:event_btn_viewSeniorPatientsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_manageSeniorPatients;
    private javax.swing.JButton btn_viewSeniorPatients;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblHeader;
    // End of variables declaration//GEN-END:variables
}
