package database;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.YES_NO_CANCEL_OPTION;
import static javax.swing.JOptionPane.YES_OPTION;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class SCustomer extends javax.swing.JFrame {
    
    public static void setCellsAlignment(JTable table, int alignment)
    {
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(alignment);

        TableModel tableModel = table.getModel();

        for (int columnIndex = 0; columnIndex < tableModel.getColumnCount(); columnIndex++)
        {
            table.getColumnModel().getColumn(columnIndex).setCellRenderer(rightRenderer);
        }
    }

    Connection con=null;
    Statement stat=null;
    ResultSet  rs=null;
    
    DefaultTableModel d;
    
    boolean b;

 
    public SCustomer(Connection c) throws SQLException {
        initComponents();
        
        this.setTitle("search for a customer");
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
        
        d = new DefaultTableModel();
        t1.setModel(d);
        d.addColumn("Movie Name");
        d.addColumn("Length");
        d.addColumn("Rated");
        d.addColumn("Date released");
        d.addColumn("Rented to");
        d.addColumn("Date of rental");
        d.addColumn("Date of return");
        
        dos();
        
    }
    
    public void dos() throws SQLException
    {
        
      d.getDataVector().removeAllElements();
      
      if(t.getText().isEmpty())
      {
        if(b)JOptionPane.showMessageDialog(null, "Empty : no input to search","result  ",1,new ImageIcon("src/icons/20.png")); 
        else b=true;
        return;   
      }
        
      rs = stat.executeQuery("select * from movei where RentedTo ='"+t.getText()+"';");
      
      int count=0;
      
      while(rs.next())
      {
            
        String []g={ 
            rs.getString(1) 
           ,rs.getString(2)
           ,rs.getString(3)
           ,rs.getString(4) 
           ,rs.getString(5)  
           ,rs.getString(6) 
           ,rs.getString(7)
        };

        d.addRow(g);
        
        count++;
           
        }  
      
       rs.close();
       
      if(count == 0){
          JOptionPane.showMessageDialog(null, "Not Found : the movie is not exist","result  ",1,new ImageIcon("src/icons/20.png")); return;
      }
            
      DISBLAY.setCellsAlignment(t1, SwingConstants.CENTER);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new javax.swing.JPanel();
        l1 = new javax.swing.JLabel();
        t = new javax.swing.JTextField();
        panel2 = new javax.swing.JPanel();
        b1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        t1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        panel1.setBackground(new java.awt.Color(255, 153, 153));
        panel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 153), 3, true));
        panel1.setPreferredSize(new java.awt.Dimension(1026, 100));

        l1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        l1.setForeground(new java.awt.Color(51, 102, 0));
        l1.setText("Please Enter Name of Customer To Search : ");

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
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(l1)
                .addGap(40, 40, 40)
                .addComponent(t, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addComponent(l1)
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addComponent(t, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13))))
        );

        panel2.setBackground(new java.awt.Color(153, 153, 255));
        panel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 0), 3, true));

        b1.setBackground(new java.awt.Color(255, 204, 204));
        b1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        b1.setForeground(new java.awt.Color(51, 102, 0));
        b1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/vg.png"))); // NOI18N
        b1.setMnemonic('R');
        b1.setText("Search");
        b1.setToolTipText("get last  data update");
        b1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b1b1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                .addContainerGap(488, Short.MAX_VALUE)
                .addComponent(b1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(488, 488, 488))
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(b1)
                .addGap(7, 7, 7))
        );

        t1.setBackground(new java.awt.Color(204, 204, 204));
        t1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 153), 2, true));
        t1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        t1.setForeground(new java.awt.Color(255, 102, 102));
        t1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(t1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1104, Short.MAX_VALUE)
                .addGap(5, 5, 5))
            .addComponent(panel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
                .addGap(3, 3, 3)
                .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tActionPerformed
        b1.doClick();
    }//GEN-LAST:event_tActionPerformed

    private void b1b1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b1b1ActionPerformed

        d.setRowCount(0);
        try {
            dos();
        }
        catch (SQLException ex) {
            Logger.getLogger(DISBLAY.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_b1b1ActionPerformed

    public static void main(String args[]) throws Exception {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                try {
                    new SCustomer(new DB().getCon("DB\\DB.mdb"));
                } 
                
                catch (Exception ex) {
                    Logger.getLogger(SCustomer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel l1;
    private javax.swing.JPanel panel1;
    private javax.swing.JPanel panel2;
    private javax.swing.JTextField t;
    private javax.swing.JTable t1;
    // End of variables declaration//GEN-END:variables
}
