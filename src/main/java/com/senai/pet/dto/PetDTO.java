package com.senai.pet.dto;

import com.senai.pet.entity.Pet;
import com.senai.pet.enums.Porte;
import com.senai.pet.enums.Tipo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PetDTO {
    @NotBlank
    private String nome;

    private int idade;

    private String raca;

    @NotBlank
    private Porte porte;

    @NotBlank
    private Tipo tipo;

    public PetDTO(Pet pet) {
        this.nome = pet.getNome();
        this.idade = pet.getIdade();
        this.raca = pet.getRaca();
        this.porte = pet.getPorte();
        this.tipo = pet.getTipo();
    }
}

