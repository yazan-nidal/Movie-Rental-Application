package database;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.YES_NO_CANCEL_OPTION;
import static javax.swing.JOptionPane.YES_OPTION;

public class ReturnVedio extends javax.swing.JFrame {
    
    
    Connection con=null;
    Statement stat=null;
    PreparedStatement prep=null;
    ResultSet  rs=null;
    
    public ReturnVedio(Connection c) throws SQLException {
        
        initComponents();
        
        this.setTitle("return a video");
        this.setResizable(false);
        this.getContentPane().setBackground(Color.LIGHT_GRAY);
        
        //Center in screen
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width/2-getSize().width/2, dim.height/2-getSize().height/2);
        
        addWindowListener(new WindowAdapter()
        {
        
        @Override
        public void windowOpened(WindowEvent we) {
        setIconImage( new ImageIcon("src/icons/p.png").getImage());
        }
        
        @Override
        public void windowClosing(WindowEvent we)
        {
        int ans=JOptionPane.showConfirmDialog(null,"Do you want to exit","Exit",YES_NO_CANCEL_OPTION,1,new ImageIcon("src/icons/can.png"));
        if (ans==YES_OPTION )dispose();
        }
        
        @Override
        public void windowIconified(WindowEvent we) { setIconImage( new ImageIcon("src/icons/pl.png").getImage()); }

        @Override
        public void windowDeiconified(WindowEvent we) { setIconImage( new ImageIcon("src/icons/p.png").getImage()); }
        
        });
        
        this.setVisible(true);
        
        con=c;
        stat =(Statement) con.createStatement();
        prep= con.prepareStatement("update movei set RentedTo=? , DateOfRental=? , DateOfReturn=? where MovieName=?");
    }

    
    public boolean found() throws SQLException
    {
      if(t.getText().isEmpty())
      {
       
        JOptionPane.showMessageDialog(null, "Empty : no input to search","result  ",1,new ImageIcon("src/icons/20.png")); 
        
        return false;
      }
        
      rs = stat.executeQuery("select * from movei where MovieName ='"+t.getText()+"';");
      
      int count=0;
      
      while(rs.next())count++;
      
      if(count == 0){
          JOptionPane.showMessageDialog(null, "Not Found : the movie is not exist","result  ",1,new ImageIcon("src/icons/20.png")); 
          return false;
      }
      
        return true;
    }

        public boolean dos() throws SQLException 
    {
        
      
     if(found()){
       
         try {
             prep.setString(1,null);
             prep.setString(2,null);
             prep.setString(3,null);
             prep.setString(4, t.getText());
             prep.executeUpdate();

         } 
         catch (SQLException ex) {
             
             JOptionPane.showMessageDialog(null, "Bad input","Error) ",1,new ImageIcon("src/icons/20.png"));
             
             return false;
             //Logger.getLogger(RentVedio.class.getName()).log(Level.SEVERE, null, ex);
         }
          return true;
     }
     
     return false;
     
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new javax.swing.JPanel();
        l1 = new javax.swing.JLabel();
        t = new javax.swing.JTextField();
        panel3 = new javax.swing.JPanel();
        b1 = new javax.swing.JButton();
        b2 = new javax.swing.JButton();
        ans = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        panel1.setBackground(new java.awt.Color(255, 204, 204));
        panel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 153), 3, true));

        l1.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        l1.setForeground(new java.awt.Color(51, 102, 0));
        l1.setText("Please Enter Name of Movie : ");

        t.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(l1)
                .addGap(110, 110, 110)
                .addComponent(t, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l1)
                    .addComponent(t, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        panel3.setBackground(new java.awt.Color(255, 204, 204));

        b1.setBackground(new java.awt.Color(204, 204, 0));
        b1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        b1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/addv.png"))); // NOI18N
        b1.setMnemonic('a');
        b1.setText("Return");
        b1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b1ActionPerformed(evt);
            }
        });

        b2.setBackground(new java.awt.Color(204, 204, 0));
        b2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        b2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/rem1.png"))); // NOI18N
        b2.setMnemonic('c');
        b2.setText("Clear");
        b2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b2ActionPerformed(evt);
            }
        });

        ans.setBackground(new java.awt.Color(204, 204, 255));
        ans.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        ans.setForeground(new java.awt.Color(204, 204, 0));

        javax.swing.GroupLayout panel3Layout = new javax.swing.GroupLayout(panel3);
        panel3.setLayout(panel3Layout);
        panel3Layout.setHorizontalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel3Layout.createSequentialGroup()
                .addGap(173, 173, 173)
                .addComponent(b2)
                .addGap(106, 106, 106)
                .addComponent(b1)
                .addGap(18, 18, 18)
                .addComponent(ans)
                .addGap(155, 155, 155))
        );
        panel3Layout.setVerticalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(b1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(b2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(ans, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(panel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tActionPerformed

    private void b1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b1ActionPerformed

        String  h;
        try {
            h = ((dos()) ?" Successful Return":"Failed Return");
            ans.setText(h);
        }
        catch (SQLException ex) {
            //Logger.getLogger(RentVedio.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_b1ActionPerformed

    private void b2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b2ActionPerformed
        t.setText("");
        ans.setText("");
    }//GEN-LAST:event_b2ActionPerformed


    
   public static void main(String args[]) throws Exception {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                try {
                    new ReturnVedio(new DB().getCon("DB\\DB.mdb"));
                } 
                
                catch (Exception ex) {
                    Logger.getLogger(SVedio.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ans;
    private javax.swing.JButton b1;
    private javax.swing.JButton b2;
    private javax.swing.JLabel l1;
    private javax.swing.JPanel panel1;
    private javax.swing.JPanel panel3;
    private javax.swing.JTextField t;
    // End of variables declaration//GEN-END:variables
}
