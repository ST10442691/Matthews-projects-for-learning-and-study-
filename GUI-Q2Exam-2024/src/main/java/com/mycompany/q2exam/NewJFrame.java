
package com.mycompany.q2exam;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;


public class NewJFrame extends javax.swing.JFrame {

    
    public NewJFrame() {
        initComponents();
    }

    private void processTicketSale() {
    String movie = (String) cboMovie.getSelectedItem();

    try {
        int tickets = Integer.parseInt(txtTickets.getText());
        double price = Double.parseDouble(txtPrice.getText());

        MovieTicketData data = new MovieTicketData(movie, tickets, price);
        MovieTickets service = new MovieTickets();

        if (!service.ValidateData(data)) {
            JOptionPane.showMessageDialog(this, "Invalid input detected!");
            return;
        }

        double total = service.CalculateTotalTicketPrice(tickets, price);

        // build report using escape sequences
        String report =
                "***************************************\n" +
                "MOVIE TICKET REPORT\n" +
                "***************************************\n\n" +
                "MOVIE NAME:\t\t" + movie + "\n" +
                "MOVIE TICKET PRICE:\tR " + price + "\n" +
                "NUMBER OF TICKETS:\t" + tickets + "\n" +
                "TOTAL TICKET PRICE:\tR " + total + "\n" +
                "***************************************\n";

        txtReport.setText(report);

        BufferedWriter writer = new BufferedWriter(new FileWriter("report.txt", true));
        writer.write(report);
        writer.newLine();
        writer.close();

        JOptionPane.showMessageDialog(this, "Report saved successfully!");

    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(this, "Please enter valid numbers!");
    } catch (IOException ex) {
        JOptionPane.showMessageDialog(this, "Error writing to file: " + ex.getMessage());
    }
}

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cboMovie = new javax.swing.JComboBox<>();
        txtTickets = new javax.swing.JTextField();
        txtPrice = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtReport = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        MenuExit = new javax.swing.JMenu();
        ExitMenu = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        MenuProcess = new javax.swing.JMenuItem();
        MenuClear = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MOVIE TICKETS");
        setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("NUMBER OF TICKETS");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("TICKET PRICE");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("MOVIE");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("TICKET REPORT");

        cboMovie.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        cboMovie.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Napoleon", "Oppenheimer" }));

        txtReport.setColumns(20);
        txtReport.setRows(5);
        jScrollPane1.setViewportView(txtReport);

        MenuExit.setText("File");

        ExitMenu.setText("EXIT");
        ExitMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitMenuActionPerformed(evt);
            }
        });
        MenuExit.add(ExitMenu);

        jMenuBar1.add(MenuExit);

        jMenu2.setText("Tools");

        MenuProcess.setText("Process");
        MenuProcess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuProcessActionPerformed(evt);
            }
        });
        jMenu2.add(MenuProcess);

        MenuClear.setText("Clear");
        MenuClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuClearActionPerformed(evt);
            }
        });
        jMenu2.add(MenuClear);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cboMovie, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                                .addComponent(txtTickets, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(50, 50, 50))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboMovie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTickets, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MenuProcessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuProcessActionPerformed
        processTicketSale();
    }//GEN-LAST:event_MenuProcessActionPerformed

    private void MenuClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuClearActionPerformed
         txtTickets.setText("");
         txtPrice.setText("");
         txtReport.setText("");      
    }//GEN-LAST:event_MenuClearActionPerformed

    private void ExitMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitMenuActionPerformed
        System.exit(0);
    }//GEN-LAST:event_ExitMenuActionPerformed

  
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem ExitMenu;
    private javax.swing.JMenuItem MenuClear;
    private javax.swing.JMenu MenuExit;
    private javax.swing.JMenuItem MenuProcess;
    private javax.swing.JComboBox<String> cboMovie;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextArea txtReport;
    private javax.swing.JTextField txtTickets;
    // End of variables declaration//GEN-END:variables
}
