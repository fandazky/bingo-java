package server;

import javax.swing.JOptionPane;
import java.net.*;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/*ambil tanggal*/
import java.util.Date; 
import java.text.DateFormat; 
import java.text.SimpleDateFormat; 

/*cetak log permainan*/
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class UI_server extends javax.swing.JFrame {
    myEchoServer new_server;    //membuat server baru
    String nama = null;
    public Home home;
    //public client.UI_client ui_client;
    //int x;
    
    public UI_server() {
        initComponents();
        try {
            this.txt_IP.setText(InetAddress.getLocalHost().getHostAddress());
        }
        catch(Exception e) {
        }
        this.writelog("Fill The blank form. and wait until server finish the searching\n"); 
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButton1 = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        txt_Port = new javax.swing.JTextField();
        Server_Btn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_ChatRoom = new javax.swing.JTextArea();
        Exit_Btn = new javax.swing.JButton();
        Kill_Field = new javax.swing.JTextField();
        DC_but = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txt_IP = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_EventLog = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnCetakLog = new javax.swing.JButton();

        jRadioButton1.setText("jRadioButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("PORT");

        txt_Port.setText("1234");
        txt_Port.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_PortActionPerformed(evt);
            }
        });

        Server_Btn.setText("Open");
        Server_Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Server_BtnActionPerformed(evt);
            }
        });

        txt_ChatRoom.setEditable(false);
        txt_ChatRoom.setColumns(20);
        txt_ChatRoom.setRows(5);
        jScrollPane1.setViewportView(txt_ChatRoom);

        Exit_Btn.setText("Close");
        Exit_Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Exit_BtnActionPerformed(evt);
            }
        });

        Kill_Field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Kill_FieldActionPerformed(evt);
            }
        });

        DC_but.setText("Kill");
        DC_but.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DC_butActionPerformed(evt);
            }
        });

        jLabel3.setText("IP SERVER");

        txt_EventLog.setColumns(20);
        txt_EventLog.setRows(5);
        jScrollPane2.setViewportView(txt_EventLog);

        jLabel2.setText("Play log");

        jLabel4.setText("Event Log");

        jLabel5.setText("Kill User");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Koneksi Server");

        btnCetakLog.setText("Cetak Log");
        btnCetakLog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCetakLogActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Kill_Field, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(DC_but, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCetakLog))
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Exit_Btn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(41, 41, 41)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_IP, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_Port, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(25, 25, 25)))
                        .addGap(43, 43, 43)
                        .addComponent(Server_Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txt_IP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_Port, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(Server_Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Kill_Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DC_but))
                        .addGap(53, 53, 53))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCetakLog)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Exit_Btn)
                        .addGap(30, 30, 30))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_PortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_PortActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_PortActionPerformed

    private void Server_BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Server_BtnActionPerformed
        if(txt_Port.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Complete the form to make Server");
        } else {    
            try { 
                new_server = new myEchoServer(this, Integer.parseInt(txt_Port.getText())); 
            }

            catch(Exception e) {
                System.out.println("Error Server");
            }
        }
    }//GEN-LAST:event_Server_BtnActionPerformed

    private void Exit_BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Exit_BtnActionPerformed
        System.exit(1);
    }//GEN-LAST:event_Exit_BtnActionPerformed

    private void Kill_FieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Kill_FieldActionPerformed
        // TODO add your handling code here:     
    }//GEN-LAST:event_Kill_FieldActionPerformed

    private void DC_butActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DC_butActionPerformed
        try {
            this.KillClient(this.Kill_Field.getText());
            this.Kill_Field.setText("");
        } 
        catch (IOException ex) {
            ex.getMessage();
        }
    }//GEN-LAST:event_DC_butActionPerformed

    /*cetak log permainan file.txt*/
    private void btnCetakLogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakLogActionPerformed
        // TODO add your handling code here:
        String text, judul;
        text = txt_ChatRoom.getText();
        judul = "server_log_permainan";
        
        File log = new File(judul + ".txt");
        
        try {
            if(log.exists()==false) {
                JOptionPane.showMessageDialog(null, "Log Permainan Berhasil Disimpan");
                log.createNewFile();
            }

            PrintWriter out = new PrintWriter(new FileWriter(log, true));

            out.append(getTanggal()).println();
            out.append(text).println();
            out.append("======================================================\n\n").println();

            out.close();
        } catch (IOException e) {
            System.out.println("Gagal Mencetak Log Permainan");
        }
        JOptionPane.showMessageDialog(null, "Sukses Disimpan!");
    }//GEN-LAST:event_btnCetakLogActionPerformed

    private String getTanggal() { 
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"); 
        Date date = new Date(); 
        return dateFormat.format(date); 
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UI_server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UI_server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UI_server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UI_server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UI_server().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DC_but;
    private javax.swing.JButton Exit_Btn;
    private javax.swing.JTextField Kill_Field;
    private javax.swing.JButton Server_Btn;
    private javax.swing.JButton btnCetakLog;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea txt_ChatRoom;
    private javax.swing.JTextArea txt_EventLog;
    private javax.swing.JTextField txt_IP;
    private javax.swing.JTextField txt_Port;
    // End of variables declaration//GEN-END:variables
    
    void writelog(String log) {
        txt_EventLog.append(log);
    }
    
    void writemessage(String message) {
        txt_ChatRoom.append(message + "\n");
    }
    
    void sendToClient(String Message)throws java.io.IOException {   
        for(int i =0; i<new_server.clientCount; i++){
           new_server.clients[i].sendMessage(Message);
        }
    }
        
    public void sendToAClient(String Message, String username)throws IOException { 
        String toClient = username.substring(0, username.length()-1);
        
        for(int i =0; i<new_server.clientCount; i++) {
            String client = new_server.clients[i].nama;
            if(client.equalsIgnoreCase(toClient)) {
                  new_server.clients[i].sendMessage("[PM] "+Message+"\n");
            }
        }
    }
    
    public void KillClient(String username)throws IOException {     
        for(int i =0; i<new_server.clientCount; i++) {
            String client = new_server.clients[i].nama;
            if(client.equalsIgnoreCase(username)) {
                new_server.clients[i].output.writeUTF("QUIT");
                new_server.clients[i].stop();
            }
        } 
    }
}