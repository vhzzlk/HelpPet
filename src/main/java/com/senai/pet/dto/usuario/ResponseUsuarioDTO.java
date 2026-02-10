package com.senai.pet.dto.usuario;


import com.senai.pet.entity.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseUsuarioDTO {


    private String nome;
    private String email;

    public ResponseUsuarioDTO(Usuario usuario) {
        nome = usuario.getNome();
        email = usuario.getEmail();
    }
}
