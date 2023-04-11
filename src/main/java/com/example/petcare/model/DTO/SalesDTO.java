package com.example.petcare.model.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
public class SalesDTO {
    private LocalDate date;
    private String petName;
    private String ownerName;
    private String petServiceName;
    private Long petServicePrice;

    @Override
    public String toString() {
        return '|' + "Transacation date: " + date +'|' +
                " Pet Name:'" + petName + '\'' +  '|' +
                " Owner Name:'" + ownerName + '\'' +'|' +
                " Service Name:'" + petServiceName + '\'' +'|' +
                " Price:'" + petServicePrice + '\''+ '|' ;
    }
}
