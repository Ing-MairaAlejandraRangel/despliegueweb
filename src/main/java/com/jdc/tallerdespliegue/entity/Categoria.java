package com.jdc.tallerdespliegue.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "categorias")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idcategoria;

    @Column(length = 50, nullable = false, unique = true)
    private String nombrecategoria;
}
