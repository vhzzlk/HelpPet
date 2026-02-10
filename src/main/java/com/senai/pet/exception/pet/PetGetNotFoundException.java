package com.senai.pet.exception.pet;

public class PetGetNotFoundException extends RuntimeException {
    public PetGetNotFoundException(Long id) {
        super("Pet nao encontrado para o id: " + id);
    }
}
