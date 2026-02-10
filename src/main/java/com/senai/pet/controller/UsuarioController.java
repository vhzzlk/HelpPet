package com.senai.pet.controller;

import com.senai.pet.dto.usuario.RequestUsuarioDTO;
import com.senai.pet.dto.usuario.ResponseUsuarioDTO;
import com.senai.pet.entity.Usuario;
import com.senai.pet.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @PostMapping ("/cadastrar")
    public ResponseEntity <ResponseUsuarioDTO> cadastrar(@Valid @RequestBody RequestUsuarioDTO dto){
        return ResponseEntity.ok(usuarioService.cadastrar(dto));
    }

    @GetMapping ("/listar")
    public ResponseEntity <List<ResponseUsuarioDTO>> listarUsuarios(){
        return ResponseEntity.ok(usuarioService.listarUsuarios());
    }

    @GetMapping ("/listar/{id}")
    public ResponseEntity <ResponseUsuarioDTO> listarUsuarioPorId(@PathVariable Long id){
        return ResponseEntity.ok(usuarioService.listarUsuarioPorId(id));
    }

    @PutMapping ("/{id}")
    public ResponseEntity <?> atualizarUsuarioPorId(@PathVariable Long id, @RequestBody RequestUsuarioDTO dto){
        return ResponseEntity.ok(usuarioService.atualizarUsuarioPorId(dto, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarUsuarioPorId(@PathVariable Long id){
        usuarioService.deletarUsuarioPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body("Usuario apagado com sucesso!");
    }
}
