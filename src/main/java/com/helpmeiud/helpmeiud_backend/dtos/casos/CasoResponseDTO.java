package com.helpmeiud.helpmeiud_backend.dtos.casos;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@Builder
public class CasoResponseDTO {

    Long id;

    LocalDateTime fechaHora;

    Float latitud;

    Float longitud;

    Float altitud;

    Boolean visible;

    String descripcion;

    String urlMap;

    String rmiUrl;

    String username;

    Long delitoId;
}
