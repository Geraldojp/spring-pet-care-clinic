package com.example.petcare.controller;

import com.example.petcare.model.Owner;
import com.example.petcare.model.Pet;
import com.example.petcare.model.PetClinic;
import com.example.petcare.model.Sales;

import java.time.LocalDate;
import java.util.Scanner;

public class MenuController {
    private OwnerController ownerController;
    private PetController petController;
    private PetClinicController petClinicController;
    private SalesController salesController;
    private final Scanner scanner = new Scanner(System.in);

    public MenuController(OwnerController ownerController, PetController petController, PetClinicController petClinicController, SalesController salesController) {
        this.ownerController = ownerController;
        this.petController = petController;
        this.petClinicController = petClinicController;
        this.salesController = salesController;
    }

    public void mainMenu() {
        boolean exit = false;
        while (!exit) {
            System.out.println("Welcome to PetCare");
            System.out.println("1. Owners");
            System.out.println("2. Pets");
            System.out.println("3. Services");
            System.out.println("4. Transactions");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    ownerMenu();
                    break;
                case 2:
                    petMenu();
                    break;
                case 3:
                    serviceMenu();
                    break;
                case 4:
                    salesMenu();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice, only 1-5");
                    break;
            }
        }
    }

    public void ownerMenu() {
        System.out.println("Owner Menu");
        System.out.println("1. Create Owner");
        System.out.println("2. Update Owner");
        System.out.println("3. List Owners");
        System.out.println("4. Find Owner");
        System.out.println("5. Delete Owner");
        System.out.println("6. Back");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                ownerController.create();
                break;
            case 2:
                ownerController.update();
                break;
            case 3:
                ownerController.list();
                break;
            case 4:
                ownerController.findById();
                break;
            case 5:
                ownerController.delete();
                break;
            case 6:
                System.out.println("Back");
                mainMenu();
                break;
            default:
                System.out.println("Invalid choice, only 1-6");
                ownerMenu();
                break;
        }
        ownerMenu();
    }

    public void petMenu() {
        System.out.println("1. Create Pet");
        System.out.println("2. Update Pet");
        System.out.println("3. List Pets");
        System.out.println("4. Find Pet");
        System.out.println("5. Delete Pet");
        System.out.println("6. Back");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                petController.create();
                break;
            case 2:
                petController.update();
                break;
            case 3:
                petController.list();
                break;
            case 4:
                petController.findById();
                break;
            case 5:
                petController.delete();
                break;
            case 6:
                System.out.println("Back");
                mainMenu();
                break;
            default:
                System.out.println("Invalid choice");
                petMenu();
                break;
        }
        petMenu();
    }

    public void serviceMenu() {
        System.out.println("1. Create Service");
        System.out.println("2. Update Service");
        System.out.println("3. List Services");
        System.out.println("4. Find Service");
        System.out.println("5. Delete Service");
        System.out.println("6. Back");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                petClinicController.create();
                break;
            case 2:
                petClinicController.update();
                break;
            case 3:
                petClinicController.list();
                break;
            case 4:
                petClinicController.findById();
                break;
            case 5:
                petClinicController.delete();
                break;
            case 6:
                System.out.println("Back");
                mainMenu();
                break;
            default:
                System.out.println("Invalid choice");
                serviceMenu();
                break;
        }
        serviceMenu();
    }

    public void salesMenu() {
        System.out.println("1. Create Sales");
        System.out.println("2. Update Sales");
        System.out.println("3. All-time Sales");
        System.out.println("4. Daily Sales");
        System.out.println("5. Monthly Sales");
        System.out.println("6. Delete Sales");
        System.out.println("7. Back");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                salesController.create();
                break;
            case 2:
                salesController.update();
                break;
            case 3:
                salesController.getAll();
                break;
            case 4:
                salesController.getDailySales();
                break;
            case 5:
                salesController.getMonthlySales();
                break;
            case 6:
                salesController.delete();
                break;
            case 7:
                System.out.println("Back");
                mainMenu();
                break;
            default:
                System.out.println("Invalid choice");
                salesMenu();
                break;

        }
        salesMenu();
    }
}
