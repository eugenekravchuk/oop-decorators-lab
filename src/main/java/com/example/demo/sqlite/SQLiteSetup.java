package com.example.demo.sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class SQLiteSetup {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:document_cache.db";

        // SQL statement for creating a new table
        String createTableSQL = "CREATE TABLE IF NOT EXISTS document_cache (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "gcs_path TEXT NOT NULL, " +
                "parsed_text TEXT, " +
                "timestamp DATETIME DEFAULT CURRENT_TIMESTAMP" +
                ");";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            // Create table
            stmt.execute(createTableSQL);
            System.out.println("Table created successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
