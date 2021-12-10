package database;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.YES_NO_CANCEL_OPTION;
import static javax.swing.JOptionPane.YES_OPTION;


class DB
{
    
    Connection con=null;

    DB() throws Exception
    {
      con=getCon("DB\\DB.mdb");
    }
      
    Connection getCon(String msAccessDBName) throws Exception
    {
      String driver="sun.jdbc.odbc.JdbcOdbcDriver"; 
                
      String URL= "jdbc:odbc:Driver=" 
                + "{Microsoft Access Driver (*.mdb, *.accdb)};" 
                + "DBQ="+ msAccessDBName  
              /*+ ";DriverID=22;READONLY=true"*/;
          
        Class.forName(driver); 
        return DriverManager.getConnection(URL);
          
    }

}


public class GUI extends javax.swing.JFrame {


    public GUI() {
        initComponents();
        
        this.setTitle("Movie Rental Application");
        this.getContentPane().setBackground(Color.LIGHT_GRAY);
        
        //Center in screen
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width/2-getSize().width/2, dim.height/2-getSize().height/2);
        
        addWindowListener(new WindowAdapter()
        {
        @Override
        public void windowOpened(WindowEvent we) {
        setIconImage( new ImageIcon("src/icons/p.png").getImage()); 
        JOptionPane.showMessageDialog(null, "Enjoy use Movie Rental Application","welcome to my program ;) ",1,new ImageIcon("src/icons/7.png")); }

        @Override
        public void windowClosing(WindowEvent we)
        {
        exit.doClick();
        }

        @Override
        public void windowClosed(WindowEvent we) { JOptionPane.showMessageDialog(null, "thank you for use my program ;) ","good bye",1,new ImageIcon("src/icons/7.png")); 
        System.exit(0); }
        
        @Override
        public void windowIconified(WindowEvent we) { setIconImage( new ImageIcon("src/icons/pl.png").getImage()); }

        @Override
        public void windowDeiconified(WindowEvent we) { setIconImage( new ImageIcon("src/icons/p.png").getImage()); }
        
        });
          
