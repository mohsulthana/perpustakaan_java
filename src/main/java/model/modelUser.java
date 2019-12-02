/*
 * This software belong to Mohammad Sulthan. You are allowed to
 * use, copy, distributing or make it commercial for your purposes
 * as long as you don't remove this license.
 */
package model;

import controller.controllerUser;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import koneksi.koneksi;
import views.formUser;

/**
 *
 * @author muham
 */
public class modelUser implements controllerUser {

    @Override
    public void tampil(formUser user) throws SQLException {
        user.tableModel.getDataVector().removeAllElements();
        user.tableModel.fireTableDataChanged();
        
        koneksi con = new koneksi();
        Connection konek = con.getKoneksi();
        String sql = "SELECT * FROM user";
        PreparedStatement prepare = konek.prepareStatement(sql);
        ResultSet rs = prepare.executeQuery(sql);
        
        while(rs.next())
        {
            Object[] obj    = new Object[6];
            obj[0]          = rs.getString(2);
            obj[1]          = rs.getString(3);
            obj[2]          = rs.getString(4);
            obj[3]          = rs.getString(5);
            user.tableModel.addRow(obj);
        }
    }

    @Override
    public void tambah(formUser user) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
