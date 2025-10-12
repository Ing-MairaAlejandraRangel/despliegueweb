package com.jdc.tallerdespliegue.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "medicos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idmedico;

    @Column(length = 50, nullable = false)
    private String nombres;

    @Column(length = 15)
    private String primerapellido;

    @Column(length = 15)
    private String segundoapellido;

    private Integer genero;

    @Column(length = 50)
    private String email;

    @Column(length = 15)
    private String telefono;

    @ManyToOne
    @JoinColumn(name = "idcategoria")
    private Categoria categoria;
}
