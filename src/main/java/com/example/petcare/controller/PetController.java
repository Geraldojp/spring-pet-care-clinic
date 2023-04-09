package com.example.petcare.controller;

import com.example.petcare.model.Pet;
import com.example.petcare.service.PetModelServiceInterface;
import com.example.petcare.service.PetService;

import java.util.List;
import java.util.Scanner;

public class PetController{
    private PetModelServiceInterface<Pet> petService;
    private Scanner scanner = new Scanner(System.in);

    public PetController(PetModelServiceInterface<Pet> petService) {
        this.petService = petService;
    }

    public Pet create() {
        System.out.println("Create Pet");
        scanner.nextLine();
        System.out.println("Enter name: ");
        String name = scanner.nextLine();
        System.out.println("Enter type: ");
        String type = scanner.nextLine();
        System.out.println("Enter breed: ");
        String breed = scanner.nextLine();
        System.out.println("Enter color: ");
        String color = scanner.nextLine();
        System.out.println("Enter owner id: ");
        Long ownerId = scanner.nextLong();
        Pet newPet = new Pet(name, type, breed, color, ownerId);
        System.out.println("Pet added");
        return petService.create(newPet);
    }

    public Pet update() {
        System.out.println("Update Pet");
        scanner.nextLine();
        System.out.println("Enter id: ");
        Long idUpdate = scanner.nextLong();
        System.out.println("Enter name: ");
        String nameUpdate = scanner.nextLine();
        System.out.println("Enter type: ");
        String typeUpdate = scanner.nextLine();
        System.out.println("Enter breed: ");
        String breedUpdate = scanner.nextLine();
        System.out.println("Enter color: ");
        String colorUpdate = scanner.nextLine();
        System.out.println("Enter owner id: ");
        Long ownerIdUpdate = scanner.nextLong();
        Pet updatePet = new Pet(nameUpdate, typeUpdate, breedUpdate, colorUpdate, ownerIdUpdate);
        System.out.println("Pet with id of: " + idUpdate + " updated");
        return petService.update(updatePet, idUpdate);
    }

    public List<Pet> list() {
        System.out.println("List Pets");
        List<Pet> result = petService.getAll();
        result.forEach(System.out::println);
        return result;
    }

    public Pet findById() {
        System.out.println("Find Pet");
        System.out.println("Enter id: ");
        Long idFind = scanner.nextLong();
        Pet result = petService.getById(idFind);
        System.out.println(result);
        return result;
    }

    public void delete() {
        System.out.println("Delete Pet");
        System.out.println("Enter id: ");
        Long idDelete = scanner.nextLong();
        petService.delete(idDelete);
        System.out.println("Pet with id of: " + idDelete + " deleted");
    }
}
