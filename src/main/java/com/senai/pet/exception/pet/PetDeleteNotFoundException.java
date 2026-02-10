package com.senai.pet.exception.pet;

public class PetDeleteNotFoundException extends RuntimeException {
    public PetDeleteNotFoundException(Long id) {
        super("Pet nao encontrado para excluir o id: " + id);
    }
}
