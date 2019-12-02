/*
 * This software belong to Mohammad Sulthan. You are allowed to
 * use, copy, distributing or make it commercial for your purposes
 * as long as you don't remove this license.
 */
package views;

import java.awt.Component;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import model.modelSiswa;

/**
 *
 * @author muham
 */
public final class tabelSiswa extends javax.swing.JFrame {

    public DefaultTableModel tableModel;
    String header[] = {"Nama Siswa", "NISN", "Tampat Lahir", "Tanggal Lahir", "Alamat"};
    modelSiswa model = new modelSiswa();
    
    public tabelSiswa() throws SQLException {
        initComponents();
        tableModel      = new DefaultTableModel(null, header);
        tabel.setModel(tableModel);
        tabel.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        model.tampil(this);
        setLebarKolom();
    }
    
    
    public void setLebarKolom() {
        for (int a = 0; a < tabel.getColumnCount(); a++) {
            setColumnWidth(a);
        }
    }
    
    public void setColumnWidth(int kolom) {
      DefaultTableColumnModel dtcm = (DefaultTableColumnModel) tabel.
                            getColumnModel();
      TableColumn kolomtabel = dtcm.getColumn(kolom);
      int lebar = 0;
      int margin = 10;
      int a;
      
      TableCellRenderer renderer = kolomtabel.getHeaderRenderer();
      if (renderer ==null){
          renderer = tabel.getTableHeader().getDefaultRenderer();
      }
      Component komponen = renderer.getTableCellRendererComponent(tabel, 
                        kolomtabel.getHeaderValue(), false, false, 0, 0);
      lebar = komponen.getPreferredSize().width;
      for (a = 0; a< tabel.getRowCount(); a++){
          renderer = tabel.getCellRenderer(a, kolom);
          komponen = renderer.getTableCellRendererComponent(tabel, 
                  tabel.getValueAt(a, kolom), false, false, a, kolom);
          int lebarKolom = komponen.getPreferredSize().width;
          lebar = Math.max(lebar, lebarKolom);
      }
      lebar = lebar + margin;
      kolomtabel.setPreferredWidth(lebar);
  }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabel);

        jLabel1.setText("Daftar Siswa");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(159, 159, 159)
                .addComponent(jLabel1)
                .addContainerGap(179, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(38, 38, 38)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(101, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(tabelSiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tabelSiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tabelSiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tabelSiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new tabelSiswa().setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(tabelSiswa.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabel;
    // End of variables declaration//GEN-END:variables
}