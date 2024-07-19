/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.helpmeiud.helpmeiud_backend.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

/**
 *
 * @author kevin
 */
@Data
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "casos")

public class Caso implements Serializable{

    static final Long serialVersionUID = 1L;
    
    @Id
    @Setter(AccessLevel.NONE)
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    
    @Column(name = "fecha_hora")
    LocalDateTime fechaHora;
    
    @Column
    Float Latitud;
    
    @Column
    Float longitud;
    
    @Column
    Float altitud;
    
    @Column
    Boolean visible;
    
    @Column
    String descripcion;
    
    @Column(name = "url_map")
    String urlMap;
    
    @Column(name = "rmi_url")
    String rmiUrl;
    
    @ManyToOne
    @JoinColumn(name = "usuarios_id")
    Usuario usuario;
            
    @ManyToOne
    @JoinColumn(name = "delitos_id")
    Delito delito;
            
}
