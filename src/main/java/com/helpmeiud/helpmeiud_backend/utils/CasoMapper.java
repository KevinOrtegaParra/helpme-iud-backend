package com.helpmeiud.helpmeiud_backend.utils;

import com.helpmeiud.helpmeiud_backend.dtos.casos.CasoResponseDTO;
import com.helpmeiud.helpmeiud_backend.models.Caso;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

// TODO: MIGRAR A PUEDE SER: MAPSTRUCT, OBJECTMAPPER, ...
@Component
public class CasoMapper {


    public List<CasoResponseDTO> toCasoResponseDTOList(List<Caso> casos) {
        return casos.stream()
                .map(caso -> toCasoResponseDTO(caso))
                .collect(Collectors.toList());
    }

    public CasoResponseDTO toCasoResponseDTO(Caso caso) {
        return CasoResponseDTO.builder()
                .id(caso.getId())
                .fechaHora(caso.getFechaHora())
                .latitud(caso.getLatitud())
                .longitud(caso.getLongitud())
                .altitud(caso.getAltitud())
                .visible(caso.getVisible())
                .descripcion(caso.getDescripcion())
                .urlMap(caso.getUrlMap())
                .rmiUrl(caso.getRmiUrl())
                .username(caso.getUsuario().getUsername())
                .delitoId(caso.getDelito().getId())
                .build();
    }
}
