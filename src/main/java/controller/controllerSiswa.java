/*
 * This software belong to Mohammad Sulthan. You are allowed to
 * use, copy, distributing or make it commercial for your purposes
 * as long as you don't remove this license.
 */
package controller;

import java.sql.SQLException;
import views.tabelSiswa;

/**
 *
 * @author muham
 */
public interface controllerSiswa {
    public void tampil(tabelSiswa siswa) throws SQLException;
    public void arsipkan(tabelSiswa siswa) throws SQLException;
}
