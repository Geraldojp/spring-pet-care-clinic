package com.example.petcare.controller;

import com.example.petcare.model.DTO.SalesDTO;
import com.example.petcare.model.Sales;
import com.example.petcare.service.SalesService;
import com.example.petcare.service.SalesServiceInterface;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class SalesController{
    private SalesServiceInterface salesService;
    private Scanner scanner = new Scanner(System.in);
    public SalesController(SalesService salesService) {
        this.salesService = salesService;
    }

    public Sales create() {
        System.out.println("Create Sales");
        scanner.nextLine();
        System.out.println("Enter pet id: ");
        Long petId = scanner.nextLong();
        System.out.println("Enter service id: ");
        Long serviceId = scanner.nextLong();
        System.out.println("Enter Owner id:");
        Long ownerId = scanner.nextLong();
        LocalDate dateSales = LocalDate.now();
        Sales newSales = new Sales(dateSales, petId, serviceId, ownerId);
        System.out.println("Sales added");
        return salesService.create(newSales);
    }

    public Sales update() {
        System.out.println("Update Sales");
        scanner.nextLine();
        System.out.println("Enter id: ");
        Long id = scanner.nextLong();
        System.out.println("Enter date: ");
        LocalDate dateUpdate = LocalDate.parse(scanner.nextLine());
        System.out.println("Enter pet id: ");
        Long petIdUpdate = scanner.nextLong();
        System.out.println("Enter service id: ");
        Long serviceIdUpdate = scanner.nextLong();
        System.out.println("Enter Owner id:");
        Long ownerIdUpdate = scanner.nextLong();
        Sales updateSales = new Sales(dateUpdate, petIdUpdate, serviceIdUpdate, ownerIdUpdate);
        System.out.println("Sales with id of: " + id + " updated");
        return salesService.update(updateSales, id);

    }

    public List<SalesDTO> getAll() {
        while (true){
            try {
                System.out.println("Get All-time Sales");
                List<SalesDTO> result = salesService.getAll();
                if (result.isEmpty()) {
                    System.out.println("No sales yet");
                    break;
                }
                result.forEach(System.out::println);
                long allTimeSales = result.stream().map(SalesDTO::getPetServicePrice).reduce(0L, Long::sum);
                System.out.println("All-time Sales: " + allTimeSales);
                return result;
            } catch (Exception e) {
                System.out.println("No sales yet");
                break;
            }
        }
        return null;
    }

    public List<SalesDTO> getDailySales() {
        while (true){
            try {
                System.out.println("Get Daily Sales");
                System.out.println("Enter date(YYYY-MM-DD): ");
                String date = scanner.nextLine();
                if (date.isEmpty()) {
                    System.out.println("Date cannot be empty");
                    continue;
                }
                if (!date.matches("\\d{4}-\\d{2}-\\d{2}") || LocalDate.parse(date).isAfter(LocalDate.now())) {
                    System.out.println("date must be in format YYYY-MM-DD and must be before today");
                    continue;
                }
                List<SalesDTO> result = salesService.getDailySales(date);
                result.forEach(System.out::println);
                return result;
            } catch (Exception e) {
                System.out.println("No sales yet");
                break;
            }
        }
        return null;
    }

    public List<SalesDTO> getMonthlySales() {
        while (true){
            try {
                System.out.println("Get Monthly Sales");
                System.out.println("Enter month(1-12): ");
                int month = scanner.nextInt();
                if (month < 1 || month > 12) {
                    System.out.println("Invalid month");
                    continue;
                }
                System.out.println("Enter year: ");
                int year = scanner.nextInt();
                int currentYear = LocalDate.now().getYear();
                if (year < 0 || year > currentYear) {
                    System.out.println("Invalid year");
                    continue;
                }
                List<SalesDTO> result = salesService.getMonthlySales(month, year);
                result.forEach(System.out::println);
                long monthlySales = result.stream().map(SalesDTO::getPetServicePrice).reduce(0L, Long::sum);
                System.out.println("Monthly Sales: " + monthlySales);
                return result;
            } catch (Exception e) {
                System.out.println("No sales yet");
                break;
            }
        }
        return null;
    }

    public void delete() {
        while (true){
            try {
                System.out.println("Delete Sales");
                System.out.println("Enter id: ");
                Long idDelete = scanner.nextLong();
                if (idDelete < 0) {
                    System.out.println("Invalid id");
                    continue;
                }
                salesService.delete(idDelete);
                System.out.println("Sales with id of: " + idDelete + " deleted");
            } catch (Exception e) {
                System.out.println("No sales yet");
                break;
            }
        }
    }
}
