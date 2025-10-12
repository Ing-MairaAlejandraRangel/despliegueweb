package com.jdc.tallerdespliegue.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "pacientes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idpaciente;

    @Column(length = 50, nullable = false)
    private String nombres;

    @Column(length = 15)
    private String primerapellido;

    @Column(length = 15)
    private String segundoapellido;

    @Column(length = 20)
    private String documento;

    private LocalDate fechanacimiento;

    @Column(length = 100)
    private String medicamentos;

    @Column(length = 100)
    private String alergias;

    @ManyToOne
    @JoinColumn(name = "idusuario")
    private Usuario usuario;
}
