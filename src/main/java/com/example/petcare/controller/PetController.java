package com.example.petcare.controller;

import com.example.petcare.model.DTO.PetDTO;
import com.example.petcare.model.Pet;
import com.example.petcare.service.PetServiceInterface;

import java.util.List;
import java.util.Scanner;

public class PetController {
    private PetServiceInterface petService;
    private Scanner scanner = new Scanner(System.in);

    public PetController(PetServiceInterface petService) {
        this.petService = petService;
    }

    public Pet create() {
        while (true) {
            try {
                System.out.println("Create Pet");
                System.out.println("Enter name: ");
                String name = scanner.nextLine();
                if (name.isEmpty()) {
                    System.out.println("Name cannot be empty");
                    continue;
                }
                System.out.println("Enter type: ");
                String type = scanner.nextLine();
                if (type.isEmpty()) {
                    System.out.println("Type cannot be empty");
                    continue;
                }
                if (!type.equals("dog") && !type.equals("cat")) {
                    System.out.println("Type must be dog or cat");
                    continue;
                }
                System.out.println("Enter breed: ");
                String breed = scanner.nextLine();
                if (breed.isEmpty()) {
                    System.out.println("Breed cannot be empty");
                    continue;
                }
                System.out.println("Enter color: ");
                String color = scanner.nextLine();
                if (color.isEmpty()) {
                    System.out.println("Color cannot be empty");
                    continue;
                }
                System.out.println("Enter owner id: ");
                Long ownerId = scanner.nextLong();
                if (ownerId <= 0) {
                    System.out.println("Owner id must be positive number");
                    continue;
                }
                Pet newPet = new Pet(name, type, breed, color, ownerId);
                System.out.println("Pet added");
                return petService.create(newPet);
            } catch (Exception e) {
                System.out.println("Something went wrong");
                break;
            }
        }
        return null;
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

    public List<PetDTO> list() {
        while (true) {
            try {
                System.out.println("List Pets");
                List<PetDTO> result = petService.getAll();
                if (result.isEmpty()) {
                    System.out.println("Database is empty");
                    break;
                }
                result.forEach(System.out::println);
                return result;
            }catch (Exception e){
                System.out.println("Something went wrong");
                break;
            }
        }
        return null;
    }

    public PetDTO findById() {
        while (true){
            try {
                System.out.println("Find Pet");
                System.out.println("Enter id: ");
                Long idFind = scanner.nextLong();
                if (idFind <= 0) {
                    System.out.println("Id must be positive number");
                    continue;
                }
                PetDTO result = petService.getById(idFind);
                if (result == null) {
                    System.out.println("Pet with id of: " + idFind + " not found");
                    continue;
                }
                System.out.println(result);
                return result;
            }catch (Exception e){
                System.out.println("Something went wrong");
                break;
            }
        }
        return null;
    }

    public void delete() {
        while (true){
            try {
                System.out.println("Delete Pet");
                System.out.println("Enter id: ");
                Long idDelete = scanner.nextLong();
                if (idDelete <= 0) {
                    System.out.println("Id must be positive number");
                    continue;
                }
                petService.delete(idDelete);
                System.out.println("Pet with id of: " + idDelete + " deleted");
            }catch (Exception e){
                System.out.println("Something went wrong");
                break;
            }
        }
    }
}
