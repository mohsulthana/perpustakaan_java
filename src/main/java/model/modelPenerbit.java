/*
 * This software belong to Mohammad Sulthan. You are allowed to
 * use, copy, distributing or make it commercial for your purposes
 * as long as you don't remove this license.
 */
package model;

import controller.controllerPenerbit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import koneksi.koneksi;
import views.formBuku;
import views.formPenerbit;

/**
 *
 * @author muham
 */
public class modelPenerbit implements controllerPenerbit {

    /**
     *
     * @param penerbit
     */
    @Override
    public void tampil(formPenerbit penerbit) {
        penerbit.tableModel.getDataVector().removeAllElements();
        penerbit.tableModel.getDataVector().removeAllElements();
        
        try {
            koneksi con         = new koneksi();
            Connection konek    = con.getKoneksi();
            Statement sttmnt    = konek.createStatement();
            String sql          = "SELECT * FROM penerbit";
            ResultSet rs        = sttmnt.executeQuery(sql);
            
            while(rs.next())
            {
                Object[] obj    = new Object[2];
                obj[0]          = rs.getString(1);
                obj[1]          = rs.getString(2);
                penerbit.tableModel.addRow(obj);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
    
    /**
     *
     * @param penerbit
     */
    @Override
    public void insert(formPenerbit penerbit) throws SQLException {
        koneksi con = new koneksi();
        Connection konek = con.getKoneksi();
        String sql  = "INSERT INTO penerbit (id_penerbit, nama_penerbit) VALUES (?, ?)";
        try (PreparedStatement prepare = konek.prepareStatement(sql)) {
            prepare.setString(1, null);
            prepare.setString(2, penerbit.txtPenerbit.getText());
            
            prepare.execute();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            JOptionPane.showMessageDialog(null, "Data berhasil disimpan");
            this.reset(penerbit);
            this.tampil(penerbit);
        }
    }
    
    public void reset(formPenerbit penerbit) throws SQLException {
        penerbit.txtPenerbit.setText("");
    }
}
