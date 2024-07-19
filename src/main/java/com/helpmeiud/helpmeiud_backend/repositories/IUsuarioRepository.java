package com.helpmeiud.helpmeiud_backend.repositories;

import com.helpmeiud.helpmeiud_backend.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByUsername(String username);
}
