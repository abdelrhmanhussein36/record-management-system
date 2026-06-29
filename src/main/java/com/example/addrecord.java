package com.example;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.core.type.TypeReference;

public class addrecord {
    private static int id = 1;
    private static final String FILE_NAME = "records.json";
    
    public static void addRecord(float amount, String description) {
        try {
            ObjectMapper om = new ObjectMapper();
            om.enable(SerializationFeature.INDENT_OUTPUT);
            
            File f = new File(FILE_NAME);
            
            // Read existing records
            List<Map<String, Object>> records = new ArrayList<>();
            if (f.exists() && f.length() > 0) {
                records = om.readValue(f, new TypeReference<List<Map<String, Object>>>() {});
                
                // Find max ID
                for (Map<String, Object> record : records) {
                    int currentId = (int) record.get("id");
                    if (currentId >= id) {
                        id = currentId + 1;
                    }
                }
            }
            
            // Create new record
            int newid = id++;
            Map<String, Object> record = new HashMap<>();
            record.put("id", newid);
            record.put("amount", amount);
            record.put("description", description);
            record.put("timestamp", System.currentTimeMillis());
            
            // Add to list and save
            records.add(record);
            om.writeValue(f, records);
            
            System.out.println("✅ Record added with ID: " + newid);
            
        } catch (Exception e) {
            System.out.println("❌ Error adding record!");
            e.printStackTrace();
        }
    }
}