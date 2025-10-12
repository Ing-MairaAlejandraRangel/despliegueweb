package com.jdc.tallerdespliegue.entity;

import lombok.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AgendaId implements Serializable {
    private Integer cita;     // id de cita
    private Integer paciente; // id de paciente
}
