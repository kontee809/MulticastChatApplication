/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package main;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class Multicast extends javax.swing.JFrame {
    
    private static final int PORT = 6666;
    private static final byte[] BUFFER = new byte[4096];
    
    private String userName;
    private MulticastSocket multicastSocket;
    private InetAddress groupAddress;
    private InetAddress localAddress;
    
    public Multicast(String userName) {
        this.userName = userName;
        try {
            localAddress = InetAddress.getLocalHost();
        } catch (IOException e) {
            e.printStackTrace();
        }
        initComponents();
        toggleButtons(false);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        text_ex = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tf_group_ip = new javax.swing.JTextField();
        btn_join = new javax.swing.JButton();
        btn_leave = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_content = new javax.swing.JTextArea();
        tf_msg = new javax.swing.JTextField();
        btn_send = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        tf_private = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        text_ex.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        text_ex.setText("Not in group yet");

        jLabel2.setText("Group IP:");

        tf_group_ip.setText("239.123.35.46");

        btn_join.setText("Join Group");
        btn_join.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_joinActionPerformed(evt);
            }
        });

        btn_leave.setText("Leave Group");
        btn_leave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_leaveActionPerformed(evt);
            }
        });

        txt_content.setColumns(20);
        txt_content.setRows(5);
        jScrollPane1.setViewportView(txt_content);

        btn_send.setText("Send");
        btn_send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sendActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Private:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_private, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tf_msg, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_send, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(text_ex)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btn_leave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(tf_group_ip, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btn_join, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(text_ex)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_group_ip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_join, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_leave, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_send, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addComponent(tf_msg))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_private, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_joinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_joinActionPerformed
      String groupIP = tf_group_ip.getText().trim();
        try {
            groupAddress = InetAddress.getByName(groupIP);
            if(!groupAddress.isMulticastAddress()) {
                JOptionPane.showMessageDialog(this, "The IP address is not in the multicast range.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            multicastSocket = new MulticastSocket(PORT);
            multicastSocket.joinGroup(groupAddress);
            
            text_ex.setText("Name: " + userName + " | Group: " + groupIP);
            toggleButtons(true);
            sendSystemMessage(userName + " joined the group");
            
            new Thread(() -> {
                try {
                    while (!multicastSocket.isClosed()) {                        
                        DatagramPacket packet = new DatagramPacket(BUFFER, BUFFER.length);
                        multicastSocket.receive(packet);
                        String msg = new String(packet.getData(), 0, packet.getLength());
                        handleReceivedMessage(msg);
                        //txt_content.append(msg + "\n");
                    }
                } catch (IOException e) {
                    if (!multicastSocket.isClosed()) {
                        e.printStackTrace();
                    }
                }
            }).start();
            
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error joining the group.", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_btn_joinActionPerformed

    private void btn_sendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sendActionPerformed
        String msg = tf_msg.getText().trim();
        String privateUser = tf_private.getText().trim();
        if(!msg.isEmpty()) {
             String message = userName + " (" + localAddress.getHostAddress() + "): " + msg;
            if (!privateUser.isEmpty()) {
                sendMessage("private:" + privateUser + ":" + userName + ": " + message); // Gửi tin nhắn riêng tư
            } else {
                sendMessage(message); // Gửi tin nhắn công khai
            }
            tf_msg.setText("");
        }
    }//GEN-LAST:event_btn_sendActionPerformed

    private void btn_leaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_leaveActionPerformed
        if (multicastSocket != null && groupAddress != null) {
            try {
                sendSystemMessage(userName + " left the group.");
                multicastSocket.leaveGroup(groupAddress);
                multicastSocket.close();
                txt_content.append("You left the group.\n");
                text_ex.setText("Not in group yet");
                toggleButtons(false);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error leaving the group.", "Error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btn_leaveActionPerformed
    
    
    private void sendMessage(String msg) {
        if(multicastSocket != null && groupAddress != null) {
            try {
                byte[] msgBytes = msg.getBytes();
                DatagramPacket packet = new DatagramPacket(msgBytes, msgBytes.length, groupAddress, PORT);
                multicastSocket.send(packet);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error sending message.", "Error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        }
    }
    
    private void sendSystemMessage(String message) {
        sendMessage("[System]: " + message);
    }
    
    private void handleReceivedMessage(String msg) {
        String[] parts = msg.split(":", 4);
        if (parts.length == 4 && parts[0].equals("private")) {
            if(parts[1].equals(userName) || parts[2].equals(userName)) {
                txt_content.append("[Private] " + parts[3] + "\n");
            }
        }else {
             txt_content.append(parts[0] + ": " + parts[1] + "\n");
        }
    }
    
    
    
    
    private void toggleButtons(boolean inGroup) {
        btn_join.setEnabled(!inGroup);
        btn_leave.setEnabled(inGroup);
        btn_send.setEnabled(inGroup);
        tf_msg.setEnabled(inGroup);
        tf_private.setEnabled(inGroup);
    }
    
 
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        String userName = JOptionPane.showInputDialog("Enter your name");
        if (userName != null && !userName.isEmpty()) {
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new Multicast(userName).setVisible(true);
                }
            });
        }else {
            JOptionPane.showMessageDialog(null, "Name is required to join the chat", "Err", JOptionPane.ERROR_MESSAGE);
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_join;
    private javax.swing.JButton btn_leave;
    private javax.swing.JButton btn_send;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel text_ex;
    private javax.swing.JTextField tf_group_ip;
    private javax.swing.JTextField tf_msg;
    private javax.swing.JTextField tf_private;
    private javax.swing.JTextArea txt_content;
    // End of variables declaration//GEN-END:variables

    
}
