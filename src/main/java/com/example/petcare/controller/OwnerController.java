package com.example.petcare.controller;

import com.example.petcare.model.Owner;
import com.example.petcare.service.OwnerServiceInterface;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class OwnerController {
    private final OwnerServiceInterface ownerService;
    private final Scanner scanner = new Scanner(System.in);

    public OwnerController(OwnerServiceInterface ownerService) {
        this.ownerService = ownerService;
    }


    public Owner create() {
        System.out.println("Create Owner");
        scanner.nextLine();
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        while (name.isEmpty() || name.length() < 3) {
            System.out.println("Name must be at least 3 characters long");
            System.out.print("Enter name: ");
            name = scanner.nextLine();
        }
        System.out.print("Enter address: ");
        String address = scanner.nextLine();
        while (address.length() < 5) {
            System.out.println("Address must be at least 3 characters long");
            System.out.print("Enter address: ");
            address = scanner.nextLine();
        }
        System.out.print("Enter city: ");
        String city = scanner.nextLine();
        while (city.isEmpty() || city.length() < 4) {
            System.out.println("City must be at least 4 characters long");
            System.out.print("Enter city: ");
            city = scanner.nextLine();
        }
        System.out.print("Enter telephone: ");
        String telephone = scanner.nextLine();
        while (telephone.isEmpty() || telephone.matches("^08\\d{8}$") == false) {
            System.out.println("Telephone must be 10 digits and start with 08");
            System.out.print("Enter telephone: ");
            telephone = scanner.nextLine();
        }
        Owner newOwner = new Owner(name, address, city, telephone);
        System.out.println("Owner added");
        return ownerService.create(newOwner);
    }


    public Owner update() {
        System.out.println("Update Owner");
        System.out.print("Enter id: ");
        Long id = scanner.nextLong();
        System.out.print("Enter name: " + scanner.nextLine());
        String nameUpdate = scanner.nextLine();
        System.out.print("Enter address: ");
        String addressUpdate = scanner.nextLine();
        System.out.print("Enter city: ");
        String cityUpdate = scanner.nextLine();
        System.out.print("Enter telephone: " + scanner.nextLine());
        String telephoneUpdate = scanner.nextLine();
        Owner ownerUpdate = new Owner(nameUpdate, addressUpdate, cityUpdate, telephoneUpdate);
        System.out.println("Owner with id of: " + id + " updated");
        return ownerService.update(ownerUpdate, id);
    }


    public List<Owner> list() {
        while (true){
            try {
                System.out.println("List Owners");
                List<Owner> listOwner = ownerService.getAll();
                if (listOwner.isEmpty()) {
                    System.out.println("No owner found");
                    continue;
                }
                listOwner.forEach(System.out::println);
                return listOwner;
            }catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                break;
            }
        }
        return null;
    }


    public void findById() {
        while (true) {
            try {
                System.out.println("Find Owner By Id");
                System.out.print("Enter id: ");
                Long idFind = scanner.nextLong();
                if (!idFind.toString().matches("^\\d+$")) {
                    System.out.println("Id must be a number");
                    System.out.print("Enter id: ");
                    idFind = scanner.nextLong();
                    continue;
                }
                Owner result = ownerService.getById(idFind);
                System.out.println(result);
            } catch (InputMismatchException e) {
                System.out.println("Id must be a number");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Error");
                break;
            }
        }
    }


    public void delete() {
        while (true){
            try {
                System.out.println("Delete Owner");
                System.out.print("Enter id: ");
                Long idDelete = scanner.nextLong();
                if (!idDelete.toString().matches("^\\d+$")) {
                    System.out.println("Id must be a number");
                    System.out.print("Enter id: ");
                    idDelete = scanner.nextLong();
                    continue;
                }
                if (ownerService.getById(idDelete) == null) {
                    System.out.println("Owner with id of: " + idDelete + " not found");
                    continue;
                }
                ownerService.delete(idDelete);
            }catch (InputMismatchException e){
                System.out.println("Id must be a number");
                scanner.nextLine();
            }catch (Exception e){
                System.out.println("Error: " + e.getMessage());
                break;
            }
        }
    }
}
