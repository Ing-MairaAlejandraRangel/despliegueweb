package com.jdc.tallerdespliegue.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "pagos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idpago;

    @Column(length = 100, nullable = false, unique = true)
    private String tipopago;
}
