package com.senai.pet.service;

import com.senai.pet.dto.usuario.RequestUsuarioDTO;
import com.senai.pet.dto.usuario.ResponseUsuarioDTO;
import com.senai.pet.entity.Usuario;
import com.senai.pet.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;
    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }
    // tem q fazer a validacao aq? Path variable e valid? nao precisa, so na controlelr
    // fiz construtor la mano!!!
    public ResponseUsuarioDTO cadastrar (RequestUsuarioDTO dto){
        Usuario usuario = new Usuario(dto);
        usuarioRepository.save(usuario);
        return new ResponseUsuarioDTO(usuario);
    }

    public List<ResponseUsuarioDTO> listarUsuarios(){
        return usuarioRepository.findAll().stream().map(ResponseUsuarioDTO::new).toList();
    }

    public ResponseUsuarioDTO listarUsuarioPorId(Long id){
        return new ResponseUsuarioDTO(
                usuarioRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Usuário não encontrado"))
        );
    }// e q no meu tava usuario usuaro da certo, mas não pode pq entity é dado sensivel, usuario não pode ter acesso
    //entity é banco
    //olha ai ze , nn sei como faz eu faco

    public ResponseUsuarioDTO atualizarUsuarioPorId(RequestUsuarioDTO dto, Long id){
        if (!usuarioRepository.existsById(id)) {
            throw new RuntimeException("Usuário não encontrado");
        }
        //pq so o Nome nn passou no lombok? pera ai, vou ter que fazer uma coisa aqui no meui trabalho, 15 min
        // ve meu github
        // descobri
        Usuario usuario = new Usuario(dto);
        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        usuario.setSenha(dto.getSenha());
        usuarioRepository.save(usuario);
        return new ResponseUsuarioDTO(usuario);
    }

    public void deletarUsuarioPorId(Long id){
        if (!usuarioRepository.existsById(id)) {
            throw new RuntimeException("Usuário não encontrado");
        }
        usuarioRepository.deleteById(id);

    }

}
