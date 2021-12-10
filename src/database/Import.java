package database;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.YES_NO_CANCEL_OPTION;
import static javax.swing.JOptionPane.YES_OPTION;


public class Import extends javax.swing.JFrame {

 
  Connection con=null;
    Statement stat=null;
    ResultSet  rs=null;
    PreparedStatement prep;
    public Import(Connection c) throws SQLException, IOException {
        initComponents();
        this.setTitle("Import");
        this.setResizable(false);
        this.getContentPane().setBackground(Color.LIGHT_GRAY);
        
        //Center in screen
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width/2-getSize().width/2, dim.height/2-getSize().height/2);
        
        ans.setForeground(Color.BLACK);
        ans.setFont(new Font("SansSerif", Font.BOLD, 13));
        
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
        prep=con.prepareStatement("insert into movei values (?,?,?,?,?,?,?);");
        
       // dos() ;
    }
    
    public void dos() throws SQLException, IOException
    {
       
      File selectedFile = rt.getSelectedFile();
       if(selectedFile==null)return;
      Scanner in = new Scanner(selectedFile);
    
      int i=0;
      while(in.hasNextLine())
          
      {
          String data=in.nextLine();
         // System.out.println(data);
        switch(i){
            
            
            
            case 1:
            {
                prep.setString(1, data); 
                break;
            }
            
            case 2:
            {
                prep.setInt(2,Integer.parseInt(data)); 
                break;
            }
            
            case 3:
            {
                prep.setInt(3,Integer.parseInt(data)); 
                break;
            }
            
            case 4:
            {
                prep.setString(4, data); 
                break;
            }
            
            case 5:
            {
              if(data.equals("null"))  prep.setString(5, null); 
              else prep.setString(5, data); 
                break;
            }
            
            case 6:
            {
              if(data.equals("null"))  prep.setString(6, null); 
              else prep.setString(6, data); 
                break;
            }
            
            case 7:
            {
              if(data.equals("null"))  prep.setString(7, null); 
              else prep.setString(7, data); 
            prep.execute();
                break;
            }
            
            default:{  }
            
        }
         System.out.println(i+" "+data);
  i++;
  if(i==10)i=0;
  
      }
      
      ans.setText("The Import Successfully ");
      
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel3 = new javax.swing.JPanel();
        b1 = new javax.swing.JButton();
        b2 = new javax.swing.JButton();
        ans = new javax.swing.JLabel();
        l3 = new javax.swing.JLabel();
        rt = new javax.swing.JFileChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        panel3.setBackground(new java.awt.Color(255, 204, 204));
        panel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 204), 3, true));

        b1.setBackground(new java.awt.Color(204, 204, 0));
        b1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        b1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/imp.png"))); // NOI18N
        b1.setMnemonic('a');
        b1.setText("Import");
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
                .addGap(10, 10, 10)
                .addComponent(b2)
                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel3Layout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(ans))
                    .addGroup(panel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(b1)))
                .addContainerGap())
        );
        panel3Layout.setVerticalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel3Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(b1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(b2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ans))
                .addGap(4, 4, 4))
        );

        l3.setFont(new java.awt.Font("Tahoma", 1, 19)); // NOI18N
        l3.setForeground(new java.awt.Color(51, 102, 0));
        l3.setText("Please Select File Path To Import : ");

        rt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(rt, javax.swing.GroupLayout.PREFERRED_SIZE, 810, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(l3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(l3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(panel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void b1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b1ActionPerformed

        try {
            dos();

        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "The data is exist or the data is bad input","result) ",1,new ImageIcon("src/icons/20.png")); return;
        }

        catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "error in ophen file","result) ",1,new ImageIcon("src/icons/20.png")); return;
           // Logger.getLogger(Export.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_b1ActionPerformed

    private void b2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b2ActionPerformed
        ans.setText("");
    }//GEN-LAST:event_b2ActionPerformed

    private void rtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rtActionPerformed
        b1.doClick();
    }//GEN-LAST:event_rtActionPerformed

   public static void main(String args[]) throws Exception {
    
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                 new Import(new DB().getCon("DB\\DB.mdb"));
                } 
                catch (Exception ex) {
                   // Logger.getLogger(DISBLAY.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ans;
    private javax.swing.JButton b1;
    private javax.swing.JButton b2;
    private javax.swing.JLabel l3;
    private javax.swing.JPanel panel3;
    private javax.swing.JFileChooser rt;
    // End of variables declaration//GEN-END:variables
}
