package net.ianboy10.essenssystem;

import org.bukkit.Bukkit;

import javax.xml.transform.Result;
import java.sql.*;

public class MySQL {
    public static String host;
    public static String port;
    public static String database;
    public static String username;
    public static String password;
    private static Connection con;

    public static void connect() {
        if(!isConnected()) {
            try {
                con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database, username, password);
                Bukkit.getConsoleSender().sendMessage("§a[Essenssystem] §aDie Verbindung zur MySQL-Datenbank wurde hergestellt!");

                con.createStatement().executeUpdate("CREATE TABLE IF NOT EXISTS essen(id int AUTO_INCREMENT, uuid VARCHAR(100), fett int(100), muskeln int(100), PRIMARY KEY(id))");
            } catch (SQLException e) {
                Bukkit.getConsoleSender().sendMessage("§c[Essenssystem] §4Die Verbindung zur MySQL-Datenbank konnte nicht hergestellt werden!");
            }
        }
    }

    public static void close() {
        if(isConnected()) {
            try {
                con.close();
                Bukkit.getConsoleSender().sendMessage("§a[Essenssystem] §aDie Verbindung zur MySQL-Datenbank wurde geschlossen!");
            } catch (SQLException e) {
                Bukkit.getConsoleSender().sendMessage("§c[Essenssystem] §4Die Verbindung zur MySQL-Datenbank konnte nicht geschlossen werden!");
            }
        }
    }

    public static boolean isConnected() {
        return con != null;
    }

    public static void update(String qry) {
        if(isConnected()) {
            try {
                con.createStatement().executeUpdate(qry);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static ResultSet getResult(String qry) {
        if (isConnected()) {
            try {
                Statement statement = con.createStatement();
                ResultSet resultSet = statement.executeQuery(qry);
                return resultSet;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }
}
