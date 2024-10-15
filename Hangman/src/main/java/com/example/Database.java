package com.example;

import java.sql.*;

public class Database {
    private static final String URL = "jdbc:mysql://localhost:3306";
    private static final String USER = "root";
    private static final String PASSWORD = "426999";

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static String getWord(String difficulty) {
        try (Connection conn = connect()) {
            String query = "SELECT word From words WHERE difficulty = '" + difficulty + "' ORDER BY RANDOM() LIMIT 1";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                return rs.getString("word");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;

    }
}
