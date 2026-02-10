package com.senai.pet.dto.usuario;


import com.senai.pet.entity.Usuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestUsuarioDTO {

    //validação de campo na request é mais ou menos assim

    @NotBlank (message = "Este campo não deve estar vazio.")
    private String nome;

    @NotBlank (message = "Este campo não deve estar vazio.")
    private String email;

    @NotBlank (message = "Este campo não deve estar vazio.") @Size(min = 6, max = 18)
    private String senha;

    public RequestUsuarioDTO (Usuario usuario) {
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
        this.senha = usuario.getSenha();
    }
}
