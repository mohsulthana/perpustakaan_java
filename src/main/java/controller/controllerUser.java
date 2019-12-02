/*
 * This software belong to Mohammad Sulthan. You are allowed to
 * use, copy, distributing or make it commercial for your purposes
 * as long as you don't remove this license.
 */
package controller;

import java.sql.SQLException;
import views.formUser;

/**
 *
 * @author muham
 */
public interface controllerUser {
    public void tampil(formUser user) throws SQLException;
    public void tambah(formUser user) throws SQLException;
}
