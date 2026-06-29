package com.example;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class search {
    
    public static void searchRecords() {
        try {
            File f = new File("records.json");
            
            if (!f.exists()) {
                System.out.println("❌ No records found!");
                return;
            }
            
            Scanner sc = new Scanner(System.in);
            System.out.print("\n🔍 Enter keyword to search in description: ");
            String keyword = sc.nextLine();
            
            searchByDescription(keyword);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void searchByDescription(String keyword) {
        try {
            ObjectMapper om = new ObjectMapper();
            File f = new File("records.json");
            
            if (!f.exists() || f.length() == 0) {
                System.out.println("❌ No records found!");
                return;
            }
            
            List<Map<String, Object>> records = om.readValue(f, new TypeReference<List<Map<String, Object>>>() {});
            
            boolean found = false;
            int count = 0;
            
            System.out.println("\n🔍 SEARCH RESULTS for '" + keyword + "'");
            System.out.println("========================================");
            
            for (Map<String, Object> record : records) {
                String description = record.get("description").toString().toLowerCase();
                
                if (description.contains(keyword.toLowerCase())) {
                    found = true;
                    count++;
                    System.out.println("Result #" + count);
                    System.out.println("ID: " + record.get("id"));
                    System.out.println("Amount: $" + record.get("amount"));
                    System.out.println("Description: " + record.get("description"));
                    System.out.println("Timestamp: " + record.get("timestamp"));
                    System.out.println("----------------------------------------");
                }
            }
            
            if (!found) {
                System.out.println("❌ No records found with description containing: '" + keyword + "'");
            } else {
                System.out.println("✅ Total results found: " + count);
            }
            System.out.println("========================================");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}