package com.senai.pet.dto;

import com.senai.pet.entity.Pet;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponsePetDTO {
    @NotBlank
    private String nome;

    private int idade;



    public ResponsePetDTO(Pet pet) {
        this.nome = pet.getNome();
        this.idade = pet.getIdade();

    }
}

