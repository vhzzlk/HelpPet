package com.senai.pet.repository;

import com.senai.pet.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository <Usuario, Long> {
    // buscar por email e top dms!
    Usuario findByEmail(String email);
}
