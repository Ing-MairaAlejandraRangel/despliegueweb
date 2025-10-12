package com.jdc.tallerdespliegue.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "usuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idusuario;

    @Column(length = 10, nullable = false, unique = true)
    private String username;

    @Column(length = 10, nullable = false)
    private String password;

    @Column(nullable = false)
    private Boolean estado;
}
