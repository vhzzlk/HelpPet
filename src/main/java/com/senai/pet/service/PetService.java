package com.senai.pet.service;

import com.senai.pet.dto.RequestPetDTO;
import com.senai.pet.dto.ResponsePetDTO;
import com.senai.pet.entity.Pet;
import com.senai.pet.exception.PetException;
import com.senai.pet.repository.PetRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetService {

    private PetRepository petRepository;

    public PetService(PetRepository petRepository){
        this.petRepository = petRepository;
    }

    public ResponsePetDTO cadastrar(RequestPetDTO dto){

        if (petRepository.findAll().stream()
                .anyMatch(p -> p.getNome() != null && p.getNome().equalsIgnoreCase(dto.getNome()))) {
            throw new PetException();
        }
        Pet pet = new Pet(dto.getNome(),dto.getIdade(),dto.getRaca(),dto.getTipo(),dto.getPorte());
        petRepository.save(pet);
        return new ResponsePetDTO(pet);
    }

    public List<Pet> listar(){
        return petRepository.findAll();
    }

    public Pet ListarPorId(Long id){
        Optional<Pet> optionalPet = petRepository.findById(id);
        return optionalPet.get();
    }

    public void deletar(Long id){
        petRepository.deleteById(id);
    }

    public Pet atualizar(Pet pet, Long id){
        pet.setId(id);
        return petRepository.save(pet);
    }


}
