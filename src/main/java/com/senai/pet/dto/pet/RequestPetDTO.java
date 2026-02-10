package com.senai.pet.dto.pet;

import com.senai.pet.entity.Pet;
import com.senai.pet.enums.pet.Porte;
import com.senai.pet.enums.pet.Tipo;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestPetDTO {
    @NotBlank
    private String nome;

    private int idade;

    private String raca;

    private Porte porte;

    private Tipo tipo;

    public RequestPetDTO(Pet pet) {
        this.nome = pet.getNome();
        this.idade = pet.getIdade();
        this.raca = pet.getRaca();
        this.porte = pet.getPorte();
        this.tipo = pet.getTipo();
    }
}

