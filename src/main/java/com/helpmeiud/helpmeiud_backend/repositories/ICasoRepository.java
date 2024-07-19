package com.helpmeiud.helpmeiud_backend.repositories;


import com.helpmeiud.helpmeiud_backend.models.Caso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository 
public interface ICasoRepository extends JpaRepository<Caso, Long> {

    List<Caso> findAllByUsuarioUsername(String username);

    List<Caso> findAllByVisibleTrue();
}
