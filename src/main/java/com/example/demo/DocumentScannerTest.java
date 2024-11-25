package com.example.demo;

import java.io.FileInputStream;

import com.example.demo.documents.CachedDocument;
import com.example.demo.documents.Document;
import com.example.demo.documents.SmartDocument;
import com.example.demo.documents.TimedDocument;
import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.vision.v1.ImageAnnotatorClient;
import com.google.cloud.vision.v1.ImageAnnotatorSettings;

public class DocumentScannerTest {
    public static void main(String[] args) {
        try {
            GoogleCredentials credentials = GoogleCredentials.fromStream(new FileInputStream("C:/D/UCU/OOP/Flower/decorators/credentials.json"))
                .createScoped("https://www.googleapis.com/auth/cloud-platform");

            ImageAnnotatorSettings settings = ImageAnnotatorSettings.newBuilder()
                .setCredentialsProvider(FixedCredentialsProvider.create(credentials))
                .build();

            try (ImageAnnotatorClient client = ImageAnnotatorClient.create(settings)) {
                System.out.println("Vision API Client initialized successfully.");
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        String dbPath = "document_cache.db";
        String gcsPath = "gs://decorator-photos-java/lays_chips.jpg";
        Document combinedDoc = new TimedDocument(new CachedDocument(new SmartDocument(gcsPath), dbPath));
        System.out.println("Parsed content: \n" + combinedDoc.parse());

    }
}