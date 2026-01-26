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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;
    private String nome;
    private int idade;
    private String raca;
    private Porte porte;
    private Tipo tipo;
}
