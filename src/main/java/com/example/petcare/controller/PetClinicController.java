package com.example.petcare.controller;

import com.example.petcare.model.PetClinic;
import com.example.petcare.service.PetModelServiceInterface;

import java.util.List;
import java.util.Scanner;

public class PetClinicController{
    private PetModelServiceInterface<PetClinic> petClinicService;
    private Scanner scanner = new Scanner(System.in);

    public PetClinicController(PetModelServiceInterface<PetClinic> petClinicService) {
        this.petClinicService = petClinicService;
    }

    public PetClinic create() {
        System.out.println("Create Service");
        scanner.nextLine();
        System.out.println("Enter name: ");
        String name = scanner.nextLine();
        System.out.println("Enter price: ");
        long price = scanner.nextLong();
        scanner.nextLine();
        System.out.println("Enter description: ");
        String description = scanner.nextLine();
        PetClinic newService = new PetClinic(name, price, description);
        System.out.println("Service added");
        return petClinicService.create(newService);
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
        System.out.println("List Services");
        List<PetClinic> result = petClinicService.getAll();
        result.forEach(System.out::println);
        return result;
    }

    public PetClinic findById() {
        System.out.println("Find Service");
        System.out.println("Enter id: ");
        Long idFind = scanner.nextLong();
        PetClinic result = petClinicService.getById(idFind);
        System.out.println(result);
        return result;
    }

    public void delete() {
        System.out.println("Delete Service");
        System.out.println("Enter id: ");
        Long idDelete = scanner.nextLong();
        petClinicService.delete(idDelete);
    }
}
