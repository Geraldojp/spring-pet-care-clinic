package com.example.petcare.controller;

import com.example.petcare.model.Owner;
import com.example.petcare.model.Pet;
import com.example.petcare.service.PetModelServiceInterface;

import java.util.List;
import java.util.Scanner;

public class OwnerController {
    private final PetModelServiceInterface<Owner> ownerService;
    private final Scanner scanner = new Scanner(System.in);

    public OwnerController(PetModelServiceInterface<Owner> ownerService) {
        this.ownerService = ownerService;
    }



    public Owner create() {
        System.out.println("Create Owner");
        scanner.nextLine();
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter address: ");
        String address = scanner.nextLine();
        System.out.print("Enter city: ");
        String city = scanner.nextLine();
        System.out.print("Enter telephone: ");
        String telephone = scanner.nextLine();
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
        System.out.println("List Owners");
        List<Owner> listOwner = ownerService.getAll();
        listOwner.forEach(System.out::println);
        return listOwner;
    }


    public Owner findById() {
        System.out.println("Find Owner By Id");
        System.out.print("Enter id: ");
        Long idFind = scanner.nextLong();
        Owner result = ownerService.getById(idFind);
        System.out.println(result);
        return result;
    }


    public void delete() {
        System.out.println("Delete Owner");
        System.out.print("Enter id: ");
        Long idDelete = scanner.nextLong();
        ownerService.delete(idDelete);
        System.out.println("Owner with id of: " + idDelete + " deleted");
    }
}
