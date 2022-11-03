package com.example.PetStore.service.implement;

import com.example.PetStore.entity.PetEntity;
import com.example.PetStore.repository.PetRepository;
import com.example.PetStore.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PetServiceImpl implements PetService {
    @Autowired
    PetRepository petRepository;

    @Override
    public List<PetEntity> getAllPet() {
        List<PetEntity> petEntities = petRepository.findAll();
        return petEntities;
    }

    @Override
    public Optional<PetEntity> findByCategory(String category) {
        Optional<PetEntity> petEntity = petRepository.findByCategory(category);
        return petEntity;
    }

    @Override
    public Optional<PetEntity> findById(Long id) {
        Optional<PetEntity> petEntity = petRepository.findById(id);
        return petEntity;
    }

    @Override
    public void save(PetEntity petEntity) {
        petRepository.save(petEntity);
    }
}
