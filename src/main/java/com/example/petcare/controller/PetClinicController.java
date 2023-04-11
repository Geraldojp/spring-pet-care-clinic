package com.example.petcare.controller;

import com.example.petcare.model.PetClinic;
import com.example.petcare.service.PetClinicServiceInterface;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class PetClinicController {
    private PetClinicServiceInterface petClinicService;
    private Scanner scanner = new Scanner(System.in);

    public PetClinicController(PetClinicServiceInterface petClinicService) {
        this.petClinicService = petClinicService;
    }

    public PetClinic create() {
        while (true) {
            try {
                System.out.println("Create Service");
                System.out.println("Enter name: ");
                String name = scanner.nextLine();
                if (name.isEmpty() || name.length() < 3) {
                    System.out.println("Name must be at least 3 characters long");
                    continue;
                }
                System.out.println("Enter price: ");
                Long price = scanner.nextLong();
                if (price >= 0 && !price.toString().matches("^\\d+$")) {
                    System.out.println("Price posotive number");
                    continue;
                }
                scanner.nextLine();
                System.out.println("Enter description: ");
                String description = scanner.nextLine();
                if (description.isEmpty() || description.length() < 5) {
                    System.out.println("Description must be at least 5 characters long");
                    continue;
                }
                PetClinic newService = new PetClinic(name, price, description);
                System.out.println("Service added");
                return petClinicService.create(newService);
            } catch (InputMismatchException e) {
                System.out.println("Invalid input");
                break;
            } catch (Exception e) {
                System.out.println("Something went wrong");
                break;
            }
        }
        return null;
    }

    public PetClinic update() {
        System.out.println("Update Service");
        scanner.nextLine();
        System.out.println("Enter id: ");
        Long id = scanner.nextLong();
        System.out.println("Enter name: ");
        String nameUpdate = scanner.nextLine();
        System.out.println("Enter price: ");
        long priceUpdate = scanner.nextLong();
        System.out.println("Enter description: ");
        String descriptionUpdate = scanner.nextLine();
        PetClinic updateService = new PetClinic(nameUpdate, priceUpdate, descriptionUpdate);
        return petClinicService.update(updateService, id);
    }

    public List<PetClinic> list() {
        while (true) {
            try {
                System.out.println("List Services");
                List<PetClinic> result = petClinicService.getAll();
                if (result.isEmpty()) {
                    System.out.println("No services");
                    continue;
                }
                result.forEach(System.out::println);
                return result;
            } catch (Exception e) {
                System.out.println("Database empty");
                break;
            }
        }
        return null;
    }

    public void findById() {
        while (true) {
            try {
                System.out.println("Find Service");
                System.out.println("Enter id: ");
                Long idFind = scanner.nextLong();
                if (!idFind.toString().matches("^\\d+$")) {
                    System.out.println("id must be a number");
                    System.out.println("Enter id: ");
                    idFind = scanner.nextLong();
                    continue;
                }
                PetClinic result = petClinicService.getById(idFind);
                System.out.println(result);
            } catch (InputMismatchException e) {
                System.out.println("Id must be a number");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                break;
            }
        }
    }

    public void delete() {
        while (true) {
            try {
                System.out.println("Delete Service");
                System.out.println("Enter id: ");
                Long idDelete = scanner.nextLong();
                if (idDelete == null) {
                    System.out.println("Id cannot be null");
                    continue;
                }
                if (!idDelete.toString().matches("^\\d+$")) {
                    System.out.println("id must be a number");
                    continue;
                }
                petClinicService.delete(idDelete);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
