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
    private String email;// ta funcionando caue viadinho
    //caue , preciso saber se e correto colocar anotation tipo @not null e @email pra email! caue -> VALIDATION (anotações como essas que você citou) SEMPRE NA DTO REQUEST!!!
    // caue-> anotation @email pra email eu nunca vi, eu acho que nem existe. @NotNull pode ser usado em qualquer tipo de atributo e pode ser estar vazia, só não pode deixar de existir. ex: String mensagem = " ". VVV correto!!! pode
    // caue-> você pode usar notnull e notblank, a diferenca é que notnull pode ser usado em qualquer atributo e notblank pode ser usado só em string e não pode estar vazia. ex: String mensagem = " "  XXX errado!!! não pode

    // preciso saber tb,coisas do tipo, deleteri o id 2 e 5, e agr ja ta criando o 6 , nn lista o id 2, nem o 5 q deu erro!!!!!!!
// e o delete nao ta deletando, eu vou sair pra me arrumar pra ir pra escola , arruma isso ai pfv!!!
    //caue-> acredito que o delete esta deletando, faz o teste depois. nao consigo acessar esse banco na maquina da empresa
    // vc subiu pro github?



    public ResponseUsuarioDTO(Usuario usuario) {
        nome = usuario.getNome();
        email = usuario.getEmail();
    }
}