        this.setResizable(false);
        this.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bar = new javax.swing.JMenuBar();
        file = new javax.swing.JMenu();
        imporT = new javax.swing.JMenuItem();
        export = new javax.swing.JMenuItem();
        exit = new javax.swing.JMenuItem();
        operations = new javax.swing.JMenu();
        Add_video = new javax.swing.JMenuItem();
        Search_video = new javax.swing.JMenuItem();
        Delete_video = new javax.swing.JMenuItem();
        rent_video = new javax.swing.JMenuItem();
        return_video = new javax.swing.JMenuItem();
        search_customer = new javax.swing.JMenuItem();
        display_all = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                formFocusLost(evt);
            }
        });

        bar.setBackground(new java.awt.Color(255, 204, 204));

        file.setForeground(new java.awt.Color(0, 153, 153));
        file.setMnemonic('f');
        file.setText("File");
        file.setToolTipText("Import , Export , Exit");

        imporT.setForeground(new java.awt.Color(51, 204, 0));
        imporT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/imp.png"))); // NOI18N
        imporT.setMnemonic('i');
        imporT.setText("Import");
        imporT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imporTActionPerformed(evt);
            }
        });
        file.add(imporT);

        export.setForeground(new java.awt.Color(51, 51, 255));
        export.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/exp.png"))); // NOI18N
        export.setMnemonic('e');
        export.setText("Export");
        export.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportActionPerformed(evt);
            }
        });
        file.add(export);

        exit.setForeground(new java.awt.Color(255, 51, 51));
        exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/can1.png"))); // NOI18N
        exit.setMnemonic('x');
        exit.setText("Exit");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        file.add(exit);

        bar.add(file);

        operations.setForeground(new java.awt.Color(0, 153, 153));
        operations.setMnemonic('o');
        operations.setText("Operations");
        operations.setPreferredSize(new java.awt.Dimension(80, 24));

        Add_video.setForeground(new java.awt.Color(0, 204, 153));
        Add_video.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/addv.png"))); // NOI18N
        Add_video.setText("Add a new video");
        Add_video.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Add_videoActionPerformed(evt);
            }
        });
        operations.add(Add_video);

        Search_video.setForeground(new java.awt.Color(51, 51, 255));
        Search_video.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/sv.png"))); // NOI18N
        Search_video.setText("Search for a video");
        Search_video.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Search_videoActionPerformed(evt);
            }
        });
        operations.add(Search_video);

        Delete_video.setForeground(new java.awt.Color(255, 51, 51));
        Delete_video.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/dv.png"))); // NOI18N
        Delete_video.setText("Delete a video");
        Delete_video.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Delete_videoActionPerformed(evt);
            }
        });
        operations.add(Delete_video);

        rent_video.setForeground(new java.awt.Color(102, 102, 0));
        rent_video.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/rv.png"))); // NOI18N
        rent_video.setText("rent a video");
        rent_video.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rent_videoActionPerformed(evt);
            }
        });
        operations.add(rent_video);

        return_video.setForeground(new java.awt.Color(204, 204, 0));
        return_video.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/rvv.png"))); // NOI18N
        return_video.setText("return a video");
        return_video.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                return_videoActionPerformed(evt);
            }
        });
        operations.add(return_video);

        search_customer.setForeground(new java.awt.Color(153, 153, 153));
        search_customer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/ss.png"))); // NOI18N
        search_customer.setText("search for a customer");
        search_customer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_customerActionPerformed(evt);
            }
        });
        operations.add(search_customer);

        display_all.setForeground(new java.awt.Color(204, 0, 204));
        display_all.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/da.png"))); // NOI18N
        display_all.setText("Display All");
        display_all.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                display_allActionPerformed(evt);
            }
        });
        operations.add(display_all);

        bar.add(operations);

        setJMenuBar(bar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 900, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 609, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        int ans=JOptionPane.showConfirmDialog(null,"Do you want to exit","Exit",YES_NO_CANCEL_OPTION,1,new ImageIcon("src/icons/can.png"));
        if (ans==YES_OPTION )dispose();
    }//GEN-LAST:event_exitActionPerformed

    private void Add_videoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Add_videoActionPerformed

        try {
            new ADD(new DB().con);
        }

        catch (Exception ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Add_videoActionPerformed

    private void display_allActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_display_allActionPerformed

        try {
            new DISBLAY(new DB().con);
        }

        catch (Exception ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_display_allActionPerformed

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
       setIconImage( new ImageIcon("src/icons/p.png").getImage()); 
    }//GEN-LAST:event_formFocusGained

    private void formFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusLost
        setIconImage( new ImageIcon("src/icons/p2.png").getImage());
    }//GEN-LAST:event_formFocusLost

    private void Search_videoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Search_videoActionPerformed
               try {
            new SVedio(new DB().con);
        }

        catch (Exception ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Search_videoActionPerformed

    private void Delete_videoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Delete_videoActionPerformed
        try {
            new DVedio(new DB().con);
        }

        catch (Exception ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Delete_videoActionPerformed

    private void rent_videoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rent_videoActionPerformed
      try {
            new RentVedio(new DB().con);
        }

        catch (Exception ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_rent_videoActionPerformed

    private void return_videoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_return_videoActionPerformed
           try {
            new ReturnVedio(new DB().con);
        }

        catch (Exception ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_return_videoActionPerformed

    private void search_customerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_customerActionPerformed
          try {
            new SCustomer(new DB().con);
        }

        catch (Exception ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_search_customerActionPerformed

    private void imporTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imporTActionPerformed
    try {
            new Import(new DB().con);
        }

        catch (Exception ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_imporTActionPerformed

    private void exportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportActionPerformed
       try {
            new Export(new DB().con);
        }

        catch (Exception ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }//GEN-LAST:event_exportActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Add_video;
    private javax.swing.JMenuItem Delete_video;
    private javax.swing.JMenuItem Search_video;
    private javax.swing.JMenuBar bar;
    private javax.swing.JMenuItem display_all;
    private javax.swing.JMenuItem exit;
    private javax.swing.JMenuItem export;
    private javax.swing.JMenu file;
    private javax.swing.JMenuItem imporT;
    private javax.swing.JMenu operations;
    private javax.swing.JMenuItem rent_video;
    private javax.swing.JMenuItem return_video;
    private javax.swing.JMenuItem search_customer;
    // End of variables declaration//GEN-END:variables
}
