package database;

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

class ADD extends javax.swing.JFrame {

 
    Connection con=null;
    Statement stat=null;
    PreparedStatement prep=null;
    ResultSet  rs=null;
    
    public ADD(Connection c) throws SQLException {
        initComponents();
        
        this.setTitle("Add a new video");
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
        
         t5.setEnabled(false);
         t6.setEnabled(false);
         t7.setEnabled(false);
         
        con=c;
        stat =(Statement) con.createStatement();
        prep=con.prepareStatement("insert into movei values (?,?,?,?,?,?,?);");
         
        this.setVisible(true);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new javax.swing.JPanel();
        l4 = new javax.swing.JLabel();
        l3 = new javax.swing.JLabel();
        l1 = new javax.swing.JLabel();
        l2 = new javax.swing.JLabel();
        t4 = new javax.swing.JTextField();
        t1 = new javax.swing.JTextField();
        t2 = new javax.swing.JTextField();
        t3 = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        panel2 = new javax.swing.JPanel();
        rented = new java.awt.Checkbox();
        l6 = new javax.swing.JLabel();
        l7 = new javax.swing.JLabel();
        l5 = new javax.swing.JLabel();
        t6 = new javax.swing.JTextField();
        t7 = new javax.swing.JTextField();
        t5 = new javax.swing.JTextField();
        panel3 = new javax.swing.JPanel();
        b1 = new javax.swing.JButton();
        b2 = new javax.swing.JButton();
        ans = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        panel1.setBackground(new java.awt.Color(255, 204, 204));
        panel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 153), 3, true));

        l4.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        l4.setForeground(new java.awt.Color(0, 102, 0));
        l4.setText("Please Enter Date released of Movie : ");

        l3.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        l3.setForeground(new java.awt.Color(0, 102, 0));
        l3.setText("Please Enter Rated  of Movie : ");

        l1.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        l1.setForeground(new java.awt.Color(51, 102, 0));
        l1.setText("Please Enter Name of Movie : ");

        l2.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        l2.setForeground(new java.awt.Color(0, 102, 0));
        l2.setText("Please Enter Length of Movie : ");

        t4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t4KeyTyped(evt);
            }
        });

        t2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t2KeyTyped(evt);
            }
        });

        t3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t3KeyTyped(evt);
            }
        });

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(l2)
                    .addComponent(l3)
                    .addComponent(l4)
                    .addComponent(l1))
                .addGap(23, 23, 23)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(t4, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(t1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t3, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t2, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42))))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l1)
                    .addComponent(t1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l2)
                    .addComponent(t2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l3)
                    .addComponent(t3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l4)
                    .addComponent(t4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        panel2.setBackground(new java.awt.Color(255, 204, 204));
        panel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 153), 3, true));

        rented.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        rented.setForeground(new java.awt.Color(51, 102, 0));
        rented.setLabel(" Rented");
        rented.setName(""); // NOI18N
        rented.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rentedMousePressed(evt);
            }
        });

        l6.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        l6.setForeground(new java.awt.Color(0, 102, 0));
        l6.setText("Please Enter Date of rental  : ");

        l7.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        l7.setForeground(new java.awt.Color(0, 102, 0));
        l7.setText("Please Enter Date of return : ");

        l5.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        l5.setForeground(new java.awt.Color(0, 102, 0));
        l5.setText("Please Enter Name of ranted : ");

        t6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t6KeyTyped(evt);
            }
        });

        t7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t7KeyTyped(evt);
            }
        });

        t5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t5KeyTyped(evt);
            }
        });

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(l6)
                    .addComponent(rented, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l7)
                    .addComponent(l5))
                .addGap(86, 86, 86)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(t7, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(t6, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                        .addComponent(t5)))
                .addGap(36, 36, 36))
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(rented, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l5)
                    .addComponent(t5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l6)
                    .addComponent(t6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l7)
                    .addComponent(t7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        panel3.setBackground(new java.awt.Color(255, 204, 204));

        b1.setBackground(new java.awt.Color(204, 204, 0));
        b1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        b1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/addv.png"))); // NOI18N
        b1.setMnemonic('a');
        b1.setText("ADD");
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
                .addGap(163, 163, 163)
                .addComponent(b2)
                .addGap(101, 101, 101)
                .addComponent(b1)
                .addGap(38, 38, 38)
                .addComponent(ans)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(6, 6, 6))
            .addComponent(panel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(5, 5, 5)
                .addComponent(panel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void t4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t4KeyTyped
        if(!((evt.getKeyChar() >= '0' && evt.getKeyChar() <='9') || (evt.getKeyChar() == '/' )))
        evt.consume();
    }//GEN-LAST:event_t4KeyTyped

    private void t2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t2KeyTyped
        if(!(evt.getKeyChar() >= '0' && evt.getKeyChar() <='9'))
        evt.consume();
    }//GEN-LAST:event_t2KeyTyped

    private void t3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t3KeyTyped
        if(!(evt.getKeyChar() >= '0' && evt.getKeyChar() <='9'))
        evt.consume();
    }//GEN-LAST:event_t3KeyTyped

    private void rentedMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rentedMousePressed

        b=(b==true)?false:true;

        if(b)
        {
            t5.setEnabled(true);
            t6.setEnabled(true);
            t7.setEnabled(true);
        }

        if(b==false)
        {
            t5.setEnabled(false);
            t6.setEnabled(false);
            t7.setEnabled(false);

            t5.setText("");
            t6.setText("");
            t7.setText("");
        }
    }//GEN-LAST:event_rentedMousePressed

    private void t6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t6KeyTyped
        if(!((evt.getKeyChar() >= '0' && evt.getKeyChar() <='9') || (evt.getKeyChar() == '/' )))
        evt.consume();
    }//GEN-LAST:event_t6KeyTyped

    private void t7KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t7KeyTyped
        if(!((evt.getKeyChar() >= '0' && evt.getKeyChar() <='9') || (evt.getKeyChar() == '/' )))
        evt.consume();
    }//GEN-LAST:event_t7KeyTyped

    private void t5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t5KeyTyped

        if(!((evt.getKeyChar() >= 'a' && evt.getKeyChar() <='z')
            || (evt.getKeyChar() >= 'A' && evt.getKeyChar() <='Z')
            || (evt.getKeyChar() == ' ')))
    evt.consume();
    }//GEN-LAST:event_t5KeyTyped

    public boolean found() throws SQLException
    {
      if(t1.getText().isEmpty())
      {
       
        JOptionPane.showMessageDialog(null, "Empty : no input to search","result  ",1,new ImageIcon("src/icons/20.png")); 
        
        return false;
      }
        
      rs = stat.executeQuery("select * from movei where MovieName ='"+t1.getText()+"';");
      
      int count=0;
      
      while(rs.next())count++;
      
      if(count == 0){
         // JOptionPane.showMessageDialog(null, "Not Found : the movie is not exist","result  ",1,new ImageIcon("src/icons/20.png")); 
          return false;
      }
      
        return true;
    }
        
    boolean fun() throws SQLException 
    {
      
       
      if(found()){ 
      // System.out.println(found());
      JOptionPane.showMessageDialog(null, "prevent add : the movie is exist","result) ",1,new ImageIcon("src/icons/20.png"));
      return false;
       }
      
          try { 
              
            prep.setString(1, t1.getText());  
            prep.setInt(2,Integer.parseInt(t2.getText())); 
            prep.setInt(3,Integer.parseInt(t3.getText())); 
            prep.setString(4, t4.getText());  
            
            if(rented.getState()==true){
            prep.setString(5, t5.getText());  
            prep.setString(6, t6.getText());  
            prep.setString(7, t7.getText());  
            }
            else
            {
            prep.setString(5, null);  
            prep.setString(6, null);  
            prep.setString(7, null);
            }
            prep.execute();
            
            return true;

            }
          catch (Exception ex) {
          JOptionPane.showMessageDialog(null, "Bad input","Error) ",1,new ImageIcon("src/icons/20.png"));
            } 
                return false;
    }
        
    private void b1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b1ActionPerformed

        String h;
        try {
            h = (fun()) ?" Successful Add":"Failed Add";
            ans.setText(h);
        } catch (SQLException ex) {
            //Logger.getLogger(ADD.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }//GEN-LAST:event_b1ActionPerformed

    boolean b;
    private void b2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b2ActionPerformed
        t1.setText("");
        t2.setText("");
        t3.setText("");
        t4.setText("");
        t5.setText("");
        t6.setText("");
        t7.setText("");

        t5.setEnabled(false);
        t6.setEnabled(false);
        t7.setEnabled(false);

        rented.setState(b=false);

        ans.setText("");
    }//GEN-LAST:event_b2ActionPerformed

        public static void main(String args[]) throws Exception {
     
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               
                try {
                    new ADD(new DB().getCon("DB\\DB.mdb"));
                } 
                
                catch (Exception ex) {
                    Logger.getLogger(ADD.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ans;
    private javax.swing.JButton b1;
    private javax.swing.JButton b2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel l1;
    private javax.swing.JLabel l2;
    private javax.swing.JLabel l3;
    private javax.swing.JLabel l4;
    private javax.swing.JLabel l5;
    private javax.swing.JLabel l6;
    private javax.swing.JLabel l7;
    private javax.swing.JPanel panel1;
    private javax.swing.JPanel panel2;
    private javax.swing.JPanel panel3;
    private java.awt.Checkbox rented;
    private javax.swing.JTextField t1;
    private javax.swing.JTextField t2;
    private javax.swing.JTextField t3;
    private javax.swing.JTextField t4;
    private javax.swing.JTextField t5;
    private javax.swing.JTextField t6;
    private javax.swing.JTextField t7;
    // End of variables declaration//GEN-END:variables
}
