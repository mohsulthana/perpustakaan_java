/*
 * This software belong to Mohammad Sulthan. You are allowed to
 * use, copy, distributing or make it commercial for your purposes
 * as long as you don't remove this license.
 */
package koneksi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author muham
 */
public class koneksi {
    
    private Connection con;
    
        public Connection getKoneksi() {
        if (con == null) {
            try {
                String url      = "jdbc:mysql://localhost/perpustakaan_java?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
                String user     = "root";
                String password = "";
                
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                con = DriverManager.getConnection(url, user, password);
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
        return con;
    }
}
