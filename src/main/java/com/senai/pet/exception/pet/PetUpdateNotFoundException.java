package com.senai.pet.exception.pet;

public class PetUpdateNotFoundException extends RuntimeException {
    public PetUpdateNotFoundException(Long id) {
        super("Pet nao encontrado para atualizar o id: " + id);
    }
}
