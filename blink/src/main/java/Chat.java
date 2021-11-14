import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

class Chat_instance {
   String Name;
   String toid;
   
   @Override
   public String toString(){
       return Name;
   }
}

public class Chat extends javax.swing.JFrame {

    /** Creates new form window */
    public Chat() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Chat_List = new javax.swing.JScrollPane();
        Chats = new javax.swing.JList<>();
        Message = new javax.swing.JTextField();
        Send = new javax.swing.JButton();
        Renderer = new javax.swing.JScrollPane();
        New_Chat = new javax.swing.JButton();
        New_Group = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(200, 150, 150));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        Chats.setModel(new javax.swing.AbstractListModel<Chat_instance>() {
            public int getSize() { return chats.size(); }
            public Chat_instance getElementAt(int i) { return chats.get(i); }
        });
        Chats.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        Chats.setToolTipText("");
        Chats.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                ChatsValueChanged(evt);
            }
        });
        Chat_List.setViewportView(Chats);

        Send.setText("Send");
        Send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SendActionPerformed(evt);
            }
        });

        Renderer.setForeground(new java.awt.Color(200, 150, 150));

        New_Chat.setText("New Chat");
        New_Chat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                New_ChatActionPerformed(evt);
            }
        });

        New_Group.setText("New Group");
        New_Group.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                New_GroupActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                    .add(Chat_List, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                    .add(New_Chat, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(New_Group, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .add(6, 6, 6)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(Message, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(Send, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 73, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(Renderer))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(11, 11, 11)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(Renderer, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 373, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(Send)
                                .add(0, 0, Short.MAX_VALUE))
                            .add(layout.createSequentialGroup()
                                .add(1, 1, 1)
                                .add(Message))))
                    .add(layout.createSequentialGroup()
                        .add(New_Chat, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(2, 2, 2)
                        .add(New_Group, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(Chat_List)))
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleName("Window");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void New_GroupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_New_GroupActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_New_GroupActionPerformed

    private void SendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SendActionPerformed
            String message = Message.getText();
            Client.send(message,rec);
    }//GEN-LAST:event_SendActionPerformed

    private void ChatsValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_ChatsValueChanged
        Chat_instance t = new Chat_instance();
        t = Chats.getSelectedValue();
        rec = t.toid;
    }//GEN-LAST:event_ChatsValueChanged

    private void New_ChatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_New_ChatActionPerformed
        Chat_instance t = new Chat_instance();
        t.Name = "hello";
        t.toid = "shreya_ananth@yahoo.com";
        chats.add(t);
        Chats.setModel(new javax.swing.AbstractListModel<Chat_instance>() {
            public int getSize() { return chats.size(); }
            public Chat_instance getElementAt(int i) { return chats.get(i); }
        });
    }//GEN-LAST:event_New_ChatActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        try {
            Client.c.close();
        } catch (SQLException ex) {
            Logger.getLogger(Chat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowClosed

    /**
     * @param args the command line arguments
     */
    public String rec;
    public ArrayList<Chat_instance> chats= new ArrayList<Chat_instance>();
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
            java.util.logging.Logger.getLogger(Chat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Chat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Chat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Chat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        Client.database();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Chat().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane Chat_List;
    public javax.swing.JList<Chat_instance> Chats;
    private javax.swing.JTextField Message;
    private javax.swing.JButton New_Chat;
    private javax.swing.JButton New_Group;
    private javax.swing.JScrollPane Renderer;
    private javax.swing.JButton Send;
    // End of variables declaration//GEN-END:variables

}
