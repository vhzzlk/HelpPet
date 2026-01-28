package com.senai.pet.exception;

import com.senai.pet.dto.ErrorPetDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class PetExceptionHandler {

    @ExceptionHandler(PetException.class)
    public ResponseEntity<ErrorPetDTO> handlePetException(PetException e){
        return ResponseEntity.badRequest().body(new ErrorPetDTO(e.getMessage(),400,LocalDateTime.now()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorPetDTO> handleException(Exception e){
        return ResponseEntity.badRequest().body(new ErrorPetDTO(e.getMessage(),500,LocalDateTime.now()));
    }
}
