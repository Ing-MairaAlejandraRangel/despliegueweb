package com.jdc.tallerdespliegue.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "citas")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idcita;

    @Column(length = 50, nullable = false)
    private String titulo;

    @Column(length = 50)
    private String nota;

    @Column(name = "fecha_cita", nullable = false)
    private LocalDate fechaCita;

    @Column(length = 100)
    private String sintomas;

    @Column(length = 100)
    private String medicamentos;

    private Integer tipocita;

    private Boolean antecedentes;

    @ManyToOne
    @JoinColumn(name = "idmedico")
    private Medico medico;

    @ManyToOne
    @JoinColumn(name = "idpago")
    private Pago pago;

    @ManyToOne
    @JoinColumn(name = "idestatus")
    private Estatus estatus;
}
