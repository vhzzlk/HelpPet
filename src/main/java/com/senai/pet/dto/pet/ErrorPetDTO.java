package com.senai.pet.dto.pet;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
public class ErrorPetDTO {

    private String mensagem;
    private int status;
    private LocalDateTime timestamp;


}
