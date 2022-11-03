package com.example.PetStore.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pet")
public class PetEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Size(min=2, message = "Description should have atleast 2 characters")
    private String description;
    @Size(min=2, message = "Category should have atleast 2 characters")
    private String category;
    private String images;
    private boolean status;
    @Past(message = "Birth date should be in the past")
    private LocalDate birthDate;
}
