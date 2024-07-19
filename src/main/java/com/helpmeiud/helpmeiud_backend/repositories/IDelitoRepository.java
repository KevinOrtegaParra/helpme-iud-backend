package com.helpmeiud.helpmeiud_backend.repositories;

import com.helpmeiud.helpmeiud_backend.models.Delito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDelitoRepository extends JpaRepository<Delito, Long> {
}
