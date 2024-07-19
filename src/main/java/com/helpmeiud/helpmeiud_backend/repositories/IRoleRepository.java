package com.helpmeiud.helpmeiud_backend.repositories;

import com.helpmeiud.helpmeiud_backend.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Long> {
}
