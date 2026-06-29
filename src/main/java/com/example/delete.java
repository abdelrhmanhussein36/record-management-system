package com.example;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class delete {
    
    public static void deleteRecord() {
        try {
            ObjectMapper om = new ObjectMapper();
            File f = new File("records.json");
            
            if (!f.exists() || f.length() == 0) {
                System.out.println("❌ No records found!");
                return;
            }
            
            System.out.println("\n📋 CURRENT RECORDS:");
            System.out.println("========================================");
            displayall.displayAllRecords();
            
            Scanner sc = new Scanner(System.in);
            System.out.print("\n🗑️ Enter ID of record to delete: ");
            int id = sc.nextInt();
            
            List<Map<String, Object>> records = om.readValue(f, new TypeReference<List<Map<String, Object>>>() {});
            
            boolean found = false;
            List<Map<String, Object>> updatedRecords = new ArrayList<>();
            
            for (Map<String, Object> record : records) {
                int currentId = (int) record.get("id");
                
                if (currentId == id) {
                    found = true;
                    System.out.println("\n🗑️ Deleting record with ID: " + id);
                    System.out.println("   Amount: $" + record.get("amount"));
                    System.out.println("   Description: " + record.get("description"));
                    System.out.println("   Timestamp: " + record.get("timestamp"));
                } else {
                    updatedRecords.add(record);
                }
            }
            
            if (!found) {
                System.out.println("❌ Record with ID " + id + " not found!");
                return;
            }
            
            System.out.print("\nAre you sure you want to delete this record? (y/n): ");
            String confirm = sc.next();
            
            if (!confirm.equalsIgnoreCase("y")) {
                System.out.println("❌ Deletion cancelled!");
                return;
            }
            
            om.writeValue(f, updatedRecords);
            
            System.out.println("✅ Record with ID " + id + " deleted successfully!");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}