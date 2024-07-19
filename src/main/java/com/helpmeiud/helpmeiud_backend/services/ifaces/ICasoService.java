package com.helpmeiud.helpmeiud_backend.services.ifaces;

import com.helpmeiud.helpmeiud_backend.dtos.casos.CasoRequestDTO;
import com.helpmeiud.helpmeiud_backend.dtos.casos.CasoResponseDTO;
import com.helpmeiud.helpmeiud_backend.exceptions.RestException;
import org.springframework.security.core.Authentication;

import java.util.List;

public interface ICasoService {

    List<CasoResponseDTO> consultarCasos() throws RestException;

    List<CasoResponseDTO> consultarCasosVisibles() throws RestException;

    List<CasoResponseDTO> consultarCasosPorUsuario(String username) throws RestException;

    CasoResponseDTO consultarCasoPorId(Long id) throws RestException;

    CasoResponseDTO guardarCaso(CasoRequestDTO casoString, Authentication authentication) throws RestException;

    Boolean visibilizar(Boolean visible, Long id) throws RestException;
}
