package com.senai.pet.service;

import com.senai.pet.dto.PetDTO;
import com.senai.pet.repository.PetRepository;
import org.springframework.stereotype.Service;

@Service
public class PetService {

    private PetRepository petRepository;

    public PetService(PetRepository petRepository){
        this.petRepository = petRepository;
    }

    public PetDTO mostrar(){
    }
}
