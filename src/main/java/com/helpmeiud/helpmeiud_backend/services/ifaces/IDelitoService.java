package com.helpmeiud.helpmeiud_backend.services.ifaces;

import com.helpmeiud.helpmeiud_backend.exceptions.RestException;
import com.helpmeiud.helpmeiud_backend.models.Delito;
import org.springframework.security.core.Authentication;

import java.util.List;

public interface IDelitoService { // Que voy a hacer

    // TODO: DELITOS A DTO

    Delito crearDelito(Delito delito, Authentication authentication) throws RestException;

    Delito actualizarDelitoPorID(Long id, Delito delito) throws RestException;

    void eliminarDelitoPorID(Long id) throws RestException;

    Delito consultarDelitoPorID(Long id) throws RestException;

    List<Delito> consultarDelitos() throws RestException;
}
