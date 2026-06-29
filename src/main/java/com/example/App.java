package com.example;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            System.out.println("\n========================================");
            System.out.println(" RECORD MANAGEMENT SYSTEM");
            System.out.println("========================================");
            System.out.println("1. Add Record");
            System.out.println("2. Display All Records");
            System.out.println("3. Search Records");
            System.out.println("4. Delete Record");
            System.out.println("5. Exit");
            System.out.println("========================================");
            System.out.print("Choose an option (1-5): ");
            
            int choice = sc.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.println("\n ADD NEW RECORD");
                    System.out.println("========================================");
                    System.out.print("Enter amount: $");
                    float amount = sc.nextFloat();
                    sc.nextLine();
                    System.out.print("Enter description: ");
                    String desc = sc.nextLine();
                    addrecord.addRecord(amount, desc);
                    break;
                    
                case 2:
                    displayall.displayAllRecords();
                    break;
                    
                case 3:
                    search.searchRecords();
                    break;
                    
                case 4:
                    delete.deleteRecord();
                    break;
                    
                case 5:
                    System.out.println("\n Goodbye!");
                    sc.close();
                    System.exit(0);
                    break;
                    
                default:
                    System.out.println(" Invalid option! Please choose 1-5.");
            }
        }
    }
}