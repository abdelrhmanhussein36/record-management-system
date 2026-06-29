package com.example;

import java.io.File;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class displayall {
    
    public static void displayAllRecords() {
        try {
            ObjectMapper om = new ObjectMapper();
            File f = new File("records.json");
            
            if (!f.exists() || f.length() == 0) {
                System.out.println("📋 No records found!");
                return;
            }
            
            List<Map<String, Object>> records = om.readValue(f, new TypeReference<List<Map<String, Object>>>() {});
            
            if (records.isEmpty()) {
                System.out.println("📋 No records found!");
                return;
            }
            
            System.out.println("\n📋 ALL RECORDS");
            System.out.println("========================================");
            int count = 0;
            for (Map<String, Object> record : records) {
                System.out.println("ID: " + record.get("id"));
                System.out.println("Amount: $" + record.get("amount"));
                System.out.println("Description: " + record.get("description"));
                System.out.println("Timestamp: " + record.get("timestamp"));
                System.out.println("----------------------------------------");
                count++;
            }
            System.out.println("Total records: " + count);
            System.out.println("========================================");
            
        } catch (Exception e) {
            System.out.println("❌ Error reading file!");
            e.printStackTrace();
        }
    }
}