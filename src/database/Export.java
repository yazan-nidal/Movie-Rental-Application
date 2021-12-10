package database;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.YES_NO_CANCEL_OPTION;
import static javax.swing.JOptionPane.YES_OPTION;

public class Export extends javax.swing.JFrame {

    Connection con=null;
    Statement stat=null;
    ResultSet  rs=null;

    public Export(Connection c) throws SQLException, IOException {
        initComponents();
        this.setTitle("Export");
        rt.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
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
        
       // dos() ;
    }
    
    public void dos() throws IOException
    {
        try {
            String re="";
            
            File selectedFile = rt.getSelectedFile();
            if(selectedFile!=null)
            re= selectedFile.getPath();
            
            System.out.println(re);
            if(t1.getText().isEmpty()){JOptionPane.showMessageDialog(null, "Please Enter Name Of  File To Export","Name Of  File ",1,new ImageIcon("src/icons/20.png")); return;}
            re+="/"+t1.getText()+".txt";
            
            
            FileWriter myWriter = new FileWriter(re);
            
            rs = stat.executeQuery("select * from movei;");
            
            int count=0;
            
            while(rs.next())
            {
                
                String g="***********************************************\n"
                        +(count+1)+ "- Movie Name : " + rs.getString(1)
                        +"\nLength : "+rs.getString(2)
                        +" , Rated : "+rs.getString(3)
                        +" , Date released : "+rs.getString(4)
                        +"\nRented to :"+rs.getString(5)
                        +" , Date of rental : "+rs.getString(6)
                        +" , Date of return : "+rs.getString(7)
                        +"\n***********************************************\n\n"
                        ;
                
                myWriter.write(g);
                
                count++;
                
            }
            
            rs.close();
            myWriter.close();
            
            if(count == 0){
                
                JOptionPane.showMessageDialog(null, "Not Found : no movie exist","result) ",1,new ImageIcon("src/icons/20.png")); return;
            }
            
            ans.setText("The file saved in Path : "+re);
            System.out.println("Successfully wrote to the file.");
        } catch (SQLException ex) {
            //Logger.getLogger(Export.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Please Select Path To Export File in this Path","result) ",1,new ImageIcon("src/icons/20.png")); return;
        }
            
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new javax.swing.JPanel();
        l1 = new javax.swing.JLabel();
        t1 = new javax.swing.JTextField();
        l2 = new javax.swing.JLabel();
        l3 = new javax.swing.JLabel();
        panel3 = new javax.swing.JPanel();
        b1 = new javax.swing.JButton();
        b2 = new javax.swing.JButton();
        ans = new javax.swing.JLabel();
        rt = new javax.swing.JFileChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        panel1.setBackground(new java.awt.Color(255, 153, 153));
        panel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 153), 3, true));
        panel1.setPreferredSize(new java.awt.Dimension(1026, 100));

        l1.setFont(new java.awt.Font("Tahoma", 1, 19)); // NOI18N
        l1.setForeground(new java.awt.Color(51, 102, 0));
        l1.setText("Please Enter Name Of  File To Export : ");

        t1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t1ActionPerformed(evt);
            }
        });
        t1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t1KeyTyped(evt);
            }
        });

        l2.setFont(new java.awt.Font("Tahoma", 1, 19)); // NOI18N
        l2.setForeground(new java.awt.Color(51, 102, 0));
        l2.setText(". txt");

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(l1)
                .addGap(3, 3, 3)
                .addComponent(t1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(l2)
                .addGap(105, 105, 105))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l1)
                    .addComponent(l2))
                .addGap(10, 10, 10))
        );

        l3.setFont(new java.awt.Font("Tahoma", 1, 19)); // NOI18N
        l3.setForeground(new java.awt.Color(51, 102, 0));
        l3.setText("Please Select Path To Export File in this Path : ");

        panel3.setBackground(new java.awt.Color(255, 204, 204));
        panel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 204), 3, true));

        b1.setBackground(new java.awt.Color(204, 204, 0));
        b1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        b1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/exp.png"))); // NOI18N
        b1.setMnemonic('a');
        b1.setText("Export");
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

        rt.setDialogType(javax.swing.JFileChooser.SAVE_DIALOG);
        rt.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);
        rt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, 843, Short.MAX_VALUE)
                .addGap(6, 6, 6))
            .addComponent(panel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(l3))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(rt, javax.swing.GroupLayout.PREFERRED_SIZE, 810, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(l3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void t1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t1ActionPerformed
         b1.doClick();
    }//GEN-LAST:event_t1ActionPerformed

    private void t1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t1KeyTyped
        if((evt.getKeyChar() == '.'
            || evt.getKeyChar() ==',')
        || (evt.getKeyChar() == '/' )
        || (evt.getKeyChar() == '*' )
        || (evt.getKeyChar() == '+' )
        || (evt.getKeyChar() == '-' )
        || (evt.getKeyChar() == ' ' )
        || (evt.getKeyChar() == '\t' ))
        evt.consume();
    }//GEN-LAST:event_t1KeyTyped

  void f()
  {
      try {
            dos();
        }
        catch (IOException ex) {
           //Logger.getLogger(Export.class.getName()).log(Level.SEVERE, null, ex);
           JOptionPane.showMessageDialog(null, "Please Select Path To Export File in this Path","result) ",1,new ImageIcon("src/icons/20.png")); return;
        } 
  }
  
    private void b1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b1ActionPerformed
        f();
    }//GEN-LAST:event_b1ActionPerformed

    private void b2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b2ActionPerformed
        t1.setText("");
        ans.setText("");
    }//GEN-LAST:event_b2ActionPerformed

    private void rtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rtActionPerformed
        b1.doClick();
    }//GEN-LAST:event_rtActionPerformed

   public static void main(String args[]) throws Exception {
    
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                 new Export(new DB().getCon("DB\\DB.mdb"));
                } 
                catch (Exception ex) {
                   //Logger.getLogger(DISBLAY.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ans;
    private javax.swing.JButton b1;
    private javax.swing.JButton b2;
    private javax.swing.JLabel l1;
    private javax.swing.JLabel l2;
    private javax.swing.JLabel l3;
    private javax.swing.JPanel panel1;
    private javax.swing.JPanel panel3;
    private javax.swing.JFileChooser rt;
    private javax.swing.JTextField t1;
    // End of variables declaration//GEN-END:variables
}
