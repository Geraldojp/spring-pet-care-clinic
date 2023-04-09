package com.example.petcare.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Sales {
    private Long transactionId;
    private LocalDate transactionDate;
    private Long ownerId;
    private Long petId;
    private Long petClinicId;

    public Sales(LocalDate transactionDate,  Long petId, Long petClinicId, Long ownerId) {
        this.transactionDate = transactionDate;
        this.ownerId = ownerId;
        this.petId = petId;
        this.petClinicId = petClinicId;
    }
}
