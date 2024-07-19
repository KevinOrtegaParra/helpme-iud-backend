/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.helpmeiud.helpmeiud_backend.models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "roles")

public class Role implements Serializable {

    static final long serialVersionUID = 1L;

    public Role() {
    }

    public Role(Long id) {
        this.id = id;
    }

    @Id
    @Setter(AccessLevel.NONE)
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(unique = true, length = 100)
    String nombre;

    @Column
    String descripcion;
}
