package com.senai.pet.entity;

import com.senai.pet.dto.usuario.RequestUsuarioDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "tb_usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Column(unique = true)
    private String email;
    private String senha;


    public Usuario(RequestUsuarioDTO dto) {
        nome = dto.getNome();
        email = dto.getEmail();
        senha = dto.getSenha();
    }


}
