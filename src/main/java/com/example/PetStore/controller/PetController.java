package com.example.PetStore.controller;

import com.example.PetStore.entity.PetEntity;
import com.example.PetStore.exception.PetNotFoundException;
import com.example.PetStore.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pet")
public class PetController {
    @Autowired
    PetService petService;

    @GetMapping("")
    public ResponseEntity<?> getListTaiKhoan() {
        List<PetEntity> petEntities = petService.getAllPet();
        return new ResponseEntity(petEntities, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getPetById(@PathVariable long id) {
        Optional<PetEntity> petEntity = petService.findById(id);
        if (petEntity.isEmpty()){
            throw new PetNotFoundException("petEntity: " + id);
        }
        return ResponseEntity.ok(petEntity);
    }

    @PostMapping("")
    public ResponseEntity<?> createPet(@Valid @RequestBody PetEntity petEntity) {
        petService.save(petEntity);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(petEntity.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/search")
    public ResponseEntity<?> getPetByCategory(@RequestParam(name = "category", required = false, defaultValue = "") String category) {
        Optional<PetEntity> petEntity = petService.findByCategory(category);
        return ResponseEntity.ok(petEntity);
    }
}
