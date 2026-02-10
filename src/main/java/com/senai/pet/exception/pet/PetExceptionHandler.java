package com.senai.pet.exception.pet;

import com.senai.pet.dto.pet.ErrorPetDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class PetExceptionHandler {

    @ExceptionHandler({
            PetGetNotFoundException.class,
            PetUpdateNotFoundException.class,
            PetDeleteNotFoundException.class
    })
    public ResponseEntity<ErrorPetDTO> handlePetNotFoundException(RuntimeException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorPetDTO(e.getMessage(), 404, LocalDateTime.now()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorPetDTO> handleException(Exception e){
        return ResponseEntity.badRequest().body(new ErrorPetDTO(e.getMessage(),500,LocalDateTime.now()));
    }
}
