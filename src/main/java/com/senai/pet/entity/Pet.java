package com.senai.pet.entity;

import com.senai.pet.enums.Porte;
import com.senai.pet.enums.Tipo;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name= "tb_pet")
public class Pet  {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    private String nome;
    private int idade;
    private String raca;
    private Porte porte;
    private Tipo tipo;

    public Pet( String nome, int idade, String raca,  Tipo tipo,  Porte porte) {
        this.nome = nome;
        this.idade = idade;
        this.raca = raca;
        this.tipo = tipo;
        this.porte = porte;
    }
}
