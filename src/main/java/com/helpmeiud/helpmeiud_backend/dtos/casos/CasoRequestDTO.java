package com.helpmeiud.helpmeiud_backend.dtos.casos;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@Builder
public class CasoRequestDTO implements Serializable {

    static final long serialVersionUID = 1L;

    @JsonProperty("fecha_hora")
    LocalDateTime fechaHora; 

    Float latitud;

    Float longitud;

    Float altitud;

    String descripcion;

    @JsonProperty("url_map")
    String urlMap;

    @JsonProperty("rmi_url")
    String rmiUrl;

    @JsonProperty("delito_id")
    @NotNull(message = "delito Id requerido")
    Long delitoId;
}
