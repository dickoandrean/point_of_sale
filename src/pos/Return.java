/*
    Point of Sale System Project
    Authors: Clayton Barber, Brandon Barton, Declan Brennan, Maximilian Hasselbusch, Eric Metcalf
    Last Updated: 20 November 2015
 */
package pos;

import java.io.PrintStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Return extends javax.swing.JFrame {

    Connection con;
    ResultSet result;
    PrintStream ps;
    ArrayList<String> pids;
    ArrayList<String> isret;
    String tid;
    Sys system;

    /**
     * Creates new form NewReturn
     *
     * @param system
     * @param con
     * @param result
     * @param tid
     */
    public Return(Sys system, Connection con, ResultSet result, String tid) {
        this.system = system;
        this.tid = tid;
        pids = new ArrayList<String>();
        isret = new ArrayList<String>();
        this.result = result;
        this.con = con;
        initComponents();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        ps = new PrintStream(new COS(RTA));
        printExpectedReturn();
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
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        RTA = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        AR = new javax.swing.JButton();
        FR = new javax.swing.JButton();
        Logout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(700, 700));
        setSize(new java.awt.Dimension(700, 700));

        jPanel1.setBackground(new java.awt.Color(0, 0, 255));

        jLabel1.setText("What is the Point of Sales");

        RTA.setColumns(20);
        RTA.setRows(5);
        jScrollPane1.setViewportView(RTA);

        jLabel2.setText("WPS");

        AR.setText("Accept Item");
        AR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ARActionPerformed(evt);
            }
        });

        FR.setText("Finalize Return");
        FR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FRActionPerformed(evt);
            }
        });

        Logout.setText("Logout");
        Logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(FR, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                            .addComponent(AR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Logout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(AR, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(FR, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Logout, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 438, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ARActionPerformed
        ReturnItem ri = new ReturnItem(pids, isret);
    }//GEN-LAST:event_ARActionPerformed

    private void FRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FRActionPerformed
        double amount = 0.0;
        for (int i = 0; i < pids.size(); i++) {
            if (isret.get(i).equals("notfound")) {
                continue;
            }
            try {
                Statement s = con.createStatement();
                s.executeUpdate("update CONTAINS set RENTAL = 0 where TID = '" + tid + "' AND PID = '" + pids.get(i) + "'");
                ResultSet result = s.executeQuery("select \"Price\", Quantity from contains natural join item where TID = " + tid + " and PID = " + pids.get(i));
                result.next();
                amount = Double.parseDouble(result.getNString(1)) * Double.parseDouble(result.getNString(2));
                s.executeUpdate("insert into RETURN values('" + tid + "', SYSDATE, '" + new Money(amount*0.4) + "')");
            } catch (SQLException sqe) {
                System.err.println("Unable to update RETTRANSACTION");
                System.err.println(sqe.getMessage());
            }
        }
        PointofSale.doWork();
        UpdateSuccessful us = new UpdateSuccessful();
        TenderCash tc = new TenderCash(Double.toString(Money.toDouble(new Money(amount*0.4))));
        this.dispose();
    }//GEN-LAST:event_FRActionPerformed

    private void LogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutActionPerformed
        this.dispose();
        system.logout();
    }//GEN-LAST:event_LogoutActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AR;
    private javax.swing.JButton FR;
    private javax.swing.JButton Logout;
    private javax.swing.JTextArea RTA;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private void printExpectedReturn() {
        ps.println("TID  \tPID  \tQUANTITY");
        try {
            do {
                ps.println(result.getNString(1) + "\t" + result.getNString(2) + "\t" + result.getNString(3));
                pids.add(result.getNString(2));
                isret.add("notfound");
            } while (result.next());
        } catch (SQLException sqe) {
            System.err.println(sqe.getMessage());
        }
    }
}
