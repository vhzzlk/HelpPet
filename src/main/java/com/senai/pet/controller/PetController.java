package com.senai.pet.controller;


import com.senai.pet.dto.RequestPetDTO;
import com.senai.pet.dto.ResponsePetDTO;
import com.senai.pet.entity.Pet;
import com.senai.pet.service.PetService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Pet")
public class PetController {

    private  PetService petService;

    public PetController(PetService petService) {this.petService = petService;}

    @PostMapping("/cadastrar")
    public ResponseEntity<ResponsePetDTO> cadastrar(@RequestBody @Valid RequestPetDTO dto){
        return ResponseEntity.ok(petService.cadastrar(dto));
    }

    @GetMapping("/listar")
    public ResponseEntity<?> listar(){
        return ResponseEntity.ok(petService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listarPorId(@PathVariable Long id){
        return ResponseEntity.ok(petService.ListarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarPorId(@PathVariable Long id){
        petService.deletar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> alterarPorId(@PathVariable  Long id, @RequestBody Pet pet){
        petService.atualizar(pet, id);
        return ResponseEntity.ok("Alterado com sucesso");
    }
}
