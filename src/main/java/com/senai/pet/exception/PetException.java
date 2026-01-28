package com.senai.pet.exception;

public class PetException extends RuntimeException {
    public PetException() {
        super("Nome duplicado. Tente novamente.");
    }
}
