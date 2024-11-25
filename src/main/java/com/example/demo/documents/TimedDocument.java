package com.example.demo.documents;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TimedDocument implements Document {
    private final Document wrappedDocument;

    @Override
    public String parse() {
        long startTime = System.nanoTime();
        String result = wrappedDocument.parse();
        long endTime = System.nanoTime();

        long durationInMillis = (endTime - startTime) / 1_000_000;
        System.out.println("Parsing took: " + durationInMillis + " ms");

        return result;
    }
}
