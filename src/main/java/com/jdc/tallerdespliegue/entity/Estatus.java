package com.jdc.tallerdespliegue.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "estatus")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Estatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idestatus;

    @Column(length = 200, nullable = false, unique = true)
    private String nombreestatus;
}
