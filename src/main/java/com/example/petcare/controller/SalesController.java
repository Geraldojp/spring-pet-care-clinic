package com.example.petcare.controller;

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
        System.out.println("Enter date: ");
        LocalDate dateSales = LocalDate.parse(scanner.nextLine());
        System.out.println("Enter pet id: ");
        Long petId = scanner.nextLong();
        System.out.println("Enter service id: ");
        Long serviceId = scanner.nextLong();
        System.out.println("Enter Owner id:");
        Long ownerId = scanner.nextLong();
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

    public List<Sales> getAll() {
        System.out.println("Get All-time Sales");
        List<Sales> result = salesService.getAll();
        result.forEach(System.out::println);
        return result;
    }

    public List<Sales> getDailySales() {
        System.out.println("Get Daily Sales");
        scanner.nextLine();
        System.out.println("Enter date(YYYY-MM-DD): ");
        LocalDate date = LocalDate.parse(scanner.nextLine());
        List<Sales> result = salesService.getDailySales(date);
        result.forEach(System.out::println);
        return result;
    }

    public List<Sales> getMonthlySales() {
        System.out.println("Get Monthly Sales");
        scanner.nextLine();
        System.out.println("Enter month(1-12): ");
        int month = scanner.nextInt();
        System.out.println("Enter year: ");
        int year = scanner.nextInt();
        List<Sales> result = salesService.getMonthlySales(month, year);
        result.forEach(System.out::println);
        return result;
    }

    public void delete() {
        System.out.println("Delete Sales");
        System.out.println("Enter id: ");
        Long idDelete = scanner.nextLong();
        salesService.delete(idDelete);
        System.out.println("Sales with id of: " + idDelete + " deleted");
    }
}
