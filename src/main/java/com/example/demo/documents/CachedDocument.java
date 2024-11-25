package com.example.demo.documents;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

@AllArgsConstructor
public class CachedDocument implements Document {
    private final Document wrappedDocument;
    private final String dbPath;

    @SneakyThrows
    private Connection connectToDb() {
        return DriverManager.getConnection("jdbc:sqlite:" + dbPath);
    }

    @Override
    @SneakyThrows
    public String parse() {
        String gcsPath = ((SmartDocument) wrappedDocument).gcsPath;

        try (Connection conn = connectToDb();
             PreparedStatement stmt = conn.prepareStatement("SELECT parsed_text FROM document_cache WHERE gcs_path = ?")) {
            stmt.setString(1, gcsPath);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                System.out.println("Cache hit: Returning cached result.");
                return rs.getString("parsed_text");
            }
        }

        System.out.println("Cache miss: Parsing using Google Cloud Vision.");
        String parsedText = wrappedDocument.parse();

        try (Connection conn = connectToDb();
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO document_cache (gcs_path, parsed_text) VALUES (?, ?)")) {
            stmt.setString(1, gcsPath);
            stmt.setString(2, parsedText);
            stmt.executeUpdate();
        }

        return parsedText;
    }
}
