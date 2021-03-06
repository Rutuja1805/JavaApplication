/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.ManagerWorkArea;

import Healthplus.Account.Account;
import Healthplus.FundRaiser.FundRaiser;
import Healthplus.E_System;
import Healthplus.Enterprises.Enterprise;
import Healthplus.Org.AdminOrg;
import Healthplus.Org.Org;
import Healthplus.UserAccount.UserAccount;
import Healthplus.WorkQueue.AgencyWorkRequest;
import Healthplus.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;


public class ManageFundingAgenciesJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageFundingAgencies
     */
    private JPanel userProcessContainer;
    private UserAccount userAccount;
    private Org organization;
    private Enterprise enterprise;
    private E_System system;

    public ManageFundingAgenciesJPanel(JPanel userProcessContainer, E_System system, UserAccount userAccount, Org organization, Enterprise enterprise) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.userAccount = userAccount;
        this.organization = organization;
        this.enterprise = enterprise;
        this.system = system;
        populateAgencyTable();
    }

    public void populateAgencyTable() {
        DefaultTableModel model = (DefaultTableModel) tblFundingAgency.getModel();

        model.setRowCount(0);
        for (WorkRequest request : organization.getWorkQueue().getWorkRequestList()) {
            if (request instanceof AgencyWorkRequest) {
                if (((AgencyWorkRequest) request).getAgency().isStatus() == true) {
                    Object[] row = new Object[3];
 //                   row[0] = ((AgencyWorkRequest) request).getAgency().getId();
                    row[0] = (AgencyWorkRequest) request;
                    row[1] = ((AgencyWorkRequest) request).getAgency().getAmount();
                    row[2] = ((AgencyWorkRequest) request).getAgency().getCity();
                    model.addRow(row);
                }
            }
        }
//        for (FundRaiser agency : organization.getAgencyDirectory().getAgencyList()) {
//            if (agency.isStatus() == true) {
//                Object[] row = new Object[3];
//                row[0] = agency.getId();
//                row[1] = agency;
//                row[2] = agency.getCity();
//                model.addRow(row);
//            }
//        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_add = new javax.swing.JButton();
        btngoback = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFundingAgency = new javax.swing.JTable();
        lblHeader = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 219, 196));
        setMaximumSize(new java.awt.Dimension(700, 700));
        setMinimumSize(new java.awt.Dimension(700, 700));
        setPreferredSize(new java.awt.Dimension(700, 700));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_add.setBackground(new java.awt.Color(255, 255, 255));
        btn_add.setFont(new java.awt.Font("Comic Sans MS", 0, 13)); // NOI18N
        btn_add.setText("Accept");
        btn_add.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });
        add(btn_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 320, 100, 40));

        btngoback.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/backicon.jpeg"))); // NOI18N
        btngoback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btngobackActionPerformed(evt);
            }
        });
        add(btngoback, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 510, 100, 90));

        tblFundingAgency.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Budget", "City"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblFundingAgency);
        if (tblFundingAgency.getColumnModel().getColumnCount() > 0) {
            tblFundingAgency.getColumnModel().getColumn(0).setResizable(false);
            tblFundingAgency.getColumnModel().getColumn(1).setResizable(false);
            tblFundingAgency.getColumnModel().getColumn(2).setResizable(false);
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 126, 500, 170));

        lblHeader.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        lblHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHeader.setText("Manage Funding Agencies");
        add(lblHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, 300, 40));
    }// </editor-fold>//GEN-END:initComponents

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblFundingAgency.getSelectedRow();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        AgencyWorkRequest agencyRequest = (AgencyWorkRequest) tblFundingAgency.getValueAt(selectedRow, 0);
        
        //Updating account and account directory
        Account account = new Account();
        enterprise.getAccountDirectory().getAccountList().add(account);
        account.setAgency(agencyRequest.getAgency());
        int total = agencyRequest.getAgency().getAmount() + enterprise.getAccountDirectory().getTotal();
        int balance = agencyRequest.getAgency().getAmount() + enterprise.getAccountDirectory().getBalance();
        enterprise.getAccountDirectory().setTotal(total);
        enterprise.getAccountDirectory().setBalance(balance);

        system.getAgencyDirectory().createAgency(agencyRequest.getAgency().getName(), agencyRequest.getAgency().getAmount());
        //set agency status to false ie amount =0
        agencyRequest.getAgency().setStatus(false);
        agencyRequest.setReceiver(userAccount);
        agencyRequest.setStatus("Accepted");
        populateAgencyTable();
        JOptionPane.showMessageDialog(null, "Accepted");
    }//GEN-LAST:event_btn_addActionPerformed

    private void btngobackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btngobackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btngobackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btngoback;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblHeader;
    private javax.swing.JTable tblFundingAgency;
    // End of variables declaration//GEN-END:variables
}
