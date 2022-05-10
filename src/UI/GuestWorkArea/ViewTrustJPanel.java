/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.GuestWorkArea;

import Healthplus.E_System;
import Healthplus.Enterprises.Enterprise;
import Healthplus.Network.City;
import Healthplus.Network.Country;
import Healthplus.Network.State;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;


public class ViewTrustJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ViewTrustJPanel
     */
    
    private JPanel userProcessContainer;
    E_System system;
    
    public ViewTrustJPanel(JPanel userProcessContainer, E_System system) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.system = system;
        populateCountry();
        populateState();
        populateCity();
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


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btn_submit = new javax.swing.JButton();
        label_country = new javax.swing.JLabel();
        combo_country = new javax.swing.JComboBox();
        combo_city = new javax.swing.JComboBox();
        label_city = new javax.swing.JLabel();
        label_state = new javax.swing.JLabel();
        combo_state = new javax.swing.JComboBox();
        tblScrollPane = new javax.swing.JScrollPane();
        tblTrust = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btn_back = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 222, 210));

        jPanel1.setBackground(new java.awt.Color(255, 222, 210));
        jPanel1.setDoubleBuffered(false);
        jPanel1.setMaximumSize(new java.awt.Dimension(700, 700));
        jPanel1.setMinimumSize(new java.awt.Dimension(700, 700));
        jPanel1.setName(""); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(700, 700));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_submit.setBackground(new java.awt.Color(255, 255, 255));
        btn_submit.setFont(new java.awt.Font("Comic Sans MS", 0, 13)); // NOI18N
        btn_submit.setText("Submit");
        btn_submit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btn_submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_submitActionPerformed(evt);
            }
        });
        jPanel1.add(btn_submit, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 240, 90, 30));

        label_country.setFont(new java.awt.Font("Comic Sans MS", 0, 13)); // NOI18N
        label_country.setText("Country:");
        jPanel1.add(label_country, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, -1, 20));

        combo_country.setFont(new java.awt.Font("Comic Sans MS", 0, 13)); // NOI18N
        combo_country.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_countryActionPerformed(evt);
            }
        });
        jPanel1.add(combo_country, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 120, 150, -1));

        combo_city.setFont(new java.awt.Font("Comic Sans MS", 0, 13)); // NOI18N
        jPanel1.add(combo_city, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 200, 150, -1));

        label_city.setFont(new java.awt.Font("Comic Sans MS", 0, 13)); // NOI18N
        label_city.setText("City:");
        jPanel1.add(label_city, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 200, -1, 20));

        label_state.setFont(new java.awt.Font("Comic Sans MS", 0, 13)); // NOI18N
        label_state.setText("State:");
        jPanel1.add(label_state, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 160, -1, 20));

        combo_state.setFont(new java.awt.Font("Comic Sans MS", 0, 13)); // NOI18N
        combo_state.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_stateActionPerformed(evt);
            }
        });
        jPanel1.add(combo_state, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 160, 150, -1));

        tblTrust.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Trust"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTrust.setColumnSelectionAllowed(true);
        tblTrust.setMinimumSize(new java.awt.Dimension(375, 0));
        tblTrust.getTableHeader().setReorderingAllowed(false);
        tblScrollPane.setViewportView(tblTrust);
        tblTrust.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        jPanel1.add(tblScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 290, 340, 170));

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("View Trust");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 60, 250, -1));

        btn_back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/backicon.jpeg"))); // NOI18N
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });
        jPanel1.add(btn_back, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 550, 100, 80));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 100, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 100, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_submitActionPerformed
        // TODO add your handling code here:
        DefaultTableModel dtm = (DefaultTableModel) tblTrust.getModel();
        dtm.setRowCount(0);

        Country country = (Country) combo_country.getSelectedItem();
        State state = (State) combo_state.getSelectedItem();
        City city = (City) combo_city.getSelectedItem();

        for (Country c : system.getNetworkList()) {
            if (c.equals(country)) {
                for (State s : c.getStateList()) {
                    if (s.equals(state)) {
                        for (City cy : s.getCityList()) {
                            if (cy.equals(city)) {
                                for (Enterprise e : city.getEnterpriseDirectory().getEnterpriseList()) {
                                    if(e.getEnterpriseType().getValue().equals("Trust")){
                                        Object row[] = new Object[1];

                                        row[0] = e;
                                        dtm.addRow(row);
                                    }
                                }
                            }
                        }
                    }
                }
            }

        }
    }//GEN-LAST:event_btn_submitActionPerformed

    private void combo_countryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_countryActionPerformed
        // TODO add your handling code here:
        populateState();
    }//GEN-LAST:event_combo_countryActionPerformed

    private void combo_stateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_stateActionPerformed
        // TODO add your handling code here:
        populateCity();
    }//GEN-LAST:event_combo_stateActionPerformed

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btn_backActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_back;
    private javax.swing.JButton btn_submit;
    private javax.swing.JComboBox combo_city;
    private javax.swing.JComboBox combo_country;
    private javax.swing.JComboBox combo_state;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel label_city;
    private javax.swing.JLabel label_country;
    private javax.swing.JLabel label_state;
    private javax.swing.JScrollPane tblScrollPane;
    private javax.swing.JTable tblTrust;
    // End of variables declaration//GEN-END:variables
}
