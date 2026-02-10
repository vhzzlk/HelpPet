package com.senai.pet.service;

import com.senai.pet.dto.pet.RequestPetDTO;
import com.senai.pet.dto.pet.ResponsePetDTO;
import com.senai.pet.entity.Pet;
import com.senai.pet.exception.pet.PetDeleteNotFoundException;
import com.senai.pet.exception.pet.PetGetNotFoundException;
import com.senai.pet.exception.pet.PetUpdateNotFoundException;
import com.senai.pet.repository.PetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {

    private PetRepository petRepository;

    public PetService(PetRepository petRepository){
        this.petRepository = petRepository;
    }

    public ResponsePetDTO cadastrar(RequestPetDTO dto){

        Pet pet = new Pet(dto.getNome(),dto.getIdade(),dto.getRaca(),dto.getTipo(),dto.getPorte());
        petRepository.save(pet);
        return new ResponsePetDTO(pet);
    }

    public List<Pet> listar(){
        return petRepository.findAll();
    }

    public Pet ListarPorId(Long id){
        return petRepository.findById(id)
                .orElseThrow(() -> new PetGetNotFoundException(id));
    }

    public void deletar(Long id){
        if (!petRepository.existsById(id)) {
            throw new PetDeleteNotFoundException(id);
        }
        petRepository.deleteById(id);
    }

    public Pet atualizar(Pet pet, Long id){
        if (!petRepository.existsById(id)) {
            throw new PetUpdateNotFoundException(id);
        }
        pet.setId(id);
        return petRepository.save(pet);
    }


}
