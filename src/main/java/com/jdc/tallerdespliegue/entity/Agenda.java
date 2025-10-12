package com.jdc.tallerdespliegue.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "agendas")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@IdClass(AgendaId.class)
public class Agenda {

    @Id
    @ManyToOne
    @JoinColumn(name = "idcitas", nullable = false)
    private Cita cita;

    @Id
    @ManyToOne
    @JoinColumn(name = "idpacientes", nullable = false)
    private Paciente paciente;
}
