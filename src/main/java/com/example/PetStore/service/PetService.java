package com.example.PetStore.service;

import com.example.PetStore.entity.PetEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface PetService {
    public List<PetEntity> getAllPet();
    public Optional<PetEntity> findByCategory(String name);
    public Optional<PetEntity> findById(Long id);

    public void save(PetEntity petEntity);
}
