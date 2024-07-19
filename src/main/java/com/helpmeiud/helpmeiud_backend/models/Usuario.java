/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.helpmeiud.helpmeiud_backend.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "usuarios")

public class Usuario implements Serializable {
    
    static final long serialVersionUID = 1L;
    
    @Id
    @Setter(AccessLevel.NONE)
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    
    @Column(unique = true,length = 120, updatable = false)
    String username;
    
    @Column(length = 120, nullable = false)
    String nombre;
    
    @Column(length = 120)
    String apellido;
    
    @Column
    String password;
    
    @Column(name = "fecha_nacimiento")
    LocalDate fechaNacimiento;
    
    @Column
    Boolean enabled;
    
    @Column(name = "red_social")
    Boolean redSocial;
    
    @Column
    String image;
    
    @ManyToMany(fetch = FetchType.EAGER)//LAZY)
    @JoinTable(
            name = "roles_usuarios", 
            joinColumns = {@JoinColumn(name = "usuarios_id")},
            inverseJoinColumns = {@JoinColumn(name = "roles_id")}
    )
    List<Role> roles;
}
