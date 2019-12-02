/*
 * This software belong to Mohammad Sulthan. You are allowed to
 * use, copy, distributing or make it commercial for your purposes
 * as long as you don't remove this license.
 */
package model;

import controller.controllerSiswa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import koneksi.koneksi;
import views.tabelSiswa;

/**
 *
 * @author muham
 */
public class modelSiswa implements controllerSiswa {

    @Override
    public void tampil(tabelSiswa siswa) throws SQLException {
        siswa.tableModel.getDataVector().removeAllElements();
        siswa.tableModel.fireTableDataChanged();
    
        koneksi con = new koneksi();
        Connection konek = con.getKoneksi();
        String sql = "SELECT * FROM siswa";
        PreparedStatement sttmnt = konek.prepareStatement(sql);
        ResultSet rs = sttmnt.executeQuery(sql);
        
        while(rs.next())
        {
            Object[] obj    = new Object[6];
            obj[0]          = rs.getString(2);
            obj[1]          = rs.getString(3);
            obj[2]          = rs.getString(4);
            obj[3]          = rs.getString(5);
            obj[4]          = rs.getString(6);
            siswa.tableModel.addRow(obj);
        }
    }

    @Override
    public void arsipkan(tabelSiswa siswa) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
